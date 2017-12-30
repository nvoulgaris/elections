package com.nvoulgaris.elections;

import com.nvoulgaris.elections.formatters.HeatMapFormatter;
import com.nvoulgaris.elections.observers.HeatMap;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class HeatMapShould {

  @Mock Console console;
  @Mock ElectionResults results;
  @Mock HeatMapFormatter resultsFormatter;

  private HeatMap heatMap;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
    heatMap = new HeatMap(console, resultsFormatter);
  }

  @Test
  public void displayFreshResultsWhenUpdated() throws Exception {
    when(resultsFormatter.format(results)).thenReturn(Constants.HEAT_MAP_FORMATTED_RESULTS);
    heatMap.update(results);

    verify(console).printLine(Constants.HEAT_MAP_FORMATTED_RESULTS);
  }
}
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

  @Mock ResultsPrinter resultsPrinter;
  @Mock ElectionResults results;
  @Mock HeatMapFormatter resultsFormatter;

  private HeatMap heatMap;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
    heatMap = new HeatMap(resultsPrinter, resultsFormatter);
  }

  @Test
  public void displayFreshResultsWhenUpdated() throws Exception {
    when(resultsFormatter.format(results)).thenReturn(Constants.HEAT_MAP_FORMATTED_RESULTS);
    heatMap.update(results);

    verify(resultsPrinter).print(Constants.HEAT_MAP_FORMATTED_RESULTS);
  }
}
package com.nvoulgaris.elections;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class HeatMapShould {

  @Mock Console console;
  @Mock ElectionResults results;
  @Mock ResultsFormatter resultsFormatter;

  private HeatMap heatMap;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
    heatMap = new HeatMap(console, resultsFormatter);
  }

  @Test
  public void displayFreshResultsWhenUpdated() throws Exception {
    when(resultsFormatter.formatForHeatMap(results)).thenReturn(Constants.HEAT_MAP_FORMATTED_RESULTS);
    heatMap.update(results);

    verify(console).printLine(Constants.HEAT_MAP_FORMATTED_RESULTS);
  }
}
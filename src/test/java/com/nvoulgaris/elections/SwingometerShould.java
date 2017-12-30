package com.nvoulgaris.elections;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class SwingometerShould {

  @Mock Console console;
  @Mock ElectionResults results;
  @Mock ResultsFormatter resultsFormatter;

  private Swingometer swingometer;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
    swingometer = new Swingometer(console, resultsFormatter);
  }

  @Test
  public void displayFreshResultsWhenUpdated() throws Exception {
    when(resultsFormatter.formatForSwingometer(results)).thenReturn(Constants.SWINGOMETER_FORMATTED_RESULTS);
    swingometer.update(results);

    verify(console).printLine(Constants.SWINGOMETER_FORMATTED_RESULTS);
  }
}
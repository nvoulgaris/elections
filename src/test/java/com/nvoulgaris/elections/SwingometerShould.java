package com.nvoulgaris.elections;

import com.nvoulgaris.elections.formatters.SwingometerFormatter;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class SwingometerShould {

  @Mock Console console;
  @Mock ElectionResults results;
  @Mock SwingometerFormatter resultsFormatter;

  private Swingometer swingometer;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
    swingometer = new Swingometer(console, resultsFormatter);
  }

  @Test
  public void displayFreshResultsWhenUpdated() throws Exception {
    when(resultsFormatter.format(results)).thenReturn(Constants.SWINGOMETER_FORMATTED_RESULTS);
    swingometer.update(results);

    verify(console).printLine(Constants.SWINGOMETER_FORMATTED_RESULTS);
  }
}
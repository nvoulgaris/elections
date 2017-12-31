package com.nvoulgaris.elections;

import com.nvoulgaris.elections.formatters.SwingometerFormatter;
import com.nvoulgaris.elections.observables.ElectionData;
import com.nvoulgaris.elections.observers.Swingometer;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class SwingometerShould {

  @Mock ElectionData electionData;
  @Mock ResultsPrinter resultsPrinter;
  @Mock ElectionResults results;
  @Mock SwingometerFormatter resultsFormatter;

  private Swingometer swingometer;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
    swingometer = new Swingometer(resultsPrinter, resultsFormatter);
  }

  @Test
  public void displayFreshResultsWhenUpdated() throws Exception {
    when(electionData.getResults()).thenReturn(results);
    when(resultsFormatter.format(results)).thenReturn(Constants.SWINGOMETER_FORMATTED_RESULTS);
    swingometer.update(electionData);

    verify(resultsPrinter).print(Constants.SWINGOMETER_FORMATTED_RESULTS);
  }
}
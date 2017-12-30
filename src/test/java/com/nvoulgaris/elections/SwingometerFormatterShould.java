package com.nvoulgaris.elections;

import com.nvoulgaris.elections.formatters.SwingometerFormatter;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SwingometerFormatterShould {

  private SwingometerFormatter swingometerFormatter;
  private ElectionResults results;

  @Before
  public void setUp() throws Exception {
    swingometerFormatter = new SwingometerFormatter();
    results = new ElectionResults();
  }

  @Test
  public void formatResults() throws Exception {
    String formattedResults = swingometerFormatter.format(results);

    assertThat(formattedResults).isEqualTo(Constants.SWINGOMETER_FORMATTED_RESULTS);
  }
}
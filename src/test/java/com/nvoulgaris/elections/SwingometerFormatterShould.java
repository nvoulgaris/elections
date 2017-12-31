package com.nvoulgaris.elections;

import com.nvoulgaris.elections.formatters.SwingometerFormatter;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class SwingometerFormatterShould {

  private static final String BLUE_SCORE = "40";
  private static final String ORANGE_SCORE = "60";

  @Mock ElectionResults results;

  private SwingometerFormatter swingometerFormatter;
  private String swingometerFormattedResults;

  private void prepareMocksBehavior() {
    when(results.getBlueVotes()).thenReturn(40);
    when(results.getOrangeVotes()).thenReturn(60);
  }

  private void prepareExpectedResults() {
    swingometerFormattedResults = new StringBuilder()
        .append(Constants.SWINGOMETER_FORMATTED_RESULTS)
        .append(Constants.BLUE_SCORE_TAG)
        .append(BLUE_SCORE)
        .append(Constants.SWINGOMETER_DELIMITER)
        .append(Constants.ORANGE_SCORE_TAG)
        .append(ORANGE_SCORE)
        .toString();
  }

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
    swingometerFormatter = new SwingometerFormatter();
    prepareMocksBehavior();
    prepareExpectedResults();
  }

  @Test
  public void formatResults() throws Exception {
    String formattedResults = swingometerFormatter.format(results);

    assertThat(formattedResults).isEqualTo(swingometerFormattedResults);
  }
}
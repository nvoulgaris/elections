package com.nvoulgaris.elections;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultsFormatterShould {

  private ElectionResults results;
  private ResultsFormatter resultsFormatter;

  @Before
  public void setUp() throws Exception {
    resultsFormatter = new ResultsFormatter();
    results = new ElectionResults();
  }

  @Test
  public void formatResultsForTheLeaderBoard() throws Exception {
    String formattedResults = resultsFormatter.formatForLeaderBoard(results);

    assertThat(formattedResults).isEqualTo(Constants.LEADER_BOARD_FORMATTED_RESULTS);
  }

  @Test
  public void formatResultsForTheHeatMap() throws Exception {
    String formattedResults = resultsFormatter.formatForHeatMap(results);

    assertThat(formattedResults).isEqualTo(Constants.HEAT_MAP_FORMATTED_RESULTS);
  }

  @Test
  public void formatResultsForSwingometer() throws Exception {
    String formattedResults = resultsFormatter.formatForSwingometer(results);

    assertThat(formattedResults).isEqualTo(Constants.SWINGOMETER_FORMATTED_RESULTS);
  }
}
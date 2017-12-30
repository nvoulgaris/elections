package com.nvoulgaris.elections;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultsFormatterShould {

  private ElectionResults electionResults;
  private ResultsFormatter resultsFormatter;

  @Before
  public void setUp() throws Exception {
    resultsFormatter = new ResultsFormatter();
    electionResults = new ElectionResults();
  }

  @Test
  public void formatResultsForTheLeaderBoard() throws Exception {
    String results = resultsFormatter.formatForLeaderBoard(electionResults);

    assertThat(results).isEqualTo(Constants.LEADER_BOARD_FORMATTED_RESULTS);
  }

  @Test
  public void formatResultsForTheHeatMap() throws Exception {
    String results = resultsFormatter.formatForHeatMap(electionResults);

    assertThat(results).isEqualTo(Constants.HEAT_MAP_FORMATTED_RESULTS);
  }
}
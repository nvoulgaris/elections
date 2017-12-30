package com.nvoulgaris.elections;

import com.nvoulgaris.elections.formatters.LeaderBoardFormatter;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LeaderBoardFormatterShould {

  private LeaderBoardFormatter leaderBoardFormatter;
  private ElectionResults results;

  @Before
  public void setUp() throws Exception {
    leaderBoardFormatter = new LeaderBoardFormatter();
    results = new ElectionResults();
  }

  @Test
  public void formatResults() throws Exception {
    String formattedResults = leaderBoardFormatter.format(results);

    assertThat(formattedResults).isEqualTo(Constants.LEADER_BOARD_FORMATTED_RESULTS);
  }
}
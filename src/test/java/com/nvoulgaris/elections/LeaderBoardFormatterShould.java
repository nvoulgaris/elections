package com.nvoulgaris.elections;

import com.nvoulgaris.elections.formatters.LeaderBoardFormatter;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class LeaderBoardFormatterShould {

  private static final String BLUE_SCORE = "40";
  private static final String ORANGE_SCORE = "60";

  @Mock ElectionResults results;

  private LeaderBoardFormatter leaderBoardFormatter;
  private String leaderBoardFormattedResults;

  private void prepareMocksBehavior() {
    when(results.getBlueVotes()).thenReturn(40);
    when(results.getOrangeVotes()).thenReturn(60);
  }

  private void prepareExpectedResults() {
    leaderBoardFormattedResults = new StringBuilder()
        .append(Constants.LEADER_BOARD_FORMATTED_RESULTS)
        .append(Constants.BLUE_SCORE_TAG)
        .append(BLUE_SCORE)
        .append(Constants.LEADER_BOARD_DELIMITER)
        .append(Constants.ORANGE_SCORE_TAG)
        .append(ORANGE_SCORE)
        .toString();
  }

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
    leaderBoardFormatter = new LeaderBoardFormatter();
    prepareMocksBehavior();
    prepareExpectedResults();
  }

  @Test
  public void formatResults() throws Exception {
    String formattedResults = leaderBoardFormatter.format(results);

    assertThat(formattedResults).isEqualTo(leaderBoardFormattedResults);
  }
}
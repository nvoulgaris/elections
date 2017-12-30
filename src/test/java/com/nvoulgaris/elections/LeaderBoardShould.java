package com.nvoulgaris.elections;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class LeaderBoardShould {

  private static final String LEADER_BOARD_FORMATTED_RESULTS = "Leader board updated";

  @Mock Console console;
  @Mock ResultsFormatter resultsFormatter;
  @Mock ElectionResults results;

  private LeaderBoard leaderBoard;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
    leaderBoard = new LeaderBoard(resultsFormatter, console);
  }

  @Test
  public void displayFreshResultsWhenUpdated() throws Exception {
    when(resultsFormatter.formatForLeaderBoard(results)).thenReturn(LEADER_BOARD_FORMATTED_RESULTS);

    leaderBoard.update(results);

    verify(console).printLine(LEADER_BOARD_FORMATTED_RESULTS);
  }
}
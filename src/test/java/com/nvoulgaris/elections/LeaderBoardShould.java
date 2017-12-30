package com.nvoulgaris.elections;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class LeaderBoardShould {

  @Mock Console console;
  @Mock ResultsFormatter resultsFormatter;
  @Mock ElectionResults results;

  private LeaderBoard leaderBoard;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
    leaderBoard = new LeaderBoard(console, resultsFormatter);
  }

  @Test
  public void displayFreshResultsWhenUpdated() throws Exception {
    when(resultsFormatter.formatForLeaderBoard(results)).thenReturn(Constants.LEADER_BOARD_FORMATTED_RESULTS);

    leaderBoard.update(results);

    verify(console).printLine(Constants.LEADER_BOARD_FORMATTED_RESULTS);
  }
}
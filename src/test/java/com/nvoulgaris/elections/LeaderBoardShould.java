package com.nvoulgaris.elections;

import com.nvoulgaris.elections.formatters.LeaderBoardFormatter;
import com.nvoulgaris.elections.observables.ElectionData;
import com.nvoulgaris.elections.observers.LeaderBoard;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class LeaderBoardShould {

  @Mock ElectionData electionData;
  @Mock ResultsPrinter resultsPrinter;
  @Mock LeaderBoardFormatter resultsFormatter;
  @Mock ElectionResults results;

  private LeaderBoard leaderBoard;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
    leaderBoard = new LeaderBoard(resultsPrinter, resultsFormatter);
  }

  @Test
  public void displayFreshResultsWhenUpdated() throws Exception {
    when(electionData.getResults()).thenReturn(results);
    when(resultsFormatter.format(results)).thenReturn(Constants.LEADER_BOARD_FORMATTED_RESULTS);

    leaderBoard.update(electionData);

    verify(resultsPrinter).print(Constants.LEADER_BOARD_FORMATTED_RESULTS);
  }
}
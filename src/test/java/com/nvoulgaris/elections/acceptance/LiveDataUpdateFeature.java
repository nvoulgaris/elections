package com.nvoulgaris.elections.acceptance;

import com.nvoulgaris.elections.Console;
import com.nvoulgaris.elections.ElectionData;
import com.nvoulgaris.elections.ElectionResults;
import com.nvoulgaris.elections.LeaderBoard;
import com.nvoulgaris.elections.ResultsFormatter;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class LiveDataUpdateFeature {

  @Mock Console console;

  private ResultsFormatter resultsFormatter;

  private ElectionData electionData;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
    electionData = new ElectionData();
    resultsFormatter = new ResultsFormatter();
  }

  @Test
  public void updateDisplays() throws Exception {
    LeaderBoard leaderBoard = new LeaderBoard(resultsFormatter, console);
    electionData.registerObserver(leaderBoard);

    electionData.resultsChanged(new ElectionResults());

    InOrder inOrder = Mockito.inOrder(console);
    inOrder.verify(console).printLine("Leader board updated");
    inOrder.verify(console).printLine("Map updated");
    inOrder.verify(console).printLine("Swingometer updated");
  }
}

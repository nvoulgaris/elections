package com.nvoulgaris.elections.acceptance;

import com.nvoulgaris.elections.Console;
import com.nvoulgaris.elections.Constants;
import com.nvoulgaris.elections.ResultsPrinter;
import com.nvoulgaris.elections.observables.ElectionData;
import com.nvoulgaris.elections.ElectionResults;
import com.nvoulgaris.elections.observers.HeatMap;
import com.nvoulgaris.elections.formatters.HeatMapFormatter;
import com.nvoulgaris.elections.observers.LeaderBoard;
import com.nvoulgaris.elections.formatters.LeaderBoardFormatter;
import com.nvoulgaris.elections.observers.Swingometer;
import com.nvoulgaris.elections.formatters.SwingometerFormatter;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class LiveDataDisplayFeature {

  @Mock Console console;

  private ResultsPrinter resultsPrinter;
  private LeaderBoardFormatter leaderBoardFormatter;
  private HeatMapFormatter heatMapFormatter;
  private SwingometerFormatter swingometerFormatter;
  private LeaderBoard leaderBoard;
  private HeatMap heatMap;
  private Swingometer swingometer;
  private ElectionData electionData;

  private void initializeObjects() {
    electionData = new ElectionData();
    leaderBoardFormatter = new LeaderBoardFormatter();
    heatMapFormatter = new HeatMapFormatter();
    swingometerFormatter = new SwingometerFormatter();
    resultsPrinter = new ResultsPrinter(console);
    leaderBoard = new LeaderBoard(resultsPrinter, leaderBoardFormatter);
    heatMap = new HeatMap(resultsPrinter, heatMapFormatter);
    swingometer = new Swingometer(resultsPrinter, swingometerFormatter);
  }

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
    initializeObjects();
  }

  @Test
  public void shouldUpdateAllDisplaysWhenDataAreUpdated() throws Exception {
    electionData.register(leaderBoard);
    electionData.register(heatMap);
    electionData.register(swingometer);

    electionData.resultsChanged(new ElectionResults());

    InOrder inOrder = Mockito.inOrder(console);
    inOrder.verify(console).printLine(Constants.LEADER_BOARD_FORMATTED_RESULTS);
    inOrder.verify(console).printLine(Constants.HEAT_MAP_FORMATTED_RESULTS);
    inOrder.verify(console).printLine(Constants.SWINGOMETER_FORMATTED_RESULTS);
  }
}

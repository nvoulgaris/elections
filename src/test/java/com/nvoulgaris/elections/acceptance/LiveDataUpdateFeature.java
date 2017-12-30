package com.nvoulgaris.elections.acceptance;

import com.nvoulgaris.elections.Console;
import com.nvoulgaris.elections.Constants;
import com.nvoulgaris.elections.ElectionData;
import com.nvoulgaris.elections.ElectionResults;
import com.nvoulgaris.elections.HeatMap;
import com.nvoulgaris.elections.formatters.HeatMapFormatter;
import com.nvoulgaris.elections.LeaderBoard;
import com.nvoulgaris.elections.formatters.LeaderBoardFormatter;
import com.nvoulgaris.elections.Swingometer;
import com.nvoulgaris.elections.formatters.SwingometerFormatter;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class LiveDataUpdateFeature {

  @Mock Console console;

  private LeaderBoardFormatter leaderBoardFormatter;
  private HeatMapFormatter heatMapFormatter;
  private SwingometerFormatter swingometerFormatter;
  private LeaderBoard leaderBoard;
  private HeatMap heatMap;
  private Swingometer swingometer;
  private ElectionData electionData;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
    electionData = new ElectionData();
    leaderBoardFormatter = new LeaderBoardFormatter();
    heatMapFormatter = new HeatMapFormatter();
    swingometerFormatter = new SwingometerFormatter();
    leaderBoard = new LeaderBoard(console, leaderBoardFormatter);
    heatMap = new HeatMap(console, heatMapFormatter);
    swingometer = new Swingometer(console, swingometerFormatter);
  }

  @Test
  public void updateDisplays() throws Exception {
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

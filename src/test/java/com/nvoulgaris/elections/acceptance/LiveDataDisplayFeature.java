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

  private static final String LEADER_BOARD_SCORE = Constants.LEADER_BOARD_FORMATTED_RESULTS + Constants.BLUE_SCORE_TAG + "40" + Constants.LEADER_BOARD_DELIMITER + Constants.ORANGE_SCORE_TAG + "60";
  private static final String HEAT_MAP_SCORE = Constants.HEAT_MAP_FORMATTED_RESULTS + Constants.BLUE_SCORE_TAG + "40" + Constants.HEAT_MAP_DELIMITER + Constants.ORANGE_SCORE_TAG + "60";
  private static final String SWINGOMETER_SCORE = Constants.SWINGOMETER_FORMATTED_RESULTS + Constants.BLUE_SCORE_TAG + "40" + Constants.SWINGOMETER_DELIMITER + Constants.ORANGE_SCORE_TAG + "60";

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

    ElectionResults results = new ElectionResults();
    results.setBlueVotes(40);
    results.setOrangeVotes(60);
    electionData.resultsChanged(results);

    InOrder inOrder = Mockito.inOrder(console);
    inOrder.verify(console).printLine(LEADER_BOARD_SCORE);
    inOrder.verify(console).printLine(HEAT_MAP_SCORE);
    inOrder.verify(console).printLine(SWINGOMETER_SCORE);
  }
}

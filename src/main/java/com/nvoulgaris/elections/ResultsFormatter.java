package com.nvoulgaris.elections;

public class ResultsFormatter {

  public String formatForLeaderBoard(ElectionResults results) {
    return Constants.LEADER_BOARD_FORMATTED_RESULTS;
  }

  public String formatForHeatMap(ElectionResults results) {
    return Constants.HEAT_MAP_FORMATTED_RESULTS;
  }
}

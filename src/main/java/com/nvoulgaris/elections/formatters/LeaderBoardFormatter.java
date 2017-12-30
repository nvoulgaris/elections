package com.nvoulgaris.elections.formatters;

import com.nvoulgaris.elections.Constants;
import com.nvoulgaris.elections.ElectionResults;

public class LeaderBoardFormatter implements ResultsFormatter {

  @Override
  public String format(ElectionResults results) {
    return Constants.LEADER_BOARD_FORMATTED_RESULTS;
  }
}

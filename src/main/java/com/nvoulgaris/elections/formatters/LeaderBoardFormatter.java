package com.nvoulgaris.elections.formatters;

import com.nvoulgaris.elections.Constants;
import com.nvoulgaris.elections.ElectionResults;

public class LeaderBoardFormatter implements ResultsFormatter {

  @Override
  public String format(ElectionResults results) {
    return new StringBuilder()
        .append(Constants.LEADER_BOARD_FORMATTED_RESULTS)
        .append(Constants.BLUE_SCORE_TAG)
        .append(results.getBlueVotes())
        .append(Constants.LEADER_BOARD_DELIMITER)
        .append(Constants.ORANGE_SCORE_TAG)
        .append(results.getOrangeVotes())
        .toString();
  }
}

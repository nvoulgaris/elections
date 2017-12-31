package com.nvoulgaris.elections.formatters;

import com.nvoulgaris.elections.Constants;
import com.nvoulgaris.elections.ElectionResults;

public class HeatMapFormatter implements ResultsFormatter {

  @Override
  public String format(ElectionResults results) {
    return new StringBuilder()
        .append(Constants.HEAT_MAP_FORMATTED_RESULTS)
        .append(Constants.BLUE_SCORE_TAG)
        .append(results.getBlueVotes())
        .append(Constants.HEAT_MAP_DELIMITER)
        .append(Constants.ORANGE_SCORE_TAG)
        .append(results.getOrangeVotes())
        .toString();
  }
}

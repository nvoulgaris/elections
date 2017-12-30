package com.nvoulgaris.elections.formatters;

import com.nvoulgaris.elections.Constants;
import com.nvoulgaris.elections.ElectionResults;

public class HeatMapFormatter implements ResultsFormatter {

  @Override
  public String format(ElectionResults results) {
    return Constants.HEAT_MAP_FORMATTED_RESULTS;
  }
}

package com.nvoulgaris.elections.formatters;

import com.nvoulgaris.elections.Constants;
import com.nvoulgaris.elections.ElectionResults;

public class SwingometerFormatter implements ResultsFormatter {

  @Override
  public String format(ElectionResults results) {
    return Constants.SWINGOMETER_FORMATTED_RESULTS;
  }
}

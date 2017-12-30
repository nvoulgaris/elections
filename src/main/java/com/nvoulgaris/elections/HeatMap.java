package com.nvoulgaris.elections;

import com.nvoulgaris.elections.formatters.HeatMapFormatter;

public class HeatMap extends Display implements ElectionObserver {

  public HeatMap(Console console, HeatMapFormatter resultsFormatter) {
    super(console, resultsFormatter);
  }

  @Override
  public void update(ElectionResults results) {
    printResults(results);
  }
}

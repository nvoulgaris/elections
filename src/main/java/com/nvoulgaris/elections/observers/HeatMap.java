package com.nvoulgaris.elections.observers;

import com.nvoulgaris.elections.Console;
import com.nvoulgaris.elections.ElectionResults;
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

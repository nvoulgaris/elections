package com.nvoulgaris.elections.observers;

import com.nvoulgaris.elections.ElectionResults;
import com.nvoulgaris.elections.ResultsPrinter;
import com.nvoulgaris.elections.formatters.HeatMapFormatter;

public class HeatMap extends Display implements ElectionObserver {

  public HeatMap(ResultsPrinter resultsPrinter, HeatMapFormatter resultsFormatter) {
    super(resultsPrinter, resultsFormatter);
  }

  @Override
  public void update(ElectionResults results) {
    display(results);
  }
}

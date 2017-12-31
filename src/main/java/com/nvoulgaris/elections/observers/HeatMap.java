package com.nvoulgaris.elections.observers;

import com.nvoulgaris.elections.ResultsPrinter;
import com.nvoulgaris.elections.formatters.HeatMapFormatter;
import com.nvoulgaris.elections.observables.ElectionData;

public class HeatMap extends ElectionDisplay implements ElectionObserver {

  public HeatMap(ResultsPrinter resultsPrinter, HeatMapFormatter resultsFormatter) {
    super(resultsPrinter, resultsFormatter);
  }

  @Override
  public void update(ElectionData data) {
    display(data);
  }
}

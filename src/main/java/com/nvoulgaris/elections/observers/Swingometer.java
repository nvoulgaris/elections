package com.nvoulgaris.elections.observers;

import com.nvoulgaris.elections.ResultsPrinter;
import com.nvoulgaris.elections.formatters.SwingometerFormatter;
import com.nvoulgaris.elections.observables.ElectionData;

public class Swingometer extends ElectionDisplay implements ElectionObserver {

  public Swingometer(ResultsPrinter resultsPrinter, SwingometerFormatter resultsFormatter) {
    super(resultsPrinter, resultsFormatter);
  }

  @Override
  public void update(ElectionData data) {
    display(data);
  }
}

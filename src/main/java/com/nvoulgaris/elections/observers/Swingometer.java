package com.nvoulgaris.elections.observers;

import com.nvoulgaris.elections.ElectionResults;
import com.nvoulgaris.elections.ResultsPrinter;
import com.nvoulgaris.elections.formatters.SwingometerFormatter;

public class Swingometer extends Display implements ElectionObserver {

  public Swingometer(ResultsPrinter resultsPrinter, SwingometerFormatter resultsFormatter) {
    super(resultsPrinter, resultsFormatter);
  }

  @Override
  public void update(ElectionResults results) {
    display(results);
  }
}

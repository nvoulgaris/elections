package com.nvoulgaris.elections.observers;

import com.nvoulgaris.elections.Console;
import com.nvoulgaris.elections.ElectionResults;
import com.nvoulgaris.elections.formatters.SwingometerFormatter;

public class Swingometer extends Display implements ElectionObserver {

  public Swingometer(Console console, SwingometerFormatter resultsFormatter) {
    super(console, resultsFormatter);
  }

  @Override
  public void update(ElectionResults results) {
    printResults(results);
  }
}

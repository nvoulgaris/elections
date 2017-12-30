package com.nvoulgaris.elections;

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

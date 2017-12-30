package com.nvoulgaris.elections;

public class Swingometer implements ElectionObserver, Display {

  private Console console;
  private ResultsFormatter resultsFormatter;

  public Swingometer(Console console, ResultsFormatter resultsFormatter) {
    this.resultsFormatter = resultsFormatter;
    this.console = console;
  }

  @Override
  public void update(ElectionResults results) {
    String formattedResults = resultsFormatter.formatForSwingometer(results);
    console.printLine(formattedResults);
  }
}

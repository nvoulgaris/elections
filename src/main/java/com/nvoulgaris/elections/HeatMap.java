package com.nvoulgaris.elections;

public class HeatMap implements ElectionObserver, Display {

  private Console console;
  private ResultsFormatter resultsFormatter;

  public HeatMap(Console console, ResultsFormatter resultsFormatter) {
    this.console = console;
    this.resultsFormatter = resultsFormatter;
  }

  @Override
  public void update(ElectionResults results) {
    String formattedResults = resultsFormatter.formatForHeatMap(results);
    console.printLine(formattedResults);
  }
}

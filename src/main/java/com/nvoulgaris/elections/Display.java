package com.nvoulgaris.elections;

import com.nvoulgaris.elections.formatters.ResultsFormatter;

public class Display {

  private Console console;
  private ResultsFormatter resultsFormatter;

  public Display(Console console, ResultsFormatter resultsFormatter) {
    this.console = console;
    this.resultsFormatter = resultsFormatter;
  }

  void printResults(ElectionResults results) {
    String formattedResults = resultsFormatter.format(results);
    console.printLine(formattedResults);
  }
}

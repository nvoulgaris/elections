package com.nvoulgaris.elections.observers;

import com.nvoulgaris.elections.Console;
import com.nvoulgaris.elections.ElectionResults;
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

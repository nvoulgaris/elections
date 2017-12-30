package com.nvoulgaris.elections.observers;

import com.nvoulgaris.elections.ElectionResults;
import com.nvoulgaris.elections.ResultsPrinter;
import com.nvoulgaris.elections.formatters.ResultsFormatter;

public class Display {

  private ResultsPrinter resultsPrinter;
  private ResultsFormatter resultsFormatter;

  public Display(ResultsPrinter resultsPrinter, ResultsFormatter resultsFormatter) {
    this.resultsPrinter = resultsPrinter;
    this.resultsFormatter = resultsFormatter;
  }

  void display(ElectionResults results) {
    String formattedResults = resultsFormatter.format(results);
    resultsPrinter.print(formattedResults);
  }
}

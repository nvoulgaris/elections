package com.nvoulgaris.elections.observers;

import com.nvoulgaris.elections.ElectionResults;
import com.nvoulgaris.elections.ResultsPrinter;
import com.nvoulgaris.elections.formatters.ResultsFormatter;
import com.nvoulgaris.elections.observables.ElectionData;

public class ElectionDisplay {

  private ResultsPrinter resultsPrinter;
  private ResultsFormatter resultsFormatter;

  public ElectionDisplay(ResultsPrinter resultsPrinter, ResultsFormatter resultsFormatter) {
    this.resultsPrinter = resultsPrinter;
    this.resultsFormatter = resultsFormatter;
  }

  void display(ElectionData data) {
    ElectionResults results = data.getResults();
    String formattedResults = resultsFormatter.format(results);
    resultsPrinter.print(formattedResults);
  }
}

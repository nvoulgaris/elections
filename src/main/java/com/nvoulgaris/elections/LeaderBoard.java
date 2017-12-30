package com.nvoulgaris.elections;

public class LeaderBoard implements ElectionObserver, Display {

  private Console console;
  private ResultsFormatter resultsFormatter;

  public LeaderBoard(Console console, ResultsFormatter resultsFormatter) {
    this.console = console;
    this.resultsFormatter = resultsFormatter;
  }

  public void update(ElectionResults results) {
    String formattedResults = resultsFormatter.formatForLeaderBoard(results);
    console.printLine(formattedResults);
  }
}

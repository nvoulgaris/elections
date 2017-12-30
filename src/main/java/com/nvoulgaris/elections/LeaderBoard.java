package com.nvoulgaris.elections;

public class LeaderBoard implements ElectionObserver {

  private ResultsFormatter resultsFormatter;
  private Console console;

  public LeaderBoard(ResultsFormatter resultsFormatter, Console console) {
    this.resultsFormatter = resultsFormatter;
    this.console = console;
  }

  public void update(ElectionResults results) {
    String formattedResults = resultsFormatter.formatForLeaderBoard(results);
    console.printLine(formattedResults);
  }
}

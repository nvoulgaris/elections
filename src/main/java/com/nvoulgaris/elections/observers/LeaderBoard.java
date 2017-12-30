package com.nvoulgaris.elections.observers;

import com.nvoulgaris.elections.Console;
import com.nvoulgaris.elections.ElectionResults;
import com.nvoulgaris.elections.formatters.LeaderBoardFormatter;

public class LeaderBoard extends Display implements ElectionObserver {

  public LeaderBoard(Console console, LeaderBoardFormatter resultsFormatter) {
    super(console, resultsFormatter);
  }

  public void update(ElectionResults results) {
    printResults(results);
  }
}

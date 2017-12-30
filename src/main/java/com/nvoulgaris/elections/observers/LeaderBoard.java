package com.nvoulgaris.elections.observers;

import com.nvoulgaris.elections.ElectionResults;
import com.nvoulgaris.elections.ResultsPrinter;
import com.nvoulgaris.elections.formatters.LeaderBoardFormatter;

public class LeaderBoard extends Display implements ElectionObserver {

  public LeaderBoard(ResultsPrinter resultsPrinter, LeaderBoardFormatter resultsFormatter) {
    super(resultsPrinter, resultsFormatter);
  }

  public void update(ElectionResults results) {
    display(results);
  }
}

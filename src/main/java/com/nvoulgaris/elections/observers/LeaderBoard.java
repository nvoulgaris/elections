package com.nvoulgaris.elections.observers;

import com.nvoulgaris.elections.ResultsPrinter;
import com.nvoulgaris.elections.formatters.LeaderBoardFormatter;
import com.nvoulgaris.elections.observables.ElectionData;

public class LeaderBoard extends ElectionDisplay implements ElectionObserver {

  public LeaderBoard(ResultsPrinter resultsPrinter, LeaderBoardFormatter resultsFormatter) {
    super(resultsPrinter, resultsFormatter);
  }

  public void update(ElectionData data) {
    display(data);
  }
}

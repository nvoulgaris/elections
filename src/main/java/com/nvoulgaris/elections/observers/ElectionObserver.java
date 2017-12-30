package com.nvoulgaris.elections.observers;

import com.nvoulgaris.elections.ElectionResults;

public interface ElectionObserver {

  void update(ElectionResults results);
}

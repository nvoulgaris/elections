package com.nvoulgaris.elections.observers;

import com.nvoulgaris.elections.observables.ElectionData;

public interface ElectionObserver {

  void update(ElectionData data);
}

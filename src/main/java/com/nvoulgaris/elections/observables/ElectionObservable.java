package com.nvoulgaris.elections.observables;

import com.nvoulgaris.elections.observers.ElectionObserver;

public interface ElectionObservable {

  void register(ElectionObserver observer);

  void unregister(ElectionObserver observer);

  void notifyObservers();
}

package com.nvoulgaris.elections.observables;

import com.nvoulgaris.elections.ElectionResults;
import com.nvoulgaris.elections.observers.ElectionObserver;

import java.util.ArrayList;

public class ElectionData implements ElectionObservable {

  private ArrayList<ElectionObserver> observers;
  private ElectionResults results;

  public ElectionData() {
    this.observers = new ArrayList<>();
  }

  @Override
  public void register(ElectionObserver observer) {
    observers.add(observer);
  }

  @Override
  public void unregister(ElectionObserver observer) {
    observers.remove(observer);
  }

  @Override
  public void notifyObservers() {
    observers.forEach(o -> o.update(results));
  }

  public void resultsChanged(ElectionResults results) {
    this.results = results;
    notifyObservers();
  }
}

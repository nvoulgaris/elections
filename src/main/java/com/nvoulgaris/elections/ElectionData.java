package com.nvoulgaris.elections;

import java.util.ArrayList;

public class ElectionData {

  private ArrayList<ElectionObserver> observers;
  private ElectionResults results;

  public ElectionData() {
    this.observers = new ArrayList<>();
  }

  public void registerObserver(ElectionObserver observer) {
    observers.add(observer);
  }

  public void unregisterObserver(ElectionObserver observer) {
    observers.remove(observer);
  }

  public void notifyObservers() {
    observers.forEach(o -> o.update(results));
  }

  public void resultsChanged(ElectionResults results) {
    this.results = results;
    notifyObservers();
  }
}

package com.nvoulgaris.elections;

public class ResultsPrinter {

  private Console console;

  public ResultsPrinter(Console console) {
    this.console = console;
  }

  public void print(String message) {
    console.printLine(message);
  }
}

package com.nvoulgaris.elections;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

public class ResultsPrinterShould {

  private static final String MESSAGE = "message";

  @Mock Console console;

  private  ResultsPrinter resultsPrinter;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
    resultsPrinter = new ResultsPrinter(console);
  }

  @Test
  public void printResultsToConsole() throws Exception {
    resultsPrinter.print(MESSAGE);
    verify(console).printLine(MESSAGE);
  }
}
package com.nvoulgaris.elections.acceptance;

import com.nvoulgaris.elections.Console;
import com.nvoulgaris.elections.ElectionData;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.HashMap;
import java.util.Map;

public class LiveDataUpdateFeature {

  @Mock Console console;

  @InjectMocks
  private ElectionData electionData;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void updateDisplays() throws Exception {
    Map<String, String> freshData = new HashMap<String, String>();
    electionData.read(freshData);

    InOrder inOrder = Mockito.inOrder(console);
    inOrder.verify(console).printLine("Leader board updated");
    inOrder.verify(console).printLine("Map updated");
    inOrder.verify(console).printLine("Swingometer updated");
  }
}

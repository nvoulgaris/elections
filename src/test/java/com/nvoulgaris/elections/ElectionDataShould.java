package com.nvoulgaris.elections;

import com.nvoulgaris.elections.observables.ElectionData;
import com.nvoulgaris.elections.observers.HeatMap;
import com.nvoulgaris.elections.observers.LeaderBoard;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

public class ElectionDataShould {

  @Mock ElectionResults electionResults;
  @Mock LeaderBoard leaderBoard;
  @Mock HeatMap heatMap;
  private ElectionData electionData;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
    electionData = new ElectionData();
  }

  @Test
  public void notifyRegisteredObserversWhenReadingFreshElectionData() throws Exception {
    electionData.register(leaderBoard);

    electionData.resultsChanged(electionResults);

    verify(leaderBoard).update(electionData);
  }

  @Test
  public void notifyOnlyRegisteredObserversWhenReadingFreshElectionData() throws Exception {
    electionData.register(heatMap);
    electionData.unregister(heatMap);

    electionData.resultsChanged(electionResults);

    verify(heatMap, never()).update(electionData);
  }
}

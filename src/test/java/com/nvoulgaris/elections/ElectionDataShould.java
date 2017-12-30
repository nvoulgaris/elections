package com.nvoulgaris.elections;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

public class ElectionDataShould {

  @Mock ElectionResults electionResults;
  @Mock LeaderBoard leaderBoard;
  @Mock HeatMap heatMap;
  @InjectMocks private ElectionData electionData;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void notifyRegisteredObserversWhenReadingFreshElectionData() throws Exception {
    electionData.registerObserver(leaderBoard);

    electionData.resultsChanged(electionResults);

    verify(leaderBoard).update(electionResults);
  }

  @Test
  public void notifyOnlyRegisteredObserversWhenReadingFreshElectionData() throws Exception {
    electionData.registerObserver(heatMap);
    electionData.unregisterObserver(heatMap);

    electionData.resultsChanged(electionResults);

    verify(heatMap, never()).update(electionResults);
  }
}

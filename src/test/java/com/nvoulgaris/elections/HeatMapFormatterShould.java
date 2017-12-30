package com.nvoulgaris.elections;

import com.nvoulgaris.elections.formatters.HeatMapFormatter;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HeatMapFormatterShould {

  private HeatMapFormatter heatMapFormatter;
  private ElectionResults results;

  @Before
  public void setUp() throws Exception {
    heatMapFormatter = new HeatMapFormatter();
    results = new ElectionResults();
  }

  @Test
  public void formatResults() throws Exception {
    String formattedResults = heatMapFormatter.format(results);

    assertThat(formattedResults).isEqualTo(Constants.HEAT_MAP_FORMATTED_RESULTS);
  }
}
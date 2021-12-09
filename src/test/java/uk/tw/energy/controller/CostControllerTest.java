package uk.tw.energy.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import uk.tw.energy.service.UsageCostService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CostControllerTest {

    @Mock
    UsageCostService usageCostService;

    @ParameterizedTest
    @ValueSource(ints = {100, 200})
    public void calculate_last_week_cost_for_an_smart_meter(int givenALastWeekCost) throws Exception {
        String givenASmartMeterId = "anySmartMeterId";
        when(usageCostService.calculateLastWeekCostFor(givenASmartMeterId)).thenReturn(givenALastWeekCost);

        UsageCostController costController = new UsageCostController(usageCostService);
        ResponseEntity<Integer> actualUsageCost = costController.lastWeekUsageCost(givenASmartMeterId);

        ResponseEntity<Integer> expected = new ResponseEntity<>(givenALastWeekCost, HttpStatus.OK);
        assertThat(actualUsageCost).isEqualTo(expected);
    }

    @Test
    public void do_not_calculate_last_week_cost_when_calculation_fails() throws Exception {
        String givenASmartMeterId = "anySmartMeterId";
        when(usageCostService.calculateLastWeekCostFor(givenASmartMeterId)).thenThrow(new Exception("Oh my god"));

        UsageCostController usageCostController = new UsageCostController(usageCostService);
        ResponseEntity<Integer> actualUsageCost = usageCostController.lastWeekUsageCost(givenASmartMeterId);

        ResponseEntity<Integer> expected = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        assertThat(actualUsageCost).isEqualTo(expected);
    }
}

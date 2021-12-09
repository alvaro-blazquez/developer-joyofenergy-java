package uk.tw.energy.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import uk.tw.energy.controller.UsageCostController;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UsageCostServiceTest {

    private UsageCostController usageCostController;

    @Mock
    private AccountService accountService;

//    @BeforeEach
//    public void setUp() {
//        usageCostController = new UsageCostController(accountService);
//    }
//
//    @Test
//    public void givenMeterIdWithPricePlanLastWeekUsageCostShouldBeReturned() {
//        final String METER_ID = "MyId";
//        final String PLAN_ID = "PlanId";
//        when(accountService.getPricePlanIdForSmartMeterId(METER_ID)).thenReturn(PLAN_ID);
//        usageCostController.lastWeekUsageCost(METER_ID);
//    }
}

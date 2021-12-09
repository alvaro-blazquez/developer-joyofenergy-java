package uk.tw.energy.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import uk.tw.energy.service.UsageCostService;

public class UsageCostController {
    private final UsageCostService usageCostService;

    public UsageCostController(UsageCostService usageCostService) {
        this.usageCostService = usageCostService;
    }

    public ResponseEntity<Integer> lastWeekUsageCost(String meterId) {
        int result = usageCostService.calculateLastWeekCostFor(meterId);
        ResponseEntity<Integer> response = new ResponseEntity<>(result, HttpStatus.OK);
        return response;
    }
}

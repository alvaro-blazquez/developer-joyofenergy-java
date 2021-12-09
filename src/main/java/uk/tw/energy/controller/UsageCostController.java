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
        ResponseEntity<Integer> response;
        try {
            int result = usageCostService.calculateLastWeekCostFor(meterId);
            response = new ResponseEntity<>(result, HttpStatus.OK);
            return response;
        } catch (Exception ex) {
            response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }
}

package uk.tw.energy.controller;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import uk.tw.energy.service.AccountService;
import uk.tw.energy.service.PricePlanService;

public class UsageCostController {
    private AccountService accountService;

    public UsageCostController(AccountService accountService) {
        this.accountService = accountService;
    }

    public void lastWeekUsageCost(String meterId) {
        // Get Plan
        String pricePlan = this.accountService.getPricePlanIdForSmartMeterId(meterId);
        // Get Last week DateTimes
        // Calculate usage cost
//        - Unit of meter readings : kW (KilloWatt)
//                - Unit of Time : Hour (h)
//        - Unit of Energy Consumed : kW x Hour = kWh
//                - Unit of Tariff : $ per kWh (ex 0.2 $ per kWh)
        throw new NotImplementedException();
    }
}

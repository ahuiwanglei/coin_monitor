package com.coin.monitor.quartz;

import com.coin.monitor.service.MarketListService;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.PersistJobDataAfterExecution;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@DisallowConcurrentExecution
@PersistJobDataAfterExecution
public class ScanMarketListQuartz  implements Job{

    protected static final Logger logger = LoggerFactory.getLogger(ScanMarketListQuartz.class);

    @Autowired
    MarketListService marketListService;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        marketListService.storeMarketList();
    }
}

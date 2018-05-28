package com.coin.monitor.quartz;

import com.coin.monitor.service.MarketListService;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@DisallowConcurrentExecution
@PersistJobDataAfterExecution
public class ScanOrderBooksQuartz implements Job{

    protected static final Logger logger = LoggerFactory.getLogger(ScanOrderBooksQuartz.class);

    @Autowired
    MarketListService marketListService;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        marketListService.storeOrderBooks();
    }
}

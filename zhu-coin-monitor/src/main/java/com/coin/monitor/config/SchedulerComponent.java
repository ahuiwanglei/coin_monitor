package com.coin.monitor.config;

import com.coin.monitor.quartz.ScanMarketListQuartz;
import com.coin.monitor.quartz.ScanOrderBooksQuartz;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class SchedulerComponent {

    protected static final Logger logger = LoggerFactory.getLogger(SchedulerComponent.class);

    @Value("${scan.marketlist.cron}")
    private String market_cron;
    @Value("${scan.orderbook.cron}")
    private String orderbook_cron;

    @Autowired
    SchedulerJobFactory schedulerJobFactory;

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(){
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        schedulerFactoryBean.setJobFactory(schedulerJobFactory);
        logger.info("***************schedulerFactoryBean init***************");
        return schedulerFactoryBean;
    }

    public void scheduleJobs(SchedulerFactoryBean schedulerFactoryBean ) throws SchedulerException {
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        startScanMarketList(scheduler);
        startScanOrderBooks(scheduler);
    }

    public void startScanMarketList(Scheduler scheduler) throws SchedulerException {
        JobDetail jobDetail = JobBuilder.newJob(ScanMarketListQuartz.class)
                .withIdentity("job1", "group1").build();
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(market_cron);
        CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1")
                .withSchedule(scheduleBuilder).build();
        scheduler.scheduleJob(jobDetail,cronTrigger);
    }

    public void startScanOrderBooks(Scheduler scheduler) throws SchedulerException {
        JobDetail jobDetail = JobBuilder.newJob(ScanOrderBooksQuartz.class)
                .withIdentity("job2", "group2").build();
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(orderbook_cron);
        CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity("trigger2", "group2")
                .withSchedule(scheduleBuilder).build();
        scheduler.scheduleJob(jobDetail,cronTrigger);
    }

}

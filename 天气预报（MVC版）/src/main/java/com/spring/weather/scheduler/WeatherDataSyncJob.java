package com.spring.weather.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * 定时获取天气信息
 */
@Slf4j
public class WeatherDataSyncJob extends QuartzJobBean {
    @Override
    protected void executeInternal(JobExecutionContext ctx) throws JobExecutionException {
        log.info("weather data sync job invoke...");

    }
}

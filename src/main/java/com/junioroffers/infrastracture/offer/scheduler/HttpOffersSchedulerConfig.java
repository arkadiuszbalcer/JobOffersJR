package com.junioroffers.infrastracture.offer.scheduler;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
@ConditionalOnProperty(name="scheduling.enabled", matchIfMissing = true)
public class HttpOffersSchedulerConfig {
}
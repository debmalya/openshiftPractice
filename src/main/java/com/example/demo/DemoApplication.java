package com.example.demo;



import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableScheduling
@Slf4j
public class DemoApplication {
	
	private static final Logger LOG = LoggerFactory
            .getLogger(DemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Scheduled(cron="1 * * * * *")
	public void scheduledTask() {
		LOG.info("Scheduled task at {}",LocalDateTime.now());
	}
	
	@Bean
	public TaskScheduler  taskScheduler() {
	    ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
	    threadPoolTaskScheduler.setPoolSize(5);
	    threadPoolTaskScheduler.setThreadNamePrefix("ThreadPoolTaskScheduler");
	    return threadPoolTaskScheduler;
	}
	
	// spring.task.scheduling.pool.size=5

}

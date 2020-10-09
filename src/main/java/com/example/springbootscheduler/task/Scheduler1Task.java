package com.example.springbootscheduler.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by summer on 2016/12/1.
 */

@Component
public class Scheduler1Task {

    private int count=0;

    @Scheduled(cron="*/6 * * * * ?")
    private void process(){
        System.out.println("this is scheduler task running  "+(count++));
    }

}
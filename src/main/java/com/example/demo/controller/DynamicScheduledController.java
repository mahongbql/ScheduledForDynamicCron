package com.example.demo.controller;

import com.example.demo.service.ScheduledForDynamicCron;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mahongbin on 2018/9/4.
 */
@RestController
@RequestMapping("/dynamic-scheduled")
public class DynamicScheduledController {
    @Autowired
    ScheduledForDynamicCron scheduledForDynamicCron;

    @RequestMapping(value = "/update-cron")
    public String updateDynamicScheduledTask(@RequestParam("cron") String cron) {
        String c = cron;
        scheduledForDynamicCron.setCron(cron);

        return "success";
    }
}
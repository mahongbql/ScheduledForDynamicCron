package com.example.demo.service;

import com.example.demo.mapper.TestMapper;
import com.example.demo.model.App;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;

/**
 * Created by mahongbin on 2018/9/4.
 */
@Service
public class ScheduledForDynamicCron implements SchedulingConfigurer {

    private Logger log = LoggerFactory.getLogger(ScheduledForDynamicCron.class);

    @Autowired
    private ThreadPoolTaskScheduler threadPoolTaskScheduler;

    private ScheduledFuture<?> future;

    private static Map<Integer, ScheduledFuture<?>> threadMap = new HashMap<>();

    @Bean
    public ThreadPoolTaskScheduler threadPoolTaskScheduler() {
        return new ThreadPoolTaskScheduler();
    }

    private static final String DEFAULT_CRON = "0/10 * * * * ?";
    private String cron = DEFAULT_CRON;

    @Autowired
    private TestMapper testMapper;

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.addTriggerTask(() -> {
            // 定时任务的业务逻辑
            //从数据库中取得开启状态的所有任务，与已经定时的任务做比较，新的任务开启新任务
            //传入参数：开始时间 结束时间 最小净买入量 最小持仓量 赠送的币种类型
            List<App> appList = testMapper.getActivityData();
            log.info(" === 进行最外层查询数据库内容 === " + new Date());
            for(App app : appList){
                if(app.getAppType() == 3){
                    stopCron(app.getId());
                }else if(threadMap.get(app.getId()) == null){
                    future = threadPoolTaskScheduler.schedule(new MyRunnable(app.getId()+""), new CronTrigger("0/5 * * * * *"));
                    threadMap.put(app.getId(), future);
                }
            }
        }, (triggerContext) -> {
            // 定时任务触发，可修改定时任务的执行周期
            CronTrigger trigger = new CronTrigger(cron);
            Date nextExecDate = trigger.nextExecutionTime(triggerContext);
            return nextExecDate;
        });
    }

    public String stopCron(int id) {
        ScheduledFuture<?> future = threadMap.get(id);
        if (future != null) {
            future.cancel(true);
            System.out.println("DynamicTask.stopCron()");
        }
        return "stopCron";
    }

    public void setCron(String cron) {
        System.out.println("当前cron="+this.cron+"->将被改变为："+cron);
        this.cron = cron;
    }

    private class MyRunnable implements Runnable {
        private String c = "";


        public MyRunnable(String c){
            this.c = c;
        }

        @Override
        public void run() {
            System.out.println("DynamicTask.MyRunnable.run()，" + c);
        }
    }
}

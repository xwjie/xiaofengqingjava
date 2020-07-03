package cn.xiaowenjie.iptask;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Conditional;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * 后台定时任务
 *
 * @author 晓风轻
 */
@Service
@Slf4j
@Conditional(IPCondition.class)
public class BackService {

    @PostConstruct
    public void init(){
        log.info("i run task...");
    }

    @Scheduled(cron = "0/10 * * * * *")
    public void scheduleTask(){
        log.info("task running....");
    }
}

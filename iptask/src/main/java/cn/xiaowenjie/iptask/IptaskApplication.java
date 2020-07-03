package cn.xiaowenjie.iptask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 集群环境下指定机器执行后台任务
 *
 * @author 晓风轻
 */
@EnableScheduling
@SpringBootApplication
public class IptaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(IptaskApplication.class, args);
	}

}

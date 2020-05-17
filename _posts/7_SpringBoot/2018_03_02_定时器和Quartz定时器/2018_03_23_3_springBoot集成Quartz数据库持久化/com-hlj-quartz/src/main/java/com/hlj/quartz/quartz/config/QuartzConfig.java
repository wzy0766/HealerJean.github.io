package com.hlj.quartz.quartz.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;

import java.io.IOException;
import java.util.Properties;


/**
 * @Description
 * @Author HealerJean
 * @Date 2018/3/22  下午3:45.
 */
@Configuration
public class QuartzConfig {

    @Value("${healerjean.datasource.url}")
    private String healerjeanUrl;
    @Value("${healerjean.datasource.username}")
    private String healerjeanname;
    @Value("${healerjean.datasource.password}")
    private String healerjeanPassword;

    @Bean
    public SpringBeanJobFactory jobFactory (){
        return new SpringBeanJobFactory();
    }

    @Bean
    public Properties quartzProperties() throws IOException {
        PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
        propertiesFactoryBean.setLocation(new ClassPathResource("/quartz.properties"));
        propertiesFactoryBean.afterPropertiesSet();
        return propertiesFactoryBean.getObject();
    }

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(SpringBeanJobFactory jobFactory) throws IOException {
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();

        schedulerFactoryBean.setOverwriteExistingJobs(true);
        schedulerFactoryBean.setQuartzProperties(quartzProperties());
        schedulerFactoryBean.setJobFactory(jobFactory);
        schedulerFactoryBean.setWaitForJobsToCompleteOnShutdown(true);
        return schedulerFactoryBean;
    }




    /**
     * 类描述：
     * 创建人： HealerJean
     */
    @Configuration
    public class QuartzConfig {



        @Bean
        public SpringBeanJobFactory jobFactory (){
            return new SpringBeanJobFactory();
        }

        @Bean
        public SchedulerFactoryBean schedulerFactoryBean (SpringBeanJobFactory jobFactory) {
            SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
            schedulerFactoryBean.setDataSource(createAdmore());
            schedulerFactoryBean.setConfigLocation(new ClassPathResource("quartz.properties"));
            schedulerFactoryBean.setJobFactory(jobFactory);
            schedulerFactoryBean.setWaitForJobsToCompleteOnShutdown(true);
            schedulerFactoryBean.setGlobalJobListeners(new com.duodian.admore.quartz.core.event.HealerJeanJobListener());
            schedulerFactoryBean.setOverwriteExistingJobs(true);
            return schedulerFactoryBean;
        }


    }

}

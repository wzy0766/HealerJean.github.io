package com.healerjean.proj.study.spi;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.common.URL;

/**
 * @author HealerJean
 * @ClassName Elephant
 * @date 2020/6/28  10:10.
 * @Description
 */
@Slf4j
public class AdaptiveAnimal implements Animal {

    @Override
    public void call(String msg, URL url) {
      log.info("我是适配动物，发出叫声：{}", msg);
    }

}

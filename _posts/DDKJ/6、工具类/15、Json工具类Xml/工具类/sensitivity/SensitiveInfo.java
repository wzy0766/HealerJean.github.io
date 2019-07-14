package com.hlj.proj.utils.sensitivity;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @ClassName SensitiveInfo
 * @Author TD
 * @Date 2019/1/10 17:26
 * @Description Json序列化脱敏注解
 * 不建议使用注解，建议使用JsonUtils工具类进行脱敏，因为注解会让我们需要必要时输出到前台的信息变的脱敏
 */
@Retention(RetentionPolicy.RUNTIME)
@JacksonAnnotationsInside
@JsonSerialize(using = SensitiveInfoSerialize.class)
public @interface SensitiveInfo {

    SensitiveTypeEnum value() ;

}

package com.imiros.generator.config;


import lombok.Data;

/**
 * 全局配置
 *
 * @author zxq
 */
@Data
public class ContextConfig {

    /**
     * 模板输出的项目目录
     */
    private String projectPath = "/Users/zhangxinqiang/Downloads/code";
    /**
     * 业务名称
     */
    private String bizChName;
    /**
     * 业务英文名称
     */
    private String bizEnName;
    /**
     * 业务英文名称(大写)
     */
    private String bizEnBigName;
    /**
     * 模块名称
     */
    private String moduleName = "system";

    private String proPackage = "com.imiros.salivawar.module";
    private String baseCommonPackage = "com.imiros";
    /**
     * 是否生成控制器代码开关
     */
    private Boolean controllerSwitch = true;
    /**
     * dao
     */
    private Boolean daoSwitch = true;
    /**
     * service
     */
    private Boolean serviceSwitch = true;
    /**
     * 生成实体的开关
     */
    private Boolean entitySwitch = true;

}

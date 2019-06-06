package com.imiros.generator.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.imiros.generator.utils.OSUtil;

/**
 * 代码生成规则的配置
 *
 * @author zxq
 */
public class AppDevGeneratorConfig extends BaseGeneratorConfig {

    protected void globalConfig() {
        //配置项目代码生成的绝对路径,注意具体到java目录
        if (OSUtil.MAC) {
            globalConfig.setOutputDir("/Users/zhangxinqiang/Downloads");
        } else if (OSUtil.WINDOWS) {
            globalConfig.setOutputDir("E:\\generatorCode");
        }
        //是否开启文件覆盖
        globalConfig.setFileOverride(true);
        globalConfig.setEnableCache(false);
        globalConfig.setBaseResultMap(true);
        globalConfig.setBaseColumnList(true);
        //设置id策略
        globalConfig.setIdType(IdType.INPUT);
        //不需要ActiveRecord特性的请改为false
        globalConfig.setActiveRecord(false);
        globalConfig.setOpen(false);
        /**
         * 【修改1-更换代码生成作者】
         */
        globalConfig.setAuthor("zhangxinqiang");
    }

    protected void dataSourceConfig() {
        dataSourceConfig.setDbType(DbType.MYSQL);
//        dataSourceConfig.setDriverName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("");
        dataSourceConfig.setUrl("jdbc:mysql:///salivawar?&serverTimezone=UTC");
    }

    protected void strategyConfig() {
        /**
         * 【修改2-更换表的前缀】
         */
        // 此处可以修改为您的表前缀
        strategyConfig.setTablePrefix("");
        //表名映射实体类名的规则
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        //列名名映射属性名的规则
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
        // 自定义实体父类
        strategyConfig.setSuperEntityClass("com.imiros.salivawar.common.model.base.BaseDO");
        // 自定义实体，公共字段
        strategyConfig.setSuperEntityColumns("id", "createTime", "updateTime", "isEnable");

        /**
         * 【修改3-配置对应模块的表集合，各自维护自己模块，并保持一条生效】
         */
        //system-------系统管理表集合
        //"article", "article_type", "attention", "collect",
        //                "comment", "comment_multi", , "user", "user_auths"
        strategyConfig.setInclude("article", "article_type", "attention", "collect",
                "comment", "comment_multi", "user", "user_auths");

        //tool-------工具类通用性表集合
        //strategyConfig.setInclude("produce_order", "produce_plan");
    }

    protected void packageConfig() {
        packageConfig.setParent("com.imiros.salivawar");
        /**
         * 【修改4-配置模块的顶级包名】
         */
        //系统管理的顶级包名
        packageConfig.setModuleName("module");

        //tool-------工具类通用性表集合
        //packageConfig.setModuleName("demand");
        //packageConfig.setModuleName("produce");

    }

    protected void contextConfig() {
        /**
         * mybatis-plus 生成器开关
         */
        contextConfig.setEntitySwitch(true);
        contextConfig.setDaoSwitch(true);
        contextConfig.setServiceSwitch(true);
    }

    @Override
    protected void config() {
        globalConfig();
        dataSourceConfig();
        strategyConfig();
        packageConfig();
        contextConfig();
    }
}

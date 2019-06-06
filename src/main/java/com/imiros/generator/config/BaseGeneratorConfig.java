package com.imiros.generator.config;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.imiros.generator.utils.FileUtil;

import java.io.File;
import java.util.List;

/**
 * 代码生成的抽象配置
 */
public abstract class BaseGeneratorConfig {

    /**
     * mybatis-plus代码生成器配置
     */
    GlobalConfig globalConfig = new GlobalConfig();

    DataSourceConfig dataSourceConfig = new DataSourceConfig();

    StrategyConfig strategyConfig = new StrategyConfig();

    PackageConfig packageConfig = new PackageConfig();

    TableInfo tableInfo = null;

    /**
     * Guns代码生成器配置
     */
    ContextConfig contextConfig = new ContextConfig();


    protected abstract void config();

    public void init() {
        config();

        //配置实体、Mapper、xml、Service、ServiceImpl的包路径
        packageConfig.setEntity("model");
        packageConfig.setMapper("dao");
        packageConfig.setXml("dao.mapper");
        packageConfig.setService("service");
        packageConfig.setServiceImpl("service.impl");
        packageConfig.setController("controller");

        //controller没用掉,生成之后会自动删掉
        //packageConfig.setController("DDD");

        if (!contextConfig.getEntitySwitch()) {
            packageConfig.setEntity("DDD");
        }

        if (!contextConfig.getDaoSwitch()) {
            packageConfig.setMapper("DDD");
            packageConfig.setXml("DDD");
        }

        if (!contextConfig.getServiceSwitch()) {
            packageConfig.setService("DDD");
            packageConfig.setServiceImpl("DDD");
        }

    }

    /**
     * 删除不必要的代码
     */
    public void destory() {
        String outputDir = globalConfig.getOutputDir() + "/DDD";
        FileUtil.deleteDir(new File(outputDir));
    }


    public void doMpGeneration() {
        init();
        AutoGenerator autoGenerator = new AutoGenerator();
        // 选择 freemarker 引擎，默认 Veloctiy
        autoGenerator.setTemplateEngine(new FreemarkerTemplateEngine());

        autoGenerator.setGlobalConfig(globalConfig);
        autoGenerator.setDataSource(dataSourceConfig);
        autoGenerator.setStrategy(strategyConfig);
        autoGenerator.setPackageInfo(packageConfig);
        autoGenerator.execute();
        destory();

        //获取table信息,用于guns代码生成
        List<TableInfo> tableInfoList = autoGenerator.getConfig().getTableInfoList();
        if (tableInfoList != null && tableInfoList.size() > 0) {
            this.tableInfo = tableInfoList.get(0);
        }
    }
}

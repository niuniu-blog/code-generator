package com.imiros.generator;

import com.imiros.generator.config.AppDevGeneratorConfig;

/**
 * 项目代码生成器
 *
 * @author zxq
 * @since 2019-06-06
 */
public class ImirosCodeGenerator {

    public static void main(String[] args) {

        /**
         * Mybatis-Plus的代码生成器:
         * mp的代码生成器可以根据数据库表的信息生成实体,mapper,mapper对应的xml,service
         */
        AppDevGeneratorConfig appDevGeneratorConfig = new AppDevGeneratorConfig();
        appDevGeneratorConfig.doMpGeneration();
    }
}

package com.fbw;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;

public class CodeGeneratir {
    public static void main(String[] args) {
        AutoGenerator autoGenerator = new AutoGenerator();
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("Test!234");
        dataSourceConfig.setUrl("jdbc:mysql://localhost:3306/blog?serverTimezone=UTC");
        autoGenerator.setDataSource(dataSourceConfig);

        //全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setOutputDir("E:\\Codes\\javaCodes\\BlogServer\\Server\\src\\main\\java");//生成目录
//        globalConfig.setAuthor("编程随想");
        globalConfig.setFileOverride(true);//覆盖
        globalConfig.setMapperName("%sDao");//数据层命名规则
        globalConfig.setIdType(IdType.AUTO);//设置id生成策略
        autoGenerator.setGlobalConfig(globalConfig);

        //包名设置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("com.fbw");
        packageConfig.setEntity("domain");
        packageConfig.setMapper("dao");
        autoGenerator.setPackageInfo(packageConfig);

        //策略设置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setInclude("user","tag","comment","article");//指定对应的表，不指定就是全部
//        strategyConfig.setTablePrefix("tb1_");//设置数据库表的前缀，生成的类就不会带前缀
        strategyConfig.setRestControllerStyle(true);//启用Rest风格
//        strategyConfig.setVersionFieldName();//乐观锁直段
//        strategyConfig.setLogicDeleteFieldName();//逻辑删除字段
        strategyConfig.setEntityLombokModel(true);//是否启用lombok

        autoGenerator.setStrategy(strategyConfig);
        autoGenerator.execute();
    }
}

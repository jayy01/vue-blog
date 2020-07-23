package com.jayy.generator;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.jupiter.api.Test;

public class CodeGenerator {
    @Test
    public void run(){
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");//获取项目文件夹（D:\programme\Workspace\my-blog）
        gc.setOutputDir(projectPath + "/src/test/java");//输出文件夹
        gc.setAuthor("jayy");//作者
        gc.setOpen(false);//生成后是否打开资源管理器
        gc.setFileOverride(true);//生成完成时文件是否覆盖
        gc.setServiceName("%sSrevice");//去掉Service接口的首字母I
        gc.setSwagger2(true); //开启Swagger2模式
        gc.setIdType(IdType.ASSIGN_UUID);//逐渐策略
        gc.setDateType(DateType.TIME_PACK);//日期类型
        mpg.setGlobalConfig(gc);
        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/myblog?serverTimezone=GMT%2B8&useUnicode=true&useSSL=false&characterEncoding=utf8");
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("root");
        mpg.setDataSource(dsc);
        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName("");//模块名
        pc.setParent("com.jayy");//包名
        //pc.setController("controller");//设置包  使用默认值
        mpg.setPackageInfo(pc);
        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);//数据库表映射到实体的命名策略
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);//数据库表字段映射到实体的命名策略
        strategy.setRestControllerStyle(true);//restful
        String[] tables = "blog,type,user".split(",");
        strategy.setInclude(tables);//表名
        strategy.setControllerMappingHyphenStyle(true);//驼峰转连字符
        strategy.setTablePrefix(pc.getModuleName() + "_");//设置表前缀
        mpg.setStrategy(strategy);

        //执行
        mpg.execute();
    }
}

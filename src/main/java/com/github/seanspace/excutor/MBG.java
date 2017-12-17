package com.github.seanspace.excutor;

import com.github.seanspace.progress.Caller;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaobin
 * @date 2017/12/17
 */
public class MBG {

    private static Logger logger = LoggerFactory.getLogger(MBG.class);

    /**
     * generate: 调用MyBatis Generator 生成相应代码. <br/>
     *
     * @param generatorConfigPath generatorConfigPath.xml配置文件的路径
     * @since JDK 1.6
     */
    public static void generate(String generatorConfigPath) {
        if (generatorConfigPath == null || "".equals(generatorConfigPath.trim())) {
            logger.error("The generatorConfigPath.xml location specified is null, user default locate config files.");
            return;
        }

        try {
            List<String> warnings = new ArrayList<String>();
            boolean overwrite = true;
            logger.info("Current path is " + new File(".").getAbsolutePath());
            File configFile = new File(generatorConfigPath);
            ConfigurationParser cp = new ConfigurationParser(warnings);
            Configuration config = cp.parseConfiguration(configFile);
            DefaultShellCallback callback = new DefaultShellCallback(overwrite);
            MyBatisGenerator myBatisGenerator = null;
            myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
            myBatisGenerator.generate(new Caller());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        generate("src/main/resources/mbg/generatorConfig.xml");
    }
}

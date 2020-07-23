package com.jy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 启动程序
 * 
 * @author ruoyi
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@MapperScan("com.jy.*.mapper")
public class JyApplication
{
    public static void main(String[] args)
    {
        // System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(JyApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  就业系统启动成功   ლ(´ڡ`ლ)ﾞ  \n" +
                "   ____     __        \n" +
                "    \\   \\   /  /    \n" +
                "    \\  _. /  '       \n" +
                "    _( )_ .'         \n" +
                " ___(_ o _)'          \n" +
                " ||   |(_,_)'         \n" +
                " |   `-'  /           \n" +
                "  \\      /           \n" +
                "   `-..-'              ");
    }
}
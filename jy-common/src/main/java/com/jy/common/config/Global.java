package com.jy.common.config;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import com.jy.common.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.jy.common.utils.YamlUtil;

/**
 * 全局配置类
 * 
 * @author ruoyi
 */
public class Global
{
    private static final Logger log = LoggerFactory.getLogger(Global.class);

    private static String NAME = "application.yml";

    /**
     * 当前对象实例
     */
    private static Global global;

    /**
     * 保存全局属性值
     */
    private static Map<String, String> map = new HashMap<String, String>();

    private Global()
    {
    }

    /**
     * 静态工厂方法
     */
    public static synchronized Global getInstance()
    {
        if (global == null)
        {
            global = new Global();
        }
        return global;
    }

    /**
     * 获取配置
     */
    public static String getConfig(String key)
    {
        String value = map.get(key);
        if (value == null)
        {
            Map<?, ?> yamlMap = null;
            try
            {
                yamlMap = YamlUtil.loadYaml(NAME);
                value = String.valueOf(YamlUtil.getProperty(yamlMap, key));
                map.put(key, value != null ? value : StringUtils.EMPTY);
            }
            catch (FileNotFoundException e)
            {
                log.error("获取全局配置异常 {}", key);
            }
        }
        return value;
    }

    /**
     * 获取项目名称
     */
    public static String getName()
    {
        return StringUtils.nvl(getConfig("jy.name"), "jy");
    }

    /**
     * 获取项目版本
     */
    public static String getVersion()
    {
        return StringUtils.nvl(getConfig("jy.version"), "3.3.0");
    }

    /**
     * 获取版权年份
     */
    public static String getCopyrightYear()
    {
        return StringUtils.nvl(getConfig("jy.copyrightYear"), "2018");
    }

    /**
     * 获取ip地址开关
     */
    public static Boolean isAddressEnabled()
    {
        return Boolean.valueOf(getConfig("jy.addressEnabled"));
    }

    /**
     * 获取文件上传路径
     */
    public static String getProfile()
    {
        return getConfig("jy.profile");
    }

    /**
     * 获取头像上传路径
     */
    public static String getAvatarPath()
    {
        return getConfig("jy.profile") + "avatar/";
    }

    /**
     * 获取下载路径
     */
    public static String getDownloadPath()
    {
        return getConfig("jy.profile") + "download/";
    }

    /**
     * 获取上传路径
     */
    public static String getUploadPath()
    {
        return getConfig("jy.profile") + "upload/";
    }
}

package com.jy.web.controller.system;

import java.util.List;

import com.jy.framework.web.domain.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import com.jy.common.config.Global;
import com.jy.common.core.controller.BaseController;
import com.jy.framework.util.ShiroUtils;
import com.jy.system.domain.SysMenu;
import com.jy.system.domain.SysUser;
import com.jy.system.service.ISysMenuService;

/**
 * 首页 业务处理
 * 
 * @author ruoyi
 */
@Controller
public class SysIndexController extends BaseController
{
    private String prefix = "monitor/server";
    @Autowired
    private ISysMenuService menuService;

    // 系统首页
    @GetMapping("/index")
    public String index(ModelMap map)
    {
        // 取身份信息
        SysUser user = ShiroUtils.getSysUser();
        // 根据用户id取出菜单
        List<SysMenu> menus = menuService.selectMenusByUser(user);
        map.put("menus", menus);
        map.put("user", user);
        map.put("copyrightYear", Global.getCopyrightYear());
        return "index";
    }

    // 系统介绍
    @GetMapping("/system/main")
    public String main(ModelMap map)
    {
        map.put("version", Global.getVersion());
        return "main";
    }
    @GetMapping("/system/server")
    public String server(ModelMap map) throws Exception
    {
        Server server = new Server();
        server.copyTo();
        map.put("server", server);
        return prefix + "/server";
    }
}

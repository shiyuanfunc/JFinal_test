package com.song.demo;

import com.jfinal.config.*;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.CaseInsensitiveContainerFactory;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.song.controller.TestController;
import com.song.model.TestModel;

/**
 * Created by lenovo on 2017/10/12.
 */
public class DemoTest extends JFinalConfig{

    @Override
    public void configConstant(Constants constants) {
        constants.setDevMode(true);
    }

    @Override
    public void configRoute(Routes routes) {
        routes.add("/test",TestController.class);
    }

    @Override
    public void configPlugin(Plugins plugins) {
        PropKit.use("jdbc.properties","utf-8");
        C3p0Plugin c3p0Plugin = new C3p0Plugin(PropKit.get("jdbcUrl"),PropKit.get("user"), PropKit.get("password").trim());
        plugins.add(c3p0Plugin);
        ActiveRecordPlugin arp = new ActiveRecordPlugin(c3p0Plugin);
        plugins.add(arp);
        arp.setShowSql(true);

        arp.addMapping("test","id", TestModel.class);

        arp.setContainerFactory(new CaseInsensitiveContainerFactory(true));
        //true是小写  false是大写  不写是区分大小写
    }

    @Override
    public void configInterceptor(Interceptors interceptors) {

    }

    @Override
    public void configHandler(Handlers handlers) {

    }
}

package com.song.controller;

import com.jfinal.core.Controller;
import com.song.model.TestModel;

import java.util.List;

/**
 * Created by lenovo on 2017/10/12.
 */
public class TestController extends Controller {

    public void index() {
        renderText("testdfsfsdfsdf");
    }

    public void test() throws Exception {
        List<TestModel> testModels = TestModel.test.queryList();
        System.out.println(testModels);
        renderJson("json",testModels);  //向前台返回json  {"json":[....]}
    }
}

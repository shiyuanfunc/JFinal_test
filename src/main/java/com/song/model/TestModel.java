package com.song.model;

import com.jfinal.plugin.activerecord.Model;

import java.util.List;

/**
 * Created by lenovo on 2017/10/12.
 */
public class TestModel extends Model<TestModel> {

    public static final TestModel test = new TestModel();

    public List<TestModel> queryList() throws Exception{

        return test.find("select * from test");
    }
}

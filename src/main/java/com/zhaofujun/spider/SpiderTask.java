package com.zhaofujun.spider;

import com.zhaofujun.spider.engine.Spider;
import com.zhaofujun.spider.task.*;

import java.io.IOException;
import java.util.List;

public class SpiderTask {
    public static void main(String[] args) throws InterruptedException, IOException {
        Spider spider = new Spider();
        spider.addTask(new ProvincePageTask("http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2020/"));
//        spider.addTask(new CityPageTask("http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2020/51.html"));
//        spider.addTask(new CountyPageTask("http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2020/51/5109.html"));
//        spider.addTask(new TownPageTask("http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2020/51/09/510904.html"));
        spider.execute();
//        List<AreaCode> areaCodes = AreaCodeDataStorage.getAreaCodes();
        System.out.println("完成！");
    }
}


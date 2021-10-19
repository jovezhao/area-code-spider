package com.zhaofujun.spider.task;

import com.zhaofujun.spider.AreaCode;
import com.zhaofujun.spider.engine.PageTask;
import com.zhaofujun.spider.engine.Spider;
import org.jsoup.nodes.Document;

import java.util.ArrayList;
import java.util.List;

public class ProvincePageTask extends PageTask<AreaCode> {
    public ProvincePageTask(String url) {
        super(url, "GET", null, null);
        this.setDataStorage(new AreaCodeDataStorage());
    }


    @Override
    protected List<AreaCode> processData(Document document, Spider spider) {
        List<AreaCode> areaCodes = new ArrayList<>();
        document.select("tr .provincetr").forEach(p -> {
            p.select("td a").forEach(q -> {
                areaCodes.add(new AreaCode(q.attr("href"), q.text()));
                spider.addTask(new CityPageTask(q.attr("abs:href")));
            });
        });
        return areaCodes;
    }
}

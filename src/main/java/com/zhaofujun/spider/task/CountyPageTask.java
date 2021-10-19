package com.zhaofujun.spider.task;

import com.zhaofujun.spider.AreaCode;
import com.zhaofujun.spider.engine.PageTask;
import com.zhaofujun.spider.engine.Spider;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class CountyPageTask extends PageTask<AreaCode> {
    public CountyPageTask(String url) {
        super(url, "GET", null, null);
        this.setDataStorage(new AreaCodeDataStorage());
    }

    @Override
    protected List<AreaCode> processData(Document document, Spider spider) {
        List<AreaCode> areaCodes = new ArrayList<>();
        document.select("tr .countytr").forEach(p -> {
            Elements td_a = p.select("td a");
            if(td_a.size()==2){
                areaCodes.add(new AreaCode(td_a.get(0).text(),td_a.get(1).text()));
                spider.addTask(new TownPageTask(td_a.get(0).attr("abs:href")));
            }
        });
        return areaCodes;
    }
}

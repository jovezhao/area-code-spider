package com.zhaofujun.spider.task;

import com.zhaofujun.spider.AreaCode;
import com.zhaofujun.spider.engine.PageTask;
import com.zhaofujun.spider.engine.Spider;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class TownPageTask extends PageTask<AreaCode> {
    public TownPageTask(String url) {
        super(url, "GET", null, null);
        this.setDataStorage(new AreaCodeDataStorage());
    }

    @Override
    protected List<AreaCode> processData(Document document, Spider spider) {
        List<AreaCode> areaCodes = new ArrayList<>();
        document.select("tr .towntr").forEach(p -> {
            Elements td = p.select("td");
            areaCodes.add(new AreaCode(td.get(0).text(), td.get(1).text()));
//            if (td.select("a").size() != 0)
//                spider.addTask(new TownPageTask(td.select("a").attr("abs:href")));
        });
        return areaCodes;
    }
}

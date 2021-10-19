package com.zhaofujun.spider.engine;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.List;

public abstract class PageTask<T> {
    private String url;
    private String method;
    private String body;
    private String pathVar;
    private DataStorage<T> dataStorage;

    public PageTask(String url, String method) {
        this.url = url;
        this.method = method;
    }

    public PageTask(String url, String method, String body, String pathVar) {
        this.url = url;
        this.method = method;
        this.body = body;
        this.pathVar = pathVar;
    }

    protected abstract List<T> processData(Document document, Spider spider);


    private Document document;

    public void setDataStorage(DataStorage<T> dataStorage) {
        this.dataStorage = dataStorage;
    }

    public void start(Spider spider) throws IOException {

        Connection connect = Jsoup.connect(url);
        try {
            switch (method) {
                case "GET":
                    document = connect.get();
                    break;
            }

            List<T> data = processData(document, spider);
            dataStorage.save(data);
        } catch (Exception ex) {

            System.err.println(this.url + "失败，进入重试队列");

            spider.addTask(this);
        }
    }


    public String getUrl() {
        return url;
    }

    public String getMethod() {
        return method;
    }

    public String getBody() {
        return body;
    }

    public String getPathVar() {
        return pathVar;
    }
}

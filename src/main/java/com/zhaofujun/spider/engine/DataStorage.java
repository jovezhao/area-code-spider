package com.zhaofujun.spider.engine;

import java.util.List;

public interface DataStorage<T> {
    void save(List<T> data);
}

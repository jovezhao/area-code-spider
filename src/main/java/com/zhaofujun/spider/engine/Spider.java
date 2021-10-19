package com.zhaofujun.spider.engine;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class Spider {

    private Queue<PageTask> pageTasks = new LinkedList<>();

    public void addTask(PageTask pageTask) {
        pageTasks.offer(pageTask);
    }

    public void execute() throws InterruptedException, IOException {

        PageTask pageTask = pageTasks.poll();
        while (pageTask != null) {
            System.out.println("开始" + pageTask.getUrl() + " 剩余：" + pageTasks.size());
            pageTask.start(this);
            pageTask = pageTasks.poll();
            Thread.sleep(1000);
        }
    }
}

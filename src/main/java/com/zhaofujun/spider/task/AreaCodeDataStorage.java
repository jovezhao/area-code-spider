package com.zhaofujun.spider.task;

import com.zhaofujun.spider.AreaCode;
import com.zhaofujun.spider.engine.DataStorage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class AreaCodeDataStorage implements DataStorage<AreaCode> {
    private static List<AreaCode> areaCodes = new ArrayList<>();

    public static List<AreaCode> getAreaCodes() {
        return areaCodes;
    }

    @Override
    public void save(List<AreaCode> data) {

        String fileName = "/home/jove/IdeaProjects/jovezhao/area-code-spider/area.txt";

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName,true))) {
            for (AreaCode areaCode : data) {
                bufferedWriter.append(areaCode.getCode() + "," + areaCode.getName()+"\r\n");
            }

        } catch (Exception exception) {
            System.out.println(exception);
        }
    }
}

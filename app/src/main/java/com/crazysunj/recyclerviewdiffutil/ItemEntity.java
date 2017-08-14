package com.crazysunj.recyclerviewdiffutil;

/**
 * author: sunjian
 * created on: 2017/8/4 下午1:32
 * description:
 */

public class ItemEntity {
    private long id;
    private String title;

    public ItemEntity(long id, String title) {
        this.id = id;
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}

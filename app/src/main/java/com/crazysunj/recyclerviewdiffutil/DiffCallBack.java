package com.crazysunj.recyclerviewdiffutil;

import android.support.v7.util.DiffUtil;

import java.util.List;

/**
 * author: sunjian
 * created on: 2017/8/5 上午10:47
 * description:
 */

public class DiffCallBack extends DiffUtil.Callback {
    private List<ItemEntity> mOldDatas, mNewDatas;

    public DiffCallBack(List<ItemEntity> oldDatas, List<ItemEntity> newDatas) {
        mOldDatas = oldDatas;
        mNewDatas = newDatas;
    }

    @Override
    public int getOldListSize() {
        return mOldDatas != null ? mOldDatas.size() : 0;
    }

    @Override
    public int getNewListSize() {
        return mNewDatas != null ? mNewDatas.size() : 0;
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        if (mOldDatas == null || mNewDatas == null) {
            return false;
        }
        ItemEntity oldItem = mOldDatas.get(oldItemPosition);
        ItemEntity newItem = mNewDatas.get(newItemPosition);
        return !(oldItem == null || newItem == null) && oldItem.getId() == newItem.getId();
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        ItemEntity oldItem = mOldDatas.get(oldItemPosition);
        ItemEntity newItem = mNewDatas.get(newItemPosition);
        String oldTitle = oldItem.getTitle();
        String newTitle = newItem.getTitle();
        return !(oldTitle == null || newTitle == null) && oldTitle.equals(newTitle);
    }
}

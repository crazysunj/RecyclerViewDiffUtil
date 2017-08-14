package com.crazysunj.recyclerviewdiffutil;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateUtils;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private MyAdapter adapter;
    private List<ItemEntity> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        data = getRandomList();
        adapter = new MyAdapter(data);
        recyclerView.setAdapter(adapter);
    }

    public void onclick(View view) {

        List<ItemEntity> list = getRandomList();
        DiffUtil.DiffResult diffResult =
                DiffUtil.calculateDiff(new DiffCallBack(data, list), true);
        diffResult.dispatchUpdatesTo(adapter);
        data.clear();
        data.addAll(list);
    }

    private List<ItemEntity> getRandomList() {
        List<ItemEntity> list = new ArrayList<ItemEntity>();
        Random random = new Random();
        String dateTime = DateUtils.formatDateTime(this, System.currentTimeMillis(), DateUtils.FORMAT_SHOW_TIME);
        for (int i = 0, size = random.nextInt(10); i < size; i++) {
            list.add(new ItemEntity(i, String.format(Locale.getDefault(), "我是第%d个,时间：%s", i, dateTime)));
        }
        return list;
    }
}

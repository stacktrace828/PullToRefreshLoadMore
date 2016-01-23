package com.stacktrace.pulltorefreshloadmore;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ArrayAdapter;

import com.stacktrace.pulltorefreshloadmore.view.ListViewLoadMore;
import com.stacktrace.pulltorefreshloadmore.view.ListViewLoadMore.IsLoadingListener;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements IsLoadingListener{

    private ListViewLoadMore listView;
    private List<String> list;
    private ArrayAdapter<String> adapter;
    private Handler handler=new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListViewLoadMore) findViewById(R.id.listview);
        initData();
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);
        listView.setOnLoadingListener(this);
    }

    /**
     * 初始化list值
     */
    private void initData() {
        list = new ArrayList<String>();

        list.add("123456789");
        list.add("123456789");
        list.add("123456789");
        list.add("123456789");
        list.add("123456789");
        list.add("123456789");
        list.add("123456789");
        list.add("123456789");
        list.add("123456789");
        list.add("123456789");
        list.add("123456789");
        list.add("123456789");
        list.add("123456789");
        list.add("123456789");
        list.add("123456789");
        list.add("123456789");
        list.add("123456789");
    }

    @Override
    public void onLoad() {

        handler.postDelayed(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    list.add("new item" + i);
                }
                adapter.notifyDataSetChanged();
                listView.complateLoad();
            }
        }, 2000);

    }

}

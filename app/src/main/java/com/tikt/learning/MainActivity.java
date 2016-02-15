package com.tikt.learning;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

	@Bind(R.id.id_mainactivity_recycleview)
	RecyclerView recycleview;
	LinearLayoutManager linearLayoutManager;
	MainActivityAdapter adapter;
	ArrayList<String> list = new ArrayList<>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ButterKnife.bind(this);

		initEvent();
	}

	private void initEvent() {

		list.add("自定义View");
		if (null == adapter) {
			adapter = new MainActivityAdapter(MainActivity.this, list);
		} else {
			adapter.onDateChange(MainActivity.this, list);
		}


		linearLayoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
		recycleview.setItemAnimator(new DefaultItemAnimator());
		recycleview.setLayoutManager(linearLayoutManager);
		recycleview.setAdapter(adapter);

	}


}

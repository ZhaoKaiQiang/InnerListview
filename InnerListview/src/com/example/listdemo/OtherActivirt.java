/*
 * Copyright (c) 2014, 青岛司通科技有限公司 All rights reserved.
 * File Name：OtherActivirt.java
 * Version：V1.0
 * Author：zhaokaiqiang
 * Date：2014-8-15
 */
package com.example.listdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class OtherActivirt extends Activity implements OnItemClickListener {

	private ListView lv3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_other);
		lv3 = (ListView) findViewById(R.id.lv3);
		lv3.setOnItemClickListener(this);
		lv3.setAdapter(new MyAdapter());
	}

	private class MyAdapter extends BaseAdapter {

		@Override
		public int getCount() {
			return 20;
		}

		@Override
		public Object getItem(int position) {
			return position;
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {

			if (convertView == null) {
				convertView = LayoutInflater.from(OtherActivirt.this).inflate(
						R.layout.item, parent, false);
			}

			TextView tv = (TextView) convertView.findViewById(R.id.tv);
			tv.setText("Item" + position);
			return convertView;
		}

	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		Toast.makeText(this, "position" + position, Toast.LENGTH_SHORT).show();

	}
}

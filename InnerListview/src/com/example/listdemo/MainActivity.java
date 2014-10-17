package com.example.listdemo;

import android.app.Activity;
import android.content.Context;
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

public class MainActivity extends Activity implements OnItemClickListener {

	private ListView lv1;
	private ListView lv2;
	private Context context;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		context = this;

		lv1 = (ListView) findViewById(R.id.lv1);
		lv2 = (ListView) findViewById(R.id.lv2);

		lv1.setAdapter(new MyAdapter());
		lv1.setOnItemClickListener(this);
		lv2.setAdapter(new MyAdapter());
		lv2.setOnItemClickListener(this);
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
				convertView = LayoutInflater.from(context).inflate(
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
		Toast.makeText(context, "position" + position, Toast.LENGTH_SHORT)
				.show();

	}

}

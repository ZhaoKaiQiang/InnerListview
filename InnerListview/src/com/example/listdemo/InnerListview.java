/*
 * Copyright (c) 2014, 青岛司通科技有限公司 All rights reserved.
 * File Name：InnerListview.java
 * Version：V1.0
 * Author：zhaokaiqiang
 * Date：2014-8-15
 */
package com.example.listdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ListView;

/**
 * 
 * @ClassName: com.example.listdemo.InnerListview
 * @Description: 可以放在Listview中的Listview
 * @author zhaokaiqiang
 * @date 2014-8-15 下午2:43:34
 * 
 */
public class InnerListview extends ListView {
	public InnerListview(Context context) {
		super(context);
	}

	public InnerListview(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public InnerListview(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);

	}

	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		switch (ev.getAction()) {
		// 当手指触摸listview时，让父控件交出ontouch权限,不能滚动
		case MotionEvent.ACTION_DOWN:
			setParentScrollAble(false);
		case MotionEvent.ACTION_MOVE:
			break;
		case MotionEvent.ACTION_UP:
		case MotionEvent.ACTION_CANCEL:
			// 当手指松开时，让父控件重新获取onTouch权限
			setParentScrollAble(true);
			break;

		}
		return super.onInterceptTouchEvent(ev);

	}

	// 设置父控件是否可以获取到触摸处理权限
	private void setParentScrollAble(boolean flag) {
		getParent().requestDisallowInterceptTouchEvent(!flag);
	}

}

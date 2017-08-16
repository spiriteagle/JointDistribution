package com.acuit.jointdistribution.bean.impl;

import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TextView;

import com.acuit.jointdistribution.bean.BasePager;

/**
 *统计分析
 */


public class StatisticalAnalysisPager extends BasePager {

	public StatisticalAnalysisPager(Activity activity) {
		super(activity);
	}

	@Override
	public void initData() {

		//给空的帧布局动态添加布局对象
		TextView view = new TextView(mActivity);
		view.setTextSize(22);
		view.setTextColor(Color.GREEN);
		view.setGravity(Gravity.CENTER);//居中显示
		view.setText("首页");

		flContainer.addView(view);//给帧布局添加对象

		//修改标题
		tvTitle.setText("统计分析");
	}

}

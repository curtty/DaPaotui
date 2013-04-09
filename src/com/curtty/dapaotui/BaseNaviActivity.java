package com.curtty.dapaotui;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class BaseNaviActivity extends FragmentActivity {

	protected void setTopNavi(String left, String right, String title,
			OnClickListener rightAction) {
		View navi_left = findViewById(R.id.navi_left);
		TextView tv_right = (TextView) findViewById(R.id.navi_right);
		TextView tv_title = (TextView) findViewById(R.id.navi_title);
		if (navi_left instanceof TextView) {
			TextView tv_left = (TextView) navi_left;
			tv_left.setText(left);
			if (left == null) {
				tv_left.setVisibility(View.GONE);
			}
		}
		tv_right.setText(right);
		tv_title.setText(title);
		if (right == null) {
			tv_right.setVisibility(View.GONE);
		}
		if (title == null) {
			tv_title.setVisibility(View.GONE);
		}
		navi_left.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				onBackPressed();

			}
		});
		tv_right.setOnClickListener(rightAction);
	}

	protected void setTopNavi2(int resLeft, int resRight, String title,
			OnClickListener rightAction) {
		ImageView navi_left = (ImageView) findViewById(R.id.navi_left);
		ImageView navi_right = (ImageView) findViewById(R.id.navi_right);
		TextView navi_title = (TextView) findViewById(R.id.navi_title);
		if (resLeft == 0) {
			navi_left.setVisibility(View.GONE);
		} else {
			navi_left.setImageResource(resLeft);
		}
		if (resRight == 0) {
			navi_right.setVisibility(View.GONE);
		} else {
			navi_right.setImageResource(resRight);
		}
		if (title == null) {
			navi_title.setVisibility(View.GONE);
		} else {
			navi_title.setText(title);
		}
		navi_left.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				onBackPressed();

			}
		});
		navi_right.setOnClickListener(rightAction);
	}
}

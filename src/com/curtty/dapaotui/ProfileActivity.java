package com.curtty.dapaotui;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;

public class ProfileActivity  extends Activity{
	public void onCreate(Bundle bundle){
		super.onCreate(bundle);
		TextView tv = new TextView(this);
		tv.setText("ProfileActivity");
		tv.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT));
		tv.setGravity(Gravity.CENTER);
		setContentView(tv);
	}
}

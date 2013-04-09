package com.curtty.dapaotui;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

import com.curtty.dapaotui.task.RequestActivity;
import com.curtty.dapaotui.user.HomePageActivity;

public class MainActivity extends TabActivity{
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initTabs();
	}

	private void initTabs() {
		TabHost tabHost = (TabHost) findViewById(android.R.id.tabhost);
		tabHost.addTab(tabHost.newTabSpec("request").setIndicator("Buy Request").setContent(new Intent(this,RequestActivity.class)));
		tabHost.addTab(tabHost.newTabSpec("buy").setIndicator("Buy").setContent(new Intent(this,BuyActivity.class)));
		tabHost.addTab(tabHost.newTabSpec("profile").setIndicator("Profile").setContent(new Intent(this,HomePageActivity.class)));
		tabHost.addTab(tabHost.newTabSpec("sms").setIndicator("Message").setContent(new Intent(this,SMSActivity.class)));
		tabHost.addTab(tabHost.newTabSpec("contact").setIndicator("Contact").setContent(new Intent(this,ContactActivity.class)));
	}

}

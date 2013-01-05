package com.curtty.dapaotui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.commonsware.cwac.thumbnail.ThumbnailAdapter;
import com.curtty.dapaotui.adapter.RequestAdapter;
import com.curtty.dapaotui.data.DataWarehouse;

public class RequestActivity  extends Activity{
	ListView mListView;
	RequestAdapter mAdapter;
	ThumbnailAdapter mThumbnailAdapter; 
	public void onCreate(Bundle bundle){
		super.onCreate(bundle);
		setContentView(R.layout.activity_request);
		mListView = (ListView) findViewById(R.id.content);
		mAdapter = new RequestAdapter(this, DataWarehouse.sRequests);
		mThumbnailAdapter = new ThumbnailAdapter(this,mAdapter,((DPTApplication)getApplication()).getCache(),new int[]{R.id.icon});
		mListView.setAdapter(mThumbnailAdapter);
	}
}

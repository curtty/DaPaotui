package com.curtty.dapaotui;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import android.R.integer;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

import com.curtty.dapaotui.common.Constant;
import com.curtty.dapaotui.data.BaseData;
import com.curtty.dapaotui.data.Commodity;
import com.curtty.dapaotui.data.DataWarehouse;
import com.curtty.dapaotui.data.RequestData;
import com.curtty.dapaotui.data.User;
import com.curtty.dapaotui.web.Updater;
import com.curtty.dapaotui.web.UpdaterDelegate;
import com.curtty.dapaotui.web.UsersDownloader;
import com.curtty.dapaotui.web.UsersDownloaderDelegate;


public class SplashActivity extends Activity{
	
	public void onCreate(Bundle bundle){
		super.onCreate(bundle);
		ImageView img = new ImageView(this);
		img.setImageResource(R.drawable.welcome_img);
		img.setScaleType(ScaleType.FIT_XY);
		setContentView(img);
//		Timer timer = new Timer();
//		timer.schedule(new TimerTask() {
//			
//			@Override
//			public void run() {
//				finish();
//				
//			}
//		}, 2000);
		new Handler().postDelayed(new Runnable() {
			
			@Override
			public void run() {
				checkAuthed();				
			}
		}, 100);
	}
	private void checkAuthed(){
		SharedPreferences prefs = getSharedPreferences(Constant.USER_ACCOUNT_PREFS, MODE_PRIVATE);
		String user = prefs.getString(Constant.USER_ACCOUNT_PREFS_USER,null);
		String psw =  prefs.getString(Constant.USER_ACCOUNT_PREFS_PSW,null);
		new UsersDownloader(new UsersDownloaderDelegate() {
			
			@Override
			public void onUsersDownloadSuccess(UsersDownloader downloader,
					String announcementText, String announcementUrl) {
				if(checkData()){
					startActivity(new Intent(SplashActivity.this,MainActivity.class));					
				}else{
					downloadData();
				}
				
			}
			
			@Override
			public void onUsersDownloadStart(UsersDownloader downloader) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onUsersDownloadProgress(UsersDownloader downloader,
					Integer... progress) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onUsersDownloadFailure(UsersDownloader downloader,
					Exception exception) {
				// authentification failed, try login
				startActivity(new Intent(SplashActivity.this,LoginActivity.class));					
				
			}
		},user,psw).execute();
	}
	/**
	 * 
	 * @return true means there is already data, otherwise, no data, need to download
	 */
	private boolean checkData(){
		if(DataWarehouse.sRequests != null && DataWarehouse.sRequests.size() > 0){
			return true;
		}
		return false;
	}
	/**
	 * download request data and then go to MainActivity if successful
	 */
	private void downloadData(){
		DataWarehouse.sRequests = new DataWarehouse(new DummyUpdater());
		DataWarehouse.sRequests.update(new UpdaterDelegate() {
			
			@Override
			public void onUsersDownloadSuccess(ArrayList<BaseData> lst) {
				startActivity(new Intent(SplashActivity.this,MainActivity.class));
				
			}
			
			@Override
			public void onUsersDownloadStart() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onUsersDownloadProgress(Integer... progress) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onUsersDownloadFailure(Exception exception) {
				//this means there is something wrong
				finish();				
			}
		});
	}
}

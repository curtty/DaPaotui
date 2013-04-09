package com.curtty.dapaotui.common;

import android.R.integer;
import android.content.Intent;
import android.graphics.Bitmap;

public class Utils {
	public static final String timeString(long time){
		long diff = time-System.currentTimeMillis();
		if(diff <= 0){
			return "Expired";
		}
		long hour = diff/Constant.HOUR;
		long minute = (diff%Constant.HOUR)/Constant.MINUTE;
		return hour +" h " + minute + " m ";
	}
	public static final double distance(double lat1, double lon1, double lat2,
			double lon2) {
		double theta = lon1 - lon2;
		double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2))
				+ Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2))
				* Math.cos(deg2rad(theta));
		dist = Math.acos(dist);
		dist = rad2deg(dist);
		dist = dist * 60 * 1.1515;
		dist = dist * 1609.344;
		return dist;
	}
	public static final double deg2rad(double deg) {
		return (deg * Math.PI / 180.0);
	}

	public static final double rad2deg(double rad) {
		return (rad * 180.0 / Math.PI);
	}


	public static Intent getCropImageIntent(Bitmap data) {
		Intent intent = new Intent("com.android.camera.action.CROP");
		intent.setType("image/*");
		intent.putExtra("data", data);
		intent.putExtra("crop", "true");
		intent.putExtra("aspectX", 1);
		intent.putExtra("aspectY", 1);
		intent.putExtra("outputX", 128);
		intent.putExtra("outputY", 128);
		intent.putExtra("return-data", true);
		return intent;
	}

}

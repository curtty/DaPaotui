package com.curtty.dapaotui.database;

import org.json.JSONObject;

public class LocalData {
	
	private static String mLoginName;
	private static String mFirstName;
	private static String mLastName;
	private static JSONObject usersJsonArrayEntry;
	private static int version=0;
	
	public static void setLoginName(String loginName){
		if(version ==0){
			LocalData.mLoginName = loginName;
			versionControl();
		}
	}
	public static void setFirstName(String firstName){
		if(version ==0){
			LocalData.mFirstName = firstName;
			versionControl();
		}
	}
	public static void setLastName(String lastName){
		if(version ==0){
			LocalData.mLastName = lastName;
			versionControl();
		}
	}
	private static void versionControl(){
		if((LocalData.mLoginName != null)&&
			(LocalData.mFirstName != null)&&
			(LocalData.mLastName != null)&&
			LocalData.usersJsonArrayEntry!=null)
			version = 1;
	}
	
	public static String getLoginName(){
		return LocalData.mLoginName;
	}
	public static String getFirstName(){
		return LocalData.mFirstName;
	}
	public static String getLastName(){
		return LocalData.mLastName;
	}
	public static JSONObject getUsersJsonArrayEntry() {
		return LocalData.usersJsonArrayEntry;
	}
	public static void setUsersJsonArrayEntry(JSONObject usersJsonArrayEntry) {
		if(version ==0){
			LocalData.usersJsonArrayEntry = usersJsonArrayEntry;
			versionControl();
		}
		
	}

}

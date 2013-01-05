package com.curtty.dapaotui.data;

import android.os.Parcel;
import android.os.Parcelable;

public class User  extends BaseData implements Parcelable{
	private long uuid;
	private String name;
	private String nickName;
	private String strLonlat;
	private float evaluation; 
	private double[] lonlat = new double[2];
	private UserProfile profile;
	public static User ME;
	
	public UserProfile getProfile() {
		return profile;
	}

	public void setProfile(UserProfile profile) {
		this.profile = profile;
	}

	public long getUuid() {
		return uuid;
	}

	public void setUuid(long uuid) {
		this.uuid = uuid;
	}

	public float getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(float evaluation) {
		this.evaluation = evaluation;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getStrLonlat() {
		return strLonlat;
	}

	public void setStrLonlat(String strLonlat) {
		this.strLonlat = strLonlat;
		String[] lonlatsStrings = strLonlat.split(";");
		lonlat[0] = Double.parseDouble(lonlatsStrings[0]);
		lonlat[1] = Double.parseDouble(lonlatsStrings[1]);
	}

	public double[] getLonlat() {
		return lonlat;
	}
	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// TODO Auto-generated method stub
		
	}
	public static final Creator<User> CREATOR = new Creator<User>() {

		@Override
		public User createFromParcel(Parcel source) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public User[] newArray(int size) {
			// TODO Auto-generated method stub
			return null;
		}
	};
}

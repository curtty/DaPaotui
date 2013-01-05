package com.curtty.dapaotui.data;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * this class contains all the information of an item someone want to buy
 * @author Administrator
 *
 */
public class RequestData  extends BaseData implements Parcelable{
	
	/**
	 * image url of the icon 
	 */
	private String title;
	private long expired_time;
	private User publisher;
	private Commodity item;
	private float itemAmmount;
	private float curAmmount;
	private String itemUnit; 
	private float reward;
	//comment of part A
	private String comment;
	
	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// TODO Auto-generated method stub
		
	}
	
	public static final Creator<RequestData> CREATOR = new Creator<RequestData>() {

		@Override
		public RequestData createFromParcel(Parcel source) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public RequestData[] newArray(int size) {
			// TODO Auto-generated method stub
			return null;
		}
	};

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public long getExpired_time() {
		return expired_time;
	}

	public void setExpired_time(long expired_time) {
		this.expired_time = expired_time;
	}

	public User getPublisher() {
		return publisher;
	}

	public void setPublisher(User publisher) {
		this.publisher = publisher;
	}

	public Commodity getItem() {
		return item;
	}

	public void setItem(Commodity item) {
		this.item = item;
	}

	public float getItemAmmount() {
		return itemAmmount;
	}

	public void setItemAmmount(float itemAmmount) {
		this.itemAmmount = itemAmmount;
	}

	public float getCurAmmount() {
		return curAmmount;
	}

	public void setCurAmmount(float curAmmount) {
		this.curAmmount = curAmmount;
	}

	public String getItemUnit() {
		return itemUnit;
	}

	public void setItemUnit(String itemUnit) {
		this.itemUnit = itemUnit;
	}

	public float getReward() {
		return reward;
	}

	public void setReward(float reward) {
		this.reward = reward;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}

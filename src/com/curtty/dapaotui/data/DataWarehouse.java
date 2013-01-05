package com.curtty.dapaotui.data;

import java.util.ArrayList;

import com.curtty.dapaotui.web.Updater;
import com.curtty.dapaotui.web.UpdaterDelegate;


public class DataWarehouse extends ArrayList<BaseData> {
	private static final long serialVersionUID = -3520340719550382105L;
	private long lastUpdateTime = 0;
	private Updater mUpdater;
	public static DataWarehouse sRequests = null; 
	
	public DataWarehouse(Updater updater){
		mUpdater = updater;
	}
	
	public long getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(long lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	
	public void update(UpdaterDelegate delegate){
		if(mUpdater != null){
			mUpdater.update(this,delegate);
		}
	}
}

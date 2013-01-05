package com.curtty.dapaotui.web;

import java.util.ArrayList;

import com.curtty.dapaotui.data.BaseData;

public interface UpdaterDelegate {
	public abstract void onUsersDownloadStart();
	public abstract void onUsersDownloadProgress(Integer... progress);
	public abstract void onUsersDownloadSuccess(ArrayList<BaseData> lst);
	public abstract void onUsersDownloadFailure(Exception exception);
}

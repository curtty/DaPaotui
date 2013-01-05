package com.curtty.dapaotui.web;

public interface UsersDownloaderDelegate {
	
	public abstract void onUsersDownloadStart(UsersDownloader downloader);
	public abstract void onUsersDownloadProgress(UsersDownloader downloader, Integer... progress);
	public abstract void onUsersDownloadSuccess(UsersDownloader downloader, String announcementText, String announcementUrl);
	public abstract void onUsersDownloadFailure(UsersDownloader downloader, Exception exception);
}

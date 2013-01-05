package com.curtty.dapaotui;

import com.commonsware.cwac.cache.SimpleWebImageCache;
import com.commonsware.cwac.thumbnail.ThumbnailBus;
import com.commonsware.cwac.thumbnail.ThumbnailMessage;

import android.app.Application;

public class DPTApplication extends Application {

	public boolean mIsInitialLaunch;
	private ThumbnailBus mBus = new ThumbnailBus();
	private SimpleWebImageCache<ThumbnailBus, ThumbnailMessage> mCache = new SimpleWebImageCache<ThumbnailBus, ThumbnailMessage>(
			null, null, 101, mBus);

	@Override
	public void onCreate() {
		super.onCreate();
		mIsInitialLaunch = true;
	}

	public ThumbnailBus getBus() {
		return (mBus);
	}

	public SimpleWebImageCache<ThumbnailBus, ThumbnailMessage> getCache() {
		return (mCache);
	}

}

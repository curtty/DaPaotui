package com.curtty.dapaotui.web;

import com.curtty.dapaotui.data.BaseData;
import com.curtty.dapaotui.data.DataWarehouse;

public interface Updater {
	public void update(DataWarehouse datahouse,UpdaterDelegate delegate);
}

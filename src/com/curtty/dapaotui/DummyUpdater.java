package com.curtty.dapaotui;

import com.curtty.dapaotui.common.Constant;
import com.curtty.dapaotui.data.Commodity;
import com.curtty.dapaotui.data.DataWarehouse;
import com.curtty.dapaotui.data.RequestData;
import com.curtty.dapaotui.data.User;
import com.curtty.dapaotui.web.Updater;
import com.curtty.dapaotui.web.UpdaterDelegate;

public class DummyUpdater implements Updater{

	@Override
	public void update(DataWarehouse datahouse, UpdaterDelegate delegate) {

		// TODO: we need to download data from storageroomapp.com here, but for now, we use some dummy data
		datahouse.clear();
		if(delegate != null){
			delegate.onUsersDownloadStart();
		}
		final Commodity[] commodities = new Commodity[4];
		final User[] users = new User[5];
		final String[] units = new String[]{"kg", "g","one","piece"};
		double lon = 118;
		double lat = 32;
		User john = new User();
		john.setEvaluation(4.5f);
		john.setName("John");
		john.setNickName("John");
		john.setStrLonlat(lon+";"+lat);
		users[0] = john;
		User.ME = john;
		
		lon += Math.random()*10-5;
		lat += Math.random()*10-5;
		User Johnny = new User();
		Johnny.setEvaluation(4.5f);
		Johnny.setName("Johnny");
		Johnny.setNickName("Johnny");
		Johnny.setStrLonlat(lon+";"+lat);
		users[1] = Johnny;

		lon += Math.random()*10-5;
		lat += Math.random()*10-5;
		User Maria = new User();
		Maria.setEvaluation(4.5f);
		Maria.setName("Maria");
		Maria.setNickName("Maria");
		Maria.setStrLonlat(lon+";"+lat);
		users[2] = Maria;

		lon += Math.random()*10-5;
		lat += Math.random()*10-5;
		User Karl = new User();
		Karl.setEvaluation(4.5f);
		Karl.setName("John");
		Karl.setNickName("John");
		Karl.setStrLonlat(lon+";"+lat);
		users[3] = Karl;

		lon += Math.random()*10-5;
		lat += Math.random()*10-5;
		User Jack = new User();
		Jack.setEvaluation(4.5f);
		Jack.setName("Jack");
		Jack.setNickName("Jack");
		Jack.setStrLonlat(lon+";"+lat);
		users[4] = Jack;
		
		commodities[0] = new Commodity();
		commodities[0].setName("Apple");
		commodities[0].setIcon_url("http://fostertech.files.wordpress.com/2010/07/apple.jpg");

		commodities[1] = new Commodity();
		commodities[1].setName("Books");
		commodities[1].setIcon_url("http://www.phd2published.com/wp-content/uploads/2011/06/book.jpg");

		commodities[2] = new Commodity();
		commodities[2].setName("Flour");
		commodities[2].setIcon_url("http://2.bp.blogspot.com/-Mdecug6P8R0/TdJMcENlmrI/AAAAAAAADeE/b9EU5R7Rz2Y/s1600/flour.jpg");

		commodities[3] = new Commodity();
		commodities[3].setName("Toilet Paper");
		commodities[3].setIcon_url("http://toiletpaper-dispenser.net/wp-content/uploads/2011/08/11.jpg");

		
		
		for(int i =0;i<100;i++){
			RequestData data = new  RequestData();
			data.setTitle("Want Some "+commodities[i%commodities.length].getName());
			data.setComment("Who can do me this favour, I'll marry him");
			data.setExpired_time((long) (System.currentTimeMillis()+36*Constant.HOUR + Math.random()*60*Constant.MINUTE));
			data.setItemAmmount(1+i%10);
			data.setCurAmmount((float) (Math.random()*data.getItemAmmount()));
			data.setItem(commodities[i%commodities.length]);
			data.setItemUnit(units[i%units.length]);
			data.setPublisher(users[i%users.length]);
			data.setReward((float) Math.random());
			datahouse.add(data);
			delegate.onUsersDownloadProgress(i);
		}
		if(delegate != null){
			delegate.onUsersDownloadSuccess(datahouse);
		}
		
	}

}

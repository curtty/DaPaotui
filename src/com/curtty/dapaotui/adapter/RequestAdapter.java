package com.curtty.dapaotui.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.curtty.dapaotui.R;
import com.curtty.dapaotui.common.Utils;
import com.curtty.dapaotui.data.BaseData;
import com.curtty.dapaotui.data.RequestData;
import com.curtty.dapaotui.data.User;

public class RequestAdapter extends BaseAdapter{
	
	private Context mContext;
	private List<RequestData> mData = new ArrayList<RequestData>();
	
	public RequestAdapter(Context c,List<BaseData> data){
		for(BaseData bd:data){
			if(bd instanceof RequestData){
				mData.add((RequestData) bd);
			}
		}
		mContext = c;
	}
	@Override
	public int getCount() {
		return mData.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if(convertView == null){
			convertView = LayoutInflater.from(mContext).inflate(R.layout.view_request, null);
		}
		ImageView icon = (ImageView)convertView.findViewById(R.id.icon);
		TextView title = (TextView) convertView.findViewById(R.id.title);
		TextView name = (TextView) convertView.findViewById(R.id.name);
		RatingBar rating = (RatingBar) convertView.findViewById(R.id.rating);
		TextView remainTime = (TextView) convertView.findViewById(R.id.remain_time);
		TextView commodity = (TextView) convertView.findViewById(R.id.commodity);
		TextView progress = (TextView) convertView.findViewById(R.id.progress);
		TextView reward = (TextView) convertView.findViewById(R.id.reward);
		TextView distance = (TextView) convertView.findViewById(R.id.distance);
		RequestData data = mData.get(position);
		icon.setTag(data.getItem().getIcon_url());
		title.setText(data.getTitle());
		name.setText(data.getPublisher().getNickName());
		rating.setRating(data.getPublisher().getEvaluation());
		remainTime.setText(Utils.timeString(data.getExpired_time()));
		commodity.setText(data.getItem().getName()+" X "+data.getItemAmmount()+" " + data.getItemUnit());
		progress.setText(String.format("%.1f/%.1f", data.getCurAmmount(),data.getItemAmmount()));
		reward.setText(String.valueOf(data.getReward())+" EUR per " + data.getItemUnit());
		distance.setText(String.format("%.2fm", Utils.distance(data.getPublisher().getLonlat()[0], data.getPublisher().getLonlat()[1],
				User.ME.getLonlat()[0], User.ME.getLonlat()[1])));
		return convertView;
	}

}

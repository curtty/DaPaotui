package com.curtty.dapaotui.database;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.json.JSONArray;
import org.json.JSONObject;



import android.os.AsyncTask;
import android.util.Log;

public class UsersDownloader extends AsyncTask<Void, Integer, Boolean> {

	private UsersDownloaderDelegate mDelegate;
	private Exception mThrownException;
	private HttpGet mHttpRequest;
	private String mUserText;
	private String mUserUrl;
	private String mLoginName;
	private String mPassword;
	
	public UsersDownloader(UsersDownloaderDelegate delegate,String loginName,String password) {
		super();
		mDelegate = delegate;
		mLoginName = loginName;
		mPassword = password;
	}

	@Override
	protected void onPreExecute() {
		mDelegate.onUsersDownloadStart(this);
	}
	
	@Override
	protected Boolean doInBackground(Void... params) {
		boolean successful = downloadUsers();
		return successful;
	}
	
	@Override
	protected void onProgressUpdate(Integer... progress) {
		super.onProgressUpdate(progress);
		mDelegate.onUsersDownloadProgress(this, progress);
	}
	
	@Override
	protected void onPostExecute(Boolean successful) {
		if (successful) {
			mDelegate.onUsersDownloadSuccess(this, mUserText, mUserUrl);
		}
		else {
			mDelegate.onUsersDownloadFailure(this, mThrownException);
		}
	}
	
	@Override
	protected void onCancelled() {
		mHttpRequest.abort();
		Log.d(AppConfigInterface.TAG,"Task cancelled");
	}
	
	protected boolean downloadUsers() {
		HttpResponse httpResponse;
        HttpEntity httpEntity;
        HttpClient httpClient;
        HttpParams httpParameters;
        BufferedReader bufferedReader;
        String bufferedReaderLine;
        StringBuilder jsonResponseStringBuilder;
        String jsonResponseString = "";
        mThrownException = null;
		
		httpParameters = new BasicHttpParams();
		HttpConnectionParams.setConnectionTimeout(httpParameters, AppConfigInterface.timeoutConnection);			
		HttpConnectionParams.setSoTimeout(httpParameters, AppConfigInterface.timeoutSocket);

		httpClient = new DefaultHttpClient(httpParameters);
		String  url = AppConfigInterface.STORAGEROOM_USERS_URL;
        mHttpRequest = new HttpGet(url);
        
        if (!isCancelled())
        {
        	try {
	        	httpResponse = httpClient.execute(mHttpRequest);
	            httpEntity = httpResponse.getEntity();
	            bufferedReader = new BufferedReader(new InputStreamReader(httpEntity.getContent(), "UTF-8"));          
	            jsonResponseStringBuilder = new StringBuilder();
	            
	            while (((bufferedReaderLine = bufferedReader.readLine()) != null) && (!isCancelled())) {
	                jsonResponseStringBuilder.append(bufferedReaderLine);
	            }
	            bufferedReader.close();            
	            jsonResponseString = jsonResponseStringBuilder.toString();
				Log.d(AppConfigInterface.TAG, jsonResponseString);
	        }
        	catch (IOException e) {
	        	mThrownException = e;
	        	System.out.println(e.toString());
	        	return false;
	        }
        }	        
        
        if (!isCancelled()) {
        	try{
        		JSONObject usersJsonObject = new JSONObject(jsonResponseString);
				JSONObject usersJsonArrayObject = usersJsonObject.getJSONObject("array");
				JSONArray usersJsonArray = usersJsonArrayObject.getJSONArray("resources");	
				
				for(int i =0;i<usersJsonArray.length();i++){
					JSONObject usersJsonArrayEntry = usersJsonArray.getJSONObject(i);
					String l = usersJsonArrayEntry.getString("login_name");
					String p = usersJsonArrayEntry.getString("password");
					if((mLoginName.equals(l))
							&&(mPassword.equals(p))){
						//backup user informations.
						LocalData.setLoginName(mLoginName);
						LocalData.setFirstName(usersJsonArrayEntry.getString("first_name"));
						LocalData.setFirstName(usersJsonArrayEntry.getString("last_name"));
						LocalData.setUsersJsonArrayEntry(usersJsonArrayEntry);
						return true;
					}
//					mUserText = usersJsonArrayEntry.getString("text");
//					mUserUrl = usersJsonArrayEntry.getString("link");
				}
				return false;
	        }
        	catch (Exception e) {
	        	mThrownException = e;
	        	return false;
			}
        }
        return false;
	}

}

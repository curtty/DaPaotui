package com.curtty.dapaotui.database;

public interface AppConfigInterface {

	

	public static final String TAG = "User Login Task";

	public static final String BASE_URL = "http://api.storageroomapp.com/accounts/50cb320c0f6602589f000370/";
	public static final String PARAM_AUTH_TOKEN = "?auth_token=kE4y9iECrWwAGd6Nq38C";
	public static final String PARAM_SORT = "&sort=i_d";  
	public static final String PARAM_ORDER = "&order=desc";

	public static final String COLLECTIONS_ID_USERS = "collections/50cb94080f66026830001b4f/";
	public static final String JSON_FILENAME = "entries.json";
//	public static final String COLLECTIONS_ID_PACK = "collections/5062af6e0f66023119002aca/";
//	public static final String COLLECTIONS_ID_PROGRAMS = "collections/5062afa50f66026ae60005f5/";
//	public static final String COLLECTIONS_ID_TYPE = "collections/505c0a680f66023290002132/";
	public static final String STORAGEROOM_USERS_URL  = BASE_URL +COLLECTIONS_ID_USERS +JSON_FILENAME +PARAM_AUTH_TOKEN+PARAM_SORT+PARAM_ORDER+"&per_page=50";
	

	public static final int timeoutConnection = 15000;
	public static final int timeoutSocket = 15000;

//	public static final String[] IDTYPES = new String[]{
//		"ISBN","UPC","ASIN","SKU","EAN"
//	};
	

}

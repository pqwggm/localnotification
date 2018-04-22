package com.pqw.localnotificaion;

import org.json.JSONObject;
import org.json.JSONException;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import com.pqw.localnotificaion.notification.Manager;

public class LocalNotification {
    public static final String TAG = "pqw_local_notification";
	
	private static Context pContext;
    private static int counter;
	
	public static void init(Activity context){
	    Log.d(TAG, "init");
		pContext = context.getApplicationContext();
	}
	
	public static void pushMessage(String msg, long delay, int repeats ){
        Log.d(TAG, "pushMessage msg: " + msg + " delay(s): " + delay + " repeats: " + repeats);
        try {
            JSONObject dict = new JSONObject();
            dict.put("id", counter++);
            Log.d(TAG, "pushMessage id is: " + dict.getInt("id"));
            dict.put("text", msg);
            dict.put("at", System.currentTimeMillis() / 1000 + delay);
            // 设置通知栏的小图标为大航海的图标，对应res/drawable/icon.png
            dict.put("smallIcon", "icon");
            dict.put("sound", "res://platform_default");
            if (repeats == 1) {
                dict.put("every", "day");
            } else if (repeats == 2) {
                dict.put("every", "hour");
            } else if (repeats == 3) {
                dict.put("every", "minute");
            } else if (repeats == 4) {
                dict.put("every", "second");
            }
            Manager.getInstance(pContext).schedule(dict);
        } catch (JSONException e) {
            e.printStackTrace();
        }
	}
	
	public static void registerNotification( String uid ) {
	}
	
	public static void removeNotification() {
        Log.d(TAG, "removeNotification");
        counter = 0;
        Manager.getInstance(pContext).cancelAll();
	}

}

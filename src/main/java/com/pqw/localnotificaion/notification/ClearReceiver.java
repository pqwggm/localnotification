package com.pqw.localnotificaion.notification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class ClearReceiver extends BroadcastReceiver {

    /**
     * Called when the notification was cleared from the notification center.
     *
     * @param context
     *      Application context
     * @param intent
     *      Received intent with content data
     */
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(Notification.LOG_TAG, "ClearReceiver onReceive");
    }
}

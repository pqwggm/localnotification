package com.pqw.localnotificaion.notification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import org.json.JSONObject;
import java.util.List;

/**
 * Created by panqianwei on 2018/4/16.
 */

/**
 * This class is triggered upon reboot of the device. It needs to re-register
 * the alarms with the AlarmManager since these alarms are lost in case of
 * reboot.
 * for android 7.0 and above, you need to allow auto start when install the app
 */
public abstract class AbstractRestoreReceiver extends BroadcastReceiver {
    /**
     * Called on device reboot.
     *
     * @param context Application context
     * @param intent  Received intent with content data
     */
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(Notification.LOG_TAG, "reboot AbstractRestoreReceiver OnReceive action: " + intent.getAction());
        Manager mgr = Manager.getInstance(context);
        List<JSONObject> toasts = mgr.getOptions();

        for (JSONObject data : toasts) {
            Log.d(Notification.LOG_TAG, "after Reboot data: " + data.toString());
            Options options = new Options(context).parse(data);
            Builder builder = new Builder(options);
            Notification notification = buildNotification(builder);
            onRestore(notification);
        }
    }

    /**
     * Called when a local notification was restore.
     *
     * @param notification
     *      Wrapper around the local notification
     */
    abstract public void onRestore (Notification notification);

    /**
     * Build notification specified by options.
     *
     * @param builder
     *      Notification builder
     */
    abstract public Notification buildNotification (Builder builder);

}

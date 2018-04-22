package com.pqw.localnotificaion.notification;

/**
 * Created by panqianwei on 2018/4/16.
 */

public class RestoreReceiver extends AbstractRestoreReceiver {

    @Override
    public void onRestore(Notification notification) {
        notification.schedule(false);
    }

    @Override
    public Notification buildNotification(Builder builder) {
        return builder.setTriggerReceiver(TriggerReceiver.class)
                .build();
    }
}

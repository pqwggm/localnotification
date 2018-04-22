/*
 * Copyright (c) 2013-2015 by appPlant UG. All rights reserved.
 *
 * @APPPLANT_LICENSE_HEADER_START@
 *
 * This file contains Original Code and/or Modifications of Original Code
 * as defined in and that are subject to the Apache License
 * Version 2.0 (the 'License'). You may not use this file except in
 * compliance with the License. Please obtain a copy of the License at
 * http://opensource.org/licenses/Apache-2.0/ and read it before using this
 * file.
 *
 * The Original Code and all software distributed under the License are
 * distributed on an 'AS IS' basis, WITHOUT WARRANTY OF ANY KIND, EITHER
 * EXPRESS OR IMPLIED, AND APPLE HEREBY DISCLAIMS ALL SUCH WARRANTIES,
 * INCLUDING WITHOUT LIMITATION, ANY WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE, QUIET ENJOYMENT OR NON-INFRINGEMENT.
 * Please see the License for the specific language governing rights and
 * limitations under the License.
 *
 * @APPPLANT_LICENSE_HEADER_END@
 */

package com.pqw.localnotificaion.notification;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/**
 * The receiver activity is triggered when a notification is clicked by a user.
 * local notification and calls the event functions for further proceeding.
 */
public class ClickActivity extends Activity {

    /**
     * Called when local notification was clicked to launch the main intent.
     *
     * @param state
     *      Saved instance state
     */
    @Override
    public void onCreate (Bundle state) {
        super.onCreate(state);
        launchApp();
    }

    /**
     * Launch main intent from package.
     */
    public void launchApp() {
        Log.d(Notification.LOG_TAG, "launch app start");
        Context context = getApplicationContext();
        String pkgName  = context.getPackageName();
        Intent intent = context
                .getPackageManager()
                .getLaunchIntentForPackage(pkgName);
        intent.addFlags(
                Intent.FLAG_ACTIVITY_REORDER_TO_FRONT | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        context.startActivity(intent);
        // 干掉自己
        finish();
    }

}

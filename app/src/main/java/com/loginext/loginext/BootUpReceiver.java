package com.loginext.loginext;

/**
 * Created by Nitish on 19-11-2015.
 */
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;


public class BootUpReceiver extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {

        /***** For start Service  ****/
        Intent myIntent = new Intent(context, Locfetching.class);
        context.startService(myIntent);
    }

}
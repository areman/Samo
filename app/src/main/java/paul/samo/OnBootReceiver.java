package paul.samo;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.admin.DevicePolicyManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 *
 * @author André Kullmann
 */
public class OnBootReceiver extends BroadcastReceiver {

    /**
     * The password will be set to the childs password. So the device can be unlock by the child.
     *
     * @param context
     * @param intent
     */
    @Override
    public void onReceive(Context context, Intent intent) {

        Log.i("pweb", getClass().getSimpleName() + ".onReceive( " + intent.getAction() + " )");

        ComponentName admin = new ComponentName( context, OnDeviceAdminReceiver.class );
        Passwords.get(context)
                .setPassword(Constants.CHILD_PASSWORD)
                .setQuality(admin, DevicePolicyManager.PASSWORD_QUALITY_SOMETHING);

        Notify.get( context ).showIsReady();
    }

}
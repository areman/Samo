package paul.samo;

import android.app.admin.DeviceAdminReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsManager;
import android.util.Log;

/**
 * Used for uninstall protection. Samo must be a Device Admin.
 * In case the user tries to disable Samo as Device Admin, the device will be locked with Master Password.
 * On disable a SMS will be send.
 *
 * @author André Kullmann
 */
public class OnDeviceAdminReceiver extends DeviceAdminReceiver {

    @Override
    public CharSequence onDisableRequested(Context context, Intent intent) {

        Log.i("pweb", getClass().getSimpleName() + ".onDisableRequested( " + intent.getAction() + " )");

        Notify.get( context ).showIsLocked();

        Passwords.get(context).setPassword( Constants.MASTER_PASSWORD ).lock();

        return "warn";
    }

    @Override
    public void onDisabled(Context context, Intent intent) {

        Log.i("pweb", getClass().getSimpleName() + ".onDisabled( " + intent.getAction() + " )");

        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage( Constants.MY_PHONE, null, "Disable", null, null);
    }

}

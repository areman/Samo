package paul.samo;

import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;

/**
 * Helper to access the passwords.
 *
 * @author André Kullmann
 */
public class Passwords {

    public static Passwords get( Context context ) {
        return new Passwords( context );
    }

    private final Context context;

    private Passwords( Context context ) {
        this.context = context;
    }

    public void lock() {
        DevicePolicyManager dpm = dpm();
        dpm.lockNow();
    }

    public Passwords setQuality( ComponentName admin, int quality ) {

        dpm().setPasswordQuality(admin, quality);

        return this;
    }

    public Passwords setPassword( String password ) {

        DevicePolicyManager dpm = dpm();
        dpm.resetPassword(password, DevicePolicyManager.RESET_PASSWORD_REQUIRE_ENTRY );

        return this;
    }

    private DevicePolicyManager dpm() {
        return (DevicePolicyManager) ctx().getSystemService(Context.DEVICE_POLICY_SERVICE);
    }

    private Context ctx() {
        return context;
    }
}

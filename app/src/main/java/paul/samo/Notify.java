package paul.samo;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.NotificationCompat;

/**
 * Helper for different notifications.
 *
 * @author André Kullmann
 */
public class Notify {

    public static Notify get( Context context ) {
        return new Notify( context );
    }

    private final Context context;

    private Notify( Context context ) {
        this.context = context;
    }

    public void showIsLocked() {

        Resources r = context.getResources();
        show( r.getString( R.string.is_locked ) );
    }

    public void showIsReady() {

        Resources r = context.getResources();
        show(r.getString(R.string.is_ready));
    }

    private void show( String msg ) {

        SamoApplication app = SamoApplication.get( context );

        Resources r = context.getResources();
        Notification notification = new NotificationCompat.Builder(context)
                .setTicker("A")
                .setSmallIcon( android.R.drawable.ic_dialog_info)
                .setLargeIcon( app.icon() )
                .setContentTitle( r.getString( R.string.app_name ) )
                .setContentText( msg )
                .setAutoCancel(true)
                .setVisibility(Notification.VISIBILITY_PUBLIC)
                .build();

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE );
        notificationManager.notify(0, notification);
    }

}

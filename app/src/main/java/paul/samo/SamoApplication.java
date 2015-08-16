package paul.samo;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

/**
 *
 * @author André Kullmann
 */
public class SamoApplication extends Application {

    public static SamoApplication get( Context context ) {
        return (SamoApplication) context.getApplicationContext();
    }

    /**
     *
     * @return the app icon as bitmap.
     */
    public Bitmap icon() {
        Drawable icon = getPackageManager().getApplicationIcon(getApplicationInfo());
        return ((BitmapDrawable)icon).getBitmap();
    }
}

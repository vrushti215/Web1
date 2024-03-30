package com.example.assignment_1.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

public class InternetAccessUtility {

    /**
     * Opens a web page in a web browser.
     *
     * @param context The Context from which the intent is started.
     * @param url     The web page URL to open.
     */
    public static void openWebPage(Context context, String url) {
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);

        // Check if there's an app that can handle this intent
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            context.startActivity(intent);
        } else {
            Toast.makeText(context, "No application can handle this request. Please install a web browser.", Toast.LENGTH_LONG).show();
        }
    }

    /**
     * Opens a location in a map app.
     *
     * @param context The Context from which the intent is started.
     * @param lat     The latitude of the location.
     * @param lon     The longitude of the location.
     */
    public static void openMap(Context context, double lat, double lon) {
        Uri location = Uri.parse("geo:" + lat + "," + lon + "?z=14"); // z parameter is zoom level
        Intent intent = new Intent(Intent.ACTION_VIEW, location);

        // Check if there's an app that can handle this intent
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            context.startActivity(intent);
        } else {
            Toast.makeText(context, "No application can handle this request. Please install a map application.", Toast.LENGTH_LONG).show();
        }
    }
}


package com.edamametech.android.DropMemo;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;
import android.widget.RemoteViews;


public class DropMemoAppWidgetProvider extends AppWidgetProvider {
    String directory = Environment.getExternalStoragePublicDirectory(
            Environment.DIRECTORY_DOWNLOADS).toString();

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        final int NWidgets = appWidgetIds.length;
        for (int i = 0; i < NWidgets; i++) {
            int appWidgetId = appWidgetIds[i];
            Intent intent = new Intent(Intent.ACTION_EDIT);
            intent.setDataAndType(Uri.parse("file:/" + directory + "/dropmemo.txt"), "text/plain");
            Log.v("DropMemo", intent.toString());
            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);
            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.main);
            views.setOnClickPendingIntent(R.id.widget_button, pendingIntent);
            appWidgetManager.updateAppWidget(appWidgetId, views);
        }
        super.onUpdate(context, appWidgetManager, appWidgetIds);
    }
}

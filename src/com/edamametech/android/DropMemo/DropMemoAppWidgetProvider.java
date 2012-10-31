
package com.edamametech.android.DropMemo;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import android.widget.RemoteViews;

public class DropMemoAppWidgetProvider extends AppWidgetProvider {
    final String DropBoxNewTextAction = android.content.Intent.ACTION_GET_CONTENT;
    final String DropBoxPackageName = "com.dropbox.android";
    final ComponentName DropBoxNewTextComponent = new ComponentName("com.dropbox.android",
            ".activity.TextEditActivity");

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        PackageManager packageManager = context.getPackageManager();
        final int NWidgets = appWidgetIds.length;
        for (int i = 0; i < NWidgets; i++) {
            int appWidgetId = appWidgetIds[i];
            Intent intent = packageManager.getLaunchIntentForPackage(DropBoxPackageName);
            //intent.setAction(DropBoxNewTextAction);
            //intent.setComponent(DropBoxNewTextComponent);
            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);
            
            try {
                Log.v("DropMemo", packageManager.getReceiverInfo(DropBoxNewTextComponent, 0).toString());
            } catch (NameNotFoundException e) {
                Log.e("DropMemo", e.toString());    /* DropBoxNewTextComponent is not found on Nexus One */
            }
            
            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.main);
            views.setOnClickPendingIntent(R.id.button, pendingIntent);
            appWidgetManager.updateAppWidget(appWidgetId, views);
        }
        super.onUpdate(context, appWidgetManager, appWidgetIds);
    }
}

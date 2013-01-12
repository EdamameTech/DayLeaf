
package com.edamametech.android.DropMemo;

import java.util.Date;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

public class DropMemoAppWidgetProvider extends AppWidgetProvider {
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        final int NWidgets = appWidgetIds.length;
        DropMemoUtil.FilePath path = new DropMemoUtil.FilePath(new Date());
        Intent intent = new Intent(Intent.ACTION_EDIT);
        intent.setDataAndType(path.uri(), "text/plain");
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.main);
        for (int i = 0; i < NWidgets; i++) {
            int appWidgetId = appWidgetIds[i];
            views.setOnClickPendingIntent(R.id.widget_button, pendingIntent);
            views.setTextViewText(R.id.widget_label, path.directoryName() + "/\n"
                    + path.filename());
            views.setOnClickPendingIntent(R.id.widget_label, pendingIntent);
            appWidgetManager.updateAppWidget(appWidgetId, views);
        }
        super.onUpdate(context, appWidgetManager, appWidgetIds);
    }
}

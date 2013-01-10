
package com.edamametech.android.DropMemo;

import java.util.Date;
import java.text.SimpleDateFormat;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.widget.RemoteViews;

public class DropMemoAppWidgetProvider extends AppWidgetProvider {
    final String filenameFormat = "yyMMdd'.txt'";
    SimpleDateFormat filenameFormatter = new SimpleDateFormat(filenameFormat);
    String directory = Environment.getExternalStoragePublicDirectory(
            Environment.DIRECTORY_DOWNLOADS).toString();
    String[] directoryNameAry = directory.split("/");
    String directoryName = directoryNameAry[directoryNameAry.length - 1];

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        final int NWidgets = appWidgetIds.length;
        String currentFilename = filename(new Date());
        Intent intent = new Intent(Intent.ACTION_EDIT);
        intent.setDataAndType(Uri.parse("file:/" + directory + "/" + currentFilename), "text/plain");
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);
        for (int i = 0; i < NWidgets; i++) {
            int appWidgetId = appWidgetIds[i];
            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.main);
            views.setOnClickPendingIntent(R.id.widget_button, pendingIntent);
            views.setTextViewText(R.id.widget_label, directoryName + "/\n" + currentFilename);
            views.setOnClickPendingIntent(R.id.widget_label, pendingIntent);
            appWidgetManager.updateAppWidget(appWidgetId, views);
        }
        super.onUpdate(context, appWidgetManager, appWidgetIds);
    }

    String filename(Date date) {
        return filenameFormatter.format(date);
    }
}

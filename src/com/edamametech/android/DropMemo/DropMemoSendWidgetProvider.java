
package com.edamametech.android.DropMemo;

import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;

import java.util.Date;

public class DropMemoSendWidgetProvider extends DropMemoWidgetProvider {
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        path = new DropMemoUtil.FilePath(new Date());
        intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_STREAM, path.uri());
        layout = R.layout.send;
        super.onUpdate(context, appWidgetManager, appWidgetIds);
    }
}

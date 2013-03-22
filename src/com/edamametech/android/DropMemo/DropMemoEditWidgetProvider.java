
package com.edamametech.android.DropMemo;

import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;

import java.util.Date;

public class DropMemoEditWidgetProvider extends DropMemoWidgetProvider {
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        path = new DropMemoUtil.FilePath(new Date());
        intent = new Intent(Intent.ACTION_EDIT);
        intent.setDataAndType(path.uri(), "text/plain");
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        layout = R.layout.edit;
        super.onUpdate(context, appWidgetManager, appWidgetIds);
    }
}

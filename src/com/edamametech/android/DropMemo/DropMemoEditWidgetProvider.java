
package com.edamametech.android.DropMemo;

import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;

public class DropMemoEditWidgetProvider extends DropMemoWidgetProvider {
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        intent = new Intent(Intent.ACTION_EDIT);
        layout = R.layout.edit;
        super.onUpdate(context, appWidgetManager, appWidgetIds);
    }
}

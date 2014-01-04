
package com.edamametech.android.DayLeaf;

import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;

import java.util.Date;

public class DayLeafSendWidgetProvider extends DayLeafWidgetProvider {
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        path = new DayLeafUtil.FilePath(new Date());
        intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_STREAM, path.uri());
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        layout = R.layout.send;
        super.onUpdate(context, appWidgetManager, appWidgetIds);
    }
}


package com.edamametech.android.DayLeaf;

import android.net.Uri;
import android.os.Environment;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DayLeafUtil {
    static public class FilePath {
        private final String filenameFormat = "yyMMdd'.txt'";
        private final SimpleDateFormat filenameFormatter = new SimpleDateFormat(filenameFormat);
        Date date;

        FilePath(Date d) {
            date = d;
        }

        String directory() {
            return Environment.getExternalStoragePublicDirectory(
                    Environment.DIRECTORY_DOWNLOADS).toString();
        }

        String filename() {
            return filenameFormatter.format(date);
        }

        String directoryName() {
            String[] directoryNameAry = directory().split("/");
            return directoryNameAry[directoryNameAry.length - 1];
        }

        Uri uri() {
            return Uri.parse("file://" + directory() + "/" + filename());
        }
    }

}

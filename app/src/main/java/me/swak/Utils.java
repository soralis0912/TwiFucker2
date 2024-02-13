package me.swak;

import android.net.Uri;
import android.preference.PreferenceManager;
import android.util.Log;

/* loaded from: classes8.dex */
@Deprecated
public class Utils {
    public static Uri changeHost(Uri uri) {
        return Uri.parse("https://" + Pref.urlHostName() + uri.getPath());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String getPref(String str, String str2) {
        try {
            return PreferenceManager.getDefaultSharedPreferences(StartApp.ctx).getString(str, str2);
        } catch (ClassCastException e) {
            logger(e.toString());
            return str2;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean getPref(String str, boolean z) {
        try {
            return PreferenceManager.getDefaultSharedPreferences(StartApp.ctx).getBoolean(str, z);
        } catch (ClassCastException e) {
            logger(e.toString());
            return z;
        }
    }

    public static void logger(String str) {
        Log.d("swkLog", str);
    }

    public static void logItem(String str, long j) {
        Log.e("SwakLog", str + " = " + j);
    }
}

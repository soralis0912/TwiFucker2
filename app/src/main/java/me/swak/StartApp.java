package me.swak;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

/* loaded from: classes8.dex */
public class StartApp {
    @SuppressLint({"StaticFieldLeak"})
    public static Context ctx;

    public static void setContext(Application application) {
        ctx = application;
    }
}

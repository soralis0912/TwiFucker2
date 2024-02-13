package me.swak;

import android.content.Intent;
import me.swak.myprefscreen.SettingsActivity;

/* loaded from: classes8.dex */
@Deprecated
public final class AdvancedSettings {
    public AdvancedSettings() {
    }

    public static void startMySettings() {
        Intent intent = new Intent(StartApp.ctx, SettingsActivity.class);
        intent.addFlags(268435456);
        StartApp.ctx.startActivity(intent);
    }
}

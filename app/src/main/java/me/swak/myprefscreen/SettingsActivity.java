package me.swak.myprefscreen;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import org.soralis_0912.twifucker2.R;

/* loaded from: classes8.dex */
@Deprecated
public class SettingsActivity extends PreferenceActivity {
    @Override // android.preference.PreferenceActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getFragmentManager().beginTransaction().add(16908290, new MyScreen()).commit();
    }

    /* loaded from: classes8.dex */
    public static class MyScreen extends PreferenceFragment {
        @Override // android.preference.PreferenceFragment, android.app.Fragment
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            addPreferencesFromResource(R.xml.mod_settings);
        }
    }
}

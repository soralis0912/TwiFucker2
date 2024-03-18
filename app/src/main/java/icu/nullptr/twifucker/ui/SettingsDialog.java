package icu.nullptr.twifucker.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceGroup;
import android.preference.SwitchPreference;
import androidx.documentfile.provider.DocumentFile;
import com.github.kyuubiran.ezxhelper.AndroidLogger;
import com.github.kyuubiran.ezxhelper.EzXHelper;
import com.github.kyuubiran.ezxhelper.Log;
import com.github.kyuubiran.ezxhelper.misc.Utils;
import com.tencent.mmkv.MMKV;
import icu.nullptr.twifucker.UtilsKt;
import icu.nullptr.twifucker.data.TwitterItem;
import icu.nullptr.twifucker.hook.DrawerNavbarHook;
import icu.nullptr.twifucker.ui.SettingsDialog;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.soralis_0912.twifucker2.BuildConfig;
import org.soralis_0912.twifucker2.HookEntry;
import org.soralis_0912.twifucker2.R;
/* compiled from: SettingsDialog.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00072\u00020\u0001:\u0002\u0007\bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\t"}, d2 = {"Licu/nullptr/twifucker/ui/SettingsDialog;", "Landroid/app/AlertDialog$Builder;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "deleteFromDatabase", "", "Companion", "PrefsFragment", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SettingsDialog extends AlertDialog.Builder {
    public static final Companion Companion = new Companion(null);
    public static final String PREFS_NAME = "twifucker";
    public static final String PREF_ABOUT = "about";
    public static final String PREF_CLEAR_LOG = "clear_log";
    public static final String PREF_DELETE_DATABASES = "delete_databases";
    public static final String PREF_DISABLE_PROMOTED_CONTENT = "disable_promoted_content";
    public static final String PREF_DOWNLOAD_DIRECTORY = "download_directory";
    public static final String PREF_ENABLE_LOG = "enable_log";
    public static final String PREF_EXPORT_JSON_LOG = "export_json_log";
    public static final String PREF_EXPORT_LOG = "export_log";
    public static final String PREF_FEATURE_SWITCH = "feature_switch";
    public static final String PREF_HIDDEN_BOTTOM_NAVBAR_ITEMS = "hidden_bottom_navbar_items";
    public static final String PREF_HIDDEN_DRAWER_ITEMS = "hidden_drawer_items";
    public static final String PREF_HIDE_BOTTOM_NAVBAR_ITEMS = "hide_bottom_navbar_items";
    public static final String PREF_HIDE_DRAWER_ITEMS = "hide_drawer_items";
    public static final String PREF_VERSION = "version";
    public static final int REQUEST_EXPORT_JSON_LOG = 1002;
    public static final int REQUEST_EXPORT_LOG = 1001;
    public static final int REQUEST_SET_DOWNLOAD_DIRECTORY = 1003;
    private static AlertDialog outDialog;
    private static SharedPreferences prefs;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsDialog(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        EzXHelper.addModuleAssetPath(context);
        final Activity act = (Activity) context;
        final SettingsDialog $this$_init__u24lambda_u242 = this;
        PrefsFragment prefsFragment = new PrefsFragment();
        act.getFragmentManager().beginTransaction().add(prefsFragment, "settings").commit();
        act.getFragmentManager().executePendingTransactions();
        prefsFragment.onActivityCreated(null);
        $this$_init__u24lambda_u242.setView(prefsFragment.getView());
        $this$_init__u24lambda_u242.setTitle(context.getString(R.string.twifucker_settings));
        $this$_init__u24lambda_u242.setPositiveButton(context.getString(R.string.save_restart), new DialogInterface.OnClickListener() { // from class: icu.nullptr.twifucker.ui.SettingsDialog$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                SettingsDialog.lambda$2$lambda$1(SettingsDialog.this, act, dialogInterface, i);
            }
        });
        $this$_init__u24lambda_u242.setNegativeButton(context.getString(R.string.settings_dismiss), (DialogInterface.OnClickListener) null);
        $this$_init__u24lambda_u242.setCancelable(false);
        AlertDialog show = $this$_init__u24lambda_u242.show();
        Intrinsics.checkNotNullExpressionValue(show, "run(...)");
        outDialog = show;
    }

    /* compiled from: SettingsDialog.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0014X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Licu/nullptr/twifucker/ui/SettingsDialog$Companion;", "", "()V", "PREFS_NAME", "", "PREF_ABOUT", "PREF_CLEAR_LOG", "PREF_DELETE_DATABASES", "PREF_DISABLE_PROMOTED_CONTENT", "PREF_DOWNLOAD_DIRECTORY", "PREF_ENABLE_LOG", "PREF_EXPORT_JSON_LOG", "PREF_EXPORT_LOG", "PREF_FEATURE_SWITCH", "PREF_HIDDEN_BOTTOM_NAVBAR_ITEMS", "PREF_HIDDEN_DRAWER_ITEMS", "PREF_HIDE_BOTTOM_NAVBAR_ITEMS", "PREF_HIDE_DRAWER_ITEMS", "PREF_VERSION", "REQUEST_EXPORT_JSON_LOG", "", "REQUEST_EXPORT_LOG", "REQUEST_SET_DOWNLOAD_DIRECTORY", "outDialog", "Landroid/app/AlertDialog;", "prefs", "Landroid/content/SharedPreferences;", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private final void deleteFromDatabase() {
        boolean disablePromotedContent = UtilsKt.getModulePrefs().getBoolean(PREF_DISABLE_PROMOTED_CONTENT, true);
        if (disablePromotedContent) {
            Regex re = new Regex("^\\d+-\\d+(-versioncode-\\d+)?.db$");
            int count = 0;
            Object[] databaseList = getContext().databaseList();
            Intrinsics.checkNotNullExpressionValue(databaseList, "databaseList(...)");
            Object[] $this$forEach$iv = databaseList;
            for (Object element$iv : $this$forEach$iv) {
                String db = (String) element$iv;
                Intrinsics.checkNotNull(db);
                if (re.matches(db)) {
                    SQLiteDatabase database = SQLiteDatabase.openDatabase(getContext().getDatabasePath(db).getAbsolutePath(), null, 0);
                    count += database.delete("timeline", "entity_id LIKE ?", new String[]{"promoted%"});
                    database.close();
                }
            }
            if (count > 0) {
                String string = getContext().getString(R.string.deleted_n_promoted_tweet, Integer.valueOf(count));
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                AndroidLogger.toast$default(string, 0, 2, null);
            }
        }
    }

    /* compiled from: SettingsDialog.kt */
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\"\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0017J\u0012\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0017J\b\u0010\u0015\u001a\u00020\u0006H\u0002J\b\u0010\u0016\u001a\u00020\u0006H\u0002J\u001c\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0017J\u0012\u0010\u001d\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0017J\b\u0010\u001e\u001a\u00020\u0006H\u0002¨\u0006\u001f"}, d2 = {"Licu/nullptr/twifucker/ui/SettingsDialog$PrefsFragment;", "Landroid/preference/PreferenceFragment;", "Landroid/preference/Preference$OnPreferenceChangeListener;", "Landroid/preference/Preference$OnPreferenceClickListener;", "()V", "clearLog", "", "deleteDatabases", "exportLog", "logType", "", "fileName", "", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCustomizeHiddenBottomNavbarItems", "onCustomizeHiddenDrawerItems", "onPreferenceChange", "", "p0", "Landroid/preference/Preference;", "p1", "", "onPreferenceClick", "refreshDownloadDirectory", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class PrefsFragment extends PreferenceFragment implements Preference.OnPreferenceChangeListener, Preference.OnPreferenceClickListener {
        @Override // android.preference.PreferenceFragment, android.app.Fragment
        @Deprecated(message = "Deprecated in Java")
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.settings_dialog);
            int preferenceCount = getPreferenceScreen().getPreferenceCount();
            for (int i = 0; i < preferenceCount; i++) {
                Preference p = getPreferenceScreen().getPreference(i);
                if (p instanceof SwitchPreference) {
                    if (UtilsKt.getModulePrefs().containsKey(((SwitchPreference) p).getKey())) {
                        ((SwitchPreference) p).setChecked(UtilsKt.getModulePrefs().getBoolean(((SwitchPreference) p).getKey(), false));
                    }
                    ((SwitchPreference) p).setOnPreferenceChangeListener(this);
                } else if (p != null) {
                    p.setOnPreferenceClickListener(this);
                }
                if (p instanceof PreferenceGroup) {
                    int preferenceCount2 = ((PreferenceGroup) p).getPreferenceCount();
                    for (int j = 0; j < preferenceCount2; j++) {
                        Preference p2 = ((PreferenceGroup) p).getPreference(j);
                        if (p2 instanceof SwitchPreference) {
                            if (UtilsKt.getModulePrefs().containsKey(((SwitchPreference) p2).getKey())) {
                                ((SwitchPreference) p2).setChecked(UtilsKt.getModulePrefs().getBoolean(((SwitchPreference) p2).getKey(), false));
                            }
                            ((SwitchPreference) p2).setOnPreferenceChangeListener(this);
                        } else if (p2 != null) {
                            p2.setOnPreferenceClickListener(this);
                        }
                    }
                }
            }
            refreshDownloadDirectory();
            findPreference(SettingsDialog.PREF_VERSION).setSummary("1.1 (1)");
            if (BuildConfig.DEBUG) {
                findPreference(SettingsDialog.PREF_DELETE_DATABASES).setEnabled(true);
            }
        }

        private final void refreshDownloadDirectory() {
            DocumentFile fromTreeUri;
            Uri uri2;
            String str = null;
            String downloadDirectory = UtilsKt.getModulePrefs().getString(SettingsDialog.PREF_DOWNLOAD_DIRECTORY, null);
            if (downloadDirectory == null) {
                findPreference(SettingsDialog.PREF_DOWNLOAD_DIRECTORY).setSummary("");
                return;
            }
            Uri uri1 = Uri.parse(downloadDirectory);
            if (uri1 != null && (fromTreeUri = DocumentFile.fromTreeUri(getContext(), uri1)) != null && (uri2 = fromTreeUri.getUri()) != null) {
                Preference findPreference = findPreference(SettingsDialog.PREF_DOWNLOAD_DIRECTORY);
                String path = uri2.getPath();
                if (path != null) {
                    Intrinsics.checkNotNull(path);
                    List split$default = StringsKt.split$default((CharSequence) path, new String[]{":"}, false, 0, 6, (Object) null);
                    if (split$default != null) {
                        str = (String) CollectionsKt.last((List<? extends Object>) split$default);
                    }
                }
                findPreference.setSummary(str);
            }
        }

        @Override // android.preference.Preference.OnPreferenceChangeListener
        @Deprecated(message = "Deprecated in Java")
        public boolean onPreferenceChange(Preference p0, Object p1) {
            if (p0 instanceof SwitchPreference) {
                MMKV modulePrefs = UtilsKt.getModulePrefs();
                String key = ((SwitchPreference) p0).getKey();
                Intrinsics.checkNotNull(p1, "null cannot be cast to non-null type kotlin.Boolean");
                modulePrefs.putBoolean(key, ((Boolean) p1).booleanValue());
                if (Intrinsics.areEqual(((SwitchPreference) p0).getKey(), SettingsDialog.PREF_ENABLE_LOG) && !((Boolean) p1).booleanValue()) {
                    clearLog();
                    return true;
                }
                return true;
            }
            return true;
        }

        @Override // android.preference.Preference.OnPreferenceClickListener
        @Deprecated(message = "Deprecated in Java")
        public boolean onPreferenceClick(Preference p0) {
            String key = p0 != null ? p0.getKey() : null;
            if (key != null) {
                switch (key.hashCode()) {
                    case -1907550051:
                        if (key.equals(SettingsDialog.PREF_FEATURE_SWITCH)) {
                            Context context = getContext();
                            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                            new FeatureSwitchDialog(context);
                            return true;
                        }
                        return true;
                    case -1850535016:
                        if (key.equals(SettingsDialog.PREF_EXPORT_JSON_LOG)) {
                            String name = UtilsKt.getLogJsonFile().getName();
                            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                            exportLog(1002, name);
                            return true;
                        }
                        return true;
                    case -1270572462:
                        if (key.equals(SettingsDialog.PREF_CLEAR_LOG)) {
                            clearLog();
                            return true;
                        }
                        return true;
                    case -1069431612:
                        if (key.equals(SettingsDialog.PREF_DELETE_DATABASES)) {
                            deleteDatabases();
                            return true;
                        }
                        return true;
                    case 176847:
                        if (key.equals(SettingsDialog.PREF_HIDE_DRAWER_ITEMS)) {
                            onCustomizeHiddenDrawerItems();
                            return true;
                        }
                        return true;
                    case 92611469:
                        if (key.equals(SettingsDialog.PREF_ABOUT)) {
                            getActivity().startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://github.com/Dr-TSNG/TwiFucker")));
                            return true;
                        }
                        return true;
                    case 209513529:
                        if (key.equals(SettingsDialog.PREF_EXPORT_LOG)) {
                            String name2 = UtilsKt.getLogFile().getName();
                            Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
                            exportLog(1001, name2);
                            return true;
                        }
                        return true;
                    case 1314340328:
                        if (key.equals(SettingsDialog.PREF_HIDE_BOTTOM_NAVBAR_ITEMS)) {
                            onCustomizeHiddenBottomNavbarItems();
                            return true;
                        }
                        return true;
                    case 1872811894:
                        if (key.equals(SettingsDialog.PREF_DOWNLOAD_DIRECTORY)) {
                            Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT_TREE");
                            startActivityForResult(intent, 1003);
                            return true;
                        }
                        return true;
                    default:
                        return true;
                }
            }
            return true;
        }

        @Override // android.preference.PreferenceFragment, android.app.Fragment
        @Deprecated(message = "Deprecated in Java")
        public void onActivityResult(int requestCode, int resultCode, Intent data) {
            Uri uri;
            OutputStream openOutputStream;
            Uri uri2;
            switch (requestCode) {
                case 1001:
                case 1002:
                    if (resultCode == -1 && data != null && (uri = data.getData()) != null && (openOutputStream = getContext().getContentResolver().openOutputStream(uri)) != null) {
                        OutputStream outputStream = openOutputStream;
                        try {
                            OutputStream out = outputStream;
                            switch (requestCode) {
                                case 1001:
                                    FileInputStream fileInputStream = new FileInputStream(UtilsKt.getLogFile());
                                    FileInputStream input = fileInputStream;
                                    Intrinsics.checkNotNull(out);
                                    Long.valueOf(ByteStreamsKt.copyTo$default(input, out, 0, 2, null));
                                    CloseableKt.closeFinally(fileInputStream, null);
                                    break;
                                case 1002:
                                    FileInputStream fileInputStream2 = new FileInputStream(UtilsKt.getLogJsonFile());
                                    FileInputStream input2 = fileInputStream2;
                                    Intrinsics.checkNotNull(out);
                                    Long.valueOf(ByteStreamsKt.copyTo$default(input2, out, 0, 2, null));
                                    CloseableKt.closeFinally(fileInputStream2, null);
                                    break;
                                default:
                                    Unit unit = Unit.INSTANCE;
                                    break;
                            }
                            CloseableKt.closeFinally(outputStream, null);
                            return;
                        } catch (Throwable th) {
                            try {
                                throw th;
                            } catch (Throwable th2) {
                                CloseableKt.closeFinally(outputStream, th);
                                throw th2;
                            }
                        }
                    }
                    return;
                case 1003:
                    if (resultCode != -1) {
                        UtilsKt.getModulePrefs().remove(SettingsDialog.PREF_DOWNLOAD_DIRECTORY);
                        refreshDownloadDirectory();
                        return;
                    }
                    if (data != null && (uri2 = data.getData()) != null) {
                        getContext().getContentResolver().takePersistableUriPermission(uri2, 3);
                        UtilsKt.getModulePrefs().putString(SettingsDialog.PREF_DOWNLOAD_DIRECTORY, uri2.toString());
                    }
                    refreshDownloadDirectory();
                    return;
                default:
                    super.onActivityResult(requestCode, resultCode, data);
                    return;
            }
        }

        private final void deleteDatabases() {
            Regex re = new Regex("^\\d+-\\d+(-versioncode-\\d+)?.db$");
            int count = 0;
            Object[] databaseList = getContext().databaseList();
            Intrinsics.checkNotNullExpressionValue(databaseList, "databaseList(...)");
            Object[] $this$forEach$iv = databaseList;
            for (Object element$iv : $this$forEach$iv) {
                String db = (String) element$iv;
                Intrinsics.checkNotNull(db);
                if (re.matches(db)) {
                    getContext().deleteDatabase(db);
                    count++;
                }
            }
            if (count > 0) {
                String string = getContext().getString(R.string.deleted_n_database, Integer.valueOf(count));
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                AndroidLogger.toast$default(string, 0, 2, null);
            }
        }

        private final void exportLog(int logType, String fileName) {
            switch (logType) {
                case 1001:
                    if (!UtilsKt.getLogFile().exists()) {
                        return;
                    }
                    break;
                case 1002:
                    if (!UtilsKt.getLogJsonFile().exists()) {
                        return;
                    }
                    break;
                default:
                    return;
            }
            Intent intent = new Intent("android.intent.action.CREATE_DOCUMENT");
            intent.setType("text/plain");
            intent.addCategory("android.intent.category.OPENABLE");
            intent.putExtra("android.intent.extra.TITLE", fileName);
            try {
                startActivityForResult(intent, logType);
            } catch (Throwable t) {
                Log.e$default(t, (String) null, 2, (Object) null);
            }
        }

        private final void clearLog() {
            try {
                if (HookEntry.Companion.isLogcatProcessInitialized()) {
                    HookEntry.Companion.getLogcatProcess().destroy();
                }
                FilesKt.deleteRecursively(UtilsKt.getLogFileDir());
                UtilsKt.getLogFileDir().delete();
            } catch (Throwable t) {
                Log.e$default(t, (String) null, 2, (Object) null);
            }
        }

        private final void onCustomizeHiddenDrawerItems() {
            AlertDialog.Builder $this$onCustomizeHiddenDrawerItems_u24lambda_u2414 = new AlertDialog.Builder(getActivity());
            final List items = DrawerNavbarHook.INSTANCE.getDrawerItems();
            List $this$map$iv = items;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                TwitterItem it = (TwitterItem) item$iv$iv;
                destination$iv$iv.add(it.getKey());
            }
            Collection thisCollection$iv = (List) destination$iv$iv;
            String[] ids = (String[]) thisCollection$iv.toArray(new String[0]);
            $this$onCustomizeHiddenDrawerItems_u24lambda_u2414.setTitle(R.string.hide_drawer_items);
            $this$onCustomizeHiddenDrawerItems_u24lambda_u2414.setPositiveButton(R.string.save, new DialogInterface.OnClickListener() { // from class: icu.nullptr.twifucker.ui.SettingsDialog$PrefsFragment$$ExternalSyntheticLambda3
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    SettingsDialog.PrefsFragment.onCustomizeHiddenDrawerItems$lambda$14$lambda$11(items, dialogInterface, i);
                }
            });
            $this$onCustomizeHiddenDrawerItems_u24lambda_u2414.setNeutralButton(R.string.reset, new DialogInterface.OnClickListener() { // from class: icu.nullptr.twifucker.ui.SettingsDialog$PrefsFragment$$ExternalSyntheticLambda4
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    SettingsDialog.PrefsFragment.onCustomizeHiddenDrawerItems$lambda$14$lambda$12(dialogInterface, i);
                }
            });
            $this$onCustomizeHiddenDrawerItems_u24lambda_u2414.setNegativeButton(R.string.settings_dismiss, (DialogInterface.OnClickListener) null);
            int size = items.size();
            boolean[] showings = new boolean[size];
            for (int i = 0; i < size; i++) {
                showings[i] = !items.get(i).getShowing();
            }
            $this$onCustomizeHiddenDrawerItems_u24lambda_u2414.setMultiChoiceItems(ids, showings, new DialogInterface.OnMultiChoiceClickListener() { // from class: icu.nullptr.twifucker.ui.SettingsDialog$PrefsFragment$$ExternalSyntheticLambda5
                @Override // android.content.DialogInterface.OnMultiChoiceClickListener
                public final void onClick(DialogInterface dialogInterface, int i2, boolean z) {
                    SettingsDialog.PrefsFragment.onCustomizeHiddenDrawerItems$lambda$14$lambda$13(items, dialogInterface, i2, z);
                }
            });
            $this$onCustomizeHiddenDrawerItems_u24lambda_u2414.show();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onCustomizeHiddenDrawerItems$lambda$14$lambda$11(List items, DialogInterface dialogInterface, int i) {
            Intrinsics.checkNotNullParameter(items, "$items");
            Set hideItems = new LinkedHashSet();
            List $this$forEach$iv = items;
            for (Object element$iv : $this$forEach$iv) {
                TwitterItem it = (TwitterItem) element$iv;
                if (!it.getShowing()) {
                    hideItems.add(it.getKey());
                }
            }
            UtilsKt.getModulePrefs().putStringSet(SettingsDialog.PREF_HIDDEN_DRAWER_ITEMS, hideItems);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onCustomizeHiddenDrawerItems$lambda$14$lambda$12(DialogInterface dialogInterface, int i) {
            UtilsKt.getModulePrefs().remove(SettingsDialog.PREF_HIDDEN_DRAWER_ITEMS);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onCustomizeHiddenDrawerItems$lambda$14$lambda$13(List items, DialogInterface dialogInterface, int which, boolean isChecked) {
            Intrinsics.checkNotNullParameter(items, "$items");
            ((TwitterItem) items.get(which)).setShowing(!isChecked);
        }

        private final void onCustomizeHiddenBottomNavbarItems() {
            AlertDialog.Builder $this$onCustomizeHiddenBottomNavbarItems_u24lambda_u2420 = new AlertDialog.Builder(getActivity());
            final List items = DrawerNavbarHook.INSTANCE.getBottomNavbarItems();
            List $this$map$iv = items;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                TwitterItem it = (TwitterItem) item$iv$iv;
                destination$iv$iv.add(it.getKey());
            }
            Collection thisCollection$iv = (List) destination$iv$iv;
            String[] ids = (String[]) thisCollection$iv.toArray(new String[0]);
            $this$onCustomizeHiddenBottomNavbarItems_u24lambda_u2420.setTitle(R.string.hide_bottom_navbar_items);
            $this$onCustomizeHiddenBottomNavbarItems_u24lambda_u2420.setPositiveButton(R.string.save, new DialogInterface.OnClickListener() { // from class: icu.nullptr.twifucker.ui.SettingsDialog$PrefsFragment$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    SettingsDialog.PrefsFragment.onCustomizeHiddenBottomNavbarItems$lambda$20$lambda$17(items, dialogInterface, i);
                }
            });
            $this$onCustomizeHiddenBottomNavbarItems_u24lambda_u2420.setNeutralButton(R.string.reset, new DialogInterface.OnClickListener() { // from class: icu.nullptr.twifucker.ui.SettingsDialog$PrefsFragment$$ExternalSyntheticLambda1
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    SettingsDialog.PrefsFragment.onCustomizeHiddenBottomNavbarItems$lambda$20$lambda$18(dialogInterface, i);
                }
            });
            $this$onCustomizeHiddenBottomNavbarItems_u24lambda_u2420.setNegativeButton(R.string.settings_dismiss, (DialogInterface.OnClickListener) null);
            int size = items.size();
            boolean[] showings = new boolean[size];
            for (int i = 0; i < size; i++) {
                showings[i] = !items.get(i).getShowing();
            }
            $this$onCustomizeHiddenBottomNavbarItems_u24lambda_u2420.setMultiChoiceItems(ids, showings, new DialogInterface.OnMultiChoiceClickListener() { // from class: icu.nullptr.twifucker.ui.SettingsDialog$PrefsFragment$$ExternalSyntheticLambda2
                @Override // android.content.DialogInterface.OnMultiChoiceClickListener
                public final void onClick(DialogInterface dialogInterface, int i2, boolean z) {
                    SettingsDialog.PrefsFragment.onCustomizeHiddenBottomNavbarItems$lambda$20$lambda$19(items, dialogInterface, i2, z);
                }
            });
            $this$onCustomizeHiddenBottomNavbarItems_u24lambda_u2420.show();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onCustomizeHiddenBottomNavbarItems$lambda$20$lambda$17(List items, DialogInterface dialogInterface, int i) {
            Intrinsics.checkNotNullParameter(items, "$items");
            Set hideItems = new LinkedHashSet();
            List $this$forEach$iv = items;
            for (Object element$iv : $this$forEach$iv) {
                TwitterItem it = (TwitterItem) element$iv;
                if (!it.getShowing()) {
                    hideItems.add(it.getKey());
                }
            }
            UtilsKt.getModulePrefs().putStringSet(SettingsDialog.PREF_HIDDEN_BOTTOM_NAVBAR_ITEMS, hideItems);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onCustomizeHiddenBottomNavbarItems$lambda$20$lambda$18(DialogInterface dialogInterface, int i) {
            UtilsKt.getModulePrefs().remove(SettingsDialog.PREF_HIDDEN_BOTTOM_NAVBAR_ITEMS);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onCustomizeHiddenBottomNavbarItems$lambda$20$lambda$19(List items, DialogInterface dialogInterface, int which, boolean isChecked) {
            Intrinsics.checkNotNullParameter(items, "$items");
            ((TwitterItem) items.get(which)).setShowing(!isChecked);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void lambda$2$lambda$1(SettingsDialog this_run, Activity act, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(this_run, "$this_run");
        Intrinsics.checkNotNullParameter(act, "$act");
        this_run.deleteFromDatabase();
        Utils.restartHostApp(act);
    }
}

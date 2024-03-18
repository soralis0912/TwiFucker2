package icu.nullptr.twifucker;

import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.os.Build;
import com.github.kyuubiran.ezxhelper.EzXHelper;
import com.github.kyuubiran.ezxhelper.HookFactory;
import com.github.kyuubiran.ezxhelper.Log;
import com.github.kyuubiran.ezxhelper.interfaces.IMethodHookCallback;
import com.tencent.mmkv.MMKV;
import de.robv.android.xposed.XC_MethodHook;
import icu.nullptr.twifucker.ui.SettingsDialog;
import java.io.File;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.IntIterator;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;
/* compiled from: Utils.kt */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u000e\u00106\u001a\u00020\u00142\u0006\u00107\u001a\u00020\u0014\u001a\u000e\u00108\u001a\u00020\u00142\u0006\u00107\u001a\u00020\u0014\u001a\u0018\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\u00142\u0006\u0010<\u001a\u00020\u0014H\u0007\u001a\u000e\u0010=\u001a\u00020\u00142\u0006\u00107\u001a\u00020\u0014\u001a\u000e\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020\u0014\u001a\t\u0010A\u001a\u00020'H\u0086 \u001a\u000e\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020\u0014\u001a.\u0010E\u001a\u00020C*\u00020F2\u0006\u0010;\u001a\u00020\u00142\u0014\b\u0004\u0010G\u001a\u000e\u0012\u0004\u0012\u00020I\u0012\u0004\u0012\u00020C0HH\u0086\bø\u0001\u0000\u001a.\u0010J\u001a\u00020C*\u00020F2\u0006\u0010;\u001a\u00020\u00142\u0014\b\u0004\u0010G\u001a\u000e\u0012\u0004\u0012\u00020I\u0012\u0004\u0012\u00020C0HH\u0086\bø\u0001\u0000\u001a$\u0010K\u001a\u00020C*\u00020L2\u0012\u0010M\u001a\u000e\u0012\u0004\u0012\u00020N\u0012\u0004\u0012\u00020C0HH\u0086\bø\u0001\u0000\u001a9\u0010O\u001a\u00020C*\u00020L2'\u0010M\u001a#\u0012\u0013\u0012\u00110:¢\u0006\f\bQ\u0012\b\b;\u0012\u0004\b\b(R\u0012\u0004\u0012\u00020N\u0012\u0004\u0012\u00020C0PH\u0086\bø\u0001\u0000\u001a0\u0010S\u001a\u00020C*\u00020F2\u0006\u0010;\u001a\u00020\u00142\u0016\b\u0004\u0010G\u001a\u0010\u0012\u0004\u0012\u00020I\u0012\u0006\u0012\u0004\u0018\u00010\u000e0HH\u0086\bø\u0001\u0000\"\u001b\u0010\u0000\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0002\u0010\u0003\"!\u0010\u0006\u001a\u00020\u00078FX\u0086\u0084\u0002¢\u0006\u0012\n\u0004\b\f\u0010\u0005\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"!\u0010\r\u001a\u00020\u000e8FX\u0086\u0084\u0002¢\u0006\u0012\n\u0004\b\u0012\u0010\u0005\u0012\u0004\b\u000f\u0010\t\u001a\u0004\b\u0010\u0010\u0011\"\u001b\u0010\u0013\u001a\u00020\u00148FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0005\u001a\u0004\b\u0015\u0010\u0016\"\u001b\u0010\u0018\u001a\u00020\u00198FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0005\u001a\u0004\b\u001a\u0010\u001b\"\u001b\u0010\u001d\u001a\u00020\u00198FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0005\u001a\u0004\b\u001e\u0010\u001b\"\u001b\u0010 \u001a\u00020\u00198FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u0005\u001a\u0004\b!\u0010\u001b\"\u001b\u0010#\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u0005\u001a\u0004\b$\u0010\u0003\"\u001b\u0010&\u001a\u00020'8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\u0005\u001a\u0004\b(\u0010)\"!\u0010+\u001a\u00020,8FX\u0086\u0084\u0002¢\u0006\u0012\n\u0004\b0\u0010\u0005\u0012\u0004\b-\u0010\t\u001a\u0004\b.\u0010/\"\u001b\u00101\u001a\u0002028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b5\u0010\u0005\u001a\u0004\b3\u00104\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006T"}, d2 = {"hostAppLastUpdate", "", "getHostAppLastUpdate", "()J", "hostAppLastUpdate$delegate", "Lkotlin/Lazy;", "hostPrefs", "Landroid/content/SharedPreferences;", "getHostPrefs$annotations", "()V", "getHostPrefs", "()Landroid/content/SharedPreferences;", "hostPrefs$delegate", "hostVersionCode", "", "getHostVersionCode$annotations", "getHostVersionCode", "()Ljava/lang/Object;", "hostVersionCode$delegate", "hostVersionName", "", "getHostVersionName", "()Ljava/lang/String;", "hostVersionName$delegate", "logFile", "Ljava/io/File;", "getLogFile", "()Ljava/io/File;", "logFile$delegate", "logFileDir", "getLogFileDir", "logFileDir$delegate", "logJsonFile", "getLogJsonFile", "logJsonFile$delegate", "moduleLastModify", "getModuleLastModify", "moduleLastModify$delegate", "modulePrefs", "Lcom/tencent/mmkv/MMKV;", "getModulePrefs", "()Lcom/tencent/mmkv/MMKV;", "modulePrefs$delegate", "packageInfo", "Landroid/content/pm/PackageInfo;", "getPackageInfo$annotations", "getPackageInfo", "()Landroid/content/pm/PackageInfo;", "packageInfo$delegate", "reGenericClass", "Lkotlin/text/Regex;", "getReGenericClass", "()Lkotlin/text/Regex;", "reGenericClass$delegate", "clearUrlQueries", "url", "genOrigUrl", "getId", "", "name", "defType", "getUrlExtension", "isEntryNeedsRemove", "", "entryId", "nativeLoadPrefs", "writeJsonLog", "", "content", "afterMeasure", "Lcom/github/kyuubiran/ezxhelper/HookFactory;", "block", "Lkotlin/Function1;", "Lde/robv/android/xposed/XC_MethodHook$MethodHookParam;", "beforeMeasure", "forEach", "Lorg/json/JSONArray;", "action", "Lorg/json/JSONObject;", "forEachIndexed", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "index", "replaceMeasure", "app_debug"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class UtilsKt {
    private static final Lazy reGenericClass$delegate = LazyKt.lazy(new Function0<Regex>() { // from class: icu.nullptr.twifucker.UtilsKt$reGenericClass$2
        @Override // kotlin.jvm.functions.Function0
        public final Regex invoke() {
            return new Regex("^(\\w+)<(\\w+)>$");
        }
    });
    private static final Lazy logFileDir$delegate = LazyKt.lazy(new Function0<File>() { // from class: icu.nullptr.twifucker.UtilsKt$logFileDir$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final File invoke() {
            File externalCacheDir = EzXHelper.getAppContext().getExternalCacheDir();
            return new File((externalCacheDir != null ? externalCacheDir.getAbsolutePath() : null) + "/twifucker_log/");
        }
    });
    private static final Lazy logFile$delegate = LazyKt.lazy(new Function0<File>() { // from class: icu.nullptr.twifucker.UtilsKt$logFile$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final File invoke() {
            return new File(UtilsKt.getLogFileDir(), "log.txt");
        }
    });
    private static final Lazy logJsonFile$delegate = LazyKt.lazy(new Function0<File>() { // from class: icu.nullptr.twifucker.UtilsKt$logJsonFile$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final File invoke() {
            return new File(UtilsKt.getLogFileDir(), "log_json.txt");
        }
    });
    private static final Lazy packageInfo$delegate = LazyKt.lazy(new Function0<PackageInfo>() { // from class: icu.nullptr.twifucker.UtilsKt$packageInfo$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final PackageInfo invoke() {
            return EzXHelper.getAppContext().getPackageManager().getPackageInfo(EzXHelper.getAppContext().getPackageName(), 0);
        }
    });
    private static final Lazy hostVersionName$delegate = LazyKt.lazy(new Function0<String>() { // from class: icu.nullptr.twifucker.UtilsKt$hostVersionName$2
        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            return UtilsKt.getPackageInfo().versionName;
        }
    });
    private static final Lazy hostVersionCode$delegate = LazyKt.lazy(new Function0<Object>() { // from class: icu.nullptr.twifucker.UtilsKt$hostVersionCode$2
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            if (Build.VERSION.SDK_INT >= 28) {
                return Long.valueOf(UtilsKt.getPackageInfo().getLongVersionCode());
            }
            return Integer.valueOf(UtilsKt.getPackageInfo().versionCode);
        }
    });
    private static final Lazy hostAppLastUpdate$delegate = LazyKt.lazy(new Function0<Long>() { // from class: icu.nullptr.twifucker.UtilsKt$hostAppLastUpdate$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Long invoke() {
            return Long.valueOf(UtilsKt.getPackageInfo().lastUpdateTime);
        }
    });
    private static final Lazy moduleLastModify$delegate = LazyKt.lazy(new Function0<Long>() { // from class: icu.nullptr.twifucker.UtilsKt$moduleLastModify$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Long invoke() {
            return Long.valueOf(new File(EzXHelper.getModulePath()).lastModified());
        }
    });
    private static final Lazy modulePrefs$delegate = LazyKt.lazy(new Function0<MMKV>() { // from class: icu.nullptr.twifucker.UtilsKt$modulePrefs$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final MMKV invoke() {
            return UtilsKt.nativeLoadPrefs();
        }
    });
    private static final Lazy hostPrefs$delegate = LazyKt.lazy(new Function0<SharedPreferences>() { // from class: icu.nullptr.twifucker.UtilsKt$hostPrefs$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final SharedPreferences invoke() {
            return EzXHelper.getAppContext().getSharedPreferences(EzXHelper.getAppContext().getPackageName() + "_preferences", 4);
        }
    });

    public static /* synthetic */ void getHostPrefs$annotations() {
    }

    public static /* synthetic */ void getHostVersionCode$annotations() {
    }

    public static /* synthetic */ void getPackageInfo$annotations() {
    }

    public static final native MMKV nativeLoadPrefs();

    public static final Regex getReGenericClass() {
        return (Regex) reGenericClass$delegate.getValue();
    }

    public static final File getLogFileDir() {
        return (File) logFileDir$delegate.getValue();
    }

    public static final File getLogFile() {
        return (File) logFile$delegate.getValue();
    }

    public static final File getLogJsonFile() {
        return (File) logJsonFile$delegate.getValue();
    }

    public static final PackageInfo getPackageInfo() {
        Object value = packageInfo$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (PackageInfo) value;
    }

    public static final String getHostVersionName() {
        Object value = hostVersionName$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (String) value;
    }

    public static final Object getHostVersionCode() {
        return hostVersionCode$delegate.getValue();
    }

    public static final long getHostAppLastUpdate() {
        return ((Number) hostAppLastUpdate$delegate.getValue()).longValue();
    }

    public static final long getModuleLastModify() {
        return ((Number) moduleLastModify$delegate.getValue()).longValue();
    }

    public static final MMKV getModulePrefs() {
        return (MMKV) modulePrefs$delegate.getValue();
    }

    public static final SharedPreferences getHostPrefs() {
        Object value = hostPrefs$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (SharedPreferences) value;
    }

    public static final int getId(String name, String defType) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(defType, "defType");
        return EzXHelper.getAppContext().getResources().getIdentifier(name, defType, EzXHelper.getAppContext().getPackageName());
    }

    public static final void writeJsonLog(String content) {
        Intrinsics.checkNotNullParameter(content, "content");
        try {
            if (!getLogFileDir().exists()) {
                getLogFileDir().mkdirs();
            }
            if (!getLogJsonFile().exists()) {
                getLogJsonFile().createNewFile();
            }
            FilesKt.appendText$default(getLogJsonFile(), content + "\n", null, 2, null);
        } catch (Throwable t) {
            Log.e$default(t, (String) null, 2, (Object) null);
        }
    }

    public static final boolean isEntryNeedsRemove(String entryId) {
        Intrinsics.checkNotNullParameter(entryId, "entryId");
        if ((StringsKt.startsWith$default(entryId, "promotedTweet-", false, 2, (Object) null) || StringsKt.startsWith$default(entryId, "superhero-", false, 2, (Object) null)) && getModulePrefs().getBoolean(SettingsDialog.PREF_DISABLE_PROMOTED_CONTENT, true)) {
            return true;
        }
        if ((StringsKt.startsWith$default(entryId, "whoToFollow-", false, 2, (Object) null) || StringsKt.startsWith$default(entryId, "who-to-follow-", false, 2, (Object) null) || StringsKt.startsWith$default(entryId, "connect-module-", false, 2, (Object) null)) && getModulePrefs().getBoolean("disable_who_to_follow", false)) {
            return true;
        }
        if (StringsKt.startsWith$default(entryId, "who-to-subscribe-", false, 2, (Object) null) && getModulePrefs().getBoolean("disable_who_to_subscribe", false)) {
            return true;
        }
        if (StringsKt.startsWith$default(entryId, "TopicsModule-", false, 2, (Object) null) && getModulePrefs().getBoolean("disable_topics_to_follow", false)) {
            return true;
        }
        return StringsKt.startsWith$default(entryId, "tweetdetailrelatedtweets-", false, 2, (Object) null) && getModulePrefs().getBoolean("disable_tweet_detail_related_tweets", false);
    }

    public static final String clearUrlQueries(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return (String) StringsKt.split$default((CharSequence) url, new String[]{"?"}, false, 0, 6, (Object) null).get(0);
    }

    public static final String getUrlExtension(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        String urlWithoutQueries = clearUrlQueries(url);
        String substring = urlWithoutQueries.substring(StringsKt.lastIndexOf$default((CharSequence) urlWithoutQueries, ".", 0, false, 6, (Object) null) + 1);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        return substring;
    }

    public static final String genOrigUrl(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        String urlWithoutQueries = clearUrlQueries(url);
        String urlWithoutExt = urlWithoutQueries.substring(0, StringsKt.lastIndexOf$default((CharSequence) urlWithoutQueries, ".", 0, false, 6, (Object) null));
        Intrinsics.checkNotNullExpressionValue(urlWithoutExt, "substring(...)");
        String ext = getUrlExtension(urlWithoutQueries);
        return urlWithoutExt + "?format=" + ext + "&name=orig";
    }

    public static final void forEach(JSONArray $this$forEach, Function1<? super JSONObject, Unit> action) {
        Intrinsics.checkNotNullParameter($this$forEach, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        Iterable $this$forEach$iv = RangesKt.until(0, $this$forEach.length());
        Iterator<Integer> it = $this$forEach$iv.iterator();
        while (it.hasNext()) {
            int element$iv = ((IntIterator) it).nextInt();
            if ($this$forEach.get(element$iv) instanceof JSONObject) {
                Object obj = $this$forEach.get(element$iv);
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type org.json.JSONObject");
                action.invoke((JSONObject) obj);
            }
        }
    }

    public static final void forEachIndexed(JSONArray $this$forEachIndexed, Function2<? super Integer, ? super JSONObject, Unit> action) {
        Intrinsics.checkNotNullParameter($this$forEachIndexed, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        Iterable $this$forEach$iv = RangesKt.until(0, $this$forEachIndexed.length());
        Iterator<Integer> it = $this$forEach$iv.iterator();
        while (it.hasNext()) {
            int element$iv = ((IntIterator) it).nextInt();
            if ($this$forEachIndexed.get(element$iv) instanceof JSONObject) {
                Integer valueOf = Integer.valueOf(element$iv);
                Object obj = $this$forEachIndexed.get(element$iv);
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type org.json.JSONObject");
                action.invoke(valueOf, (JSONObject) obj);
            }
        }
    }

    public static final void replaceMeasure(HookFactory $this$replaceMeasure, final String name, final Function1<? super XC_MethodHook.MethodHookParam, ? extends Object> block) {
        Intrinsics.checkNotNullParameter($this$replaceMeasure, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(block, "block");
        $this$replaceMeasure.replace(new Function1<XC_MethodHook.MethodHookParam, Object>() { // from class: icu.nullptr.twifucker.UtilsKt$replaceMeasure$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(XC_MethodHook.MethodHookParam it) {
                Intrinsics.checkNotNullParameter(it, "it");
                long start = System.currentTimeMillis();
                Object ret = block.invoke(it);
                long end = System.currentTimeMillis();
                long elapsed = end - start;
                if (elapsed > 10) {
                    Log.d$default(name + " elapsed: " + (System.currentTimeMillis() - start) + "ms", (Throwable) null, 2, (Object) null);
                }
                return ret;
            }
        });
    }

    public static final void beforeMeasure(HookFactory $this$beforeMeasure, final String name, final Function1<? super XC_MethodHook.MethodHookParam, Unit> block) {
        Intrinsics.checkNotNullParameter($this$beforeMeasure, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(block, "block");
        $this$beforeMeasure.before(new IMethodHookCallback() { // from class: icu.nullptr.twifucker.UtilsKt$beforeMeasure$1
            @Override // com.github.kyuubiran.ezxhelper.interfaces.IMethodHookCallback
            public final void onMethodHooked(XC_MethodHook.MethodHookParam it) {
                Intrinsics.checkNotNullParameter(it, "it");
                long start = System.currentTimeMillis();
                block.invoke(it);
                long end = System.currentTimeMillis();
                long elapsed = end - start;
                if (elapsed > 10) {
                    Log.d$default(name + " elapsed: " + (System.currentTimeMillis() - start) + "ms", (Throwable) null, 2, (Object) null);
                }
            }
        });
    }

    public static final void afterMeasure(HookFactory $this$afterMeasure, final String name, final Function1<? super XC_MethodHook.MethodHookParam, Unit> block) {
        Intrinsics.checkNotNullParameter($this$afterMeasure, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(block, "block");
        $this$afterMeasure.after(new IMethodHookCallback() { // from class: icu.nullptr.twifucker.UtilsKt$afterMeasure$1
            @Override // com.github.kyuubiran.ezxhelper.interfaces.IMethodHookCallback
            public final void onMethodHooked(XC_MethodHook.MethodHookParam it) {
                Intrinsics.checkNotNullParameter(it, "it");
                long start = System.currentTimeMillis();
                block.invoke(it);
                long end = System.currentTimeMillis();
                long elapsed = end - start;
                if (elapsed > 10) {
                    Log.d$default(name + " elapsed: " + (System.currentTimeMillis() - start) + "ms", (Throwable) null, 2, (Object) null);
                }
            }
        });
    }
}

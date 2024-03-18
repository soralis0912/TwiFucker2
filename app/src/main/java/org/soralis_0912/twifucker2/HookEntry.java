package org.soralis_0912.twifucker2;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import com.github.kyuubiran.ezxhelper.EzXHelper;
import com.github.kyuubiran.ezxhelper.HookFactory;
import com.github.kyuubiran.ezxhelper.Log;
import com.github.kyuubiran.ezxhelper.LogExtensions;
import com.github.kyuubiran.ezxhelper.Logger;
import com.github.kyuubiran.ezxhelper.finders.MethodFinder;
import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.IXposedHookZygoteInit;
import de.robv.android.xposed.callbacks.XC_LoadPackage;
import icu.nullptr.twifucker.UtilsKt;
import icu.nullptr.twifucker.hook.BaseHook;
import icu.nullptr.twifucker.ui.SettingsDialog;
import io.luckypray.dexkit.DexKitBridge;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Main.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u00012\u00020\u0002:\u0001\u0014B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0016\u0010\b\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0019\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0082 ¨\u0006\u0015"}, d2 = {"Lorg/soralis_0912/twifucker2/HookEntry;", "Lde/robv/android/xposed/IXposedHookZygoteInit;", "Lde/robv/android/xposed/IXposedHookLoadPackage;", "()V", "handleLoadPackage", "", "lpparam", "Lde/robv/android/xposed/callbacks/XC_LoadPackage$LoadPackageParam;", "initHooks", "hook", "", "Licu/nullptr/twifucker/hook/BaseHook;", "initZygote", "startupParam", "Lde/robv/android/xposed/IXposedHookZygoteInit$StartupParam;", "nativeInit", "context", "Landroid/content/Context;", "modulePath", "", "Companion", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class HookEntry implements IXposedHookZygoteInit, IXposedHookLoadPackage {
    public static final Companion Companion = new Companion(null);
    public static WeakReference<Activity> currentActivity;
    public static DexKitBridge dexKit;
    public static Process logcatProcess;

    /* JADX INFO: Access modifiers changed from: private */
    public final native void nativeInit(Context context, String str);

    /* compiled from: Main.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\u0019J\u0006\u0010\u001a\u001a\u00020\u0017J\u0006\u0010\u001b\u001a\u00020\u0017R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u001c"}, d2 = {"Lorg/soralis_0912/twifucker2/HookEntry$Companion;", "", "()V", "currentActivity", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "getCurrentActivity", "()Ljava/lang/ref/WeakReference;", "setCurrentActivity", "(Ljava/lang/ref/WeakReference;)V", "dexKit", "Lio/luckypray/dexkit/DexKitBridge;", "getDexKit", "()Lio/luckypray/dexkit/DexKitBridge;", "setDexKit", "(Lio/luckypray/dexkit/DexKitBridge;)V", "logcatProcess", "Ljava/lang/Process;", "getLogcatProcess", "()Ljava/lang/Process;", "setLogcatProcess", "(Ljava/lang/Process;)V", "closeDexKit", "", "isLogcatProcessInitialized", "", "loadDexKit", "startLog", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DexKitBridge getDexKit() {
            DexKitBridge dexKitBridge = HookEntry.dexKit;
            if (dexKitBridge != null) {
                return dexKitBridge;
            }
            Intrinsics.throwUninitializedPropertyAccessException("dexKit");
            return null;
        }

        public final void setDexKit(DexKitBridge dexKitBridge) {
            Intrinsics.checkNotNullParameter(dexKitBridge, "<set-?>");
            HookEntry.dexKit = dexKitBridge;
        }

        public final WeakReference<Activity> getCurrentActivity() {
            WeakReference<Activity> weakReference = HookEntry.currentActivity;
            if (weakReference != null) {
                return weakReference;
            }
            Intrinsics.throwUninitializedPropertyAccessException("currentActivity");
            return null;
        }

        public final void setCurrentActivity(WeakReference<Activity> weakReference) {
            Intrinsics.checkNotNullParameter(weakReference, "<set-?>");
            HookEntry.currentActivity = weakReference;
        }

        public final Process getLogcatProcess() {
            Process process = HookEntry.logcatProcess;
            if (process != null) {
                return process;
            }
            Intrinsics.throwUninitializedPropertyAccessException("logcatProcess");
            return null;
        }

        public final void setLogcatProcess(Process process) {
            Intrinsics.checkNotNullParameter(process, "<set-?>");
            HookEntry.logcatProcess = process;
        }

        public final void loadDexKit() {
            if (HookEntry.dexKit != null) {
                return;
            }
            long ts = System.currentTimeMillis();
            System.loadLibrary("dexkit");
            DexKitBridge.Companion companion = DexKitBridge.Companion;
            String sourceDir = EzXHelper.getAppContext().getApplicationInfo().sourceDir;
            Intrinsics.checkNotNullExpressionValue(sourceDir, "sourceDir");
            DexKitBridge it = companion.create(sourceDir);
            if (it != null) {
                HookEntry.Companion.setDexKit(it);
                Log.i$default("DexKit loaded in " + (System.currentTimeMillis() - ts) + " ms", (Throwable) null, 2, (Object) null);
            }
        }

        public final void closeDexKit() {
            if (HookEntry.dexKit != null) {
                getDexKit().close();
            }
        }

        public final boolean isLogcatProcessInitialized() {
            return HookEntry.logcatProcess != null;
        }

        public final void startLog() {
            if (UtilsKt.getModulePrefs().getBoolean(SettingsDialog.PREF_ENABLE_LOG, false)) {
                if (!UtilsKt.getLogFileDir().exists()) {
                    UtilsKt.getLogFileDir().mkdirs();
                }
                try {
                    Process exec = Runtime.getRuntime().exec(new String[]{"logcat", "-T", "100", "-f", UtilsKt.getLogFile().getAbsolutePath()});
                    Intrinsics.checkNotNullExpressionValue(exec, "exec(...)");
                    setLogcatProcess(exec);
                } catch (Throwable t) {
                    Log.e$default(t, (String) null, 2, (Object) null);
                }
            }
        }
    }

    public void initZygote(IXposedHookZygoteInit.StartupParam startupParam) {
        Intrinsics.checkNotNullParameter(startupParam, "startupParam");
        System.loadLibrary(SettingsDialog.PREFS_NAME);
        EzXHelper.initZygote(startupParam);
        EzXHelper.setLogTag("TwiFucker");
        EzXHelper.setToastTag("TwiFucker");
        Log.d$default("InitZygote", (Throwable) null, 2, (Object) null);
    }

    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) {
        Intrinsics.checkNotNullParameter(lpparam, "lpparam");
        if (Intrinsics.areEqual(lpparam.packageName, "com.twitter.android")) {
            EzXHelper.initHandleLoadPackage(lpparam);
            Log.d$default("HandleLoadedPackage", (Throwable) null, 2, (Object) null);
            HookFactory.f1Static.m38createMethodHook((Method) MethodFinder.f4Static.fromClass(Application.class).filterByName("attach").filterByParamTypes(Context.class).first(), new HookEntry$handleLoadPackage$1(this, lpparam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initHooks(List<? extends BaseHook> list) {
        Object $receiver$iv;
        List<? extends BaseHook> $this$forEach$iv = list;
        for (Object element$iv : $this$forEach$iv) {
            BaseHook it = (BaseHook) element$iv;
            LogExtensions logExtensions = LogExtensions.INSTANCE;
            try {
                Result.Companion companion = Result.Companion;
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                $receiver$iv = Result.m82constructorimpl(ResultKt.createFailure(th));
            }
            if (!it.isInit()) {
                long ts = System.currentTimeMillis();
                it.init();
                it.setInit(true);
                Log.i$default("Inited " + it.getName() + " hook in " + (System.currentTimeMillis() - ts) + " ms", (Throwable) null, 2, (Object) null);
                $receiver$iv = Result.m82constructorimpl(Unit.INSTANCE);
                String msg$iv = "Failed init hook: " + it.getName();
                Object $this$logexIfThrow_1vKEnOE_u24lambda_u2416$iv = $receiver$iv;
                Throwable it$iv = Result.m85exceptionOrNullimpl($this$logexIfThrow_1vKEnOE_u24lambda_u2416$iv);
                if (it$iv != null) {
                    Logger logger = LogExtensions.INSTANCE.getLogger();
                    if (logger != null) {
                        logger.ex(it$iv, msg$iv);
                    }
                }
            }
        }
    }
}

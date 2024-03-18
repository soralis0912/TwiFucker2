package icu.nullptr.twifucker.hook.activity;

import android.app.Activity;
import com.github.kyuubiran.ezxhelper.AndroidLogger;
import com.github.kyuubiran.ezxhelper.ClassUtils;
import com.github.kyuubiran.ezxhelper.HookFactory;
import com.github.kyuubiran.ezxhelper.Log;
import com.github.kyuubiran.ezxhelper.finders.MethodFinder;
import com.github.kyuubiran.ezxhelper.interfaces.IMethodHookCallback;
import de.robv.android.xposed.XC_MethodHook;
import icu.nullptr.twifucker.UtilsKt;
import icu.nullptr.twifucker.hook.BaseHook;
import icu.nullptr.twifucker.ui.SettingsDialog;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.soralis_0912.twifucker2.BuildConfig;
/* compiled from: MainActivityHook.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u00020\u000bH\u0016R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00060\bR\u00020\tX\u0082.¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Licu/nullptr/twifucker/hook/activity/MainActivityHook;", "Licu/nullptr/twifucker/hook/BaseHook;", "()V", "name", "", "getName", "()Ljava/lang/String;", "theHook", "Lde/robv/android/xposed/XC_MethodHook$Unhook;", "Lde/robv/android/xposed/XC_MethodHook;", "init", "", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MainActivityHook extends BaseHook {
    public static final MainActivityHook INSTANCE = new MainActivityHook();
    private static XC_MethodHook.Unhook theHook;

    private MainActivityHook() {
    }

    @Override // icu.nullptr.twifucker.hook.BaseHook
    public String getName() {
        return "MainActivityHook";
    }

    @Override // icu.nullptr.twifucker.hook.BaseHook
    public void init() {
        theHook = HookFactory.f1Static.m38createMethodHook((Method) MethodFinder.f4Static.fromClass(ClassUtils.loadClass$default("com.twitter.app.main.MainActivity", null, 2, null)).findSuper((Function1<? super Class<?>, Boolean>) new Function1<Class<?>, Boolean>() { // from class: icu.nullptr.twifucker.hook.activity.MainActivityHook$init$1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Class<?> findSuper) {
                Intrinsics.checkNotNullParameter(findSuper, "$this$findSuper");
                return false;
            }
        }).filterByName("onResume").first(), new Function1<HookFactory, Unit>() { // from class: icu.nullptr.twifucker.hook.activity.MainActivityHook$init$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(HookFactory hookFactory) {
                invoke2(hookFactory);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(HookFactory createHook) {
                Intrinsics.checkNotNullParameter(createHook, "$this$createHook");
                final String name$iv = MainActivityHook.INSTANCE.getName();
                createHook.after(new IMethodHookCallback() { // from class: icu.nullptr.twifucker.hook.activity.MainActivityHook$init$2$invoke$$inlined$afterMeasure$1
                    @Override // com.github.kyuubiran.ezxhelper.interfaces.IMethodHookCallback
                    public final void onMethodHooked(XC_MethodHook.MethodHookParam it) {
                        XC_MethodHook.Unhook unhook;
                        Intrinsics.checkNotNullParameter(it, "it");
                        long start = System.currentTimeMillis();
                        Log.d$default("MainActivity onResume", (Throwable) null, 2, (Object) null);
                        if (BuildConfig.DEBUG || UtilsKt.getModulePrefs().getBoolean("first_run", true)) {
                            Object obj = it.thisObject;
                            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.app.Activity");
                            new SettingsDialog((Activity) obj);
                            UtilsKt.getModulePrefs().putBoolean("first_run", false);
                        }
                        if (UtilsKt.getModulePrefs().getBoolean("show_toast", true)) {
                            AndroidLogger.toast$default("TwiFucker version 1.1", 0, 2, null);
                        }
                        unhook = MainActivityHook.theHook;
                        if (unhook == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("theHook");
                            unhook = null;
                        }
                        unhook.unhook();
                        long end = System.currentTimeMillis();
                        long elapsed = end - start;
                        if (elapsed > 10) {
                            Log.d$default(name$iv + " elapsed: " + (System.currentTimeMillis() - start) + "ms", (Throwable) null, 2, (Object) null);
                        }
                    }
                });
            }
        });
    }
}

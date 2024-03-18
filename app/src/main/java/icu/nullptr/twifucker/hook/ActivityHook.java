package icu.nullptr.twifucker.hook;

import android.app.Activity;
import com.github.kyuubiran.ezxhelper.HookFactory;
import com.github.kyuubiran.ezxhelper.Log;
import com.github.kyuubiran.ezxhelper.finders.MethodFinder;
import com.github.kyuubiran.ezxhelper.interfaces.IMethodHookCallback;
import de.robv.android.xposed.XC_MethodHook;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.soralis_0912.twifucker2.HookEntry;
/* compiled from: ActivityHook.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Licu/nullptr/twifucker/hook/ActivityHook;", "Licu/nullptr/twifucker/hook/BaseHook;", "()V", "name", "", "getName", "()Ljava/lang/String;", "init", "", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ActivityHook extends BaseHook {
    public static final ActivityHook INSTANCE = new ActivityHook();

    private ActivityHook() {
    }

    @Override // icu.nullptr.twifucker.hook.BaseHook
    public String getName() {
        return "ActivityHook";
    }

    @Override // icu.nullptr.twifucker.hook.BaseHook
    public void init() {
        HookFactory.f1Static.m38createMethodHook((Method) MethodFinder.f4Static.fromClass(Activity.class).filterByName("onResume").first(), new Function1<HookFactory, Unit>() { // from class: icu.nullptr.twifucker.hook.ActivityHook$init$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(HookFactory hookFactory) {
                invoke2(hookFactory);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(HookFactory createHook) {
                Intrinsics.checkNotNullParameter(createHook, "$this$createHook");
                final String name$iv = ActivityHook.INSTANCE.getName();
                createHook.after(new IMethodHookCallback() { // from class: icu.nullptr.twifucker.hook.ActivityHook$init$1$invoke$$inlined$afterMeasure$1
                    @Override // com.github.kyuubiran.ezxhelper.interfaces.IMethodHookCallback
                    public final void onMethodHooked(XC_MethodHook.MethodHookParam it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        long start = System.currentTimeMillis();
                        HookEntry.Companion companion = HookEntry.Companion;
                        Object obj = it.thisObject;
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.app.Activity");
                        companion.setCurrentActivity(new WeakReference<>((Activity) obj));
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

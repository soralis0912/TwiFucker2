package icu.nullptr.twifucker.hook;

import android.view.View;
import com.github.kyuubiran.ezxhelper.HookFactory;
import com.github.kyuubiran.ezxhelper.Log;
import com.github.kyuubiran.ezxhelper.interfaces.IMethodHookCallback;
import de.robv.android.xposed.XC_MethodHook;
import icu.nullptr.twifucker.UtilsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
/* compiled from: ViewHook.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/github/kyuubiran/ezxhelper/HookFactory;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
final class ViewHook$init$1 extends Lambda implements Function1<HookFactory, Unit> {
    public static final ViewHook$init$1 INSTANCE = new ViewHook$init$1();

    ViewHook$init$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(HookFactory hookFactory) {
        invoke2(hookFactory);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(HookFactory createHook) {
        Intrinsics.checkNotNullParameter(createHook, "$this$createHook");
        createHook.before(new IMethodHookCallback() { // from class: icu.nullptr.twifucker.hook.ViewHook$init$1$$ExternalSyntheticLambda0
            @Override // com.github.kyuubiran.ezxhelper.interfaces.IMethodHookCallback
            public final void onMethodHooked(XC_MethodHook.MethodHookParam methodHookParam) {
                ViewHook$init$1.invoke$lambda$0(methodHookParam);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$0(XC_MethodHook.MethodHookParam param) {
        Intrinsics.checkNotNullParameter(param, "param");
        Object obj = param.thisObject;
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.view.View");
        int id = ((View) obj).getId();
        Object obj2 = param.args[0];
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Int");
        int visibility = ((Integer) obj2).intValue();
        if (id == UtilsKt.getId("banner", "id") && visibility == 0) {
            Log.d$default("Prevented banner view", (Throwable) null, 2, (Object) null);
            param.args[0] = 8;
        }
    }
}

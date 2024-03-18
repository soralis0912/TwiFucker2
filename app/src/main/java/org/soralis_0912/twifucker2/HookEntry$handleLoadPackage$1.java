package org.soralis_0912.twifucker2;

import android.content.Context;
import com.github.kyuubiran.ezxhelper.EzXHelper;
import com.github.kyuubiran.ezxhelper.HookFactory;
import com.github.kyuubiran.ezxhelper.Log;
import com.github.kyuubiran.ezxhelper.interfaces.IMethodHookCallback;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.callbacks.XC_LoadPackage;
import icu.nullptr.twifucker.UtilsKt;
import icu.nullptr.twifucker.hook.ActivityHook;
import icu.nullptr.twifucker.hook.BaseHook;
import icu.nullptr.twifucker.hook.CustomTabsHook;
import icu.nullptr.twifucker.hook.DownloadHook;
import icu.nullptr.twifucker.hook.DrawerNavbarHook;
import icu.nullptr.twifucker.hook.FeatureSwitchHook;
import icu.nullptr.twifucker.hook.HomeTimelineHook;
import icu.nullptr.twifucker.hook.JsonFleetsTimelineResponseHook;
import icu.nullptr.twifucker.hook.JsonHook;
import icu.nullptr.twifucker.hook.JsonProfileRecommendationModuleResponseHook;
import icu.nullptr.twifucker.hook.JsonTimelineEntryHook;
import icu.nullptr.twifucker.hook.JsonTimelineModuleHook;
import icu.nullptr.twifucker.hook.JsonTimelineTrendHook;
import icu.nullptr.twifucker.hook.JsonTimelineTweetHook;
import icu.nullptr.twifucker.hook.JsonTimelineUserHook;
import icu.nullptr.twifucker.hook.SelectableTextHook;
import icu.nullptr.twifucker.hook.SensitiveMediaWarningHook;
import icu.nullptr.twifucker.hook.UrlHook;
import icu.nullptr.twifucker.hook.ViewHook;
import icu.nullptr.twifucker.hook.activity.MainActivityHook;
import icu.nullptr.twifucker.hook.activity.SettingsHook;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
/* compiled from: Main.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/github/kyuubiran/ezxhelper/HookFactory;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
final class HookEntry$handleLoadPackage$1 extends Lambda implements Function1<HookFactory, Unit> {
    final /* synthetic */ XC_LoadPackage.LoadPackageParam $lpparam;
    final /* synthetic */ HookEntry this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HookEntry$handleLoadPackage$1(HookEntry hookEntry, XC_LoadPackage.LoadPackageParam loadPackageParam) {
        super(1);
        this.this$0 = hookEntry;
        this.$lpparam = loadPackageParam;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(HookFactory hookFactory) {
        invoke2(hookFactory);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(HookFactory createHook) {
        Intrinsics.checkNotNullParameter(createHook, "$this$createHook");
        final HookEntry hookEntry = this.this$0;
        final XC_LoadPackage.LoadPackageParam loadPackageParam = this.$lpparam;
        createHook.before(new IMethodHookCallback() { // from class: org.soralis_0912.twifucker2.HookEntry$handleLoadPackage$1$$ExternalSyntheticLambda0
            @Override // com.github.kyuubiran.ezxhelper.interfaces.IMethodHookCallback
            public final void onMethodHooked(XC_MethodHook.MethodHookParam methodHookParam) {
                HookEntry$handleLoadPackage$1.invoke$lambda$0(HookEntry.this, loadPackageParam, methodHookParam);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$0(HookEntry this$0, XC_LoadPackage.LoadPackageParam lpparam, XC_MethodHook.MethodHookParam param) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(lpparam, "$lpparam");
        Intrinsics.checkNotNullParameter(param, "param");
        Object obj = param.args[0];
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.content.Context");
        Context context = (Context) obj;
        EzXHelper.initAppContext$default(context, false, 2, null);
        this$0.nativeInit(context, EzXHelper.getModulePath());
        String processName = lpparam.processName;
        Intrinsics.checkNotNullExpressionValue(processName, "processName");
        if (!StringsKt.contains$default((CharSequence) processName, (CharSequence) ":", false, 2, (Object) null)) {
            HookEntry.Companion.startLog();
        }
        Log.d$default("AttachContext", (Throwable) null, 2, (Object) null);
        Log.d$default("Twitter: " + UtilsKt.getHostVersionName() + " (" + UtilsKt.getHostVersionCode() + ") TwiFucker: 1.1 (1)", (Throwable) null, 2, (Object) null);
        ArrayList hooks = CollectionsKt.arrayListOf(MainActivityHook.INSTANCE, SettingsHook.INSTANCE, UrlHook.INSTANCE, SelectableTextHook.INSTANCE, DownloadHook.INSTANCE, ActivityHook.INSTANCE, CustomTabsHook.INSTANCE, DrawerNavbarHook.INSTANCE, FeatureSwitchHook.INSTANCE, ViewHook.INSTANCE, HomeTimelineHook.INSTANCE);
        if (UtilsKt.getModulePrefs().getBoolean("use_legacy_hook", false)) {
            hooks.add(JsonHook.INSTANCE);
        } else {
            hooks.addAll(CollectionsKt.listOf((Object[]) new BaseHook[]{JsonTimelineEntryHook.INSTANCE, JsonTimelineTweetHook.INSTANCE, JsonTimelineUserHook.INSTANCE, JsonTimelineTrendHook.INSTANCE, SensitiveMediaWarningHook.INSTANCE, JsonProfileRecommendationModuleResponseHook.INSTANCE, JsonFleetsTimelineResponseHook.INSTANCE, JsonTimelineModuleHook.INSTANCE}));
        }
        this$0.initHooks(hooks);
        HookEntry.Companion.closeDexKit();
    }
}

package icu.nullptr.twifucker.hook;

import com.github.kyuubiran.ezxhelper.HookFactory;
import com.github.kyuubiran.ezxhelper.Log;
import com.github.kyuubiran.ezxhelper.finders.FieldFinder;
import com.github.kyuubiran.ezxhelper.finders.MethodFinder;
import com.github.kyuubiran.ezxhelper.interfaces.IMethodHookCallback;
import com.tencent.mmkv.MMKV;
import de.robv.android.xposed.XC_MethodHook;
import icu.nullptr.twifucker.UtilsKt;
import icu.nullptr.twifucker.exceptions.CachedHookNotFound;
import io.luckypray.dexkit.DexKitBridge;
import io.luckypray.dexkit.builder.MethodOpcodeArgs;
import io.luckypray.dexkit.builder.MethodUsingStringArgs;
import io.luckypray.dexkit.descriptor.member.DexMethodDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.soralis_0912.twifucker2.HookEntry;
/* compiled from: HomeTimelineHook.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0013\u001a\u00020\u0011H\u0002J\b\u0010\u0014\u001a\u00020\u0011H\u0002J\b\u0010\u0015\u001a\u00020\u0011H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0012\u0010\r\u001a\u00060\u000eR\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Licu/nullptr/twifucker/hook/HomeTimelineHook;", "Licu/nullptr/twifucker/hook/BaseHook;", "()V", "HOOK_HOME_TIMELINE_LIST_ADD_METHOD", "", "HOOK_HOME_TIMELINE_LIST_CLASS", "HOOK_HOME_TIMELINE_TAB_CLASS", "homeTimelineListAddMethodName", "homeTimelineListClassName", "homeTimelineTabClassName", "name", "getName", "()Ljava/lang/String;", "unhook", "Lde/robv/android/xposed/XC_MethodHook$Unhook;", "Lde/robv/android/xposed/XC_MethodHook;", "init", "", "loadCachedHookInfo", "loadHookInfo", "saveHookInfo", "searchHook", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class HomeTimelineHook extends BaseHook {
    private static final String HOOK_HOME_TIMELINE_LIST_ADD_METHOD = "hook_home_timeline_list_add_method";
    private static final String HOOK_HOME_TIMELINE_LIST_CLASS = "hook_home_timeline_list_class";
    private static final String HOOK_HOME_TIMELINE_TAB_CLASS = "hook_home_timeline_tab_class";
    public static final HomeTimelineHook INSTANCE = new HomeTimelineHook();
    private static String homeTimelineListAddMethodName;
    private static String homeTimelineListClassName;
    private static String homeTimelineTabClassName;
    private static XC_MethodHook.Unhook unhook;

    private HomeTimelineHook() {
    }

    @Override // icu.nullptr.twifucker.hook.BaseHook
    public String getName() {
        return "HomeTimelineHook";
    }

    @Override // icu.nullptr.twifucker.hook.BaseHook
    public void init() {
        if (UtilsKt.getModulePrefs().getBoolean("hide_for_you_tab", false)) {
            try {
                loadHookInfo();
                HookFactory.Static r2 = HookFactory.f1Static;
                MethodFinder.Static r3 = MethodFinder.f4Static;
                String str = homeTimelineTabClassName;
                if (str == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("homeTimelineTabClassName");
                    str = null;
                }
                r2.m38createMethodHook((Method) MethodFinder.Static.fromClass$default(r3, str, null, 2, null).filterByName("apply").first(), new Function1<HookFactory, Unit>() { // from class: icu.nullptr.twifucker.hook.HomeTimelineHook$init$1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(HookFactory hookFactory) {
                        invoke2(hookFactory);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(HookFactory createHook) {
                        Intrinsics.checkNotNullParameter(createHook, "$this$createHook");
                        final String name$iv = HomeTimelineHook.INSTANCE.getName();
                        createHook.before(new IMethodHookCallback() { // from class: icu.nullptr.twifucker.hook.HomeTimelineHook$init$1$invoke$$inlined$beforeMeasure$1
                            @Override // com.github.kyuubiran.ezxhelper.interfaces.IMethodHookCallback
                            public final void onMethodHooked(XC_MethodHook.MethodHookParam it) {
                                String str2;
                                String str3;
                                String str4;
                                Intrinsics.checkNotNullParameter(it, "it");
                                long start = System.currentTimeMillis();
                                if (it.args[0] instanceof List) {
                                    FieldFinder.Static r4 = FieldFinder.f3Static;
                                    str2 = HomeTimelineHook.homeTimelineTabClassName;
                                    if (str2 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("homeTimelineTabClassName");
                                        str2 = null;
                                    }
                                    ((Field) FieldFinder.Static.fromClass$default(r4, str2, null, 2, null).filterByType(Integer.TYPE).first()).getInt(it.thisObject);
                                    HomeTimelineHook homeTimelineHook = HomeTimelineHook.INSTANCE;
                                    HookFactory.Static r42 = HookFactory.f1Static;
                                    MethodFinder.Static r7 = MethodFinder.f4Static;
                                    str3 = HomeTimelineHook.homeTimelineListClassName;
                                    if (str3 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("homeTimelineListClassName");
                                        str3 = null;
                                    }
                                    MethodFinder fromClass$default = MethodFinder.Static.fromClass$default(r7, str3, null, 2, null);
                                    str4 = HomeTimelineHook.homeTimelineListAddMethodName;
                                    if (str4 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("homeTimelineListAddMethodName");
                                        str4 = null;
                                    }
                                    HomeTimelineHook.unhook = r42.m38createMethodHook((Method) fromClass$default.filterByName(str4).first(), new Function1<HookFactory, Unit>() { // from class: icu.nullptr.twifucker.hook.HomeTimelineHook$init$1$1$1
                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(HookFactory hookFactory) {
                                            invoke2(hookFactory);
                                            return Unit.INSTANCE;
                                        }

                                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                        public final void invoke2(HookFactory createHook2) {
                                            Intrinsics.checkNotNullParameter(createHook2, "$this$createHook");
                                            final String name$iv2 = HomeTimelineHook.INSTANCE.getName();
                                            createHook2.replace(new Function1<XC_MethodHook.MethodHookParam, Object>() { // from class: icu.nullptr.twifucker.hook.HomeTimelineHook$init$1$1$1$invoke$$inlined$replaceMeasure$1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Object invoke(XC_MethodHook.MethodHookParam it2) {
                                                    XC_MethodHook.Unhook unhook2;
                                                    Intrinsics.checkNotNullParameter(it2, "it");
                                                    long start2 = System.currentTimeMillis();
                                                    unhook2 = HomeTimelineHook.unhook;
                                                    if (unhook2 == null) {
                                                        Intrinsics.throwUninitializedPropertyAccessException("unhook");
                                                        unhook2 = null;
                                                    }
                                                    unhook2.unhook();
                                                    Object ret = Unit.INSTANCE;
                                                    long end = System.currentTimeMillis();
                                                    long elapsed = end - start2;
                                                    if (elapsed > 10) {
                                                        Log.d$default(name$iv2 + " elapsed: " + (System.currentTimeMillis() - start2) + "ms", (Throwable) null, 2, (Object) null);
                                                    }
                                                    return ret;
                                                }
                                            });
                                        }
                                    });
                                }
                                long end = System.currentTimeMillis();
                                long elapsed = end - start;
                                if (elapsed > 10) {
                                    Log.d$default(name$iv + " elapsed: " + (System.currentTimeMillis() - start) + "ms", (Throwable) null, 2, (Object) null);
                                }
                            }
                        });
                    }
                });
            } catch (Throwable t) {
                Log.e$default(t, (String) null, 2, (Object) null);
            }
        }
    }

    private final void loadCachedHookInfo() {
        String string = UtilsKt.getModulePrefs().getString(HOOK_HOME_TIMELINE_TAB_CLASS, null);
        if (string != null) {
            homeTimelineTabClassName = string;
            String string2 = UtilsKt.getModulePrefs().getString(HOOK_HOME_TIMELINE_LIST_CLASS, null);
            if (string2 != null) {
                homeTimelineListClassName = string2;
                String string3 = UtilsKt.getModulePrefs().getString(HOOK_HOME_TIMELINE_LIST_ADD_METHOD, null);
                if (string3 != null) {
                    homeTimelineListAddMethodName = string3;
                    return;
                }
                throw new CachedHookNotFound();
            }
            throw new CachedHookNotFound();
        }
        throw new CachedHookNotFound();
    }

    private final void saveHookInfo() {
        MMKV it = UtilsKt.getModulePrefs();
        String str = homeTimelineTabClassName;
        String str2 = null;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("homeTimelineTabClassName");
            str = null;
        }
        it.putString(HOOK_HOME_TIMELINE_TAB_CLASS, str);
        String str3 = homeTimelineListClassName;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("homeTimelineListClassName");
            str3 = null;
        }
        it.putString(HOOK_HOME_TIMELINE_LIST_CLASS, str3);
        String str4 = homeTimelineListAddMethodName;
        if (str4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("homeTimelineListAddMethodName");
        } else {
            str2 = str4;
        }
        it.putString(HOOK_HOME_TIMELINE_LIST_ADD_METHOD, str2);
    }

    private final void searchHook() {
        DexKitBridge this_$iv = HookEntry.Companion.getDexKit();
        MethodUsingStringArgs.Companion companion = MethodUsingStringArgs.Companion;
        MethodUsingStringArgs.Builder $this$searchHook_u24lambda_u241 = new MethodUsingStringArgs.Builder();
        $this$searchHook_u24lambda_u241.setUsingString("^super_follow_subscriptions_home_timeline_tab_enabled$");
        $this$searchHook_u24lambda_u241.setMethodName("apply");
        String name = Object.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        $this$searchHook_u24lambda_u241.setMethodReturnType(name);
        String name2 = Object.class.getName();
        Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
        String name3 = Object.class.getName();
        Intrinsics.checkNotNullExpressionValue(name3, "getName(...)");
        $this$searchHook_u24lambda_u241.setMethodParamTypes(new String[]{name2, name3});
        $this$searchHook_u24lambda_u241.setUnique(true);
        homeTimelineTabClassName = ((DexMethodDescriptor) CollectionsKt.first((List<? extends Object>) this_$iv.findMethodUsingString($this$searchHook_u24lambda_u241.build()))).getDeclaringClassName();
        DexKitBridge this_$iv2 = HookEntry.Companion.getDexKit();
        MethodOpcodeArgs.Companion companion2 = MethodOpcodeArgs.Companion;
        MethodOpcodeArgs.Builder $this$searchHook_u24lambda_u242 = new MethodOpcodeArgs.Builder();
        $this$searchHook_u24lambda_u242.setOpSeq(new int[]{56, 84, 57, 110, 10, 56, 110, 40, 84, 56, 18, 110});
        String name4 = Void.TYPE.getName();
        Intrinsics.checkNotNullExpressionValue(name4, "getName(...)");
        $this$searchHook_u24lambda_u242.setMethodReturnType(name4);
        String name5 = Object.class.getName();
        Intrinsics.checkNotNullExpressionValue(name5, "getName(...)");
        $this$searchHook_u24lambda_u242.setMethodParamTypes(new String[]{name5});
        DexMethodDescriptor listAddMethod = (DexMethodDescriptor) CollectionsKt.first((List<? extends Object>) this_$iv2.findMethodUsingOpPrefixSeq($this$searchHook_u24lambda_u242.build()));
        homeTimelineListClassName = listAddMethod.getDeclaringClassName();
        homeTimelineListAddMethodName = listAddMethod.getName();
    }

    private final void loadHookInfo() {
        long hookHomeTimelineLastUpdate = UtilsKt.getModulePrefs().getLong("hook_home_timeline_last_update", 0L);
        long hostAppLastUpdate = UtilsKt.getHostAppLastUpdate();
        Log.d$default("hookHomeTimelineLastUpdate: " + hookHomeTimelineLastUpdate + ", hostAppLastUpdate: " + hostAppLastUpdate + ", moduleLastModify: " + UtilsKt.getModuleLastModify(), (Throwable) null, 2, (Object) null);
        long timeStart = System.currentTimeMillis();
        if (hookHomeTimelineLastUpdate > UtilsKt.getHostAppLastUpdate() && hookHomeTimelineLastUpdate > UtilsKt.getModuleLastModify()) {
            loadCachedHookInfo();
            Log.d$default("Home Timeline Hook load time: " + (System.currentTimeMillis() - timeStart) + " ms", (Throwable) null, 2, (Object) null);
            return;
        }
        HookEntry.Companion.loadDexKit();
        searchHook();
        Log.d$default("Home Timeline Hook search time: " + (System.currentTimeMillis() - timeStart) + " ms", (Throwable) null, 2, (Object) null);
        saveHookInfo();
        UtilsKt.getModulePrefs().putLong("hook_home_timeline_last_update", System.currentTimeMillis());
    }
}

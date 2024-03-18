package icu.nullptr.twifucker.hook;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.github.kyuubiran.ezxhelper.ClassUtils;
import com.github.kyuubiran.ezxhelper.EzXHelper;
import com.github.kyuubiran.ezxhelper.HookFactory;
import com.github.kyuubiran.ezxhelper.Log;
import com.github.kyuubiran.ezxhelper.finders.MethodFinder;
import com.github.kyuubiran.ezxhelper.interfaces.IMethodHookCallback;
import com.tencent.mmkv.MMKV;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import icu.nullptr.twifucker.UtilsKt;
import icu.nullptr.twifucker.exceptions.CachedHookNotFound;
import io.luckypray.dexkit.DexKitBridge;
import io.luckypray.dexkit.builder.MethodUsingStringArgs;
import io.luckypray.dexkit.descriptor.member.DexMethodDescriptor;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.soralis_0912.twifucker2.HookEntry;
/* compiled from: CustomTabsHook.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0012\u001a\u00020\u0010H\u0002J\b\u0010\u0013\u001a\u00020\u0010H\u0002J\b\u0010\u0014\u001a\u00020\u0010H\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0015"}, d2 = {"Licu/nullptr/twifucker/hook/CustomTabsHook;", "Licu/nullptr/twifucker/hook/BaseHook;", "()V", "DOMAIN_WHITELIST_SUFFIX", "", "", "HOOK_CUSTOM_TABS_CLASS", "HOOK_CUSTOM_TABS_GET_METHOD", "HOOK_CUSTOM_TABS_LAUNCH_URL_METHOD", "customTabsClassName", "customTabsGetMethodName", "customTabsLaunchUrlMethodName", "name", "getName", "()Ljava/lang/String;", "init", "", "loadCachedHookInfo", "loadHookInfo", "saveHookInfo", "searchHook", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CustomTabsHook extends BaseHook {
    private static final String HOOK_CUSTOM_TABS_CLASS = "hook_custom_tabs_class";
    private static final String HOOK_CUSTOM_TABS_GET_METHOD = "hook_custom_tabs_get_method";
    private static final String HOOK_CUSTOM_TABS_LAUNCH_URL_METHOD = "hook_custom_tabs_launch_url_method";
    private static String customTabsClassName;
    private static String customTabsGetMethodName;
    private static String customTabsLaunchUrlMethodName;
    public static final CustomTabsHook INSTANCE = new CustomTabsHook();
    private static final List<String> DOMAIN_WHITELIST_SUFFIX = CollectionsKt.listOf((Object[]) new String[]{"pscp.tv", "periscope.tv", "twitter.com", "t.co"});

    private CustomTabsHook() {
    }

    @Override // icu.nullptr.twifucker.hook.BaseHook
    public String getName() {
        return "CustomTabsHook";
    }

    @Override // icu.nullptr.twifucker.hook.BaseHook
    public void init() {
        if (UtilsKt.getModulePrefs().getBoolean("disable_url_redirect", false)) {
            try {
                loadHookInfo();
                HookFactory.f1Static.m38createMethodHook((Method) MethodFinder.f4Static.fromClass(Activity.class).filterByName("startActivity").filterByParamTypes(new Function1<Class<?>[], Boolean>() { // from class: icu.nullptr.twifucker.hook.CustomTabsHook$init$1
                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(Class<?>[] it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        boolean z = false;
                        if (it.length == 2 && Intrinsics.areEqual(it[0], Intent.class) && Intrinsics.areEqual(it[1], Bundle.class)) {
                            z = true;
                        }
                        return Boolean.valueOf(z);
                    }
                }).first(), new Function1<HookFactory, Unit>() { // from class: icu.nullptr.twifucker.hook.CustomTabsHook$init$2
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(HookFactory hookFactory) {
                        invoke2(hookFactory);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(HookFactory createHook) {
                        Intrinsics.checkNotNullParameter(createHook, "$this$createHook");
                        final String name$iv = CustomTabsHook.INSTANCE.getName();
                        createHook.before(new IMethodHookCallback() { // from class: icu.nullptr.twifucker.hook.CustomTabsHook$init$2$invoke$$inlined$beforeMeasure$1
                            @Override // com.github.kyuubiran.ezxhelper.interfaces.IMethodHookCallback
                            public final void onMethodHooked(XC_MethodHook.MethodHookParam it) {
                                Iterable iterable;
                                String str;
                                String str2;
                                String str3;
                                String str4;
                                Intrinsics.checkNotNullParameter(it, "it");
                                long start = System.currentTimeMillis();
                                Object obj = it.thisObject;
                                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.app.Activity");
                                Activity activity = (Activity) obj;
                                boolean z = false;
                                Object obj2 = it.args[0];
                                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type android.content.Intent");
                                Intent intent = (Intent) obj2;
                                if (intent.getCategories() != null && (Intrinsics.areEqual(intent.getAction(), "android.intent.action.VIEW") || intent.getCategories() == null || intent.getCategories().contains("android.intent.category.BROWSABLE"))) {
                                    boolean isInAppBrowserEnabled = UtilsKt.getHostPrefs().getBoolean("in_app_browser", true);
                                    String data = intent.getDataString();
                                    Uri uri = Uri.parse(data);
                                    String host = uri.getHost();
                                    if (host != null) {
                                        iterable = CustomTabsHook.DOMAIN_WHITELIST_SUFFIX;
                                        Iterable $this$any$iv = iterable;
                                        if (!($this$any$iv instanceof Collection) || !((Collection) $this$any$iv).isEmpty()) {
                                            Iterator it2 = $this$any$iv.iterator();
                                            while (true) {
                                                if (!it2.hasNext()) {
                                                    z = false;
                                                    break;
                                                }
                                                Object element$iv = it2.next();
                                                if (StringsKt.endsWith$default(host, (String) element$iv, false, 2, (Object) null)) {
                                                    z = true;
                                                    break;
                                                }
                                            }
                                        }
                                        if (!z) {
                                            str = CustomTabsHook.customTabsClassName;
                                            if (str == null) {
                                                Intrinsics.throwUninitializedPropertyAccessException("customTabsClassName");
                                                str = null;
                                            }
                                            Class customTabsClass = ClassUtils.loadClass$default(str, null, 2, null);
                                            str2 = CustomTabsHook.customTabsGetMethodName;
                                            if (str2 == null) {
                                                Intrinsics.throwUninitializedPropertyAccessException("customTabsGetMethodName");
                                                str2 = null;
                                            }
                                            Object customTabsObj = XposedHelpers.callStaticMethod(customTabsClass, str2, new Object[0]);
                                            it.setResult((Object) null);
                                            if (isInAppBrowserEnabled) {
                                                str3 = CustomTabsHook.customTabsLaunchUrlMethodName;
                                                if (str3 == null) {
                                                    Intrinsics.throwUninitializedPropertyAccessException("customTabsLaunchUrlMethodName");
                                                    str4 = null;
                                                } else {
                                                    str4 = str3;
                                                }
                                                XposedHelpers.callMethod(customTabsObj, str4, new Object[]{activity, data, null, false, true, null});
                                            } else {
                                                Intent newIntent = new Intent("android.intent.action.VIEW", uri);
                                                activity.startActivity(newIntent);
                                            }
                                        }
                                    }
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
        String string = UtilsKt.getModulePrefs().getString(HOOK_CUSTOM_TABS_CLASS, null);
        if (string != null) {
            customTabsClassName = string;
            String string2 = UtilsKt.getModulePrefs().getString(HOOK_CUSTOM_TABS_GET_METHOD, null);
            if (string2 != null) {
                customTabsGetMethodName = string2;
                String string3 = UtilsKt.getModulePrefs().getString(HOOK_CUSTOM_TABS_LAUNCH_URL_METHOD, null);
                if (string3 != null) {
                    customTabsLaunchUrlMethodName = string3;
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
        String str = customTabsClassName;
        String str2 = null;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("customTabsClassName");
            str = null;
        }
        it.putString(HOOK_CUSTOM_TABS_CLASS, str);
        String str3 = customTabsGetMethodName;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("customTabsGetMethodName");
            str3 = null;
        }
        it.putString(HOOK_CUSTOM_TABS_GET_METHOD, str3);
        String str4 = customTabsLaunchUrlMethodName;
        if (str4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("customTabsLaunchUrlMethodName");
        } else {
            str2 = str4;
        }
        it.putString(HOOK_CUSTOM_TABS_LAUNCH_URL_METHOD, str2);
    }

    private final void searchHook() {
        Member memberInstance;
        DexKitBridge this_$iv = HookEntry.Companion.getDexKit();
        MethodUsingStringArgs.Companion companion = MethodUsingStringArgs.Companion;
        MethodUsingStringArgs.Builder $this$searchHook_u24lambda_u241 = new MethodUsingStringArgs.Builder();
        $this$searchHook_u24lambda_u241.setUsingString("^android.support.customtabs.action.CustomTabsService$");
        String name = Void.TYPE.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        $this$searchHook_u24lambda_u241.setMethodReturnType(name);
        DexMethodDescriptor dexMethodDescriptor = (DexMethodDescriptor) CollectionsKt.firstOrNull((List<? extends Object>) this_$iv.findMethodUsingString($this$searchHook_u24lambda_u241.build()));
        Class customTabsClass = (dexMethodDescriptor == null || (memberInstance = dexMethodDescriptor.getMemberInstance(EzXHelper.getClassLoader())) == null) ? null : memberInstance.getDeclaringClass();
        if (customTabsClass == null) {
            throw new ClassNotFoundException();
        }
        Method customTabsGetMethod = (Method) MethodFinder.f4Static.fromClass(customTabsClass).filterStatic().filterByParamCount(0).filterByReturnType(customTabsClass).first();
        Method customTabsLaunchUrlMethod = (Method) MethodFinder.f4Static.fromClass(customTabsClass).filterNonStatic().filterPublic().filterFinal().filterByParamCount(6).filterByParamTypes(new Function1<Class<?>[], Boolean>() { // from class: icu.nullptr.twifucker.hook.CustomTabsHook$searchHook$customTabsLaunchUrlMethod$1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Class<?>[] it) {
                Intrinsics.checkNotNullParameter(it, "it");
                boolean z = false;
                if (Intrinsics.areEqual(it[0], Activity.class) && Intrinsics.areEqual(it[1], String.class) && Intrinsics.areEqual(it[3], Boolean.TYPE) && Intrinsics.areEqual(it[4], Boolean.TYPE) && Intrinsics.areEqual(it[5], String.class)) {
                    z = true;
                }
                return Boolean.valueOf(z);
            }
        }).first();
        String name2 = customTabsClass.getName();
        Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
        customTabsClassName = name2;
        String name3 = customTabsGetMethod.getName();
        Intrinsics.checkNotNullExpressionValue(name3, "getName(...)");
        customTabsGetMethodName = name3;
        String name4 = customTabsLaunchUrlMethod.getName();
        Intrinsics.checkNotNullExpressionValue(name4, "getName(...)");
        customTabsLaunchUrlMethodName = name4;
    }

    private final void loadHookInfo() {
        long hookCustomTabsLastUpdate = UtilsKt.getModulePrefs().getLong("hook_custom_tabs_last_update", 0L);
        long hostAppLastUpdate = UtilsKt.getHostAppLastUpdate();
        Log.d$default("hookCustomTabsLastUpdate: " + hookCustomTabsLastUpdate + ", hostAppLastUpdate: " + hostAppLastUpdate + ", moduleLastModify: " + UtilsKt.getModuleLastModify(), (Throwable) null, 2, (Object) null);
        long timeStart = System.currentTimeMillis();
        if (hookCustomTabsLastUpdate > UtilsKt.getHostAppLastUpdate() && hookCustomTabsLastUpdate > UtilsKt.getModuleLastModify()) {
            loadCachedHookInfo();
            Log.d$default("Custom Tabs Hook load time: " + (System.currentTimeMillis() - timeStart) + " ms", (Throwable) null, 2, (Object) null);
            return;
        }
        HookEntry.Companion.loadDexKit();
        searchHook();
        Log.d$default("Custom Tabs Hook search time: " + (System.currentTimeMillis() - timeStart) + " ms", (Throwable) null, 2, (Object) null);
        saveHookInfo();
        UtilsKt.getModulePrefs().putLong("hook_custom_tabs_last_update", System.currentTimeMillis());
    }
}

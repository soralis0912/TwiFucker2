package icu.nullptr.twifucker.hook;

import com.github.kyuubiran.ezxhelper.ClassUtils;
import com.github.kyuubiran.ezxhelper.EzXHelper;
import com.github.kyuubiran.ezxhelper.HookFactory;
import com.github.kyuubiran.ezxhelper.Log;
import com.github.kyuubiran.ezxhelper.finders.MethodFinder;
import com.github.kyuubiran.ezxhelper.interfaces.IMethodHookCallback;
import com.tencent.mmkv.MMKV;
import de.robv.android.xposed.XC_MethodHook;
import icu.nullptr.twifucker.UtilsKt;
import icu.nullptr.twifucker.exceptions.CachedHookNotFound;
import icu.nullptr.twifucker.ui.SettingsDialog;
import io.luckypray.dexkit.DexKitBridge;
import io.luckypray.dexkit.builder.MethodUsingStringArgs;
import io.luckypray.dexkit.descriptor.member.DexMethodDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.soralis_0912.twifucker2.HookEntry;
/* compiled from: FeatureSwitchHook.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001dH\u0002J\b\u0010\u001f\u001a\u00020\u001dH\u0002J \u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\u0019H\u0002J\b\u0010$\u001a\u00020\u001dH\u0002J\b\u0010%\u001a\u00020\u001dH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R.\u0010\u0010\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0011j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0012`\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006&"}, d2 = {"Licu/nullptr/twifucker/hook/FeatureSwitchHook;", "Licu/nullptr/twifucker/hook/BaseHook;", "()V", "HOOK_FEATURE_SWITCH_CLASS", "", "HOOK_FEATURE_SWITCH_GET_BOOL_METHOD", "HOOK_FEATURE_SWITCH_GET_DOUBLE_METHOD", "HOOK_FEATURE_SWITCH_GET_FLOAT_METHOD", "HOOK_FEATURE_SWITCH_GET_INT_METHOD", "HOOK_FEATURE_SWITCH_GET_LONG_METHOD", "featureSwitchClassName", "featureSwitchGetBoolMethodName", "featureSwitchGetDoubleMethodName", "featureSwitchGetFloatMethodName", "featureSwitchGetIntMethodName", "featureSwitchGetLongMethodName", "featureSwitchHashMap", "Ljava/util/HashMap;", "Ljava/lang/Void;", "Lkotlin/collections/HashMap;", "name", "getName", "()Ljava/lang/String;", "getParamKeyValue", "Lkotlin/Pair;", "", "param", "Lde/robv/android/xposed/XC_MethodHook$MethodHookParam;", "init", "", "loadCachedHookInfo", "loadHookInfo", "logParamKeyResultOnce", "key", "originalResult", "replacedResult", "saveHookInfo", "searchHook", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FeatureSwitchHook extends BaseHook {
    private static final String HOOK_FEATURE_SWITCH_CLASS = "hook_feature_switch_class";
    private static final String HOOK_FEATURE_SWITCH_GET_BOOL_METHOD = "hook_feature_switch_get_bool_method";
    private static final String HOOK_FEATURE_SWITCH_GET_DOUBLE_METHOD = "hook_feature_switch_get_double_method";
    private static final String HOOK_FEATURE_SWITCH_GET_FLOAT_METHOD = "hook_feature_switch_get_float_method";
    private static final String HOOK_FEATURE_SWITCH_GET_INT_METHOD = "hook_feature_switch_get_int_method";
    private static final String HOOK_FEATURE_SWITCH_GET_LONG_METHOD = "hook_feature_switch_get_long_method";
    private static String featureSwitchClassName;
    private static String featureSwitchGetBoolMethodName;
    private static String featureSwitchGetDoubleMethodName;
    private static String featureSwitchGetFloatMethodName;
    private static String featureSwitchGetIntMethodName;
    private static String featureSwitchGetLongMethodName;
    public static final FeatureSwitchHook INSTANCE = new FeatureSwitchHook();
    private static HashMap<String, Void> featureSwitchHashMap = new HashMap<>();

    private FeatureSwitchHook() {
    }

    @Override // icu.nullptr.twifucker.hook.BaseHook
    public String getName() {
        return "FeatureSwitchHook";
    }

    @Override // icu.nullptr.twifucker.hook.BaseHook
    public void init() {
        final JSONArray arr;
        String featureSwitch = UtilsKt.getModulePrefs().getString(SettingsDialog.PREF_FEATURE_SWITCH, "[]");
        try {
            arr = new JSONArray(featureSwitch);
        } catch (JSONException e) {
            arr = new JSONArray("[]");
        }
        if (arr.length() <= 0) {
            return;
        }
        String str = null;
        try {
            loadHookInfo();
            HookFactory.Static r4 = HookFactory.f1Static;
            MethodFinder.Static r5 = MethodFinder.f4Static;
            String str2 = featureSwitchClassName;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("featureSwitchClassName");
                str2 = null;
            }
            MethodFinder fromClass = r5.fromClass(ClassUtils.loadClass$default(str2, null, 2, null));
            String str3 = featureSwitchGetBoolMethodName;
            if (str3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("featureSwitchGetBoolMethodName");
                str3 = null;
            }
            r4.m38createMethodHook((Method) fromClass.filterByName(str3).first(), new Function1<HookFactory, Unit>() { // from class: icu.nullptr.twifucker.hook.FeatureSwitchHook$init$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
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
                    final String name$iv = FeatureSwitchHook.INSTANCE.getName();
                    final JSONArray jSONArray = arr;
                    createHook.after(new IMethodHookCallback() { // from class: icu.nullptr.twifucker.hook.FeatureSwitchHook$init$1$invoke$$inlined$afterMeasure$1
                        @Override // com.github.kyuubiran.ezxhelper.interfaces.IMethodHookCallback
                        public final void onMethodHooked(XC_MethodHook.MethodHookParam it) {
                            Pair paramKV;
                            boolean z;
                            Pair paramKV2;
                            JSONArray $this$forEach$iv;
                            boolean z2;
                            Intrinsics.checkNotNullParameter(it, "it");
                            long start = System.currentTimeMillis();
                            boolean z3 = false;
                            paramKV = FeatureSwitchHook.INSTANCE.getParamKeyValue(it);
                            JSONArray $this$forEach$iv2 = jSONArray;
                            boolean z4 = false;
                            Iterable $this$forEach$iv$iv = RangesKt.until(0, $this$forEach$iv2.length());
                            Iterator<Integer> it2 = $this$forEach$iv$iv.iterator();
                            while (it2.hasNext()) {
                                int element$iv$iv = ((IntIterator) it2).nextInt();
                                if (!($this$forEach$iv2.get(element$iv$iv) instanceof JSONObject)) {
                                    z = z3;
                                    paramKV2 = paramKV;
                                    $this$forEach$iv = $this$forEach$iv2;
                                    z2 = z4;
                                } else {
                                    Object obj = $this$forEach$iv2.get(element$iv$iv);
                                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type org.json.JSONObject");
                                    JSONObject obj2 = (JSONObject) obj;
                                    z = z3;
                                    $this$forEach$iv = $this$forEach$iv2;
                                    if (Intrinsics.areEqual(obj2.optString("type", "boolean"), "boolean")) {
                                        String replaceKey = obj2.optString("key");
                                        boolean replaceValue = obj2.optBoolean("value");
                                        if (Intrinsics.areEqual(paramKV.getFirst(), replaceKey)) {
                                            FeatureSwitchHook featureSwitchHook = FeatureSwitchHook.INSTANCE;
                                            String str4 = (String) paramKV.getFirst();
                                            paramKV2 = paramKV;
                                            Object result = it.getResult();
                                            z2 = z4;
                                            Intrinsics.checkNotNullExpressionValue(result, "getResult(...)");
                                            featureSwitchHook.logParamKeyResultOnce(str4, result, Boolean.valueOf(replaceValue));
                                            it.setResult(Boolean.valueOf(replaceValue));
                                        } else {
                                            paramKV2 = paramKV;
                                            z2 = z4;
                                        }
                                    } else {
                                        paramKV2 = paramKV;
                                        z2 = z4;
                                    }
                                }
                                z3 = z;
                                $this$forEach$iv2 = $this$forEach$iv;
                                paramKV = paramKV2;
                                z4 = z2;
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
            HookFactory.Static r42 = HookFactory.f1Static;
            MethodFinder.Static r52 = MethodFinder.f4Static;
            String str4 = featureSwitchClassName;
            if (str4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("featureSwitchClassName");
                str4 = null;
            }
            MethodFinder fromClass2 = r52.fromClass(ClassUtils.loadClass$default(str4, null, 2, null));
            String str5 = featureSwitchGetDoubleMethodName;
            if (str5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("featureSwitchGetDoubleMethodName");
                str5 = null;
            }
            r42.m38createMethodHook((Method) fromClass2.filterByName(str5).first(), new Function1<HookFactory, Unit>() { // from class: icu.nullptr.twifucker.hook.FeatureSwitchHook$init$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
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
                    final String name$iv = FeatureSwitchHook.INSTANCE.getName();
                    final JSONArray jSONArray = arr;
                    createHook.after(new IMethodHookCallback() { // from class: icu.nullptr.twifucker.hook.FeatureSwitchHook$init$2$invoke$$inlined$afterMeasure$1
                        @Override // com.github.kyuubiran.ezxhelper.interfaces.IMethodHookCallback
                        public final void onMethodHooked(XC_MethodHook.MethodHookParam it) {
                            Pair paramKV;
                            boolean z;
                            Pair paramKV2;
                            JSONArray $this$forEach$iv;
                            boolean z2;
                            Intrinsics.checkNotNullParameter(it, "it");
                            long start = System.currentTimeMillis();
                            boolean z3 = false;
                            paramKV = FeatureSwitchHook.INSTANCE.getParamKeyValue(it);
                            JSONArray $this$forEach$iv2 = jSONArray;
                            boolean z4 = false;
                            Iterable $this$forEach$iv$iv = RangesKt.until(0, $this$forEach$iv2.length());
                            Iterator<Integer> it2 = $this$forEach$iv$iv.iterator();
                            while (it2.hasNext()) {
                                int element$iv$iv = ((IntIterator) it2).nextInt();
                                if (!($this$forEach$iv2.get(element$iv$iv) instanceof JSONObject)) {
                                    z = z3;
                                    paramKV2 = paramKV;
                                    $this$forEach$iv = $this$forEach$iv2;
                                    z2 = z4;
                                } else {
                                    Object obj = $this$forEach$iv2.get(element$iv$iv);
                                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type org.json.JSONObject");
                                    JSONObject obj2 = (JSONObject) obj;
                                    z = z3;
                                    $this$forEach$iv = $this$forEach$iv2;
                                    if (Intrinsics.areEqual(obj2.optString("type", ""), "decimal")) {
                                        String replaceKey = obj2.optString("key");
                                        String replaceValue = obj2.optString("value");
                                        if (Intrinsics.areEqual(paramKV.getFirst(), replaceKey)) {
                                            FeatureSwitchHook featureSwitchHook = FeatureSwitchHook.INSTANCE;
                                            String str6 = (String) paramKV.getFirst();
                                            paramKV2 = paramKV;
                                            Object result = it.getResult();
                                            z2 = z4;
                                            Intrinsics.checkNotNullExpressionValue(result, "getResult(...)");
                                            Intrinsics.checkNotNull(replaceValue);
                                            featureSwitchHook.logParamKeyResultOnce(str6, result, replaceValue);
                                            it.setResult(replaceValue);
                                        } else {
                                            paramKV2 = paramKV;
                                            z2 = z4;
                                        }
                                    } else {
                                        paramKV2 = paramKV;
                                        z2 = z4;
                                    }
                                }
                                z3 = z;
                                $this$forEach$iv2 = $this$forEach$iv;
                                paramKV = paramKV2;
                                z4 = z2;
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
            HookFactory.Static r43 = HookFactory.f1Static;
            MethodFinder.Static r53 = MethodFinder.f4Static;
            String str6 = featureSwitchClassName;
            if (str6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("featureSwitchClassName");
                str6 = null;
            }
            MethodFinder fromClass3 = r53.fromClass(ClassUtils.loadClass$default(str6, null, 2, null));
            String str7 = featureSwitchGetFloatMethodName;
            if (str7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("featureSwitchGetFloatMethodName");
                str7 = null;
            }
            r43.m38createMethodHook((Method) fromClass3.filterByName(str7).first(), new Function1<HookFactory, Unit>() { // from class: icu.nullptr.twifucker.hook.FeatureSwitchHook$init$3
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
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
                    final String name$iv = FeatureSwitchHook.INSTANCE.getName();
                    final JSONArray jSONArray = arr;
                    createHook.after(new IMethodHookCallback() { // from class: icu.nullptr.twifucker.hook.FeatureSwitchHook$init$3$invoke$$inlined$afterMeasure$1
                        @Override // com.github.kyuubiran.ezxhelper.interfaces.IMethodHookCallback
                        public final void onMethodHooked(XC_MethodHook.MethodHookParam it) {
                            Pair paramKV;
                            boolean z;
                            Pair paramKV2;
                            JSONArray $this$forEach$iv;
                            boolean z2;
                            Intrinsics.checkNotNullParameter(it, "it");
                            long start = System.currentTimeMillis();
                            boolean z3 = false;
                            paramKV = FeatureSwitchHook.INSTANCE.getParamKeyValue(it);
                            JSONArray $this$forEach$iv2 = jSONArray;
                            boolean z4 = false;
                            Iterable $this$forEach$iv$iv = RangesKt.until(0, $this$forEach$iv2.length());
                            Iterator<Integer> it2 = $this$forEach$iv$iv.iterator();
                            while (it2.hasNext()) {
                                int element$iv$iv = ((IntIterator) it2).nextInt();
                                if (!($this$forEach$iv2.get(element$iv$iv) instanceof JSONObject)) {
                                    z = z3;
                                    paramKV2 = paramKV;
                                    $this$forEach$iv = $this$forEach$iv2;
                                    z2 = z4;
                                } else {
                                    Object obj = $this$forEach$iv2.get(element$iv$iv);
                                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type org.json.JSONObject");
                                    JSONObject obj2 = (JSONObject) obj;
                                    z = z3;
                                    $this$forEach$iv = $this$forEach$iv2;
                                    if (Intrinsics.areEqual(obj2.optString("type", ""), "decimal")) {
                                        String replaceKey = obj2.optString("key");
                                        String replaceValue = obj2.optString("value");
                                        if (Intrinsics.areEqual(paramKV.getFirst(), replaceKey)) {
                                            FeatureSwitchHook featureSwitchHook = FeatureSwitchHook.INSTANCE;
                                            String str8 = (String) paramKV.getFirst();
                                            paramKV2 = paramKV;
                                            Object result = it.getResult();
                                            z2 = z4;
                                            Intrinsics.checkNotNullExpressionValue(result, "getResult(...)");
                                            Intrinsics.checkNotNull(replaceValue);
                                            featureSwitchHook.logParamKeyResultOnce(str8, result, replaceValue);
                                            it.setResult(replaceValue);
                                        } else {
                                            paramKV2 = paramKV;
                                            z2 = z4;
                                        }
                                    } else {
                                        paramKV2 = paramKV;
                                        z2 = z4;
                                    }
                                }
                                z3 = z;
                                $this$forEach$iv2 = $this$forEach$iv;
                                paramKV = paramKV2;
                                z4 = z2;
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
            HookFactory.Static r44 = HookFactory.f1Static;
            MethodFinder.Static r54 = MethodFinder.f4Static;
            String str8 = featureSwitchClassName;
            if (str8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("featureSwitchClassName");
                str8 = null;
            }
            MethodFinder fromClass4 = r54.fromClass(ClassUtils.loadClass$default(str8, null, 2, null));
            String str9 = featureSwitchGetLongMethodName;
            if (str9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("featureSwitchGetLongMethodName");
                str9 = null;
            }
            r44.m38createMethodHook((Method) fromClass4.filterByName(str9).first(), new Function1<HookFactory, Unit>() { // from class: icu.nullptr.twifucker.hook.FeatureSwitchHook$init$4
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
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
                    final String name$iv = FeatureSwitchHook.INSTANCE.getName();
                    final JSONArray jSONArray = arr;
                    createHook.after(new IMethodHookCallback() { // from class: icu.nullptr.twifucker.hook.FeatureSwitchHook$init$4$invoke$$inlined$afterMeasure$1
                        @Override // com.github.kyuubiran.ezxhelper.interfaces.IMethodHookCallback
                        public final void onMethodHooked(XC_MethodHook.MethodHookParam it) {
                            Pair paramKV;
                            boolean z;
                            Pair paramKV2;
                            JSONArray $this$forEach$iv;
                            boolean z2;
                            Intrinsics.checkNotNullParameter(it, "it");
                            long start = System.currentTimeMillis();
                            boolean z3 = false;
                            paramKV = FeatureSwitchHook.INSTANCE.getParamKeyValue(it);
                            JSONArray $this$forEach$iv2 = jSONArray;
                            boolean z4 = false;
                            Iterable $this$forEach$iv$iv = RangesKt.until(0, $this$forEach$iv2.length());
                            Iterator<Integer> it2 = $this$forEach$iv$iv.iterator();
                            while (it2.hasNext()) {
                                int element$iv$iv = ((IntIterator) it2).nextInt();
                                if (!($this$forEach$iv2.get(element$iv$iv) instanceof JSONObject)) {
                                    z = z3;
                                    paramKV2 = paramKV;
                                    $this$forEach$iv = $this$forEach$iv2;
                                    z2 = z4;
                                } else {
                                    Object obj = $this$forEach$iv2.get(element$iv$iv);
                                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type org.json.JSONObject");
                                    JSONObject obj2 = (JSONObject) obj;
                                    z = z3;
                                    $this$forEach$iv = $this$forEach$iv2;
                                    if (Intrinsics.areEqual(obj2.optString("type", ""), "decimal")) {
                                        String replaceKey = obj2.optString("key");
                                        String replaceValue = obj2.optString("value");
                                        if (Intrinsics.areEqual(paramKV.getFirst(), replaceKey)) {
                                            FeatureSwitchHook featureSwitchHook = FeatureSwitchHook.INSTANCE;
                                            String str10 = (String) paramKV.getFirst();
                                            paramKV2 = paramKV;
                                            Object result = it.getResult();
                                            z2 = z4;
                                            Intrinsics.checkNotNullExpressionValue(result, "getResult(...)");
                                            Intrinsics.checkNotNull(replaceValue);
                                            featureSwitchHook.logParamKeyResultOnce(str10, result, replaceValue);
                                            it.setResult(replaceValue);
                                        } else {
                                            paramKV2 = paramKV;
                                            z2 = z4;
                                        }
                                    } else {
                                        paramKV2 = paramKV;
                                        z2 = z4;
                                    }
                                }
                                z3 = z;
                                $this$forEach$iv2 = $this$forEach$iv;
                                paramKV = paramKV2;
                                z4 = z2;
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
            HookFactory.Static r45 = HookFactory.f1Static;
            MethodFinder.Static r55 = MethodFinder.f4Static;
            String str10 = featureSwitchClassName;
            if (str10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("featureSwitchClassName");
                str10 = null;
            }
            MethodFinder fromClass5 = r55.fromClass(ClassUtils.loadClass$default(str10, null, 2, null));
            String str11 = featureSwitchGetIntMethodName;
            if (str11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("featureSwitchGetIntMethodName");
            } else {
                str = str11;
            }
            r45.m38createMethodHook((Method) fromClass5.filterByName(str).first(), new Function1<HookFactory, Unit>() { // from class: icu.nullptr.twifucker.hook.FeatureSwitchHook$init$5
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
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
                    final String name$iv = FeatureSwitchHook.INSTANCE.getName();
                    final JSONArray jSONArray = arr;
                    createHook.after(new IMethodHookCallback() { // from class: icu.nullptr.twifucker.hook.FeatureSwitchHook$init$5$invoke$$inlined$afterMeasure$1
                        @Override // com.github.kyuubiran.ezxhelper.interfaces.IMethodHookCallback
                        public final void onMethodHooked(XC_MethodHook.MethodHookParam it) {
                            Pair paramKV;
                            boolean z;
                            Pair paramKV2;
                            JSONArray $this$forEach$iv;
                            boolean z2;
                            Intrinsics.checkNotNullParameter(it, "it");
                            long start = System.currentTimeMillis();
                            boolean z3 = false;
                            paramKV = FeatureSwitchHook.INSTANCE.getParamKeyValue(it);
                            JSONArray $this$forEach$iv2 = jSONArray;
                            boolean z4 = false;
                            Iterable $this$forEach$iv$iv = RangesKt.until(0, $this$forEach$iv2.length());
                            Iterator<Integer> it2 = $this$forEach$iv$iv.iterator();
                            while (it2.hasNext()) {
                                int element$iv$iv = ((IntIterator) it2).nextInt();
                                if (!($this$forEach$iv2.get(element$iv$iv) instanceof JSONObject)) {
                                    z = z3;
                                    paramKV2 = paramKV;
                                    $this$forEach$iv = $this$forEach$iv2;
                                    z2 = z4;
                                } else {
                                    Object obj = $this$forEach$iv2.get(element$iv$iv);
                                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type org.json.JSONObject");
                                    JSONObject obj2 = (JSONObject) obj;
                                    z = z3;
                                    $this$forEach$iv = $this$forEach$iv2;
                                    if (Intrinsics.areEqual(obj2.optString("type", ""), "decimal")) {
                                        String replaceKey = obj2.optString("key");
                                        String replaceValue = obj2.optString("value");
                                        if (Intrinsics.areEqual(paramKV.getFirst(), replaceKey)) {
                                            FeatureSwitchHook featureSwitchHook = FeatureSwitchHook.INSTANCE;
                                            String str12 = (String) paramKV.getFirst();
                                            paramKV2 = paramKV;
                                            Object result = it.getResult();
                                            z2 = z4;
                                            Intrinsics.checkNotNullExpressionValue(result, "getResult(...)");
                                            Intrinsics.checkNotNull(replaceValue);
                                            featureSwitchHook.logParamKeyResultOnce(str12, result, replaceValue);
                                            it.setResult(replaceValue);
                                        } else {
                                            paramKV2 = paramKV;
                                            z2 = z4;
                                        }
                                    } else {
                                        paramKV2 = paramKV;
                                        z2 = z4;
                                    }
                                }
                                z3 = z;
                                $this$forEach$iv2 = $this$forEach$iv;
                                paramKV = paramKV2;
                                z4 = z2;
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

    private final void loadCachedHookInfo() {
        String string = UtilsKt.getModulePrefs().getString(HOOK_FEATURE_SWITCH_CLASS, null);
        if (string != null) {
            featureSwitchClassName = string;
            String string2 = UtilsKt.getModulePrefs().getString(HOOK_FEATURE_SWITCH_GET_BOOL_METHOD, null);
            if (string2 != null) {
                featureSwitchGetBoolMethodName = string2;
                String string3 = UtilsKt.getModulePrefs().getString(HOOK_FEATURE_SWITCH_GET_DOUBLE_METHOD, null);
                if (string3 != null) {
                    featureSwitchGetDoubleMethodName = string3;
                    String string4 = UtilsKt.getModulePrefs().getString(HOOK_FEATURE_SWITCH_GET_FLOAT_METHOD, null);
                    if (string4 != null) {
                        featureSwitchGetFloatMethodName = string4;
                        String string5 = UtilsKt.getModulePrefs().getString(HOOK_FEATURE_SWITCH_GET_LONG_METHOD, null);
                        if (string5 != null) {
                            featureSwitchGetLongMethodName = string5;
                            String string6 = UtilsKt.getModulePrefs().getString(HOOK_FEATURE_SWITCH_GET_INT_METHOD, null);
                            if (string6 != null) {
                                featureSwitchGetIntMethodName = string6;
                                return;
                            }
                            throw new CachedHookNotFound();
                        }
                        throw new CachedHookNotFound();
                    }
                    throw new CachedHookNotFound();
                }
                throw new CachedHookNotFound();
            }
            throw new CachedHookNotFound();
        }
        throw new CachedHookNotFound();
    }

    private final void saveHookInfo() {
        MMKV it = UtilsKt.getModulePrefs();
        String str = featureSwitchClassName;
        String str2 = null;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("featureSwitchClassName");
            str = null;
        }
        it.putString(HOOK_FEATURE_SWITCH_CLASS, str);
        String str3 = featureSwitchGetBoolMethodName;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("featureSwitchGetBoolMethodName");
            str3 = null;
        }
        it.putString(HOOK_FEATURE_SWITCH_GET_BOOL_METHOD, str3);
        String str4 = featureSwitchGetDoubleMethodName;
        if (str4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("featureSwitchGetDoubleMethodName");
            str4 = null;
        }
        it.putString(HOOK_FEATURE_SWITCH_GET_DOUBLE_METHOD, str4);
        String str5 = featureSwitchGetFloatMethodName;
        if (str5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("featureSwitchGetFloatMethodName");
            str5 = null;
        }
        it.putString(HOOK_FEATURE_SWITCH_GET_FLOAT_METHOD, str5);
        String str6 = featureSwitchGetLongMethodName;
        if (str6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("featureSwitchGetLongMethodName");
            str6 = null;
        }
        it.putString(HOOK_FEATURE_SWITCH_GET_LONG_METHOD, str6);
        String str7 = featureSwitchGetIntMethodName;
        if (str7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("featureSwitchGetIntMethodName");
        } else {
            str2 = str7;
        }
        it.putString(HOOK_FEATURE_SWITCH_GET_INT_METHOD, str2);
    }

    private final void searchHook() {
        Method methodInstance;
        DexKitBridge this_$iv = HookEntry.Companion.getDexKit();
        MethodUsingStringArgs.Companion companion = MethodUsingStringArgs.Companion;
        MethodUsingStringArgs.Builder $this$searchHook_u24lambda_u241 = new MethodUsingStringArgs.Builder();
        $this$searchHook_u24lambda_u241.setUsingString("^feature_switches_configs_crashlytics_enabled$");
        DexMethodDescriptor dexMethodDescriptor = (DexMethodDescriptor) CollectionsKt.firstOrNull((List<? extends Object>) this_$iv.findMethodUsingString($this$searchHook_u24lambda_u241.build()));
        Class featureSwitchClass = (dexMethodDescriptor == null || (methodInstance = dexMethodDescriptor.getMethodInstance(EzXHelper.getClassLoader())) == null) ? null : methodInstance.getDeclaringClass();
        if (featureSwitchClass == null) {
            throw new ClassNotFoundException();
        }
        Method featureSwitchGetBoolMethod = (Method) MethodFinder.f4Static.fromClass(featureSwitchClass).filterByParamCount(2).filterByReturnType(Boolean.TYPE).first();
        Method featureSwitchGetDoubleMethod = (Method) MethodFinder.f4Static.fromClass(featureSwitchClass).filterByParamCount(2).filterByReturnType(Double.TYPE).first();
        Method featureSwitchGetFloatMethod = (Method) MethodFinder.f4Static.fromClass(featureSwitchClass).filterByParamCount(2).filterByReturnType(Float.TYPE).first();
        Method featureSwitchGetLongMethod = (Method) MethodFinder.f4Static.fromClass(featureSwitchClass).filterByParamCount(2).filterByReturnType(Long.TYPE).first();
        Method featureSwitchGetIntMethod = (Method) MethodFinder.f4Static.fromClass(featureSwitchClass).filterByParamCount(2).filterByReturnType(Integer.TYPE).first();
        String name = featureSwitchClass.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        featureSwitchClassName = name;
        String name2 = featureSwitchGetBoolMethod.getName();
        Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
        featureSwitchGetBoolMethodName = name2;
        String name3 = featureSwitchGetDoubleMethod.getName();
        Intrinsics.checkNotNullExpressionValue(name3, "getName(...)");
        featureSwitchGetDoubleMethodName = name3;
        String name4 = featureSwitchGetFloatMethod.getName();
        Intrinsics.checkNotNullExpressionValue(name4, "getName(...)");
        featureSwitchGetFloatMethodName = name4;
        String name5 = featureSwitchGetLongMethod.getName();
        Intrinsics.checkNotNullExpressionValue(name5, "getName(...)");
        featureSwitchGetLongMethodName = name5;
        String name6 = featureSwitchGetIntMethod.getName();
        Intrinsics.checkNotNullExpressionValue(name6, "getName(...)");
        featureSwitchGetIntMethodName = name6;
    }

    private final void loadHookInfo() {
        long hookFeatureSwitchLastUpdate = UtilsKt.getModulePrefs().getLong("hook_feature_switch_last_update", 0L);
        long hostAppLastUpdate = UtilsKt.getHostAppLastUpdate();
        Log.d$default("hookFeatureSwitchLastUpdate: " + hookFeatureSwitchLastUpdate + ", hostAppLastUpdate: " + hostAppLastUpdate + ", moduleLastModify: " + UtilsKt.getModuleLastModify(), (Throwable) null, 2, (Object) null);
        long timeStart = System.currentTimeMillis();
        if (hookFeatureSwitchLastUpdate > UtilsKt.getHostAppLastUpdate() && hookFeatureSwitchLastUpdate > UtilsKt.getModuleLastModify()) {
            loadCachedHookInfo();
            Log.d$default("Feature Switch Hook load time: " + (System.currentTimeMillis() - timeStart) + " ms", (Throwable) null, 2, (Object) null);
            return;
        }
        HookEntry.Companion.loadDexKit();
        searchHook();
        Log.d$default("Feature Switch Hook search time: " + (System.currentTimeMillis() - timeStart) + " ms", (Throwable) null, 2, (Object) null);
        saveHookInfo();
        UtilsKt.getModulePrefs().putLong("hook_feature_switch_last_update", System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Pair<String, Object> getParamKeyValue(XC_MethodHook.MethodHookParam param) {
        if (Intrinsics.areEqual(param.args[0].getClass(), String.class)) {
            Object obj = param.args[0];
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            return TuplesKt.to((String) obj, param.args[1]);
        }
        Object obj2 = param.args[1];
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
        return TuplesKt.to((String) obj2, param.args[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void logParamKeyResultOnce(String key, Object originalResult, Object replacedResult) {
        if (featureSwitchHashMap.containsKey(key)) {
            return;
        }
        Log.d$default("Replace " + key + " from " + originalResult + " to " + replacedResult, (Throwable) null, 2, (Object) null);
        featureSwitchHashMap.put(key, null);
    }
}

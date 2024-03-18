package icu.nullptr.twifucker.hook.activity;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.github.kyuubiran.ezxhelper.ClassUtils;
import com.github.kyuubiran.ezxhelper.EzXHelper;
import com.github.kyuubiran.ezxhelper.HookFactory;
import com.github.kyuubiran.ezxhelper.Log;
import com.github.kyuubiran.ezxhelper.finders.ConstructorFinder;
import com.github.kyuubiran.ezxhelper.finders.FieldFinder;
import com.github.kyuubiran.ezxhelper.finders.MethodFinder;
import com.tencent.mmkv.MMKV;
import de.robv.android.xposed.XC_MethodHook;
import icu.nullptr.twifucker.UtilsKt;
import icu.nullptr.twifucker.exceptions.CachedHookNotFound;
import icu.nullptr.twifucker.hook.BaseHook;
import icu.nullptr.twifucker.ui.SettingsDialog;
import io.luckypray.dexkit.DexKitBridge;
import io.luckypray.dexkit.builder.MethodInvokingArgs;
import io.luckypray.dexkit.descriptor.member.DexMethodDescriptor;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.soralis_0912.twifucker2.HookEntry;
/* compiled from: SettingsHook.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u000f\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\rH\u0002J\b\u0010\u0011\u001a\u00020\rH\u0002R\u0012\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Licu/nullptr/twifucker/hook/activity/SettingsHook;", "Licu/nullptr/twifucker/hook/BaseHook;", "()V", "aboutActivityClass", "Ljava/lang/Class;", "name", "", "getName", "()Ljava/lang/String;", "onVersionClickListenerClassName", "onVersionClickMethodName", "preferenceClass", "init", "", "loadCachedHookInfo", "loadHookInfo", "saveHookInfo", "searchHook", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SettingsHook extends BaseHook {
    private static String onVersionClickListenerClassName;
    private static String onVersionClickMethodName;
    public static final SettingsHook INSTANCE = new SettingsHook();
    private static final Class<?> aboutActivityClass = ClassUtils.loadClass$default("com.twitter.app.settings.AboutActivity", null, 2, null);
    private static final Class<?> preferenceClass = ClassUtils.loadClass$default("android.preference.Preference", null, 2, null);

    private SettingsHook() {
    }

    @Override // icu.nullptr.twifucker.hook.BaseHook
    public String getName() {
        return "SettingsHook";
    }

    @Override // icu.nullptr.twifucker.hook.BaseHook
    public void init() {
        try {
            final int logoId = UtilsKt.getId("logo", "id");
            ConstructorFinder.f2Static.fromClass(ImageView.class).forEach(new Function1<Constructor<?>, Unit>() { // from class: icu.nullptr.twifucker.hook.activity.SettingsHook$init$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                /* compiled from: SettingsHook.kt */
                @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/github/kyuubiran/ezxhelper/HookFactory;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
                /* renamed from: icu.nullptr.twifucker.hook.activity.SettingsHook$init$1$1  reason: invalid class name */
                /* loaded from: classes.dex */
                public static final class AnonymousClass1 extends Lambda implements Function1<HookFactory, Unit> {
                    final /* synthetic */ int $logoId;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass1(int i) {
                        super(1);
                        this.$logoId = i;
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(HookFactory hookFactory) {
                        invoke2(hookFactory);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(HookFactory createHook) {
                        Intrinsics.checkNotNullParameter(createHook, "$this$createHook");
                        final int i = this.$logoId;
                        createHook.after(
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000c: INVOKE  
                              (r3v0 'createHook' com.github.kyuubiran.ezxhelper.HookFactory A[D('$this$createHook' com.github.kyuubiran.ezxhelper.HookFactory)])
                              (wrap: com.github.kyuubiran.ezxhelper.interfaces.IMethodHookCallback : 0x0009: CONSTRUCTOR  (r1v0 com.github.kyuubiran.ezxhelper.interfaces.IMethodHookCallback A[REMOVE]) = (r0v1 'i' int A[DONT_INLINE]) call: icu.nullptr.twifucker.hook.activity.SettingsHook$init$1$1$$ExternalSyntheticLambda0.<init>(int):void type: CONSTRUCTOR)
                             type: VIRTUAL call: com.github.kyuubiran.ezxhelper.HookFactory.after(com.github.kyuubiran.ezxhelper.interfaces.IMethodHookCallback):void in method: icu.nullptr.twifucker.hook.activity.SettingsHook$init$1.1.invoke(com.github.kyuubiran.ezxhelper.HookFactory):void, file: classes.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:309)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:272)
                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:91)
                            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:296)
                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:275)
                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:377)
                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:306)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:272)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: icu.nullptr.twifucker.hook.activity.SettingsHook$init$1$1$$ExternalSyntheticLambda0, state: NOT_LOADED
                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:302)
                            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:769)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:718)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:417)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:144)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1097)
                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:872)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:421)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:302)
                            	... 15 more
                            */
                        /*
                            this = this;
                            java.lang.String r0 = "$this$createHook"
                            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                            int r0 = r2.$logoId
                            icu.nullptr.twifucker.hook.activity.SettingsHook$init$1$1$$ExternalSyntheticLambda0 r1 = new icu.nullptr.twifucker.hook.activity.SettingsHook$init$1$1$$ExternalSyntheticLambda0
                            r1.<init>(r0)
                            r3.after(r1)
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: icu.nullptr.twifucker.hook.activity.SettingsHook$init$1.AnonymousClass1.invoke2(com.github.kyuubiran.ezxhelper.HookFactory):void");
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final void invoke$lambda$1(int $logoId, XC_MethodHook.MethodHookParam param) {
                        Intrinsics.checkNotNullParameter(param, "param");
                        Object obj = param.thisObject;
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.widget.ImageView");
                        final ImageView view = (ImageView) obj;
                        int mId = view.getId();
                        if ($logoId != mId) {
                            return;
                        }
                        view.setOnLongClickListener(
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x001a: INVOKE  
                              (r0v2 'view' android.widget.ImageView A[D('view' android.widget.ImageView)])
                              (wrap: android.view.View$OnLongClickListener : 0x0017: CONSTRUCTOR  (r2v0 android.view.View$OnLongClickListener A[REMOVE]) = (r0v2 'view' android.widget.ImageView A[D('view' android.widget.ImageView), DONT_INLINE]) call: icu.nullptr.twifucker.hook.activity.SettingsHook$init$1$1$$ExternalSyntheticLambda1.<init>(android.widget.ImageView):void type: CONSTRUCTOR)
                             type: VIRTUAL call: android.widget.ImageView.setOnLongClickListener(android.view.View$OnLongClickListener):void in method: icu.nullptr.twifucker.hook.activity.SettingsHook$init$1.1.invoke$lambda$1(int, de.robv.android.xposed.XC_MethodHook$MethodHookParam):void, file: classes.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:309)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:272)
                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:91)
                            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:296)
                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:275)
                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:377)
                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:306)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:272)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: icu.nullptr.twifucker.hook.activity.SettingsHook$init$1$1$$ExternalSyntheticLambda1, state: NOT_LOADED
                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:302)
                            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:769)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:718)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:417)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:144)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1097)
                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:872)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:421)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:302)
                            	... 19 more
                            */
                        /*
                            java.lang.String r0 = "param"
                            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
                            java.lang.Object r0 = r4.thisObject
                            java.lang.String r1 = "null cannot be cast to non-null type android.widget.ImageView"
                            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r1)
                            android.widget.ImageView r0 = (android.widget.ImageView) r0
                            int r1 = r0.getId()
                            if (r3 == r1) goto L15
                            return
                        L15:
                            icu.nullptr.twifucker.hook.activity.SettingsHook$init$1$1$$ExternalSyntheticLambda1 r2 = new icu.nullptr.twifucker.hook.activity.SettingsHook$init$1$1$$ExternalSyntheticLambda1
                            r2.<init>(r0)
                            r0.setOnLongClickListener(r2)
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: icu.nullptr.twifucker.hook.activity.SettingsHook$init$1.AnonymousClass1.invoke$lambda$1(int, de.robv.android.xposed.XC_MethodHook$MethodHookParam):void");
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final boolean invoke$lambda$1$lambda$0(ImageView view, View it) {
                        Intrinsics.checkNotNullParameter(view, "$view");
                        Context context = view.getContext();
                        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                        new SettingsDialog(context);
                        return true;
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Constructor<?> constructor) {
                    invoke2(constructor);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Constructor<?> cons) {
                    Intrinsics.checkNotNullParameter(cons, "cons");
                    HookFactory.f1Static.m35createConstructorHook(cons, new AnonymousClass1(logoId));
                }
            });
        } catch (Throwable t) {
            Log.e$default(t, (String) null, 2, (Object) null);
        }
        Method onVersionClickMethod = (Method) MethodFinder.f4Static.fromClass(aboutActivityClass).filterByParamTypes(preferenceClass).firstOrNull();
        if (onVersionClickMethod != null) {
            HookFactory.f1Static.m38createMethodHook(onVersionClickMethod, new Function1<HookFactory, Unit>() { // from class: icu.nullptr.twifucker.hook.activity.SettingsHook$init$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(HookFactory hookFactory) {
                    invoke2(hookFactory);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(HookFactory createHook) {
                    Intrinsics.checkNotNullParameter(createHook, "$this$createHook");
                    final String name$iv = SettingsHook.INSTANCE.getName();
                    createHook.replace(new Function1<XC_MethodHook.MethodHookParam, Object>() { // from class: icu.nullptr.twifucker.hook.activity.SettingsHook$init$2$invoke$$inlined$replaceMeasure$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(XC_MethodHook.MethodHookParam it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            long start = System.currentTimeMillis();
                            Object obj = it.thisObject;
                            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.app.Activity");
                            new SettingsDialog((Activity) obj);
                            long end = System.currentTimeMillis();
                            long elapsed = end - start;
                            if (elapsed > 10) {
                                Log.d$default(name$iv + " elapsed: " + (System.currentTimeMillis() - start) + "ms", (Throwable) null, 2, (Object) null);
                            }
                            return true;
                        }
                    });
                }
            });
            return;
        }
        try {
            loadHookInfo();
            String str = onVersionClickListenerClassName;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("onVersionClickListenerClassName");
                str = null;
            }
            Class onVersionClickListenerClass = ClassUtils.loadClass$default(str, null, 2, null);
            final Field activityField = (Field) FieldFinder.f3Static.fromClass(onVersionClickListenerClass).filterByType(aboutActivityClass).first();
            HookFactory.f1Static.m38createMethodHook((Method) MethodFinder.f4Static.fromClass(onVersionClickListenerClass).filterByParamTypes(preferenceClass).first(), new Function1<HookFactory, Unit>() { // from class: icu.nullptr.twifucker.hook.activity.SettingsHook$init$3
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
                    final String name$iv = SettingsHook.INSTANCE.getName();
                    final Field field = activityField;
                    createHook.replace(new Function1<XC_MethodHook.MethodHookParam, Object>() { // from class: icu.nullptr.twifucker.hook.activity.SettingsHook$init$3$invoke$$inlined$replaceMeasure$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(XC_MethodHook.MethodHookParam it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            long start = System.currentTimeMillis();
                            Object obj = field.get(it.thisObject);
                            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.app.Activity");
                            new SettingsDialog((Activity) obj);
                            long end = System.currentTimeMillis();
                            long elapsed = end - start;
                            if (elapsed > 10) {
                                Log.d$default(name$iv + " elapsed: " + (System.currentTimeMillis() - start) + "ms", (Throwable) null, 2, (Object) null);
                            }
                            return true;
                        }
                    });
                }
            });
        } catch (Throwable t2) {
            Log.e$default(t2, (String) null, 2, (Object) null);
        }
    }

    private final void loadCachedHookInfo() {
        String string = UtilsKt.getModulePrefs().getString("hook_on_version_click_listener_class", null);
        if (string != null) {
            onVersionClickListenerClassName = string;
            return;
        }
        throw new CachedHookNotFound();
    }

    private final void saveHookInfo() {
        MMKV modulePrefs = UtilsKt.getModulePrefs();
        String str = onVersionClickListenerClassName;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("onVersionClickListenerClassName");
            str = null;
        }
        modulePrefs.putString("hook_on_version_click_listener_class", str);
    }

    private final void searchHook() {
        Class cls;
        List<DexMethodDescriptor> list;
        DexMethodDescriptor dexMethodDescriptor;
        Member memberInstance;
        Method onCreateMethod = (Method) MethodFinder.f4Static.fromClass(aboutActivityClass).filterByName("onCreate").first();
        DexKitBridge this_$iv = HookEntry.Companion.getDexKit();
        MethodInvokingArgs.Companion companion = MethodInvokingArgs.Companion;
        MethodInvokingArgs.Builder $this$searchHook_u24lambda_u240 = new MethodInvokingArgs.Builder();
        $this$searchHook_u24lambda_u240.setMethodDescriptor(new DexMethodDescriptor(onCreateMethod).getDescriptor());
        $this$searchHook_u24lambda_u240.setBeInvokedMethodName("<init>");
        String name = Void.TYPE.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        $this$searchHook_u24lambda_u240.setBeInvokedMethodReturnType(name);
        String name2 = aboutActivityClass.getName();
        Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
        $this$searchHook_u24lambda_u240.setBeInvokedMethodParameterTypes(new String[]{name2});
        Iterator<Map.Entry<DexMethodDescriptor, List<DexMethodDescriptor>>> it = this_$iv.findMethodInvoking($this$searchHook_u24lambda_u240.build()).entrySet().iterator();
        while (true) {
            cls = null;
            if (!it.hasNext()) {
                list = null;
                break;
            }
            Map.Entry it2 = it.next();
            list = it2.getValue();
            if (list != null) {
                break;
            }
        }
        if (list != null && (dexMethodDescriptor = (DexMethodDescriptor) CollectionsKt.firstOrNull((List<? extends Object>) list)) != null && (memberInstance = dexMethodDescriptor.getMemberInstance(EzXHelper.getClassLoader())) != null) {
            cls = memberInstance.getDeclaringClass();
        }
        if (cls == null) {
            throw new ClassNotFoundException();
        }
        Class onPreferenceClickListenerClass = cls;
        Method onVersionClickMethod = (Method) MethodFinder.f4Static.fromClass(onPreferenceClickListenerClass).filterByParamTypes(preferenceClass).first();
        String name3 = onPreferenceClickListenerClass.getName();
        Intrinsics.checkNotNullExpressionValue(name3, "getName(...)");
        onVersionClickListenerClassName = name3;
        String name4 = onVersionClickMethod.getName();
        Intrinsics.checkNotNullExpressionValue(name4, "getName(...)");
        onVersionClickMethodName = name4;
    }

    private final void loadHookInfo() {
        long hookSettingsLastUpdate = UtilsKt.getModulePrefs().getLong("hook_settings_last_update", 0L);
        long hostAppLastUpdate = UtilsKt.getHostAppLastUpdate();
        Log.d$default("hookSettingsLastUpdate: " + hookSettingsLastUpdate + ", hostAppLastUpdate: " + hostAppLastUpdate + ", moduleLastModify: " + UtilsKt.getModuleLastModify(), (Throwable) null, 2, (Object) null);
        long timeStart = System.currentTimeMillis();
        if (hookSettingsLastUpdate > UtilsKt.getHostAppLastUpdate() && hookSettingsLastUpdate > UtilsKt.getModuleLastModify()) {
            loadCachedHookInfo();
            Log.d$default("Settings Hook load time: " + (System.currentTimeMillis() - timeStart) + " ms", (Throwable) null, 2, (Object) null);
            return;
        }
        HookEntry.Companion.loadDexKit();
        searchHook();
        Log.d$default("Settings Hook search time: " + (System.currentTimeMillis() - timeStart) + " ms", (Throwable) null, 2, (Object) null);
        saveHookInfo();
        UtilsKt.getModulePrefs().putLong("hook_settings_last_update", System.currentTimeMillis());
    }
}

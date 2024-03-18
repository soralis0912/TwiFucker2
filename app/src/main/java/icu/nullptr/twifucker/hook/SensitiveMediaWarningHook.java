package icu.nullptr.twifucker.hook;

import com.github.kyuubiran.ezxhelper.ClassUtils;
import com.github.kyuubiran.ezxhelper.HookFactory;
import com.github.kyuubiran.ezxhelper.Log;
import com.github.kyuubiran.ezxhelper.finders.FieldFinder;
import com.github.kyuubiran.ezxhelper.finders.MethodFinder;
import com.github.kyuubiran.ezxhelper.interfaces.IMethodHookCallback;
import de.robv.android.xposed.XC_MethodHook;
import icu.nullptr.twifucker.UtilsKt;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
/* compiled from: SensitiveMediaWarningHook.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Licu/nullptr/twifucker/hook/SensitiveMediaWarningHook;", "Licu/nullptr/twifucker/hook/BaseHook;", "()V", "name", "", "getName", "()Ljava/lang/String;", "init", "", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SensitiveMediaWarningHook extends BaseHook {
    public static final SensitiveMediaWarningHook INSTANCE = new SensitiveMediaWarningHook();

    private SensitiveMediaWarningHook() {
    }

    @Override // icu.nullptr.twifucker.hook.BaseHook
    public String getName() {
        return "SensitiveMediaWarningHook";
    }

    @Override // icu.nullptr.twifucker.hook.BaseHook
    public void init() {
        if (UtilsKt.getModulePrefs().getBoolean("disable_sensitive_media_warning", false)) {
            Class jsonSensitiveMediaWarningClass = ClassUtils.loadClass$default("com.twitter.model.json.core.JsonSensitiveMediaWarning", null, 2, null);
            Class jsonSensitiveMediaWarningMapperClass = ClassUtils.loadClass$default("com.twitter.model.json.core.JsonSensitiveMediaWarning$$JsonObjectMapper", null, 2, null);
            final FieldFinder warningFields = FieldFinder.f3Static.fromClass(jsonSensitiveMediaWarningClass).filterByType(Boolean.TYPE);
            HookFactory.f1Static.m38createMethodHook((Method) MethodFinder.f4Static.fromClass(jsonSensitiveMediaWarningMapperClass).filterByName("_parse").filterByReturnType(jsonSensitiveMediaWarningClass).first(), new Function1<HookFactory, Unit>() { // from class: icu.nullptr.twifucker.hook.SensitiveMediaWarningHook$init$1
                /* JADX INFO: Access modifiers changed from: package-private */
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
                    final String name$iv = SensitiveMediaWarningHook.INSTANCE.getName();
                    final FieldFinder fieldFinder = FieldFinder.this;
                    createHook.after(new IMethodHookCallback() { // from class: icu.nullptr.twifucker.hook.SensitiveMediaWarningHook$init$1$invoke$$inlined$afterMeasure$1
                        @Override // com.github.kyuubiran.ezxhelper.interfaces.IMethodHookCallback
                        public final void onMethodHooked(final XC_MethodHook.MethodHookParam it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            long start = System.currentTimeMillis();
                            Object result = it.getResult();
                            if (result != null) {
                                Intrinsics.checkNotNull(result);
                                final Ref.IntRef count = new Ref.IntRef();
                                fieldFinder.forEach(new Function1<Field, Unit>() { // from class: icu.nullptr.twifucker.hook.SensitiveMediaWarningHook$init$1$1$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(Field field) {
                                        invoke2(field);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                    public final void invoke2(Field field) {
                                        Intrinsics.checkNotNullParameter(field, "field");
                                        Object value = field.get(it.getResult());
                                        XC_MethodHook.MethodHookParam methodHookParam = it;
                                        Ref.IntRef intRef = count;
                                        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.Boolean");
                                        if (((Boolean) value).booleanValue()) {
                                            field.set(methodHookParam.getResult(), false);
                                            intRef.element++;
                                        }
                                    }
                                });
                                if (count.element > 0) {
                                    Log.d$default("Set " + count.element + " sensitive media warning field(s) to false", (Throwable) null, 2, (Object) null);
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
        }
    }
}

package icu.nullptr.twifucker.hook;

import android.app.Activity;
import android.content.ClipData;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.github.kyuubiran.ezxhelper.ClassUtils;
import com.github.kyuubiran.ezxhelper.HookFactory;
import com.github.kyuubiran.ezxhelper.Log;
import com.github.kyuubiran.ezxhelper.finders.MethodFinder;
import com.github.kyuubiran.ezxhelper.interfaces.IMethodHookCallback;
import de.robv.android.xposed.XC_MethodHook;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
/* compiled from: UrlHook.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\f\u0010\u000b\u001a\u00020\f*\u00020\u0004H\u0002J\f\u0010\r\u001a\u00020\f*\u00020\u0004H\u0002R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000e"}, d2 = {"Licu/nullptr/twifucker/hook/UrlHook;", "Licu/nullptr/twifucker/hook/BaseHook;", "()V", "name", "", "getName", "()Ljava/lang/String;", "clearExtraParams", "url", "init", "", "hasExtraParam", "", "isTwitterUrl", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class UrlHook extends BaseHook {
    public static final UrlHook INSTANCE = new UrlHook();

    private UrlHook() {
    }

    @Override // icu.nullptr.twifucker.hook.BaseHook
    public String getName() {
        return "UrlHook";
    }

    @Override // icu.nullptr.twifucker.hook.BaseHook
    public void init() {
        HookFactory.f1Static.m38createMethodHook((Method) MethodFinder.f4Static.fromClass(Intent.class).filterByName("replaceExtras").filterByParamTypes(Bundle.class).first(), new Function1<HookFactory, Unit>() { // from class: icu.nullptr.twifucker.hook.UrlHook$init$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(HookFactory hookFactory) {
                invoke2(hookFactory);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(HookFactory createHook) {
                Intrinsics.checkNotNullParameter(createHook, "$this$createHook");
                final String name$iv = UrlHook.INSTANCE.getName();
                createHook.before(new IMethodHookCallback() { // from class: icu.nullptr.twifucker.hook.UrlHook$init$1$invoke$$inlined$beforeMeasure$1
                    @Override // com.github.kyuubiran.ezxhelper.interfaces.IMethodHookCallback
                    public final void onMethodHooked(XC_MethodHook.MethodHookParam it) {
                        boolean isTwitterUrl;
                        String newExtraText;
                        Intrinsics.checkNotNullParameter(it, "it");
                        long start = System.currentTimeMillis();
                        Object obj = it.args[0];
                        if (obj != null) {
                            Intrinsics.checkNotNull(obj);
                            Object obj2 = it.args[0];
                            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type android.os.Bundle");
                            Bundle bundle = (Bundle) obj2;
                            String extraText = bundle.getString("android.intent.extra.TEXT");
                            if (extraText != null) {
                                Intrinsics.checkNotNull(extraText);
                                isTwitterUrl = UrlHook.INSTANCE.isTwitterUrl(extraText);
                                if (isTwitterUrl) {
                                    newExtraText = UrlHook.INSTANCE.clearExtraParams(extraText);
                                    bundle.putString("android.intent.extra.TEXT", newExtraText);
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
        MethodFinder.f4Static.fromClass(Intent.class).filterByName("createChooser").filterByParamCount(new IntRange(2, 3)).filterByParamTypes(new Function1<Class<?>[], Boolean>() { // from class: icu.nullptr.twifucker.hook.UrlHook$init$2
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Class<?>[] it) {
                Intrinsics.checkNotNullParameter(it, "it");
                boolean z = false;
                if (Intrinsics.areEqual(it[0], Intent.class) && Intrinsics.areEqual(it[1], CharSequence.class)) {
                    z = true;
                }
                return Boolean.valueOf(z);
            }
        }).forEach(new Function1<Method, Unit>() { // from class: icu.nullptr.twifucker.hook.UrlHook$init$3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Method method) {
                invoke2(method);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Method it) {
                Intrinsics.checkNotNullParameter(it, "it");
                HookFactory.f1Static.m38createMethodHook(it, new Function1<HookFactory, Unit>() { // from class: icu.nullptr.twifucker.hook.UrlHook$init$3.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(HookFactory hookFactory) {
                        invoke2(hookFactory);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(HookFactory createHook) {
                        Intrinsics.checkNotNullParameter(createHook, "$this$createHook");
                        final String name$iv = UrlHook.INSTANCE.getName();
                        createHook.before(new IMethodHookCallback() { // from class: icu.nullptr.twifucker.hook.UrlHook$init$3$1$invoke$$inlined$beforeMeasure$1
                            @Override // com.github.kyuubiran.ezxhelper.interfaces.IMethodHookCallback
                            public final void onMethodHooked(XC_MethodHook.MethodHookParam it2) {
                                boolean isTwitterUrl;
                                String clearExtraParams;
                                Intrinsics.checkNotNullParameter(it2, "it");
                                long start = System.currentTimeMillis();
                                Object obj = it2.args[0];
                                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.content.Intent");
                                Intent intent = (Intent) obj;
                                String extraText = intent.getStringExtra("android.intent.extra.TEXT");
                                if (extraText != null) {
                                    Intrinsics.checkNotNull(extraText);
                                    isTwitterUrl = UrlHook.INSTANCE.isTwitterUrl(extraText);
                                    if (isTwitterUrl) {
                                        clearExtraParams = UrlHook.INSTANCE.clearExtraParams(extraText);
                                        intent.putExtra("android.intent.extra.TEXT", clearExtraParams);
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
        });
        HookFactory.f1Static.m38createMethodHook((Method) MethodFinder.f4Static.fromClass(ClipData.class).filterByName("newPlainText").filterByParamTypes(CharSequence.class, CharSequence.class).first(), new Function1<HookFactory, Unit>() { // from class: icu.nullptr.twifucker.hook.UrlHook$init$4
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(HookFactory hookFactory) {
                invoke2(hookFactory);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(HookFactory createHook) {
                Intrinsics.checkNotNullParameter(createHook, "$this$createHook");
                final String name$iv = UrlHook.INSTANCE.getName();
                createHook.before(new IMethodHookCallback() { // from class: icu.nullptr.twifucker.hook.UrlHook$init$4$invoke$$inlined$beforeMeasure$1
                    @Override // com.github.kyuubiran.ezxhelper.interfaces.IMethodHookCallback
                    public final void onMethodHooked(XC_MethodHook.MethodHookParam it) {
                        boolean isTwitterUrl;
                        String clearExtraParams;
                        Intrinsics.checkNotNullParameter(it, "it");
                        long start = System.currentTimeMillis();
                        Object obj = it.args[1];
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.CharSequence");
                        String text = ((CharSequence) obj).toString();
                        isTwitterUrl = UrlHook.INSTANCE.isTwitterUrl(text);
                        if (isTwitterUrl) {
                            Object[] objArr = it.args;
                            clearExtraParams = UrlHook.INSTANCE.clearExtraParams(text);
                            objArr[1] = clearExtraParams;
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
        HookFactory.f1Static.m38createMethodHook((Method) MethodFinder.f4Static.fromClass(ClassUtils.loadClass$default("com.twitter.deeplink.implementation.UrlInterpreterActivity", null, 2, null)).filterByName("onCreate").first(), new Function1<HookFactory, Unit>() { // from class: icu.nullptr.twifucker.hook.UrlHook$init$5
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(HookFactory hookFactory) {
                invoke2(hookFactory);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(HookFactory createHook) {
                Intrinsics.checkNotNullParameter(createHook, "$this$createHook");
                final String name$iv = UrlHook.INSTANCE.getName();
                createHook.before(new IMethodHookCallback() { // from class: icu.nullptr.twifucker.hook.UrlHook$init$5$invoke$$inlined$beforeMeasure$1
                    @Override // com.github.kyuubiran.ezxhelper.interfaces.IMethodHookCallback
                    public final void onMethodHooked(XC_MethodHook.MethodHookParam it) {
                        boolean isTwitterUrl;
                        String newUrl;
                        Intrinsics.checkNotNullParameter(it, "it");
                        long start = System.currentTimeMillis();
                        Object obj = it.thisObject;
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.app.Activity");
                        Intent intent = ((Activity) obj).getIntent();
                        String url = String.valueOf(intent.getData());
                        isTwitterUrl = UrlHook.INSTANCE.isTwitterUrl(url);
                        if (isTwitterUrl) {
                            newUrl = UrlHook.INSTANCE.clearExtraParams(url);
                            intent.setData(Uri.parse(newUrl));
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

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isTwitterUrl(String $this$isTwitterUrl) {
        Uri uri = Uri.parse($this$isTwitterUrl);
        return (Intrinsics.areEqual(uri.getScheme(), "https") || Intrinsics.areEqual(uri.getScheme(), "http")) && (Intrinsics.areEqual(uri.getHost(), "twitter.com") || Intrinsics.areEqual(uri.getHost(), "www.twitter.com") || Intrinsics.areEqual(uri.getHost(), "mobile.twitter.com"));
    }

    private final boolean hasExtraParam(String $this$hasExtraParam) {
        return Intrinsics.areEqual($this$hasExtraParam, "t") || Intrinsics.areEqual($this$hasExtraParam, "s");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String clearExtraParams(String url) {
        Log.d$default("Handle Url before: " + url, (Throwable) null, 2, (Object) null);
        Uri oldUri = Uri.parse(url);
        Uri.Builder newUri = oldUri.buildUpon().clearQuery();
        Iterable queryParameterNames = oldUri.getQueryParameterNames();
        Intrinsics.checkNotNullExpressionValue(queryParameterNames, "getQueryParameterNames(...)");
        Iterable $this$forEach$iv = queryParameterNames;
        for (Object element$iv : $this$forEach$iv) {
            String it = (String) element$iv;
            UrlHook urlHook = INSTANCE;
            Intrinsics.checkNotNull(it);
            if (!urlHook.hasExtraParam(it)) {
                newUri.appendQueryParameter(it, oldUri.getQueryParameter(it));
            }
        }
        String newUrl = newUri.build().toString();
        Intrinsics.checkNotNullExpressionValue(newUrl, "toString(...)");
        Log.d$default("Handle Url after: " + newUrl, (Throwable) null, 2, (Object) null);
        return newUrl;
    }
}

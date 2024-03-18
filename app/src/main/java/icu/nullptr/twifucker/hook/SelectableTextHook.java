package icu.nullptr.twifucker.hook;

import android.widget.TextView;
import com.github.kyuubiran.ezxhelper.HookFactory;
import com.github.kyuubiran.ezxhelper.Log;
import com.github.kyuubiran.ezxhelper.finders.MethodFinder;
import com.github.kyuubiran.ezxhelper.interfaces.IMethodHookCallback;
import de.robv.android.xposed.XC_MethodHook;
import icu.nullptr.twifucker.UtilsKt;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SelectableTextHook.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Licu/nullptr/twifucker/hook/SelectableTextHook;", "Licu/nullptr/twifucker/hook/BaseHook;", "()V", "name", "", "getName", "()Ljava/lang/String;", "init", "", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SelectableTextHook extends BaseHook {
    public static final SelectableTextHook INSTANCE = new SelectableTextHook();

    private SelectableTextHook() {
    }

    @Override // icu.nullptr.twifucker.hook.BaseHook
    public String getName() {
        return "SelectableTextHook";
    }

    @Override // icu.nullptr.twifucker.hook.BaseHook
    public void init() {
        Iterable $this$map$iv = CollectionsKt.listOf((Object[]) new String[]{"user_name", "user_bio", "profile_header_location", "text", "secondary_text"});
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            String it = (String) item$iv$iv;
            destination$iv$iv.add(Integer.valueOf(UtilsKt.getId(it, "id")));
        }
        final List notSelectableText = (List) destination$iv$iv;
        HookFactory.f1Static.m38createMethodHook((Method) MethodFinder.f4Static.fromClass(TextView.class).filterByName("setText").filterByParamCount(4).first(), new Function1<HookFactory, Unit>() { // from class: icu.nullptr.twifucker.hook.SelectableTextHook$init$1
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
                final String name$iv = SelectableTextHook.INSTANCE.getName();
                final List<Integer> list = notSelectableText;
                createHook.after(new IMethodHookCallback() { // from class: icu.nullptr.twifucker.hook.SelectableTextHook$init$1$invoke$$inlined$afterMeasure$1
                    @Override // com.github.kyuubiran.ezxhelper.interfaces.IMethodHookCallback
                    public final void onMethodHooked(XC_MethodHook.MethodHookParam it2) {
                        Intrinsics.checkNotNullParameter(it2, "it");
                        long start = System.currentTimeMillis();
                        Object obj = it2.thisObject;
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.widget.TextView");
                        TextView textView = (TextView) obj;
                        if (list.contains(Integer.valueOf(textView.getId())) && !textView.isTextSelectable()) {
                            textView.setTextIsSelectable(true);
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

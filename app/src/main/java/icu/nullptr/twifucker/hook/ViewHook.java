package icu.nullptr.twifucker.hook;

import android.view.View;
import com.github.kyuubiran.ezxhelper.HookFactory;
import com.github.kyuubiran.ezxhelper.finders.MethodFinder;
import icu.nullptr.twifucker.UtilsKt;
import java.lang.reflect.Method;
import kotlin.Metadata;
/* compiled from: ViewHook.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Licu/nullptr/twifucker/hook/ViewHook;", "Licu/nullptr/twifucker/hook/BaseHook;", "()V", "name", "", "getName", "()Ljava/lang/String;", "init", "", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ViewHook extends BaseHook {
    public static final ViewHook INSTANCE = new ViewHook();

    private ViewHook() {
    }

    @Override // icu.nullptr.twifucker.hook.BaseHook
    public String getName() {
        return "ViewHook";
    }

    @Override // icu.nullptr.twifucker.hook.BaseHook
    public void init() {
        if (UtilsKt.getModulePrefs().getBoolean("disable_banner_view", false)) {
            HookFactory.f1Static.m38createMethodHook((Method) MethodFinder.f4Static.fromClass(View.class).filterByName("setVisibility").first(), ViewHook$init$1.INSTANCE);
        }
    }
}

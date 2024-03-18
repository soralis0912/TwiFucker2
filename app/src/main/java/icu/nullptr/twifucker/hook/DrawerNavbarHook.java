package icu.nullptr.twifucker.hook;

import com.github.kyuubiran.ezxhelper.ClassUtils;
import com.github.kyuubiran.ezxhelper.HookFactory;
import com.github.kyuubiran.ezxhelper.Log;
import com.github.kyuubiran.ezxhelper.finders.MethodFinder;
import com.github.kyuubiran.ezxhelper.interfaces.IMethodHookCallback;
import com.tencent.mmkv.MMKV;
import de.robv.android.xposed.XC_MethodHook;
import icu.nullptr.twifucker.UtilsKt;
import icu.nullptr.twifucker.data.TwitterItem;
import icu.nullptr.twifucker.exceptions.CachedHookNotFound;
import icu.nullptr.twifucker.ui.SettingsDialog;
import io.luckypray.dexkit.DexKitBridge;
import io.luckypray.dexkit.builder.MethodOpcodeArgs;
import io.luckypray.dexkit.descriptor.member.DexMethodDescriptor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.soralis_0912.twifucker2.HookEntry;
/* compiled from: DrawerNavbarHook.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0002J\b\u0010\u001c\u001a\u00020\u001aH\u0002J\b\u0010\u001d\u001a\u00020\u001aH\u0002J\b\u0010\u001e\u001a\u00020\u001aH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\f\"\u0004\b\u0013\u0010\u000eR\u000e\u0010\u0014\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001f"}, d2 = {"Licu/nullptr/twifucker/hook/DrawerNavbarHook;", "Licu/nullptr/twifucker/hook/BaseHook;", "()V", "HOOK_BOTTOM_NAVBAR_ITEMS_CLASS", "", "HOOK_BOTTOM_NAVBAR_ITEMS_GET_METHOD", "HOOK_DRAWER_ITEMS_CLASS", "HOOK_DRAWER_ITEMS_GET_METHOD", "bottomNavbarItems", "", "Licu/nullptr/twifucker/data/TwitterItem;", "getBottomNavbarItems", "()Ljava/util/List;", "setBottomNavbarItems", "(Ljava/util/List;)V", "bottomNavbarItemsClassName", "bottomNavbarItemsGetMethod", "drawerItems", "getDrawerItems", "setDrawerItems", "drawerItemsClassName", "drawerItemsGetMethod", "name", "getName", "()Ljava/lang/String;", "init", "", "loadCachedHookInfo", "loadHookInfo", "saveHookInfo", "searchHook", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DrawerNavbarHook extends BaseHook {
    private static final String HOOK_BOTTOM_NAVBAR_ITEMS_CLASS = "hook_bottom_navbar_items_class";
    private static final String HOOK_BOTTOM_NAVBAR_ITEMS_GET_METHOD = "hook_bottom_navbar_items_get_method";
    private static final String HOOK_DRAWER_ITEMS_CLASS = "hook_drawer_items_class";
    private static final String HOOK_DRAWER_ITEMS_GET_METHOD = "hook_drawer_items_get_method";
    private static String bottomNavbarItemsClassName;
    private static String bottomNavbarItemsGetMethod;
    private static String drawerItemsClassName;
    private static String drawerItemsGetMethod;
    public static final DrawerNavbarHook INSTANCE = new DrawerNavbarHook();
    private static List<TwitterItem> drawerItems = new ArrayList();
    private static List<TwitterItem> bottomNavbarItems = new ArrayList();

    private DrawerNavbarHook() {
    }

    @Override // icu.nullptr.twifucker.hook.BaseHook
    public String getName() {
        return "DrawerNavbarHook";
    }

    public final List<TwitterItem> getDrawerItems() {
        return drawerItems;
    }

    public final void setDrawerItems(List<TwitterItem> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        drawerItems = list;
    }

    public final List<TwitterItem> getBottomNavbarItems() {
        return bottomNavbarItems;
    }

    public final void setBottomNavbarItems(List<TwitterItem> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        bottomNavbarItems = list;
    }

    @Override // icu.nullptr.twifucker.hook.BaseHook
    public void init() {
        String str = null;
        try {
            loadHookInfo();
            HookFactory.Static r2 = HookFactory.f1Static;
            MethodFinder.Static r3 = MethodFinder.f4Static;
            String str2 = drawerItemsClassName;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("drawerItemsClassName");
                str2 = null;
            }
            MethodFinder fromClass = r3.fromClass(ClassUtils.loadClass$default(str2, null, 2, null));
            String str3 = drawerItemsGetMethod;
            if (str3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("drawerItemsGetMethod");
                str3 = null;
            }
            r2.m38createMethodHook((Method) fromClass.filterByName(str3).first(), new Function1<HookFactory, Unit>() { // from class: icu.nullptr.twifucker.hook.DrawerNavbarHook$init$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(HookFactory hookFactory) {
                    invoke2(hookFactory);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(HookFactory createHook) {
                    Intrinsics.checkNotNullParameter(createHook, "$this$createHook");
                    final String name$iv = DrawerNavbarHook.INSTANCE.getName();
                    createHook.after(new IMethodHookCallback() { // from class: icu.nullptr.twifucker.hook.DrawerNavbarHook$init$1$invoke$$inlined$afterMeasure$1
                        /* JADX WARN: Code restructure failed: missing block: B:14:0x0077, code lost:
                            if (r5.contains(r14) == true) goto L13;
                         */
                        @Override // com.github.kyuubiran.ezxhelper.interfaces.IMethodHookCallback
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public final void onMethodHooked(XC_MethodHook.MethodHookParam it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            long start = System.currentTimeMillis();
                            boolean z = false;
                            Set hiddenItems = UtilsKt.getModulePrefs().getStringSet(SettingsDialog.PREF_HIDDEN_DRAWER_ITEMS, new LinkedHashSet());
                            DrawerNavbarHook.INSTANCE.getDrawerItems().clear();
                            Object result = it.getResult();
                            Intrinsics.checkNotNull(result, "null cannot be cast to non-null type kotlin.collections.List<*>");
                            Iterable originalDrawerItems = (List) result;
                            List newDrawerItems = CollectionsKt.toMutableList((Collection) ((Collection) originalDrawerItems));
                            Iterable $this$forEach$iv = originalDrawerItems;
                            for (Object element$iv : $this$forEach$iv) {
                                String itemName = String.valueOf(element$iv);
                                boolean z2 = z;
                                DrawerNavbarHook.INSTANCE.getDrawerItems().add(new TwitterItem(itemName, (hiddenItems == null || hiddenItems.contains(itemName)) ? false : true));
                                boolean z3 = hiddenItems != null;
                                if (z3 && !Intrinsics.areEqual(itemName, "SettingsAndSupportGroup")) {
                                    newDrawerItems.remove(element$iv);
                                }
                                z = z2;
                            }
                            it.setResult(CollectionsKt.toList(newDrawerItems));
                            long end = System.currentTimeMillis();
                            long elapsed = end - start;
                            if (elapsed > 10) {
                                Log.d$default(name$iv + " elapsed: " + (System.currentTimeMillis() - start) + "ms", (Throwable) null, 2, (Object) null);
                            }
                        }
                    });
                }
            });
            HookFactory.Static r22 = HookFactory.f1Static;
            MethodFinder.Static r32 = MethodFinder.f4Static;
            String str4 = bottomNavbarItemsClassName;
            if (str4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomNavbarItemsClassName");
                str4 = null;
            }
            MethodFinder fromClass2 = r32.fromClass(ClassUtils.loadClass$default(str4, null, 2, null));
            String str5 = bottomNavbarItemsGetMethod;
            if (str5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomNavbarItemsGetMethod");
            } else {
                str = str5;
            }
            r22.m38createMethodHook((Method) fromClass2.filterByName(str).first(), new Function1<HookFactory, Unit>() { // from class: icu.nullptr.twifucker.hook.DrawerNavbarHook$init$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(HookFactory hookFactory) {
                    invoke2(hookFactory);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(HookFactory createHook) {
                    Intrinsics.checkNotNullParameter(createHook, "$this$createHook");
                    final String name$iv = DrawerNavbarHook.INSTANCE.getName();
                    createHook.after(new IMethodHookCallback() { // from class: icu.nullptr.twifucker.hook.DrawerNavbarHook$init$2$invoke$$inlined$afterMeasure$1
                        /* JADX WARN: Code restructure failed: missing block: B:14:0x0078, code lost:
                            if (r5.contains(r14) == true) goto L13;
                         */
                        @Override // com.github.kyuubiran.ezxhelper.interfaces.IMethodHookCallback
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public final void onMethodHooked(XC_MethodHook.MethodHookParam it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            long start = System.currentTimeMillis();
                            boolean z = false;
                            Set hiddenItems = UtilsKt.getModulePrefs().getStringSet(SettingsDialog.PREF_HIDDEN_BOTTOM_NAVBAR_ITEMS, new LinkedHashSet());
                            DrawerNavbarHook.INSTANCE.getBottomNavbarItems().clear();
                            Object result = it.getResult();
                            Intrinsics.checkNotNull(result, "null cannot be cast to non-null type kotlin.collections.List<*>");
                            Iterable originalBottomNavbarItems = (List) result;
                            List newBottomNavbarItems = CollectionsKt.toMutableList((Collection) ((Collection) originalBottomNavbarItems));
                            Iterable $this$forEach$iv = originalBottomNavbarItems;
                            for (Object element$iv : $this$forEach$iv) {
                                String itemName = String.valueOf(element$iv);
                                boolean z2 = z;
                                DrawerNavbarHook.INSTANCE.getBottomNavbarItems().add(new TwitterItem(itemName, (hiddenItems == null || hiddenItems.contains(itemName)) ? false : true));
                                boolean z3 = hiddenItems != null;
                                if (z3) {
                                    newBottomNavbarItems.remove(element$iv);
                                }
                                z = z2;
                            }
                            it.setResult(CollectionsKt.toList(newBottomNavbarItems));
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
        MMKV it = UtilsKt.getModulePrefs();
        String string = it.getString(HOOK_DRAWER_ITEMS_CLASS, null);
        if (string != null) {
            Intrinsics.checkNotNull(string);
            drawerItemsClassName = string;
            String string2 = it.getString(HOOK_DRAWER_ITEMS_GET_METHOD, null);
            if (string2 != null) {
                Intrinsics.checkNotNull(string2);
                drawerItemsGetMethod = string2;
                String string3 = it.getString(HOOK_BOTTOM_NAVBAR_ITEMS_CLASS, null);
                if (string3 != null) {
                    Intrinsics.checkNotNull(string3);
                    bottomNavbarItemsClassName = string3;
                    String string4 = it.getString(HOOK_BOTTOM_NAVBAR_ITEMS_GET_METHOD, null);
                    if (string4 == null) {
                        throw new CachedHookNotFound();
                    }
                    bottomNavbarItemsGetMethod = string4;
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
        String str = drawerItemsClassName;
        String str2 = null;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("drawerItemsClassName");
            str = null;
        }
        it.putString(HOOK_DRAWER_ITEMS_CLASS, str);
        String str3 = drawerItemsGetMethod;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("drawerItemsGetMethod");
            str3 = null;
        }
        it.putString(HOOK_DRAWER_ITEMS_GET_METHOD, str3);
        String str4 = bottomNavbarItemsClassName;
        if (str4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomNavbarItemsClassName");
            str4 = null;
        }
        it.putString(HOOK_BOTTOM_NAVBAR_ITEMS_CLASS, str4);
        String str5 = bottomNavbarItemsGetMethod;
        if (str5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomNavbarItemsGetMethod");
        } else {
            str2 = str5;
        }
        it.putString(HOOK_BOTTOM_NAVBAR_ITEMS_GET_METHOD, str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x011b A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void searchHook() {
        boolean z;
        DexKitBridge this_$iv = HookEntry.Companion.getDexKit();
        MethodOpcodeArgs.Companion companion = MethodOpcodeArgs.Companion;
        MethodOpcodeArgs.Builder $this$searchHook_u24lambda_u242 = new MethodOpcodeArgs.Builder();
        $this$searchHook_u24lambda_u242.setOpSeq(new int[]{19, 35, 98, 18, 77, 98, 18, 77, 98, 18, 77, 98, 18, 77, 98, 18, 77, 98, 18, 77, 98, 18, 77, 98, 18, 77, 98, 19, 77, 98, 19, 77, 98, 19, 77, 98, 19, 77, 98, 19, 77, 98, 19, 77, 98, 19, 77, 98, 19, 77});
        $this$searchHook_u24lambda_u242.setMethodName("invoke");
        String name = Object.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        $this$searchHook_u24lambda_u242.setMethodReturnType(name);
        $this$searchHook_u24lambda_u242.setMethodParamTypes(new String[0]);
        DexMethodDescriptor drawerClassDesc = (DexMethodDescriptor) CollectionsKt.first((List<? extends Object>) this_$iv.findMethodUsingOpPrefixSeq($this$searchHook_u24lambda_u242.build()));
        DexKitBridge this_$iv2 = HookEntry.Companion.getDexKit();
        MethodOpcodeArgs.Companion companion2 = MethodOpcodeArgs.Companion;
        MethodOpcodeArgs.Builder $this$searchHook_u24lambda_u243 = new MethodOpcodeArgs.Builder();
        $this$searchHook_u24lambda_u243.setOpSeq(new int[]{84, 110, 113, 10, 84, 114, 10});
        String name2 = List.class.getName();
        Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
        $this$searchHook_u24lambda_u243.setMethodReturnType(name2);
        $this$searchHook_u24lambda_u243.setMethodParamTypes(new String[0]);
        Iterable $this$first$iv = this_$iv2.findMethodUsingOpPrefixSeq($this$searchHook_u24lambda_u243.build());
        for (Object element$iv : $this$first$iv) {
            DexMethodDescriptor method = (DexMethodDescriptor) element$iv;
            Class clazz = ClassUtils.loadClass$default(method.getDeclaringClassName(), null, 2, null);
            if (clazz.getDeclaredFields().length == 2) {
                z = true;
                if (clazz.getDeclaredMethods().length == 1) {
                    continue;
                    if (z) {
                        DexMethodDescriptor bottomNavbarDesc = (DexMethodDescriptor) element$iv;
                        drawerItemsClassName = drawerClassDesc.getDeclaringClassName();
                        drawerItemsGetMethod = drawerClassDesc.getName();
                        bottomNavbarItemsClassName = bottomNavbarDesc.getDeclaringClassName();
                        bottomNavbarItemsGetMethod = bottomNavbarDesc.getName();
                        return;
                    }
                }
            }
            z = false;
            continue;
            if (z) {
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    private final void loadHookInfo() {
        long hookDrawerLastUpdate = UtilsKt.getModulePrefs().getLong("hook_drawer_last_update", 0L);
        long hostAppLastUpdate = UtilsKt.getHostAppLastUpdate();
        Log.d$default("hookDrawerLastUpdate: " + hookDrawerLastUpdate + ", hostAppLastUpdate: " + hostAppLastUpdate + ", moduleLastModify: " + UtilsKt.getModuleLastModify(), (Throwable) null, 2, (Object) null);
        long timeStart = System.currentTimeMillis();
        if (hookDrawerLastUpdate > UtilsKt.getHostAppLastUpdate() && hookDrawerLastUpdate > UtilsKt.getModuleLastModify()) {
            loadCachedHookInfo();
            Log.d$default("Drawer Hook load time: " + (System.currentTimeMillis() - timeStart) + " ms", (Throwable) null, 2, (Object) null);
            return;
        }
        HookEntry.Companion.loadDexKit();
        searchHook();
        Log.d$default("Drawer Hook search time: " + (System.currentTimeMillis() - timeStart) + " ms", (Throwable) null, 2, (Object) null);
        saveHookInfo();
        UtilsKt.getModulePrefs().putLong("hook_drawer_last_update", System.currentTimeMillis());
    }
}

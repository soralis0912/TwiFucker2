package icu.nullptr.twifucker.hook;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.github.kyuubiran.ezxhelper.ClassUtils;
import com.github.kyuubiran.ezxhelper.EzXHelper;
import com.github.kyuubiran.ezxhelper.HookFactory;
import com.github.kyuubiran.ezxhelper.Log;
import com.github.kyuubiran.ezxhelper.MemberExtensions;
import com.github.kyuubiran.ezxhelper.finders.ConstructorFinder;
import com.github.kyuubiran.ezxhelper.finders.FieldFinder;
import com.github.kyuubiran.ezxhelper.finders.MethodFinder;
import com.github.kyuubiran.ezxhelper.interfaces.IMethodHookCallback;
import com.tencent.mmkv.MMKV;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import icu.nullptr.twifucker.UtilsKt;
import icu.nullptr.twifucker.exceptions.CachedHookNotFound;
import icu.nullptr.twifucker.ui.DownloadDialog;
import io.luckypray.dexkit.DexKitBridge;
import io.luckypray.dexkit.builder.MethodInvokingArgs;
import io.luckypray.dexkit.builder.MethodOpcodeArgs;
import io.luckypray.dexkit.builder.MethodUsingStringArgs;
import io.luckypray.dexkit.descriptor.member.DexMethodDescriptor;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.soralis_0912.twifucker2.HookEntry;
import org.soralis_0912.twifucker2.R;
/* compiled from: DownloadHook.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001f\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0002\b\u0017\n\u0002\u0010\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010=\u001a\u00020>H\u0016J\b\u0010?\u001a\u00020>H\u0002J\b\u0010@\u001a\u00020>H\u0002J\b\u0010A\u001a\u00020>H\u0002J\b\u0010B\u001a\u00020>H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00040$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010-\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/R\u000e\u00100\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000¨\u0006C"}, d2 = {"Licu/nullptr/twifucker/hook/DownloadHook;", "Licu/nullptr/twifucker/hook/BaseHook;", "()V", "HOOK_ACTION_ENUM_CLASS", "", "HOOK_ACTION_ENUM_WRAPPED_CLASS", "HOOK_ACTION_ENUM_WRAPPED_INNER_CLASS", "HOOK_ACTION_ITEM_VIEW_DATA_FIELD", "HOOK_ACTION_SHEET_ITEM_CLASS", "HOOK_ACTION_SHEET_ITEM_FIELD", "HOOK_EXTENDED_ENTITIES_FIELD", "HOOK_LEGACY_FIELD", "HOOK_MEDIA_FIELD", "HOOK_MEDIA_INFO_FIELD", "HOOK_MEDIA_TYPE_FIELD", "HOOK_MEDIA_URL_HTTPS_FIELD", "HOOK_PROTECTED_SHARE_ITEM_ADAPTER_CLASS", "HOOK_PROTECTED_SHARE_TWEET_ITEM_ADAPTER_CLASS_TITLE_FIELD", "HOOK_RESULT_FIELD", "HOOK_SHARE_MENU_CLASS", "HOOK_SHARE_MENU_METHOD", "HOOK_SHARE_TWEET_ITEM_ADAPTER_FIELD", "HOOK_SHARE_TWEET_ON_CLICK_LISTENER_CLASS", "HOOK_TWEET_ID_FIELD", "HOOK_TWEET_RESULT_FIELD", "HOOK_TWEET_SHARE_CLASS", "HOOK_TWEET_SHARE_LIST_FIELD", "HOOK_TWEET_SHARE_SHOW_METHOD", "HOOK_VARIANTS_FIELD", "actionEnumClassName", "actionEnumWrappedClassName", "actionEnumWrappedInnerClassName", "actionItemViewDataFieldName", "actionSheetItemClassName", "actionSheetItemFieldName", "cachedDownloadUrls", "", "cachedTweetId", "", "extendedEntitiesFieldName", "legacyFieldName", "mediaFieldName", "mediaInfoFieldName", "mediaTypeFieldName", "mediaUrlHttpsFieldName", "name", "getName", "()Ljava/lang/String;", "protectedShareTweetItemAdapterClassName", "protectedShareTweetItemAdapterClassTitleFieldName", "resultFieldName", "shareMenuClassName", "shareMenuMethodName", "shareTweetItemAdapterFieldName", "shareTweetOnClickListenerClassName", "tweetIdFieldName", "tweetResultFieldName", "tweetShareClassName", "tweetShareShareListFieldName", "tweetShareShowMethodName", "variantsFieldName", "init", "", "loadCachedHookInfo", "loadHookInfo", "saveHookInfo", "searchHook", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DownloadHook extends BaseHook {
    private static final String HOOK_ACTION_ENUM_CLASS = "hook_action_enum_class";
    private static final String HOOK_ACTION_ENUM_WRAPPED_CLASS = "hook_action_enum_wrapped_class";
    private static final String HOOK_ACTION_ENUM_WRAPPED_INNER_CLASS = "hook_action_enum_wrapped_inner_class";
    private static final String HOOK_ACTION_ITEM_VIEW_DATA_FIELD = "hook_action_item_view_data_field";
    private static final String HOOK_ACTION_SHEET_ITEM_CLASS = "hook_action_sheet_item_class";
    private static final String HOOK_ACTION_SHEET_ITEM_FIELD = "hook_action_sheet_item_field";
    private static final String HOOK_EXTENDED_ENTITIES_FIELD = "hook_extended_entities_field";
    private static final String HOOK_LEGACY_FIELD = "hook_legacy_field";
    private static final String HOOK_MEDIA_FIELD = "hook_media_field";
    private static final String HOOK_MEDIA_INFO_FIELD = "hook_media_info_field";
    private static final String HOOK_MEDIA_TYPE_FIELD = "hook_media_type_field";
    private static final String HOOK_MEDIA_URL_HTTPS_FIELD = "hook_media_url_https_field";
    private static final String HOOK_PROTECTED_SHARE_ITEM_ADAPTER_CLASS = "hook_protected_share_item_adapter_class";
    private static final String HOOK_PROTECTED_SHARE_TWEET_ITEM_ADAPTER_CLASS_TITLE_FIELD = "hook_protected_share_tweet_item_adapter_class_title_field";
    private static final String HOOK_RESULT_FIELD = "hook_result_field";
    private static final String HOOK_SHARE_MENU_CLASS = "hook_share_menu_class";
    private static final String HOOK_SHARE_MENU_METHOD = "hook_share_menu_method";
    private static final String HOOK_SHARE_TWEET_ITEM_ADAPTER_FIELD = "hook_share_tweet_item_adapter_field";
    private static final String HOOK_SHARE_TWEET_ON_CLICK_LISTENER_CLASS = "hook_share_tweet_on_click_listener_class";
    private static final String HOOK_TWEET_ID_FIELD = "hook_tweet_id_field";
    private static final String HOOK_TWEET_RESULT_FIELD = "hook_tweet_result_field";
    private static final String HOOK_TWEET_SHARE_CLASS = "hook_tweet_share_class";
    private static final String HOOK_TWEET_SHARE_LIST_FIELD = "hook_tweet_share_list_field";
    private static final String HOOK_TWEET_SHARE_SHOW_METHOD = "hook_tweet_share_show_method";
    private static final String HOOK_VARIANTS_FIELD = "hook_variants_field";
    private static String actionEnumClassName;
    private static String actionEnumWrappedClassName;
    private static String actionEnumWrappedInnerClassName;
    private static String actionItemViewDataFieldName;
    private static String actionSheetItemClassName;
    private static String actionSheetItemFieldName;
    private static long cachedTweetId;
    private static String extendedEntitiesFieldName;
    private static String legacyFieldName;
    private static String mediaFieldName;
    private static String mediaInfoFieldName;
    private static String mediaTypeFieldName;
    private static String mediaUrlHttpsFieldName;
    private static String protectedShareTweetItemAdapterClassName;
    private static String protectedShareTweetItemAdapterClassTitleFieldName;
    private static String resultFieldName;
    private static String shareMenuClassName;
    private static String shareMenuMethodName;
    private static String shareTweetItemAdapterFieldName;
    private static String shareTweetOnClickListenerClassName;
    private static String tweetIdFieldName;
    private static String tweetResultFieldName;
    private static String tweetShareClassName;
    private static String tweetShareShareListFieldName;
    private static String tweetShareShowMethodName;
    private static String variantsFieldName;
    public static final DownloadHook INSTANCE = new DownloadHook();
    private static List<String> cachedDownloadUrls = CollectionsKt.emptyList();

    private DownloadHook() {
    }

    @Override // icu.nullptr.twifucker.hook.BaseHook
    public String getName() {
        return "DownloadHook";
    }

    @Override // icu.nullptr.twifucker.hook.BaseHook
    public void init() {
        if (UtilsKt.getModulePrefs().getBoolean("enable_download_hook", false)) {
            String str = null;
            try {
                loadHookInfo();
                String className = shareTweetOnClickListenerClassName;
                if (className == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("shareTweetOnClickListenerClassName");
                    className = null;
                }
                if (!(className.length() == 0)) {
                    HookFactory.f1Static.m38createMethodHook((Method) MethodFinder.f4Static.fromClass(ClassUtils.loadClass$default(className, null, 2, null)).filterByName("onClick").first(), new Function1<HookFactory, Unit>() { // from class: icu.nullptr.twifucker.hook.DownloadHook$init$1$1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(HookFactory hookFactory) {
                            invoke2(hookFactory);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2(HookFactory createHook) {
                            Intrinsics.checkNotNullParameter(createHook, "$this$createHook");
                            final String name$iv = DownloadHook.INSTANCE.getName();
                            createHook.before(new IMethodHookCallback() { // from class: icu.nullptr.twifucker.hook.DownloadHook$init$1$1$invoke$$inlined$beforeMeasure$1
                                @Override // com.github.kyuubiran.ezxhelper.interfaces.IMethodHookCallback
                                public final void onMethodHooked(XC_MethodHook.MethodHookParam it) {
                                    long j;
                                    List list;
                                    String str2;
                                    String str3;
                                    long j2;
                                    List list2;
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    long start = System.currentTimeMillis();
                                    j = DownloadHook.cachedTweetId;
                                    if (j != 0) {
                                        list = DownloadHook.cachedDownloadUrls;
                                        if (!list.isEmpty()) {
                                            Object obj = it.thisObject;
                                            str2 = DownloadHook.shareTweetItemAdapterFieldName;
                                            if (str2 == null) {
                                                Intrinsics.throwUninitializedPropertyAccessException("shareTweetItemAdapterFieldName");
                                                str2 = null;
                                            }
                                            Object objectField = XposedHelpers.getObjectField(obj, str2);
                                            str3 = DownloadHook.actionItemViewDataFieldName;
                                            if (str3 == null) {
                                                Intrinsics.throwUninitializedPropertyAccessException("actionItemViewDataFieldName");
                                                str3 = null;
                                            }
                                            Object actionItemViewData = XposedHelpers.getObjectField(objectField, str3);
                                            EzXHelper.addModuleAssetPath(EzXHelper.getAppContext());
                                            if (Intrinsics.areEqual(XposedHelpers.getObjectField(actionItemViewData, "b"), EzXHelper.getAppContext().getString(R.string.download_or_copy))) {
                                                try {
                                                    Activity act = HookEntry.Companion.getCurrentActivity().get();
                                                    if (act != null) {
                                                        Intrinsics.checkNotNull(act);
                                                        j2 = DownloadHook.cachedTweetId;
                                                        list2 = DownloadHook.cachedDownloadUrls;
                                                        new DownloadDialog(act, j2, list2, new Function0<Unit>() { // from class: icu.nullptr.twifucker.hook.DownloadHook$init$1$1$1$1$1
                                                            @Override // kotlin.jvm.functions.Function0
                                                            public /* bridge */ /* synthetic */ Unit invoke() {
                                                                invoke2();
                                                                return Unit.INSTANCE;
                                                            }

                                                            /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                                            public final void invoke2() {
                                                                DownloadHook downloadHook = DownloadHook.INSTANCE;
                                                                DownloadHook.cachedTweetId = 0L;
                                                                DownloadHook downloadHook2 = DownloadHook.INSTANCE;
                                                                DownloadHook.cachedDownloadUrls = CollectionsKt.emptyList();
                                                            }
                                                        });
                                                    }
                                                } catch (Throwable t) {
                                                    Log.e$default(t, (String) null, 2, (Object) null);
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
                }
                HookFactory.Static r2 = HookFactory.f1Static;
                MethodFinder.Static r3 = MethodFinder.f4Static;
                String str2 = protectedShareTweetItemAdapterClassName;
                if (str2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("protectedShareTweetItemAdapterClassName");
                    str2 = null;
                }
                r2.m38createMethodHook((Method) r3.fromClass(ClassUtils.loadClass$default(str2, null, 2, null)).filterByName("onClick").first(), new Function1<HookFactory, Unit>() { // from class: icu.nullptr.twifucker.hook.DownloadHook$init$2
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(HookFactory hookFactory) {
                        invoke2(hookFactory);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(HookFactory createHook) {
                        Intrinsics.checkNotNullParameter(createHook, "$this$createHook");
                        final String name$iv = DownloadHook.INSTANCE.getName();
                        createHook.before(new IMethodHookCallback() { // from class: icu.nullptr.twifucker.hook.DownloadHook$init$2$invoke$$inlined$beforeMeasure$1
                            @Override // com.github.kyuubiran.ezxhelper.interfaces.IMethodHookCallback
                            public final void onMethodHooked(XC_MethodHook.MethodHookParam it) {
                                long j;
                                List list;
                                String str3;
                                long j2;
                                List list2;
                                Intrinsics.checkNotNullParameter(it, "it");
                                long start = System.currentTimeMillis();
                                j = DownloadHook.cachedTweetId;
                                if (j != 0) {
                                    list = DownloadHook.cachedDownloadUrls;
                                    if (!list.isEmpty()) {
                                        Object obj = it.thisObject;
                                        str3 = DownloadHook.protectedShareTweetItemAdapterClassTitleFieldName;
                                        if (str3 == null) {
                                            Intrinsics.throwUninitializedPropertyAccessException("protectedShareTweetItemAdapterClassTitleFieldName");
                                            str3 = null;
                                        }
                                        Object objectField = XposedHelpers.getObjectField(obj, str3);
                                        Intrinsics.checkNotNull(objectField, "null cannot be cast to non-null type android.widget.TextView");
                                        TextView protectedShareTweetItemAdapterTitleTextView = (TextView) objectField;
                                        EzXHelper.addModuleAssetPath(EzXHelper.getAppContext());
                                        if (Intrinsics.areEqual(protectedShareTweetItemAdapterTitleTextView.getText(), EzXHelper.getAppContext().getString(R.string.download_or_copy))) {
                                            try {
                                                Activity act = HookEntry.Companion.getCurrentActivity().get();
                                                if (act != null) {
                                                    Intrinsics.checkNotNull(act);
                                                    j2 = DownloadHook.cachedTweetId;
                                                    list2 = DownloadHook.cachedDownloadUrls;
                                                    new DownloadDialog(act, j2, list2, new Function0<Unit>() { // from class: icu.nullptr.twifucker.hook.DownloadHook$init$2$1$1$1
                                                        @Override // kotlin.jvm.functions.Function0
                                                        public /* bridge */ /* synthetic */ Unit invoke() {
                                                            invoke2();
                                                            return Unit.INSTANCE;
                                                        }

                                                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                                        public final void invoke2() {
                                                            DownloadHook downloadHook = DownloadHook.INSTANCE;
                                                            DownloadHook.cachedTweetId = 0L;
                                                            DownloadHook downloadHook2 = DownloadHook.INSTANCE;
                                                            DownloadHook.cachedDownloadUrls = CollectionsKt.emptyList();
                                                        }
                                                    });
                                                }
                                            } catch (Throwable t) {
                                                Log.e$default(t, (String) null, 2, (Object) null);
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
                HookFactory.Static r22 = HookFactory.f1Static;
                MethodFinder.Static r32 = MethodFinder.f4Static;
                String str3 = tweetShareClassName;
                if (str3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tweetShareClassName");
                    str3 = null;
                }
                MethodFinder fromClass = r32.fromClass(ClassUtils.loadClass$default(str3, null, 2, null));
                String str4 = tweetShareShowMethodName;
                if (str4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tweetShareShowMethodName");
                    str4 = null;
                }
                r22.m38createMethodHook((Method) fromClass.filterByName(str4).first(), new Function1<HookFactory, Unit>() { // from class: icu.nullptr.twifucker.hook.DownloadHook$init$3
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(HookFactory hookFactory) {
                        invoke2(hookFactory);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(HookFactory createHook) {
                        Intrinsics.checkNotNullParameter(createHook, "$this$createHook");
                        final String name$iv = DownloadHook.INSTANCE.getName();
                        createHook.before(new IMethodHookCallback() { // from class: icu.nullptr.twifucker.hook.DownloadHook$init$3$invoke$$inlined$beforeMeasure$1
                            @Override // com.github.kyuubiran.ezxhelper.interfaces.IMethodHookCallback
                            public final void onMethodHooked(XC_MethodHook.MethodHookParam it) {
                                String str5;
                                String str6;
                                String str7;
                                String str8;
                                Object dlButton;
                                String str9;
                                String str10;
                                String str11;
                                Intrinsics.checkNotNullParameter(it, "it");
                                long start = System.currentTimeMillis();
                                Object obj = it.thisObject;
                                str5 = DownloadHook.tweetShareShareListFieldName;
                                if (str5 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("tweetShareShareListFieldName");
                                    str5 = null;
                                }
                                Object objectField = XposedHelpers.getObjectField(obj, str5);
                                Intrinsics.checkNotNull(objectField, "null cannot be cast to non-null type kotlin.collections.List<*>");
                                List shareList = (List) objectField;
                                List mutList = CollectionsKt.toMutableList((Collection) shareList);
                                str6 = DownloadHook.actionEnumWrappedInnerClassName;
                                if (str6 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("actionEnumWrappedInnerClassName");
                                    str6 = null;
                                }
                                Class actionEnumWrappedClass = ClassUtils.loadClass$default(str6, null, 2, null);
                                str7 = DownloadHook.actionEnumClassName;
                                if (str7 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("actionEnumClassName");
                                    str7 = null;
                                }
                                Class actionEnumClass = ClassUtils.loadClass$default(str7, null, 2, null);
                                str8 = DownloadHook.actionSheetItemClassName;
                                if (str8 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("actionSheetItemClassName");
                                    str8 = null;
                                }
                                Class actionSheetItemClass = ClassUtils.loadClass$default(str8, null, 2, null);
                                Object actionEnumWrapped = XposedHelpers.newInstance(actionEnumWrappedClass, new Object[]{XposedHelpers.callStaticMethod(actionEnumClass, "valueOf", new Object[]{"None"}), ""});
                                EzXHelper.addModuleAssetPath(EzXHelper.getAppContext());
                                Constructor buttonConstructor = (Constructor) ConstructorFinder.f2Static.fromClass(actionSheetItemClass).filterByParamCount(3).filterByParamTypes(new Function1<Class<?>[], Boolean>() { // from class: icu.nullptr.twifucker.hook.DownloadHook$init$3$1$buttonConstructor$1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Boolean invoke(Class<?>[] it2) {
                                        Intrinsics.checkNotNullParameter(it2, "it");
                                        boolean z = false;
                                        if ((Intrinsics.areEqual(it2[0], Integer.TYPE) && Intrinsics.areEqual(it2[1], Integer.TYPE) && Intrinsics.areEqual(it2[2], String.class)) || (Intrinsics.areEqual(it2[0], String.class) && Intrinsics.areEqual(it2[1], Integer.TYPE) && Intrinsics.areEqual(it2[2], Integer.TYPE))) {
                                            z = true;
                                        }
                                        return Boolean.valueOf(z);
                                    }
                                }).first();
                                if (Intrinsics.areEqual(buttonConstructor.getParameterTypes()[0], Integer.TYPE)) {
                                    dlButton = buttonConstructor.newInstance(Integer.valueOf(UtilsKt.getId("ic_vector_incoming", "drawable")), 0, EzXHelper.getAppContext().getString(R.string.download_or_copy));
                                } else {
                                    dlButton = buttonConstructor.newInstance(EzXHelper.getAppContext().getString(R.string.download_or_copy), Integer.valueOf(UtilsKt.getId("ic_vector_incoming", "drawable")), 0);
                                }
                                str9 = DownloadHook.actionSheetItemFieldName;
                                if (str9 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("actionSheetItemFieldName");
                                    str9 = null;
                                }
                                XposedHelpers.setObjectField(actionEnumWrapped, str9, dlButton);
                                str10 = DownloadHook.actionEnumWrappedClassName;
                                if (str10 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("actionEnumWrappedClassName");
                                    str10 = null;
                                }
                                mutList.add(XposedHelpers.newInstance(ClassUtils.loadClass$default(str10, null, 2, null), new Object[]{actionEnumWrapped}));
                                Object obj2 = it.thisObject;
                                str11 = DownloadHook.tweetShareShareListFieldName;
                                if (str11 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("tweetShareShareListFieldName");
                                    str11 = null;
                                }
                                XposedHelpers.setObjectField(obj2, str11, CollectionsKt.toList(mutList));
                                long end = System.currentTimeMillis();
                                long elapsed = end - start;
                                if (elapsed > 10) {
                                    Log.d$default(name$iv + " elapsed: " + (System.currentTimeMillis() - start) + "ms", (Throwable) null, 2, (Object) null);
                                }
                            }
                        });
                    }
                });
                HookFactory.Static r23 = HookFactory.f1Static;
                MethodFinder.Static r33 = MethodFinder.f4Static;
                String str5 = shareMenuClassName;
                if (str5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("shareMenuClassName");
                    str5 = null;
                }
                MethodFinder fromClass2 = r33.fromClass(ClassUtils.loadClass$default(str5, null, 2, null));
                String str6 = shareMenuMethodName;
                if (str6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("shareMenuMethodName");
                } else {
                    str = str6;
                }
                r23.m38createMethodHook((Method) fromClass2.filterByName(str).first(), new Function1<HookFactory, Unit>() { // from class: icu.nullptr.twifucker.hook.DownloadHook$init$4
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(HookFactory hookFactory) {
                        invoke2(hookFactory);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(HookFactory createHook) {
                        Intrinsics.checkNotNullParameter(createHook, "$this$createHook");
                        final String name$iv = DownloadHook.INSTANCE.getName();
                        createHook.before(new IMethodHookCallback() { // from class: icu.nullptr.twifucker.hook.DownloadHook$init$4$invoke$$inlined$beforeMeasure$1
                            /* JADX WARN: Removed duplicated region for block: B:51:0x014f  */
                            /* JADX WARN: Removed duplicated region for block: B:54:0x015f  */
                            /* JADX WARN: Removed duplicated region for block: B:57:0x0190  */
                            /* JADX WARN: Removed duplicated region for block: B:73:0x01a6 A[SYNTHETIC] */
                            @Override // com.github.kyuubiran.ezxhelper.interfaces.IMethodHookCallback
                            /*
                                Code decompiled incorrectly, please refer to instructions dump.
                            */
                            public final void onMethodHooked(XC_MethodHook.MethodHookParam it) {
                                String str7;
                                String str8;
                                String str9;
                                String str10;
                                String str11;
                                String str12;
                                String str13;
                                String str14;
                                Object event;
                                ArrayList urls;
                                Object tweetResults;
                                String str15;
                                String str16;
                                String str17;
                                Object it2;
                                Intrinsics.checkNotNullParameter(it, "it");
                                long start = System.currentTimeMillis();
                                XC_MethodHook.MethodHookParam param = it;
                                boolean z = false;
                                Object event2 = param.args[1];
                                if (Intrinsics.areEqual(event2, "share_menu_cancel")) {
                                    DownloadHook downloadHook = DownloadHook.INSTANCE;
                                    DownloadHook.cachedTweetId = 0L;
                                    DownloadHook downloadHook2 = DownloadHook.INSTANCE;
                                    DownloadHook.cachedDownloadUrls = CollectionsKt.emptyList();
                                } else if (Intrinsics.areEqual(event2, "share_menu_click")) {
                                    Object tweetResults2 = param.args[2];
                                    str7 = DownloadHook.tweetResultFieldName;
                                    if (str7 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("tweetResultFieldName");
                                        str7 = null;
                                    }
                                    Object tweetResult = XposedHelpers.getObjectField(tweetResults2, str7);
                                    str8 = DownloadHook.tweetIdFieldName;
                                    if (str8 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("tweetIdFieldName");
                                        str8 = null;
                                    }
                                    long tweetId = XposedHelpers.getLongField(tweetResult, str8);
                                    str9 = DownloadHook.resultFieldName;
                                    if (str9 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("resultFieldName");
                                        str9 = null;
                                    }
                                    Object result = XposedHelpers.getObjectField(tweetResult, str9);
                                    str10 = DownloadHook.legacyFieldName;
                                    if (str10 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("legacyFieldName");
                                        str10 = null;
                                    }
                                    Object legacy = XposedHelpers.getObjectField(result, str10);
                                    str11 = DownloadHook.extendedEntitiesFieldName;
                                    if (str11 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("extendedEntitiesFieldName");
                                        str11 = null;
                                    }
                                    Object extendedEntities = XposedHelpers.getObjectField(legacy, str11);
                                    str12 = DownloadHook.mediaFieldName;
                                    if (str12 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("mediaFieldName");
                                        str12 = null;
                                    }
                                    Object objectField = XposedHelpers.getObjectField(extendedEntities, str12);
                                    Intrinsics.checkNotNull(objectField, "null cannot be cast to non-null type kotlin.collections.List<*>");
                                    Iterable media = (List) objectField;
                                    Object tweetResults3 = new ArrayList();
                                    Iterable $this$forEach$iv = media;
                                    for (Object element$iv : $this$forEach$iv) {
                                        str13 = DownloadHook.mediaTypeFieldName;
                                        if (str13 == null) {
                                            Intrinsics.throwUninitializedPropertyAccessException("mediaTypeFieldName");
                                            str14 = null;
                                        } else {
                                            str14 = str13;
                                        }
                                        XC_MethodHook.MethodHookParam param2 = param;
                                        Object mediaType = XposedHelpers.getObjectField(element$iv, str14);
                                        String obj = mediaType.toString();
                                        boolean z2 = z;
                                        switch (obj.hashCode()) {
                                            case -927935736:
                                                event = event2;
                                                urls = tweetResults3;
                                                tweetResults = tweetResults2;
                                                if (!obj.equals("ANIMATED_GIF")) {
                                                    break;
                                                }
                                                str16 = DownloadHook.mediaInfoFieldName;
                                                if (str16 == null) {
                                                    Intrinsics.throwUninitializedPropertyAccessException("mediaInfoFieldName");
                                                    str16 = null;
                                                }
                                                Object mediaInfo = XposedHelpers.getObjectField(element$iv, str16);
                                                str17 = DownloadHook.variantsFieldName;
                                                if (str17 == null) {
                                                    Intrinsics.throwUninitializedPropertyAccessException("variantsFieldName");
                                                    str17 = null;
                                                }
                                                Object objectField2 = XposedHelpers.getObjectField(mediaInfo, str17);
                                                Intrinsics.checkNotNull(objectField2, "null cannot be cast to non-null type kotlin.collections.List<*>");
                                                Iterable variants = (List) objectField2;
                                                Iterable $this$sortedByDescending$iv = variants;
                                                it2 = CollectionsKt.sortedWith($this$sortedByDescending$iv, new Comparator() { // from class: icu.nullptr.twifucker.hook.DownloadHook$init$4$invoke$lambda$3$lambda$2$$inlined$sortedByDescending$1
                                                    @Override // java.util.Comparator
                                                    public final int compare(T t, T t2) {
                                                        Object objectField3 = XposedHelpers.getObjectField(t2, "a");
                                                        Intrinsics.checkNotNull(objectField3, "null cannot be cast to non-null type kotlin.Int");
                                                        Object objectField4 = XposedHelpers.getObjectField(t, "a");
                                                        Intrinsics.checkNotNull(objectField4, "null cannot be cast to non-null type kotlin.Int");
                                                        return ComparisonsKt.compareValues((Integer) objectField3, (Integer) objectField4);
                                                    }
                                                }).get(0);
                                                if (it2 == null) {
                                                    Object objectField3 = XposedHelpers.getObjectField(it2, "b");
                                                    Intrinsics.checkNotNull(objectField3, "null cannot be cast to non-null type kotlin.String");
                                                    String url = (String) objectField3;
                                                    urls.add(UtilsKt.clearUrlQueries(url));
                                                    break;
                                                } else {
                                                    break;
                                                }
                                            case 69775675:
                                                event = event2;
                                                if (obj.equals("IMAGE")) {
                                                    str15 = DownloadHook.mediaUrlHttpsFieldName;
                                                    if (str15 == null) {
                                                        Intrinsics.throwUninitializedPropertyAccessException("mediaUrlHttpsFieldName");
                                                        str15 = null;
                                                    }
                                                    Object objectField4 = XposedHelpers.getObjectField(element$iv, str15);
                                                    Intrinsics.checkNotNull(objectField4, "null cannot be cast to non-null type kotlin.String");
                                                    String mediaUrlHttps = (String) objectField4;
                                                    urls = tweetResults3;
                                                    urls.add(UtilsKt.genOrigUrl(mediaUrlHttps));
                                                    tweetResults = tweetResults2;
                                                    break;
                                                }
                                                urls = tweetResults3;
                                                tweetResults = tweetResults2;
                                                break;
                                            case 81665115:
                                                event = event2;
                                                if (obj.equals("VIDEO")) {
                                                    urls = tweetResults3;
                                                    tweetResults = tweetResults2;
                                                    str16 = DownloadHook.mediaInfoFieldName;
                                                    if (str16 == null) {
                                                    }
                                                    Object mediaInfo2 = XposedHelpers.getObjectField(element$iv, str16);
                                                    str17 = DownloadHook.variantsFieldName;
                                                    if (str17 == null) {
                                                    }
                                                    Object objectField22 = XposedHelpers.getObjectField(mediaInfo2, str17);
                                                    Intrinsics.checkNotNull(objectField22, "null cannot be cast to non-null type kotlin.collections.List<*>");
                                                    Iterable variants2 = (List) objectField22;
                                                    Iterable $this$sortedByDescending$iv2 = variants2;
                                                    it2 = CollectionsKt.sortedWith($this$sortedByDescending$iv2, new Comparator() { // from class: icu.nullptr.twifucker.hook.DownloadHook$init$4$invoke$lambda$3$lambda$2$$inlined$sortedByDescending$1
                                                        @Override // java.util.Comparator
                                                        public final int compare(T t, T t2) {
                                                            Object objectField32 = XposedHelpers.getObjectField(t2, "a");
                                                            Intrinsics.checkNotNull(objectField32, "null cannot be cast to non-null type kotlin.Int");
                                                            Object objectField42 = XposedHelpers.getObjectField(t, "a");
                                                            Intrinsics.checkNotNull(objectField42, "null cannot be cast to non-null type kotlin.Int");
                                                            return ComparisonsKt.compareValues((Integer) objectField32, (Integer) objectField42);
                                                        }
                                                    }).get(0);
                                                    if (it2 == null) {
                                                    }
                                                }
                                                urls = tweetResults3;
                                                tweetResults = tweetResults2;
                                                break;
                                            default:
                                                event = event2;
                                                urls = tweetResults3;
                                                tweetResults = tweetResults2;
                                                break;
                                        }
                                        tweetResults2 = tweetResults;
                                        param = param2;
                                        z = z2;
                                        tweetResults3 = urls;
                                        event2 = event;
                                    }
                                    DownloadHook downloadHook3 = DownloadHook.INSTANCE;
                                    DownloadHook.cachedTweetId = tweetId;
                                    DownloadHook downloadHook4 = DownloadHook.INSTANCE;
                                    DownloadHook.cachedDownloadUrls = (List) tweetResults3;
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
        String string = UtilsKt.getModulePrefs().getString(HOOK_TWEET_SHARE_CLASS, null);
        if (string != null) {
            tweetShareClassName = string;
            String string2 = UtilsKt.getModulePrefs().getString(HOOK_TWEET_SHARE_SHOW_METHOD, null);
            if (string2 != null) {
                tweetShareShowMethodName = string2;
                String string3 = UtilsKt.getModulePrefs().getString(HOOK_TWEET_SHARE_LIST_FIELD, null);
                if (string3 != null) {
                    tweetShareShareListFieldName = string3;
                    String string4 = UtilsKt.getModulePrefs().getString(HOOK_ACTION_ENUM_WRAPPED_CLASS, null);
                    if (string4 == null) {
                        throw new CachedHookNotFound();
                    }
                    actionEnumWrappedClassName = string4;
                    String string5 = UtilsKt.getModulePrefs().getString(HOOK_ACTION_ENUM_WRAPPED_INNER_CLASS, null);
                    if (string5 != null) {
                        actionEnumWrappedInnerClassName = string5;
                        String string6 = UtilsKt.getModulePrefs().getString(HOOK_ACTION_ENUM_CLASS, null);
                        if (string6 != null) {
                            actionEnumClassName = string6;
                            String string7 = UtilsKt.getModulePrefs().getString(HOOK_ACTION_SHEET_ITEM_CLASS, null);
                            if (string7 != null) {
                                actionSheetItemClassName = string7;
                                String string8 = UtilsKt.getModulePrefs().getString(HOOK_ACTION_SHEET_ITEM_FIELD, null);
                                if (string8 != null) {
                                    actionSheetItemFieldName = string8;
                                    String string9 = UtilsKt.getModulePrefs().getString(HOOK_SHARE_TWEET_ON_CLICK_LISTENER_CLASS, null);
                                    if (string9 != null) {
                                        shareTweetOnClickListenerClassName = string9;
                                        String string10 = UtilsKt.getModulePrefs().getString(HOOK_SHARE_TWEET_ITEM_ADAPTER_FIELD, null);
                                        if (string10 != null) {
                                            shareTweetItemAdapterFieldName = string10;
                                            String string11 = UtilsKt.getModulePrefs().getString(HOOK_ACTION_ITEM_VIEW_DATA_FIELD, null);
                                            if (string11 == null) {
                                                throw new CachedHookNotFound();
                                            }
                                            actionItemViewDataFieldName = string11;
                                            String string12 = UtilsKt.getModulePrefs().getString(HOOK_PROTECTED_SHARE_ITEM_ADAPTER_CLASS, null);
                                            if (string12 != null) {
                                                protectedShareTweetItemAdapterClassName = string12;
                                                String string13 = UtilsKt.getModulePrefs().getString(HOOK_PROTECTED_SHARE_TWEET_ITEM_ADAPTER_CLASS_TITLE_FIELD, null);
                                                if (string13 != null) {
                                                    protectedShareTweetItemAdapterClassTitleFieldName = string13;
                                                    String string14 = UtilsKt.getModulePrefs().getString(HOOK_SHARE_MENU_CLASS, null);
                                                    if (string14 != null) {
                                                        shareMenuClassName = string14;
                                                        String string15 = UtilsKt.getModulePrefs().getString(HOOK_SHARE_MENU_METHOD, null);
                                                        if (string15 != null) {
                                                            shareMenuMethodName = string15;
                                                            String string16 = UtilsKt.getModulePrefs().getString(HOOK_TWEET_RESULT_FIELD, null);
                                                            if (string16 != null) {
                                                                tweetResultFieldName = string16;
                                                                String string17 = UtilsKt.getModulePrefs().getString(HOOK_TWEET_ID_FIELD, null);
                                                                if (string17 != null) {
                                                                    tweetIdFieldName = string17;
                                                                    String string18 = UtilsKt.getModulePrefs().getString(HOOK_RESULT_FIELD, null);
                                                                    if (string18 != null) {
                                                                        resultFieldName = string18;
                                                                        String string19 = UtilsKt.getModulePrefs().getString(HOOK_LEGACY_FIELD, null);
                                                                        if (string19 != null) {
                                                                            legacyFieldName = string19;
                                                                            String string20 = UtilsKt.getModulePrefs().getString(HOOK_EXTENDED_ENTITIES_FIELD, null);
                                                                            if (string20 != null) {
                                                                                extendedEntitiesFieldName = string20;
                                                                                String string21 = UtilsKt.getModulePrefs().getString(HOOK_MEDIA_FIELD, null);
                                                                                if (string21 == null) {
                                                                                    throw new CachedHookNotFound();
                                                                                }
                                                                                mediaFieldName = string21;
                                                                                String string22 = UtilsKt.getModulePrefs().getString(HOOK_MEDIA_TYPE_FIELD, null);
                                                                                if (string22 != null) {
                                                                                    mediaTypeFieldName = string22;
                                                                                    String string23 = UtilsKt.getModulePrefs().getString(HOOK_MEDIA_URL_HTTPS_FIELD, null);
                                                                                    if (string23 != null) {
                                                                                        mediaUrlHttpsFieldName = string23;
                                                                                        String string24 = UtilsKt.getModulePrefs().getString(HOOK_MEDIA_INFO_FIELD, null);
                                                                                        if (string24 != null) {
                                                                                            mediaInfoFieldName = string24;
                                                                                            String string25 = UtilsKt.getModulePrefs().getString(HOOK_VARIANTS_FIELD, null);
                                                                                            if (string25 != null) {
                                                                                                variantsFieldName = string25;
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
        String str = tweetShareClassName;
        String str2 = null;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tweetShareClassName");
            str = null;
        }
        it.putString(HOOK_TWEET_SHARE_CLASS, str);
        String str3 = tweetShareShowMethodName;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tweetShareShowMethodName");
            str3 = null;
        }
        it.putString(HOOK_TWEET_SHARE_SHOW_METHOD, str3);
        String str4 = tweetShareShareListFieldName;
        if (str4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tweetShareShareListFieldName");
            str4 = null;
        }
        it.putString(HOOK_TWEET_SHARE_LIST_FIELD, str4);
        String str5 = actionEnumWrappedClassName;
        if (str5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionEnumWrappedClassName");
            str5 = null;
        }
        it.putString(HOOK_ACTION_ENUM_WRAPPED_CLASS, str5);
        String str6 = actionEnumWrappedInnerClassName;
        if (str6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionEnumWrappedInnerClassName");
            str6 = null;
        }
        it.putString(HOOK_ACTION_ENUM_WRAPPED_INNER_CLASS, str6);
        String str7 = actionEnumClassName;
        if (str7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionEnumClassName");
            str7 = null;
        }
        it.putString(HOOK_ACTION_ENUM_CLASS, str7);
        String str8 = actionSheetItemClassName;
        if (str8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionSheetItemClassName");
            str8 = null;
        }
        it.putString(HOOK_ACTION_SHEET_ITEM_CLASS, str8);
        String str9 = actionSheetItemFieldName;
        if (str9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionSheetItemFieldName");
            str9 = null;
        }
        it.putString(HOOK_ACTION_SHEET_ITEM_FIELD, str9);
        String str10 = shareTweetOnClickListenerClassName;
        if (str10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareTweetOnClickListenerClassName");
            str10 = null;
        }
        it.putString(HOOK_SHARE_TWEET_ON_CLICK_LISTENER_CLASS, str10);
        String str11 = shareTweetItemAdapterFieldName;
        if (str11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareTweetItemAdapterFieldName");
            str11 = null;
        }
        it.putString(HOOK_SHARE_TWEET_ITEM_ADAPTER_FIELD, str11);
        String str12 = actionItemViewDataFieldName;
        if (str12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionItemViewDataFieldName");
            str12 = null;
        }
        it.putString(HOOK_ACTION_ITEM_VIEW_DATA_FIELD, str12);
        String str13 = protectedShareTweetItemAdapterClassName;
        if (str13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("protectedShareTweetItemAdapterClassName");
            str13 = null;
        }
        it.putString(HOOK_PROTECTED_SHARE_ITEM_ADAPTER_CLASS, str13);
        String str14 = protectedShareTweetItemAdapterClassTitleFieldName;
        if (str14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("protectedShareTweetItemAdapterClassTitleFieldName");
            str14 = null;
        }
        it.putString(HOOK_PROTECTED_SHARE_TWEET_ITEM_ADAPTER_CLASS_TITLE_FIELD, str14);
        String str15 = shareMenuClassName;
        if (str15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareMenuClassName");
            str15 = null;
        }
        it.putString(HOOK_SHARE_MENU_CLASS, str15);
        String str16 = shareMenuMethodName;
        if (str16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareMenuMethodName");
            str16 = null;
        }
        it.putString(HOOK_SHARE_MENU_METHOD, str16);
        String str17 = tweetResultFieldName;
        if (str17 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tweetResultFieldName");
            str17 = null;
        }
        it.putString(HOOK_TWEET_RESULT_FIELD, str17);
        String str18 = tweetIdFieldName;
        if (str18 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tweetIdFieldName");
            str18 = null;
        }
        it.putString(HOOK_TWEET_ID_FIELD, str18);
        String str19 = resultFieldName;
        if (str19 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("resultFieldName");
            str19 = null;
        }
        it.putString(HOOK_RESULT_FIELD, str19);
        String str20 = legacyFieldName;
        if (str20 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("legacyFieldName");
            str20 = null;
        }
        it.putString(HOOK_LEGACY_FIELD, str20);
        String str21 = extendedEntitiesFieldName;
        if (str21 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("extendedEntitiesFieldName");
            str21 = null;
        }
        it.putString(HOOK_EXTENDED_ENTITIES_FIELD, str21);
        String str22 = mediaFieldName;
        if (str22 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaFieldName");
            str22 = null;
        }
        it.putString(HOOK_MEDIA_FIELD, str22);
        String str23 = mediaTypeFieldName;
        if (str23 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaTypeFieldName");
            str23 = null;
        }
        it.putString(HOOK_MEDIA_TYPE_FIELD, str23);
        String str24 = mediaUrlHttpsFieldName;
        if (str24 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaUrlHttpsFieldName");
            str24 = null;
        }
        it.putString(HOOK_MEDIA_URL_HTTPS_FIELD, str24);
        String str25 = mediaInfoFieldName;
        if (str25 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaInfoFieldName");
            str25 = null;
        }
        it.putString(HOOK_MEDIA_INFO_FIELD, str25);
        String str26 = variantsFieldName;
        if (str26 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("variantsFieldName");
        } else {
            str2 = str26;
        }
        it.putString(HOOK_VARIANTS_FIELD, str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:221:0x03d1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:228:0x06b1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:229:0x06a1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x03d3 A[LOOP:7: B:71:0x037e->B:83:0x03d3, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void searchHook() {
        Object element$iv;
        DexMethodDescriptor dexMethodDescriptor;
        Object element$iv2;
        Object maxElem$iv;
        Object maxElem$iv2;
        Class mediaTypeEnumClass;
        Object obj;
        boolean z;
        Method actionEnumWrappedClassRefMethod;
        ArrayList arrayList;
        Iterable $this$firstOrNull$iv;
        boolean z2;
        List shareTweetOnClickListenerRefMethodsDesc;
        boolean z3;
        Field[] declaredFields;
        boolean z4;
        boolean z5;
        Map result;
        Iterator it;
        Object element$iv3;
        Method methodInstance;
        Method it2;
        DexKitBridge this_$iv = HookEntry.Companion.getDexKit();
        MethodUsingStringArgs.Companion companion = MethodUsingStringArgs.Companion;
        MethodUsingStringArgs.Builder $this$searchHook_u24lambda_u242 = new MethodUsingStringArgs.Builder();
        $this$searchHook_u24lambda_u242.setUsingString("^timeline_selected_caret_position$");
        Unit unit = Unit.INSTANCE;
        Iterable $this$map$iv = this_$iv.findMethodUsingString($this$searchHook_u24lambda_u242.build());
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            DexMethodDescriptor it3 = (DexMethodDescriptor) item$iv$iv;
            destination$iv$iv.add(it3.getMethodInstance(EzXHelper.getClassLoader()));
        }
        Iterator it4 = ((List) destination$iv$iv).iterator();
        while (true) {
            if (!it4.hasNext()) {
                element$iv = null;
                break;
            }
            element$iv = it4.next();
            Method it5 = (Method) element$iv;
            if (it5.getParameterTypes().length == 2 && Intrinsics.areEqual(it5.getParameterTypes()[1], Bundle.class)) {
                it2 = 1;
                continue;
            } else {
                it2 = null;
                continue;
            }
            if (it2 != null) {
                break;
            }
        }
        Method method = (Method) element$iv;
        Class tweetShareClass = method != null ? method.getDeclaringClass() : null;
        if (tweetShareClass == null) {
            throw new ClassNotFoundException();
        }
        Class<?> TYPE = Void.TYPE;
        Intrinsics.checkNotNullExpressionValue(TYPE, "TYPE");
        Method tweetShareShowMethod = (Method) MethodFinder.f4Static.fromClass(tweetShareClass).filterPublic().filterFinal().filterByParamCount(1).filterByReturnType(TYPE).first();
        Field tweetShareShareListField = (Field) FieldFinder.f3Static.fromClass(tweetShareClass).filterPublic().filterFinal().filterByType(List.class).first();
        Method actionEnumWrappedClassRefMethod2 = (Method) MethodFinder.f4Static.fromClass(tweetShareClass).filterPublic().filterFinal().filterByParamTypes(new Function1<Class<?>[], Boolean>() { // from class: icu.nullptr.twifucker.hook.DownloadHook$searchHook$actionEnumWrappedClassRefMethod$1
            /* JADX WARN: Code restructure failed: missing block: B:7:0x001d, code lost:
                if (kotlin.jvm.internal.Intrinsics.areEqual(r4[2], java.lang.Boolean.TYPE) != false) goto L7;
             */
            @Override // kotlin.jvm.functions.Function1
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Boolean invoke(Class<?>[] it6) {
                boolean z6;
                Intrinsics.checkNotNullParameter(it6, "it");
                if (it6.length >= 3) {
                    z6 = true;
                    if (Intrinsics.areEqual(it6[1], String.class)) {
                    }
                }
                z6 = false;
                return Boolean.valueOf(z6);
            }
        }).first();
        Class<?> returnType = actionEnumWrappedClassRefMethod2.getReturnType();
        Class<?> cls = returnType.getConstructors()[0].getParameterTypes()[0];
        Class actionEnumClass = actionEnumWrappedClassRefMethod2.getParameterTypes()[0];
        DexKitBridge this_$iv2 = HookEntry.Companion.getDexKit();
        MethodUsingStringArgs.Companion companion2 = MethodUsingStringArgs.Companion;
        MethodUsingStringArgs.Builder $this$searchHook_u24lambda_u245 = new MethodUsingStringArgs.Builder();
        $this$searchHook_u24lambda_u245.setUsingString("^ActionSheetItem(drawableRes=$");
        $this$searchHook_u24lambda_u245.setMethodName("toString");
        String name = String.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        $this$searchHook_u24lambda_u245.setMethodReturnType(name);
        Unit unit2 = Unit.INSTANCE;
        DexMethodDescriptor dexMethodDescriptor2 = (DexMethodDescriptor) CollectionsKt.firstOrNull((List<? extends Object>) this_$iv2.findMethodUsingString($this$searchHook_u24lambda_u245.build()));
        Class actionSheetItemClass = (dexMethodDescriptor2 == null || (methodInstance = dexMethodDescriptor2.getMethodInstance(EzXHelper.getClassLoader())) == null) ? null : methodInstance.getDeclaringClass();
        if (actionSheetItemClass == null) {
            throw new ClassNotFoundException();
        }
        FieldFinder.Static r7 = FieldFinder.f3Static;
        Intrinsics.checkNotNull(cls);
        Field actionSheetItemField = (Field) r7.fromClass(cls).filterByType(actionSheetItemClass).first();
        String name2 = tweetShareClass.getName();
        Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
        tweetShareClassName = name2;
        String name3 = tweetShareShowMethod.getName();
        Intrinsics.checkNotNullExpressionValue(name3, "getName(...)");
        tweetShareShowMethodName = name3;
        String name4 = tweetShareShareListField.getName();
        Intrinsics.checkNotNullExpressionValue(name4, "getName(...)");
        tweetShareShareListFieldName = name4;
        String name5 = returnType.getName();
        Intrinsics.checkNotNullExpressionValue(name5, "getName(...)");
        actionEnumWrappedClassName = name5;
        String name6 = cls.getName();
        Intrinsics.checkNotNullExpressionValue(name6, "getName(...)");
        actionEnumWrappedInnerClassName = name6;
        String name7 = actionEnumClass.getName();
        Intrinsics.checkNotNullExpressionValue(name7, "getName(...)");
        actionEnumClassName = name7;
        String name8 = actionSheetItemClass.getName();
        Intrinsics.checkNotNullExpressionValue(name8, "getName(...)");
        actionSheetItemClassName = name8;
        String name9 = actionSheetItemField.getName();
        Intrinsics.checkNotNullExpressionValue(name9, "getName(...)");
        actionSheetItemFieldName = name9;
        DexKitBridge this_$iv3 = HookEntry.Companion.getDexKit();
        MethodUsingStringArgs.Companion companion3 = MethodUsingStringArgs.Companion;
        MethodUsingStringArgs.Builder $this$searchHook_u24lambda_u246 = new MethodUsingStringArgs.Builder();
        $this$searchHook_u24lambda_u246.setUsingString("itemView.findViewById(R.id.action_sheet_item_icon)");
        Unit unit3 = Unit.INSTANCE;
        List shareTweetOnClickListenerRefMethodsDesc2 = this_$iv3.findMethodUsingString($this$searchHook_u24lambda_u246.build());
        Iterator<T> it6 = shareTweetOnClickListenerRefMethodsDesc2.iterator();
        while (true) {
            if (!it6.hasNext()) {
                dexMethodDescriptor = null;
                break;
            }
            DexMethodDescriptor methodDesc = (DexMethodDescriptor) it6.next();
            DexKitBridge this_$iv4 = HookEntry.Companion.getDexKit();
            MethodInvokingArgs.Companion companion4 = MethodInvokingArgs.Companion;
            MethodInvokingArgs.Builder $this$searchHook_u24lambda_u2410_u24lambda_u247 = new MethodInvokingArgs.Builder();
            Class tweetShareClass2 = tweetShareClass;
            Method tweetShareShowMethod2 = tweetShareShowMethod;
            $this$searchHook_u24lambda_u2410_u24lambda_u247.setMethodDescriptor(methodDesc.getDescriptor());
            $this$searchHook_u24lambda_u2410_u24lambda_u247.setBeInvokedMethodName("<init>");
            String name10 = Void.TYPE.getName();
            Intrinsics.checkNotNullExpressionValue(name10, "getName(...)");
            $this$searchHook_u24lambda_u2410_u24lambda_u247.setBeInvokedMethodReturnType(name10);
            Map result2 = this_$iv4.findMethodInvoking($this$searchHook_u24lambda_u2410_u24lambda_u247.build());
            Iterator it7 = result2.values().iterator();
            while (true) {
                if (!it7.hasNext()) {
                    dexMethodDescriptor = null;
                    break;
                }
                Iterable l = (List) it7.next();
                Iterator it8 = l.iterator();
                while (true) {
                    if (!it8.hasNext()) {
                        result = result2;
                        it = it7;
                        element$iv3 = null;
                        break;
                    }
                    element$iv3 = it8.next();
                    result = result2;
                    DexMethodDescriptor desc = (DexMethodDescriptor) element$iv3;
                    it = it7;
                    if (desc.getConstructorInstance(EzXHelper.getClassLoader()).getParameterTypes().length == 3) {
                        break;
                    }
                    result2 = result;
                    it7 = it;
                }
                dexMethodDescriptor = (DexMethodDescriptor) element$iv3;
                if (dexMethodDescriptor != null) {
                    break;
                }
                result2 = result;
                it7 = it;
            }
            if (dexMethodDescriptor != null) {
                break;
            }
            tweetShareClass = tweetShareClass2;
            tweetShareShowMethod = tweetShareShowMethod2;
        }
        if (dexMethodDescriptor == null) {
            throw new ClassNotFoundException();
        }
        DexMethodDescriptor shareTweetOnClickListenerConstructorDesc = dexMethodDescriptor;
        Class shareTweetOnClickListenerClass = shareTweetOnClickListenerConstructorDesc.getConstructorInstance(EzXHelper.getClassLoader()).getDeclaringClass();
        if (shareTweetOnClickListenerClass == null) {
            throw new ClassNotFoundException();
        }
        Field shareTweetItemAdapterField = (Field) FieldFinder.f3Static.fromClass(shareTweetOnClickListenerClass).last();
        DexKitBridge this_$iv5 = HookEntry.Companion.getDexKit();
        MethodUsingStringArgs.Companion companion5 = MethodUsingStringArgs.Companion;
        MethodUsingStringArgs.Builder $this$searchHook_u24lambda_u2411 = new MethodUsingStringArgs.Builder();
        $this$searchHook_u24lambda_u2411.setUsingString("^itemView.findViewById(R.id.action_sheet_item_icon)$");
        $this$searchHook_u24lambda_u2411.setMethodName("<init>");
        String name11 = Void.TYPE.getName();
        Intrinsics.checkNotNullExpressionValue(name11, "getName(...)");
        $this$searchHook_u24lambda_u2411.setMethodReturnType(name11);
        Unit unit4 = Unit.INSTANCE;
        Iterable $this$map$iv2 = this_$iv5.findMethodUsingString($this$searchHook_u24lambda_u2411.build());
        boolean z6 = false;
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
        for (Object item$iv$iv2 : $this$map$iv2) {
            Iterable $this$map$iv3 = $this$map$iv2;
            DexMethodDescriptor it9 = (DexMethodDescriptor) item$iv$iv2;
            destination$iv$iv2.add(it9.getConstructorInstance(EzXHelper.getClassLoader()).getDeclaringClass());
            $this$map$iv2 = $this$map$iv3;
            z6 = z6;
        }
        Iterable $this$firstOrNull$iv2 = (List) destination$iv$iv2;
        boolean z7 = false;
        Iterator it10 = $this$firstOrNull$iv2.iterator();
        while (true) {
            if (!it10.hasNext()) {
                element$iv2 = null;
                break;
            }
            element$iv2 = it10.next();
            Class it11 = (Class) element$iv2;
            if (it11 == null || (declaredFields = it11.getDeclaredFields()) == null) {
                $this$firstOrNull$iv = $this$firstOrNull$iv2;
                z2 = z7;
                shareTweetOnClickListenerRefMethodsDesc = shareTweetOnClickListenerRefMethodsDesc2;
                z3 = false;
            } else {
                Intrinsics.checkNotNull(declaredFields);
                $this$firstOrNull$iv = $this$firstOrNull$iv2;
                z2 = z7;
                int $i$f$firstOrNull = declaredFields.length;
                shareTweetOnClickListenerRefMethodsDesc = shareTweetOnClickListenerRefMethodsDesc2;
                int i = 0;
                while (true) {
                    if (i >= $i$f$firstOrNull) {
                        z4 = false;
                        break;
                    }
                    Field field = declaredFields[i];
                    Intrinsics.checkNotNull(field);
                    Field $this$isPublic$iv = field;
                    if (Modifier.isPublic($this$isPublic$iv.getModifiers())) {
                        MemberExtensions memberExtensions = MemberExtensions.INSTANCE;
                        if (!Modifier.isStatic(field.getModifiers())) {
                            MemberExtensions memberExtensions2 = MemberExtensions.INSTANCE;
                            if (!Modifier.isFinal(field.getModifiers())) {
                                z5 = true;
                                if (!z5) {
                                    z4 = true;
                                    break;
                                }
                                i++;
                            }
                        }
                    }
                    z5 = false;
                    if (!z5) {
                    }
                }
                z3 = z4;
            }
            if (z3) {
                break;
            }
            z7 = z2;
            $this$firstOrNull$iv2 = $this$firstOrNull$iv;
            shareTweetOnClickListenerRefMethodsDesc2 = shareTweetOnClickListenerRefMethodsDesc;
        }
        Class shareTweetItemAdapterClass = (Class) element$iv2;
        if (shareTweetItemAdapterClass == null) {
            throw new ClassNotFoundException();
        }
        Field actionItemViewDataField = (Field) FieldFinder.f3Static.fromClass(shareTweetItemAdapterClass).filterPublic().filterNonStatic().filterNonFinal().first();
        String name12 = shareTweetOnClickListenerClass.getName();
        Intrinsics.checkNotNullExpressionValue(name12, "getName(...)");
        shareTweetOnClickListenerClassName = name12;
        String name13 = shareTweetItemAdapterField.getName();
        Intrinsics.checkNotNullExpressionValue(name13, "getName(...)");
        shareTweetItemAdapterFieldName = name13;
        String name14 = actionItemViewDataField.getName();
        Intrinsics.checkNotNullExpressionValue(name14, "getName(...)");
        actionItemViewDataFieldName = name14;
        DexKitBridge this_$iv6 = HookEntry.Companion.getDexKit();
        MethodOpcodeArgs.Companion companion6 = MethodOpcodeArgs.Companion;
        MethodOpcodeArgs.Builder $this$searchHook_u24lambda_u2415 = new MethodOpcodeArgs.Builder();
        $this$searchHook_u24lambda_u2415.setOpSeq(new int[]{84, 56, 110, 10, 114, 14});
        $this$searchHook_u24lambda_u2415.setMethodName("onClick");
        String name15 = View.class.getName();
        Intrinsics.checkNotNullExpressionValue(name15, "getName(...)");
        $this$searchHook_u24lambda_u2415.setMethodParamTypes(new String[]{name15});
        String name16 = Void.TYPE.getName();
        Intrinsics.checkNotNullExpressionValue(name16, "getName(...)");
        $this$searchHook_u24lambda_u2415.setMethodReturnType(name16);
        Unit unit5 = Unit.INSTANCE;
        Class protectedShareTweetItemAdapterClass = ((DexMethodDescriptor) CollectionsKt.first((List<? extends Object>) this_$iv6.findMethodUsingOpPrefixSeq($this$searchHook_u24lambda_u2415.build()))).getMethodInstance(EzXHelper.getClassLoader()).getDeclaringClass();
        FieldFinder.Static r1 = FieldFinder.f3Static;
        Intrinsics.checkNotNull(protectedShareTweetItemAdapterClass);
        Field protectedShareTweetItemAdapterClassTitleField = (Field) r1.fromClass(protectedShareTweetItemAdapterClass).filterByType(TextView.class).first();
        String name17 = protectedShareTweetItemAdapterClass.getName();
        Intrinsics.checkNotNullExpressionValue(name17, "getName(...)");
        protectedShareTweetItemAdapterClassName = name17;
        String name18 = protectedShareTweetItemAdapterClassTitleField.getName();
        Intrinsics.checkNotNullExpressionValue(name18, "getName(...)");
        protectedShareTweetItemAdapterClassTitleFieldName = name18;
        DexKitBridge this_$iv7 = HookEntry.Companion.getDexKit();
        MethodUsingStringArgs.Companion companion7 = MethodUsingStringArgs.Companion;
        MethodUsingStringArgs.Builder $this$searchHook_u24lambda_u2416 = new MethodUsingStringArgs.Builder();
        $this$searchHook_u24lambda_u2416.setUsingString("^sandbox://tweetview?id=$");
        String name19 = Void.TYPE.getName();
        Intrinsics.checkNotNullExpressionValue(name19, "getName(...)");
        $this$searchHook_u24lambda_u2416.setMethodReturnType(name19);
        Unit unit6 = Unit.INSTANCE;
        String it12 = ((DexMethodDescriptor) CollectionsKt.first((List<? extends Object>) this_$iv7.findMethodUsingString($this$searchHook_u24lambda_u2416.build()))).getDeclaringClassName();
        Class shareMenuClass = ClassUtils.loadClass$default(it12, null, 2, null);
        MethodFinder fromClass = MethodFinder.f4Static.fromClass(shareMenuClass);
        Class<?> TYPE2 = Void.TYPE;
        Intrinsics.checkNotNullExpressionValue(TYPE2, "TYPE");
        Method shareMenuMethod = (Method) fromClass.filterByReturnType(TYPE2).filterByParamTypes(new Function1<Class<?>[], Boolean>() { // from class: icu.nullptr.twifucker.hook.DownloadHook$searchHook$shareMenuMethod$1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Class<?>[] it13) {
                Intrinsics.checkNotNullParameter(it13, "it");
                boolean z8 = false;
                if (it13.length == 4 && Intrinsics.areEqual(it13[0], String.class) && Intrinsics.areEqual(it13[1], String.class)) {
                    z8 = true;
                }
                return Boolean.valueOf(z8);
            }
        }).first();
        DexKitBridge this_$iv8 = HookEntry.Companion.getDexKit();
        MethodOpcodeArgs.Companion companion8 = MethodOpcodeArgs.Companion;
        MethodOpcodeArgs.Builder $this$searchHook_u24lambda_u2418 = new MethodOpcodeArgs.Builder();
        $this$searchHook_u24lambda_u2418.setMethodName("<init>");
        String name20 = Void.TYPE.getName();
        Intrinsics.checkNotNullExpressionValue(name20, "getName(...)");
        $this$searchHook_u24lambda_u2418.setMethodReturnType(name20);
        $this$searchHook_u24lambda_u2418.setOpSeq(new int[]{112, 83, 90, 84, 91, 83, 90, 83, 90, 83, 90, 84, 91});
        Unit unit7 = Unit.INSTANCE;
        Class tweetResultClass = ((DexMethodDescriptor) CollectionsKt.first((List<? extends Object>) this_$iv8.findMethodUsingOpPrefixSeq($this$searchHook_u24lambda_u2418.build()))).getConstructorInstance(EzXHelper.getClassLoader()).getDeclaringClass();
        FieldFinder.Static r4 = FieldFinder.f3Static;
        Class<?> cls2 = shareMenuMethod.getParameterTypes()[2];
        Intrinsics.checkNotNullExpressionValue(cls2, "get(...)");
        FieldFinder fromClass2 = r4.fromClass(cls2);
        Intrinsics.checkNotNull(tweetResultClass);
        Field tweetResultField = (Field) fromClass2.filterByType(tweetResultClass).first();
        Object[] declaredFields2 = tweetResultField.getType().getDeclaredFields();
        Intrinsics.checkNotNullExpressionValue(declaredFields2, "getDeclaredFields(...)");
        Object[] $this$first$iv = declaredFields2;
        int length = $this$first$iv.length;
        int i2 = 0;
        while (i2 < length) {
            Object element$iv4 = $this$first$iv[i2];
            Field it13 = (Field) element$iv4;
            int i3 = length;
            Class actionSheetItemClass2 = actionSheetItemClass;
            if (Intrinsics.areEqual(it13.getType(), Long.TYPE)) {
                Field tweetIdField = (Field) element$iv4;
                Field[] declaredFields3 = tweetResultField.getType().getDeclaredFields();
                Intrinsics.checkNotNullExpressionValue(declaredFields3, "getDeclaredFields(...)");
                Field[] fieldArr = declaredFields3;
                Map linkedHashMap = new LinkedHashMap();
                int length2 = fieldArr.length;
                int $i$f$groupBy = 0;
                while ($i$f$groupBy < length2) {
                    int i4 = length2;
                    Field field2 = fieldArr[$i$f$groupBy];
                    Field it14 = field2;
                    Class<?> type = it14.getType();
                    Field actionSheetItemField2 = actionSheetItemField;
                    Field shareTweetItemAdapterField2 = shareTweetItemAdapterField;
                    Object value$iv$iv$iv = linkedHashMap.get(type);
                    if (value$iv$iv$iv == null) {
                        arrayList = new ArrayList();
                        actionEnumWrappedClassRefMethod = actionEnumWrappedClassRefMethod2;
                        linkedHashMap.put(type, arrayList);
                    } else {
                        actionEnumWrappedClassRefMethod = actionEnumWrappedClassRefMethod2;
                        arrayList = value$iv$iv$iv;
                    }
                    List list$iv$iv = (List) arrayList;
                    list$iv$iv.add(field2);
                    $i$f$groupBy++;
                    length2 = i4;
                    shareTweetItemAdapterField = shareTweetItemAdapterField2;
                    actionSheetItemField = actionSheetItemField2;
                    actionEnumWrappedClassRefMethod2 = actionEnumWrappedClassRefMethod;
                }
                Map $this$filter$iv = linkedHashMap;
                boolean z8 = false;
                Map linkedHashMap2 = new LinkedHashMap();
                for (Map.Entry element$iv$iv : $this$filter$iv.entrySet()) {
                    Map $this$filter$iv2 = $this$filter$iv;
                    boolean z9 = z8;
                    if (((List) element$iv$iv.getValue()).size() == 2 && ((Class) element$iv$iv.getKey()).getDeclaredFields().length == 3) {
                        z = true;
                        if (z) {
                            z8 = z9;
                            $this$filter$iv = $this$filter$iv2;
                        } else {
                            linkedHashMap2.put(element$iv$iv.getKey(), element$iv$iv.getValue());
                            z8 = z9;
                            $this$filter$iv = $this$filter$iv2;
                        }
                    }
                    z = false;
                    if (z) {
                    }
                }
                Map $this$map$iv4 = linkedHashMap2;
                boolean z10 = false;
                Collection destination$iv$iv3 = new ArrayList($this$map$iv4.size());
                for (Map.Entry item$iv$iv3 : $this$map$iv4.entrySet()) {
                    destination$iv$iv3.add((Field) ((List) item$iv$iv3.getValue()).get(1));
                    z10 = z10;
                    $this$map$iv4 = $this$map$iv4;
                }
                Field resultField = (Field) ((List) destination$iv$iv3).get(0);
                if (resultField == null) {
                    throw new NoSuchFieldError();
                }
                Field[] declaredFields4 = resultField.getType().getDeclaredFields();
                Intrinsics.checkNotNullExpressionValue(declaredFields4, "getDeclaredFields(...)");
                Field[] fieldArr2 = declaredFields4;
                boolean z11 = false;
                Collection destination$iv$iv4 = new ArrayList();
                int length3 = fieldArr2.length;
                int i5 = 0;
                while (i5 < length3) {
                    boolean z12 = z11;
                    Field field3 = fieldArr2[i5];
                    Field it15 = field3;
                    Intrinsics.checkNotNull(it15);
                    MemberExtensions memberExtensions3 = MemberExtensions.INSTANCE;
                    if (!Modifier.isStatic(it15.getModifiers())) {
                        destination$iv$iv4.add(field3);
                    }
                    i5++;
                    z11 = z12;
                }
                Iterable $this$maxByOrNull$iv = (List) destination$iv$iv4;
                Iterator iterator$iv = $this$maxByOrNull$iv.iterator();
                if (iterator$iv.hasNext()) {
                    maxElem$iv = iterator$iv.next();
                    if (iterator$iv.hasNext()) {
                        Field it16 = (Field) maxElem$iv;
                        Comparable maxValue$iv = it16.getName();
                        while (true) {
                            Object e$iv = iterator$iv.next();
                            Field it17 = (Field) e$iv;
                            Iterable $this$maxByOrNull$iv2 = $this$maxByOrNull$iv;
                            String name21 = it17.getName();
                            if (maxValue$iv.compareTo(name21) < 0) {
                                maxElem$iv = e$iv;
                                maxValue$iv = name21;
                            }
                            if (!iterator$iv.hasNext()) {
                                break;
                            }
                            $this$maxByOrNull$iv = $this$maxByOrNull$iv2;
                            returnType = returnType;
                            cls = cls;
                        }
                    }
                } else {
                    maxElem$iv = null;
                }
                Field legacyField = (Field) maxElem$iv;
                if (legacyField == null) {
                    throw new NoSuchFieldError();
                }
                Field[] declaredFields5 = legacyField.getType().getDeclaredFields();
                Intrinsics.checkNotNullExpressionValue(declaredFields5, "getDeclaredFields(...)");
                Field[] fieldArr3 = declaredFields5;
                Collection destination$iv$iv5 = new ArrayList();
                int length4 = fieldArr3.length;
                int $i$f$filter = 0;
                while ($i$f$filter < length4) {
                    int i6 = length4;
                    Field field4 = fieldArr3[$i$f$filter];
                    Field it18 = field4;
                    Intrinsics.checkNotNull(it18);
                    MemberExtensions memberExtensions4 = MemberExtensions.INSTANCE;
                    if (!Modifier.isStatic(it18.getModifiers())) {
                        destination$iv$iv5.add(field4);
                    }
                    $i$f$filter++;
                    length4 = i6;
                }
                Iterable $this$maxByOrNull$iv3 = (List) destination$iv$iv5;
                Iterator iterator$iv2 = $this$maxByOrNull$iv3.iterator();
                if (iterator$iv2.hasNext()) {
                    maxElem$iv2 = iterator$iv2.next();
                    if (iterator$iv2.hasNext()) {
                        Field it19 = (Field) maxElem$iv2;
                        Comparable maxValue$iv2 = it19.getName();
                        while (true) {
                            Object e$iv2 = iterator$iv2.next();
                            Field it20 = (Field) e$iv2;
                            Iterable $this$maxByOrNull$iv4 = $this$maxByOrNull$iv3;
                            String name22 = it20.getName();
                            if (maxValue$iv2.compareTo(name22) < 0) {
                                maxElem$iv2 = e$iv2;
                                maxValue$iv2 = name22;
                            }
                            if (!iterator$iv2.hasNext()) {
                                break;
                            }
                            $this$maxByOrNull$iv3 = $this$maxByOrNull$iv4;
                            returnType = returnType;
                            cls = cls;
                        }
                    }
                } else {
                    maxElem$iv2 = null;
                }
                Field extendedEntitiesField = (Field) maxElem$iv2;
                if (extendedEntitiesField == null) {
                    throw new NoSuchFieldError();
                }
                FieldFinder.Static r8 = FieldFinder.f3Static;
                Class<? super Object> superclass = extendedEntitiesField.getType().getSuperclass();
                Intrinsics.checkNotNullExpressionValue(superclass, "getSuperclass(...)");
                Field mediaField = (Field) r8.fromClass(superclass).filterByType(List.class).first();
                DexKitBridge this_$iv9 = HookEntry.Companion.getDexKit();
                MethodUsingStringArgs.Companion companion9 = MethodUsingStringArgs.Companion;
                MethodUsingStringArgs.Builder $this$searchHook_u24lambda_u2427 = new MethodUsingStringArgs.Builder();
                $this$searchHook_u24lambda_u2427.setUsingString("^MODEL3D$");
                $this$searchHook_u24lambda_u2427.setMethodName("<clinit>");
                String name23 = Void.TYPE.getName();
                Intrinsics.checkNotNullExpressionValue(name23, "getName(...)");
                $this$searchHook_u24lambda_u2427.setMethodReturnType(name23);
                Unit unit8 = Unit.INSTANCE;
                DexMethodDescriptor it21 = (DexMethodDescriptor) CollectionsKt.firstOrNull((List<? extends Object>) this_$iv9.findMethodUsingString($this$searchHook_u24lambda_u2427.build()));
                if (it21 == null || (mediaTypeEnumClass = ClassUtils.loadClass$default(it21.getDeclaringClassName(), null, 2, null)) == null) {
                    throw new ClassNotFoundException();
                }
                String name24 = mediaTypeEnumClass.getName();
                Intrinsics.checkNotNullExpressionValue(name24, "getName(...)");
                Class perMediaClass = ClassUtils.loadClass$default((String) StringsKt.split$default((CharSequence) name24, new String[]{"$"}, false, 0, 6, (Object) null).get(0), null, 2, null);
                Object[] declaredFields6 = perMediaClass.getDeclaredFields();
                Intrinsics.checkNotNullExpressionValue(declaredFields6, "getDeclaredFields(...)");
                Object[] $this$firstOrNull$iv3 = declaredFields6;
                int length5 = $this$firstOrNull$iv3.length;
                int i7 = 0;
                while (true) {
                    if (i7 >= length5) {
                        obj = null;
                        break;
                    }
                    Object element$iv5 = $this$firstOrNull$iv3[i7];
                    Field it22 = (Field) element$iv5;
                    int i8 = length5;
                    if (Intrinsics.areEqual(it22.getType(), mediaTypeEnumClass)) {
                        obj = element$iv5;
                        break;
                    } else {
                        i7++;
                        length5 = i8;
                    }
                }
                Field mediaTypeField = (Field) obj;
                if (mediaTypeField == null) {
                    throw new NoSuchFieldError();
                }
                Field mediaUrlHttpsField = (Field) FieldFinder.f3Static.fromClass(perMediaClass).filterNonStatic().filterByType(String.class).first();
                Field mediaInfoField = (Field) FieldFinder.f3Static.fromClass(perMediaClass).filter(new Function1<Field, Boolean>() { // from class: icu.nullptr.twifucker.hook.DownloadHook$searchHook$mediaInfoField$1
                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(Field filter) {
                        Field[] fieldArr4;
                        Field[] fieldArr5;
                        Intrinsics.checkNotNullParameter(filter, "$this$filter");
                        boolean z13 = false;
                        if (filter.getType().getDeclaredFields().length == 4) {
                            Field[] declaredFields7 = filter.getType().getDeclaredFields();
                            Intrinsics.checkNotNullExpressionValue(declaredFields7, "getDeclaredFields(...)");
                            Collection destination$iv$iv6 = new ArrayList();
                            for (Field field5 : declaredFields7) {
                                Field f2 = field5;
                                if (Intrinsics.areEqual(f2.getType(), Float.TYPE)) {
                                    destination$iv$iv6.add(field5);
                                }
                            }
                            if (((List) destination$iv$iv6).size() == 2) {
                                Field[] declaredFields8 = filter.getType().getDeclaredFields();
                                Intrinsics.checkNotNullExpressionValue(declaredFields8, "getDeclaredFields(...)");
                                Collection destination$iv$iv7 = new ArrayList();
                                for (Field field6 : declaredFields8) {
                                    Field f22 = field6;
                                    if (Intrinsics.areEqual(f22.getType(), List.class)) {
                                        destination$iv$iv7.add(field6);
                                    }
                                }
                                if (((List) destination$iv$iv7).size() == 1) {
                                    z13 = true;
                                }
                            }
                        }
                        return Boolean.valueOf(z13);
                    }
                }).first();
                FieldFinder.Static r15 = FieldFinder.f3Static;
                Class mediaTypeEnumClass2 = mediaInfoField.getType();
                Intrinsics.checkNotNullExpressionValue(mediaTypeEnumClass2, "getType(...)");
                Field variantsField = (Field) r15.fromClass(mediaTypeEnumClass2).filterByType(List.class).first();
                String name25 = shareMenuClass.getName();
                Intrinsics.checkNotNullExpressionValue(name25, "getName(...)");
                shareMenuClassName = name25;
                String name26 = shareMenuMethod.getName();
                Intrinsics.checkNotNullExpressionValue(name26, "getName(...)");
                shareMenuMethodName = name26;
                String name27 = tweetResultField.getName();
                Intrinsics.checkNotNullExpressionValue(name27, "getName(...)");
                tweetResultFieldName = name27;
                String name28 = tweetIdField.getName();
                Intrinsics.checkNotNullExpressionValue(name28, "getName(...)");
                tweetIdFieldName = name28;
                String name29 = resultField.getName();
                Intrinsics.checkNotNullExpressionValue(name29, "getName(...)");
                resultFieldName = name29;
                String name30 = legacyField.getName();
                Intrinsics.checkNotNullExpressionValue(name30, "getName(...)");
                legacyFieldName = name30;
                String name31 = extendedEntitiesField.getName();
                Intrinsics.checkNotNullExpressionValue(name31, "getName(...)");
                extendedEntitiesFieldName = name31;
                String name32 = mediaField.getName();
                Intrinsics.checkNotNullExpressionValue(name32, "getName(...)");
                mediaFieldName = name32;
                String name33 = mediaTypeField.getName();
                Intrinsics.checkNotNullExpressionValue(name33, "getName(...)");
                mediaTypeFieldName = name33;
                String name34 = mediaUrlHttpsField.getName();
                Intrinsics.checkNotNullExpressionValue(name34, "getName(...)");
                mediaUrlHttpsFieldName = name34;
                String name35 = mediaInfoField.getName();
                Intrinsics.checkNotNullExpressionValue(name35, "getName(...)");
                mediaInfoFieldName = name35;
                String name36 = variantsField.getName();
                Intrinsics.checkNotNullExpressionValue(name36, "getName(...)");
                variantsFieldName = name36;
                return;
            }
            i2++;
            returnType = returnType;
            cls = cls;
            length = i3;
            actionSheetItemClass = actionSheetItemClass2;
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    private final void loadHookInfo() {
        long hookDownloadLastUpdate = UtilsKt.getModulePrefs().getLong("hook_download_last_update", 0L);
        long hostAppLastUpdate = UtilsKt.getHostAppLastUpdate();
        Log.d$default("hookDownloadLastUpdate: " + hookDownloadLastUpdate + ", hostAppLastUpdate: " + hostAppLastUpdate + ", moduleLastModify: " + UtilsKt.getModuleLastModify(), (Throwable) null, 2, (Object) null);
        long timeStart = System.currentTimeMillis();
        if (hookDownloadLastUpdate > UtilsKt.getHostAppLastUpdate() && hookDownloadLastUpdate > UtilsKt.getModuleLastModify()) {
            loadCachedHookInfo();
            Log.d$default("Download Hook load time: " + (System.currentTimeMillis() - timeStart) + " ms", (Throwable) null, 2, (Object) null);
            return;
        }
        HookEntry.Companion.loadDexKit();
        searchHook();
        Log.d$default("Download Hook search time: " + (System.currentTimeMillis() - timeStart) + " ms", (Throwable) null, 2, (Object) null);
        saveHookInfo();
        UtilsKt.getModulePrefs().putLong("hook_download_last_update", System.currentTimeMillis());
    }
}

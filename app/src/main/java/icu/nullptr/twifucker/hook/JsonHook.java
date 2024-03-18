package icu.nullptr.twifucker.hook;

import com.github.kyuubiran.ezxhelper.ClassUtils;
import com.github.kyuubiran.ezxhelper.HookFactory;
import com.github.kyuubiran.ezxhelper.Log;
import com.github.kyuubiran.ezxhelper.finders.FieldFinder;
import com.github.kyuubiran.ezxhelper.finders.MethodFinder;
import com.github.kyuubiran.ezxhelper.interfaces.IMethodHookCallback;
import de.robv.android.xposed.XC_MethodHook;
import icu.nullptr.twifucker.UtilsKt;
import icu.nullptr.twifucker.ui.SettingsDialog;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: JsonHook.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\"\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u000b\u001a\u00020\bH\u0016J\f\u0010\f\u001a\u00020\b*\u00020\rH\u0002J\u000e\u0010\u000e\u001a\u0004\u0018\u00010\u000f*\u00020\rH\u0002J\u000e\u0010\u0010\u001a\u0004\u0018\u00010\r*\u00020\rH\u0002J\f\u0010\u0011\u001a\u00020\b*\u00020\u000fH\u0002J\f\u0010\u0012\u001a\u00020\b*\u00020\u000fH\u0002J\f\u0010\u0013\u001a\u00020\b*\u00020\u000fH\u0002J\f\u0010\u0014\u001a\u00020\b*\u00020\u000fH\u0002J\f\u0010\u0015\u001a\u00020\b*\u00020\u000fH\u0002J\f\u0010\u0016\u001a\u00020\b*\u00020\u000fH\u0002J\f\u0010\u0017\u001a\u00020\b*\u00020\u000fH\u0002J\f\u0010\u0018\u001a\u00020\b*\u00020\u000fH\u0002J\u000e\u0010\u0019\u001a\u0004\u0018\u00010\u000f*\u00020\rH\u0002J\u000e\u0010\u001a\u001a\u0004\u0018\u00010\r*\u00020\rH\u0002J\u000e\u0010\u001b\u001a\u0004\u0018\u00010\u000f*\u00020\rH\u0002J\f\u0010\u001c\u001a\u00020\u001d*\u00020\rH\u0002J\f\u0010\u001e\u001a\u00020\u001d*\u00020\rH\u0002J\f\u0010\u001f\u001a\u00020\u001d*\u00020\rH\u0002J\f\u0010 \u001a\u00020\u001d*\u00020\rH\u0002J\f\u0010!\u001a\u00020\u001d*\u00020\rH\u0002J\f\u0010\"\u001a\u00020\u001d*\u00020\rH\u0002J\f\u0010#\u001a\u00020\u001d*\u00020\rH\u0002J\f\u0010$\u001a\u00020\u001d*\u00020\rH\u0002J\f\u0010%\u001a\u00020\b*\u00020\rH\u0002J\f\u0010&\u001a\u00020\b*\u00020\rH\u0002J\u000e\u0010'\u001a\u0004\u0018\u00010\u000f*\u00020\rH\u0002J\u000e\u0010(\u001a\u0004\u0018\u00010\u000f*\u00020\rH\u0002J\u000e\u0010)\u001a\u0004\u0018\u00010\r*\u00020\rH\u0002J\f\u0010*\u001a\u00020\u001d*\u00020\rH\u0002J\f\u0010+\u001a\u00020\b*\u00020\rH\u0002J\f\u0010,\u001a\u00020\b*\u00020\rH\u0002J\u000e\u0010-\u001a\u0004\u0018\u00010\r*\u00020\rH\u0002J\u000e\u0010.\u001a\u0004\u0018\u00010\u000f*\u00020\rH\u0002J\u000e\u0010/\u001a\u0004\u0018\u00010\r*\u00020\rH\u0002J\f\u00100\u001a\u00020\u001d*\u00020\rH\u0002J\f\u00101\u001a\u00020\u001d*\u00020\rH\u0002J\f\u00102\u001a\u00020\b*\u00020\rH\u0002J\f\u00103\u001a\u00020\b*\u00020\rH\u0002J\f\u00104\u001a\u00020\b*\u00020\rH\u0002J\u000e\u00105\u001a\u0004\u0018\u00010\u000f*\u00020\rH\u0002J\u000e\u00106\u001a\u0004\u0018\u00010\r*\u00020\rH\u0002J\f\u00107\u001a\u00020\b*\u00020\rH\u0002J\f\u00108\u001a\u00020\u001d*\u00020\rH\u0002J\f\u00109\u001a\u00020\b*\u00020\rH\u0002J\f\u0010:\u001a\u00020\u001d*\u00020\rH\u0002J\f\u0010;\u001a\u00020\b*\u00020\u000fH\u0002J\f\u0010<\u001a\u00020\b*\u00020\rH\u0002J\u000e\u0010=\u001a\u0004\u0018\u00010\u000f*\u00020\rH\u0002J \u0010>\u001a\u00020\b*\u00020\r2\u0012\u0010?\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\b0@H\u0002R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006A"}, d2 = {"Licu/nullptr/twifucker/hook/JsonHook;", "Licu/nullptr/twifucker/hook/BaseHook;", "()V", "name", "", "getName", "()Ljava/lang/String;", "handleJson", "", "param", "Lde/robv/android/xposed/XC_MethodHook$MethodHookParam;", "init", "dataCheckAndRemove", "Lorg/json/JSONObject;", "dataGetInstructions", "Lorg/json/JSONArray;", "dataGetLegacy", "entriesRemoveAnnoyance", "entriesRemoveSensitiveMediaWarning", "entriesRemoveTimelineAds", "entriesRemoveTopicsToFollow", "entriesRemoveTweetDetailRelatedTweets", "entriesRemoveVideoCarousel", "entriesRemoveWhoToFollow", "entriesRemoveWhoToSubscribe", "entryGetContentItems", "entryGetLegacy", "entryGetTrends", "entryHasPromotedMetadata", "", "entryIsConversationThread", "entryIsTopicsModule", "entryIsTweet", "entryIsTweetDetailRelatedTweets", "entryIsVideoCarousel", "entryIsWhoToFollow", "entryIsWhoToSubscribe", "entryRemoveSensitiveMediaWarning", "instructionCheckAndRemove", "instructionGetAddEntries", "instructionTimelineAddEntries", "instructionTimelinePinEntry", "itemContainsPromotedUser", "jsonCheckAndRemoveRecommendedUsers", "jsonCheckAndRemoveThreads", "jsonGetData", "jsonGetInstructions", "jsonGetTweets", "jsonHasRecommendedUsers", "jsonHasThreads", "jsonRemoveRecommendedUsers", "jsonRemoveThreads", "legacyCheckAndRemove", "legacyGetExtendedEntitiesMedias", "legacyGetRetweetedStatusLegacy", "mediaCheckAndRemove", "mediaHasSensitiveMediaWarning", "mediaRemoveSensitiveMediaWarning", "trendHasPromotedMetadata", "trendRemoveAds", "tweetCheckAndRemove", "tweetGetExtendedEntitiesMedias", "tweetsForEach", "action", "Lkotlin/Function1;", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class JsonHook extends BaseHook {
    public static final JsonHook INSTANCE = new JsonHook();

    private JsonHook() {
    }

    @Override // icu.nullptr.twifucker.hook.BaseHook
    public String getName() {
        return "JsonHook";
    }

    @Override // icu.nullptr.twifucker.hook.BaseHook
    public void init() {
        try {
            HookFactory.Static r0 = HookFactory.f1Static;
            MethodFinder.Static r1 = MethodFinder.f4Static;
            Class $this$init_u24lambda_u240 = ((Field) FieldFinder.f3Static.fromClass(ClassUtils.loadClass$default("com.bluelinelabs.logansquare.LoganSquare", null, 2, null)).filterByName("JSON_FACTORY").first()).getType();
            Log.d$default("Located json class " + $this$init_u24lambda_u240.getName(), (Throwable) null, 2, (Object) null);
            Unit unit = Unit.INSTANCE;
            Intrinsics.checkNotNullExpressionValue($this$init_u24lambda_u240, "apply(...)");
            Member first = r1.methodFinder($this$init_u24lambda_u240).filterFinal().filterByParamTypes(new Function1<Class<?>[], Boolean>() { // from class: icu.nullptr.twifucker.hook.JsonHook$init$2
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(Class<?>[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    boolean z = true;
                    if (!(!(it.length == 0)) || !Intrinsics.areEqual(it[0], InputStream.class)) {
                        z = false;
                    }
                    return Boolean.valueOf(z);
                }
            }).first();
            Method $this$init_u24lambda_u241 = (Method) first;
            Log.d$default("Located json method " + $this$init_u24lambda_u241.getName(), (Throwable) null, 2, (Object) null);
            r0.m38createMethodHook((Method) first, new Function1<HookFactory, Unit>() { // from class: icu.nullptr.twifucker.hook.JsonHook$init$4
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(HookFactory hookFactory) {
                    invoke2(hookFactory);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(HookFactory createHook) {
                    Intrinsics.checkNotNullParameter(createHook, "$this$createHook");
                    final String name$iv = JsonHook.INSTANCE.getName();
                    createHook.before(new IMethodHookCallback() { // from class: icu.nullptr.twifucker.hook.JsonHook$init$4$invoke$$inlined$beforeMeasure$1
                        @Override // com.github.kyuubiran.ezxhelper.interfaces.IMethodHookCallback
                        public final void onMethodHooked(XC_MethodHook.MethodHookParam it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            long start = System.currentTimeMillis();
                            try {
                                JsonHook.INSTANCE.handleJson(it);
                            } catch (Throwable t) {
                                Log.e$default(t, (String) null, 2, (Object) null);
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
        } catch (NoSuchFieldException e) {
            Log.d("Failed to relocate json field", e);
        } catch (NoSuchMethodException e2) {
            Log.d("Failed to relocate json method", e2);
        } catch (Throwable e3) {
            Log.e("json hook failed", e3);
        }
    }

    private final JSONObject jsonGetTweets(JSONObject $this$jsonGetTweets) {
        JSONObject optJSONObject = $this$jsonGetTweets.optJSONObject("globalObjects");
        if (optJSONObject != null) {
            return optJSONObject.optJSONObject("tweets");
        }
        return null;
    }

    private final JSONArray jsonGetInstructions(JSONObject $this$jsonGetInstructions) {
        JSONObject optJSONObject = $this$jsonGetInstructions.optJSONObject("timeline");
        if (optJSONObject != null) {
            return optJSONObject.optJSONArray("instructions");
        }
        return null;
    }

    private final JSONObject jsonGetData(JSONObject $this$jsonGetData) {
        return $this$jsonGetData.optJSONObject("data");
    }

    private final boolean jsonHasRecommendedUsers(JSONObject $this$jsonHasRecommendedUsers) {
        return $this$jsonHasRecommendedUsers.has("recommended_users");
    }

    private final void jsonRemoveRecommendedUsers(JSONObject $this$jsonRemoveRecommendedUsers) {
        $this$jsonRemoveRecommendedUsers.remove("recommended_users");
    }

    private final void jsonCheckAndRemoveRecommendedUsers(JSONObject $this$jsonCheckAndRemoveRecommendedUsers) {
        if (UtilsKt.getModulePrefs().getBoolean("disable_recommended_users", false) && jsonHasRecommendedUsers($this$jsonCheckAndRemoveRecommendedUsers)) {
            Log.d$default("Handle recommended users: " + $this$jsonCheckAndRemoveRecommendedUsers, (Throwable) null, 2, (Object) null);
            jsonRemoveRecommendedUsers($this$jsonCheckAndRemoveRecommendedUsers);
        }
    }

    private final boolean jsonHasThreads(JSONObject $this$jsonHasThreads) {
        return $this$jsonHasThreads.has("threads");
    }

    private final void jsonRemoveThreads(JSONObject $this$jsonRemoveThreads) {
        $this$jsonRemoveThreads.remove("threads");
    }

    private final void jsonCheckAndRemoveThreads(JSONObject $this$jsonCheckAndRemoveThreads) {
        if (UtilsKt.getModulePrefs().getBoolean("disable_threads", false) && jsonHasThreads($this$jsonCheckAndRemoveThreads)) {
            Log.d$default("Handle threads: " + $this$jsonCheckAndRemoveThreads, (Throwable) null, 2, (Object) null);
            jsonRemoveThreads($this$jsonCheckAndRemoveThreads);
        }
    }

    private final JSONArray dataGetInstructions(JSONObject $this$dataGetInstructions) {
        JSONObject timeline;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        JSONObject optJSONObject3;
        JSONObject optJSONObject4 = $this$dataGetInstructions.optJSONObject("user_result");
        if (optJSONObject4 == null || (optJSONObject2 = optJSONObject4.optJSONObject("result")) == null || (optJSONObject3 = optJSONObject2.optJSONObject("timeline_response")) == null || (timeline = optJSONObject3.optJSONObject("timeline")) == null) {
            JSONObject optJSONObject5 = $this$dataGetInstructions.optJSONObject("timeline_response");
            timeline = optJSONObject5 != null ? optJSONObject5.optJSONObject("timeline") : null;
            if (timeline == null && (timeline = $this$dataGetInstructions.optJSONObject("timeline_response")) == null) {
                JSONObject optJSONObject6 = $this$dataGetInstructions.optJSONObject("search");
                timeline = (optJSONObject6 == null || (optJSONObject = optJSONObject6.optJSONObject("timeline_response")) == null) ? null : optJSONObject.optJSONObject("timeline");
            }
        }
        if (timeline != null) {
            return timeline.optJSONArray("instructions");
        }
        return null;
    }

    private final void dataCheckAndRemove(JSONObject $this$dataCheckAndRemove) {
        JSONArray $this$forEach$iv = dataGetInstructions($this$dataCheckAndRemove);
        if ($this$forEach$iv != null) {
            Iterable $this$forEach$iv$iv = RangesKt.until(0, $this$forEach$iv.length());
            Iterator<Integer> it = $this$forEach$iv$iv.iterator();
            while (it.hasNext()) {
                int element$iv$iv = ((IntIterator) it).nextInt();
                if ($this$forEach$iv.get(element$iv$iv) instanceof JSONObject) {
                    Object obj = $this$forEach$iv.get(element$iv$iv);
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type org.json.JSONObject");
                    JSONObject instruction = (JSONObject) obj;
                    INSTANCE.instructionCheckAndRemove(instruction);
                }
            }
        }
        JSONObject dataGetLegacy = dataGetLegacy($this$dataCheckAndRemove);
        if (dataGetLegacy != null) {
            legacyCheckAndRemove(dataGetLegacy);
        }
    }

    private final JSONObject dataGetLegacy(JSONObject $this$dataGetLegacy) {
        JSONObject it;
        JSONObject jSONObject;
        JSONObject optJSONObject = $this$dataGetLegacy.optJSONObject("tweet_result");
        if (optJSONObject != null && (it = optJSONObject.optJSONObject("result")) != null) {
            if (it.has("tweet")) {
                jSONObject = it.optJSONObject("tweet");
            } else {
                jSONObject = it;
            }
            if (jSONObject != null) {
                return jSONObject.optJSONObject("legacy");
            }
        }
        return null;
    }

    private final void tweetsForEach(JSONObject $this$tweetsForEach, Function1<? super JSONObject, Unit> function1) {
        Iterator<String> keys = $this$tweetsForEach.keys();
        Intrinsics.checkNotNullExpressionValue(keys, "keys(...)");
        while (keys.hasNext()) {
            String i = keys.next();
            JSONObject it = $this$tweetsForEach.optJSONObject(i);
            if (it != null) {
                function1.invoke(it);
            }
        }
    }

    private final JSONArray tweetGetExtendedEntitiesMedias(JSONObject $this$tweetGetExtendedEntitiesMedias) {
        JSONObject optJSONObject = $this$tweetGetExtendedEntitiesMedias.optJSONObject("extended_entities");
        if (optJSONObject != null) {
            return optJSONObject.optJSONArray("media");
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void tweetCheckAndRemove(JSONObject $this$tweetCheckAndRemove) {
        JSONArray $this$forEach$iv = tweetGetExtendedEntitiesMedias($this$tweetCheckAndRemove);
        if ($this$forEach$iv == null) {
            return;
        }
        Iterable $this$forEach$iv$iv = RangesKt.until(0, $this$forEach$iv.length());
        Iterator<Integer> it = $this$forEach$iv$iv.iterator();
        while (it.hasNext()) {
            int element$iv$iv = ((IntIterator) it).nextInt();
            if ($this$forEach$iv.get(element$iv$iv) instanceof JSONObject) {
                Object obj = $this$forEach$iv.get(element$iv$iv);
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type org.json.JSONObject");
                JSONObject media = (JSONObject) obj;
                INSTANCE.mediaCheckAndRemove(media);
            }
        }
    }

    private final boolean entryHasPromotedMetadata(JSONObject $this$entryHasPromotedMetadata) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        JSONObject optJSONObject3;
        JSONObject optJSONObject4;
        JSONObject optJSONObject5;
        JSONObject optJSONObject6;
        JSONObject optJSONObject7;
        JSONObject optJSONObject8;
        JSONObject optJSONObject9 = $this$entryHasPromotedMetadata.optJSONObject("content");
        if ((optJSONObject9 == null || (optJSONObject6 = optJSONObject9.optJSONObject("item")) == null || (optJSONObject7 = optJSONObject6.optJSONObject("content")) == null || (optJSONObject8 = optJSONObject7.optJSONObject("tweet")) == null) ? false : optJSONObject8.has("promotedMetadata")) {
            return true;
        }
        JSONObject optJSONObject10 = $this$entryHasPromotedMetadata.optJSONObject("content");
        if ((optJSONObject10 == null || (optJSONObject5 = optJSONObject10.optJSONObject("content")) == null) ? false : optJSONObject5.has("tweetPromotedMetadata")) {
            return true;
        }
        JSONObject optJSONObject11 = $this$entryHasPromotedMetadata.optJSONObject("item");
        if ((optJSONObject11 == null || (optJSONObject4 = optJSONObject11.optJSONObject("content")) == null) ? false : optJSONObject4.has("tweetPromotedMetadata")) {
            return true;
        }
        JSONObject optJSONObject12 = $this$entryHasPromotedMetadata.optJSONObject("content");
        return (optJSONObject12 == null || (optJSONObject = optJSONObject12.optJSONObject("item")) == null || (optJSONObject2 = optJSONObject.optJSONObject("content")) == null || (optJSONObject3 = optJSONObject2.optJSONObject("eventSummary")) == null) ? false : optJSONObject3.has("promotedMetadata");
    }

    private final boolean entryIsWhoToFollow(JSONObject $this$entryIsWhoToFollow) {
        String it = $this$entryIsWhoToFollow.optString("entryId");
        Intrinsics.checkNotNull(it);
        return StringsKt.startsWith$default(it, "whoToFollow-", false, 2, (Object) null) || StringsKt.startsWith$default(it, "who-to-follow-", false, 2, (Object) null) || StringsKt.startsWith$default(it, "connect-module-", false, 2, (Object) null);
    }

    private final boolean entryIsWhoToSubscribe(JSONObject $this$entryIsWhoToSubscribe) {
        String optString = $this$entryIsWhoToSubscribe.optString("entryId");
        Intrinsics.checkNotNullExpressionValue(optString, "optString(...)");
        return StringsKt.startsWith$default(optString, "who-to-subscribe-", false, 2, (Object) null);
    }

    private final boolean entryIsTopicsModule(JSONObject $this$entryIsTopicsModule) {
        String optString = $this$entryIsTopicsModule.optString("entryId");
        Intrinsics.checkNotNullExpressionValue(optString, "optString(...)");
        return StringsKt.startsWith$default(optString, "TopicsModule-", false, 2, (Object) null);
    }

    private final JSONArray entryGetContentItems(JSONObject $this$entryGetContentItems) {
        JSONObject optJSONObject;
        JSONArray optJSONArray;
        JSONObject optJSONObject2 = $this$entryGetContentItems.optJSONObject("content");
        if (optJSONObject2 == null || (optJSONArray = optJSONObject2.optJSONArray("items")) == null) {
            JSONObject optJSONObject3 = $this$entryGetContentItems.optJSONObject("content");
            if (optJSONObject3 == null || (optJSONObject = optJSONObject3.optJSONObject("timelineModule")) == null) {
                return null;
            }
            return optJSONObject.optJSONArray("items");
        }
        return optJSONArray;
    }

    private final boolean entryIsTweet(JSONObject $this$entryIsTweet) {
        String optString = $this$entryIsTweet.optString("entryId");
        Intrinsics.checkNotNullExpressionValue(optString, "optString(...)");
        return StringsKt.startsWith$default(optString, "tweet-", false, 2, (Object) null);
    }

    private final boolean entryIsConversationThread(JSONObject $this$entryIsConversationThread) {
        String optString = $this$entryIsConversationThread.optString("entryId");
        Intrinsics.checkNotNullExpressionValue(optString, "optString(...)");
        return StringsKt.startsWith$default(optString, "conversationthread-", false, 2, (Object) null);
    }

    private final boolean entryIsTweetDetailRelatedTweets(JSONObject $this$entryIsTweetDetailRelatedTweets) {
        String optString = $this$entryIsTweetDetailRelatedTweets.optString("entryId");
        Intrinsics.checkNotNullExpressionValue(optString, "optString(...)");
        return StringsKt.startsWith$default(optString, "tweetdetailrelatedtweets-", false, 2, (Object) null);
    }

    private final boolean entryIsVideoCarousel(JSONObject $this$entryIsVideoCarousel) {
        String str;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        JSONObject optJSONObject3 = $this$entryIsVideoCarousel.optJSONObject("content");
        if (optJSONObject3 == null || (optJSONObject = optJSONObject3.optJSONObject("timelineModule")) == null || (optJSONObject2 = optJSONObject.optJSONObject("clientEventInfo")) == null) {
            str = null;
        } else {
            str = optJSONObject2.optString("component");
        }
        return Intrinsics.areEqual(str, "video_carousel");
    }

    private final JSONObject entryGetLegacy(JSONObject $this$entryGetLegacy) {
        JSONObject temp;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        JSONObject it;
        JSONObject jSONObject;
        if ($this$entryGetLegacy.has("content")) {
            temp = $this$entryGetLegacy.optJSONObject("content");
        } else if (!$this$entryGetLegacy.has("item")) {
            return null;
        } else {
            temp = $this$entryGetLegacy.optJSONObject("item");
        }
        if (temp == null || (optJSONObject = temp.optJSONObject("content")) == null || (optJSONObject2 = optJSONObject.optJSONObject("tweetResult")) == null || (it = optJSONObject2.optJSONObject("result")) == null) {
            return null;
        }
        if (it.has("tweet")) {
            jSONObject = it.optJSONObject("tweet");
        } else {
            jSONObject = it;
        }
        if (jSONObject != null) {
            return jSONObject.optJSONObject("legacy");
        }
        return null;
    }

    private final JSONArray entryGetTrends(JSONObject $this$entryGetTrends) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2 = $this$entryGetTrends.optJSONObject("content");
        if (optJSONObject2 == null || (optJSONObject = optJSONObject2.optJSONObject("timelineModule")) == null) {
            return null;
        }
        return optJSONObject.optJSONArray("items");
    }

    private final boolean trendHasPromotedMetadata(JSONObject $this$trendHasPromotedMetadata) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        JSONObject optJSONObject3 = $this$trendHasPromotedMetadata.optJSONObject("item");
        return (optJSONObject3 == null || (optJSONObject = optJSONObject3.optJSONObject("content")) == null || (optJSONObject2 = optJSONObject.optJSONObject("trend")) == null || !optJSONObject2.has("promotedMetadata")) ? false : true;
    }

    private final void trendRemoveAds(JSONArray $this$trendRemoveAds) {
        if (UtilsKt.getModulePrefs().getBoolean("disable_promoted_trends", true)) {
            List trendRemoveIndex = new ArrayList();
            Iterable $this$forEach$iv$iv = RangesKt.until(0, $this$trendRemoveAds.length());
            Iterator<Integer> it = $this$forEach$iv$iv.iterator();
            while (it.hasNext()) {
                int element$iv$iv = ((IntIterator) it).nextInt();
                if ($this$trendRemoveAds.get(element$iv$iv) instanceof JSONObject) {
                    Object obj = $this$trendRemoveAds.get(element$iv$iv);
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type org.json.JSONObject");
                    JSONObject trend = (JSONObject) obj;
                    if (INSTANCE.trendHasPromotedMetadata(trend)) {
                        Log.d$default("Handle trends ads " + element$iv$iv + " " + trend, (Throwable) null, 2, (Object) null);
                        trendRemoveIndex.add(Integer.valueOf(element$iv$iv));
                    }
                }
            }
            for (Number number : CollectionsKt.asReversedMutable(trendRemoveIndex)) {
                int i = number.intValue();
                $this$trendRemoveAds.remove(i);
            }
        }
    }

    private final JSONObject legacyGetRetweetedStatusLegacy(JSONObject $this$legacyGetRetweetedStatusLegacy) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2 = $this$legacyGetRetweetedStatusLegacy.optJSONObject("retweeted_status_result");
        if (optJSONObject2 == null || (optJSONObject = optJSONObject2.optJSONObject("result")) == null) {
            return null;
        }
        return optJSONObject.optJSONObject("legacy");
    }

    private final JSONArray legacyGetExtendedEntitiesMedias(JSONObject $this$legacyGetExtendedEntitiesMedias) {
        JSONObject optJSONObject = $this$legacyGetExtendedEntitiesMedias.optJSONObject("extended_entities");
        if (optJSONObject != null) {
            return optJSONObject.optJSONArray("media");
        }
        return null;
    }

    private final void legacyCheckAndRemove(JSONObject $this$legacyCheckAndRemove) {
        JSONArray $this$forEach$iv;
        JSONArray $this$forEach$iv2 = legacyGetExtendedEntitiesMedias($this$legacyCheckAndRemove);
        if ($this$forEach$iv2 != null) {
            Iterable $this$forEach$iv$iv = RangesKt.until(0, $this$forEach$iv2.length());
            Iterator<Integer> it = $this$forEach$iv$iv.iterator();
            while (it.hasNext()) {
                int element$iv$iv = ((IntIterator) it).nextInt();
                if ($this$forEach$iv2.get(element$iv$iv) instanceof JSONObject) {
                    Object obj = $this$forEach$iv2.get(element$iv$iv);
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type org.json.JSONObject");
                    JSONObject media = (JSONObject) obj;
                    INSTANCE.mediaCheckAndRemove(media);
                }
            }
        }
        JSONObject legacyGetRetweetedStatusLegacy = legacyGetRetweetedStatusLegacy($this$legacyCheckAndRemove);
        if (legacyGetRetweetedStatusLegacy == null || ($this$forEach$iv = legacyGetExtendedEntitiesMedias(legacyGetRetweetedStatusLegacy)) == null) {
            return;
        }
        Iterable $this$forEach$iv$iv2 = RangesKt.until(0, $this$forEach$iv.length());
        Iterator<Integer> it2 = $this$forEach$iv$iv2.iterator();
        while (it2.hasNext()) {
            int element$iv$iv2 = ((IntIterator) it2).nextInt();
            if ($this$forEach$iv.get(element$iv$iv2) instanceof JSONObject) {
                Object obj2 = $this$forEach$iv.get(element$iv$iv2);
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type org.json.JSONObject");
                JSONObject media2 = (JSONObject) obj2;
                INSTANCE.mediaCheckAndRemove(media2);
            }
        }
    }

    private final boolean itemContainsPromotedUser(JSONObject $this$itemContainsPromotedUser) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        JSONObject optJSONObject3;
        JSONObject optJSONObject4;
        JSONObject optJSONObject5;
        JSONObject optJSONObject6 = $this$itemContainsPromotedUser.optJSONObject("item");
        if ((optJSONObject6 == null || (optJSONObject5 = optJSONObject6.optJSONObject("content")) == null) ? false : optJSONObject5.has("userPromotedMetadata")) {
            return true;
        }
        JSONObject optJSONObject7 = $this$itemContainsPromotedUser.optJSONObject("item");
        if ((optJSONObject7 == null || (optJSONObject3 = optJSONObject7.optJSONObject("content")) == null || (optJSONObject4 = optJSONObject3.optJSONObject("user")) == null) ? false : optJSONObject4.has("userPromotedMetadata")) {
            return true;
        }
        JSONObject optJSONObject8 = $this$itemContainsPromotedUser.optJSONObject("item");
        return (optJSONObject8 == null || (optJSONObject = optJSONObject8.optJSONObject("content")) == null || (optJSONObject2 = optJSONObject.optJSONObject("user")) == null) ? false : optJSONObject2.has("promotedMetadata");
    }

    private final JSONObject instructionTimelinePinEntry(JSONObject $this$instructionTimelinePinEntry) {
        return $this$instructionTimelinePinEntry.optJSONObject("entry");
    }

    private final JSONArray instructionTimelineAddEntries(JSONObject $this$instructionTimelineAddEntries) {
        return $this$instructionTimelineAddEntries.optJSONArray("entries");
    }

    private final JSONArray instructionGetAddEntries(JSONObject $this$instructionGetAddEntries) {
        JSONObject optJSONObject = $this$instructionGetAddEntries.optJSONObject("addEntries");
        if (optJSONObject != null) {
            return optJSONObject.optJSONArray("entries");
        }
        return null;
    }

    private final void instructionCheckAndRemove(JSONObject $this$instructionCheckAndRemove) {
        JSONObject instructionTimelinePinEntry = instructionTimelinePinEntry($this$instructionCheckAndRemove);
        if (instructionTimelinePinEntry != null) {
            entryRemoveSensitiveMediaWarning(instructionTimelinePinEntry);
        }
        JSONArray instructionTimelineAddEntries = instructionTimelineAddEntries($this$instructionCheckAndRemove);
        if (instructionTimelineAddEntries != null) {
            entriesRemoveAnnoyance(instructionTimelineAddEntries);
        }
        JSONArray instructionGetAddEntries = instructionGetAddEntries($this$instructionCheckAndRemove);
        if (instructionGetAddEntries != null) {
            entriesRemoveAnnoyance(instructionGetAddEntries);
        }
    }

    private final boolean mediaHasSensitiveMediaWarning(JSONObject $this$mediaHasSensitiveMediaWarning) {
        return $this$mediaHasSensitiveMediaWarning.has("sensitive_media_warning") || ($this$mediaHasSensitiveMediaWarning.has("ext_sensitive_media_warning") && $this$mediaHasSensitiveMediaWarning.optJSONObject("ext_sensitive_media_warning") != null);
    }

    private final void mediaRemoveSensitiveMediaWarning(JSONObject $this$mediaRemoveSensitiveMediaWarning) {
        $this$mediaRemoveSensitiveMediaWarning.remove("sensitive_media_warning");
        $this$mediaRemoveSensitiveMediaWarning.remove("ext_sensitive_media_warning");
    }

    private final void mediaCheckAndRemove(JSONObject $this$mediaCheckAndRemove) {
        if (UtilsKt.getModulePrefs().getBoolean("disable_sensitive_media_warning", false) && mediaHasSensitiveMediaWarning($this$mediaCheckAndRemove)) {
            Log.d$default("Handle sensitive media warning " + $this$mediaCheckAndRemove, (Throwable) null, 2, (Object) null);
            mediaRemoveSensitiveMediaWarning($this$mediaCheckAndRemove);
        }
    }

    private final void entriesRemoveTimelineAds(JSONArray $this$entriesRemoveTimelineAds) {
        JSONArray $this$forEachIndexed$iv;
        boolean z;
        Iterable $this$forEach$iv$iv;
        String str;
        List removeIndex = new ArrayList();
        JSONArray $this$forEachIndexed$iv2 = $this$entriesRemoveTimelineAds;
        boolean z2 = false;
        Iterable $this$forEach$iv$iv2 = RangesKt.until(0, $this$forEachIndexed$iv2.length());
        Iterator<Integer> it = $this$forEach$iv$iv2.iterator();
        while (it.hasNext()) {
            int element$iv$iv = ((IntIterator) it).nextInt();
            if (!($this$forEachIndexed$iv2.get(element$iv$iv) instanceof JSONObject)) {
                $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                z = z2;
                $this$forEach$iv$iv = $this$forEach$iv$iv2;
            } else {
                Object obj = $this$forEachIndexed$iv2.get(element$iv$iv);
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type org.json.JSONObject");
                JSONObject entry = (JSONObject) obj;
                JSONArray entryGetTrends = INSTANCE.entryGetTrends(entry);
                if (entryGetTrends != null) {
                    INSTANCE.trendRemoveAds(entryGetTrends);
                }
                if (!UtilsKt.getModulePrefs().getBoolean(SettingsDialog.PREF_DISABLE_PROMOTED_CONTENT, true)) {
                    $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                    z = z2;
                    $this$forEach$iv$iv = $this$forEach$iv$iv2;
                } else {
                    String str2 = " ";
                    if (!INSTANCE.entryHasPromotedMetadata(entry)) {
                        $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                    } else {
                        $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                        Log.d$default("Handle timeline ads " + element$iv$iv + " " + entry, (Throwable) null, 2, (Object) null);
                        removeIndex.add(Integer.valueOf(element$iv$iv));
                    }
                    List innerRemoveIndex = new ArrayList();
                    JSONArray contentItems = INSTANCE.entryGetContentItems(entry);
                    if (contentItems == null) {
                        z = z2;
                        $this$forEach$iv$iv = $this$forEach$iv$iv2;
                    } else {
                        z = z2;
                        int $i$f$forEachIndexed = contentItems.length();
                        $this$forEach$iv$iv = $this$forEach$iv$iv2;
                        Iterable $this$forEach$iv$iv3 = RangesKt.until(0, $i$f$forEachIndexed);
                        Iterator<Integer> it2 = $this$forEach$iv$iv3.iterator();
                        while (it2.hasNext()) {
                            int element$iv$iv2 = ((IntIterator) it2).nextInt();
                            Iterable $this$forEach$iv$iv4 = $this$forEach$iv$iv3;
                            if (contentItems.get(element$iv$iv2) instanceof JSONObject) {
                                Object obj2 = contentItems.get(element$iv$iv2);
                                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type org.json.JSONObject");
                                JSONObject item = (JSONObject) obj2;
                                if (INSTANCE.entryHasPromotedMetadata(item)) {
                                    str = str2;
                                    Log.d$default("Handle timeline replies ads " + element$iv$iv + str2 + entry, (Throwable) null, 2, (Object) null);
                                    if (contentItems.length() == 1) {
                                        removeIndex.add(Integer.valueOf(element$iv$iv));
                                    } else {
                                        innerRemoveIndex.add(Integer.valueOf(element$iv$iv2));
                                    }
                                } else {
                                    str = str2;
                                }
                            } else {
                                str = str2;
                            }
                            str2 = str;
                            $this$forEach$iv$iv3 = $this$forEach$iv$iv4;
                        }
                    }
                    for (Number number : CollectionsKt.asReversedMutable(innerRemoveIndex)) {
                        int i = number.intValue();
                        if (contentItems != null) {
                            contentItems.remove(i);
                        }
                    }
                }
            }
            $this$forEachIndexed$iv2 = $this$forEachIndexed$iv;
            z2 = z;
            $this$forEach$iv$iv2 = $this$forEach$iv$iv;
        }
        for (Number number2 : CollectionsKt.reversed(removeIndex)) {
            int i2 = number2.intValue();
            $this$entriesRemoveTimelineAds.remove(i2);
        }
    }

    private final void entriesRemoveWhoToFollow(JSONArray $this$entriesRemoveWhoToFollow) {
        JSONArray $this$forEachIndexed$iv;
        boolean z;
        Iterable $this$forEach$iv$iv;
        boolean z2;
        String str;
        boolean z3;
        List entryRemoveIndex = new ArrayList();
        JSONArray $this$forEachIndexed$iv2 = $this$entriesRemoveWhoToFollow;
        boolean z4 = false;
        boolean z5 = false;
        Iterable $this$forEach$iv$iv2 = RangesKt.until(0, $this$forEachIndexed$iv2.length());
        boolean z6 = false;
        Iterator<Integer> it = $this$forEach$iv$iv2.iterator();
        while (it.hasNext()) {
            int element$iv$iv = ((IntIterator) it).nextInt();
            if (!($this$forEachIndexed$iv2.get(element$iv$iv) instanceof JSONObject)) {
                $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                z = z4;
                $this$forEach$iv$iv = $this$forEach$iv$iv2;
                z2 = z6;
            } else {
                Object obj = $this$forEachIndexed$iv2.get(element$iv$iv);
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type org.json.JSONObject");
                JSONObject entry = (JSONObject) obj;
                if (!INSTANCE.entryIsWhoToFollow(entry)) {
                    $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                    z = z4;
                    $this$forEach$iv$iv = $this$forEach$iv$iv2;
                    z2 = z6;
                } else {
                    boolean z7 = UtilsKt.getModulePrefs().getBoolean("disable_who_to_follow", z5);
                    String str2 = " ";
                    if (z7) {
                        Log.d$default("Handle whoToFollow " + element$iv$iv + " " + entry, (Throwable) null, 2, (Object) null);
                        entryRemoveIndex.add(Integer.valueOf(element$iv$iv));
                        $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                        z = z4;
                        $this$forEach$iv$iv = $this$forEach$iv$iv2;
                        z2 = z6;
                    } else {
                        $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                        if (!UtilsKt.getModulePrefs().getBoolean("disable_promoted_user", true)) {
                            z = z4;
                            $this$forEach$iv$iv = $this$forEach$iv$iv2;
                            z2 = z6;
                        } else {
                            JSONArray items = INSTANCE.entryGetContentItems(entry);
                            List userRemoveIndex = new ArrayList();
                            if (items == null) {
                                z = z4;
                                $this$forEach$iv$iv = $this$forEach$iv$iv2;
                                z2 = z6;
                            } else {
                                z = z4;
                                int $i$f$forEachIndexed = items.length();
                                $this$forEach$iv$iv = $this$forEach$iv$iv2;
                                Iterable $this$forEach$iv$iv3 = RangesKt.until(0, $i$f$forEachIndexed);
                                Iterator<Integer> it2 = $this$forEach$iv$iv3.iterator();
                                while (it2.hasNext()) {
                                    int element$iv$iv2 = ((IntIterator) it2).nextInt();
                                    Iterable $this$forEach$iv$iv4 = $this$forEach$iv$iv3;
                                    if (items.get(element$iv$iv2) instanceof JSONObject) {
                                        Object obj2 = items.get(element$iv$iv2);
                                        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type org.json.JSONObject");
                                        JSONObject item = (JSONObject) obj2;
                                        boolean it3 = INSTANCE.itemContainsPromotedUser(item);
                                        if (it3) {
                                            z3 = z6;
                                            str = str2;
                                            Log.d$default("Handle whoToFollow promoted user " + element$iv$iv2 + str2 + item, (Throwable) null, 2, (Object) null);
                                            userRemoveIndex.add(Integer.valueOf(element$iv$iv2));
                                        } else {
                                            str = str2;
                                            z3 = z6;
                                        }
                                    } else {
                                        str = str2;
                                        z3 = z6;
                                    }
                                    str2 = str;
                                    $this$forEach$iv$iv3 = $this$forEach$iv$iv4;
                                    z6 = z3;
                                }
                                z2 = z6;
                            }
                            for (Number number : CollectionsKt.reversed(userRemoveIndex)) {
                                int i = number.intValue();
                                if (items != null) {
                                    items.remove(i);
                                }
                            }
                        }
                    }
                }
            }
            $this$forEachIndexed$iv2 = $this$forEachIndexed$iv;
            z4 = z;
            $this$forEach$iv$iv2 = $this$forEach$iv$iv;
            z6 = z2;
            z5 = false;
        }
        for (Number number2 : CollectionsKt.reversed(entryRemoveIndex)) {
            int i2 = number2.intValue();
            $this$entriesRemoveWhoToFollow.remove(i2);
        }
    }

    private final void entriesRemoveWhoToSubscribe(JSONArray $this$entriesRemoveWhoToSubscribe) {
        List entryRemoveIndex = new ArrayList();
        Iterable $this$forEach$iv$iv = RangesKt.until(0, $this$entriesRemoveWhoToSubscribe.length());
        Iterator<Integer> it = $this$forEach$iv$iv.iterator();
        while (it.hasNext()) {
            int element$iv$iv = ((IntIterator) it).nextInt();
            if ($this$entriesRemoveWhoToSubscribe.get(element$iv$iv) instanceof JSONObject) {
                Object obj = $this$entriesRemoveWhoToSubscribe.get(element$iv$iv);
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type org.json.JSONObject");
                JSONObject entry = (JSONObject) obj;
                if (INSTANCE.entryIsWhoToSubscribe(entry) && UtilsKt.getModulePrefs().getBoolean("disable_who_to_subscribe", false)) {
                    Log.d$default("Handle whoToSubscribe " + element$iv$iv + " " + entry, (Throwable) null, 2, (Object) null);
                    entryRemoveIndex.add(Integer.valueOf(element$iv$iv));
                }
            }
        }
        for (Number number : CollectionsKt.reversed(entryRemoveIndex)) {
            int i = number.intValue();
            $this$entriesRemoveWhoToSubscribe.remove(i);
        }
    }

    private final void entriesRemoveTopicsToFollow(JSONArray $this$entriesRemoveTopicsToFollow) {
        List entryRemoveIndex = new ArrayList();
        Iterable $this$forEach$iv$iv = RangesKt.until(0, $this$entriesRemoveTopicsToFollow.length());
        Iterator<Integer> it = $this$forEach$iv$iv.iterator();
        while (it.hasNext()) {
            int element$iv$iv = ((IntIterator) it).nextInt();
            if ($this$entriesRemoveTopicsToFollow.get(element$iv$iv) instanceof JSONObject) {
                Object obj = $this$entriesRemoveTopicsToFollow.get(element$iv$iv);
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type org.json.JSONObject");
                JSONObject entry = (JSONObject) obj;
                if (INSTANCE.entryIsTopicsModule(entry) && UtilsKt.getModulePrefs().getBoolean("disable_topics_to_follow", false)) {
                    Log.d$default("Handle TopicsModule " + element$iv$iv + " " + entry, (Throwable) null, 2, (Object) null);
                    entryRemoveIndex.add(Integer.valueOf(element$iv$iv));
                }
            }
        }
        for (Number number : CollectionsKt.reversed(entryRemoveIndex)) {
            int i = number.intValue();
            $this$entriesRemoveTopicsToFollow.remove(i);
        }
    }

    private final void entryRemoveSensitiveMediaWarning(JSONObject $this$entryRemoveSensitiveMediaWarning) {
        JSONArray $this$forEach$iv;
        JSONArray $this$forEach$iv2;
        String str;
        JSONArray $this$forEach$iv3;
        String str2 = "null cannot be cast to non-null type org.json.JSONObject";
        int i = 0;
        if (entryIsTweet($this$entryRemoveSensitiveMediaWarning)) {
            JSONObject it = entryGetLegacy($this$entryRemoveSensitiveMediaWarning);
            if (it != null) {
                JSONArray $this$forEach$iv4 = INSTANCE.legacyGetExtendedEntitiesMedias(it);
                if ($this$forEach$iv4 != null) {
                    Iterator<Integer> it2 = RangesKt.until(0, $this$forEach$iv4.length()).iterator();
                    while (it2.hasNext()) {
                        int element$iv$iv = ((IntIterator) it2).nextInt();
                        if ($this$forEach$iv4.get(element$iv$iv) instanceof JSONObject) {
                            Object obj = $this$forEach$iv4.get(element$iv$iv);
                            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type org.json.JSONObject");
                            JSONObject media = (JSONObject) obj;
                            INSTANCE.mediaCheckAndRemove(media);
                        }
                    }
                }
                JSONObject legacyGetRetweetedStatusLegacy = INSTANCE.legacyGetRetweetedStatusLegacy(it);
                if (legacyGetRetweetedStatusLegacy == null || ($this$forEach$iv3 = INSTANCE.legacyGetExtendedEntitiesMedias(legacyGetRetweetedStatusLegacy)) == null) {
                    return;
                }
                Iterator<Integer> it3 = RangesKt.until(0, $this$forEach$iv3.length()).iterator();
                while (it3.hasNext()) {
                    int element$iv$iv2 = ((IntIterator) it3).nextInt();
                    if ($this$forEach$iv3.get(element$iv$iv2) instanceof JSONObject) {
                        Object obj2 = $this$forEach$iv3.get(element$iv$iv2);
                        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type org.json.JSONObject");
                        JSONObject media2 = (JSONObject) obj2;
                        INSTANCE.mediaCheckAndRemove(media2);
                    }
                }
            }
        } else if (!entryIsConversationThread($this$entryRemoveSensitiveMediaWarning) || ($this$forEach$iv = entryGetContentItems($this$entryRemoveSensitiveMediaWarning)) == null) {
        } else {
            Iterator<Integer> it4 = RangesKt.until(0, $this$forEach$iv.length()).iterator();
            while (it4.hasNext()) {
                int element$iv$iv3 = ((IntIterator) it4).nextInt();
                if (!($this$forEach$iv.get(element$iv$iv3) instanceof JSONObject)) {
                    $this$forEach$iv2 = $this$forEach$iv;
                } else {
                    Object obj3 = $this$forEach$iv.get(element$iv$iv3);
                    Intrinsics.checkNotNull(obj3, str2);
                    JSONObject item = (JSONObject) obj3;
                    JSONObject legacy = INSTANCE.entryGetLegacy(item);
                    if (legacy == null) {
                        $this$forEach$iv2 = $this$forEach$iv;
                    } else {
                        JSONArray $this$forEach$iv5 = INSTANCE.legacyGetExtendedEntitiesMedias(legacy);
                        if ($this$forEach$iv5 == null) {
                            $this$forEach$iv2 = $this$forEach$iv;
                        } else {
                            $this$forEach$iv2 = $this$forEach$iv;
                            Iterable $this$forEach$iv$iv = RangesKt.until(i, $this$forEach$iv5.length());
                            Iterator<Integer> it5 = $this$forEach$iv$iv.iterator();
                            while (it5.hasNext()) {
                                int element$iv$iv4 = ((IntIterator) it5).nextInt();
                                Iterable $this$forEach$iv$iv2 = $this$forEach$iv$iv;
                                if (!($this$forEach$iv5.get(element$iv$iv4) instanceof JSONObject)) {
                                    str = str2;
                                } else {
                                    Object obj4 = $this$forEach$iv5.get(element$iv$iv4);
                                    Intrinsics.checkNotNull(obj4, str2);
                                    JSONObject media3 = (JSONObject) obj4;
                                    str = str2;
                                    INSTANCE.mediaCheckAndRemove(media3);
                                }
                                $this$forEach$iv$iv = $this$forEach$iv$iv2;
                                str2 = str;
                            }
                        }
                    }
                }
                $this$forEach$iv = $this$forEach$iv2;
                str2 = str2;
                i = 0;
            }
        }
    }

    private final void entriesRemoveSensitiveMediaWarning(JSONArray $this$entriesRemoveSensitiveMediaWarning) {
        Iterable $this$forEach$iv$iv = RangesKt.until(0, $this$entriesRemoveSensitiveMediaWarning.length());
        Iterator<Integer> it = $this$forEach$iv$iv.iterator();
        while (it.hasNext()) {
            int element$iv$iv = ((IntIterator) it).nextInt();
            if ($this$entriesRemoveSensitiveMediaWarning.get(element$iv$iv) instanceof JSONObject) {
                Object obj = $this$entriesRemoveSensitiveMediaWarning.get(element$iv$iv);
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type org.json.JSONObject");
                JSONObject entry = (JSONObject) obj;
                INSTANCE.entryRemoveSensitiveMediaWarning(entry);
            }
        }
    }

    private final void entriesRemoveTweetDetailRelatedTweets(JSONArray $this$entriesRemoveTweetDetailRelatedTweets) {
        List removeIndex = new ArrayList();
        Iterable $this$forEach$iv$iv = RangesKt.until(0, $this$entriesRemoveTweetDetailRelatedTweets.length());
        Iterator<Integer> it = $this$forEach$iv$iv.iterator();
        while (it.hasNext()) {
            int element$iv$iv = ((IntIterator) it).nextInt();
            if ($this$entriesRemoveTweetDetailRelatedTweets.get(element$iv$iv) instanceof JSONObject) {
                Object obj = $this$entriesRemoveTweetDetailRelatedTweets.get(element$iv$iv);
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type org.json.JSONObject");
                JSONObject entry = (JSONObject) obj;
                if (UtilsKt.getModulePrefs().getBoolean("disable_tweet_detail_related_tweets", false) && INSTANCE.entryIsTweetDetailRelatedTweets(entry)) {
                    Log.d$default("Handle tweet detail related tweets " + element$iv$iv + " " + entry, (Throwable) null, 2, (Object) null);
                    removeIndex.add(Integer.valueOf(element$iv$iv));
                }
            }
        }
        for (Number number : CollectionsKt.reversed(removeIndex)) {
            int i = number.intValue();
            $this$entriesRemoveTweetDetailRelatedTweets.remove(i);
        }
    }

    private final void entriesRemoveVideoCarousel(JSONArray $this$entriesRemoveVideoCarousel) {
        List removeIndex = new ArrayList();
        Iterable $this$forEach$iv$iv = RangesKt.until(0, $this$entriesRemoveVideoCarousel.length());
        Iterator<Integer> it = $this$forEach$iv$iv.iterator();
        while (it.hasNext()) {
            int element$iv$iv = ((IntIterator) it).nextInt();
            if ($this$entriesRemoveVideoCarousel.get(element$iv$iv) instanceof JSONObject) {
                Object obj = $this$entriesRemoveVideoCarousel.get(element$iv$iv);
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type org.json.JSONObject");
                JSONObject entry = (JSONObject) obj;
                if (UtilsKt.getModulePrefs().getBoolean("disable_video_carousel", false) && INSTANCE.entryIsVideoCarousel(entry)) {
                    Log.d$default("Handle explore video carousel " + element$iv$iv + " " + entry, (Throwable) null, 2, (Object) null);
                    removeIndex.add(Integer.valueOf(element$iv$iv));
                }
            }
        }
        for (Number number : CollectionsKt.reversed(removeIndex)) {
            int i = number.intValue();
            $this$entriesRemoveVideoCarousel.remove(i);
        }
    }

    private final void entriesRemoveAnnoyance(JSONArray $this$entriesRemoveAnnoyance) {
        entriesRemoveTimelineAds($this$entriesRemoveAnnoyance);
        entriesRemoveWhoToFollow($this$entriesRemoveAnnoyance);
        entriesRemoveWhoToSubscribe($this$entriesRemoveAnnoyance);
        entriesRemoveTopicsToFollow($this$entriesRemoveAnnoyance);
        entriesRemoveSensitiveMediaWarning($this$entriesRemoveAnnoyance);
        entriesRemoveTweetDetailRelatedTweets($this$entriesRemoveAnnoyance);
        entriesRemoveVideoCarousel($this$entriesRemoveAnnoyance);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleJson(XC_MethodHook.MethodHookParam param) {
        String str;
        boolean z;
        String str2 = "null cannot be cast to non-null type org.json.JSONObject";
        Object obj = param.args[0];
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type java.io.InputStream");
        InputStream inputStream = (InputStream) obj;
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, Charsets.UTF_8));
        try {
            BufferedReader bufferedReader = reader;
            BufferedReader r = bufferedReader;
            String readText = TextStreamsKt.readText(r);
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(bufferedReader, null);
            if (UtilsKt.getModulePrefs().getBoolean(SettingsDialog.PREF_ENABLE_LOG, false)) {
                try {
                    JSONObject it = new JSONObject(readText);
                    z = it.has("session_token");
                } catch (Throwable th) {
                    z = false;
                }
                boolean isRefreshSessionResponse = z;
                if (!isRefreshSessionResponse) {
                    UtilsKt.writeJsonLog(readText);
                }
            }
            try {
                JSONObject json = new JSONObject(readText);
                JSONObject jsonGetTweets = jsonGetTweets(json);
                if (jsonGetTweets != null) {
                    tweetsForEach(jsonGetTweets, new Function1<JSONObject, Unit>() { // from class: icu.nullptr.twifucker.hook.JsonHook$handleJson$3
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(JSONObject jSONObject) {
                            invoke2(jSONObject);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2(JSONObject tweet) {
                            Intrinsics.checkNotNullParameter(tweet, "tweet");
                            JsonHook.INSTANCE.tweetCheckAndRemove(tweet);
                        }
                    });
                }
                JSONArray $this$forEach$iv = jsonGetInstructions(json);
                if ($this$forEach$iv != null) {
                    Iterable $this$forEach$iv$iv = RangesKt.until(0, $this$forEach$iv.length());
                    Iterator<Integer> it2 = $this$forEach$iv$iv.iterator();
                    while (it2.hasNext()) {
                        int element$iv$iv = ((IntIterator) it2).nextInt();
                        if ($this$forEach$iv.get(element$iv$iv) instanceof JSONObject) {
                            Object obj2 = $this$forEach$iv.get(element$iv$iv);
                            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type org.json.JSONObject");
                            JSONObject instruction = (JSONObject) obj2;
                            INSTANCE.instructionCheckAndRemove(instruction);
                        }
                    }
                }
                JSONObject jsonGetData = jsonGetData(json);
                if (jsonGetData != null) {
                    dataCheckAndRemove(jsonGetData);
                }
                jsonCheckAndRemoveRecommendedUsers(json);
                jsonCheckAndRemoveThreads(json);
                String jSONObject = json.toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject, "toString(...)");
                readText = jSONObject;
            } catch (JSONException e) {
            } catch (Throwable e2) {
                Log.e("json hook failed to parse JSONObject", e2);
                Log.d$default(readText, (Throwable) null, 2, (Object) null);
            }
            try {
                JSONArray json2 = new JSONArray(readText);
                Iterable $this$forEach$iv$iv2 = RangesKt.until(0, json2.length());
                Iterator<Integer> it3 = $this$forEach$iv$iv2.iterator();
                while (it3.hasNext()) {
                    int element$iv$iv2 = ((IntIterator) it3).nextInt();
                    if (!(json2.get(element$iv$iv2) instanceof JSONObject)) {
                        str = str2;
                    } else {
                        Object obj3 = json2.get(element$iv$iv2);
                        Intrinsics.checkNotNull(obj3, str2);
                        JSONObject it4 = (JSONObject) obj3;
                        str = str2;
                        INSTANCE.tweetCheckAndRemove(it4);
                    }
                    str2 = str;
                }
                String jSONArray = json2.toString();
                Intrinsics.checkNotNullExpressionValue(jSONArray, "toString(...)");
                readText = jSONArray;
            } catch (JSONException e3) {
            } catch (Throwable e4) {
                Log.e("json hook failed to parse JSONArray", e4);
                Log.d$default(readText, (Throwable) null, 2, (Object) null);
            }
            Object[] objArr = param.args;
            byte[] bytes = readText.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            objArr[0] = new ByteArrayInputStream(bytes);
        } catch (IOException e5) {
            param.args[0] = new InputStream() { // from class: icu.nullptr.twifucker.hook.JsonHook$handleJson$2
                @Override // java.io.InputStream
                public int read() {
                    return -1;
                }
            };
        }
    }
}

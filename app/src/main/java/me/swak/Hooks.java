package me.swak;

import com.twitter.model.json.core.JsonUrlEntity;
import com.twitter.model.json.timeline.urt.JsonTimelineEntry;

/* loaded from: classes8.dex */
public class Hooks {
    public static boolean HIDE_ADS = Pref.isHideAdsEnabled();
    public static boolean HIDE_VFU = Pref.isHideVidCEnabled();
    public static boolean HIDE_WTF = Pref.isHideWTFEnabled();
    public static boolean HIDE_WTS = Pref.isHideWTSEnabled();
    public static boolean HIDE_CTX = Pref.isHideSocialContext();
    public static boolean HIDE_THREADS = Pref.isHideThreadsEnabled();
    public static boolean HIDE_SEN_MEDIA = Pref.isHideSensitiveMediaEnabled();
    public static boolean HIDE_REC_ACC = Pref.isHideRecAccEnabled();
    public static boolean HIDE_DETAIL_POST = Pref.isHideMorePostsEnabled();
    public static boolean NO_TRIM_URL = Pref.isNoShortUrl();

    public static boolean isEntryIdRemove(String str, long j) {
        String[] split = str.split("-");
        String str2 = split[0];
        if (!str2.equals("cursor") && !str2.equals("Guide") && !str2.startsWith("semantic_core")) {
            if ((str2.equals("promoted") || ((str2.equals("conversationthread") && split.length == 3) || str2.equals("superhero"))) && HIDE_ADS) {
                return true;
            }
            if (j < 25 && str2.equals("tweet") && HIDE_VFU) {
                return true;
            }
            if (str2.equals("tweetdetailrelatedtweets") && HIDE_DETAIL_POST) {
                return true;
            }
            if (str2.equals("who")) {
                if (split[2].equals("follow") && HIDE_WTF) {
                    return true;
                }
                if (split[2].equals("subscribe") && HIDE_WTS) {
                    return true;
                }
            }
        }
        return false;
    }

    public static JsonTimelineEntry checkEntry(JsonTimelineEntry jsonTimelineEntry) {
        try {
            String str = jsonTimelineEntry.a;
            if (isEntryIdRemove(str, jsonTimelineEntry.b)) {
                Utils.logger("Removed " + str);
                return null;
            }
            return jsonTimelineEntry;
        } catch (Exception unused) {
            return jsonTimelineEntry;
        }
    }

    public static JsonUrlEntity urlEntity(JsonUrlEntity jsonUrlEntity) {
        try {
            if (NO_TRIM_URL) {
                jsonUrlEntity.e = jsonUrlEntity.c;
            }
        } catch (Exception unused) {
        }
        return jsonUrlEntity;
    }
}

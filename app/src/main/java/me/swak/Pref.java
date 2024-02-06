package me.swak;

/* loaded from: classes8.dex */
public class Pref {
    public static boolean isBMFolderEnabled() {
        return Utils.getPref("mod_bmf_enabled", false);
    }

    public static boolean isBirdIconEnabled() {
        return Utils.getPref("mod_bird_icon", false);
    }

    public static boolean isCFontEnabled() {
        return Utils.getPref("mod_chirp_font", false);
    }

    public static boolean isDownloadEnabled() {
        return Utils.getPref("mod_download_vid", false);
    }

    public static boolean isGifEnabled() {
        return Utils.getPref("mod_download_gif", false);
    }

    public static boolean isHideAdsEnabled() {
        return Utils.getPref("mod_hide_ads", false);
    }

    public static boolean isHideBannerEnabled() {
        return !Utils.getPref("mod_hide_banner", false);
    }

    public static boolean isHideCommShareEnabled() {
        return Utils.getPref("mod_community_share", false);
    }

    public static boolean isHideFABBtnEnabled() {
        return Utils.getPref("mod_hide_fab_btn", false);
    }

    public static boolean isHideFABEnabled() {
        return Utils.getPref("mod_hide_fab", false);
    }

    public static boolean isHideForYouEnabled() {
        return Utils.getPref("mod_hide_for_you", false);
    }

    public static boolean isHideMorePostsEnabled() {
        return Utils.getPref("mod_hide_more_posts", false);
    }

    public static boolean isHidePromotedTrendsEnabled() {
        return Utils.getPref("mod_hide_promoted_trends", false);
    }

    public static boolean isHideRecAccEnabled() {
        return Utils.getPref("mod_hide_rec_acc", false);
    }

    public static boolean isHideSeenEnabled() {
        return Utils.getPref("mod_hide_seen", false);
    }

    public static boolean isHideSensitiveMediaEnabled() {
        return Utils.getPref("mod_hide_sensitive_media", false);
    }

    public static boolean isHideSocialContext() {
        return Utils.getPref("mod_hide_social_context", false);
    }

    public static boolean isHideThreadsEnabled() {
        return Utils.getPref("mod_hide_threads", false);
    }

    public static boolean isHideTypingEnabled() {
        return Utils.getPref("mod_hide_typing", false);
    }

    public static boolean isHideVidCEnabled() {
        return Utils.getPref("mod_vid_c", false);
    }

    public static boolean isHideViewCountEnabled() {
        return !Utils.getPref("mod_hide_view", false);
    }

    public static boolean isHideWTFEnabled() {
        return Utils.getPref("mod_who_to_follow", false);
    }

    public static boolean isHideWTSEnabled() {
        return Utils.getPref("mod_who_to_sub", false);
    }

    public static boolean isImmersivePlayer() {
        return Utils.getPref("mod_immersive_player", false);
    }

    public static boolean isMockPremiumEnabled() {
        return Utils.getPref("mod_all_premium", false);
    }

    public static boolean isMonetEnabled() {
        return Utils.getPref("mod_monet_theme", false);
    }

    public static boolean isPostsUndoEnabled() {
        return Utils.getPref("mod_undo_posts", false);
    }

    public static boolean isPreventRoundOff() {
        return Utils.getPref("mod_no_round_off", false);
    }

    public static boolean isPureLinkEnabled() {
        return Utils.getPref("mod_purify_link", false);
    }

    public static boolean isPureLinkTSEnabled() {
        return Utils.getPref("mod_purify_ts_link", false);
    }

    public static boolean isRevenueCountEnabled() {
        return Utils.getPref("mod_revenue_count", false);
    }

    public static boolean isHideAffBadgeEnabled() {
        return !Utils.getPref("mod_hide_aff_badge", false);
    }

    public static boolean isSelectableEnabled() {
        return Utils.getPref("mod_is_selectable", false);
    }

    public static int modSeekValue() {
        return Integer.valueOf(Utils.getPref("mod_seek_value", "5000")).intValue();
    }

    public static String urlHostName() {
        return Utils.getPref("mod_url_host", "x.com");
    }

    public static boolean isNoShortUrl() {
        return Utils.getPref("mod_no_short_url", false);
    }

    public static int getFollowersCount() {
        return Integer.parseInt(Utils.getPref("mod_my_followers_count", "-1"));
    }

    public static int getFollowingCount() {
        return Integer.parseInt(Utils.getPref("mod_my_following_count", "-1"));
    }

    public static String getFakeFollowNames() {
        return Utils.getPref("mod_my_fname", "x.com");
    }

    public static String getUsername() {
        return Utils.getPref("mod_my_name", "x.com");
    }

    public static boolean isFakeBlue() {
        return Utils.getPref("mod_is_blue", false);
    }

    public static boolean isHookUser() {
        return Utils.getPref("mod_is_hook_user", false);
    }
}

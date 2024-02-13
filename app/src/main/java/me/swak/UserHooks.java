package me.swak;

import com.twitter.api.model.json.core.RestJsonTwitterUser;

/* loaded from: classes8.dex */
@Deprecated
public class UserHooks {
    static boolean FAKE_BLUE = Pref.isFakeBlue();
    static String MYNAME = Pref.getUsername();
    static String USERNAMES = Pref.getFakeFollowNames();
    static int FOLLOWING_COUNT = Pref.getFollowingCount();
    static int FOLLOWERS_COUNT = Pref.getFollowersCount();

    public static RestJsonTwitterUser hookUser(RestJsonTwitterUser restJsonTwitterUser) {
        try {
            String str = restJsonTwitterUser.c;
            if (str.equals(MYNAME)) {
                if (FAKE_BLUE) {
                    restJsonTwitterUser.z = true;
                }
                int i = FOLLOWERS_COUNT;
                if (i > 0) {
                    restJsonTwitterUser.n = i;
                }
                int i2 = FOLLOWING_COUNT;
                if (i2 > 0) {
                    restJsonTwitterUser.p = i2;
                }
            } else if (USERNAMES.contains(str)) {
                restJsonTwitterUser.x = true;
            }
        } catch (Exception unused) {
        }
        return restJsonTwitterUser;
    }
}

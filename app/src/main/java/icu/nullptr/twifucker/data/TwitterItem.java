package icu.nullptr.twifucker.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: TwitterItem.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0015"}, d2 = {"Licu/nullptr/twifucker/data/TwitterItem;", "", "key", "", "showing", "", "(Ljava/lang/String;Z)V", "getKey", "()Ljava/lang/String;", "getShowing", "()Z", "setShowing", "(Z)V", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TwitterItem {
    private final String key;
    private boolean showing;

    public static /* synthetic */ TwitterItem copy$default(TwitterItem twitterItem, String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = twitterItem.key;
        }
        if ((i & 2) != 0) {
            z = twitterItem.showing;
        }
        return twitterItem.copy(str, z);
    }

    public final String component1() {
        return this.key;
    }

    public final boolean component2() {
        return this.showing;
    }

    public final TwitterItem copy(String key, boolean z) {
        Intrinsics.checkNotNullParameter(key, "key");
        return new TwitterItem(key, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TwitterItem) {
            TwitterItem twitterItem = (TwitterItem) obj;
            return Intrinsics.areEqual(this.key, twitterItem.key) && this.showing == twitterItem.showing;
        }
        return false;
    }

    public int hashCode() {
        return (this.key.hashCode() * 31) + Boolean.hashCode(this.showing);
    }

    public String toString() {
        String str = this.key;
        return "TwitterItem(key=" + str + ", showing=" + this.showing + ")";
    }

    public TwitterItem(String key, boolean showing) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.key = key;
        this.showing = showing;
    }

    public final String getKey() {
        return this.key;
    }

    public final boolean getShowing() {
        return this.showing;
    }

    public final void setShowing(boolean z) {
        this.showing = z;
    }
}

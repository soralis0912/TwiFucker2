package icu.nullptr.twifucker.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: CustomLayout.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u000b\b&\u0018\u00002\u00020\u0001:\u0001%B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\f\u0010\u001a\u001a\u00020\u001b*\u00020\u000bH\u0004J\u0014\u0010\u001c\u001a\u00020\u0006*\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u0001H\u0004J\u0014\u0010\u001e\u001a\u00020\u0006*\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u0001H\u0004J&\u0010\u001f\u001a\u00020\u001b*\u00020\u000b2\u0006\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00062\b\b\u0002\u0010\"\u001a\u00020\nH\u0004J\f\u0010#\u001a\u00020\u0006*\u00020\u0006H\u0004J\f\u0010$\u001a\u00020\u0006*\u00020\u0006H\u0004R\u0018\u0010\u0005\u001a\u00020\u0006*\u00020\u00068DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\u00020\n*\u00020\u000b8Æ\u0002¢\u0006\u0006\u001a\u0004\b\t\u0010\fR\u0016\u0010\r\u001a\u00020\u0006*\u00020\u000b8Æ\u0002¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u00020\u0006*\u00020\u000b8Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\u0006*\u00020\u000b8Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u0006*\u00020\u000b8Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u000fR\u0018\u0010\u0016\u001a\u00020\u0006*\u00020\u000b8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u000fR\u0018\u0010\u0018\u001a\u00020\u0006*\u00020\u000b8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u000f¨\u0006&"}, d2 = {"Licu/nullptr/twifucker/ui/CustomLayout;", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "dp", "", "getDp", "(I)I", "isRTL", "", "Landroid/view/View;", "(Landroid/view/View;)Z", "marginBottom", "getMarginBottom", "(Landroid/view/View;)I", "marginEnd", "getMarginEnd", "marginStart", "getMarginStart", "marginTop", "getMarginTop", "measuredHeightWithMargins", "getMeasuredHeightWithMargins", "measuredWidthWithMargins", "getMeasuredWidthWithMargins", "autoMeasure", "", "defaultHeightMeasureSpec", "parentView", "defaultWidthMeasureSpec", "layout", "x", "y", "fromRight", "toAtMostMeasureSpec", "toExactlyMeasureSpec", "LayoutParams", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class CustomLayout extends ViewGroup {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomLayout(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void autoMeasure(View $this$autoMeasure) {
        Intrinsics.checkNotNullParameter($this$autoMeasure, "<this>");
        $this$autoMeasure.measure(defaultWidthMeasureSpec($this$autoMeasure, this), defaultHeightMeasureSpec($this$autoMeasure, this));
    }

    public static /* synthetic */ void layout$default(CustomLayout customLayout, View view, int i, int i2, boolean z, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: layout");
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        customLayout.layout(view, i, i2, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void layout(View $this$layout, int x, int y, boolean fromRight) {
        Intrinsics.checkNotNullParameter($this$layout, "<this>");
        if (!fromRight) {
            $this$layout.layout(x, y, $this$layout.getMeasuredWidth() + x, $this$layout.getMeasuredHeight() + y);
        } else {
            layout$default(this, $this$layout, (getMeasuredWidth() - x) - $this$layout.getMeasuredWidth(), y, false, 4, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int getMeasuredWidthWithMargins(View $this$measuredWidthWithMargins) {
        Intrinsics.checkNotNullParameter($this$measuredWidthWithMargins, "<this>");
        int measuredWidth = $this$measuredWidthWithMargins.getMeasuredWidth();
        ViewGroup.LayoutParams layoutParams = $this$measuredWidthWithMargins.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        int i = measuredWidth + (marginLayoutParams != null ? marginLayoutParams.leftMargin : 0);
        ViewGroup.LayoutParams layoutParams2 = $this$measuredWidthWithMargins.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams2 = layoutParams2 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams2 : null;
        return i + (marginLayoutParams2 != null ? marginLayoutParams2.rightMargin : 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int getMeasuredHeightWithMargins(View $this$measuredHeightWithMargins) {
        Intrinsics.checkNotNullParameter($this$measuredHeightWithMargins, "<this>");
        int measuredHeight = $this$measuredHeightWithMargins.getMeasuredHeight();
        ViewGroup.LayoutParams layoutParams = $this$measuredHeightWithMargins.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        int i = measuredHeight + (marginLayoutParams != null ? marginLayoutParams.topMargin : 0);
        ViewGroup.LayoutParams layoutParams2 = $this$measuredHeightWithMargins.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams2 = layoutParams2 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams2 : null;
        return i + (marginLayoutParams2 != null ? marginLayoutParams2.bottomMargin : 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int defaultWidthMeasureSpec(View $this$defaultWidthMeasureSpec, ViewGroup parentView) {
        Intrinsics.checkNotNullParameter($this$defaultWidthMeasureSpec, "<this>");
        Intrinsics.checkNotNullParameter(parentView, "parentView");
        switch ($this$defaultWidthMeasureSpec.getLayoutParams().width) {
            case -2:
                return toAtMostMeasureSpec(-2);
            case -1:
                return toExactlyMeasureSpec(parentView.getMeasuredWidth());
            case 0:
                throw new IllegalArgumentException("Need special treatment for " + $this$defaultWidthMeasureSpec);
            default:
                return toExactlyMeasureSpec($this$defaultWidthMeasureSpec.getLayoutParams().width);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int defaultHeightMeasureSpec(View $this$defaultHeightMeasureSpec, ViewGroup parentView) {
        Intrinsics.checkNotNullParameter($this$defaultHeightMeasureSpec, "<this>");
        Intrinsics.checkNotNullParameter(parentView, "parentView");
        switch ($this$defaultHeightMeasureSpec.getLayoutParams().height) {
            case -2:
                return toAtMostMeasureSpec(-2);
            case -1:
                return toExactlyMeasureSpec(parentView.getMeasuredHeight());
            case 0:
                throw new IllegalArgumentException("Need special treatment for " + $this$defaultHeightMeasureSpec);
            default:
                return toExactlyMeasureSpec($this$defaultHeightMeasureSpec.getLayoutParams().height);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int toExactlyMeasureSpec(int $this$toExactlyMeasureSpec) {
        return View.MeasureSpec.makeMeasureSpec($this$toExactlyMeasureSpec, 1073741824);
    }

    protected final int toAtMostMeasureSpec(int $this$toAtMostMeasureSpec) {
        return View.MeasureSpec.makeMeasureSpec($this$toAtMostMeasureSpec, Integer.MIN_VALUE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int getDp(int $this$dp) {
        return (int) ($this$dp * getResources().getDisplayMetrics().density * 0.5f);
    }

    /* compiled from: CustomLayout.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Licu/nullptr/twifucker/ui/CustomLayout$LayoutParams;", "Landroid/view/ViewGroup$MarginLayoutParams;", "width", "", "height", "(II)V", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes.dex */
    protected static final class LayoutParams extends ViewGroup.MarginLayoutParams {
        public LayoutParams(int width, int height) {
            super(width, height);
        }
    }

    public final int getMarginStart(View $this$marginStart) {
        Intrinsics.checkNotNullParameter($this$marginStart, "<this>");
        ViewGroup.LayoutParams layoutParams = $this$marginStart.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams != null) {
            return marginLayoutParams.leftMargin;
        }
        return 0;
    }

    public final int getMarginTop(View $this$marginTop) {
        Intrinsics.checkNotNullParameter($this$marginTop, "<this>");
        ViewGroup.LayoutParams layoutParams = $this$marginTop.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams != null) {
            return marginLayoutParams.topMargin;
        }
        return 0;
    }

    public final int getMarginEnd(View $this$marginEnd) {
        Intrinsics.checkNotNullParameter($this$marginEnd, "<this>");
        ViewGroup.LayoutParams layoutParams = $this$marginEnd.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams != null) {
            return marginLayoutParams.rightMargin;
        }
        return 0;
    }

    public final int getMarginBottom(View $this$marginBottom) {
        Intrinsics.checkNotNullParameter($this$marginBottom, "<this>");
        ViewGroup.LayoutParams layoutParams = $this$marginBottom.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams != null) {
            return marginLayoutParams.bottomMargin;
        }
        return 0;
    }

    public final boolean isRTL(View $this$isRTL) {
        Intrinsics.checkNotNullParameter($this$isRTL, "<this>");
        return $this$isRTL.getContext().getResources().getConfiguration().getLayoutDirection() == 1;
    }
}

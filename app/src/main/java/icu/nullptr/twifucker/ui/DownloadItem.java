package icu.nullptr.twifucker.ui;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import icu.nullptr.twifucker.ui.CustomLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.soralis_0912.twifucker2.R;
/* compiled from: DownloadItem.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J0\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0011H\u0014J\u0018\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0011H\u0014J\u0014\u0010\u0018\u001a\u00020\r2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\r0\u001aJ\u0014\u0010\u001b\u001a\u00020\r2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\r0\u001aJ\u000e\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Licu/nullptr/twifucker/ui/DownloadItem;", "Licu/nullptr/twifucker/ui/CustomLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "btnCopy", "Landroid/widget/ImageButton;", "btnDownload", "itemText", "Landroid/widget/TextView;", "selectableItemBackground", "Landroid/util/TypedValue;", "onLayout", "", "changed", "", "l", "", "t", "r", "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setOnCopy", "onCopy", "Lkotlin/Function0;", "setOnDownload", "onDownload", "setTitle", "title", "", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DownloadItem extends CustomLayout {
    private final ImageButton btnCopy;
    private final ImageButton btnDownload;
    private final TextView itemText;
    private final TypedValue selectableItemBackground;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadItem(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        TypedValue it = new TypedValue();
        context.getTheme().resolveAttribute(16843534, it, true);
        this.selectableItemBackground = it;
        TextView $this$itemText_u24lambda_u242 = new TextView(context);
        $this$itemText_u24lambda_u242.setTextAppearance(16974257);
        CustomLayout.LayoutParams it2 = new CustomLayout.LayoutParams(-2, -2);
        it2.setMarginStart(getDp(24));
        $this$itemText_u24lambda_u242.setPadding(getDp(18), 0, getDp(18), 0);
        $this$itemText_u24lambda_u242.setLayoutParams(it2);
        addView($this$itemText_u24lambda_u242);
        this.itemText = $this$itemText_u24lambda_u242;
        ImageButton $this$btnCopy_u24lambda_u244 = new ImageButton(context);
        $this$btnCopy_u24lambda_u244.setImageResource(R.drawable.baseline_copy_24);
        $this$btnCopy_u24lambda_u244.setBackgroundColor(0);
        $this$btnCopy_u24lambda_u244.setForeground(context.getDrawable(this.selectableItemBackground.resourceId));
        CustomLayout.LayoutParams it3 = new CustomLayout.LayoutParams(getDp(96), getDp(96));
        it3.setMarginStart(getDp(8));
        $this$btnCopy_u24lambda_u244.setLayoutParams(it3);
        addView($this$btnCopy_u24lambda_u244);
        this.btnCopy = $this$btnCopy_u24lambda_u244;
        ImageButton $this$btnDownload_u24lambda_u246 = new ImageButton(context);
        $this$btnDownload_u24lambda_u246.setImageResource(R.drawable.baseline_download_24);
        $this$btnDownload_u24lambda_u246.setBackgroundColor(0);
        $this$btnDownload_u24lambda_u246.setForeground(context.getDrawable(this.selectableItemBackground.resourceId));
        CustomLayout.LayoutParams it4 = new CustomLayout.LayoutParams(getDp(96), getDp(96));
        it4.setMarginStart(getDp(8));
        it4.setMarginEnd(getDp(24));
        $this$btnDownload_u24lambda_u246.setLayoutParams(it4);
        addView($this$btnDownload_u24lambda_u246);
        this.btnDownload = $this$btnDownload_u24lambda_u246;
    }

    public final void setTitle(String title) {
        Intrinsics.checkNotNullParameter(title, "title");
        this.itemText.setText(title);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setOnCopy$lambda$7(Function0 onCopy, View it) {
        Intrinsics.checkNotNullParameter(onCopy, "$onCopy");
        onCopy.invoke();
    }

    public final void setOnCopy(final Function0<Unit> onCopy) {
        Intrinsics.checkNotNullParameter(onCopy, "onCopy");
        this.btnCopy.setOnClickListener(new View.OnClickListener() { // from class: icu.nullptr.twifucker.ui.DownloadItem$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DownloadItem.setOnCopy$lambda$7(Function0.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setOnDownload$lambda$8(Function0 onDownload, View it) {
        Intrinsics.checkNotNullParameter(onDownload, "$onDownload");
        onDownload.invoke();
    }

    public final void setOnDownload(final Function0<Unit> onDownload) {
        Intrinsics.checkNotNullParameter(onDownload, "onDownload");
        this.btnDownload.setOnClickListener(new View.OnClickListener() { // from class: icu.nullptr.twifucker.ui.DownloadItem$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DownloadItem.setOnDownload$lambda$8(Function0.this, view);
            }
        });
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        autoMeasure(this.btnCopy);
        autoMeasure(this.btnDownload);
        int measuredWidth = getMeasuredWidth();
        View $this$marginStart$iv = this.itemText;
        ViewGroup.LayoutParams layoutParams = $this$marginStart$iv.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        int paddingLeft = ((measuredWidth - (marginLayoutParams != null ? marginLayoutParams.leftMargin : 0)) - this.itemText.getPaddingLeft()) - this.itemText.getPaddingRight();
        View $this$marginEnd$iv = this.itemText;
        ViewGroup.LayoutParams layoutParams2 = $this$marginEnd$iv.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams2 = layoutParams2 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams2 : null;
        int itemTextWidth = ((paddingLeft - (marginLayoutParams2 != null ? marginLayoutParams2.rightMargin : 0)) - getMeasuredWidthWithMargins(this.btnCopy)) - getMeasuredWidthWithMargins(this.btnDownload);
        this.itemText.measure(toExactlyMeasureSpec(itemTextWidth), defaultHeightMeasureSpec(this.itemText, this));
        int maxWidth = RangesKt.coerceAtLeast(getMeasuredWidthWithMargins(this.btnCopy) + itemTextWidth + getMeasuredWidthWithMargins(this.btnDownload), getMeasuredWidth());
        int maxHeight = RangesKt.coerceAtLeast(getMeasuredHeightWithMargins(this.itemText), getMeasuredHeightWithMargins(this.btnCopy));
        setMeasuredDimension(maxWidth, maxHeight);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        DownloadItem $this$isRTL$iv = this;
        CustomLayout this_$iv = $this$isRTL$iv.getContext().getResources().getConfiguration().getLayoutDirection() == 1 ? 1 : null;
        if (this_$iv == null) {
            TextView it = this.itemText;
            DownloadItem downloadItem = this;
            TextView textView = it;
            TextView $this$marginStart$iv = it;
            ViewGroup.LayoutParams layoutParams = $this$marginStart$iv.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams2 = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
            CustomLayout.layout$default(downloadItem, textView, marginLayoutParams2 != null ? marginLayoutParams2.leftMargin : 0, (getMeasuredHeight() / 2) - (it.getMeasuredHeight() / 2), false, 4, null);
            View it2 = this.btnCopy;
            DownloadItem downloadItem2 = this;
            View view = it2;
            int right = this.itemText.getRight();
            View $this$marginStart$iv2 = it2;
            ViewGroup.LayoutParams layoutParams2 = $this$marginStart$iv2.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams3 = layoutParams2 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams2 : null;
            CustomLayout.layout$default(downloadItem2, view, right + (marginLayoutParams3 != null ? marginLayoutParams3.leftMargin : 0), 0, false, 4, null);
            View it3 = this.btnDownload;
            DownloadItem downloadItem3 = this;
            View view2 = it3;
            int right2 = this.btnCopy.getRight();
            View $this$marginStart$iv3 = it3;
            ViewGroup.LayoutParams layoutParams3 = $this$marginStart$iv3.getLayoutParams();
            marginLayoutParams = layoutParams3 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams3 : null;
            CustomLayout.layout$default(downloadItem3, view2, right2 + (marginLayoutParams != null ? marginLayoutParams.leftMargin : 0), 0, false, 4, null);
            return;
        }
        TextView it4 = this.itemText;
        TextView textView2 = it4;
        TextView $this$marginEnd$iv = it4;
        ViewGroup.LayoutParams layoutParams4 = $this$marginEnd$iv.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams4 = layoutParams4 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams4 : null;
        layout((View) textView2, marginLayoutParams4 != null ? marginLayoutParams4.rightMargin : 0, (getMeasuredHeight() / 2) - (it4.getMeasuredHeight() / 2), true);
        View it5 = this.btnDownload;
        DownloadItem downloadItem4 = this;
        View view3 = it5;
        View $this$marginStart$iv4 = it5;
        ViewGroup.LayoutParams layoutParams5 = $this$marginStart$iv4.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams5 = layoutParams5 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams5 : null;
        CustomLayout.layout$default(downloadItem4, view3, marginLayoutParams5 != null ? marginLayoutParams5.leftMargin : 0, 0, false, 4, null);
        View it6 = this.btnCopy;
        DownloadItem downloadItem5 = this;
        View view4 = it6;
        View $this$marginStart$iv5 = it6;
        ViewGroup.LayoutParams layoutParams6 = $this$marginStart$iv5.getLayoutParams();
        marginLayoutParams = layoutParams6 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams6 : null;
        CustomLayout.layout$default(downloadItem5, view4, (marginLayoutParams != null ? marginLayoutParams.leftMargin : 0) + this.btnDownload.getRight(), 0, false, 4, null);
    }
}

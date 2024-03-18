package icu.nullptr.twifucker.ui;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import icu.nullptr.twifucker.ui.CustomLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.soralis_0912.twifucker2.R;
/* compiled from: FeatureSwitchView.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J0\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0014H\u0014J\u0018\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u0014H\u0014J\u0012\u0010\u001b\u001a\u00020\u00112\n\u0010\u001c\u001a\u0006\u0012\u0002\b\u00030\u001dJ\u000e\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010!\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020 R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Licu/nullptr/twifucker/ui/FeatureSwitchView;", "Licu/nullptr/twifucker/ui/CustomLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "buttonAdd", "Landroid/widget/Button;", "buttonReset", "isRecyclerViewAdded", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "selectableItemBackground", "Landroid/util/TypedValue;", "titleView", "Landroid/widget/TextView;", "onLayout", "", "changed", "l", "", "t", "r", "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setAdapter", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "setOnAddClickListener", "listener", "Landroid/view/View$OnClickListener;", "setOnResetClickListener", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FeatureSwitchView extends CustomLayout {
    private final Button buttonAdd;
    private final Button buttonReset;
    private boolean isRecyclerViewAdded;
    private final RecyclerView recyclerView;
    private final TypedValue selectableItemBackground;
    private final TextView titleView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeatureSwitchView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        TypedValue it = new TypedValue();
        context.getTheme().resolveAttribute(16843534, it, true);
        this.selectableItemBackground = it;
        TextView $this$titleView_u24lambda_u242 = new TextView(context);
        $this$titleView_u24lambda_u242.setTextAppearance(16974255);
        CustomLayout.LayoutParams $this$titleView_u24lambda_u242_u24lambda_u241 = new CustomLayout.LayoutParams(-2, -2);
        $this$titleView_u24lambda_u242_u24lambda_u241.topMargin = getDp(32);
        $this$titleView_u24lambda_u242_u24lambda_u241.setMarginStart(getDp(32));
        $this$titleView_u24lambda_u242.setLayoutParams($this$titleView_u24lambda_u242_u24lambda_u241);
        $this$titleView_u24lambda_u242.setText(context.getString(R.string.feature_switch));
        addView($this$titleView_u24lambda_u242);
        this.titleView = $this$titleView_u24lambda_u242;
        RecyclerView $this$recyclerView_u24lambda_u244 = new RecyclerView(context);
        $this$recyclerView_u24lambda_u244.setLayoutManager(new LinearLayoutManager(context));
        CustomLayout.LayoutParams $this$recyclerView_u24lambda_u244_u24lambda_u243 = new CustomLayout.LayoutParams(-2, -2);
        $this$recyclerView_u24lambda_u244_u24lambda_u243.setMarginStart(getDp(32));
        $this$recyclerView_u24lambda_u244_u24lambda_u243.setMarginEnd(getDp(32));
        $this$recyclerView_u24lambda_u244.setLayoutParams($this$recyclerView_u24lambda_u244_u24lambda_u243);
        this.recyclerView = $this$recyclerView_u24lambda_u244;
        Button $this$buttonReset_u24lambda_u246 = new Button(context);
        $this$buttonReset_u24lambda_u246.setBackgroundColor(0);
        $this$buttonReset_u24lambda_u246.setForeground(context.getDrawable(this.selectableItemBackground.resourceId));
        CustomLayout.LayoutParams $this$buttonReset_u24lambda_u246_u24lambda_u245 = new CustomLayout.LayoutParams(-2, -2);
        $this$buttonReset_u24lambda_u246_u24lambda_u245.setMarginStart(getDp(32));
        $this$buttonReset_u24lambda_u246.setLayoutParams($this$buttonReset_u24lambda_u246_u24lambda_u245);
        $this$buttonReset_u24lambda_u246.setText(context.getString(R.string.reset));
        addView($this$buttonReset_u24lambda_u246);
        this.buttonReset = $this$buttonReset_u24lambda_u246;
        Button $this$buttonAdd_u24lambda_u248 = new Button(context);
        $this$buttonAdd_u24lambda_u248.setBackgroundColor(0);
        $this$buttonAdd_u24lambda_u248.setForeground(context.getDrawable(this.selectableItemBackground.resourceId));
        CustomLayout.LayoutParams $this$buttonAdd_u24lambda_u248_u24lambda_u247 = new CustomLayout.LayoutParams(-2, -2);
        $this$buttonAdd_u24lambda_u248_u24lambda_u247.setMarginEnd(getDp(32));
        $this$buttonAdd_u24lambda_u248.setLayoutParams($this$buttonAdd_u24lambda_u248_u24lambda_u247);
        $this$buttonAdd_u24lambda_u248.setText(context.getString(R.string.add));
        addView($this$buttonAdd_u24lambda_u248);
        this.buttonAdd = $this$buttonAdd_u24lambda_u248;
    }

    public final void setAdapter(RecyclerView.Adapter<?> adapter) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        this.recyclerView.setAdapter(adapter);
    }

    public final void setOnResetClickListener(View.OnClickListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.buttonReset.setOnClickListener(listener);
    }

    public final void setOnAddClickListener(View.OnClickListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.buttonAdd.setOnClickListener(listener);
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        autoMeasure(this.titleView);
        autoMeasure(this.buttonReset);
        autoMeasure(this.buttonAdd);
        int defaultWidthMeasureSpec = defaultWidthMeasureSpec(this, this);
        int measuredWidth = getMeasuredWidth();
        View $this$marginStart$iv = this.recyclerView;
        ViewGroup.LayoutParams layoutParams = $this$marginStart$iv.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        int i = measuredWidth - (marginLayoutParams != null ? marginLayoutParams.leftMargin : 0);
        View $this$marginEnd$iv = this.recyclerView;
        ViewGroup.LayoutParams layoutParams2 = $this$marginEnd$iv.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams2 = layoutParams2 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams2 : null;
        int maxWidth = RangesKt.coerceAtMost(defaultWidthMeasureSpec, toExactlyMeasureSpec(i - (marginLayoutParams2 != null ? marginLayoutParams2.rightMargin : 0)));
        int recyclerViewMaxHeight = RangesKt.coerceAtMost(defaultHeightMeasureSpec(this, this), toExactlyMeasureSpec((getMeasuredHeight() - getMeasuredHeightWithMargins(this.titleView)) - getMeasuredHeightWithMargins(this.buttonReset)));
        this.recyclerView.measure(maxWidth, recyclerViewMaxHeight);
        int maxHeight = RangesKt.coerceAtMost(getMeasuredHeightWithMargins(this.titleView) + getMeasuredHeightWithMargins(this.recyclerView) + getMeasuredHeightWithMargins(this.buttonReset), getMeasuredHeight());
        setMeasuredDimension(getMeasuredWidth(), maxHeight);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        FeatureSwitchView $this$isRTL$iv = this;
        CustomLayout this_$iv = $this$isRTL$iv.getContext().getResources().getConfiguration().getLayoutDirection() == 1 ? 1 : null;
        if (this_$iv == null) {
            View it = this.titleView;
            FeatureSwitchView featureSwitchView = this;
            View view = it;
            View $this$marginStart$iv = it;
            ViewGroup.LayoutParams layoutParams = $this$marginStart$iv.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams2 = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
            int i = marginLayoutParams2 != null ? marginLayoutParams2.leftMargin : 0;
            View $this$marginTop$iv = it;
            ViewGroup.LayoutParams layoutParams2 = $this$marginTop$iv.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams3 = layoutParams2 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams2 : null;
            CustomLayout.layout$default(featureSwitchView, view, i, marginLayoutParams3 != null ? marginLayoutParams3.topMargin : 0, false, 4, null);
            View it2 = this.recyclerView;
            FeatureSwitchView featureSwitchView2 = this;
            View view2 = it2;
            View $this$marginStart$iv2 = it2;
            ViewGroup.LayoutParams layoutParams3 = $this$marginStart$iv2.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams4 = layoutParams3 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams3 : null;
            CustomLayout.layout$default(featureSwitchView2, view2, marginLayoutParams4 != null ? marginLayoutParams4.leftMargin : 0, this.titleView.getBottom(), false, 4, null);
            if (!this.isRecyclerViewAdded) {
                addView(it2);
                this.isRecyclerViewAdded = true;
            }
            View it3 = this.buttonReset;
            FeatureSwitchView featureSwitchView3 = this;
            View view3 = it3;
            View $this$marginStart$iv3 = it3;
            ViewGroup.LayoutParams layoutParams4 = $this$marginStart$iv3.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams5 = layoutParams4 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams4 : null;
            CustomLayout.layout$default(featureSwitchView3, view3, marginLayoutParams5 != null ? marginLayoutParams5.leftMargin : 0, this.recyclerView.getBottom(), false, 4, null);
            View it4 = this.buttonAdd;
            View view4 = it4;
            View $this$marginEnd$iv = it4;
            ViewGroup.LayoutParams layoutParams5 = $this$marginEnd$iv.getLayoutParams();
            marginLayoutParams = layoutParams5 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams5 : null;
            layout(view4, marginLayoutParams != null ? marginLayoutParams.rightMargin : 0, this.recyclerView.getBottom(), true);
            return;
        }
        View it5 = this.titleView;
        View view5 = it5;
        View $this$marginEnd$iv2 = it5;
        ViewGroup.LayoutParams layoutParams6 = $this$marginEnd$iv2.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams6 = layoutParams6 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams6 : null;
        int i2 = marginLayoutParams6 != null ? marginLayoutParams6.rightMargin : 0;
        View $this$marginTop$iv2 = it5;
        ViewGroup.LayoutParams layoutParams7 = $this$marginTop$iv2.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams7 = layoutParams7 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams7 : null;
        layout(view5, i2, marginLayoutParams7 != null ? marginLayoutParams7.topMargin : 0, true);
        View it6 = this.recyclerView;
        View view6 = it6;
        View $this$marginEnd$iv3 = it6;
        ViewGroup.LayoutParams layoutParams8 = $this$marginEnd$iv3.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams8 = layoutParams8 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams8 : null;
        layout(view6, marginLayoutParams8 != null ? marginLayoutParams8.rightMargin : 0, this.titleView.getBottom(), true);
        if (!this.isRecyclerViewAdded) {
            addView(it6);
            this.isRecyclerViewAdded = true;
        }
        View it7 = this.buttonReset;
        View view7 = it7;
        View $this$marginEnd$iv4 = it7;
        ViewGroup.LayoutParams layoutParams9 = $this$marginEnd$iv4.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams9 = layoutParams9 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams9 : null;
        layout(view7, marginLayoutParams9 != null ? marginLayoutParams9.rightMargin : 0, this.recyclerView.getBottom(), true);
        View it8 = this.buttonAdd;
        View view8 = it8;
        View $this$marginStart$iv4 = it8;
        ViewGroup.LayoutParams layoutParams10 = $this$marginStart$iv4.getLayoutParams();
        marginLayoutParams = layoutParams10 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams10 : null;
        layout(view8, marginLayoutParams != null ? marginLayoutParams.leftMargin : 0, this.recyclerView.getBottom(), false);
    }
}

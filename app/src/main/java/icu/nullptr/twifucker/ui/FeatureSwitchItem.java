package icu.nullptr.twifucker.ui;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import icu.nullptr.twifucker.ui.CustomLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: FeatureSwitchItem.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J0\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0010H\u0014J\u0018\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0010H\u0014R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0017"}, d2 = {"Licu/nullptr/twifucker/ui/FeatureSwitchItem;", "Licu/nullptr/twifucker/ui/CustomLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "keyTextView", "Landroid/widget/TextView;", "getKeyTextView", "()Landroid/widget/TextView;", "valueTextView", "getValueTextView", "onLayout", "", "changed", "", "l", "", "t", "r", "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FeatureSwitchItem extends CustomLayout {
    private final TextView keyTextView;
    private final TextView valueTextView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeatureSwitchItem(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        TextView $this$keyTextView_u24lambda_u240 = new TextView(context);
        $this$keyTextView_u24lambda_u240.setLayoutParams(new CustomLayout.LayoutParams(-1, -2));
        $this$keyTextView_u24lambda_u240.setTextAppearance(16974257);
        addView($this$keyTextView_u24lambda_u240);
        this.keyTextView = $this$keyTextView_u24lambda_u240;
        TextView $this$valueTextView_u24lambda_u241 = new TextView(context);
        $this$valueTextView_u24lambda_u241.setLayoutParams(new CustomLayout.LayoutParams(-1, -2));
        $this$valueTextView_u24lambda_u241.setTextAppearance(16974259);
        addView($this$valueTextView_u24lambda_u241);
        this.valueTextView = $this$valueTextView_u24lambda_u241;
    }

    public final TextView getKeyTextView() {
        return this.keyTextView;
    }

    public final TextView getValueTextView() {
        return this.valueTextView;
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        autoMeasure(this.keyTextView);
        autoMeasure(this.valueTextView);
        setMeasuredDimension(getMeasuredWidth(), getMeasuredHeightWithMargins(this.keyTextView) + getMeasuredHeightWithMargins(this.valueTextView));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        FeatureSwitchItem $this$isRTL$iv = this;
        CustomLayout this_$iv = $this$isRTL$iv.getContext().getResources().getConfiguration().getLayoutDirection() == 1 ? 1 : null;
        if (this_$iv == null) {
            TextView it = this.keyTextView;
            CustomLayout.layout$default(this, it, 0, 0, false, 4, null);
            TextView it2 = this.valueTextView;
            CustomLayout.layout$default(this, it2, 0, this.keyTextView.getBottom(), false, 4, null);
            return;
        }
        TextView it3 = this.keyTextView;
        layout((View) it3, 0, 0, true);
        TextView it4 = this.valueTextView;
        layout((View) it4, 0, this.keyTextView.getBottom(), true);
    }
}

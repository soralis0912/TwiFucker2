package icu.nullptr.twifucker.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Switch;
import icu.nullptr.twifucker.ui.CustomLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.soralis_0912.twifucker2.R;
/* compiled from: KeyValueView.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0016\u001a\u00020\u0017J0\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001bH\u0014J\u0018\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\u001bH\u0014R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013¨\u0006\""}, d2 = {"Licu/nullptr/twifucker/ui/KeyValueView;", "Licu/nullptr/twifucker/ui/CustomLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "editText", "Landroid/widget/EditText;", "getEditText", "()Landroid/widget/EditText;", "inputDecimal", "getInputDecimal", "isBoolean", "", "()Z", "setBoolean", "(Z)V", "switch", "Landroid/widget/Switch;", "getSwitch", "()Landroid/widget/Switch;", "typeSwitch", "getTypeSwitch", "focus", "", "onLayout", "changed", "l", "", "t", "r", "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class KeyValueView extends CustomLayout {
    private final EditText editText;
    private final EditText inputDecimal;
    private boolean isBoolean;

    /* renamed from: switch  reason: not valid java name */
    private final Switch f5switch;
    private final Switch typeSwitch;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KeyValueView(final Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.isBoolean = true;
        final Switch $this$typeSwitch_u24lambda_u242 = new Switch(context);
        $this$typeSwitch_u24lambda_u242.setTextAppearance(16974257);
        CustomLayout.LayoutParams $this$typeSwitch_u24lambda_u242_u24lambda_u240 = new CustomLayout.LayoutParams(-1, -2);
        $this$typeSwitch_u24lambda_u242_u24lambda_u240.setMarginStart(getDp(32));
        $this$typeSwitch_u24lambda_u242_u24lambda_u240.setMarginEnd(getDp(32));
        $this$typeSwitch_u24lambda_u242.setPadding(getDp(8), 0, 0, 0);
        $this$typeSwitch_u24lambda_u242.setLayoutParams($this$typeSwitch_u24lambda_u242_u24lambda_u240);
        $this$typeSwitch_u24lambda_u242.setText(context.getString(R.string.feature_switch_value_boolean));
        $this$typeSwitch_u24lambda_u242.setOnClickListener(new View.OnClickListener() { // from class: icu.nullptr.twifucker.ui.KeyValueView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                KeyValueView.typeSwitch$lambda$2$lambda$1(KeyValueView.this, $this$typeSwitch_u24lambda_u242, context, view);
            }
        });
        addView($this$typeSwitch_u24lambda_u242);
        this.typeSwitch = $this$typeSwitch_u24lambda_u242;
        EditText $this$editText_u24lambda_u244 = new EditText(context);
        $this$editText_u24lambda_u244.setTextAppearance(16974257);
        CustomLayout.LayoutParams $this$editText_u24lambda_u244_u24lambda_u243 = new CustomLayout.LayoutParams(-1, -2);
        $this$editText_u24lambda_u244_u24lambda_u243.setMarginStart(getDp(32));
        $this$editText_u24lambda_u244_u24lambda_u243.setMarginEnd(getDp(32));
        $this$editText_u24lambda_u244.setLayoutParams($this$editText_u24lambda_u244_u24lambda_u243);
        $this$editText_u24lambda_u244.setHint(context.getString(R.string.feature_switch_key_hint));
        addView($this$editText_u24lambda_u244);
        this.editText = $this$editText_u24lambda_u244;
        Switch $this$switch_u24lambda_u246 = new Switch(context);
        $this$switch_u24lambda_u246.setTextAppearance(16974257);
        CustomLayout.LayoutParams $this$switch_u24lambda_u246_u24lambda_u245 = new CustomLayout.LayoutParams(-1, -2);
        $this$switch_u24lambda_u246_u24lambda_u245.height = getDp(64);
        $this$switch_u24lambda_u246_u24lambda_u245.setMarginStart(getDp(32));
        $this$switch_u24lambda_u246_u24lambda_u245.setMarginEnd(getDp(32));
        $this$switch_u24lambda_u246.setPadding(getDp(8), 0, 0, 0);
        $this$switch_u24lambda_u246.setLayoutParams($this$switch_u24lambda_u246_u24lambda_u245);
        $this$switch_u24lambda_u246.setText(context.getString(R.string.feature_switch_bool_label));
        addView($this$switch_u24lambda_u246);
        this.f5switch = $this$switch_u24lambda_u246;
        EditText $this$inputDecimal_u24lambda_u248 = new EditText(context);
        $this$inputDecimal_u24lambda_u248.setTextAppearance(16974257);
        CustomLayout.LayoutParams $this$inputDecimal_u24lambda_u248_u24lambda_u247 = new CustomLayout.LayoutParams(-1, -2);
        $this$inputDecimal_u24lambda_u248_u24lambda_u247.height = getDp(64);
        $this$inputDecimal_u24lambda_u248_u24lambda_u247.setMarginStart(getDp(32));
        $this$inputDecimal_u24lambda_u248_u24lambda_u247.setMarginEnd(getDp(32));
        $this$inputDecimal_u24lambda_u248.setPadding(getDp(8), 0, 0, 0);
        $this$inputDecimal_u24lambda_u248.setLayoutParams($this$inputDecimal_u24lambda_u248_u24lambda_u247);
        $this$inputDecimal_u24lambda_u248.setHint(context.getString(R.string.feature_switch_value_decimal_hint));
        $this$inputDecimal_u24lambda_u248.setInputType(8192);
        $this$inputDecimal_u24lambda_u248.setVisibility(8);
        addView($this$inputDecimal_u24lambda_u248);
        this.inputDecimal = $this$inputDecimal_u24lambda_u248;
    }

    public final boolean isBoolean() {
        return this.isBoolean;
    }

    public final void setBoolean(boolean z) {
        this.isBoolean = z;
    }

    public final Switch getTypeSwitch() {
        return this.typeSwitch;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void typeSwitch$lambda$2$lambda$1(KeyValueView this$0, Switch this_apply, Context context, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(context, "$context");
        this$0.isBoolean = !this$0.isBoolean;
        if (this$0.isBoolean) {
            this_apply.setText(context.getString(R.string.feature_switch_value_boolean));
            this$0.inputDecimal.setVisibility(8);
            this$0.f5switch.setVisibility(0);
            return;
        }
        this_apply.setText(context.getString(R.string.feature_switch_value_decimal));
        this$0.inputDecimal.setVisibility(0);
        this$0.f5switch.setVisibility(8);
    }

    public final EditText getEditText() {
        return this.editText;
    }

    public final Switch getSwitch() {
        return this.f5switch;
    }

    public final EditText getInputDecimal() {
        return this.inputDecimal;
    }

    public final void focus() {
        this.editText.requestFocus();
        Object systemService = getContext().getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).showSoftInput(this.editText, 1);
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int measuredWidth = getMeasuredWidth();
        View $this$marginStart$iv = this.editText;
        ViewGroup.LayoutParams layoutParams = $this$marginStart$iv.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        int i = measuredWidth - (marginLayoutParams != null ? marginLayoutParams.leftMargin : 0);
        View $this$marginEnd$iv = this.editText;
        ViewGroup.LayoutParams layoutParams2 = $this$marginEnd$iv.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams2 = layoutParams2 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams2 : null;
        int maxWidth = i - (marginLayoutParams2 != null ? marginLayoutParams2.rightMargin : 0);
        this.typeSwitch.measure(toExactlyMeasureSpec(maxWidth - this.typeSwitch.getPaddingLeft()), defaultHeightMeasureSpec(this.typeSwitch, this));
        this.editText.measure(toExactlyMeasureSpec(maxWidth), defaultHeightMeasureSpec(this.editText, this));
        this.f5switch.measure(toExactlyMeasureSpec(maxWidth - this.f5switch.getPaddingLeft()), defaultHeightMeasureSpec(this.f5switch, this));
        this.inputDecimal.measure(toExactlyMeasureSpec(maxWidth - this.f5switch.getPaddingLeft()), defaultHeightMeasureSpec(this.inputDecimal, this));
        setMeasuredDimension(RangesKt.coerceAtLeast(maxWidth, getMeasuredWidth()), getMeasuredHeightWithMargins(this.typeSwitch) + getMeasuredHeightWithMargins(this.editText) + getMeasuredHeightWithMargins(this.f5switch));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        KeyValueView $this$isRTL$iv = this;
        CustomLayout this_$iv = $this$isRTL$iv.getContext().getResources().getConfiguration().getLayoutDirection() == 1 ? 1 : null;
        if (this_$iv != null) {
            View it = this.typeSwitch;
            View view = it;
            View $this$marginEnd$iv = it;
            ViewGroup.LayoutParams layoutParams = $this$marginEnd$iv.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams2 = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
            layout(view, marginLayoutParams2 != null ? marginLayoutParams2.rightMargin : 0, 0, true);
            View it2 = this.editText;
            View view2 = it2;
            View $this$marginEnd$iv2 = it2;
            ViewGroup.LayoutParams layoutParams2 = $this$marginEnd$iv2.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams3 = layoutParams2 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams2 : null;
            int i = marginLayoutParams3 != null ? marginLayoutParams3.rightMargin : 0;
            int bottom = this.typeSwitch.getBottom();
            View $this$marginTop$iv = it2;
            ViewGroup.LayoutParams layoutParams3 = $this$marginTop$iv.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams4 = layoutParams3 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams3 : null;
            layout(view2, i, bottom + (marginLayoutParams4 != null ? marginLayoutParams4.topMargin : 0), true);
            View it3 = this.f5switch;
            View view3 = it3;
            View $this$marginEnd$iv3 = it3;
            ViewGroup.LayoutParams layoutParams4 = $this$marginEnd$iv3.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams5 = layoutParams4 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams4 : null;
            int i2 = marginLayoutParams5 != null ? marginLayoutParams5.rightMargin : 0;
            int bottom2 = this.editText.getBottom();
            View $this$marginTop$iv2 = it3;
            ViewGroup.LayoutParams layoutParams5 = $this$marginTop$iv2.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams6 = layoutParams5 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams5 : null;
            layout(view3, i2, bottom2 + (marginLayoutParams6 != null ? marginLayoutParams6.topMargin : 0), true);
            View it4 = this.inputDecimal;
            View view4 = it4;
            View $this$marginEnd$iv4 = it4;
            ViewGroup.LayoutParams layoutParams6 = $this$marginEnd$iv4.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams7 = layoutParams6 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams6 : null;
            int i3 = marginLayoutParams7 != null ? marginLayoutParams7.rightMargin : 0;
            int bottom3 = this.editText.getBottom();
            View $this$marginTop$iv3 = it4;
            ViewGroup.LayoutParams layoutParams7 = $this$marginTop$iv3.getLayoutParams();
            marginLayoutParams = layoutParams7 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams7 : null;
            layout(view4, i3, bottom3 + (marginLayoutParams != null ? marginLayoutParams.topMargin : 0), true);
            return;
        }
        View it5 = this.typeSwitch;
        KeyValueView keyValueView = this;
        View view5 = it5;
        View $this$marginStart$iv = it5;
        ViewGroup.LayoutParams layoutParams8 = $this$marginStart$iv.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams8 = layoutParams8 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams8 : null;
        CustomLayout.layout$default(keyValueView, view5, marginLayoutParams8 != null ? marginLayoutParams8.leftMargin : 0, 0, false, 4, null);
        View it6 = this.editText;
        KeyValueView keyValueView2 = this;
        View view6 = it6;
        View $this$marginStart$iv2 = it6;
        ViewGroup.LayoutParams layoutParams9 = $this$marginStart$iv2.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams9 = layoutParams9 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams9 : null;
        int i4 = marginLayoutParams9 != null ? marginLayoutParams9.leftMargin : 0;
        int bottom4 = this.typeSwitch.getBottom();
        View $this$marginTop$iv4 = it6;
        ViewGroup.LayoutParams layoutParams10 = $this$marginTop$iv4.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams10 = layoutParams10 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams10 : null;
        CustomLayout.layout$default(keyValueView2, view6, i4, bottom4 + (marginLayoutParams10 != null ? marginLayoutParams10.topMargin : 0), false, 4, null);
        View it7 = this.f5switch;
        KeyValueView keyValueView3 = this;
        View view7 = it7;
        View $this$marginStart$iv3 = it7;
        ViewGroup.LayoutParams layoutParams11 = $this$marginStart$iv3.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams11 = layoutParams11 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams11 : null;
        int i5 = marginLayoutParams11 != null ? marginLayoutParams11.leftMargin : 0;
        int bottom5 = this.editText.getBottom();
        View $this$marginTop$iv5 = it7;
        ViewGroup.LayoutParams layoutParams12 = $this$marginTop$iv5.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams12 = layoutParams12 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams12 : null;
        CustomLayout.layout$default(keyValueView3, view7, i5, bottom5 + (marginLayoutParams12 != null ? marginLayoutParams12.topMargin : 0), false, 4, null);
        View it8 = this.inputDecimal;
        KeyValueView keyValueView4 = this;
        View view8 = it8;
        View $this$marginStart$iv4 = it8;
        ViewGroup.LayoutParams layoutParams13 = $this$marginStart$iv4.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams13 = layoutParams13 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams13 : null;
        int i6 = marginLayoutParams13 != null ? marginLayoutParams13.leftMargin : 0;
        int bottom6 = this.editText.getBottom();
        View $this$marginTop$iv6 = it8;
        ViewGroup.LayoutParams layoutParams14 = $this$marginTop$iv6.getLayoutParams();
        marginLayoutParams = layoutParams14 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams14 : null;
        CustomLayout.layout$default(keyValueView4, view8, i6, bottom6 + (marginLayoutParams != null ? marginLayoutParams.topMargin : 0), false, 4, null);
    }
}

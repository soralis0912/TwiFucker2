package icu.nullptr.twifucker.ui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.github.kyuubiran.ezxhelper.EzXHelper;
import icu.nullptr.twifucker.UtilsKt;
import icu.nullptr.twifucker.ui.FeatureSwitchDialog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONArray;
import org.soralis_0912.twifucker2.R;
/* compiled from: FeatureSwitchDialog.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0005B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0006"}, d2 = {"Licu/nullptr/twifucker/ui/FeatureSwitchDialog;", "Landroid/app/Dialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "FeatureSwitchAdapter", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FeatureSwitchDialog extends Dialog {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, org.json.JSONArray] */
    public FeatureSwitchDialog(final Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        EzXHelper.addModuleAssetPath(context);
        String featureSwitch = UtilsKt.getModulePrefs().getString(SettingsDialog.PREF_FEATURE_SWITCH, "[]");
        final Ref.ObjectRef arr = new Ref.ObjectRef();
        arr.element = new JSONArray(featureSwitch);
        final FeatureSwitchAdapter featureSwitchAdapter = new FeatureSwitchAdapter((JSONArray) arr.element, context);
        FeatureSwitchView featureSwitchView = new FeatureSwitchView(context);
        featureSwitchView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        featureSwitchView.setAdapter(featureSwitchAdapter);
        featureSwitchView.setOnResetClickListener(new View.OnClickListener() { // from class: icu.nullptr.twifucker.ui.FeatureSwitchDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeatureSwitchDialog._init_$lambda$3(context, arr, featureSwitchAdapter, view);
            }
        });
        featureSwitchView.setOnAddClickListener(new View.OnClickListener() { // from class: icu.nullptr.twifucker.ui.FeatureSwitchDialog$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeatureSwitchDialog._init_$lambda$4(context, featureSwitchAdapter, view);
            }
        });
        setContentView(featureSwitchView);
        show();
        Window window = getWindow();
        if (window == null) {
            return;
        }
        window.setLayout(-1, -2);
    }

    /* compiled from: FeatureSwitchDialog.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0014B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\tH\u0016J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\tH\u0016J\u000e\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0013\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Licu/nullptr/twifucker/ui/FeatureSwitchDialog$FeatureSwitchAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Licu/nullptr/twifucker/ui/FeatureSwitchDialog$FeatureSwitchAdapter$ViewHolder;", "arr", "Lorg/json/JSONArray;", "context", "Landroid/content/Context;", "(Lorg/json/JSONArray;Landroid/content/Context;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "reloadAddedData", "reset", "ViewHolder", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class FeatureSwitchAdapter extends RecyclerView.Adapter<ViewHolder> {
        private JSONArray arr;
        private final Context context;

        /* compiled from: FeatureSwitchDialog.kt */
        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000b\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Licu/nullptr/twifucker/ui/FeatureSwitchDialog$FeatureSwitchAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Licu/nullptr/twifucker/ui/FeatureSwitchItem;", "(Licu/nullptr/twifucker/ui/FeatureSwitchItem;)V", "featureSwitchItem", "getFeatureSwitchItem", "()Licu/nullptr/twifucker/ui/FeatureSwitchItem;", "keyView", "Landroid/widget/TextView;", "getKeyView", "()Landroid/widget/TextView;", "valueView", "getValueView", "setValueView", "(Landroid/widget/TextView;)V", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
        /* loaded from: classes.dex */
        public static final class ViewHolder extends RecyclerView.ViewHolder {
            private final FeatureSwitchItem featureSwitchItem;
            private final TextView keyView;
            private TextView valueView;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ViewHolder(FeatureSwitchItem itemView) {
                super(itemView);
                Intrinsics.checkNotNullParameter(itemView, "itemView");
                this.featureSwitchItem = itemView;
                this.keyView = itemView.getKeyTextView();
                this.valueView = itemView.getValueTextView();
            }

            public final FeatureSwitchItem getFeatureSwitchItem() {
                return this.featureSwitchItem;
            }

            public final TextView getKeyView() {
                return this.keyView;
            }

            public final TextView getValueView() {
                return this.valueView;
            }

            public final void setValueView(TextView textView) {
                Intrinsics.checkNotNullParameter(textView, "<set-?>");
                this.valueView = textView;
            }
        }

        public FeatureSwitchAdapter(JSONArray arr, Context context) {
            Intrinsics.checkNotNullParameter(arr, "arr");
            Intrinsics.checkNotNullParameter(context, "context");
            this.arr = arr;
            this.context = context;
        }

        public final void reloadAddedData(JSONArray arr) {
            Intrinsics.checkNotNullParameter(arr, "arr");
            this.arr = arr;
            notifyItemInserted(arr.length() - 1);
        }

        public final void reset() {
            int len = this.arr.length();
            this.arr = new JSONArray();
            notifyItemRangeRemoved(0, len);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            Context context = parent.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            FeatureSwitchItem view = new FeatureSwitchItem(context);
            return new ViewHolder(view);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(final ViewHolder holder, final int position) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            final boolean isBoolean = Intrinsics.areEqual(this.arr.getJSONObject(position).optString("type", "boolean"), "boolean");
            String key = this.arr.getJSONObject(position).optString("key");
            holder.getKeyView().setText(key);
            if (isBoolean) {
                boolean bool = this.arr.getJSONObject(position).optBoolean("value");
                holder.getValueView().setText(String.valueOf(bool));
            } else {
                String decimal = this.arr.getJSONObject(position).optString("value");
                holder.getValueView().setText(decimal);
            }
            holder.getFeatureSwitchItem().setOnClickListener(new View.OnClickListener() { // from class: icu.nullptr.twifucker.ui.FeatureSwitchDialog$FeatureSwitchAdapter$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeatureSwitchDialog.FeatureSwitchAdapter.onBindViewHolder$lambda$0(isBoolean, this, position, holder, view);
                }
            });
            holder.getFeatureSwitchItem().setOnLongClickListener(new View.OnLongClickListener() { // from class: icu.nullptr.twifucker.ui.FeatureSwitchDialog$FeatureSwitchAdapter$$ExternalSyntheticLambda1
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    boolean onBindViewHolder$lambda$3;
                    onBindViewHolder$lambda$3 = FeatureSwitchDialog.FeatureSwitchAdapter.onBindViewHolder$lambda$3(FeatureSwitchDialog.FeatureSwitchAdapter.this, position, view);
                    return onBindViewHolder$lambda$3;
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBindViewHolder$lambda$0(boolean $isBoolean, FeatureSwitchAdapter this$0, int $position, ViewHolder holder, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(holder, "$holder");
            if ($isBoolean) {
                boolean bool = !this$0.arr.getJSONObject($position).optBoolean("value");
                holder.getValueView().setText(String.valueOf(bool));
                this$0.arr.getJSONObject($position).put("value", bool);
                UtilsKt.getModulePrefs().putString(SettingsDialog.PREF_FEATURE_SWITCH, this$0.arr.toString());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean onBindViewHolder$lambda$3(final FeatureSwitchAdapter this$0, final int $position, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            EzXHelper.addModuleAssetPath(this$0.context);
            AlertDialog.Builder it = new AlertDialog.Builder(this$0.context);
            it.setMessage(R.string.msg_yes_no);
            it.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() { // from class: icu.nullptr.twifucker.ui.FeatureSwitchDialog$FeatureSwitchAdapter$$ExternalSyntheticLambda2
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    FeatureSwitchDialog.FeatureSwitchAdapter.onBindViewHolder$lambda$3$lambda$2$lambda$1(FeatureSwitchDialog.FeatureSwitchAdapter.this, $position, dialogInterface, i);
                }
            });
            it.setNegativeButton(R.string.no, (DialogInterface.OnClickListener) null);
            it.show();
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBindViewHolder$lambda$3$lambda$2$lambda$1(FeatureSwitchAdapter this$0, int $position, DialogInterface dialogInterface, int i) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.arr.remove($position);
            UtilsKt.getModulePrefs().putString(SettingsDialog.PREF_FEATURE_SWITCH, this$0.arr.toString());
            this$0.notifyItemChanged($position);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.arr.length();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$3(Context context, final Ref.ObjectRef arr, final FeatureSwitchAdapter featureSwitchAdapter, View it) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(arr, "$arr");
        Intrinsics.checkNotNullParameter(featureSwitchAdapter, "$featureSwitchAdapter");
        EzXHelper.addModuleAssetPath(context);
        AlertDialog.Builder it2 = new AlertDialog.Builder(context);
        it2.setMessage(R.string.msg_yes_no);
        it2.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() { // from class: icu.nullptr.twifucker.ui.FeatureSwitchDialog$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                FeatureSwitchDialog.lambda$3$lambda$2$lambda$1(Ref.ObjectRef.this, featureSwitchAdapter, dialogInterface, i);
            }
        });
        it2.setNegativeButton(R.string.no, (DialogInterface.OnClickListener) null);
        it2.show();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Type inference failed for: r3v3, types: [T, org.json.JSONArray] */
    public static final void lambda$3$lambda$2$lambda$1(Ref.ObjectRef arr, FeatureSwitchAdapter featureSwitchAdapter, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(arr, "$arr");
        Intrinsics.checkNotNullParameter(featureSwitchAdapter, "$featureSwitchAdapter");
        arr.element = new JSONArray();
        UtilsKt.getModulePrefs().putString(SettingsDialog.PREF_FEATURE_SWITCH, "[]");
        featureSwitchAdapter.reset();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$4(Context context, final FeatureSwitchAdapter featureSwitchAdapter, View it) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(featureSwitchAdapter, "$featureSwitchAdapter");
        new KeyValueDialog(context, new Function1<JSONArray, Unit>() { // from class: icu.nullptr.twifucker.ui.FeatureSwitchDialog$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(JSONArray jSONArray) {
                invoke2(jSONArray);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(JSONArray it2) {
                Intrinsics.checkNotNullParameter(it2, "it");
                FeatureSwitchDialog.FeatureSwitchAdapter.this.reloadAddedData(it2);
            }
        });
    }
}

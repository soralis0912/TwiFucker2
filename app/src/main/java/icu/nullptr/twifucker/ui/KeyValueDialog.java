package icu.nullptr.twifucker.ui;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.Editable;
import com.github.kyuubiran.ezxhelper.EzXHelper;
import icu.nullptr.twifucker.UtilsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;
import org.soralis_0912.twifucker2.R;
/* compiled from: KeyValueDialog.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Licu/nullptr/twifucker/ui/KeyValueDialog;", "Landroid/app/AlertDialog$Builder;", "context", "Landroid/content/Context;", "onChange", "Lkotlin/Function1;", "Lorg/json/JSONArray;", "", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;)V", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class KeyValueDialog extends AlertDialog.Builder {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KeyValueDialog(Context context, final Function1<? super JSONArray, Unit> onChange) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(onChange, "onChange");
        EzXHelper.addModuleAssetPath(context);
        setTitle(R.string.feature_switch_value_boolean);
        final KeyValueView keyValueView = new KeyValueView(context);
        setView(keyValueView);
        setNeutralButton(R.string.settings_dismiss, (DialogInterface.OnClickListener) null);
        setPositiveButton(R.string.save, new DialogInterface.OnClickListener() { // from class: icu.nullptr.twifucker.ui.KeyValueDialog$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                KeyValueDialog._init_$lambda$0(KeyValueView.this, onChange, dialogInterface, i);
            }
        });
        keyValueView.focus();
        show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(KeyValueView keyValueView, Function1 onChange, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(keyValueView, "$keyValueView");
        Intrinsics.checkNotNullParameter(onChange, "$onChange");
        Editable text = keyValueView.getEditText().getText();
        Intrinsics.checkNotNullExpressionValue(text, "getText(...)");
        if (StringsKt.isBlank(text)) {
            return;
        }
        String featureSwitch = UtilsKt.getModulePrefs().getString(SettingsDialog.PREF_FEATURE_SWITCH, "[]");
        JSONArray arr = new JSONArray(featureSwitch);
        if (keyValueView.isBoolean()) {
            arr.put(new JSONObject().put("key", keyValueView.getEditText().getText()).put("value", keyValueView.getSwitch().isChecked()).put("type", "boolean"));
        } else {
            Editable text2 = keyValueView.getInputDecimal().getText();
            Intrinsics.checkNotNullExpressionValue(text2, "getText(...)");
            if (StringsKt.isBlank(text2)) {
                return;
            }
            arr.put(new JSONObject().put("key", keyValueView.getEditText().getText()).put("value", keyValueView.getInputDecimal().getText()).put("type", "decimal"));
        }
        UtilsKt.getModulePrefs().putString(SettingsDialog.PREF_FEATURE_SWITCH, arr.toString());
        onChange.invoke(arr);
    }
}

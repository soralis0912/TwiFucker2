package icu.nullptr.twifucker.ui;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Environment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.documentfile.provider.DocumentFile;
import com.github.kyuubiran.ezxhelper.AndroidLogger;
import com.github.kyuubiran.ezxhelper.EzXHelper;
import com.github.kyuubiran.ezxhelper.Log;
import icu.nullptr.twifucker.UtilsKt;
import icu.nullptr.twifucker.ui.DownloadDialog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.soralis_0912.twifucker2.R;
/* compiled from: DownloadDialog.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \r2\u00020\u0001:\u0002\r\u000eB1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\u0010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Licu/nullptr/twifucker/ui/DownloadDialog;", "Landroid/app/AlertDialog$Builder;", "context", "Landroid/content/Context;", "tweetId", "", "downloadUrls", "", "", "onDismiss", "Lkotlin/Function0;", "", "(Landroid/content/Context;JLjava/util/List;Lkotlin/jvm/functions/Function0;)V", "Companion", "DownloadMediaAdapter", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DownloadDialog extends AlertDialog.Builder {
    public static final Companion Companion = new Companion(null);
    private final long tweetId;

    /* compiled from: DownloadDialog.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J(\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J:\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00042\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0004H\u0002¨\u0006\u0017"}, d2 = {"Licu/nullptr/twifucker/ui/DownloadDialog$Companion;", "", "()V", "contentTypeToExt", "", "contentType", "copyFile", "fileName", "copyFileUri", "", "context", "Landroid/content/Context;", "outputDirectory", "download", "tweetId", "", "index", "", "url", "onDownloadCompleted", "Lkotlin/Function0;", "toClipboard", "text", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        private final String contentTypeToExt(String contentType) {
            return StringsKt.contains$default((CharSequence) contentType, (CharSequence) "image/jpeg", false, 2, (Object) null) ? ".jpg" : StringsKt.contains$default((CharSequence) contentType, (CharSequence) "image/png", false, 2, (Object) null) ? ".png" : StringsKt.contains$default((CharSequence) contentType, (CharSequence) "video/mp4", false, 2, (Object) null) ? ".mp4" : StringsKt.contains$default((CharSequence) contentType, (CharSequence) "video/webm", false, 2, (Object) null) ? ".webm" : StringsKt.contains$default((CharSequence) contentType, (CharSequence) "application/x-mpegURL", false, 2, (Object) null) ? ".m3u8" : "";
        }

        private final void copyFileUri(Context context, String fileName, String outputDirectory, String contentType) {
            DocumentFile createFile;
            Uri uri2;
            OutputStream openOutputStream;
            DocumentFile fromTreeUri = DocumentFile.fromTreeUri(context, Uri.parse(outputDirectory));
            if (fromTreeUri != null && (createFile = fromTreeUri.createFile(contentType, fileName)) != null && (uri2 = createFile.getUri()) != null && (openOutputStream = context.getContentResolver().openOutputStream(uri2)) != null) {
                OutputStream outputStream = openOutputStream;
                try {
                    OutputStream out = outputStream;
                    FileInputStream inputStream = new FileInputStream(new File(EzXHelper.getAppContext().getCacheDir(), fileName));
                    Intrinsics.checkNotNull(out);
                    Long.valueOf(ByteStreamsKt.copyTo$default(inputStream, out, 0, 2, null));
                    CloseableKt.closeFinally(outputStream, null);
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(outputStream, th);
                        throw th2;
                    }
                }
            }
        }

        private final String copyFile(String fileName) {
            File downloadPath = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "TwiFucker");
            if (!downloadPath.exists()) {
                downloadPath.mkdirs();
            }
            File outputFile = new File(downloadPath, fileName);
            FileInputStream inputStream = new FileInputStream(new File(EzXHelper.getAppContext().getCacheDir(), fileName));
            FileOutputStream outputStream = new FileOutputStream(outputFile);
            ByteStreamsKt.copyTo$default(inputStream, outputStream, 0, 2, null);
            String absolutePath = outputFile.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
            return absolutePath;
        }

        static /* synthetic */ void download$default(Companion companion, Context context, long j, int i, String str, Function0 function0, int i2, Object obj) {
            Function0 function02;
            if ((i2 & 16) == 0) {
                function02 = function0;
            } else {
                function02 = null;
            }
            companion.download(context, j, i, str, function02);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void download(final Context context, final long tweetId, final int index, final String url, final Function0<Unit> function0) {
            final ProgressDialog progressDialog = new ProgressDialog(context);
            progressDialog.setTitle(R.string.downloading);
            progressDialog.setCancelable(false);
            progressDialog.show();
            new Thread(new Runnable() { // from class: icu.nullptr.twifucker.ui.DownloadDialog$Companion$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    DownloadDialog.Companion.download$lambda$2(url, tweetId, index, context, function0, progressDialog);
                }
            }).start();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void download$lambda$2(String url, long $tweetId, int $index, Context context, Function0 $onDownloadCompleted, ProgressDialog progressDialog) {
            Intrinsics.checkNotNullParameter(url, "$url");
            Intrinsics.checkNotNullParameter(context, "$context");
            Intrinsics.checkNotNullParameter(progressDialog, "$progressDialog");
            try {
                URL downloadUrl = new URL(url);
                URLConnection openConnection = downloadUrl.openConnection();
                Intrinsics.checkNotNull(openConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
                HttpURLConnection httpConnection = (HttpURLConnection) openConnection;
                httpConnection.setConnectTimeout(15000);
                httpConnection.setReadTimeout(15000);
                httpConnection.connect();
                InputStream inputStream = httpConnection.getInputStream();
                byte[] buffer = new byte[1024];
                String contentType = httpConnection.getContentType();
                File cacheDir = EzXHelper.getAppContext().getCacheDir();
                Companion companion = DownloadDialog.Companion;
                Intrinsics.checkNotNull(contentType);
                try {
                    File file = new File(cacheDir, $tweetId + "_" + $index + companion.contentTypeToExt(contentType));
                    FileOutputStream outputStream = new FileOutputStream(file);
                    for (int len = inputStream.read(buffer); len != -1; len = inputStream.read(buffer)) {
                        outputStream.write(buffer, 0, len);
                    }
                    outputStream.close();
                    inputStream.close();
                    httpConnection.disconnect();
                    String downloadDirectory = UtilsKt.getModulePrefs().getString(SettingsDialog.PREF_DOWNLOAD_DIRECTORY, null);
                    if (downloadDirectory == null) {
                        downloadDirectory = "";
                    }
                    if (!Intrinsics.areEqual(downloadDirectory, "")) {
                        Companion companion2 = DownloadDialog.Companion;
                        String name = file.getName();
                        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                        companion2.copyFileUri(context, name, downloadDirectory, contentType);
                    } else {
                        Companion companion3 = DownloadDialog.Companion;
                        String name2 = file.getName();
                        Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
                        String outputPath = companion3.copyFile(name2);
                        MediaScannerConnection.scanFile(context, new String[]{outputPath}, null, null);
                    }
                    file.delete();
                    if ($onDownloadCompleted != null) {
                        $onDownloadCompleted.invoke();
                    }
                } catch (Throwable th) {
                    t = th;
                    Log.e$default(t, (String) null, 2, (Object) null);
                    String string = EzXHelper.getAppContext().getString(R.string.download_failed);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    AndroidLogger.toast$default(string, 0, 2, null);
                    progressDialog.cancel();
                }
            } catch (Throwable th2) {
                t = th2;
            }
            progressDialog.cancel();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void toClipboard(String text) {
            Object systemService = EzXHelper.getAppContext().getSystemService("clipboard");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
            ClipboardManager clipboardManager = (ClipboardManager) systemService;
            ClipData clip = ClipData.newPlainText("label", text);
            clipboardManager.setPrimaryClip(clip);
            String string = EzXHelper.getAppContext().getString(R.string.download_link_copied);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            AndroidLogger.toast$default(string, 0, 2, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadDialog(final Context context, long tweetId, final List<String> downloadUrls, final Function0<Unit> onDismiss) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(downloadUrls, "downloadUrls");
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        this.tweetId = tweetId;
        EzXHelper.addModuleAssetPath(context);
        DownloadMediaAdapter adapter = new DownloadMediaAdapter(context, this.tweetId, downloadUrls);
        setAdapter(adapter, null);
        setNeutralButton(R.string.download_all, new DialogInterface.OnClickListener() { // from class: icu.nullptr.twifucker.ui.DownloadDialog$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                DownloadDialog._init_$lambda$1(downloadUrls, context, this, dialogInterface, i);
            }
        });
        setNegativeButton(R.string.settings_dismiss, new DialogInterface.OnClickListener() { // from class: icu.nullptr.twifucker.ui.DownloadDialog$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                DownloadDialog._init_$lambda$2(Function0.this, dialogInterface, i);
            }
        });
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: icu.nullptr.twifucker.ui.DownloadDialog$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                DownloadDialog._init_$lambda$3(Function0.this, dialogInterface);
            }
        });
        setTitle(R.string.download_or_copy);
        show();
    }

    /* compiled from: DownloadDialog.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0011H\u0016J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0011H\u0016J$\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u00112\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Licu/nullptr/twifucker/ui/DownloadDialog$DownloadMediaAdapter;", "Landroid/widget/BaseAdapter;", "context", "Landroid/content/Context;", "tweetId", "", "urls", "", "", "(Landroid/content/Context;JLjava/util/List;)V", "getContext", "()Landroid/content/Context;", "getTweetId", "()J", "getUrls", "()Ljava/util/List;", "getCount", "", "getItem", "", "position", "getItemId", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes.dex */
    private static final class DownloadMediaAdapter extends BaseAdapter {
        private final Context context;
        private final long tweetId;
        private final List<String> urls;

        public final Context getContext() {
            return this.context;
        }

        public final long getTweetId() {
            return this.tweetId;
        }

        public final List<String> getUrls() {
            return this.urls;
        }

        public DownloadMediaAdapter(Context context, long tweetId, List<String> urls) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(urls, "urls");
            this.context = context;
            this.tweetId = tweetId;
            this.urls = urls;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.urls.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int position) {
            return this.urls.get(position);
        }

        @Override // android.widget.Adapter
        public long getItemId(int position) {
            return position;
        }

        @Override // android.widget.Adapter
        public View getView(final int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                final DownloadItem $this$getView_u24lambda_u240 = new DownloadItem(this.context);
                String string = $this$getView_u24lambda_u240.getContext().getString(R.string.download_media, Integer.valueOf(position + 1));
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                $this$getView_u24lambda_u240.setTitle(string);
                $this$getView_u24lambda_u240.setOnCopy(new Function0<Unit>() { // from class: icu.nullptr.twifucker.ui.DownloadDialog$DownloadMediaAdapter$getView$view$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        DownloadDialog.Companion.toClipboard(DownloadDialog.DownloadMediaAdapter.this.getUrls().get(position));
                    }
                });
                $this$getView_u24lambda_u240.setOnDownload(new Function0<Unit>() { // from class: icu.nullptr.twifucker.ui.DownloadDialog$DownloadMediaAdapter$getView$view$1$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        DownloadDialog.Companion companion = DownloadDialog.Companion;
                        Context context = DownloadItem.this.getContext();
                        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                        final DownloadItem downloadItem = DownloadItem.this;
                        companion.download(context, this.getTweetId(), position + 1, this.getUrls().get(position), new Function0<Unit>() { // from class: icu.nullptr.twifucker.ui.DownloadDialog$DownloadMediaAdapter$getView$view$1$2.1
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke  reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                String string2 = DownloadItem.this.getContext().getString(R.string.download_completed);
                                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                                AndroidLogger.toast$default(string2, 0, 2, null);
                            }
                        });
                    }
                });
                DownloadItem view = $this$getView_u24lambda_u240;
                return view;
            }
            return convertView;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$1(final List downloadUrls, final Context context, DownloadDialog this$0, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(downloadUrls, "$downloadUrls");
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        List $this$forEachIndexed$iv = downloadUrls;
        int index$iv = 0;
        for (Object item$iv : $this$forEachIndexed$iv) {
            int index$iv2 = index$iv + 1;
            if (index$iv < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            String j = (String) item$iv;
            final int i2 = index$iv;
            Companion.download(context, this$0.tweetId, i2 + 1, j, new Function0<Unit>() { // from class: icu.nullptr.twifucker.ui.DownloadDialog$1$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    if (i2 == downloadUrls.size() - 1) {
                        String string = context.getString(R.string.download_completed);
                        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                        AndroidLogger.toast$default(string, 0, 2, null);
                    }
                }
            });
            index$iv = index$iv2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$2(Function0 onDismiss, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(onDismiss, "$onDismiss");
        onDismiss.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$3(Function0 onDismiss, DialogInterface it) {
        Intrinsics.checkNotNullParameter(onDismiss, "$onDismiss");
        onDismiss.invoke();
    }
}

package info.guardianproject.ripple;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import info.guardianproject.panic.PanicTrigger;

public class CountDownActivity extends Activity {

    private boolean mTestRun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mTestRun = getIntent().getBooleanExtra(PanicActivity.EXTRA_TEST_RUN, false);

        Window window = getWindow();
        window.setBackgroundDrawable(null);
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // If you want to keep a layout for aesthetics, you can keep this,
        // but it's not necessary if you're going fully headless.
        setContentView(R.layout.activity_count_down);

        if (mTestRun) {
            new AlertDialog.Builder(CountDownActivity.this)
                    .setTitle(R.string.test_dialog_title)
                    .setMessage(R.string.panic_test_successful)
                    .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            CountDownActivity.this.finish();
                        }
                    }).show();
        } else {
            PanicTrigger.sendTrigger(CountDownActivity.this);
            Toast.makeText(CountDownActivity.this, R.string.done, Toast.LENGTH_LONG).show();

            /* This app needs to stay running for a while to make sure that it sends
             * all of the Intents to Activities, Services, and BroadcastReceivers. If
             * it exits too soon, they will not get sent. */
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    ExitActivity.exitAndRemoveFromRecentApps(CountDownActivity.this);
                }
            }, 10000); // Keep this if needed, reduces risk of missed broadcasts
        }
    }
}
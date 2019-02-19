package com.lgy.animatorprac.test;

import android.os.Handler;
import android.os.Message;
import android.support.annotation.ColorRes;
import android.widget.TextView;

import com.lgy.animatorprac.R;

import java.lang.ref.WeakReference;

import static com.lgy.animatorprac.test.TestActivity.MSG_JOB_PROGRESS;
import static com.lgy.animatorprac.test.TestActivity.MSG_JOB_START;
import static com.lgy.animatorprac.test.TestActivity.MSG_JOB_STOP;

class ProgressHandler extends Handler {

    private WeakReference<TestActivity> mActivity;
    private TextView textProgress;

    ProgressHandler(final TestActivity activity) {
        super();
        this.mActivity = new WeakReference<>(activity);
    }

    @Override
    public void handleMessage(final Message msg) {
        super.handleMessage(msg);

        TestActivity mainActivity = mActivity.get();
        if (mainActivity == null) {
            return;
        }
        textProgress = (TextView) mainActivity.findViewById(R.id.text_Progress);
        textProgress.setText(String.valueOf(msg.obj));

        switch (msg.what) {
            case MSG_JOB_START:
                textProgress.setTextColor(getColor(R.color.colorPrimaryDark));
                break;
            case MSG_JOB_PROGRESS:
                textProgress.setTextColor(getColor(R.color.colorAccent));
                break;
            case MSG_JOB_STOP:
                textProgress.setTextColor(getColor(R.color.colorPrimary));
                break;
        }
    }

    private int getColor(@ColorRes int color) {
        return mActivity.get().getResources().getColor(color);
    }
}
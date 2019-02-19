package com.lgy.animatorprac.test;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Messenger;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.lgy.animatorprac.R;

import java.util.List;

public class TestActivity extends AppCompatActivity implements View.OnClickListener {

    private static int mJobId = 0;
    private ProgressHandler mProgressHandler;

    public static final int MSG_JOB_START = 0;
    public static final int MSG_JOB_STOP = 1;
    public static final int MSG_JOB_PROGRESS = 2;

    public static final String MESSENGER_KEY = "MESSENGER_KEY";
    private static final String TAG = TestActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        Button scheduleJobButton = findViewById(R.id.button_schedule_job);
        Button cancelJobButton = findViewById(R.id.button_cancel_job);

        scheduleJobButton.setOnClickListener(this);
        cancelJobButton.setOnClickListener(this);

        mProgressHandler = new ProgressHandler(this);
    }

    @Override
    protected void onStop() {
        stopService(new Intent(this, JobScheduleService.class));
        super.onStop();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent serviceIntent = new Intent(this, JobScheduleService.class);
        Messenger messenger = new Messenger(mProgressHandler);
        serviceIntent.putExtra(MESSENGER_KEY, messenger);
        startService(serviceIntent);
    }

    @Override
    public void onClick(final View view) {
        switch (view.getId()) {
            case R.id.button_schedule_job:

                Intent intent = new Intent(Intent.ACTION_VIEW);
                Uri uri = Uri.parse("market://details?id=" + "com.sherpas.restaurant");//app包名
                intent.setData(uri);
                intent.setPackage("com.android.vending");//应用市场包名
                startActivity(intent);

//                Log.d(TAG, "Scheduling job");
//
//                ComponentName componentName = new ComponentName(this, JobScheduleService.class);
//                final JobInfo jobInfo = new JobInfo.Builder(++mJobId, componentName)
//                        .setRequiredNetworkType(JobInfo.NETWORK_TYPE_UNMETERED)
//                        .build();
//
//                JobScheduler jobScheduler = (JobScheduler) getSystemService(
//                        Context.JOB_SCHEDULER_SERVICE);
//                jobScheduler.schedule(jobInfo);
//                Toast.makeText(TestActivity.this, "New job scheduled with jobId: " + mJobId,
//                        Toast.LENGTH_SHORT).show();
                break;

            case R.id.button_cancel_job:
                Log.d(TAG, "Cancel all scheduled jobs");
                JobScheduler scheduler = (JobScheduler) getSystemService(
                        Context.JOB_SCHEDULER_SERVICE);
                List<JobInfo> allPendingJobs = scheduler.getAllPendingJobs();
                for (JobInfo info : allPendingJobs) {
                    int id = info.getId();
                    scheduler.cancel(id);
                }
                Toast.makeText(TestActivity.this, "All Job Canceled", Toast.LENGTH_SHORT).show();

                //or
//                mJobScheduler.cancelAll();

                break;
            default:
                break;
        }
    }
}


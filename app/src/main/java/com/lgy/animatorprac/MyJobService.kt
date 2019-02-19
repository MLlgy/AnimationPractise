package com.lgy.animatorprac

import android.app.job.JobParameters
import android.app.job.JobService

class MyJobService : JobService() {


    override fun onStopJob(params: JobParameters?): Boolean {
        return false
    }

    override fun onStartJob(params: JobParameters?): Boolean {
        return false
    }
}
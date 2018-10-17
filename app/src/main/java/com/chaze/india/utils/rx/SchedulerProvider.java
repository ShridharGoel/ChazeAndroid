package com.chaze.india.utils.rx;

import io.reactivex.Scheduler;

/**
 * Created by hrskrs on 12/10/2018.
 */

public interface SchedulerProvider {

    Scheduler ui();

    Scheduler computation();

    Scheduler io();

}

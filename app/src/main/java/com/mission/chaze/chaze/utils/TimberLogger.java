package com.mission.chaze.chaze.utils;

import timber.log.Timber;

/**
 * Created by Shubham Vishwakarma on 05/10/18.
 */

public class TimberLogger extends Timber.Tree {
    @Override
    protected void log(final int priority, final String tag, final String message, final Throwable throwable) {
    }
}

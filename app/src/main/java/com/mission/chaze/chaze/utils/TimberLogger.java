package com.mission.chaze.chaze.utils;

import timber.log.Timber;

public class TimberLogger extends Timber.Tree {
    @Override
    protected void log(final int priority, final String tag, final String message, final Throwable throwable) {
    }
}

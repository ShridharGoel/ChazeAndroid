package com.mission.chaze.chaze.utils;

import timber.log.Timber;

/**
 * Created by Shubham Vishwakarma on 05/10/18.
 */

public class TimberLogger extends Timber.DebugTree {
    @Override
    protected String createStackElementTag(StackTraceElement element) {
        return String.format("(%s:%s)#%s",
                element.getFileName(),
                element.getLineNumber(),
                element.getMethodName());
    }
}

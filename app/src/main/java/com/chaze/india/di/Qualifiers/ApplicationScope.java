package com.chaze.india.di.Qualifiers;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by Shubham Vishwakarma on 4/10/18.
 */

@Scope
@Retention(RetentionPolicy.CLASS)
public @interface ApplicationScope {
}


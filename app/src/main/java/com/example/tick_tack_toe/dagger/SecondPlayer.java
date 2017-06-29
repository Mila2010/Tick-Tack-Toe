package com.example.tick_tack_toe.dagger;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Created by mila on 6/29/17.
 */

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface SecondPlayer {}
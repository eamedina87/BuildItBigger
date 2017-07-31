package com.udacity.gradle.builditbigger.idlingresource;

import android.support.annotation.Nullable;
import android.support.test.espresso.IdlingResource;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by Erick on 30/7/17.
 */

public class MyIdlingResource implements IdlingResource {

    private AtomicBoolean mIsIdleNow = new AtomicBoolean(true);
    @Nullable private volatile ResourceCallback mCallback;

    @Override
    public String getName() {
        return this.getClass().getName();
    }

    @Override
    public boolean isIdleNow() {
        return mIsIdleNow.get();
    }

    @Override
    public void registerIdleTransitionCallback(ResourceCallback callback) {
        mCallback = callback;
    }


    public void setIdleState(boolean state){
        mIsIdleNow.set(state);
        if (isIdleNow() && mCallback!=null){
            mCallback.onTransitionToIdle();
        }
    }
}

package com.udacity.gradle.builditbigger;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.IdlingResource;
import android.support.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by Erick on 30/7/17.
 */

@RunWith(JUnit4.class)
public class JokeIdlingResource_onButtonClickIsJokeDisplayed {


    @Rule
    public ActivityTestRule<MainActivity> mActivityRule
            = new ActivityTestRule<>(MainActivity.class);

    private IdlingResource mIdlingResource;


    @Before
    public void registerIdlingResource(){
        mIdlingResource = mActivityRule.getActivity().getIdlingResource();
        Espresso.registerIdlingResources(mIdlingResource);
    }


    @Test
    public void isJokeDisplayed(){
        onView(withId(R.id.btn_get_joke)).perform(click());
        onView(withId(R.id.activity_joke_textview)).check(matches(isDisplayed()));


    }


    @After
    public void unregisterIdlingResource(){
        if (mIdlingResource!=null) {
            Espresso.unregisterIdlingResources(mIdlingResource);
        }
    }



}

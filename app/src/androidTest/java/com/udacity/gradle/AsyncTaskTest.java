package com.udacity.gradle;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.udacity.gradle.builditbigger.EndPointsAsyncTask;
import com.udacity.gradle.builditbigger.MainActivity;

import junit.framework.Assert;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.ExecutionException;

@RunWith(AndroidJUnit4.class)
public class AsyncTaskTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    @Test
    public void testJokeIsNotEmpty() throws InterruptedException, ExecutionException {
        // on the MainActivity execute the AsyncTask
        EndPointsAsyncTask endpointsAsyncTask = new EndPointsAsyncTask();
        endpointsAsyncTask.execute(activityTestRule.getActivity());

        // the String returned in the onPostExecute is being retrieved
        String Joke = endpointsAsyncTask.get();

        Assert.assertTrue(!Joke.equals("")); //This is true when the Endpoint is running.
    }
}
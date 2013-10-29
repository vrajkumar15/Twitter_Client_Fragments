package com.codepath.apps.mytweetapp.fragments;

import org.json.JSONArray;

import com.codepath.apps.mytweetapp.MyTwitterApp;
import com.codepath.apps.mytweetapp.models.Tweet;
import com.loopj.android.http.JsonHttpResponseHandler;

import android.os.Bundle;

public class HometimelineFragment extends TweetsListFragment {
	//fragmentTweets = (TweetsListFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentTweets);
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		MyTwitterApp.getRestClient().getHomeTimeline(new JsonHttpResponseHandler(){
			public void onSuccess(JSONArray jsonTweets) {
				//ArrayList<Tweet> tweets = Tweet.fromJson(jsonTweets);
				getAdapter().addAll(Tweet.fromJson(jsonTweets));
				
			}
		});
	}

}

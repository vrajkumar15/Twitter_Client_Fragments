package com.codepath.apps.mytweetapp.fragments;

import org.json.JSONArray;

import android.os.Bundle;

import com.codepath.apps.mytweetapp.MyTwitterApp;
import com.codepath.apps.mytweetapp.models.Tweet;
import com.loopj.android.http.JsonHttpResponseHandler;

public class UserTimelineFragment extends TweetsListFragment {
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		MyTwitterApp.getRestClient().getUserTimeline(new JsonHttpResponseHandler(){
			public void onSuccess(JSONArray jsonTweets) {
				//ArrayList<Tweet> tweets = Tweet.fromJson(jsonTweets);
				getAdapter().addAll(Tweet.fromJson(jsonTweets));
				
			}
		});
	}

}

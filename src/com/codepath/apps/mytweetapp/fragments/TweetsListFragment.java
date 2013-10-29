package com.codepath.apps.mytweetapp.fragments;

import java.util.ArrayList;

import org.json.JSONArray;

import com.codepath.apps.mytweetapp.MyTwitterApp;
import com.codepath.apps.mytweetapp.R;
import com.codepath.apps.mytweetapp.TweetsAdapter;
import com.codepath.apps.mytweetapp.models.Tweet;
import com.loopj.android.http.JsonHttpResponseHandler;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class TweetsListFragment extends Fragment {
	TweetsAdapter adapter;
	
	@Override
	public View onCreateView(LayoutInflater inf, ViewGroup parent, Bundle savedInstanceState) {
		return inf.inflate(R.layout.fragments_tweets_list, parent, false);
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		homeTimelineFrag();
	
	}
	
	public void homeTimelineFrag(){
			//ArrayList<Tweet> tweets = Tweet.fromJson(jsonTweets);
	    	ArrayList<Tweet> tweets = new ArrayList<Tweet>();
			//ListView lvTweets = (ListView)findViewById(R.id.lvTweets);
	    	ListView lvTweets = (ListView) getActivity().findViewById(R.id.lvTweets);
			//TweetsAdapter adapter = new TweetsAdapter(getBaseContext(), tweets);
			 adapter = new TweetsAdapter(getActivity(), tweets);
			lvTweets.setAdapter(adapter);
			//Log.d("DEBUG", jsonTweets.toString());
	}
	
	public TweetsAdapter getAdapter() {
		return adapter;
	}
	
}

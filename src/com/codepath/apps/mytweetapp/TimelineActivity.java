package com.codepath.apps.mytweetapp;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.codepath.apps.mytweetapp.fragments.HometimelineFragment;
import com.codepath.apps.mytweetapp.fragments.MentionsFragment;
import com.codepath.apps.mytweetapp.fragments.TweetsListFragment;

public class TimelineActivity extends FragmentActivity implements TabListener {
	String tweetStatus;
	TweetsListFragment fragmentTweets;

	private static final int REQUEST_CODE = 0;

@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.compose, menu);
		return true;
	}
	
public void onRefresh(MenuItem m1){
	//Toast.makeText(this, "settings clicked", Toast.LENGTH_SHORT).show();
//	homeTimeline();
	
}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_timeline);
	    
		//fragmentTweets = (TweetsListFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentTweets);
		 
//		homeTimeline();
		setupNavigationTabs();
}
	
	public void setupNavigationTabs(){
		ActionBar actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		actionBar.setDisplayShowTitleEnabled(true);
		Tab tabHome = actionBar.newTab().setText("Home").setTag("HometimelineFragment").setIcon(R.drawable.ic_home).setTabListener(this);
		Tab tabMentions = actionBar.newTab().setText("Mentions").setTag("MentionsFragment").setIcon(R.drawable.ic_mentions).setTabListener(this);
		
		actionBar.addTab(tabHome);
		actionBar.addTab(tabMentions);
		actionBar.selectTab(tabHome);
	}
	
	public void onProfileView(MenuItem mi){
		Intent i = new Intent(this, ProfileActivity.class);
		startActivity(i);
	}
//	public void homeTimeline(){
//	MyTwitterApp.getRestClient().getHomeTimeline(new JsonHttpResponseHandler(){
//		public void onSuccess(JSONArray jsonTweets) {
//			ArrayList<Tweet> tweets = Tweet.fromJson(jsonTweets);
//			 fragmentTweets.getAdapter().addAll(tweets);
			//ArrayList<Tweet> tweets = Tweet.fromJson(jsonTweets);
			//ListView lvTweets = (ListView)findViewById(R.id.lvTweets);
			//TweetsAdapter adapter = new TweetsAdapter(getBaseContext(), tweets);
			//lvTweets.setAdapter(adapter);
			//Log.d("DEBUG", jsonTweets.toString());
//		}
//	});
//	}

	public void onCompose(MenuItem m){
		//Toast.makeText(this, "settings clicked", Toast.LENGTH_SHORT).show();
		Intent i = new Intent(this, ComposeTweetActivity.class);
		//startActivity(i);
		startActivityForResult(i, REQUEST_CODE);	
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent i){
		//Toast.makeText(this, "back" , Toast.LENGTH_SHORT).show();
		  if (resultCode == 0){
			  if(requestCode == 0) {
				 tweetStatus = i.getStringExtra("posted_data");
				  
	    		  //AdvSearch data = (AdvSearch) getIntent().getSerializableExtra("criteria");
			     Toast.makeText(this, tweetStatus , Toast.LENGTH_SHORT).show();
			     

			  }
			  }
	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		
		
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		android.support.v4.app.FragmentManager manager = getSupportFragmentManager();
		android.support.v4.app.FragmentTransaction fts = manager.beginTransaction();
		
		if (tab.getTag() == "HometimelineFragment") {
			//set the fragment in framelayout to home timeline
			fts.replace(R.id.frameContainer, new HometimelineFragment());
		} else {
			//set the fragment in framelayout to mentions timeline
			fts.replace(R.id.frameContainer, new MentionsFragment());
		}
			
		fts.commit();
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		
		
	}
	


}

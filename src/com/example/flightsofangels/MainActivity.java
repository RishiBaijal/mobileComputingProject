package com.example.flightsofangels;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {
	public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void createPoll(View view)
	{
		
		Intent intent = new Intent (this, CreatePollActivity.class);
		intent.putExtra(EXTRA_MESSAGE, "Create a new poll");
		// We need to define a new class. Still thinking how to do that.
		startActivity(intent);
	}
	
	public void joinPoll(View view)
	{
		Intent intent=new Intent(this, JoinPollActivity.class);
		intent.putExtra(EXTRA_MESSAGE, "Join poll activity has been launched");
		startActivity(intent);
		//In this case, many polls already exist and the user has to join one extra poll
	}
}

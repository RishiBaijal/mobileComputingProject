package com.example.flightsofangels;

import java.util.ArrayList;

import android.support.v7.app.ActionBarActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class JoinPollActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_join_poll);

		TextView textview = new TextView(this);
		textview.setTextSize(40);
		// textview.setText("Join poll Activity");
		
		int i;
		String s = "";
		final LinearLayout lm=(LinearLayout) findViewById(R.id.buttonlayout);
		ArrayList<String> arr = getPollsInNetwork();
		for (i = 0; i < arr.size(); i++) {
			/*
			 * Button button=new Button(this); s+=arr.get(i)+"\n";
			 * button.setText(s); LinearLayout ll=(LinearLayout)
			 * findViewById(R.id.buttonlayout); LayoutParams lp=new
			 * LayoutParams(LayoutParams.MATCH_PARENT,
			 * LayoutParams.WRAP_CONTENT); ll.addView(button, lp);
			 */
//			LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
//					LinearLayout.LayoutParams.MATCH_PARENT,
//					LinearLayout.LayoutParams.WRAP_CONTENT);
			LinearLayout ll=new LinearLayout(this);
			LayoutParams params=new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
			Button btn=new Button(this);
			btn.setId(i);
			int id=btn.getId();
			btn.setText(s);
			btn.setBackgroundColor(Color.rgb(80, 80, 80));
			ll.addView(btn, params);
			Button btn1=(Button) findViewById(id);
			btn1.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Toast.makeText(v.getContext(),
		                    "Poll successfully selected", Toast.LENGTH_SHORT)
		                    .show();

				}
			});
			ll.addView(btn);
			lm.addView(ll);

		}
		textview.setText(s);
		setContentView(textview);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.join_poll, menu);
		return true;
	}

	public int getNumberOfCandidates() {
		int x = 4;
		/*
		 * This function will iterate over the list of people who are
		 * regsitered, and print the results
		 */
		return x;
	}

	public ArrayList<String> getPollsInNetwork() {
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("Sample poll 1");
		arr.add("Sample poll 2");
		// Change this function later to connect to the network and actually get
		// the number of polls that have been created
		return arr;
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
}

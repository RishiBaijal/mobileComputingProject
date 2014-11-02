package com.example.flightsofangels;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class JoinPollActivity extends ActionBarActivity {

	protected static String s;
	Button radio;
	public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_join_poll);

		// TextView textview = new TextView(this);
		// textview.setTextSize(40);
		// // textview.setText("Join poll Activity");

		// String s = "";
		// final LinearLayout lm=(LinearLayout) findViewById(R.id.buttonlayout);
		ArrayList<String> arr = getPollsInNetwork();
		int number = arr.size();
		int i, row;
		//String s;
		for (row = 0; row < 1; row++) {
			LinearLayout ll = new LinearLayout(this);
			ll.setOrientation(LinearLayout.VERTICAL);
			final Intent intent = new Intent(this, OngoingPolls.class);
			for (i = 1; i <= number; i++) {
				radio = new Button(this);
				radio.setId(row * 2 + i);
				radio.setText("Poll # " + radio.getId());
				radio.setOnClickListener(new OnClickListener(){

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						JoinPollActivity.s=""+radio.getId();
						intent.putExtra(EXTRA_MESSAGE, s);
						startActivity(intent);
					}
					
					
				});
				ll.addView(radio);
			}

			((ViewGroup) findViewById(R.id.radiogroup)).addView(ll);

		}

		// addRadioButtons(arr.size(), "Radio button #");

		// for (i = 0; i < arr.size(); i++) {
		/*
		 * Button button=new Button(this); s+=arr.get(i)+"\n";
		 * button.setText(s); LinearLayout ll=(LinearLayout)
		 * findViewById(R.id.buttonlayout); LayoutParams lp=new
		 * LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		 * ll.addView(button, lp);
		 */
		// LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
		// LinearLayout.LayoutParams.MATCH_PARENT,
		// LinearLayout.LayoutParams.WRAP_CONTENT);
		// LinearLayout ll = new LinearLayout(this);
		// LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT,
		// LayoutParams.WRAP_CONTENT);
		// Button btn = new Button(this);
		// btn.setId(i);
		// int id = btn.getId();
		// btn.setText(s);
		// btn.setBackgroundColor(Color.rgb(80, 80, 80));
		// ll.addView(btn, params);
		// Button btn1 = (Button) findViewById(id);
		// btn1.setOnClickListener(new View.OnClickListener() {
		//
		// @Override
		// public void onClick(View v) {
		// // TODO Auto-generated method stub
		// Toast.makeText(v.getContext(),
		// "Poll successfully selected", Toast.LENGTH_SHORT)
		// .show();
		//
		// }
		// });
		// ll.addView(btn);
		// lm.addView(ll);

		// }
		// textview.setText(s);
		// setContentView(textview);

	}

	// public void addRadioButtons(int number, String text) {
	// int i, row;
	// for (row = 0; row < 1; row++) {
	// LinearLayout ll = new LinearLayout(this);
	// ll.setOrientation(LinearLayout.VERTICAL);
	// for (i=1; i<=number; i++)
	// {
	// radio=new RadioButton(this);
	// radio.setId(row*2 + i);
	// radio.setText(text + radio.getId());
	// ll.addView(radio);
	// }
	//
	// ((ViewGroup) findViewById(R.id.radiogroup)).addView(ll);
	//
	// }
	//
	// }

	public void submitted(View view) {
		RadioGroup rg = (RadioGroup) findViewById(R.id.radiogroup);
		// Button next=(Button) findViewById(R.id.btn);
		// next.set
		String s = "" + rg.getCheckedRadioButtonId();
		Intent intent = new Intent(this, OngoingPolls.class);
		intent.putExtra(EXTRA_MESSAGE, s);
		startActivity(intent);
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
		 * registered, and print the results
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

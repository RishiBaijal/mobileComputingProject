package com.example.flightsofangels;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

//This is the file that I will be working on next
public class CreatePollActivity extends ActionBarActivity {
	public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
//
//		TextView textview = new TextView(this);
//		textview.setTextSize(40);
//		String s = getPollTitle();
//		textview.setText(s);
//		setContentView(textview);
		setContentView(R.layout.activity_display_message);
		
	}

	public String getPollTitle() {
		int c = 0;
		String s = "Poll " + c;// c is a dynamic counter which will later be
								// stored on the database
		c++;
		return s;

	}
	
	public void submit(View view)
	{
		//In this case, the poll results need to be submitted
		Intent intent = new Intent (this, ResultsOfCreatePoll.class);
		Intent intent1=new Intent(this, JoinPollActivity.class);
		/*At this point, we need to pass the intent the results of the data that is being
		 *  displayed. As of now, I am just passing it a string. I will see how to handle the rest later on.
		 */
		//intent.putExtra(EXTRA_MESSAGE,"Displaying results of the new poll:");
		EditText editText=(EditText) findViewById(R.id.question);
		String s=editText.getText().toString();
		intent.putExtra(EXTRA_MESSAGE, s);
		intent1.putExtra(EXTRA_MESSAGE, s);
		startActivity(intent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.display_message, menu);
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
	
	
}

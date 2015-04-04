package ro.pub.cs.systems.pdsd.practicaltest01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PracticalTest01MainActivity extends Activity {
	final private static int SECONDARY_ACTIVITY_REQUEST_CODE = 201;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_practical_test01_main);

		final Button left = (Button) findViewById(R.id.left_press_me);
		left.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				final TextView mEdit = (TextView)findViewById(R.id.left_textView);
				Integer val = Integer.valueOf(mEdit.getText().toString()) + 1;
				mEdit.setText(val.toString());

			}
		 });
		
		final Button right = (Button) findViewById(R.id.right_press_me);
		right.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				final TextView mEdit = (TextView)findViewById(R.id.right_textView);
				Integer val = Integer.valueOf(mEdit.getText().toString()) + 1;
				mEdit.setText(val.toString());
			}
		 });
		
		final Button new_activity = (Button) findViewById(R.id.navigate_to_secondary_activity_button);
		new_activity.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				final TextView left = (TextView)findViewById(R.id.left_textView);
				final TextView right = (TextView)findViewById(R.id.right_textView);
				
				Intent intent = new Intent("ro.pub.cs.systems.pdsd.lab04.intent.action.SecondaryActivity");
				
				intent.putExtra("total_clicks", String.valueOf(Integer.valueOf(left.getText().toString()) +
												Integer.valueOf(right.getText().toString())));
				startActivityForResult(intent, SECONDARY_ACTIVITY_REQUEST_CODE);
			}
		});
	}
	
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
		  switch(requestCode) {
		    case SECONDARY_ACTIVITY_REQUEST_CODE:
		      if (resultCode == Activity.RESULT_OK) {
		        Bundle data = intent.getExtras();
		        // process information from data ...
		        Toast.makeText(getApplicationContext(), data.getString("total_clicks"), 
		        		   Toast.LENGTH_LONG).show();
		      }
		      break;
		 
		      // process other request codes
		  }
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.practical_test01_main, menu);
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
 
	@Override
	protected void onSaveInstanceState(Bundle savedInstanceState) {
	  super.onSaveInstanceState(savedInstanceState);
	  
	  TextView leftText = (TextView) findViewById(R.id.left_textView);
	  savedInstanceState.putString("leftCount", leftText.getText().toString());
	  
	  TextView rightText = (TextView) findViewById(R.id.right_textView);
	  savedInstanceState.putString("rightCount", rightText.getText().toString());
	}
	
	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
	  super.onRestoreInstanceState(savedInstanceState);
	  
	  String leftNumber = savedInstanceState.getString("leftCount");
	  TextView leftText = (TextView) findViewById(R.id.left_textView);
	  leftText.setText(leftNumber);
	  
	  String rightNumber = savedInstanceState.getString("rightCount");
	  TextView rightText = (TextView) findViewById(R.id.right_textView);
	  rightText.setText(rightNumber);
	}
}

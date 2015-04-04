package ro.pub.cs.systems.pdsd.practicaltest01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PracticalTest01SecondaryActivity extends Activity {
	private String total;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_practical_test01_secondary);
		
		Intent intentFromParent = getIntent();
		Bundle data = intentFromParent.getExtras();

		final TextView total_text = (TextView) findViewById(R.id.total_text);
		total = data.getString("total_clicks");
		total_text.setText(total);
		
		final Button ok_button = (Button) findViewById(R.id.ok_button);
		ok_button.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intentToParent = new Intent("ro.pub.cs.systems.pdsd.lab04.intent.action.SecondaryActivity");
				intentToParent.putExtra("total_clicks", total);
				setResult(RESULT_OK, intentToParent);
				finish();
			}
		});
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.practical_test01_secondary, menu);
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

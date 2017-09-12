package edu.tufts.cs.simplewidgetsapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.RadioGroup;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onButtonClick(View view) {
        //Log.v("*****", "You clicked on the button!");
        TextView feedback = (TextView) findViewById(R.id.feedback);
        RadioGroup rg = (RadioGroup) findViewById(R.id.votingGroup);

        // Check if a radio button is checked
        // Reference: https://stackoverflow.com/questions/11194515/android-get-value-of-the-selected-radio-button
        if(rg.getCheckedRadioButtonId() != -1) {
            int checkedRadioButtonId = rg.getCheckedRadioButtonId();
            View checkedRadioButtonView = rg.findViewById(checkedRadioButtonId);
            int checkedRadioButtonIndex = rg.indexOfChild(checkedRadioButtonView);
            RadioButton theCheckedRadioButton = (RadioButton) rg.getChildAt(checkedRadioButtonIndex);
            feedback.setText("Thanks for voting for " + (String)theCheckedRadioButton.getText());
        }
        else {
            feedback.setText("Sorry, you did not vote!");
        }
    }
}
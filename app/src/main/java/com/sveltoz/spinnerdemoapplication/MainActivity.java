package com.sveltoz.spinnerdemoapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    static Spinner spinner = null;
    ArrayList<State> states=new ArrayList<State>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = (Spinner)this.findViewById(R.id.Spinner01);
        for(int i=0;i<=5;i++)
        states.add(new State( i, "India"+i, "IN"+i ));

        // Create and fill an ArrayAdapter with a bunch of "State" objects
        ArrayAdapter spinnerArrayAdapter = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item, states);

        // Step 3: Tell the spinner about our adapter
        spinner.setAdapter(spinnerArrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                // Your code here
                State st = (State)spinner.getSelectedItem();

                String desc = "Event: \nstate: " + st.name;
                desc += "\nabbreviation: " + st.abbrev + "\nid: " + String.valueOf( st.id );

                Toast.makeText(getApplicationContext(),desc,Toast.LENGTH_SHORT).show();

            }

            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });
//        spinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                // Get the currently selected State object from the spinner
//                State st = (State)spinner.getSelectedItem();
//                Toast.makeText(getApplicationContext(),st.toString(),Toast.LENGTH_SHORT).show();
//
//
//
//
//            }
//        });

    }
}

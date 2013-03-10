package com.DroidApps;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class ToDoActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //inflate view
        setContentView(R.layout.main);

        //get references to UI widgets
        EditText editText = (EditText) findViewById(R.id.myEditText);
        ListView listView = (ListView) findViewById(R.id.myListView);

        ArrayList<String> todoItems = new ArrayList<String>();
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, todoItems);

        todoItems.add("first item...");

        listView.setAdapter(arrayAdapter);


    }
}

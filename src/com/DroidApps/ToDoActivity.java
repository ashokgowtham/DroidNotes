package com.DroidApps;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
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
        final EditText editText = (EditText) findViewById(R.id.myEditText);
        ListView listView = (ListView) findViewById(R.id.myListView);

        final ArrayList<String> todoItems = new ArrayList<String>();
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, todoItems);

        listView.setAdapter(arrayAdapter);
        editText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    if ((keyCode == KeyEvent.KEYCODE_DPAD_CENTER) ||
                            (keyCode == KeyEvent.KEYCODE_ENTER)) {
                        todoItems.add(editText.getText().toString());
                        arrayAdapter.notifyDataSetChanged();
                        editText.setText("");
                        return true;
                    }
                }
                return false;
            }
        });
    }
}

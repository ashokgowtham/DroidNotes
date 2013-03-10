package com.DroidApps;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
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
        final ListView listView = (ListView) findViewById(R.id.myListView);
        final Button button = (Button) findViewById(R.id.addToDoItemButton);

        final ArrayList<String> todoItems = new ArrayList<String>();
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.todolist_item, todoItems);

        listView.setAdapter(arrayAdapter);
        editText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    if ((keyCode == KeyEvent.KEYCODE_DPAD_CENTER) ||
                            (keyCode == KeyEvent.KEYCODE_ENTER)) {
                        AddToDoItem(todoItems, editText, arrayAdapter, listView);
                        return true;
                    }
                }
                return false;
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddToDoItem(todoItems, editText, arrayAdapter, listView);
            }
        });
    }

    private void AddToDoItem(ArrayList<String> todoItems, EditText editText, ArrayAdapter<String> arrayAdapter, ListView listView) {
        todoItems.add(editText.getText().toString());
        arrayAdapter.notifyDataSetChanged();
        editText.setText("");
    }
}

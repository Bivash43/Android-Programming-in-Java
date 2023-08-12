package com.example.listviewandsqlite;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cursoradapter.widget.CursorAdapter;
import androidx.cursoradapter.widget.SimpleCursorAdapter;

public class MainActivity extends AppCompatActivity {
    private DatabaseHelper dbHelper;
    private SimpleCursorAdapter cursorAdapter;
    private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DatabaseHelper(this);
        SQLiteDatabase database = dbHelper.getReadableDatabase();

        ListView listView = findViewById(R.id.listViewItems);
        String[] fromColumns = {DatabaseHelper.COLUMN_NAME, DatabaseHelper.COLUMN_DESCRIPTION};
        int[] toViews = {R.id.itemNameTextView, R.id.itemDescriptionTextView};

        cursor = database.query(DatabaseHelper.TABLE_ITEMS, null, null, null, null, null, null);
        cursorAdapter = new SimpleCursorAdapter(this, R.layout.list_item, cursor, fromColumns, toViews, 0);
        listView.setAdapter(cursorAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                showItemDialog(cursor, position);
            }
        });

        Button addButton = findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AddItemActivity.class));
            }
        });
    }

    private void showItemDialog(Cursor cursor, int position) {
        cursor.moveToPosition(position);
        String itemName = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_NAME));
        String itemDescription = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_DESCRIPTION));

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(itemName);
        builder.setMessage(itemDescription);
        builder.setPositiveButton("OK", null);
        builder.show();
    }

    private void refreshCursor() {
        cursor = dbHelper.getReadableDatabase().query(DatabaseHelper.TABLE_ITEMS, null, null, null, null, null, null);
        cursorAdapter.swapCursor(cursor);
    }

    @Override
    protected void onResume() {
        super.onResume();
        refreshCursor();
    }

    @Override
    protected void onDestroy() {
        cursor.close();
        dbHelper.close();
        super.onDestroy();
    }
}

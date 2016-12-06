package sigildesigns.habittracker;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import sigildesigns.habittracker.data.Contract;
import sigildesigns.habittracker.data.HabitDbHelper;

public class MainActivity extends AppCompatActivity {

    private HabitDbHelper mDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDbHelper = new HabitDbHelper(this);
    }

    private void insertHabits() {
        // Create and/or open a database to write to it
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        // Create a new map of values, where column names are the keys.
        ContentValues values = new ContentValues();
        values.put(Contract.HabitEntry.COLUMN_HABIT_NAME, "Take a walk.");
        values.put(Contract.HabitEntry.COLUMN_HABIT_STATUS, Contract.HabitEntry.STATUS_INCOMPLETE);
        // Insert the new row, returning the primary key value of the new row.
        long newRowId = db.insert(Contract.HabitEntry.TABLE_NAME, null, values);
        Log.v("MainActivity", "New row ID " + newRowId);

        // Insert another row
        values = new ContentValues();
        values.put(Contract.HabitEntry.COLUMN_HABIT_NAME, "Take Medicine");
        values.put(Contract.HabitEntry.COLUMN_HABIT_STATUS, Contract.HabitEntry.STATUS_COMPLETED);
        // Insert the new row, returning the primary key value of the new row.
        newRowId = db.insert(Contract.HabitEntry.TABLE_NAME, null, values);
        Log.v("MainActivity", "New row ID " + newRowId);

        // Insert another row
        values = new ContentValues();
        values.put(Contract.HabitEntry.COLUMN_HABIT_NAME, "Drink Coffee");
        values.put(Contract.HabitEntry.COLUMN_HABIT_STATUS, Contract.HabitEntry.STATUS_COMPLETED);
        // Insert the new row, returning the primary key value of the new row.
        newRowId = db.insert(Contract.HabitEntry.TABLE_NAME, null, values);
        Log.v("MainActivity", "New row ID " + newRowId);
    }

    private Cursor databaseInfo() {
        // To access our database, we instantiate our subclass of SQLiteOpenHelper and pass the
        // context, which is the current activity.
        HabitDbHelper mDbHelper = new HabitDbHelper(this);

        // Create and/or open a database to read from it
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        // Create the projection for which columns we want to view (all of them)
        String[] projection = {Contract.HabitEntry._ID, Contract.HabitEntry.COLUMN_HABIT_NAME,
                Contract.HabitEntry.COLUMN_HABIT_STATUS};

        // Create the cursor object.
        Cursor cursor = db.query(Contract.HabitEntry.TABLE_NAME, projection, null, null, null,
                null, null);
        return cursor;
    }
}

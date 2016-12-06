package sigildesigns.habittracker.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Helper methods used to create the database.
 */

public class HabitDbHelper extends SQLiteOpenHelper {
    // Name of the database.
    private static final String DATABASE_NAME = "habittracker.db";
    // Database version. If you change the database schema you must increment the database version.
    private static final int DATABASE_VERSION = 1;

    public HabitDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // CREATE TABLE habits (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT NOT NULL, status
        // INTEGER NOT NULL);
        // Create a String that contains the SQL statement to create the habits table.
        String SQL_CREATE_HABITS_TABLE = "CREATE TABLE " + Contract.HabitEntry.TABLE_NAME + "("
                + Contract.HabitEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + Contract.HabitEntry.COLUMN_HABIT_NAME + " TEXT NOT NULL, "
                + Contract.HabitEntry.COLUMN_HABIT_STATUS + " INTEGER NOT NULL DEFAULT 0);";
        // Log the contents of the string to make sure it's correct if there's any problems.
        Log.v("SQL_CREATE_HABITS_TABLE", SQL_CREATE_HABITS_TABLE);
        // Create the above table.
        sqLiteDatabase.execSQL(SQL_CREATE_HABITS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
    }
}

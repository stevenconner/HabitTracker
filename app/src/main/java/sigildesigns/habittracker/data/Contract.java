package sigildesigns.habittracker.data;

import android.provider.BaseColumns;

/**
 * Holds the constant values for the database building and manipulation.
 */

public class Contract {
    /**
     * To prevent someone from accidentally instantiating the contract class,
     * make the constructor private.
     */
    private Contract() {
    }

    // Inner class that defines the table contents
    public static class HabitEntry implements BaseColumns {
        public static final String TABLE_NAME = "habits";
        public static final String _ID = "_id";
        public static final String COLUMN_HABIT_NAME = "name";
        public static final String COLUMN_HABIT_STATUS = "status";

        // Create constants for status
        public static final int STATUS_INCOMPLETE = 0;
        public static final int STATUS_COMPLETED = 1;
    }
}

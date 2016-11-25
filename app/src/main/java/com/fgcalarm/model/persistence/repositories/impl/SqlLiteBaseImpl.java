package com.fgcalarm.model.persistence.repositories.impl;

import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Biel on 24/11/2016.
 */

public abstract class SqlLiteBaseImpl {
    // Gets the data repository in write mode
    SQLiteDatabase db = mDbHelper.getWritableDatabase();
}

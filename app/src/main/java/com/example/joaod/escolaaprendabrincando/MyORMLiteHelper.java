package com.example.joaod.escolaaprendabrincando;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

/**
 * Created by joaod on 21/11/2016.
 */

public class MyORMLiteHelper extends OrmLiteSqliteOpenHelper {
    private static final String DATABASE_NAME = "escola_db";
    private static final int DATABASE_VERSION = 1;
    private static MyORMLiteHelper mInstance = null;
    private Dao<Calendario, Integer> calendarioJsonsDao = null;

    public MyORMLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static MyORMLiteHelper getmInstance(Context context) {
        if (mInstance == null)
            mInstance = new MyORMLiteHelper(context);
        return mInstance;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, Calendario.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int i, int i1) {
        try {
            TableUtils.dropTable(connectionSource, Calendario.class, true);
            onCreate(sqLiteDatabase, connectionSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Dao<Calendario, Integer> getCalendarioJsonsDao() throws SQLException {
        if (calendarioJsonsDao == null)
            calendarioJsonsDao = getDao(Calendario.class);
        return calendarioJsonsDao;
    }
}

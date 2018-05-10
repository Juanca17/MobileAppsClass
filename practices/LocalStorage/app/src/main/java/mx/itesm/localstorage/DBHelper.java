package mx.itesm.localstorage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by UXLab on 26/01/18.
 */

// DBMS para guardar localmente sqlite
// base de datos local, relacional
// sqlite ya viene como parte del OS

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE = "Students.db";
    private static final String TABLE = "Students";
    private static final String FIELD_ID = "id";
    private static final String FIELD_NAME = "name";
    private static final String FIELD_GRADE = "grade";


    public DBHelper(Context context){
        super(context, DATABASE, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        // no los invocamos explícitamente
        // son parte del funcionamiento interno de un SQLiteOpenHelper
        String query = "CREATE TABLE " + TABLE + "(" +
                FIELD_ID + " INTEGER PRIMARY KEY, " +
                FIELD_NAME + " TEXT, " +
                FIELD_GRADE + " INTEGER)";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        // ?
        String query = "DROP TABLE IF EXISTS ?";
        String[] params = {TABLE};
        sqLiteDatabase.execSQL(query, params);
        onCreate(sqLiteDatabase);
    }

    public void save(String name, int grade){
        // obtener una referencia a la BD
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(FIELD_NAME, name);
        values.put(FIELD_GRADE, grade);
        // insert
        db.insert(TABLE, null, /*ContentValues - valores que vamos a poner*/ values);
    }

    public int delete(int id){

        SQLiteDatabase db = getWritableDatabase();
        String clause = FIELD_ID + " = ?";
        String[] args = {id + ""};
        return db.delete(
                TABLE,
                /* where clause */ clause,
                /* args for clause */ args
                );
    }

    public int find(String name){

        SQLiteDatabase db = getReadableDatabase();
        String clause = FIELD_NAME + " = ?";
        String[] args = {name};

        Cursor c = db.query(TABLE, null, clause, args, null, null, null, null);

        int result = -1;

        if(c.moveToFirst()){
            result = c.getInt(2);
        }


        return result;
    }

}

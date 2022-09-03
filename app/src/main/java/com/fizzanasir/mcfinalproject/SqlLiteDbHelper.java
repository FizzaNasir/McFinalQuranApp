package com.fizzanasir.mcfinalproject;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.fizzanasir.mcfinalproject.SurahList;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class SqlLiteDbHelper extends SQLiteOpenHelper {

        private static final int DATABASE_VERSION = 1;
        private static final String DATABASE_NAME = "quran_database.sqlite";
        private static final String DB_PATH_SUFFIX = "/databases/";
        static Context ctx;
        public SqlLiteDbHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
            ctx = context;
        }
    public ArrayList<AyahDetails> getParaDetailsByEngUrdutrans(int Uloc, int Eloc, int pid){
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<AyahDetails> contList = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM tayah WHERE ParaID="+pid, null);
        if (cursor.moveToFirst()) {
            while (cursor.moveToNext()) {
                AyahDetails cont = new AyahDetails(cursor.getInt(1),cursor.getInt(2), cursor.getInt(10), cursor.getString(3), cursor.getString(Uloc), cursor.getString(Eloc));
                contList.add(cont);
            }
            cursor.close();
            db.close();
        }
        return contList;
    }

    public ArrayList<AyahDetails> getParaDetailsByEngtrans( int Eloc, int pid){
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<AyahDetails> contList = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM tayah WHERE ParaID="+pid, null);
        if (cursor.moveToFirst()) {
            while (cursor.moveToNext()) {
                AyahDetails cont = new AyahDetails(cursor.getInt(1),cursor.getInt(2), cursor.getInt(10), cursor.getString(3), cursor.getString(4), cursor.getString(Eloc));
                contList.add(cont);
            }
            cursor.close();
            db.close();
        }
        return contList;
    }

    public ArrayList<AyahDetails> getParaDetailsByUrdutrans( int Uloc, int pid){
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<AyahDetails> contList = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM tayah WHERE ParaID="+pid, null);
        if (cursor.moveToFirst()) {
            while (cursor.moveToNext()) {
                AyahDetails cont = new AyahDetails(cursor.getInt(1),cursor.getInt(2), cursor.getInt(10), cursor.getString(3), cursor.getString(Uloc), cursor.getString(6));
                contList.add(cont);
            }
            cursor.close();
            db.close();
        }
        return contList;
    }

    public ArrayList<AyahDetails> getDetailsByPara(int sid){
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<AyahDetails> contList = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM tayah WHERE ParaID="+sid, null);
        if (cursor.moveToFirst()) {
            while (cursor.moveToNext()) {
                AyahDetails cont = new AyahDetails(cursor.getInt(1),cursor.getInt(2), cursor.getInt(10), cursor.getString(3), cursor.getString(4), cursor.getString(6));
                contList.add(cont);
            }
            cursor.close();
            db.close();
        }
        return contList;
    }

        public ArrayList<AyahDetails> getDetailsBySurah(int sid){
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<AyahDetails> contList = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM tayah WHERE SuraID="+sid, null);
        if (cursor.moveToFirst()) {
            while (cursor.moveToNext()) {
                AyahDetails cont = new AyahDetails(cursor.getInt(1),cursor.getInt(2), cursor.getInt(10), cursor.getString(3), cursor.getString(4), cursor.getString(6));
                contList.add(cont);
            }
            cursor.close();
            db.close();
        }
        return contList;
      }
    public ArrayList<String> getParaDetailsOnlyArabic(int pid){
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<String> contList = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM tayah WHERE ParaID="+pid, null);
        if (cursor.moveToFirst()) {
            while (cursor.moveToNext()) {
                String cont =  cursor.getString(3);
                contList.add(cont);
            }
            cursor.close();
            db.close();
        }
        return contList;
    }
    public ArrayList<String> getParaDetailsOnlyUrdutrans( int Uloc, int pid){
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<String> contList = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM tayah WHERE ParaID="+pid, null);
        if (cursor.moveToFirst()) {
            while (cursor.moveToNext()) {
                String cont =  cursor.getString(Uloc);
                contList.add(cont);
            }
            cursor.close();
            db.close();
        }
        return contList;
    }

    public ArrayList<String> getParaDetailsOnlyEngtrans( int Eloc, int pid){
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<String> contList = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM tayah WHERE ParaID="+pid, null);
        if (cursor.moveToFirst()) {
            while (cursor.moveToNext()) {
                String cont =  cursor.getString(Eloc);
                contList.add(cont);
            }
            cursor.close();
            db.close();
        }
        return contList;
    }


    public ArrayList<String> getDetails() {
            SQLiteDatabase db = this.getReadableDatabase();
//            ArrayList<AyahDetails> contList = new ArrayList<>();
        ArrayList<String> contList = new ArrayList<>();
            Cursor cursor = db.rawQuery("SELECT ArabicText  "+" FROM tayah", null);
            if (cursor != null) {
                while (cursor.moveToNext()) {
//                    AyahDetails cont = new AyahDetails(cursor.getInt(1),cursor.getInt(2), cursor.getInt(10), cursor.getString(3), cursor.getString(5), cursor.getString(6));
                    String cont = cursor.getString(0);
                    contList.add(cont);
                }
                cursor.close();
                db.close();
            }
            return contList;
        }


    public void CopyDataBaseFromAsset() throws IOException {
            InputStream myInput = ctx.getAssets().open(DATABASE_NAME);
// Path to the just created empty db
            String outFileName = getDatabasePath();

// if the path doesn't exist first, create it
            File f = new File(ctx.getApplicationInfo().dataDir + DB_PATH_SUFFIX);
            if (!f.exists())
                f.mkdir();

// Open the empty db as the output stream
            OutputStream myOutput = new FileOutputStream(outFileName);

// transfer bytes from the inputfile to the outputfile
            byte[] buffer = new byte[1024];
            int length;
            while ((length = myInput.read(buffer)) > 0) {
                myOutput.write(buffer, 0, length);
            }
// Close the streams
            myOutput.flush();
            myOutput.close();
            myInput.close();

        }
        private static String getDatabasePath() {
            return ctx.getApplicationInfo().dataDir + DB_PATH_SUFFIX + DATABASE_NAME;
        }
        public SQLiteDatabase openDataBase() throws SQLException {
            File dbFile = ctx.getDatabasePath(DATABASE_NAME);
            if (!dbFile.exists()) {
                try {
                    CopyDataBaseFromAsset();
                    System.out.println("Copying sucess from Assets folder");
                } catch (IOException e) {
                    throw new RuntimeException("Error creating source database", e);
                }
            }
            return SQLiteDatabase.openDatabase(dbFile.getPath(), null, SQLiteDatabase.NO_LOCALIZED_COLLATORS | SQLiteDatabase.CREATE_IF_NECESSARY);
        }
        @Override
        public void onCreate(SQLiteDatabase db) {
        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        }
}

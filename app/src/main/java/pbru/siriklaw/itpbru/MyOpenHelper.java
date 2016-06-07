package pbru.siriklaw.itpbru;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by lab324-28 on 6/7/2016 AD.
 */
public class MyOpenHelper extends SQLiteOpenHelper{

    //Explicit ประกาศตัวแปร
    public static final  String database_name = "pbru.db";
    private static final int database_vertion = 1;

    private static final String create_user_table = "create table userTABLE(" +
            "_id integer primary key, " +
            "Name text," +
            "Surname text," +
            "User text," +
            "Password text);";

    public MyOpenHelper(Context context) {
        super(context, database_name, null, database_vertion);

    }//Constructor เชื่อมต่อกับคราว

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(create_user_table);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}//main Class

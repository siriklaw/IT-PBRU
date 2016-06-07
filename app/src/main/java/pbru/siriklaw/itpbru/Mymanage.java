package pbru.siriklaw.itpbru;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by lab324-28 on 6/7/2016 AD.
 */
public class MyManage {

    //Expicit ประกาศตัวแปร

    private MyOpenHelper myOpenHelper;
    private SQLiteDatabase sqLiteOpenHelper;

    public static final String user_table = "userTABLE";
    public static final String colum_id = "_id";
    public static final String colum_name = "Name";
    public static final String colum_surname = "Surname";
    public static final String colum_user = "User";
    public static final String colum_password = "Password";

    public MyManage(Context context){

        myOpenHelper = new MyOpenHelper(context);
        sqLiteOpenHelper = myOpenHelper.getWritableDatabase();

    }//Constructor

    public long addNewUser(String strName,
                           String strID,
                           String strSurname,
                           String strUser,
                           String strPassword){
        ContentValues contentValues = new ContentValues();
        contentValues.put(colum_id, strID);
        contentValues.put(colum_name, strName);
        contentValues.put(colum_surname, strSurname);
        contentValues.put(colum_user, strUser);
        contentValues.put(colum_password, strPassword);

        return  sqLiteOpenHelper.insert(user_table, null, contentValues);

    }

}//Main Class

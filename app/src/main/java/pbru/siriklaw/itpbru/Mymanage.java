package pbru.siriklaw.itpbru;

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

    public MyManage(Context context){

        myOpenHelper = new MyOpenHelper(context);
        sqLiteOpenHelper = myOpenHelper.getWritableDatabase();

    }//Constructor

}//Main Class

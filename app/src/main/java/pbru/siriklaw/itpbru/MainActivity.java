package pbru.siriklaw.itpbru;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private MyManage mymanage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mymanage = new MyManage(this);

        //test add new user
        //mymanage.addNewUser("1234", "name", "sur", "user", "pass");

        //Delete All SQLite
        deleteAllSQLite();


    } // Main Method จะมี "  เสมอ


    private void deleteAllSQLite(){

        SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name,
                MODE_PRIVATE, null);
        sqLiteDatabase.delete(MyManage.user_table, null, null);

    }//Delete All SQLite

        // Shif + command + enter
    public void clicksignUpMain(View view ) {
        startActivity(new Intent(MainActivity.this,signUpActivity.class));
    }
}   // Main Class นี่คือ คลาสหลัก

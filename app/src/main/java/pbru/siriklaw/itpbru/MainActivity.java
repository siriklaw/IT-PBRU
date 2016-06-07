package pbru.siriklaw.itpbru;

import android.content.Intent;
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

    } // Main Method จะมี "  เสมอ
        // Shif + command + enter
    public void clicksignUpMain(View view ) {
        startActivity(new Intent(MainActivity.this,signUpActivity.class));
    }
}   // Main Class นี่คือ คลาสหลัก

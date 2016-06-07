package pbru.siriklaw.itpbru;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class signUpActivity extends AppCompatActivity {

    //
    private EditText name_EditText, sureName_EditText, user_EditText, password_EditText;
    private String nameString, sureName_String, user_String, password_String;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        name_EditText = (EditText) findViewById(R.id.editText2);
        sureName_EditText = (EditText) findViewById(R.id.editText3);
        user_EditText = (EditText) findViewById(R.id.editText4);
        password_EditText = (EditText) findViewById(R.id.editText5);

    }

    public void clickSignUpSign(View view) {
        nameString = name_EditText.getText().toString().intern();
        sureName_String = sureName_EditText.getText().toString().intern();
        user_String = user_EditText.getText().toString().intern();
        password_String = password_EditText.getText().toString().intern();

        //chek
        if(checkSpace()){
            //true
            MyAlert myAlert = new MyAlert();
            myAlert.mydialog(this, "มีช่องว่าง", "กรุณากรอกทุกช่อง");

        }else {
            //False
        }
    }//clickSingUPSing

    private boolean checkSpace() {
        boolean result = true;
        result = nameString.equals("") || sureName_String.equals("") || sureName_String.equals("") ||
                password_String.equals("");


        return result;
    }

}

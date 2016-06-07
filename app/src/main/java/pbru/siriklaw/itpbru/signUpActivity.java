package pbru.siriklaw.itpbru;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class signUpActivity extends AppCompatActivity {

    //
    private EditText name_EditText, sureName_EditText, user_EditText, password_EditText;
    private String nameString, sureName_String, user_String, password_String;
    private static final String urLUpload = "http://swiftcodingthai.com/pbru2/add_user_master.php";


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
            uploadValueToServer();

        }
    }//clickSingUPSing

    private void uploadValueToServer(){

        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody requestBody = new FormEncodingBuilder()
                .add("isAdd", "true")
                .add("Name", nameString)
                .add("Surname", sureName_String)
                .add("User", user_String)
                .add("Password", password_String)
                .build();

        Request.Builder builder = new Request.Builder();
        Request request = builder.url(urLUpload).post(requestBody).build();
        Call call = okHttpClient.newCall(request);///เรียก
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {
                finish();
            }
        });

    }//UploadToServer


    private boolean checkSpace() {
        boolean result = true;
        result = nameString.equals("") || sureName_String.equals("") || sureName_String.equals("") ||
                password_String.equals("");


        return result;
    }

}

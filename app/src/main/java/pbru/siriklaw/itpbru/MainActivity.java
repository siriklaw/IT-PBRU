package pbru.siriklaw.itpbru;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private MyManage mymanage;
    private static final String urlJSON = "http://swiftcodingthai.com/pbru2/get_user_master.php";
    private EditText userEditText, passwordEditText;//ตัวแปร
    private String userString, passwordString;//ตัวแปรรับค่า

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //bind widget
        userEditText = (EditText) findViewById(R.id.editText5);
        passwordEditText = (EditText) findViewById(R.id.editText6);

        mymanage = new MyManage(this);

        //test add new user
        //mymanage.addNewUser("1234", "name", "sur", "user", "pass");

        //Delete All SQLite
        deleteAllSQLite();

        mySynJSON();


    } // Main Method

    public void clickSingIN(View view){

        userString = userEditText.getText().toString().trim();
        passwordString = passwordEditText.getText().toString().trim();

        //check space
        if(userString.equals("") || passwordString.equals("")){
            MyAlert myAlert = new MyAlert();
            myAlert.mydialog(this, "Move Space", "Please fill all every blank");

        }else {
            checkUserAnPassword();
        }


    }//Click SignIN

    private void checkUserAnPassword() {

    }


    private void mySynJSON() {
        ConnecUserTABLE connecUserTABLE = new ConnecUserTABLE(this);
        connecUserTABLE.execute();
    }

    //Create Inter Class
    private class ConnecUserTABLE extends AsyncTask<Void, Void, String>{

        private Context context;
        private ProgressDialog progressDialog;


        public ConnecUserTABLE(Context context) {
            this.context = context;
        }//Create ConstrucTor

        @Override//เมื่อโหลดหายจะได้ String
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = ProgressDialog.show(context, "Synchonize Server",
                    "Please Wait .... Process Synchonize");

        }

        @Override
        protected String doInBackground(Void... voids){

            try {
                OkHttpClient okHttpClient = new OkHttpClient();
                Request.Builder builder = new Request.Builder();
                Request request = builder. url(urlJSON).build();
                Response response = okHttpClient.newCall(request).execute();
                return response.body().string();

            }catch (Exception e){
                Log.d("7June", "error Doin ==>" + e.toString());
            }

            return null;
        }// do in background

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            try {

                progressDialog.dismiss();
                Log.d("7June", "JSON ==>" + s);

                JSONArray jsonArray = new JSONArray(s);//จองฐานข้อมูล

                String[] idString = new String[jsonArray.length()];
                String[] nameString = new String[jsonArray.length()];
                String[] surnameString = new String[jsonArray.length()];
                String[] userString = new String[jsonArray.length()];
                String[] passwordString = new String[jsonArray.length()];

                for (int i=0; i<jsonArray.length();i++){

                    JSONObject jsonObject = jsonArray.getJSONObject(i);//ตัวบ่งชี้

                    idString[i] = jsonObject.getString("id");//อ้างจาก SQL ID
                    nameString[i] = jsonObject.getString(MyManage.colum_name);
                    surnameString[i] = jsonObject.getString(MyManage.colum_surname);
                    userString[i] = jsonObject.getString(MyManage.colum_user);
                    passwordString[i] = jsonObject.getString(MyManage.colum_password);

                    mymanage.addNewUser(idString[i], nameString[i], surnameString[i], userString[i],
                            passwordString[i]);//loop string ตำแหน้งที่ I

                }//loop for

            } catch (Exception e){
                e.printStackTrace();
            }

        }
    }//Conneced Class เชื่อมต่อกับคราส


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

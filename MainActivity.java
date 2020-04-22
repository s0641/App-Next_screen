package com.app.register;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    TextView Tv1;
    EditText Et, Et1, Et2, Et3;
    Button B1;
    CheckBox chkIos, chkAndroid, chkWindows;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Tv1 = (TextView) findViewById(R.id.textView4);
        Et = (EditText) findViewById(R.id.editText);
        Et1 = (EditText) findViewById(R.id.editText1);
        Et2 = (EditText) findViewById(R.id.editText2);
        Et3 = (EditText) findViewById(R.id.editText3);
        B1 = (Button) findViewById(R.id.button);
        chkIos = findViewById(R.id.chkIos);
        chkAndroid = findViewById(R.id.chkAndroid);
        chkWindows = findViewById(R.id.chkWindows);
        Fun1ChkIos();


        B1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                if (Validate() == false) {
                    return;
                }
                String uname  = Et.getText().toString();
                String pass = Et2.getText().toString();
                //Tv1.setText("Welcome " + Et.getText().toString());
                if(uname.equals("Shubham") && pass.equals("12345890"))
                {

                    Intent i = new Intent(MainActivity.this,Act2.class);
                    i.putExtra("username",Et.getText().toString());
                    startActivity(i);
                    Toast.makeText(MainActivity.this,"Login Successful", Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Login Failed.", Toast.LENGTH_LONG).show();
                }
            }
        });
        String uname  = Et.getText().toString();
        String pass = Et2.getText().toString();
    }

    private boolean Validate() {

        String name = Et.getText().toString();
        if (isValidName(name) == false) {                //this function is for validating name if not matched according to the condtion it will show error msg
            Et.setError("Enter Name");
            return false;
        }

        String email = Et1.getText().toString();
        if (isValidEmail(email) == false) {             //this function is for validating e-mail if not matched according to the condtion it will show error msg
            Et1.setError("Invalid Email");
            return false;
        }

        String pass = Et2.getText().toString();
        if (isValidPassword(pass) == false) {          //this function is for validating password if not matched according to the condtion it will show error msg
            Et2.setError("Invalid Password");
            return false;
        }
        int num = Integer.parseInt(Et3.getText().toString());
        if (isAge(num) == false) {                                //this function is for validating age if not matched according to the condtion it will show error msg
            Et3.setError("Enter again");
            return false;
        }
        return true;
    }

    // validating email
    private boolean isValidEmail(String email) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);                   //this is for matching format required for pattern in email
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    // validating password with retype password
    private boolean isValidPassword(String pass) {
        if (pass != null && pass.length() > 6) {                           //this is for matching format required for pattern in Pass
            return true;
        }
        return false;
    }

    //validating User Name for blank
    private boolean isValidName(String name) {
        if (name != null && name.length() > 0) {                         //this is for matching format required for pattern in name
            return true;
        }
        return false;
    }

    private boolean isAge(int num) {
        if (num > 0 && num < 100) {
            return true;                                                 //this is for matching format required for pattern in age
        }
        return false;
    }

    public void Fun1ChkIos() {
        chkIos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (chkIos.isChecked()) {
                    Toast.makeText(MainActivity.this,
                            "Hi ", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this,
                            "Bye !", Toast.LENGTH_LONG).show();
                }
            }
            }
        );
    }
}



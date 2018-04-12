package mx.com.webmaps.md_ejercicio3;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    AppCompatEditText user;
    AppCompatEditText pass;
    RelativeLayout relativeLayout;
    TextInputLayout userLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = (AppCompatEditText) findViewById(R.id.username_TextField);
        pass = (AppCompatEditText) findViewById(R.id.password_TextField);

        relativeLayout = (RelativeLayout) findViewById(R.id.activity_main);
        userLayout = (TextInputLayout) findViewById(R.id.username_TextInputLayout);

        relativeLayout.setOnClickListener(null);

        user.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                validateUser();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



        user.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                validateUser();
            }
        });

    }

    private  void  validateUser(){
        if(user.getText().toString().isEmpty()){
            userLayout.setErrorEnabled(true);
            userLayout.setError("enter username");
        }
        else{
            userLayout.setErrorEnabled(false);
        }
    }
}

package com.guerrero.labexer_dec5;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etPara;
    TextView tvDisplay;
    Button btnSave;
    Button btnDisplay;
    Button btnClear;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etPara = (EditText) findViewById(R.id.etPara);
        btnClear = (Button) findViewById(R.id.btn_Clear);
        btnSave = (Button) findViewById(R.id.btn_Save);
        btnDisplay = (Button) findViewById(R.id.btn_Display);
        tvDisplay = (TextView) findViewById(R.id.tv_display);
        preferences = getPreferences(Context.MODE_PRIVATE);
    }

    public void saveInfo(View View) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("message", etPara.getText().toString());
        editor.commit();
        Toast.makeText(this, "Message Saved!", Toast.LENGTH_SHORT).show();
    }

    public void clearInfo(View View) {
        tvDisplay.setText("");
    }

    public void displayInfo(View view){
        String message = preferences.getString("message", "");
        tvDisplay.setText(message);
    }
}

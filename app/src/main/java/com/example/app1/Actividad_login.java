package com.example.app1;

import static java.lang.invoke.VarHandle.AccessMode.GET;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import org.json.JSONException;

import java.util.HashMap;
import java.util.Map;

import WebServices.Asynchtask;
import WebServices.WebService;



public class Actividad_login extends AppCompatActivity implements Asynchtask {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_actividad_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        TextInputLayout txtUserLy = findViewById(R.id.txtUserLy);
        TextInputEditText txtUser = findViewById(R.id.txtUser);
        TextInputLayout txtPassLy = findViewById(R.id.txtPassLy);
        TextInputEditText txtPass = findViewById(R.id.txtPass);

        Button btLogin = findViewById(R.id.btLogin);
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = txtUser.getText().toString();
                String pass = txtPass.getText().toString();

                Map<String, String> datos = new HashMap<String, String>();
                WebService ws= new WebService(
                        "https://revistas.uteq.edu.ec/ws/login.php?usr=cristian&pass=123",

                        datos, Actividad_login.this, Actividad_login.this);
                ws.execute("GET");
            }
        });



    }

    @Override
    public void processFinish(String result) throws JSONException {
        Toast.makeText(getApplicationContext(),result,Toast.LENGTH_LONG).show();
    }

}

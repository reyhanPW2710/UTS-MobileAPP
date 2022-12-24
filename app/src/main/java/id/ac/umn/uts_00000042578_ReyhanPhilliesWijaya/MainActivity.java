package id.ac.umn.uts_00000042578_ReyhanPhilliesWijaya;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{
    Button buttonLibrary, login;
    EditText username;
    AlertDialog dialog;

    public void profileApp(View view){
        Intent intent = new Intent(MainActivity.this,Profile.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonLibrary = findViewById(R.id.buttonLibrary);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Login Page");

        View view = getLayoutInflater().inflate(R.layout.layout_dialog, null);
        builder.setView(view);
        dialog = builder.create();
        buttonLibrary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();
            }
        });

        login = view.findViewById(R.id.login);
        username = (EditText)view.findViewById(R.id.inputuser);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                if(user.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Name must be entered", Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent = new Intent(MainActivity.this, LibraryApp.class);
                    String message = "Hello" + "," + username.getText().toString();
                    intent.putExtra("hasil", message);
                    startActivity(intent);
                }
                dialog.dismiss();
            }
        });
    }


}
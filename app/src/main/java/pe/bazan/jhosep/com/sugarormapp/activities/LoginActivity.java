package pe.bazan.jhosep.com.sugarormapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import pe.bazan.jhosep.com.sugarormapp.R;
import pe.bazan.jhosep.com.sugarormapp.models.User;
import pe.bazan.jhosep.com.sugarormapp.repositories.UserRepository;

public class LoginActivity extends AppCompatActivity {

    private static final int REGISTER_FORM_REQUEST = 100;
    private EditText user_email;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        user_email = findViewById(R.id.username_input);
        password = findViewById(R.id.password_input);

    }

    public void VerRegistros(View view) {
        Intent intent = new Intent(this, MainActivity.class);

        startActivity(intent);
    }

    public void callRegisterForm(View view){
        startActivityForResult(new Intent(this, RegisterActivity.class), REGISTER_FORM_REQUEST);
    }

    public void callLogin(View view) {
        String email = user_email.getText().toString();
        String pass = password.getText().toString();

        User userv = UserRepository.Login(email, pass);

        if(email.isEmpty() && pass.isEmpty()){
            Toast.makeText(this, "Los campos estan vacios", Toast.LENGTH_SHORT).show();
        } else if(userv == null){
            Toast.makeText(this,"Usuario o contraseña invalido", Toast.LENGTH_SHORT).show();
        } else{
            Intent intent = new Intent(this, PageActivity.class);

            startActivity(intent);
        }



    }
}

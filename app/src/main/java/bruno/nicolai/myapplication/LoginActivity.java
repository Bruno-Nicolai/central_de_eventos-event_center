package bruno.nicolai.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import bruno.nicolai.myapplication.databinding.ActivityLoginBinding;


public class LoginActivity extends AppCompatActivity {


    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.loginBtnNext.setOnClickListener(view -> {
            login();
        });
    }

    public void login() {
        String user = binding.loginEtEmail.getText().toString().trim();
        String password = binding.loginEtPassword.getText().toString().trim();

        if (user.equals("admin") && password.equals("admin")) {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Try again.", Toast.LENGTH_LONG).show();
        }

    }

}
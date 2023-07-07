package bruno.nicolai.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

import bruno.nicolai.myapplication.databinding.ActivityLoginBinding;


public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.vvHeader.setVideoURI(
                Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.login_bg)
        );
        binding.vvHeader.start();
        binding.vvHeader.setOnPreparedListener(mediaPlayer -> {
            mediaPlayer.setLooping(true);
        });

        binding.loginBtnNext.setOnClickListener(view -> {
            login();
        });
    }

    public void login() {
//        String user = binding.loginEtEmail.getText().toString().trim();
        goToMainActivity();
    }

    public void goToMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        binding.vvHeader.resume();
        super.onResume();
    }

    @Override
    protected void onRestart() {
        binding.vvHeader.start();
        super.onRestart();
    }

    @Override
    protected void onPause() {
        binding.vvHeader.suspend();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        binding.vvHeader.stopPlayback();
        super.onDestroy();
    }
}
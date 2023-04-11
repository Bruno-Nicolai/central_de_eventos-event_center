package bruno.nicolai.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import bruno.nicolai.myapplication.databinding.ActivityGetStartedBinding;
import bruno.nicolai.myapplication.databinding.ActivityWelcomeBinding;

public class GetStartedActivity extends AppCompatActivity {

    ActivityGetStartedBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGetStartedBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Button nextButton = binding.welcomeBtnNext;
        nextButton.setOnClickListener(view -> {
                Intent intent = new Intent(GetStartedActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
        });
    }
}
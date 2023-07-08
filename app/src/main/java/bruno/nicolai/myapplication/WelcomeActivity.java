package bruno.nicolai.myapplication;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import bruno.nicolai.myapplication.databinding.ActivityWelcomeBinding;

public class WelcomeActivity extends AppCompatActivity {

    private ActivityWelcomeBinding binding;
    TextView[] dots;

    ViewPager.OnPageChangeListener viewPagerListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @RequiresApi(api = Build.VERSION_CODES.N)
        @Override
        public void onPageSelected(int position) {

            setDotIndicator(position);

            if (position > 0) {
                binding.welcomeBtnPrev.setVisibility(View.VISIBLE);
            } else {
                binding.welcomeBtnPrev.setVisibility(View.INVISIBLE);
            }

            if (position == 4) {
                binding.welcomeBtnNext.setText("Finish");
            } else {
                binding.welcomeBtnNext.setText("Next");
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {


        }
    };

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWelcomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.welcomeBtnPrev.setOnClickListener(view -> {
            if (getItem(0) > 0) {
                binding.slideViewPager.setCurrentItem(getItem(-1), true);
            }
        });

        binding.welcomeBtnNext.setOnClickListener(view -> {
            if (getItem(0) < 4) {
                binding.slideViewPager.setCurrentItem(getItem(1), true);
            } else {
                Intent intent = new Intent(WelcomeActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        binding.welcomeBtnSkip.setOnClickListener(view -> {
            Intent intent = new Intent(WelcomeActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        });


        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);
        binding.slideViewPager.setAdapter(viewPagerAdapter);

        setDotIndicator(0);
        binding.slideViewPager.addOnPageChangeListener(viewPagerListener);

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void setDotIndicator(int position) {
        dots = new TextView[5];
        binding.dotIndicator.removeAllViews();

        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226", Html.FROM_HTML_MODE_LEGACY));
            dots[i].setTextSize(35);
            dots[i].setTextColor(getResources().getColor(R.color.gray_dark, getApplicationContext().getTheme()));
            binding.dotIndicator.addView(dots[i]);
        }
        dots[position].setTextColor(getResources().getColor(R.color.purple_500, getApplicationContext().getTheme()));
    }

    private int getItem(int i) {
        return binding.slideViewPager.getCurrentItem() + i;
    }

}
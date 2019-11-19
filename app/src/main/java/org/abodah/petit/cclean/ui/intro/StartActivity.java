package org.abodah.petit.cclean.ui.intro;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import org.abodah.petit.cclean.R;
import org.abodah.petit.cclean.ui.main.MainActivity;

import java.util.ArrayList;
import java.util.List;

public class StartActivity extends AppCompatActivity {

    IntroViewPagerAdapter introViewPagerAdapter;
    TabLayout tabIndicator;
    Button btnSkip, btnGetStarted;
    LinearLayout linearLayoutSkip, linearLayoutGetStarted;
    private ViewPager screenPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        // Views
        btnSkip = findViewById(R.id.btn_skip);
        btnGetStarted = findViewById(R.id.btn_get_started);
        linearLayoutSkip = findViewById(R.id.linear_layout_skip);
        linearLayoutGetStarted = findViewById(R.id.linear_layout_get_started);
        tabIndicator = findViewById(R.id.tab_indicator);
        // Fill data description
        final List<ScreenItem> mList = new ArrayList<>();
        mList.add(new ScreenItem("Watering without worry", "You can set your schedule watering plant properly and can exchange schedule automatically if come a bad climate", R.drawable.page_one));
        mList.add(new ScreenItem("Get Information About Your Plants", "You can scan information of your plant or a pest that harm your plant and get information how to take care that problems.", R.drawable.page_second));
        mList.add(new ScreenItem("Build & Share with Community", "You can create group or community of your garden or community in your city. And you can also trade, lend, buy, or share any goods with other people", R.drawable.page_third));

        // Setup ViewPager
        screenPager = findViewById(R.id.screen_viewpager);
        introViewPagerAdapter = new IntroViewPagerAdapter(this, mList);
        screenPager.setAdapter(introViewPagerAdapter);

        // Setup tab indicator
        tabIndicator.setupWithViewPager(screenPager);

        // Button Skip
        btnSkip.setOnClickListener(view -> screenPager.setCurrentItem(screenPager.getCurrentItem() + 1, true));

        tabIndicator.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == mList.size() - 1) {
                    loadLastScreen();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

        //Button Get Started
        btnGetStarted.setOnClickListener(view -> {
            Intent mainActivity = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(mainActivity);
            savePrefsData();
            finish();
        });

    }

    private boolean restorePreData() {

        SharedPreferences preferences = getApplicationContext().getSharedPreferences("myPrefs", MODE_PRIVATE);

        Boolean isIntroActivityOpenedBefore = preferences.getBoolean("isIntroOpened", false);

        return isIntroActivityOpenedBefore;

    }


    private void savePrefsData() {

        SharedPreferences preferences = getApplicationContext().getSharedPreferences("myPrefs", MODE_PRIVATE);

        SharedPreferences.Editor editor = preferences.edit();

        editor.putBoolean("isIntroOpened", true);

        editor.apply();

    }


    private void loadLastScreen() {

        linearLayoutSkip.setVisibility(View.INVISIBLE);

        linearLayoutGetStarted.setVisibility(View.VISIBLE);

    }
}

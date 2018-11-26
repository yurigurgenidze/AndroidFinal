package yuri.gurgenidze.ge.finalproject.main;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import yuri.gurgenidze.ge.finalproject.R;

public class MainActivity extends AppCompatActivity {

    ViewPager vpFragments;
    TabLayout tlFragments;
    ViewPagerAdapter viewPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        setContentView(R.layout.activity_main);
        vpFragments = findViewById(R.id.activity_main_view_pager);
        tlFragments = findViewById(R.id.activity_main_tab_layout);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), this);
        vpFragments.setAdapter(viewPagerAdapter);
        tlFragments.setupWithViewPager(vpFragments);
        Drawable nightDrawable = getResources().getDrawable(R.drawable.ic_evening_bg);
        Drawable dayDrawable = getResources().getDrawable(R.drawable.ic_day_bg);

        if (intent.getStringExtra("bg").equals("night")){
            vpFragments.setBackground(nightDrawable);
        } else {
            vpFragments.setBackground(dayDrawable);
        }




    }

    @Override
    public void onBackPressed() {
        onDestroy();
        this.finish();
    }
}

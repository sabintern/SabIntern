package application.example.com.sabintern.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import application.example.com.sabintern.Adapters.FragmentViewPagerAdapter;
import application.example.com.sabintern.Model.CourseContent;
import application.example.com.sabintern.R;

/**
 * Created by Dell on 04-01-2018.
 */

public class ViewPagerActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener {
    private TabLayout tabLayout;
    CourseContent courseContent;

    //This is our viewPager
    private ViewPager viewPager;

    private Toolbar toolbar;
    String[] tabTitles = {"Videos", "Quizzes", "Discussion"};


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        toolbar = findViewById(R.id.toolbar_description);
        setSupportActionBar(toolbar);
        toolbar.setBackgroundColor(getResources().getColor(R.color.black));
        toolbar.setTitle("Java");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        initViewPager();
        initTabs();
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.addOnTabSelectedListener(this);
        courseContent = getIntent().getParcelableExtra("contents");
    }

    private void initViewPager() {
        viewPager = findViewById(R.id.pager_description);
        FragmentViewPagerAdapter fragmentViewPagerAdapter = new FragmentViewPagerAdapter(getSupportFragmentManager(), tabTitles);
        viewPager.setOffscreenPageLimit(3);
        viewPager.setAdapter(fragmentViewPagerAdapter);

    }

    private void initTabs() {
        tabLayout = findViewById(R.id.tabLayout_description);
        tabLayout.setupWithViewPager(viewPager);
        setTabContent();

    }

    private void setTabContent() {
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tabView = tabLayout.getTabAt(i);
            tabView.setCustomView(R.layout.tab_layout);
            TextView tabTitle = (TextView) tabView.getCustomView().findViewById(R.id.title_icons);
            tabTitle.setText(tabTitles[i]);

        }
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());


    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}

package com.dream.searchit;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class TabActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
        Toolbar toolbar = (Toolbar) findViewById(R.id.tool);
        setSupportActionBar(toolbar);

        SectionAdapter adapter = new SectionAdapter(getSupportFragmentManager());
        ViewPager pager = (ViewPager) findViewById(R.id.view_pager);
        pager.setAdapter(adapter);

        TabLayout layout = (TabLayout) findViewById(R.id.tab_layout);
        layout.setupWithViewPager(pager);
        layout.setTabTextColors(-1,-256);

    }
    private class SectionAdapter extends FragmentPagerAdapter{
        public SectionAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment frag=null;
            if(position==0){
                frag=new FirstFragment();
            }
            else if(position==1){
                frag=new SecondFragment();
            }
            return frag;
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            if(position==0){
                return "Contacts";
            }
            else if(position==1){
                return "Location";
            }
            return super.getPageTitle(position);
        }
    }
}

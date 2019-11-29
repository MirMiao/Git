package com.bw.git;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    static ViewPager viewPager;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.vp);
        radioGroup = findViewById(R.id.rg);

        final List<Fragment> list=new ArrayList<>();
         list.add(new Fragment1());
         list.add(new Fragment2());
        Fragment3 fragment3 = new Fragment3();
        list.add(fragment3);
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
             @Override
             public Fragment getItem(int position) {
                 return list.get(position);
             }
             @Override
             public int getCount() {
                 return list.size();
             }
         });
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case  R.id.r1:
                        viewPager.setCurrentItem(0);
                        break;
                        case  R.id.r2:
                            viewPager.setCurrentItem(1);
                        break;
                        case  R.id.r3:
                            viewPager.setCurrentItem(2);
                        break;
                }
            }
        });
    }
    public static void qie(){
        viewPager.setCurrentItem(2);
    }
}

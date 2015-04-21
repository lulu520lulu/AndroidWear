package com.example.liulu.androidwear.Activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.liulu.androidwear.R;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity implements RadioGroup.OnCheckedChangeListener, ViewPager.OnPageChangeListener {
    private ArrayList<Fragment> fragments;
    private ViewPager m_viewPager;
    private RadioGroup m_radioGroup;
    private TextView biaoLiao_text;
    private TextView title_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      /*
       SlidingMenu slidingMenu = new SlidingMenu(this);
        slidingMenu.setMode(SlidingMenu.LEFT);
        slidingMenu.setMenu(R.layout.menu);
        slidingMenu.setBehindWidth(240);
        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        slidingMenu.setShadowWidth(50);
        slidingMenu.setShadowDrawable(R.drawable.shadow);
        slidingMenu.setSecondaryShadowDrawable(R.drawable.shadowright);
        slidingMenu.setFadeDegree(0.35f);
        slidingMenu.setBehindScrollScale(0.35f);
        slidingMenu.attachToActivity(this,SlidingMenu.SLIDING_WINDOW);
*/
        //得到ViewPager和RadioGroup的对象
       Toolbar toolBar = (Toolbar) findViewById(R.id.toolBar);
        title_text = (TextView) toolBar.findViewById(R.id.title);
        biaoLiao_text = (TextView) toolBar.findViewById(R.id.baoLiao);
        m_viewPager = (ViewPager) findViewById(R.id.m_viewPager);
        m_radioGroup = (RadioGroup) findViewById(R.id.m_radionGroup);
        //设置ActionBar

        //设置默认的RadioButton
        ((RadioButton) m_radioGroup.getChildAt(0)).setChecked(true);

        //对RadioGroup设置监听
        m_radioGroup.setOnCheckedChangeListener(this);
        // 将Fragment封装到集合ArrayList中
        fragments = new ArrayList<Fragment>();
        A_TejieFragment f0 = new A_TejieFragment();
        B_AiGuangFragment f1 = new B_AiGuangFragment();
        C_FeiLeiFragment f2 = new C_FeiLeiFragment();
        fragments.add(f0);
        fragments.add(f1);
        fragments.add(f2);
        m_viewPager.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager()));
        //设置ViewPager的监听
        m_viewPager.setOnPageChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.radio01:
                title_text.setText("天天半价");
                m_viewPager.setCurrentItem(0);
                break;
            case R.id.radio02:
                biaoLiao_text.setVisibility(View.GONE);
                title_text.setText("爱逛");
                m_viewPager.setCurrentItem(1);
                break;
            case R.id.radio03:
                biaoLiao_text.setVisibility(View.GONE);
                title_text.setText("分类");
                m_viewPager.setCurrentItem(2);
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        RadioButton btn = (RadioButton) m_radioGroup.getChildAt(position);
        btn.setChecked(true);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    class MyFragmentPagerAdapter extends FragmentPagerAdapter {

        public MyFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            if (fragments!=null){
                return fragments.size();
            }
            return 0;
        }
    }

}

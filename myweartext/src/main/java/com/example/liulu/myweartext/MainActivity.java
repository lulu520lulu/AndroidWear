package com.example.liulu.myweartext;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.wearable.view.CardFragment;
import android.support.wearable.view.DismissOverlayView;
import android.support.wearable.view.FragmentGridPagerAdapter;
import android.support.wearable.view.GridViewPager;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        GridViewPager pager = (GridViewPager) findViewById(R.id.gradViewPager);
        pager.setAdapter(new MyAdapter(getFragmentManager()));
        final DismissOverlayView dismissOverLayView =
                (DismissOverlayView)findViewById(R.id.dismiss_overlayView);
        //显示长按退出
        dismissOverLayView.setIntroText("长按退出");
        dismissOverLayView.showIntroIfNecessary();
        final GestureDetector detector = new GestureDetector(MainActivity.this,
                new GestureDetector.SimpleOnGestureListener(){
                    @Override
                    public void onLongPress(MotionEvent e) {
                        dismissOverLayView.show();
                        super.onLongPress(e);

                    }
                });
        pager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return detector.onTouchEvent(event);
            }
        });
    }
    class MyAdapter extends FragmentGridPagerAdapter{
        Page pages[][]=new Page[10][10];
        public MyAdapter(FragmentManager fm) {
            super(fm);
            for (int i=0;i<pages.length;i++){
                for (int j=0;j<pages[i].length;j++){
                    pages[i][j]=new Page();
                    pages[i][j].title="第"+i+"行";
                    pages[i][j].text="第"+j+"列";
                    pages[i][j].icon=R.drawable.ic_launcher;
                }
            }
        }
        class Page{
            String title;
            String text;
            int icon;
        }
        @Override
        public Fragment getFragment(int i, int i2) {
            Page page = pages[i][i2];
            return CardFragment.create(page.title,page.text,page.icon);
        }

        @Override
        public Drawable getBackgroundForRow(int row) {
            if (row%2==0){
                return new ColorDrawable(Color.BLUE);
            }
            return new ColorDrawable(Color.RED);
        }

        @Override
        public int getRowCount() {
            return pages.length;
        }

        @Override
        public int getColumnCount(int i) {
            return pages[i].length;
        }
    }
}

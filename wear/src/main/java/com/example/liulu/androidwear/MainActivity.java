package com.example.liulu.androidwear;

import android.app.Activity;
import android.os.Bundle;
import android.support.wearable.view.CardScrollView;
import android.view.Gravity;
import android.widget.TextView;

public class MainActivity extends Activity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //第一种效果
        /* setContentView(R.layout.activity_main);
       final WatchViewStub stub = (WatchViewStub) findViewById(R.id.watch_view_stub);
        stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
            @Override
            public void onLayoutInflated(WatchViewStub stub) {
                mTextView = (TextView) stub.findViewById(R.id.text);
            }
        });*/
        //第二种效果
        //setContentView(R.layout.box);
        //第三种效果
      /*  setContentView(R.layout.card_fragment_text);
        CardFragment f = CardFragment.create("title", "text", R.drawable.ic_launcher);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.add(R.id.fragment_container,f).commit();*/
        //第四种效果
        //CardFrame是一个view
        //CardScrollView;
        setContentView(R.layout.cardview);
        CardScrollView cardScrollView = (CardScrollView)
                findViewById(R.id.cardScrollView);
        //让CardFame在底部显示
        cardScrollView.setCardGravity(Gravity.BOTTOM);
    }
}

package com.example.liulu.myweartext2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.activity.ConfirmationActivity;
import android.support.wearable.view.DelayedConfirmationView;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements DelayedConfirmationView.DelayedConfirmationListener {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        final DelayedConfirmationView delayedConfirmationView = (DelayedConfirmationView)
                findViewById(R.id.delayedConfirmationView);
        delayedConfirmationView.setListener(this);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delayedConfirmationView.setTotalTimeMs(3000);
                delayedConfirmationView.start();
                button.setText("正在保存中......");

            }
        });
    }
    private boolean isCancel;
    //时间到了
    @Override
    public void onTimerFinished(View view) {
        Intent intent = new Intent();
        intent.setClass(this, ConfirmationActivity.class);
        if (isCancel){
            //取消保存
            button.setText("取消已保存");
            intent.putExtra(ConfirmationActivity.EXTRA_ANIMATION_TYPE,
                    ConfirmationActivity.FAILURE_ANIMATION);
            intent.putExtra(ConfirmationActivity.EXTRA_MESSAGE,"取消操作");
        }else {
            button.setText("保存完成");
//            intent.putExtra(ConfirmationActivity.EXTRA_ANIMATION_TYPE,
//                    ConfirmationActivity.SUCCESS_ANIMATION);
//            intent.putExtra(ConfirmationActivity.EXTRA_MESSAGE,"完成操作");
        }
        startActivity(intent);
    }
    //点击x图标
    @Override
    public void onTimerSelected(View view) {
    //取消
        button.setText("取消保存");
        isCancel=true;
    }
}

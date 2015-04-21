package com.example.liulu.androidwear.Activity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.liulu.androidwear.Beans.B_AiGuang_Beans;
import com.example.liulu.androidwear.R;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class B_AiGuangFragment extends Fragment {
    private static final String URL_BASE="http://api.gouwu.duba.com/mobile_product/get_xsg_items.json?page=";
    private static int page_count=1;
    private ArrayList<B_AiGuang_Beans> b_aiGuang_beanses;


    public B_AiGuangFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.listview_layout, container, false);
        b_aiGuang_beanses = new ArrayList<>();
        String path=URL_BASE+page_count;
        HttpUtils httpUtils = new HttpUtils();
        httpUtils.send(com.lidroid.xutils.http.client.HttpRequest.HttpMethod.GET,
                path,new RequestCallBack<Object>() {
                    @Override
                    public void onSuccess(ResponseInfo<Object> objectResponseInfo) {
                        String json = objectResponseInfo.result.toString();
                        try {
                            JSONObject object = new JSONObject(json);
                            int error = object.getInt("error");
                            if (error==0){
                                JSONArray data = object.getJSONArray("data");
                                for (int i=0;i<data.length();i++){
                                    JSONObject jsonObject = data.getJSONObject(i);
                                    String original_price = jsonObject.getString("original_price");
                                    String mobile_url = jsonObject.getString("mobile_url");
                                    String title = jsonObject.getString("title");
                                    String liked_num = jsonObject.getString("liked_num");
                                    String price = jsonObject.getString("price");
                                    String image = jsonObject.getString("image");
                                    int id = jsonObject.getInt("id");
                                    B_AiGuang_Beans b_aiGuang_beans = new
                                            B_AiGuang_Beans(original_price,
                                            mobile_url, title, liked_num, price, image, id);
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFailure(com.lidroid.xutils.exception.HttpException e, String s) {

                    }
                });



        ListView listView = (ListView) v.findViewById(R.id.listView);
        LinearLayout linearLayout = (LinearLayout)
                v.findViewById(R.id.linearLayout);
        final TextView jiaZai_text = (TextView) linearLayout
                .findViewById(R.id.jiaZai_text);
        jiaZai_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jiaZai_text.setText("正在加载,请稍后...");
            }
        });
        listView.setEmptyView(linearLayout);
        return v;
    }


}

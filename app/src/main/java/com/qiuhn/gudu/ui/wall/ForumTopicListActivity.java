package com.qiuhn.gudu.ui.wall;

import android.os.Bundle;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.qiuhn.gudu.R;
import com.qiuhn.gudu.common.URLConstants;
import com.qiuhn.gudu.common.volley.GsonRequest;
import com.qiuhn.gudu.domain.ForumTopic;
import com.qiuhn.gudu.pojo.ForumTopicPojo;
import com.qiuhn.gudu.response.ForumTopicListResponse;
import com.qiuhn.gudu.ui.base.CustomTitleActivity;
import com.qiuhn.gudu.ui.wall.adapter.ToplicAdapter;

import java.util.List;

import butterknife.Bind;

/**
 * Created by qiuhn on 2015/11/20.
 */
public class ForumTopicListActivity extends CustomTitleActivity {

    @Bind(R.id.lv_topic_list)
    PullToRefreshListView mListView;

    private List<ForumTopic> mTopicList;

    private BaseAdapter mAdapter;

    private RequestQueue mRequestQueue;

    private long userid;

    private long latestTime;

    private static int pageSize=20;

    private int timeCount;

    private void loadData(){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAdapter = new ToplicAdapter();
        mListView.setAdapter(mAdapter);
        mListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {

            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {

            }
        });
        mRequestQueue = Volley.newRequestQueue(this);

        GsonRequest<ForumTopicListResponse> gsonRequest = new GsonRequest<>(URLConstants.getForumTopicListURL(userid,latestTime,timeCount,pageSize),
                ForumTopicListResponse.class, new Response.Listener<ForumTopicListResponse>() {
            @Override
            public void onResponse(ForumTopicListResponse response) {
                if(response.getCode() == 1){
                    List<ForumTopicPojo> forumTopicPojos = response.getObj();


                }else{

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        mRequestQueue.add(gsonRequest);
    }
}

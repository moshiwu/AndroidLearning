package com.example.app2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by moqiaowen on 2017/11/7.
 */

public class NewsTitleFragment extends Fragment {
    private boolean isTwoPane;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.news_title_frag, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.news_title_recycler_view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());

        recyclerView.setLayoutManager(layoutManager);

        NewsAdapter adapter = new NewsAdapter(getNews());

        recyclerView.setAdapter(adapter);


        return view;
    }


    protected List<News> getNews() {
        List<News> list = new ArrayList<News>();

        for (int i = 0; i < 50; i++) {
            News news = new News();
            news.setTitle("This is title " + i);
            news.setContent("This is Content " + i);

            list.add(news);
        }

        return list;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (getActivity().findViewById(R.id.news_content_fragment) != null) {
            isTwoPane = true;
        } else {
            isTwoPane = false;
        }
    }


    class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {


        private static final String TAG = "NewsAdapter";
        private List<News> mNewsList;

        public NewsAdapter(List<News> list) {
            mNewsList = list;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


            Log.d(TAG, "onCreateViewHolder");
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item, parent, false);

            final ViewHolder holder = new ViewHolder(view);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    News news = mNewsList.get(holder.getLayoutPosition());
                    if (isTwoPane) {
                        NewsContentFragment newsContentFragment = (NewsContentFragment) getFragmentManager().findFragmentById(R.id.news_content_fragment);
                        newsContentFragment.refresh(news.getTitle(), news.getContent());
                    } else {
                        NewsContentActivity.actionStart(getActivity(), news.getTitle(), news.getContent());
                    }
                }
            });
            return holder;
        }


        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            News news = mNewsList.get(position);
            holder.newsTitleText.setText(news.getTitle());
        }

        @Override
        public int getItemCount() {
            return mNewsList.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {


            TextView newsTitleText;

            public ViewHolder(View itemView) {
                super(itemView);

                newsTitleText = itemView.findViewById(R.id.news_title);
            }
        }
    }
}

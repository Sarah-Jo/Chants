package com.example.sarah.listview;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by sarah on 08/12/15.
 */
public class CustomPagerAdapter extends PagerAdapter {

    private Context mContext;
    private List<ListItem> listItems;

    public CustomPagerAdapter(Context mContext, List<ListItem> listItems) {
        this.mContext = mContext;
        this.listItems = listItems;

    }

    @Override
    public int getCount() {
        return listItems.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == (RelativeLayout)object;
    }

    @Override
    public Object instantiateItem(ViewGroup collection, int position) {
        ListItem listItem = listItems.get(position);
        TextView lyricView;

        LayoutInflater inflater = LayoutInflater.from(mContext);
        ViewGroup layout = (ViewGroup) inflater.inflate(R.layout.activity_song, collection, false);
        lyricView = (TextView)layout.findViewById(R.id.song1);
        lyricView.setText(listItem.getLyrics());

        collection.addView(layout);
        return layout;
    }

    @Override
    public void destroyItem(ViewGroup collection, int position, Object view) {
        collection.removeView((View) view);
    }

}

package com.example.android.musicalapp;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class CustomFragmentPagerAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public CustomFragmentPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if(position == 0) {
            return new PlaylistFragment();
        }
        else if(position == 1){
            return new TracksFragment();
        }
        else {
            return new GenresFragment();
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if(position == 0){
            return mContext.getString(R.string.playlists);
        } else if(position == 1){
            return mContext.getString(R.string.tracks);
        } else {
            return mContext.getString(R.string.genres);
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}

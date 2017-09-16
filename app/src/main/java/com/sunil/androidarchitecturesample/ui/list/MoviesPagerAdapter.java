package com.sunil.androidarchitecturesample.ui.list;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by sunil on 16-09-2017.
 */

public class MoviesPagerAdapter extends FragmentStatePagerAdapter {

    private static final String[] titles = new String[]{"Popular", "Science", "Comedy"};

    public MoviesPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return MovieListFragment.newInstance();
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}

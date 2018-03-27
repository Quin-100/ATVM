package com.atvm.esssquad;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.atvm.esssquad.Fragments.CentralFragment;
import com.atvm.esssquad.Fragments.HarbourFragment;
import com.atvm.esssquad.Fragments.WesternFragment;

/**
 * Created by M.Qasim on 12-09-2017.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if (position == 0)
        {
            fragment = new WesternFragment();
        }
        else if (position == 1)
        {
            fragment = new CentralFragment();
        }
        else if (position == 1)
        {
            fragment = new HarbourFragment();
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        if (position == 0)
        {
            title = "Western";
        }
        else if (position == 1)
        {
            title = "Central";
        }
        else if (position == 2)
        {
            title = "Harbour";
        }
        return title;
    }
}

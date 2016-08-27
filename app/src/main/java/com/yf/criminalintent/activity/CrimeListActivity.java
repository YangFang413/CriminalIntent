package com.yf.criminalintent.activity;

import android.support.v4.app.Fragment;

import com.yf.criminalintent.fragment.CrimeListFragment;

/**
 * Created by Administrator on 2016/8/24.
 */
public class CrimeListActivity extends SingleFragmentActicity {

    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}

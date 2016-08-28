package com.yf.criminalintent.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;

import com.yf.criminalintent.R;
import com.yf.criminalintent.fragment.CrimeFragment;
import com.yf.criminalintent.fragment.CrimeListFragment;
import com.yf.criminalintent.model.Crime;

/**
 * Created by Administrator on 2016/8/24.
 */
public class CrimeListActivity extends SingleFragmentActicity implements CrimeListFragment.Callbacks, CrimeFragment.Callbacks {

    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_masterdetail;
    }

    @Override
    public void onCrimeSelected(Crime crime) {
        if (findViewById(R.id.detail_fragment_container) == null){
            Intent intent = CrimePagerActivity.newIntent(this, crime.getId());
            startActivity(intent);
        } else {
            Fragment newDetail = CrimeFragment.newInstance(crime.getId());
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.detail_fragment_container, newDetail)
                    .commit();
        }
    }

    public void onCrimeUpdated(Crime crime){
        CrimeListFragment listFragment = (CrimeListFragment)
                getSupportFragmentManager().findFragmentById(R.id.frangment_container);
        listFragment.updateUI();
    }
}

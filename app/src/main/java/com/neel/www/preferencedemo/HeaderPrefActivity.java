package com.neel.www.preferencedemo;

import android.preference.PreferenceActivity;

import java.util.List;

/**
 * Created by Nilesh Shinde on 07-06-2016.
 */
public class HeaderPrefActivity extends PreferenceActivity
{
    @Override
    public void onBuildHeaders(List<Header> target) {
        super.onBuildHeaders(target);
        loadHeadersFromResource(R.xml.prefernce_header, target);

    }
}

package com.neel.www.preferencedemo;

import android.os.Bundle;
import android.preference.PreferenceFragment;

/**
 * Created by Nilesh Shinde on 07-06-2016.
 */
public class SettingpartFragment extends PreferenceFragment
{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String settings = getArguments().getString("party");
        if ("part2".equals(settings)) {
            addPreferencesFromResource(R.xml.settings);
        } else
        {
            addPreferencesFromResource(R.xml.settingstwo);
        }
    }


    protected boolean isValidFragment(String fragmentName) {
        return SettingpartFragment.class.getName().equals(fragmentName);
    }

}

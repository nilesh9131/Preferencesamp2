package com.neel.www.preferencedemo;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by Nilesh Shinde on 07-06-2016.
 */
public class FragmentActivty extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Display the fragment as the main content.
        getFragmentManager().beginTransaction()
                .replace(android.R.id.content, new SettingFragment())
                .commit();
    }

}

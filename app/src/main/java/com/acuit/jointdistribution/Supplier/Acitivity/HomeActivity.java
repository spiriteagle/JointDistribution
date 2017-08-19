package com.acuit.jointdistribution.Supplier.Acitivity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.acuit.jointdistribution.Common.Base.BaseActivity;
import com.acuit.jointdistribution.R;
import com.acuit.jointdistribution.Supplier.Fragment.ContentFragment;

public class HomeActivity extends BaseActivity {

    private static final String FRAG_CONTENT = "frag_content";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initFragment();

    }

    private void initFragment() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fl_main, new ContentFragment(HomeActivity.this));
        ft.commit();

    }
    public ContentFragment getContentFragment() {
        FragmentManager fm = getSupportFragmentManager();
        ContentFragment fragment = (ContentFragment) fm.findFragmentByTag(FRAG_CONTENT);
        return fragment;
    }


}

package me.riddhimanadib.library;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class BottomBarHolderActivity extends AppCompatActivity implements BottomNavigationBar.BottomNavigationMenuClickListener {

    private BottomNavigationBar mBottomNav;

    private List<Fragment> mFragmentList = new ArrayList<>();
    private List<String> mNavBarItemTitle = new ArrayList<>();
    private List<Drawable> mNavBarItemIcon = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_bar_holder);
    }

    public void setupBottomBarHolderActivity(List<Fragment> fragments, List<String> titles, List<Drawable> icons) {
        mFragmentList = fragments;
        mNavBarItemTitle = titles;
        mNavBarItemIcon = icons;

        mBottomNav = new BottomNavigationBar(this, titles, icons, this);
        setupFragments();
    }

    private void setupFragments() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, mFragmentList.get(0));
        fragmentTransaction.commit();
    }

    @Override
    public void onClickedOnBottomNavigationMenu(int menuType) {
        Fragment fragment = null;
        switch (menuType) {
            case BottomNavigationBar.MENU_BAR_1:
                fragment = mFragmentList.get(0);
                break;
            case BottomNavigationBar.MENU_BAR_2:
                fragment = mFragmentList.get(1);
                break;
            case BottomNavigationBar.MENU_BAR_3:
                fragment = mFragmentList.get(2);
                break;
            case BottomNavigationBar.MENU_BAR_4:
                fragment = mFragmentList.get(3);
                break;
        }
        if (fragment != null) {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frameLayout, fragment);
            fragmentTransaction.commit();
        }
    }
}

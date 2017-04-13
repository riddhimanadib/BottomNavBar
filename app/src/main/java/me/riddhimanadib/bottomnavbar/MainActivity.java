package me.riddhimanadib.bottomnavbar;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import me.riddhimanadib.library.BottomBarHolderActivity;

public class MainActivity extends BottomBarHolderActivity implements FirstFragment.OnFragmentInteractionListener, SecondFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(FirstFragment.newInstance());
        fragmentList.add(SecondFragment.newInstance());
        fragmentList.add(ThirdFragment.newInstance());
        fragmentList.add(FourthFragment.newInstance());

        List<String> titleList = new ArrayList<>();
        titleList.add("Home");
        titleList.add("Support");
        titleList.add("Billing");
        titleList.add("Profile");

        List<Drawable> iconList = new ArrayList<>();
        iconList.add(ContextCompat.getDrawable(this, R.drawable.ic_home_black_24dp));
        iconList.add(ContextCompat.getDrawable(this, R.drawable.ic_mail_black_24dp));
        iconList.add(ContextCompat.getDrawable(this, R.drawable.ic_assessment_black_24dp));
        iconList.add(ContextCompat.getDrawable(this, R.drawable.ic_person_black_24dp));

        super.setupBottomBarHolderActivity(fragmentList, titleList, iconList);
    }

    @Override
    public void onClicked() {
        Toast.makeText(this, "Clicked!", Toast.LENGTH_SHORT).show();
    }
}
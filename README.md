Bottom-Nav-Bar
==================

> Easily add four tabbed bottom navigation bar in your app.

![](https://github.com/adib2149/BottomNavBar/blob/master/screenshot/screenshot.gif)

This library aids in adding four tabs in Bottom Navigation Bar, as easily and fast as possible. Th result looks like as it is commonly found in most of the apps, like Quora and others.


Difference from Official [Bottom Navigation View](https://material.io/guidelines/components/bottom-navigation.html)
-----------------
- This library is significantly different from what Google has provided for Android Developers. The official Bottom Navigation View from Google doesn't show text when it has 4 tabs.

![](https://github.com/adib2149/BottomNavBar/blob/master/screenshot/official_bottom_nav_bar.jpg)

- this library helps you add icons and texts with four bottom bars very easily and efficiently, where all stays visisble all the time, just like this one here:

![](https://github.com/adib2149/BottomNavBar/blob/master/screenshot/quora.jpg)

Features
-----------------
- Easily add four tabbed bottom navigation bar with minimal code
- changes color based on accent


Installation
-----------------
Add this in your app's **build.gradle** file:
```
compile 'me.riddhimanadib.bottom-nav-bar:bottom-nav-bar:1.0.1'
```


How to use
-----------------
1. Create four fragments (fragment with appcompat v4) with layouts and method to create new instance.

``` 'java'
public class SampleFragment extends Fragment{

    public static FourthFragment newInstance() {
        return new FourthFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sample, container, false);
    }

}
```
2. Make your activity extend **BottomBarHolderActivity**
``` 'java'
public class MainActivity extends BottomBarHolderActivity
```
3. Clear out setContentView() method and add the following:
``` 'java'
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // remove this: setContentView(R.layout.activity_main);

        // four navigation pages that would be displayed as four tabs
        // contains title, icon and fragment instance
        NavigationPage page1 = new NavigationPage("Home", ContextCompat.getDrawable(this, R.drawable.ic_home_black_24dp), FirstFragment.newInstance());
        NavigationPage page2 = new NavigationPage("Support", ContextCompat.getDrawable(this, R.drawable.ic_mail_black_24dp), SecondFragment.newInstance());
        NavigationPage page3 = new NavigationPage("Billing", ContextCompat.getDrawable(this, R.drawable.ic_assessment_black_24dp), ThirdFragment.newInstance());
        NavigationPage page4 = new NavigationPage("Profile", ContextCompat.getDrawable(this, R.drawable.ic_person_black_24dp), FourthFragment.newInstance());

        // add them in a list
        List<NavigationPage> navigationPages = new ArrayList<>();
        navigationPages.add(page1);
        navigationPages.add(page2);
        navigationPages.add(page3);
        navigationPages.add(page4);

        // pass them to super method
        super.setupBottomBarHolderActivity(navigationPages);
    }
```
4. Now build and run!!

Change accent color
-----------------
If you want to change the colors, just override the colors in your **colors.xml** file:
```'xml'
<color name="colorBackground">#F8F8F8</color>
<color name="colorNavAccentSelected">#9D0E15</color>
<color name="colorNavAccentUnselected">#727272</color>
```


License
-----------------
This Library is released under the [Apache License, Version 2.0](http://www.apache.org/licenses/LICENSE-2.0).

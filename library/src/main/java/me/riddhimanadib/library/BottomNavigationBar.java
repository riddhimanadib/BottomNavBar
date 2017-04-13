package me.riddhimanadib.library;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adib on 13-Apr-17.
 */

public class BottomNavigationBar implements View.OnClickListener {

    public static final int MENU_BAR_1 = 0;
    public static final int MENU_BAR_2 = 1;
    public static final int MENU_BAR_3 = 2;
    public static final int MENU_BAR_4 = 3;

    private List<String> mNavBarItemTitle = new ArrayList<>();
    private List<Drawable> mNavBarItemIcon = new ArrayList<>();

    private Context mContext;
    private AppCompatActivity mActivity;
    private BottomNavigationMenuClickListener mListener;

    private LinearLayout mLLBar1, mLLBar2, mLLBar3, mLLBar4;
    private View mViewBar1, mViewBar2, mViewBar3, mViewBar4;
    private AppCompatImageView mImageViewBar1, mImageViewBar2, mImageViewBar3, mImageViewBar4;
    private AppCompatTextView mTextViewBar1, mTextViewBar2, mTextViewBar3, mTextViewBar4;

    public BottomNavigationBar(Context mContext, List<String> titles, List<Drawable> icons, BottomNavigationMenuClickListener listener) {
        this.mContext = mContext;
        this.mActivity = (AppCompatActivity) mContext;
        this.mListener = listener;
        this.mNavBarItemTitle = titles;
        this.mNavBarItemIcon = icons;

        this.mLLBar1 = (LinearLayout) mActivity.findViewById(R.id.linearLayoutBar1);
        this.mLLBar2 = (LinearLayout) mActivity.findViewById(R.id.linearLayoutBar2);
        this.mLLBar3 = (LinearLayout) mActivity.findViewById(R.id.linearLayoutBar3);
        this.mLLBar4 = (LinearLayout) mActivity.findViewById(R.id.linearLayoutBar4);

        this.mViewBar1 = (View) mActivity.findViewById(R.id.viewBar1);
        this.mViewBar2 = (View) mActivity.findViewById(R.id.viewBar2);
        this.mViewBar3 = (View) mActivity.findViewById(R.id.viewBar3);
        this.mViewBar4 = (View) mActivity.findViewById(R.id.viewBar4);

        this.mImageViewBar1 = (AppCompatImageView) mActivity.findViewById(R.id.imageViewBar1);
        this.mImageViewBar2 = (AppCompatImageView) mActivity.findViewById(R.id.imageViewBar2);
        this.mImageViewBar3 = (AppCompatImageView) mActivity.findViewById(R.id.imageViewBar3);
        this.mImageViewBar4 = (AppCompatImageView) mActivity.findViewById(R.id.imageViewBar4);

        this.mImageViewBar1.setImageDrawable(icons.get(0));
        this.mImageViewBar2.setImageDrawable(icons.get(1));
        this.mImageViewBar3.setImageDrawable(icons.get(2));
        this.mImageViewBar4.setImageDrawable(icons.get(3));

        this.mTextViewBar1 = (AppCompatTextView) mActivity.findViewById(R.id.textViewBar1);
        this.mTextViewBar2 = (AppCompatTextView) mActivity.findViewById(R.id.textViewBar2);
        this.mTextViewBar3 = (AppCompatTextView) mActivity.findViewById(R.id.textViewBar3);
        this.mTextViewBar4 = (AppCompatTextView) mActivity.findViewById(R.id.textViewBar4);

        this.mTextViewBar1.setText(titles.get(0));
        this.mTextViewBar2.setText(titles.get(1));
        this.mTextViewBar3.setText(titles.get(2));
        this.mTextViewBar4.setText(titles.get(3));

        this.mLLBar1.setOnClickListener(this);
        this.mLLBar2.setOnClickListener(this);
        this.mLLBar3.setOnClickListener(this);
        this.mLLBar4.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        setView(view);

        if (view.getId() == R.id.linearLayoutBar1) {
            mListener.onClickedOnBottomNavigationMenu(MENU_BAR_1);
            return;
        } else if (view.getId() == R.id.linearLayoutBar2) {
            mListener.onClickedOnBottomNavigationMenu(MENU_BAR_2);
            return;
        } else if (view.getId() == R.id.linearLayoutBar3) {
            mListener.onClickedOnBottomNavigationMenu(MENU_BAR_3);
            return;
        } else if (view.getId() == R.id.linearLayoutBar4) {
            mListener.onClickedOnBottomNavigationMenu(MENU_BAR_4);
            return;
        } else {
            return;
        }

    }

    private void setView(View view) {
        this.mViewBar1.setVisibility(View.INVISIBLE);
        this.mViewBar2.setVisibility(View.INVISIBLE);
        this.mViewBar3.setVisibility(View.INVISIBLE);
        this.mViewBar4.setVisibility(View.INVISIBLE);

        this.mImageViewBar1.setColorFilter(ContextCompat.getColor(mContext, R.color.colorNavAccentUnselected));
        this.mImageViewBar2.setColorFilter(ContextCompat.getColor(mContext, R.color.colorNavAccentUnselected));
        this.mImageViewBar3.setColorFilter(ContextCompat.getColor(mContext, R.color.colorNavAccentUnselected));
        this.mImageViewBar4.setColorFilter(ContextCompat.getColor(mContext, R.color.colorNavAccentUnselected));

        this.mTextViewBar1.setTextColor(ContextCompat.getColor(mContext, R.color.colorNavAccentUnselected));
        this.mTextViewBar2.setTextColor(ContextCompat.getColor(mContext, R.color.colorNavAccentUnselected));
        this.mTextViewBar3.setTextColor(ContextCompat.getColor(mContext, R.color.colorNavAccentUnselected));
        this.mTextViewBar4.setTextColor(ContextCompat.getColor(mContext, R.color.colorNavAccentUnselected));

        if (view.getId() == R.id.linearLayoutBar1) {
            this.mViewBar1.setVisibility(View.VISIBLE);
            this.mImageViewBar1.setColorFilter(ContextCompat.getColor(mContext, R.color.colorNavAccentSelected));
            this.mTextViewBar1.setTextColor(ContextCompat.getColor(mContext, R.color.colorNavAccentSelected));
            return;
        } else if (view.getId() == R.id.linearLayoutBar2) {
            this.mViewBar2.setVisibility(View.VISIBLE);
            this.mImageViewBar2.setColorFilter(ContextCompat.getColor(mContext, R.color.colorNavAccentSelected));
            this.mTextViewBar2.setTextColor(ContextCompat.getColor(mContext, R.color.colorNavAccentSelected));
            return;
        } else if (view.getId() == R.id.linearLayoutBar3) {
            this.mViewBar3.setVisibility(View.VISIBLE);
            this.mImageViewBar3.setColorFilter(ContextCompat.getColor(mContext, R.color.colorNavAccentSelected));
            this.mTextViewBar3.setTextColor(ContextCompat.getColor(mContext, R.color.colorNavAccentSelected));
            return;
        } else if (view.getId() == R.id.linearLayoutBar4) {
            this.mViewBar4.setVisibility(View.VISIBLE);
            this.mImageViewBar4.setColorFilter(ContextCompat.getColor(mContext, R.color.colorNavAccentSelected));
            this.mTextViewBar4.setTextColor(ContextCompat.getColor(mContext, R.color.colorNavAccentSelected));
            return;
        } else {
            return;
        }

    }

    public interface BottomNavigationMenuClickListener {
        void onClickedOnBottomNavigationMenu(int menuType);
    }

}

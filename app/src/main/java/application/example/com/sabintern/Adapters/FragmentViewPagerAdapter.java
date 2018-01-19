package application.example.com.sabintern.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

import java.util.HashMap;

import application.example.com.sabintern.Fragments.DiscussionFragment;
import application.example.com.sabintern.Fragments.QuizzesFragment;
import application.example.com.sabintern.Fragments.VideosFragment;

/**
 * Created by Dell on 04-01-2018.
 */

public class FragmentViewPagerAdapter extends FragmentStatePagerAdapter {
    String[] mTitles;
    HashMap<Integer, Fragment> mPageReferenceMap;
    public FragmentViewPagerAdapter(FragmentManager fm, String[] mTitles) {
        super(fm);
        this.mTitles = mTitles;
        mPageReferenceMap = new HashMap<Integer, Fragment>();
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                VideosFragment videosFragment = VideosFragment.newInstance();
                mPageReferenceMap.put(position, videosFragment);
                return videosFragment;
            case 1:
                QuizzesFragment quizzesFragment =  QuizzesFragment.newInstance();
                mPageReferenceMap.put(position, quizzesFragment);
                return quizzesFragment;
            case 2:
                DiscussionFragment discussionFragment =  DiscussionFragment.newInstance();
                mPageReferenceMap.put(position, discussionFragment);
                return discussionFragment;

        }

        VideosFragment videosFragment = VideosFragment.newInstance();
        mPageReferenceMap.put(position, videosFragment);
        return videosFragment;

    }

    public Fragment getFragment(int position) {
        return mPageReferenceMap.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
        mPageReferenceMap.remove(position);
    }

    @Override
    public int getCount() {
        return (mTitles == null) ? 0 : mTitles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }
}


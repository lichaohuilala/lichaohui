package base;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by lichaohui on 2017/4/10.
 */

public class Myadapter extends FragmentPagerAdapter {
    private  String [] src;
    private List<Fragment> mFragment;

    public Myadapter(FragmentManager fm, String[] src, List<Fragment> fragment) {
        super(fm);
        this.src = src;
        mFragment = fragment;
    }

    public Myadapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragment.get(position);
    }

    @Override
    public int getCount() {
        return mFragment.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return src[position%src.length];
    }
}

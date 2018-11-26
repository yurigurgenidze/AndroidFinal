package yuri.gurgenidze.ge.finalproject.main;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import yuri.gurgenidze.ge.finalproject.R;
import yuri.gurgenidze.ge.finalproject.main.assets.AssetsFragment;
import yuri.gurgenidze.ge.finalproject.main.card.CardFragment;
import yuri.gurgenidze.ge.finalproject.main.history.HistoryFragment;
import yuri.gurgenidze.ge.finalproject.main.profile.ProfileFragment;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    Context context;

    public ViewPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int i) {
        if (i == 0){
            return ProfileFragment.newInstance();
        } else if (i == 1){
            return AssetsFragment.newInstance();
        } else if (i == 2) {
            return HistoryFragment.newInstance();
        } else {
            return CardFragment.newInstance();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0){
            return this.context.getResources().getString(R.string.profileTabTitle);
        } else if (position == 1){
            return this.context.getResources().getString(R.string.assetsTabTitle);
        } else if (position == 2){
            return this.context.getResources().getString(R.string.transactionHistoryTitle);
        } else {
            return this.context.getResources().getString(R.string.cardsTabTitle);
        }
    }
}

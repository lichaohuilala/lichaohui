package com.example.app3;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.xutils.x;

import base.Url;
import base.XUtils;
import xlistview.bawei.com.xlistviewlibrary.XListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1 extends Fragment {

    private XListView mXlistview;

    public Fragment getfragment(String src){
        Fragment1 fragment1 = new Fragment1();
        Bundle bundle = new Bundle();
        bundle.putString("key",src);
        fragment1.setArguments(bundle);
        return  fragment1;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View inflate = inflater.inflate(R.layout.fragment_fragment1, container, false);
        mXlistview = (XListView) inflate.findViewById(R.id.mlistview);
        return inflate;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        x.view().inject(getActivity());
        Bundle arguments = getArguments();
        String key = arguments.getString("key");

        XUtils xUtils = new XUtils();
        xUtils.addutis(Url.path,key,mXlistview,getActivity());
//        xUtils.addutis(Url.path);


    }
}

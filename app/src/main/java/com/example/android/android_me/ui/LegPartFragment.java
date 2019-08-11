package com.example.android.android_me.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

import java.util.List;

public class LegPartFragment extends Fragment {

    private List<Integer> mLegImageIds;
    private int mLegIndex;

    public LegPartFragment() {
        //no instance
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_leg_part, container, false);
        ImageView ivLegPart = rootView.findViewById(R.id.iv_leg_part);
        ivLegPart.setImageResource(AndroidImageAssets.getLegs().get(0));

        return rootView;
    }

    public void setmLegImageIds(List<Integer> mLegImageIds) {
        this.mLegImageIds = mLegImageIds;
    }

    public void setmLegIndex(int mLegIndex) {
        this.mLegIndex = mLegIndex;
    }
}

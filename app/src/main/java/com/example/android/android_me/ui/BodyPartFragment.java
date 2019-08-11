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

public class BodyPartFragment extends Fragment {

    private List<Integer> mBodyImageIds;
    private int mBodyIndex;

    public BodyPartFragment() {
        //no instance
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_body_part, container, false);
        ImageView ivLegPart = rootView.findViewById(R.id.iv_body_part);
        ivLegPart.setImageResource(mBodyIndex);
        return rootView;
    }

    public void setmBodyImageIds(List<Integer> mBodyImageIds) {
        this.mBodyImageIds = mBodyImageIds;
    }

    public void setmBodyIndex(int mBodyIndex) {
        this.mBodyIndex = mBodyIndex;
    }
}

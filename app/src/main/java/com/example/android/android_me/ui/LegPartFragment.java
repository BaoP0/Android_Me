package com.example.android.android_me.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

import java.util.ArrayList;
import java.util.List;

public class LegPartFragment extends Fragment {

    private static final String TAG = "LegPartFragment";

    private static final String IMG_LIST = "ImageIds";
    private static final String LIST_INDEX = "ListIndex";

    private List<Integer> mImageIds;
    private int mListIndex;

    public LegPartFragment() {
        //no instance
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_leg_part, container, false);

        if (savedInstanceState != null) {
            mImageIds =  savedInstanceState.getIntegerArrayList(IMG_LIST);
            mListIndex = savedInstanceState.getInt(LIST_INDEX);
        }

        final ImageView imageView = rootView.findViewById(R.id.iv_leg_part);
        if (mImageIds != null) {
            imageView.setImageResource(mImageIds.get(mListIndex));
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListIndex < mImageIds.size() - 1) {
                        mListIndex++;
                    } else {
                        mListIndex = 0;
                    }
                    imageView.setImageResource(mImageIds.get(mListIndex));
                }
            });
        } else {
            Log.v(TAG, "This fragment has a null list of image id's");
        }

        return rootView;
    }

    public void setImageIds(List<Integer> imageIds) {
        this.mImageIds = imageIds;
    }

    public void setListIndex(int index) {
        mListIndex = index;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putIntegerArrayList(IMG_LIST, (ArrayList<Integer>) mImageIds);
        outState.putInt(LIST_INDEX,mListIndex);
    }
}

/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  	http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.android_me.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
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


public class HeadPartFragment extends Fragment {

    // TODO (1) Create a setter method and class variable to set and store of a list of image resources
    private List<Integer> mImageIds;
    private static final String TAG = "HeadPartFragment";

    private static final String IMG_LIST = "ImageIds";
    private static final String LIST_INDEX = "ListIndex";

    // TODO (2) Create another setter method and variable to track and set the index of the list item to display
    // ex. index = 0 is the first image id in the given list , index 1 is the second, and so on
    private int mListIndex;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the fragment
     */
    public HeadPartFragment() {
    }

    /**
     * Inflates the fragment layout file and sets the correct resource for the image to display
     */
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the Android-Me fragment layout
        View rootView = inflater.inflate(R.layout.fragment_head_part, container, false);

        // Get a reference to the ImageView in the fragment layout
        final ImageView imageView = rootView.findViewById(R.id.iv_head_part);

        if (savedInstanceState != null) {
            mImageIds =  savedInstanceState.getIntegerArrayList(IMG_LIST);
            mListIndex = savedInstanceState.getInt(LIST_INDEX);
        }
        // Set the image to the first in our list of head images

        // TODO (3) If a list of image ids exists, set the image resource to the correct item in that list
        // Otherwise, create a Log statement that indicates that the list was not found

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
        // Return the rootView
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

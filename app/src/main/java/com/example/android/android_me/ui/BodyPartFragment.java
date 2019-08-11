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

import java.util.List;

public class BodyPartFragment extends Fragment {
    private List<Integer> mImageIds;
    // Tag for logging
    private static final String TAG = "BodyPartFragment";
        // ex. index = 0 is the first image id in the given list , index 1 is the second, and so on
    // Variables to store a list of image resources and the index of the image that this fragment displays

    private int mListIndex;

    public BodyPartFragment() {
        //no instance
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_body_part, container, false);
        // Get a reference to the ImageView in the fragment layout
        ImageView imageView = (ImageView) rootView.findViewById(R.id.iv_body_part);

        // Set the image to the first in our list of head images

        // TODO (3) If a list of image ids exists, set the image resource to the correct item in that list
        // Otherwise, create a Log statement that indicates that the list was not found

        // If a list of image ids exists, set the image resource to the correct item in that list
        // Otherwise, create a Log statement that indicates that the list was not found
        if(mImageIds != null){
            // Set the image resource to the list item at the stored index
            imageView.setImageResource(mImageIds.get(mListIndex));

            // TODO (1) Set a click listener on the image view and on a click increment the list index and set the image resource
            // TODO (2) If you reach the end of a list of images, set the list index back to 0 (the first item in the list)

        } else {
            Log.v(TAG, "This fragment has a null list of image id's");
        }
        return rootView;
    }
    // Setter methods for keeping track of the list images this fragment can display and which image
    // in the list is currently being displayed

    public void setImageIds(List<Integer> imageIds) {
        mImageIds = imageIds;
    }

    public void setListIndex(int index) {
        mListIndex = index;
    }

    // TODO (4) Override onSaveInstanceState and save the current state of this fragment
}

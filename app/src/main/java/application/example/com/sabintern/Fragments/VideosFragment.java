package application.example.com.sabintern.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import application.example.com.sabintern.R;

/**
 * Created by Dell on 04-01-2018.
 */

public class VideosFragment extends Fragment {

    public static VideosFragment newInstance(){
        VideosFragment fragment = new VideosFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_videos, container, false);
        return view;
    }
}

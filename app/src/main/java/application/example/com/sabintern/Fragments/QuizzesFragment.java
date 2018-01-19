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

public class QuizzesFragment extends Fragment {

    public static QuizzesFragment newInstance(){
        QuizzesFragment fragment = new QuizzesFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_quizzes, container, false);
        return view;
    }
}

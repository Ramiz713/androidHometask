package com.homework.hometask1;


import android.app.FragmentManager;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MessageFragment extends Fragment {

    public static MessageFragment newInstance() {
        return new MessageFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_message, container, false);
    }

    public void onBackPressed() {
        FragmentManager fm = getActivity().getFragmentManager();
        if (fm.getBackStackEntryCount() > 0)
            fm.popBackStack();
    }
}

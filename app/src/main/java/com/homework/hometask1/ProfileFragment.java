package com.homework.hometask1;


import android.app.DialogFragment;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.app.FragmentManager;


public class ProfileFragment extends Fragment {

    private TextView tvLogin;
    private TextView tvEmail;

    public static ProfileFragment newInstance() {
        return new ProfileFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        view.findViewById(R.id.btn_edit).setOnClickListener(v -> {
            EditDialog dialog = new EditDialog();
            dialog.show(getFragmentManager(), "dialog");
        });
        return view;
    }
}

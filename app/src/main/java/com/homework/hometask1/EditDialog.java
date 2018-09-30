package com.homework.hometask1;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

public class EditDialog extends DialogFragment {

    private EditText login;
    private EditText email;
    private OnFieldsFill listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainActivity) {
            listener = (OnFieldsFill) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFieldsFill");
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_edit, null);
        login = view.findViewById(R.id.et_login);
        email = view.findViewById(R.id.et_email);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        return builder
                .setView(view)
                .setTitle("Задать данные")
                .setIcon(android.R.drawable.ic_menu_edit)
                .setMessage("Для принятия данных нажмите ОК")
                .setPositiveButton("OK", (dialog, which) -> {
                    listener.onOkClick(login.getText().toString(), email.getText().toString());
                })
                .setNegativeButton("Отмена", null)
                .create();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    interface OnFieldsFill {
        void onOkClick(String login, String email);
    }
}

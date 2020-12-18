package com.ds.novlag.fragment;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import com.ds.novlag.R;
import com.ds.novlag.controller.MainActivity;
import com.ds.novlag.global.Constant;

public class LoginTabFragment extends Fragment {
    Button btnConnect;
    EditText edtMail, edtPassword;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.login_tab_fragment, container, false);

        btnConnect = (Button) root.findViewById(R.id.btn_connect);
        edtMail = root.findViewById(R.id.edt_email);
        edtPassword = root.findViewById(R.id.edt_password);

        btnConnect.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(ValidateInput()){
                    LoginUser();
                }
            }
        });

        return root;
    }

    private void LoginUser(){
        ValidateInput();
        SharedPreferences sharedPref = getContext().getSharedPreferences(Constant.MY_PREF, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean(Constant.PREF_IS_CONNECT,true);
        editor.apply();
        startActivity(new Intent(getContext(), MainActivity.class));
    }

    boolean ValidateInput(){
        String txtMail = edtMail.getText().toString();

        if(TextUtils.isEmpty(txtMail)) {
            edtMail.setError("Veuillez entrer votre address mail !!");
            edtMail.requestFocus();
            return false;
        }else if (isValidEmail(txtMail)){
            edtMail.setError("Veuillez entrer une address mail valide!!");
            edtMail.requestFocus();
            return false;
        }

        String txtPassword = edtPassword.getText().toString();

        if(TextUtils.isEmpty(txtPassword)) {
            edtPassword.setError("Veuillez entrer votre mot de passe !!");
            edtPassword.requestFocus();
            return false;
        }else if(txtPassword.length()<6){
            edtPassword.setError("Votre mot de passe doit etre superieur a 6 ");
            edtPassword.requestFocus();
            return false;
        }

        return true;
    }

    boolean isValidEmail(CharSequence target) {
        return (!Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }
}

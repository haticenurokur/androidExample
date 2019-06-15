package com.androidexample;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class ExampleFragment extends Fragment {

    @BindView(R.id.tvMessage)
    TextView tvMessage;

    @BindView(R.id.btnChangeText)
    Button btnChangeText;

    @BindView(R.id.btnSecondFragment)
    Button btnSecondFragment;

    private int counter;


    public ExampleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_example, container, false);

        ButterKnife.bind(this,view); // butterknife ile bağlıyor objeleri

        counter = 0;

        return view;
    }

    @OnClick(R.id.btnChangeText)
    public void changeText(){

        ++counter;

        String displayMsg = "Deneme " + counter;

        tvMessage.setText(displayMsg);

    }

    @OnClick(R.id.btnSecondFragment)
    public void openSecondFragment(){

        // Yeni Fragment aşağıdaki 4 satır kod ile açılır

        // Fragmenlarda activity metodu çağırmak için başına getActivity() yazılır.
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, new SecondFragment());
        transaction.addToBackStack(null); // geri dönme stack'ine ekler
        transaction.commitAllowingStateLoss();

    }

}

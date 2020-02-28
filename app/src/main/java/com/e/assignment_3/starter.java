package com.e.assignment_3;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;

import java.util.Objects;


/**
 * A simple {@link Fragment} subclass.
 */
public class starter extends Fragment {


    public starter() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_starter, container, false);

        Button extra_1 = (Button) view.findViewById(R.id.starter_1);
        Button extra_2 = (Button) view.findViewById(R.id.starter_2);
        final CheckBox starter_1 = (CheckBox) view.findViewById(R.id.starter_1);
        final CheckBox starter_2 = (CheckBox) view.findViewById(R.id.starter_2);

        SharedPreferences sharedPreferences = Objects.requireNonNull(getActivity()).getSharedPreferences("user_meal", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();

        extra_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String S_extra = "";
                if (starter_1.isChecked()) {
                    S_extra += "\n";
                    S_extra += starter_1.getText().toString().toLowerCase();
                }
                if (starter_2.isChecked()) {
                    S_extra += "\n";
                    S_extra += starter_2.getText().toString().toLowerCase();
                }
                editor.putString("meals","Dinner starter:\n"+S_extra);
                editor.commit();
            }
        });
        extra_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String S_extra = "";
                if (starter_1.isChecked()) {
                    S_extra += "\n";
                    S_extra += starter_1.getText().toString().toLowerCase();
                }
                if (starter_2.isChecked()) {
                    S_extra += "\n";
                    S_extra += starter_2.getText().toString().toLowerCase();
                }
                editor.putString("meals","Dinner starter:\n"+S_extra);
                editor.commit();
            }
        });
        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @NonNull Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button lunch = view.findViewById(R.id.button_dinner_main_meal);
        lunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_starter_menu_to_dinner_menu);


            }
        });
    }
}

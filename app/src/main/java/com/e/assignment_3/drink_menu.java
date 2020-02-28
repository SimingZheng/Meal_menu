package com.e.assignment_3;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;


/**
 * A simple {@link Fragment} subclass.
 */
public class drink_menu extends Fragment {

    public drink_menu() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("user_meal", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();

        final View view = inflater.inflate(R.layout.fragment_drink_menu, container, false);

        Button extra_1= (Button)view.findViewById(R.id.alcohol_1);
        Button extra_2= (Button)view.findViewById(R.id.alcohol_2);
        Button extra_3= (Button)view.findViewById(R.id.alcohol_3);
        final CheckBox alcohol_1 = (CheckBox) view.findViewById(R.id.alcohol_1);
        final CheckBox alcohol_2 = (CheckBox) view.findViewById(R.id.alcohol_2);
        final CheckBox alcohol_3 = (CheckBox) view.findViewById(R.id.alcohol_3);

        extra_1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String S_extra = "";
                if (alcohol_1.isChecked()) {
                    S_extra += "\n";
                    S_extra += alcohol_1.getText().toString().toLowerCase();
                }
                if (alcohol_2.isChecked()) {
                    S_extra += "\n";
                    S_extra += alcohol_2.getText().toString().toLowerCase();
                }
                if (alcohol_3.isChecked()) {
                    S_extra += "\n";
                    S_extra += alcohol_3.getText().toString().toLowerCase();
                }
                editor.putString("drinks","Drink(s)\n"+S_extra);
                editor.commit();
            }
        });
        extra_2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String S_extra = "";
                if (alcohol_1.isChecked()) {
                    S_extra += "\n";
                    S_extra += alcohol_1.getText().toString().toLowerCase();
                }
                if (alcohol_2.isChecked()) {
                    S_extra += "\n";
                    S_extra += alcohol_2.getText().toString().toLowerCase();
                }
                if (alcohol_3.isChecked()) {
                    S_extra += "\n";
                    S_extra += alcohol_3.getText().toString().toLowerCase();
                }
                editor.putString("drinks", "Drink(s)\n"+S_extra);
                editor.commit();
            }
        });
        extra_3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String S_extra = "";
                if (alcohol_1.isChecked()) {
                    S_extra += "\n";
                    S_extra += alcohol_1.getText().toString().toLowerCase();
                }
                if (alcohol_2.isChecked()) {
                    S_extra += "\n";
                    S_extra += alcohol_2.getText().toString().toLowerCase();
                }
                if (alcohol_3.isChecked()) {
                    S_extra += "\n";
                    S_extra += alcohol_3.getText().toString().toLowerCase();
                }
                editor.putString("drinks","Drink(s)\n"+ S_extra);
                editor.commit();
            }
        });

        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @NonNull Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button lunch = view.findViewById(R.id.button_summary);
        lunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_drink_menu_to_order_summary);


            }
        });
    }
}

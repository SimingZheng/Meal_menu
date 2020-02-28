package com.e.assignment_3;


import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class order_summary extends Fragment {


    String user_meals;
    String user_drinks;

    public order_summary() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("user_meal", Context.MODE_PRIVATE);
        user_meals = sharedPreferences.getString("meals", "Not order meal");
        user_drinks = sharedPreferences.getString("drinks","Not order drink");

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();

        return inflater.inflate(R.layout.fragment_order_summary, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        String summary = user_meals+"\n\n"+user_drinks;
        TextView Summary = view.findViewById(R.id.textView);
        Summary.setText(summary);

        Button lunch = view.findViewById(R.id.botton_home);
        lunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_order_summary_to_home2);
            }
        });
    }
}

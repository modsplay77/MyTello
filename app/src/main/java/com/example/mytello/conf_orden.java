package com.example.mytello;

import static com.example.mytello.R.layout.fragment_conf_orden;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



public class conf_orden extends Fragment {

    private EditText op1;
    private TextView list;
    private Button guardar;



    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(fragment_conf_orden, container, false);
        guardar = view.findViewById(R.id.guardar);
        op1 = view.findViewById(R.id.op1);
        list = view.findViewById(R.id.lista);

        guardar.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view){

                String resultado = op1.getText().toString();
                list.setText(resultado);

            }
        });
        return view;
    }
}
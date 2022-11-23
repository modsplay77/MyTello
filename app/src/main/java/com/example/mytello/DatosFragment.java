package com.example.mytello;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



public class DatosFragment extends Fragment {

    private EditText op1;
    private TextView list;

    public DatosFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_datos, container, false);
        Button guardar = view.findViewById(R.id.guardar);
        op1 = view.findViewById(R.id.op1);
        list = view.findViewById(R.id.list);

        guardar.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view){

                String resultado = op1.getText().toString();
                list.setText(String.valueOf(resultado.length()));

            }
        });
        return view;
    }
}
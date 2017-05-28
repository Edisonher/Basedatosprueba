package com.example.admin.basedatosprueba;


import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

//import com.firebase.client.Firebase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragmentsubir extends Fragment {

    EditText eNombre,eApellido,eTelefono,eDireccion,eBarrio,eCedula, eRClave1, eRClave2, eRCorreo;
    Button bRegistrarse, bCancelar;

    String cedula,nombre,apellido,direccion,barrio, correo, telefono;

    Clientes cliente;

    private String FIREBASE_URL = "https://basesdatos-e899b.firebaseio.com/";
   // private Firebase firebasedatos;

    DatabaseReference myRef;


    public Fragmentsubir() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View inflated = inflater.inflate(R.layout.fragment_fragmentsubir, container, false);

        final FirebaseDatabase database = FirebaseDatabase.getInstance();




        //Firebase.setAndroidContext(this.getContext());
        //firebasedatos = new Firebase(FIREBASE_URL);

        bRegistrarse = (Button) inflated.findViewById(R.id.bRegistrarse);
        bCancelar = (Button) inflated.findViewById(R.id.bCancelar);
        eNombre = (EditText) inflated.findViewById(R.id.eRNombres);
        eApellido = (EditText) inflated.findViewById(R.id.eRApellidos);
        eTelefono = (EditText) inflated.findViewById(R.id.eRTelefono);
        eDireccion = (EditText) inflated.findViewById(R.id.eRDireccion);
        eBarrio = (EditText) inflated.findViewById(R.id.eRBarrio);
        eCedula = (EditText) inflated.findViewById(R.id.eRCedula);

        bRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                cedula = eCedula.getText().toString();
                nombre = eNombre.getText().toString();
                apellido = eApellido.getText().toString();
                telefono = eTelefono.getText().toString();
                direccion = eDireccion.getText().toString();
                barrio = eBarrio.getText().toString();

                Clientes cliente = new Clientes(apellido,barrio,cedula,"",direccion,"",nombre,telefono);
                myRef = database.getReference("clientes").child(cedula);
                myRef.setValue(cliente);
                /*Snackbar.make(view, "Funciona", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
            }
        });

        bCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //.................Eliminar.............
                /*
                cedula = eCedula.getText().toString();
                myRef = database.getReference("clientes").child(cedula);
                myRef.removeValue();*/
                //......................................


                //..................................................................Mostar el contacto
                /* cedula = eCedula.getText().toString();
                database.getReference("clientes").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if(dataSnapshot.child(cedula).exists()){
                            Log.d("CLIENTE", dataSnapshot.child(cedula).getValue().toString());
                        }

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });*/
                //...................................................................................
                //......................................Mostrar en Edittext
                cedula = eCedula.getText().toString();
                database.getReference("clientes").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if(dataSnapshot.child(cedula).exists()){

                            cliente = dataSnapshot.child(cedula).getValue(Clientes.class);
                            eNombre.setText(cliente.getNombre());
                            eApellido.setText(cliente.getApellido());
                            eTelefono.setText(cliente.getTelefono());


                        }

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
                //.............................................................................




            }
        });
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_fragmentsubir, container, false);
        return inflated;
    }


}

package com.g06.bolsa.departamento;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.g06.bolsa.R;


public class DepartamentoMenuActivity extends ListActivity {
    String[] MENU={"Insertar Departamento","Eliminar Departamento","Consultar Departamento","Actualizar Departamento"};

    String[] ACTIVITIES={"DepartamentoInsertarActivity","DepartamentoEliminarActivity","DepartamentoConsultarActivity","DepartamentoActualizarActivity"};

    @Override
    public void onCreate(Bundle savedInstanceState) {super.onCreate(savedInstanceState);
        ListView listView = getListView();
        listView.setBackgroundColor(Color.rgb(75, 50, 75));
        ArrayAdapter<String> adapter = new
                ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, MENU);
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id){
        super.onListItemClick(l, v, position, id);
        String nombreValue=ACTIVITIES[position];
        l.getChildAt(position).setBackgroundColor(Color.rgb(128, 128, 255));
        try{
            Class<?> clase=Class.forName("com.g06.bolsa.departamento." + nombreValue);
            Intent inte = new Intent(this,clase);
            this.startActivity(inte);
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
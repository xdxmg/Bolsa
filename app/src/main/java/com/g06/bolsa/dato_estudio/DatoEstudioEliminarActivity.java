package com.g06.bolsa.dato_estudio;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.g06.bolsa.ControlDBLJ16001;
import com.g06.bolsa.R;
import com.g06.bolsa.clases_auxiliares.DatoEstudio;


public class DatoEstudioEliminarActivity extends Activity {

    ControlDBLJ16001 helper;
    EditText estudioNivel;
    EditText candidatoId;
    EditText  institucionId;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dato_estudio_eliminar);

        // Instancia de la clase que controla la base de datos.
        helper = new ControlDBLJ16001(this);

        // Referencia a los widgets de la interfaz.
        estudioNivel = findViewById(R.id.editEstudiNivel);

    }

    public void eliminar(View v) {
        String regEliminadas;
        DatoEstudio de = new DatoEstudio();
        de.setEstudioNivel(estudioNivel.getText().toString());

        helper.abrir();
        regEliminadas = helper.eliminar(de);
        helper.cerrar();

        Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v) {
        estudioNivel.setText("");
    }

}
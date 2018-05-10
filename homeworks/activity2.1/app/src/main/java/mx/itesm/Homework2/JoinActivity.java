package mx.itesm.Homework2;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class JoinActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        Intent intent = getIntent();

        Toast.makeText(
                this,
                intent.getStringExtra("name") + " " + intent.getIntExtra("prueba", 0),
                Toast.LENGTH_SHORT
        ).show();
    }

    public void regresar(View v){
        // para regresar
        // NO hacer un nuevo intent
        Intent resultado = new Intent();
        setResult(Activity.RESULT_OK, resultado);
        finish();
    }
}

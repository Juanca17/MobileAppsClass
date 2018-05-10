package mx.itesm.localstorage;

import android.content.Context;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class MainActivity extends AppCompatActivity {

    private DBHelper db;
    private EditText studentId, studentName, studentGrade;

    // usando properties - (otra manera de guardar)
    private Properties properties;
    public static final String PROPERTIES_FILE = "properties.xml";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DBHelper(this);
        studentId = (EditText)findViewById(R.id.studentId);
        studentName = (EditText)findViewById(R.id.studentName);
        studentGrade = (EditText)findViewById(R.id.studentGrade);

        properties = new Properties();
        // manejo de properties
        File file = new File(/*dir*/ getFilesDir(), /*name*/ PROPERTIES_FILE);
        try{

            if(file.exists()){

                FileInputStream fis = openFileInput(PROPERTIES_FILE);
                properties.loadFromXML(fis);
                fis.close();

                Toast.makeText(
                        this,
                        "FILE LOADED: " + properties.getProperty("ejemplo"),
                        Toast.LENGTH_SHORT
                ).show();
            } else {

                // create file
                saveProperties();
            }

            // cargar datos al proyecto
            // Assets, Raw
            // Raw - folder de resources
            // - indexado en R
            // - no procesa lo que está adentro
            InputStream is = getResources().openRawResource(R.raw.ejemplo);
            BufferedReader br= new BufferedReader(new InputStreamReader(is));

            String temp = "";
            while((temp = br.readLine()) != null){

                Log.d("RAW", temp);
            }

            AssetManager manager = getAssets();
            is = manager.open("saludos.txt");
            br = new BufferedReader(new InputStreamReader(is));
            while((temp = br.readLine()) != null){
                Log.d("ASSETS", temp);
            }


        }catch (IOException ioe){
            ioe.printStackTrace();
        }



    }

    private void saveProperties() throws IOException{

        FileOutputStream fos = openFileOutput(PROPERTIES_FILE, Context.MODE_PRIVATE);
        properties.storeToXML(fos, null);
        fos.close();
        Toast.makeText(this, "FILE SAVED", Toast.LENGTH_SHORT).show();
    }

    public void insertDb(View v){

        db.save(
                studentName.getText().toString(),
                Integer.parseInt(studentGrade.getText().toString())
        );

        Toast.makeText(this, "SAVING", Toast.LENGTH_SHORT).show();
    }

    public void findDb(View v){
        int result = db.find(studentName.getText().toString());
        studentGrade.setText(result + "");
    }

    public void deleteDb(View v){
        int result = db.delete(Integer.parseInt(studentId.getText().toString()));
        Toast.makeText(this, result + " rows affected.", Toast.LENGTH_SHORT).show();
    }

    public void saveToMemory(View v){
        properties.put("ejemplo", studentName.getText().toString());
        Toast.makeText(this, "SAVED TO MEMORY", Toast.LENGTH_SHORT).show();
    }

    public void saveToFile(View v){

        try {
            saveProperties();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }

        Toast.makeText(this, "SAVED TO FILE", Toast.LENGTH_SHORT).show();
    }
}

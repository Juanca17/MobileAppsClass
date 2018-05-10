package mx.itesm.listviewsspinners;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements
        AdapterView.OnItemClickListener,
        AdapterView.OnItemSelectedListener {

    private ListView listView;
    private Spinner spinner;

    private ArrayList<Student> source2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.listView);
        spinner = (Spinner)findViewById(R.id.spinner);

        // como poblar widgets para colecciones
        // datos - Adapter - widget

        String[] source = {"Hermes", "Alejandro", "Edy", "Sara"};

        // Adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                source
        );

        source2 = new ArrayList<>();

        source2.add(new Student("Marco", 60));
        source2.add(new Student("Marco", 60));
        source2.add(new Student("Marco", 60));
        source2.add(new Student("Marco", 60));
        source2.add(new Student("Marco", 60));
        source2.add(new Student("Marco", 60));
        source2.add(new Student("Marco", 60));
        source2.add(new Student("Marco", 60));
        source2.add(new Student("Miguelito", 30));
        source2.add(new Student("Ponchito", -20));
        source2.add(new Student("Katia", 68));

        StudentAdapter adapter2 = new StudentAdapter(source2, this);

        listView.setAdapter(adapter2);
        spinner.setAdapter(adapter2);

        listView.setOnItemClickListener(this);
        spinner.setOnItemSelectedListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Student selected = source2.get(i);
        Toast.makeText(this, selected.getNombre(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Student selected = source2.get(i);
        Toast.makeText(this, selected.getNombre(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}

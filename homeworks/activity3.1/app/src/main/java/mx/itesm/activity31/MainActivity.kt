package mx.itesm.activity31

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONException
import org.json.JSONArray
import org.json.JSONObject
import android.widget.Toast





class MainActivity : AppCompatActivity(), AdapterView.OnItemClickListener{

    var source: ArrayList<Food> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val jsonTest = "[{'name':'burger', 'price':15, 'description':'a juicy burger!'}," +
                "{'name':'hotdog', 'price':20, 'description':'an ok hot dog'}," +
                "{'name':'tacos', 'price':12, 'description':'some pretty good tacos'}," +
                "{'name':'torta', 'price':22, 'description':'nice torta'}," +
                "{'name':'carne asada', 'price':50, 'description':'a great carne asada'}]"

        try {
            val obj = JSONArray(jsonTest)

            for (i in 0 until obj.length()) {
                val actual = obj.get(i) as JSONObject
                source.add(Food(actual.getString("name"), actual.getString("price"),actual.getString("description")))
            }

        } catch (e: JSONException) {
            e.printStackTrace()
        }

        val adapter = FoodAdapter(this, source)

        listView.adapter = adapter
        listView.onItemClickListener = this

    }

    override fun onItemClick(adapterView: AdapterView<*>?, view: View?, i: Int, l: Long) {
        val selected = source.get(i)
        Toast.makeText(this, selected.description, Toast.LENGTH_SHORT).show()
    }
}

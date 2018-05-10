package mx.itesm.activity31

/**
 * Created by juancasan on 27/04/18.
 */

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.row.view.*

import java.util.ArrayList

/**
 * Created by UXLab on 02/02/18.
 */

class FoodAdapter(context: Context, source: ArrayList<Food>) : BaseAdapter() {

    var source: ArrayList<Food>
    var vi: LayoutInflater

    init {
        this.source = source
        this.vi = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }

    override fun getCount(): Int {
        return source.size
    }

    override fun getItem(i: Int): Any {
        return source[i]
    }

    override fun getItemId(i: Int): Long {
        return i.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
        var retView: View

        if (convertView == null) {
            retView = vi.inflate(R.layout.row, null)
        }
        else {
            retView = convertView
        }

        val nombre = retView.textName
        val price = retView.textPrice

        val actual = source[position]
        nombre.setText(actual.name)
        price.setText(actual.price)

        return retView
    }
}

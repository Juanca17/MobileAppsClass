package mx.itesm.kotlinclass

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imprimirMensaje("hola desde kotlin")

        // inmutable
        val hola = "Esto es un string"

        // mutable
        var hola2 : String = "Tambien string"

        hola2 = "cambia sin problema"

        var numerito : Int
        numerito = 2

        // string templates
        // $ en el string
        // variables - $nombreVariable
        // operaciones - ${lasOperacionesAqui}
        Log.d("SUMITA", "el resultado de la suma ${sumar(2,3)}")

        var francisco = Alumno("Francisco", 30.0f)
        Log.d("PROPIEDAD", francisco.name)
        Log.d("PROPIEDAD", "${francisco.grade}")
        francisco.quejarse()

        var humberto = Alumno("Humberto", 20.0f, 22.0f)
        Log.d("PROPIEDAD",  humberto.name)
        Log.d("PROPIEDAD", "${humberto.grade}")
        humberto.quejarse()

        // null safety
        // los tipos por default NO pueden ser null
        // si es necesario que tenga null se puede hacer nullable
        var poncho: Alumno? = null

        var s:String? = "hola"

        // segundo candado - para acceder a algo nullable se puede comprobar que no sea null
        if(s != null){
            Log.wtf("NO FUE NULL!", "${s.length}")
        }

        // ultima opcion - safe call
        Log.wtf("NO FUE NULL!", "${s?.length}")

        // elvis operator
        // ?:

        var s2 = s?.length ?: -1

        // nullable es un tipo distinto a non-nullable
        var s3 = s!!.length
    }

    // tipo Unit
    private fun imprimirMensaje(mensaje : String) {

        Log.wtf("IMPRIMIENDO", mensaje)
    }

    private fun sumar(a:Int, b:Int) = a + b
}

package mx.itesm.kotlinclass

import android.util.Log

/**
 * Created by UXLab on 20/04/18.
 */

// constructores en kotlin
// - constructor primario
// -- sirve para inicializar propiedades
// -- un constructor que se define como forzoso para la clase
// -- si existe los demas constructores están obligados a invocarlo
// -- no contiene código
// -- puede existir 1 o 0

class Alumno (nombre:String, calificacion:Float) {

    // bloques de inicializacion
    init {
        Log.wtf("INICIALIZANDO", "SI SIRVE")
    }

    var name = nombre
        get() = field
        private set(value){
            field = value
        }

    var grade = calificacion

    var horasDeSueno:Float = 0.0f

    // constructor secundario
    // - funcionalmente muy similar a los que conocemos de java
    // - 0 - n
    // - se llaman "constructor"
    // - si existe el constructor primario estamos OBLIGADOS a invocarlos
    constructor(nombre:String, calificacion:Float, hds: Float) : this(nombre, calificacion){
        horasDeSueno = hds
    }


    fun quejarse() = Log.wtf("QUEJA", "POR QUE ME FUE TAN MAL")
}
package jesus.net.ejemplojsonkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.Gson
import org.json.JSONObject
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    var listaDePersona: ArrayList<Persona>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var respuesta = "{ \"personas\" : [ " +
                "{" +
                " \"nombre\" : \"Marcos\" ," +
                " \"pais\" : \"México\" ," +
                " \"estado\" : \"soltero\" ," +
                " \"experiencia\" : 5}," +

                "{" +
                " \"nombre\" : \"Agustín\" ," +
                " \"pais\" : \"España\" ," +
                " \"estado\" : \"casado\" ," +
                " \"experiencia\" : 16}" +
                " ]" +
                " }"

        // USANDO JSON DE FORMA NATIVA
        /*val json = JSONObject(respuesta)
        val personas = json.getJSONArray("personas")
        listaDePersona = ArrayList()

        for (i in 0..personas.length() - 1) {
            val nombre = personas.getJSONObject(i).getString("nombre")
            val pais = personas.getJSONObject(i).getString("pais")
            val estado = personas.getJSONObject(i).getString("estado")
            val experiencia = personas.getJSONObject(i).getInt("experiencia")

            var persona = Persona(nombre, pais, estado, experiencia)
            listaDePersona?.add(Persona(nombre, pais, estado, experiencia))
            Log.d("JSON", "${persona.nombre}, ${persona.pais}, ${persona.estado}, ${persona.experiencia}")
            Log.d("JSON", "${listaDePersona?.count().toString()}")
        }*/

        // USANDO JSON USANDO LA LIBRERIA GSON
        val gson = Gson()
        val res = gson.fromJson(respuesta, Personas::class.java)
        Log.d("GSON", res.personas?.count().toString())
    }


}

package br.com.consumoapi.services

import br.com.consumoapi.models.Musicas
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.extensions.authentication
import com.github.kittinunf.fuel.json.responseJson
import com.github.kittinunf.result.Result
import com.google.gson.Gson
import com.google.gson.JsonElement
import com.google.gson.JsonParser
import org.json.JSONObject

class ConsumoApi {

    data class ListaDeMusicas(val track: Musicas)
    data class ObjetoComLista(val items: List<ListaDeMusicas>)


    val resultado = mutableListOf<Musicas>()
    fun pegaPlayList(): List<Musicas>{
        val playId: List<String> = listOf("70xjTJhIMWJOlJUzRjoAFQ","6w9u4wWnNyCoSYAFtEJl3x","7vSPWyNfaGn4WF8UUpqb1u")

        for (lista in playId) {
          pegarJson(lista)?.items?.forEach { listaDeMusicas ->
                val track = listaDeMusicas.track
                val name = track.name
                val duration_ms = track.duration_ms

              resultado.add(Musicas(duration_ms, name))
            }
        }
        return resultado
    }

    fun pegarJson(id: String): ObjetoComLista? {
        val url = "https://api.spotify.com/v1/playlists/${id}?fields=tracks.items%28track%28duration_ms%2Cname%29%29"



        val (_, _,result) = Fuel.get(url)
            .authentication()
            .bearer(Autenticar.getToken())
            .responseJson()

        when (result) {
            is Result.Failure -> {
                val ex = result.getException()
                println ("Erro: $ex")
                return null
            }
            is Result.Success -> {
                val json = result.value.obj()
                val tracks = json.getJSONObject("tracks")
                val transform: JsonElement = conversor(tracks)


                val gson = Gson()
                val listaMusica = gson.fromJson(transform,ObjetoComLista::class.java)
                return listaMusica

            }
        }
    }

    fun conversor(jsonObject: JSONObject): JsonElement {
        // Convertendo JSONObject para JsonElement
        val jsonString = jsonObject.toString()
        return JsonParser.parseString(jsonString)
    }

}
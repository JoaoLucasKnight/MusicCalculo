package br.com.consumoapi.services

import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.extensions.authentication
import com.github.kittinunf.fuel.json.responseJson
import com.github.kittinunf.result.Result
import com.google.gson.Gson
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import org.json.JSONObject

class ConsumoApi {

    data class Track(val duration_ms: Int, val name: String)
    data class ListaDeMusicas(val track: Track)
    data class ObjetoComLista(val items: List<ListaDeMusicas>)


    fun pegarJson(): ObjetoComLista? {
        val url = "https://api.spotify.com/v1/playlists/6gJRdUeKRA9b7bAJfsA9qI?fields=tracks.items%28track%28duration_ms%2Cname%29%29"



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
                println(json)
                val tracks = json.getJSONObject("tracks")
                println(tracks)
                val items = tracks.getJSONArray("items")
                println(items)
//                val outro: JSONObject = items.toJSONObject()
//                println(outro)


                val trans: JsonElement = convertJSONObjectToJsonElement(tracks)


                val gson = Gson()


                return null

            }
        }
    }



    fun convertJSONObjectToJsonElement(jsonObject: JSONObject): JsonElement {
        // Convertendo JSONObject para JsonElement
        val jsonString = jsonObject.toString()
        return JsonParser.parseString(jsonString)
    }






}
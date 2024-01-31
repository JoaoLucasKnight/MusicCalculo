package br.com.consumoapi.services

import br.com.consumoapi.models.Musicas
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.File

class Consumo {

        fun listaDeMusicas(): List<Musicas>{

            val caminho = "src/main/kotlin/playList.json"
            val json = File(caminho).readText()

            val gson = Gson()
            val tipo = object : TypeToken<List<Musicas>>(){}.type
            val lista: List<Musicas> = gson.fromJson(json, tipo)

            val listaDeObjetos = lista.map { Musicas -> Musicas.criaMusica()}

            return listaDeObjetos
        }
    }

package br.com.consumoapi.models

data class Musicas(
    val duration_ms: Int,
    val name: String
    ){

    fun criaMusica(): Musicas{
        return Musicas(this.duration_ms, this.name)
    }
}
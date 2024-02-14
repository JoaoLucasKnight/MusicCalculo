package br.com.consumoapi

import br.com.consumoapi.services.ConsumoApi
import br.com.consumoapi.utils.Calculadora


fun main() {


  val calculadora = Calculadora()
  val  dados = ConsumoApi()
  val lista = dados.pegaPlayList()



  val horaAtual = calculadora.transformaEmMS(17 ,16)
  var horaInicial =  calculadora.transformaEmMS(5,30)
  var i = 0

  do {
    horaInicial += calculadora.operando(horaInicial,lista[i].duration_ms)
    i++
  }while (horaInicial < horaAtual)



  println("Muisica ${i+1} ")
  println(lista[i].name)
  print("Esta musica começa as: ")
  calculadora.viraTempo(horaInicial)

}
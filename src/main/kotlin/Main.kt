package br.com.consumoapi

import br.com.consumoapi.services.Consumo
import br.com.consumoapi.services.ConsumoApi
import br.com.consumoapi.utils.Calculadora
import java.util.*



fun main() {

  val consumo = Consumo()
  val calculadora = Calculadora()
  val lista = consumo.listaDeMusicas()


  val horaAtual = calculadora.transformaEmMS(13 ,16)
  var i = 0
  var horaInicial =  19800000
  do {

    var soma = calculadora.operando(horaInicial,lista[i].duration_ms)
    horaInicial = soma
    i++
  }while (horaInicial < horaAtual)



  println("Muisica ${i+1} ")
  println(lista[i].name)
  print("Esta musica começa as: ")
  calculadora.viraTempo(horaInicial)

}
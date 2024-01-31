package br.com.consumoapi.utils
import java.util.*

class Calculadora {


    fun operando( Tempo1: Int, Tempo2: Int):Int {

        return Tempo1 + Tempo2
    }

    fun transformaEmMS (h:Int, m:Int):Int  {
        return (h*3600000)+(m*60000)
    }

    fun viraTempo(z: Int){
        val divisor = 60000
        val Tempo = z/divisor
        val minutos = z%divisor
        val segundos = minutos/1000


        if(Tempo > 60){
            val horas = Tempo/60
            val min =  Tempo%60
            print("$horas h $min min $segundos s")

        }else{
            print("$Tempo minutos  $segundos segundos")
        }
    }
}

// 5:30 == 19800000
package com.example.paulo.calculadorakotlin

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_calculadora_basica.*
import kotlin.math.pow

class CalculadoraBasica : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora_basica)
    }

    var visor : String = ""
    var valor : Double = 0.0
    var total : Double = 0.0
    var ultOp : Char = 'I'

    //  function que não retorna valor
    fun num( view : View ){
        val btn: Button = view as Button
        if (visor == "") {
            visor = btn.text as String
            valor = btn.text as Double
        } else {
            visor += btn.text as String
            valor += btn.text as Double
        }
        result.setText(visor)
    }

    @SuppressLint("WrongConstant")
    fun op(view: View){
        val btn : Button = view as Button
        ultOp = btn.text as Char

        if (visor == ""){
            Toast.makeText(this, "Digite algum valor!", 1000)
        } else {
            when(ultOp){
                'I' -> total = valor
                '+' -> total += valor
                '-' -> total -= valor
                '*' -> total *= valor
                '/' -> total /= valor
                '^' -> total = total.pow(valor)
                '√' -> Toast.makeText(this, "Estamos implementando a função! Obrigado", 1000)
                '=' -> {
                    total = 0.0

                }
            }
            visor = total as String
        }
        result.setText(visor)
    }

}

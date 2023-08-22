package com.example.courtains

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.btnIniciar
import kotlinx.android.synthetic.main.activity_main.etqNumero
import kotlinx.android.synthetic.main.activity_main.progressBar
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    var salir = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnIniciar.setOnClickListener{
            //Verifica si es true para continuar el ciclo
            if (salir){
                salir = false
                btnIniciar.text="Inciar"
            }else{
                salir=true
                btnIniciar.text="Detener"
                GlobalScope.launch(Dispatchers.Main) {
                    contar()
                }
            }

        }
    }

    //Suspend es la manera en la que s epueden utiloizar las courtains
    suspend fun contar(){
        while (salir){
            delay(1000)
            //Se convierte a entero
            var num = etqNumero.text.toString().toInt()
            //Incrementa el valor
            num++
            //Se recibe el valor
            etqNumero.text = num.toString()
            progressBar.setProgress(num)
        }

    }
}
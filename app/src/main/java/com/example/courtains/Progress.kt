package com.example.courtains

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.courtains.databinding.ActivityProgressBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class Progress : AppCompatActivity() {

    private lateinit var binding: ActivityProgressBinding
    var salir = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProgressBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnIniciar
        binding.btnIniciar.setOnClickListener{
            //Verifica si es true para continuar el ciclo
            if (salir){
                salir = false
                binding.btnIniciar.text="Inciar"
            }else{
                salir=true
                binding.btnIniciar.text="Detener"
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
            var num = binding.etqNumero.text.toString().toInt()
            //Incrementa el valor
            num++
            //Se recibe el valor
            binding.etqNumero.text = num.toString()
            binding.progressBar.setProgress(num)
        }

    }
}
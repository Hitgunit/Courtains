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
    var salir = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProgressBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var time = intent.getStringExtra("Time")
        if (time != null) {
            binding.progressBar.max = time.toInt()
            binding.etqNumero.text = time
            GlobalScope.launch(Dispatchers.Main) {
                contar()
            }
        }


        binding.btnIniciar.setOnClickListener{
            //Verifica si es true para continuar el ciclo
            if (salir){
                salir = false
                binding.btnIniciar.text="Continuar"
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
        var num = binding.etqNumero.text.toString().toInt()
        while (salir && num >= 0){
            delay(1000)
            //Se recibe el valor
            binding.etqNumero.text = num.toString()
            binding.progressBar.setProgress(num)
            num --
        }

    }
}
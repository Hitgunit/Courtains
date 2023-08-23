package com.example.courtains

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.courtains.databinding.ActivityProgressBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class Progress : AppCompatActivity() {

    private lateinit var binding: ActivityProgressBinding
    var salir = true
    //Se inicializa la variable Job para el control de los courtains
    var contarJob: Job? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Se iniciliaza el binding
        binding = ActivityProgressBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Se obtine la variable Time del layout anterior
        var time = intent.getStringExtra("Time")
        //Verifica si no es null la entrada
        if (time != null) {
            //Se pone asigna el maximo en el progresBar acorde al Time
            binding.progressBar.max = time.toInt()
            //Se asigna el valor dentro del progressBar
            binding.etqNumero.text = time
            //Se manda llamar el conteo
            iniciarConteo()
        }


        binding.btnIniciar.setOnClickListener{
            //Verifica si es true para continuar el ciclo
            if (salir){
                salir = false
                binding.btnIniciar.text="Continuar"
            }else{
                salir=true
                binding.btnIniciar.text="Detener"
                iniciarConteo()
            }

        }

        binding.btnBorrar.setOnClickListener{
            onBackPressed()
        }

        binding.btnAgregar.setOnClickListener {
            Agregar()
            salir = true
            iniciarConteo()
        }
    }

    //es la manera de asignar el Coroutine
    private fun iniciarConteo() {
        contarJob?.cancel()  // Cancela la corrutina anterior si existe
        //Inicializa el Coroutine
        contarJob = GlobalScope.launch(Dispatchers.Main) {
            contar()
        }
    }
    //Se inicializa el conteo
    suspend fun contar(){
        //Obtiene el numero de conteo
        var num = binding.etqNumero.text.toString().toInt()
        while (salir && num >= 0){
            delay(1000)
            binding.etqNumero.text = num.toString()
            binding.progressBar.setProgress(num)
            num --

            // Muestra un Toast cuando el temporizador llegue a 0
            if (num <= 0) {
                Toast.makeText(this, "Tu tiempo ha terminado.", Toast.LENGTH_LONG).show()
            }
        }
    }

    //Se agrega 60 segundos
    fun Agregar(){
        //Asigna el valor del temporizador
        var num = binding.etqNumero.text.toString().toInt()
        //Le asigna 60 segundos mas y lo que tenia
        num += 60
        salir = false
        binding.etqNumero.text = num.toString()
        binding.progressBar.max = num
    }
}
package com.example.courtains

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.courtains.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var tiempoFinal = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Se inicializa el binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnIniciar.setOnClickListener {
            Cambio()
        }

        binding.btnBorrar.setOnClickListener {
            binding.txtTime.text = "0"
            tiempoFinal = 0
        }

        //Se agega los numeeros al metodo segun el usuario haga click
        binding.btn1.setOnClickListener {AgregarTiempo(binding.btn1.text.toString().toInt())}
        binding.btn2.setOnClickListener {AgregarTiempo(binding.btn2.text.toString().toInt())}
        binding.btn3.setOnClickListener {AgregarTiempo(binding.btn3.text.toString().toInt())}
        binding.btn4.setOnClickListener {AgregarTiempo(binding.btn4.text.toString().toInt())}
        binding.btn5.setOnClickListener {AgregarTiempo(binding.btn5.text.toString().toInt())}
        binding.btn6.setOnClickListener {AgregarTiempo(binding.btn6.text.toString().toInt())}
        binding.btn7.setOnClickListener {AgregarTiempo(binding.btn7.text.toString().toInt())}
        binding.btn8.setOnClickListener {AgregarTiempo(binding.btn8.text.toString().toInt())}
        binding.btn9.setOnClickListener {AgregarTiempo(binding.btn9.text.toString().toInt())}
        binding.btn0.setOnClickListener {AgregarTiempo(binding.btn0.text.toString().toInt())}
    }

    //Se manda llamar al intent para hacer el cambio con el tiempo agregado
    private fun Cambio(){
        val intent = Intent(this, Progress::class.java)
        intent.putExtra("Time", binding.txtTime.text.toString())
        startActivity(intent)
    }

    //Se agrega la variable tiempo al tiempoFinal
    private fun AgregarTiempo(tiempo: Int) {
        tiempoFinal = tiempoFinal * 10 + tiempo
        binding.txtTime.text = tiempoFinal.toString()
    }


}
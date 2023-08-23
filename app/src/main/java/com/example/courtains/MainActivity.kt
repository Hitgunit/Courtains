package com.example.courtains

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.courtains.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var tiempoFinal = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnIniciar.setOnClickListener {
            Cambio()
        }

        binding.btn1.setOnClickListener {AgregarTiempo(binding.btn1.text.toString())}
        binding.btn2.setOnClickListener {AgregarTiempo(binding.btn2.text.toString())}
        binding.btn3.setOnClickListener {AgregarTiempo(binding.btn3.text.toString())}
        binding.btn4.setOnClickListener {AgregarTiempo(binding.btn4.text.toString())}
        binding.btn5.setOnClickListener {AgregarTiempo(binding.btn5.text.toString())}
        binding.btn6.setOnClickListener {AgregarTiempo(binding.btn6.text.toString())}
        binding.btn7.setOnClickListener {AgregarTiempo(binding.btn7.text.toString())}
        binding.btn8.setOnClickListener {AgregarTiempo(binding.btn8.text.toString())}
        binding.btn9.setOnClickListener {AgregarTiempo(binding.btn9.text.toString())}
        binding.btn0.setOnClickListener {AgregarTiempo(binding.btn0.text.toString())}
    }


    private fun Cambio(){
        val intent = Intent(this, Progress::class.java)
        intent.putExtra("Time", binding.txtTime.text.toString())
        startActivity(intent)
    }

    private fun AgregarTiempo(tiempo: String) {
        tiempoFinal += tiempo
        binding.txtTime.text = tiempoFinal
    }


}
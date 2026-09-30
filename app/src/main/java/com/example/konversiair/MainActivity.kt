package com.example.konversiair

import android.app.Activity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val inputVolume = findViewById<EditText>(R.id.inputVolume)
        val spinnerVolume = findViewById<Spinner>(R.id.spinnerVolume)
        val spinnerMassa = findViewById<Spinner>(R.id.spinnerMassa)
        val btnKonversi = findViewById<Button>(R.id.btnKonversi)
        val textHasil = findViewById<TextView>(R.id.textHasil)

        val satuanVolume = arrayOf(
            "Liter (L)",
            "Mililiter (mL)"
        )

        val satuanMassa = arrayOf(
            "Kilogram (kg)",
            "Gram (g)"
        )

        spinnerVolume.adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            satuanVolume
        )

        spinnerMassa.adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            satuanMassa
        )

        btnKonversi.setOnClickListener {

            val volume = inputVolume.text.toString().toDoubleOrNull()

            if (volume == null) {
                textHasil.text = "Masukkan volume terlebih dahulu"
                return@setOnClickListener
            }

            val volumeLiter = if (spinnerVolume.selectedItemPosition == 0) {
                volume
            } else {
                volume / 1000
            }

            val massaKg = volumeLiter

            val hasil = if (spinnerMassa.selectedItemPosition == 0) {
                massaKg
            } else {
                massaKg * 1000
            }

            val satuanHasil = if (spinnerMassa.selectedItemPosition == 0) {
                "kg"
            } else {
                "g"
            }

            textHasil.text = "Massa air: $hasil $satuanHasil"
        }
    }
}
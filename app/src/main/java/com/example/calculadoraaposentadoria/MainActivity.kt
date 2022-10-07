package com.example.calculadoraaposentadoria

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spn_Sexo = findViewById<Spinner>(R.id.spn_Sexo)
        val txt_Idade = findViewById<TextView>(R.id.txt_Idade)
        val btn_Calcular = findViewById<Button>(R.id.btn_Calcular)
        val btn_Limpar = findViewById<Button>(R.id.btn_Limpar)
        val txt_Resultado = findViewById<TextView>(R.id.txt_Resultado)

        spn_Sexo.adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,
            listOf("Selecione:", "Masculino","Feminino"))

        btn_Calcular.setOnClickListener{
            if (txt_Idade.text.isEmpty()){
                txt_Idade.error = "Digite a sua idade"
            } else {
                val sexo = spn_Sexo.selectedItem as String
                val idade = txt_Idade.text.toString().toInt()
                var resultado = 0

                if (sexo == "Masculino"){
                    resultado = 70 - idade
                    txt_Resultado.text = "Faltam $resultado anos para você se aposentar"
                } else if (sexo == "Feminino"){
                    resultado = 65 - idade
                    txt_Resultado.text = "Faltam $resultado anos para você se aposentar"
                } else {
                    txt_Resultado.text = "Selecione o sexo para calcular."
                }
            }

        }

        btn_Limpar.setOnClickListener {
            txt_Idade.text = ""
        }
    }
}
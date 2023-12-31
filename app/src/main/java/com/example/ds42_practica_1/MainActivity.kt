package com.example.ds42_practica_1


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private  var conversion: Int = 0
    private  var result: Double = 0.0
    private  var value: String = ""
    private lateinit var total : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var selectedTemp = findViewById<Spinner>(R.id.temp_options)
        var temp = findViewById<EditText>(R.id.temperature)
        var button = findViewById<Button>(R.id.convert)
        total = findViewById(R.id.result)

        if (selectedTemp != null){
            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                resources.getStringArray(R.array.convert_options)
            )
            selectedTemp.adapter = adapter

            selectedTemp.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    p0: AdapterView<*>?,
                    p1: View?,
                    p2: Int,
                    p3: Long
                ) {
                    Toast.makeText(this@MainActivity,
                        "Opcion Seleccionad: " + p2, Toast.LENGTH_SHORT)
                        .show()

                    conversion = p2
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                }

            }
        }
        button.setOnClickListener{
            value = temp.text.toString()

            convert(conversion)
        }
    }
    fun convert(_conversion: Int){

        when(_conversion) {
            0 -> {
                // F = (C × 9/5) + 32
                result = (value.toDouble() * 9/5) + 32

                total.text = result.toString()
            }
            1 -> {
                //  K = C + 273.15
                result = (value.toDouble()) + 273.15

                total.text = result.toString()
            }
            2 -> {
                //  C = (F - 32) × 5/9
                result = (value.toDouble() - 32) * 5/9

                total.text = result.toString()
            }
            3 -> {
                //  K = (F - 32) × 5/9 + 273.15
                result = (value.toDouble() - 32) * 5/9 + 273.15

                total.text = result.toString()
            }
            4 -> {
                //  C = K - 273.15
                result = (value.toDouble()) - 273.15

                total.text = result.toString()
            }
            5 -> {
                //  F = (K - 273.15) × 9/5 + 32
                result = (value.toDouble() - 273.15) * 9/5 + 32

                total.text = result.toString()
            }
        }
    }
}
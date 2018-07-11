package com.droppledev.temperatureconverter

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.widget.TextView

import kotlinx.android.synthetic.main.activity_dynamic_temp.*
import kotlinx.android.synthetic.main.content_dynamic_temp.*

class DynamicTempActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dynamic_temp)
        setSupportActionBar(toolbar)

        // Code Starts Here
        etCelsius.addTextChangedListener(object : TextWatcher { // textwatcher for instant results
            override fun afterTextChanged(p0: Editable?) {
                try{
                    val temp = p0.toString() // temp save the user input from edittext
                    val result = ((temp.toDouble() * 9) / 5) + 32
                    if(etCelsius.isFocused)
                        etFahrenheit.setText("$result",TextView.BufferType.EDITABLE)

                }
                catch (e:NumberFormatException){
                    if(etCelsius.isFocused)
                        etFahrenheit.setText("",TextView.BufferType.EDITABLE)
                }

            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
        })

        etFahrenheit.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                try{
                    val temp = p0.toString() // temp save the user input from edittext
                    val result = ((temp.toDouble() - 32) * 5) / 9
                    if(etFahrenheit.isFocused)
                        etCelsius.setText("$result",TextView.BufferType.EDITABLE)
                }
                catch(e:NumberFormatException){
                    if(etFahrenheit.isFocused)
                        etCelsius.setText("",TextView.BufferType.EDITABLE)
                }

            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
        })


        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }

}

package com.droppledev.temperatureconverter

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        // Code Starts Here

        rbCToF.setOnClickListener{ // when radiobutton CtoF clicked
            Toast.makeText(this,"C to F Checked", Toast.LENGTH_SHORT).show() // show toast
        }
        rbFtoC.setOnClickListener{ // when radiobutton FtoC clicked
            Toast.makeText(this,"F to C Checked", Toast.LENGTH_SHORT).show() // show toast
        }

        btnConvert.setOnClickListener{ // when convert button clicked
            val temp = etTempertature.text.toString() // temp save the user input from edittext
            if (temp == ""){ // if there's no input show error
                etTempertature.error ="Please enter the input!"
            }
            else{
                if (rbCToF.isChecked){ // Code for Celsius to Fahrenheit
                    val result = ((temp.toDouble() * 9) / 5) + 32
                    tvResult.text = String.format("%.2f\u00B0F",result)
                }
                else if (rbFtoC.isChecked){ // Code for Fahrenheit to Celsius
                    val result = ((temp.toDouble() - 32) * 5) / 9
                    tvResult.text = String.format("%.2f\u00B0C",result)
                }
                else{
                    Toast.makeText(this,"Please select one of the radio button",Toast.LENGTH_LONG).show()
                }
            }

        }

        btnDynamic.setOnClickListener{
            val intent = Intent(this,DynamicTempActivity::class.java)
            startActivity(intent)
        }

        // Code Ends Here

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}

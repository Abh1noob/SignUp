package com.example.signuppagecodecheftask1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        lateinit var text1: EditText
        lateinit var text2: EditText
        lateinit var text3: EditText
        lateinit var text4: EditText

        val btnClickme = findViewById<Button>(R.id.button)

        var emid_pattern = Regex("[a-z]+\\.[a-z]+[0-9]{4}+@vitstudent.ac.in")
        var phno_pattern = Regex("[0-9]{10}")
        var regno_pattern = Regex("[0-9]{2}[A-Za-z]{3}[0-9]{4}")

        text1 = findViewById(R.id.name)
        text2 = findViewById(R.id.phno)
        text3 = findViewById(R.id.emid)
        text4 = findViewById(R.id.regno)

        btnClickme.setOnClickListener{
            var emid_result = emid_pattern.containsMatchIn(text3.text)
            println(emid_result)

            var phno_result = phno_pattern.containsMatchIn(text2.text)
            println(phno_result)

            var regno_result = regno_pattern.containsMatchIn(text4.text)
            println(regno_result)

            if(emid_result==true && phno_result==true && regno_result==true){
                val Intent = Intent(this,approved::class.java)
                startActivity(Intent)
            }
            else{
                if(emid_result==false){
                    Toast.makeText(this,"Invalid Email",Toast.LENGTH_SHORT).show()
                }
                else if(phno_result==false){
                    Toast.makeText(this,"Invalid Phone No.",Toast.LENGTH_SHORT).show()
                }
                else if(regno_result==false){
                    Toast.makeText(this,"Invalid Reg No.",Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
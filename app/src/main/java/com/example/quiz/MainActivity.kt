package com.example.quiz

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val  btnStart : Button =findViewById(R.id.start)
        val etName : EditText=findViewById(R.id.et_name)
        btnStart.setOnClickListener{
            if(etName.text.isEmpty()){
                Toast.makeText(this,
                    "Please Enter your Name",Toast.LENGTH_LONG).show()
            }else{
                val intent =Intent(this, QuestionActivity::class.java)
                startActivity(intent)
                finish()
           }
        }



    }
}
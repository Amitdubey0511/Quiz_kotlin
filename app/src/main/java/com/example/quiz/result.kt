package com.example.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class result : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val tv_name:TextView= findViewById(R.id.tv_name)
        val tv_score:TextView=findViewById(R.id.tv_score)
        val finish_btn: Button=findViewById(R.id.btn_finish)
        tv_name.text=intent.getStringExtra(constants.USER_NAME)
        val totalquestion =intent.getIntExtra(constants.total_question,0)
        val corans=intent.getIntExtra(constants.correctans,0)


        tv_score.text="Your score is $corans out of $totalquestion"
        finish_btn.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
        }


    }
}
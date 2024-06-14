package com.example.quiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.ProgressBar
import android.widget.TextView

class QuestionActivity : AppCompatActivity(),View.OnClickListener {
    private var mcurpos: Int =1
    private var mquestionlist: ArrayList<Questions>?=null
    private var selectoption: Int =0
    private var progressBar : ProgressBar? = null
    private var tvprogress : TextView?  =null
    private var tvquestions: TextView?=null
    private var tvoption_one: TextView?=null
    private var tvoption_two: TextView?=null
    private var tvoption_three: TextView?=null
    private var tvoption_four: TextView?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)
        progressBar=findViewById(R.id.progress_bar)
        tvprogress=findViewById(R.id.tv_progress)
        tvquestions=findViewById(R.id.tvquestions)
        tvoption_one=findViewById(R.id.option_one)
        tvoption_two=findViewById(R.id.option_two)
        tvoption_three=findViewById(R.id.option_three)
        tvoption_four=findViewById(R.id.option_four)

         mquestionlist = constants.getQuestions()
        setquestion()

    }

    private fun setquestion() {

        val questions: Questions = mquestionlist!![mcurpos - 1]
        progressBar?.progress = mcurpos
        tvprogress?.text = "$mcurpos/${progressBar?.max}"
        tvquestions?.text = questions.question
        tvoption_one?.text = questions.optionone
        tvoption_two?.text = questions.optiontwo
        tvoption_three?.text = questions.optionthree
        tvoption_four?.text = questions.optionfour
    }

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }
}
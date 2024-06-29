package com.example.quiz

import android.content.Context
import android.graphics.Color
import android.graphics.DrawFilter
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import android.content.Intent as Intent

class QuestionActivity : AppCompatActivity(),View.OnClickListener {
    private var mcurpos: Int =1
    private var mquestionlist: ArrayList<Questions>?=null
    private var musername:String?= null
    private var mcorrectans:Int=0

    private var selectoption: Int =0
    private var progressBar : ProgressBar? = null
    private var tvprogress : TextView?  =null
    private var tvquestions: TextView?=null
    private var tvoption_one: TextView?=null
    private var tvoption_two: TextView?=null
    private var tvoption_three: TextView?=null
    private var tvoption_four: TextView?=null
    private var submit: Button?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)
        musername = intent.getStringExtra(constants.USER_NAME)
        progressBar=findViewById(R.id.progress_bar)
        tvprogress=findViewById(R.id.tv_progress)
        tvquestions=findViewById(R.id.tvquestions)
        tvoption_one=findViewById(R.id.option_one)
        tvoption_two=findViewById(R.id.option_two)
        tvoption_three=findViewById(R.id.option_three)
        tvoption_four=findViewById(R.id.option_four)
        submit=findViewById(R.id.submit)

        tvoption_one?.setOnClickListener(this)
        tvoption_two?.setOnClickListener(this)
        tvoption_three?.setOnClickListener(this)
        tvoption_four?.setOnClickListener(this)
        submit?.setOnClickListener(this)
        mquestionlist = constants.getQuestions()
        setquestion()

    }

    private fun setquestion() {
        defaultoptionview()
        val questions: Questions = mquestionlist!![mcurpos - 1]
        progressBar?.progress = mcurpos
        tvprogress?.text = "$mcurpos/${progressBar?.max}"
        tvquestions?.text = questions.question
        tvoption_one?.text = questions.optionone
        tvoption_two?.text = questions.optiontwo
        tvoption_three?.text = questions.optionthree
        tvoption_four?.text = questions.optionfour

        if(mcurpos==mquestionlist!!.size){
            submit?.text="FINISH"
        }else
        {
            submit?.text="SUBMIT"
        }

    }
    private fun defaultoptionview (){
        val options= ArrayList<TextView>()
        tvoption_one?.let {
            options.add(0,it)
        }
        tvoption_two?.let {
            options.add(1,it)
        }
        tvoption_three?.let {
            options.add(2,it)
        }
        tvoption_four?.let {
            options.add(3,it)
        }
        for(option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface= Typeface.DEFAULT
            option.background= ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )
        }
    }
    private fun optionselectedview(tv:TextView,selcoptnum: Int){
        defaultoptionview()
        selectoption=selcoptnum
        tv.run {
            setTextColor(
                Color.parseColor("#FFFFFF")
            )
        }
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background= ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border_background
        )
    }
    override fun onClick(view: View?) {

          when (view?.id) {
              R.id.option_one -> {
                  if(submit?.text!="NEXT") {
                      tvoption_one?.let {
                          optionselectedview(it, 1)
                      }
                  }
              }

              R.id.option_two -> {
                  if(submit?.text!="NEXT") {
                      tvoption_two?.let {
                          optionselectedview(it, 2)
                      }
                  }


              }

              R.id.option_three -> {
                  if(submit?.text!="NEXT") {
                      tvoption_three?.let {
                          optionselectedview(it, 3)
                      }
                  }
              }

              R.id.option_four -> {
                  if(submit?.text!="NEXT") {
                      tvoption_four?.let {
                          optionselectedview(it, 4)
                      }
                  }
              }
              R.id.submit -> {
                  if (selectoption == 0) {
                      mcurpos++
                      when {
                          mcurpos <= mquestionlist!!.size -> {
                              setquestion()
                          }

                          else -> {
                              val intent= Intent(this,result::class.java)
                              intent.putExtra(constants.USER_NAME,musername)
                              intent.putExtra(constants.correctans,mcorrectans)
                              intent.putExtra(constants.total_question,mquestionlist!!.size)
                              startActivity(intent)
                              finish()
                             }
                      }
                  } else {
                      val question = mquestionlist?.get(mcurpos - 1)
                      if (question!!.correctanswer != selectoption) {
                          answerview(selectoption, R.drawable.wrong_option_border_bg)
                      }else{
                          mcorrectans++
                      }
                      answerview(question.correctanswer, R.drawable.correct_option_border_bg)
                      if (mcurpos == mquestionlist!!.size) {
                          submit?.text = "FINISH"
                      } else {
                          submit?.text = "NEXT"
                      }
                      selectoption = 0
                  }
              }
          }

    }
    private fun  answerview (answer:Int,drawble:Int){
        when(answer){
            1 -> {
                tvoption_one?.background = ContextCompat.getDrawable(
                    this,
                    drawble
                )
            }
            2 -> {
                tvoption_two?.background = ContextCompat.getDrawable(
                    this,
                    drawble
                )
            }
            3 -> {
                tvoption_three?.background = ContextCompat.getDrawable(
                    this,
                    drawble
                )
            }
            4 -> {
                tvoption_four?.background = ContextCompat.getDrawable(
                    this,
                    drawble
                )
            }
        }
    }
}
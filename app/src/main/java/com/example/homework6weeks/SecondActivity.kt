package com.example.homework6weeks

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.lifecycle.ViewModelProvider

class SecondActivity : AppCompatActivity() {
    private var updateValue: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val msg = intent?.getStringExtra("number")?:""
        findViewById<TextView>(R.id.textView).text = "${msg}"

        //back 눌렀을 때 secondactivity가 값을 돌려주는 방법
        onBackPressedDispatcher.addCallback(this,object :OnBackPressedCallback(true){
            override fun handleOnBackPressed(){
                val resultIntent = Intent()
                resultIntent.putExtra("resultdata",updateValue.toString())
                setResult(RESULT_OK, resultIntent)
                finish()
            }
        })

        val viewModel = ViewModelProvider(this)[MyViewModel::class.java]
        val viewModel2 = ViewModelProvider(this, MyViewModel2Factorial(msg))[MyViewModel2::class.java]

        viewModel2.countLiveData.observe(this){
            findViewById<TextView>(R.id.textView).text = "${it}"
            updateValue = it
        }

        findViewById<Button>(R.id.buttonInc)?.setOnClickListener{
            viewModel2.increaseCount()
        }

        findViewById<Button>(R.id.buttonDec)?.setOnClickListener{
            viewModel2.decreaseCount()
        }
    }
}
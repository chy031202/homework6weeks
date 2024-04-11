package com.example.homework6weeks

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText = findViewById<EditText>(R.id.editText)

        val activityResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            val msg = it.data?.getStringExtra("resultdata")?:""
            Snackbar.make(findViewById(R.id.button), msg, Snackbar.LENGTH_SHORT).show()
            editText.setText(msg)
        }

        findViewById<Button>(R.id.button)?.setOnClickListener{
            val str = editText.text.toString()
            val intent = Intent(this, SecondActivity::class.java)

            intent.putExtra("number", str)
            activityResult.launch(intent)
        }
    }
}
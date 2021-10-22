package com.utsman.sharedprefbinar

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

// findViewById
// ..
// butter knife
// kotlin view extensions
// view binding

class MainActivity : AppCompatActivity() {

    private val sharedPreferences: SharedPreferences by lazy {
        getSharedPreferences("simple_value", Context.MODE_PRIVATE)
    }

    private val etValue: EditText by lazy {
        findViewById(R.id.et_value)
    }

    private val btnValue: Button by lazy {
        findViewById(R.id.btn_value)
    }

    private val tvResult: TextView by lazy {
        findViewById(R.id.tv_result)
    }

    private val btnResult: Button by lazy {
        findViewById(R.id.btn_result)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val preferencesEditor = sharedPreferences.edit()

        btnValue.setOnClickListener {
            val textValue = etValue.text.toString()
            preferencesEditor.putString("value", textValue)
            preferencesEditor.apply()
        }

        btnResult.setOnClickListener {
            val textResult = sharedPreferences.getString("value", "")
            tvResult.text = textResult
        }

    }
}
package com.darren.bmi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var my_BMI : TextView
    private lateinit var my_age: TextView
    private lateinit var my_category: TextView
    private lateinit var recalculate: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        init()
        setText()
        recalculate.setOnClickListener(this)


    }

    private fun setText() {
        val category = Category()
        var BMI = intent.getStringExtra("BMI")
        var age = intent.getStringExtra("age")
        my_BMI.text = BMI.toString()
        my_age.text = age.toString()
        my_category.text = category.getCategory(BMI.toString().toDouble())
    }

    private fun init(){
        my_BMI = findViewById(R.id.your_bmi)
        my_age = findViewById(R.id.age)
        my_category = findViewById(R.id.category)
        recalculate = findViewById(R.id.recalculate)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.recalculate -> {
                val i = Intent(this, MainActivity::class.java)
                startActivity(i)
            }
        }
    }
}



package com.darren.bmi


import android.content.Intent
import android.graphics.Color
import android.nfc.Tag
import android.os.Bundle
import android.util.Log
import android.util.Log.INFO
import android.view.TextureView
import android.view.View
import android.widget.*
import android.widget.Toast.LENGTH_LONG
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import java.lang.Math.pow
import java.util.logging.Level.INFO
import android.widget.SeekBar.OnSeekBarChangeListener as SeekBarOnSeekBarChangeListener

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var maleText: TextView
    private lateinit var femaleText: TextView

    private lateinit var weightAdd: ImageView
    private lateinit var weightMinus: ImageView
    private lateinit var ageAdd: ImageView
    private lateinit var ageMinus: ImageView
    private lateinit var weight_tv: TextView
    private lateinit var age_tv: TextView
    private lateinit var height_tv: TextView
    private lateinit var seekBar: SeekBar
    private lateinit var male_cardView: CardView
    private lateinit var female_cardView: CardView
    private var maleOnClick: Boolean = true
    private var femaleOnClick: Boolean = true
    private var checkMaleOnClick: Boolean = false
    private var checkFemaleOnClick: Boolean = false
    private lateinit var calculate_btn: Button




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
        weightAdd.setOnClickListener(this)
        weightMinus.setOnClickListener(this)
        ageAdd.setOnClickListener(this)
        ageMinus.setOnClickListener(this)
        male_cardView.setOnClickListener(this)
        female_cardView.setOnClickListener(this)
        calculate_btn.setOnClickListener(this)
        seekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                height_tv.text = progress.toString() + "cm"
            }


            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }
            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                height_tv.text = seekBar?.progress.toString() + "cm"
            }
        }
        )




    }

    private fun init() {
        weightAdd = findViewById(R.id.weight_plus)
        weightMinus = findViewById(R.id.weight_minus)
        weight_tv = findViewById(R.id.weight)
        ageAdd = findViewById(R.id.age_plus)
        ageMinus = findViewById(R.id.age_minus)
        age_tv = findViewById(R.id.age)
        height_tv = findViewById(R.id.height)
        seekBar = findViewById(R.id.Seekbar)
        male_cardView = findViewById(R.id.cardView_male)
        female_cardView = findViewById(R.id.cardView_female)
        maleText = findViewById(R.id.male)
        femaleText = findViewById(R.id.female)
        calculate_btn = findViewById(R.id.calculate)

    }

    override fun onClick(v: View?) {
        var weight: Double
        var age: Double
        var height: Double
        when (v?.id) {
            R.id.weight_plus -> {
                weight = weight_tv.text.toString().toDouble()
                weight += 1
                weight_tv.text = weight.toInt().toString()
            }
            R.id.weight_minus -> {
                weight = weight_tv.text.toString().toDouble()
                weight -= 1
                weight_tv.text = weight.toInt().toString()
            }
            R.id.age_plus -> {
                age = age_tv.text.toString().toDouble()
                age += 1
                age_tv.text = age.toInt().toString()
            }
            R.id.age_minus -> {
                age = age_tv.text.toString().toDouble()
                age -= 1
                age_tv.text = age.toInt().toString()
            }
            R.id.cardView_male -> {
                if (checkMaleOnClick) {
                    maleText.setTextColor(Color.parseColor("#8D8E99"))
                    maleText.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.male, 0, 0)
                    checkMaleOnClick = false
                } else {
                    if (femaleOnClick) {
                        femaleText.setTextColor(Color.parseColor("#8D8E99"))
                        femaleText.setCompoundDrawablesWithIntrinsicBounds(
                            0,
                            R.drawable.female,
                            0,
                            0
                        )
                        femaleOnClick = false
                        checkFemaleOnClick = false
                        maleText.setTextColor(Color.parseColor("#FFFFFF"))
                        maleText.setCompoundDrawablesWithIntrinsicBounds(
                            0,
                            R.drawable.male_white,
                            0,
                            0
                        )
                        maleOnClick = true
                        checkMaleOnClick = true

                    } else {
                        maleText.setTextColor(Color.parseColor("#FFFFFF"))
                        maleText.setCompoundDrawablesWithIntrinsicBounds(
                            0,
                            R.drawable.male_white,
                            0,
                            0
                        )
                        maleOnClick = true
                        checkMaleOnClick = true

                    }
                }
            }
            R.id.cardView_female -> {
                if (checkFemaleOnClick) {
                    femaleText.setTextColor(Color.parseColor("#8D8E99"))
                    femaleText.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.female, 0, 0)
                    checkFemaleOnClick = false
                } else {
                    if (maleOnClick) {
                        maleText.setTextColor(Color.parseColor("#8D8E99"))
                        maleText.setCompoundDrawablesWithIntrinsicBounds(
                            0,
                            R.drawable.male,
                            0,
                            0
                        )
                        maleOnClick = false
                        checkMaleOnClick = false

                        femaleText.setTextColor(Color.parseColor("#FFFFFF"))
                        femaleText.setCompoundDrawablesWithIntrinsicBounds(
                            0,
                            R.drawable.female_white,
                            0,
                            0
                        )
                        femaleOnClick = true
                        checkFemaleOnClick = true

                    } else {
                        femaleText.setTextColor(Color.parseColor("#FFFFFF"))
                        femaleText.setCompoundDrawablesWithIntrinsicBounds(
                            0,
                            R.drawable.female_white,
                            0,
                            0
                        )
                        femaleOnClick = true
                        checkFemaleOnClick = true

                    }
                }
            }
            R.id.calculate -> {
                var BMI: Double
                weight = weight_tv.text.toString().toDouble()
                height = seekBar?.progress.toString().toDouble()/100

                BMI = Math.round(weight / Math.pow(height,2.0)*100.0)/100.0
                Log.d("BMI",BMI.toString())
                val i = Intent(this, ResultActivity::class.java)
                i.putExtra("BMI",BMI.toString())
                i.putExtra("age", age_tv.text.toString())
                startActivity(i)
            }
            else -> {

            }
        }
    }
}



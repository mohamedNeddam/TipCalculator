package com.example.backtobasics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.*
import com.example.backtobasics.databinding.ActivityMainBinding
import java.time.Duration

class MainActivity : AppCompatActivity() {
    // example without the use of viewBinding
    private lateinit var inputText: EditText
    private lateinit var inputRadio: RadioGroup
    private lateinit var calculateButton : Button

    //create the binding object for mainActivity class (generated class based ob the mainActivity layout)
    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // we will use view binding later
//        inputText = findViewById(R.id.cost_input)
//        inputRadio = findViewById(R.id.tips_radio_group)
//        calculateButton = findViewById(R.id.calculate_button)
        binding.calculateButton.setOnClickListener { calculateTip() }

    }
    private fun calculateTip(){

        val cost = binding.costInput.text.toString().toDouble()
        val tipPercentage = when(binding.tipsRadioGroup.checkedRadioButtonId){
            R.id.option_twenty_percent -> 0.2
            R.id.option_eighteen_percent -> 0.18
            else -> 0.15
        }
        var message = cost + (cost*tipPercentage)

        if(binding.roundUpSwitch.isChecked)   message = kotlin.math.ceil(message)

        Toast.makeText(this,message.toString(),Toast.LENGTH_SHORT).show()



    }
}
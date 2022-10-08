package com.example.backtobasics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.*
import com.example.backtobasics.databinding.ActivityMainBinding
import java.text.NumberFormat
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

        var cost1 = binding.costInput.text.toString()
        var cost = cost1.toDoubleOrNull()
        val tipPercentage = when(binding.tipsRadioGroup.checkedRadioButtonId){
            R.id.option_twenty_percent -> 0.2
            R.id.option_eighteen_percent -> 0.18
            else -> 0.15
        }
        var message = cost!! + (cost!!*tipPercentage)

        if(binding.roundUpSwitch.isChecked)   message = kotlin.math.ceil(message)

        val formattedTip = NumberFormat.getCurrencyInstance().format(message)
        val result = getString(R.string.tip_amount,formattedTip)

        Toast.makeText(this,result,Toast.LENGTH_SHORT).show()



    }
}
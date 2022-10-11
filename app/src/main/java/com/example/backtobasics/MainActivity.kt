package com.example.backtobasics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.*
import com.example.backtobasics.databinding.ActivityMainBinding
import java.text.NumberFormat
import java.time.Duration

class MainActivity : AppCompatActivity() {

    //create the binding object for mainActivity class (generated class based ob the mainActivity layout)
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.calculateButton.setOnClickListener { calculateTip() }

    }
    private fun calculateTip(){
        var cost : Double? = this.binding.costInput.text.toString().toDoubleOrNull()
        if(cost == null){
            Toast.makeText(this,"there is no value",Toast.LENGTH_SHORT).show()
            return
        }

        val tipPercentage = when(binding.tipsRadioGroup.checkedRadioButtonId){
            R.id.option_twenty_percent -> 0.2
            R.id.option_eighteen_percent -> 0.18
            else -> 0.15
        }
        var message = cost + (cost*tipPercentage)

        if(binding.roundUpSwitch.isChecked)   message = kotlin.math.ceil(message)

        val formattedTip = NumberFormat.getCurrencyInstance().format(message)
        val result = getString(R.string.tip_amount,formattedTip)

        binding.resultTips.text = result;
        Toast.makeText(this,result,Toast.LENGTH_SHORT).show()



    }


}
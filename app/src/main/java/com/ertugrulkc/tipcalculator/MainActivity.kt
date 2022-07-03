package com.ertugrulkc.tipcalculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.roundToLong

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setViews()
    }

    private var total = 0.0
    private fun setViews() {
        edittext.setText("0")
        twenty_percent.isChecked = true
        switchs.isChecked = true

        mybutton.setOnClickListener {
            val id = tip_radigo_group.checkedRadioButtonId
            val serviceValue: Double = (edittext.text.toString().toDouble())
            when (id) {
                R.id.twenty_percent -> {
                    total = calculateTip(serviceValue, 20)
                }
                R.id.eigtheen_percent -> {
                    total = calculateTip(serviceValue, 18)
                }
                R.id.fifteen_percent -> {
                    total = calculateTip(serviceValue, 15)
                }
            }
            amount_text.text = "Tip Amount: $total$"
        }
    }

    private fun calculateTip(serviceValue: Double, value: Int): Double {
        var amount = (serviceValue * value) / 100
        if (switchs.isChecked)
            amount = amount.roundToLong().toDouble()
        return amount
    }
}

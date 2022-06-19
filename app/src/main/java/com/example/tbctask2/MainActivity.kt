package com.example.tbctask2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var button: Button
    private lateinit var editText: EditText
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button = findViewById(R.id.button)
        editText = findViewById(R.id.editText)
        textView = findViewById(R.id.textView)
        button.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        textView.text = getNumberString()
    }

    private val coreNumberPart = mapOf<Int, String>(
        0 to "ი",
        1 to "ერთი",
        2 to "ორი",
        3 to "სამი",
        4 to "ოთხი",
        5 to "ხუთი",
        6 to "ექვსი",
        7 to "შვიდი",
        8 to "რვა",
        9 to "ცხრა",
        10 to "ათი",
        11 to "თერთმეტი",
        12 to "თორმეტი",
        13 to "ცამეტი",
        14 to "თოთხმეტი",
        15 to "თუთხმეტი",
        16 to "თექვსმეტი",
        17 to "ჩვიდმეტი",
        18 to "თვრამეტი",
        19 to "ცხრამეტი",
    )
    private val tenPart = mapOf<Int, String>(
        0 to "",
        1 to "",
        2 to "ოც",
        3 to "ოც",
        4 to "ორმოც",
        5 to "ორმოც",
        6 to "სამოც",
        7 to "სამოც",
        8 to "ოთხმოც",
        9 to "ოთხმოც",
    )
    private val hundredPart = mapOf<Int, String>(
        0 to "",
        1 to "ას",
        2 to "ორას",
        3 to "სამას",
        4 to "ოთხას",
        5 to "ხუთას",
        6 to "ექვსას",
        7 to "შვიდას",
        8 to "რვაასი",
        9 to "ცხრაასი",
    )

    private fun getNumberString(): String {
        val input = editText.text.toString().toInt()

        if (input == 0) return "ნული"
        if (input == 1000) return "ათასი"

        val firstPart = hundredPart.getValue(input / 100)
        val middlePart = tenPart.getValue((input % 100) / 10)
        val lastPart = coreNumberPart.getValue(input % 20)

        val andTxt = if ((input % 100) > 20 && (input % 20) != 0) "და" else ""

        return "$firstPart${middlePart}$andTxt${lastPart}"
    }
}









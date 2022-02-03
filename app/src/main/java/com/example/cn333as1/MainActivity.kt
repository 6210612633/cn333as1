package com.example.cn333as1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import kotlin.random.Random.Default.nextInt

class MainActivity : AppCompatActivity() {
    private lateinit var inputValue: EditText
    private lateinit var Hint: TextView

    var random: Int = nextInt(1, 1000)
    var count: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        inputValue = findViewById<EditText>(R.id.inputValue)
        var SubmitButton = findViewById<Button>(R.id.SubmitButton)
        Hint = findViewById<TextView>(R.id.Hint)
        var Count = findViewById<TextView>(R.id.Count)

        SubmitButton.setOnClickListener {

            if (inputValue.text.toString().trim().isNotBlank() || inputValue.text.toString().trim()
                    .isNotEmpty()
            ) {
                val input: Int = inputValue.text.toString().toInt()
                if (input < random) {
                    count++
                    Hint.text = "More than your number"
                    Count.text = ""
                    inputValue.text.clear()
                } else if (input > random) {
                    count++
                    Hint.text = "Less than your number "
                    Count.text = ""
                    inputValue.text.clear()
                } else {
                    count++
                    Hint.text = "that's correct"
                    inputValue.text.clear()
                    Count.text = "You tried" + count.toString() +"times. Enter number for play again"
                    count = 0
                    random = nextInt(1, 1000)
                }
            }


        }

    }
}



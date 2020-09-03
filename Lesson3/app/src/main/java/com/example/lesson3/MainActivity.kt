package com.example.lesson3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.lesson3hw.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var foods: MutableList<String> = listOf(
        "Hamburger", "Pizza",
        "Mexican", "American", "Chinese"
    ).toMutableList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    fun selectRandomFood(view: View) {
        var random = Math.random() * foods.size
        textView.text = foods.get(random.toInt())
    }

    fun addFood(view: View) {
        if (!addFoodText.text.toString().equals(""))
            foods.add(addFoodText.text.toString())
    }
}
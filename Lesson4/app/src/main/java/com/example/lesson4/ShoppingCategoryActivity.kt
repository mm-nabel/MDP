package com.example.lesson4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.w1d4.R
import kotlinx.android.synthetic.main.activity_shopping_category.*


class ShoppingCategoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_category)

        val intent = intent
        val username = intent.getStringExtra("username")

        welomeTV.text = username

        imageView1.setOnClickListener {
            Toast.makeText(this, "Elecetronics Category selected.", Toast.LENGTH_LONG).show()
        }
        imageView2.setOnClickListener{
            Toast.makeText(this, "Clothes Category selected.", Toast.LENGTH_LONG).show()
        }
        imageView3.setOnClickListener{
            Toast.makeText(this, "Beauty Category selected.", Toast.LENGTH_LONG).show()
        }
        imageView4.setOnClickListener{
            Toast.makeText(this, "Food Category selected.", Toast.LENGTH_LONG).show()
        }

    }
}
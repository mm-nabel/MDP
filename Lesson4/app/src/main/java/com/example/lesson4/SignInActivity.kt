package com.example.lesson4

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.w1d4.R
import kotlinx.android.synthetic.main.activity_main.*

class SignInActivity : AppCompatActivity() {

    lateinit var users :Array<User>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var user1 : User =
            User(
                "Mohamed",
                "Nabil",
                "mbadawy@miu.edu",
                "123"
            )
        var user2 : User =
            User(
                "Mohamed",
                "Badawy",
                "mbadawy@miu.edu",
                "123"
            )
        var user3 : User =
            User(
                "ALi",
                "Khan",
                "mkhan@miu.edu",
                "123"
            )
        var user4 : User =
            User(
                "John",
                "Dark",
                "jdark@miu.edu",
                "123"
            )
        var user5 : User =
            User(
                "Walid",
                "Mohamed",
                "wmohamed@miu.edu",
                "123"
            )

        users = arrayOf(user1, user2, user3, user4, user5)

        signInBtn.setOnClickListener {
            var username = username.text.toString().trim()
            var password = password.text.toString().trim()

            if (username != "" || password != "") {
                var isValid = false
                users.forEach {
                    if (username == it.username && password == it.password) {
                        isValid = true
                        Toast.makeText(this, "Welcome, $username", Toast.LENGTH_LONG).show()

                        val i = Intent (this, ShoppingCategoryActivity::class.java)
                        i.putExtra("username", username)

                        startActivity(i)


                    }
                }
                if (!isValid) {
                    Toast.makeText(this, "Email or password is invalid.", Toast.LENGTH_LONG).show()
                }
            } else {
                Toast.makeText(this, "Enter your email and password.", Toast.LENGTH_LONG).show()
            }
        }

        createUserBtn.setOnClickListener {
            val i = Intent(this, SignUpActivity::class.java)
            startActivityForResult(i,1)
        }

        forgetPassword.setOnClickListener{


            var isValid = false
            users.forEach {
                if (it.username == username.text.toString()){


                    val intent = Intent(Intent.ACTION_SEND)
                    intent.type = "text/html"
                    intent.putExtra(Intent.EXTRA_EMAIL,arrayOf(it.username))

                    intent.putExtra(Intent.EXTRA_SUBJECT, "Your Password")
                    intent.putExtra(Intent.EXTRA_TEXT, "Your Password is : " + it.password)

                    startActivity(Intent.createChooser(intent, "Send Email"))

                }
            }
            if (!isValid)
                Toast.makeText(this, "not valid user! ", Toast.LENGTH_LONG)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, intent)
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {

                val newUser: User = data?.extras?.getSerializable("user") as User

                Log.i("newuser", newUser.toString())

                users.set(4,newUser)

            }
        }
    }

}
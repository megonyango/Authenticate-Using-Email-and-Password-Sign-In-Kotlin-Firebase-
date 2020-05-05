package com.example.meg.loginapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    var mAuth = FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         tvMoveSignUp.setOnClickListener {

            val intent=Intent(applicationContext,SignUpActivity::class.java)
            startActivity(intent)

        }
         btnlogin.setOnClickListener {
             login()
         }

    }

    private fun login () {

        val email = etEmail.text.toString()
        val password = etPassword.text.toString()

        if (!email.isEmpty() && !password.isEmpty()) {
            this.mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener ( this, OnCompleteListener<AuthResult> { task ->
                    if (task.isSuccessful) {
                        startActivity(Intent(this, HomeActivity::class.java))
                        Toast.makeText(this, "Successfully Logged in :)", Toast.LENGTH_LONG).show()
                    } else {
                        Toast.makeText(this, "Error Logging in :(", Toast.LENGTH_SHORT).show()
                    }
                })

        }else {
            Toast.makeText(this, "Please fill up the Credentials :|", Toast.LENGTH_SHORT).show()
        }
    }
}

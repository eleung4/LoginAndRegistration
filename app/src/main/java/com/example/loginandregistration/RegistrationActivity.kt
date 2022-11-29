package com.example.loginandregistration

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.loginandregistration.databinding.ActivityRegistrationBinding

class RegistrationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegistrationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // retrieve any information from the intent using the extras kets
        val username = intent.getStringExtra(LoginActivity.EXTRA_USERNAME) ?: ""
        val password = intent.getStringExtra(LoginActivity.EXTRA_PASSWORD) ?: ""

        // prefill the username and password fields
        binding.editTextRegistrationUsername.setText(username)
        binding.editTextRegistrationPassword.setText(password)

        // register an account and send back a username and password to the
        // login activity to prefill those fields
        binding.buttonRegistrationRegister.setOnClickListener {
            val password = binding.editTextRegistrationPassword.text.toString()
            val confirm = binding.editTextRegistrationConfirmPassword.text.toString()
            val name = binding.editTextRegistrationName.text.toString()
            val email = binding.editTextRegistrationEmail.text.toString()
            if(RegistrationUtil.validatePassword(password, confirm) && RegistrationUtil.validateUsername(username) &&
                RegistrationUtil.validateName(name) && RegistrationUtil.validateEmail(email)) {
                            val resultIntent = Intent().apply {
                                // apply { putExtra() } is doing the same thing as
                                // resultIntent.putExtra()
                                putExtra(LoginActivity.EXTRA_USERNAME, binding.editTextRegistrationUsername.text.toString())
                                putExtra(LoginActivity.EXTRA_PASSWORD, binding.editTextRegistrationPassword.text.toString())
                            }
                            setResult(Activity.RESULT_OK, resultIntent)
                            finish()
                        }
            else {
                Toast.makeText( this, "something is wrong! please fill out all fields.", Toast.LENGTH_SHORT).show()
            }

            if(!RegistrationUtil.validatePassword(password, confirm)) {
                Toast.makeText( this, "password", Toast.LENGTH_SHORT).show()
            }
            if(!RegistrationUtil.validateUsername(username)) {
                Toast.makeText( this, "username", Toast.LENGTH_SHORT).show()
            }
            if(!RegistrationUtil.validateName(name)) {
                Toast.makeText( this, "name", Toast.LENGTH_SHORT).show()

            }
            if(!RegistrationUtil.validateEmail(email)) {
                Toast.makeText( this, "email", Toast.LENGTH_SHORT).show()
            }









            // apply lambda will call the functions inside it on the
            // object that apply is called on



        }


    }
}
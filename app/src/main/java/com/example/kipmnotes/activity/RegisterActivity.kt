package com.example.kipmnotes.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kipmnotes.R
import com.example.kipmnotes.databinding.ActivityLoginBinding
import com.example.kipmnotes.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    lateinit var binding:ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)




    }
}
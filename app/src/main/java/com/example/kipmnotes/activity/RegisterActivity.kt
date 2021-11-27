package com.example.kipmnotes.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
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


//        Add ClickListerner on Register Button
        binding.btnRegister.setOnClickListener {
            getInfoAndCheck()
        }


    }

//    get data and check valid or not
    private fun getInfoAndCheck(){

    val fullName = binding.etRegisterName.text.toString()
    val collegeName = binding.etRegisterCollege.text.toString()
    val courseName = binding.etRegisterCourse.text.toString()
    val email = binding.etRegisterEmail.text.toString()
    val pass = binding.etRegisterPass.text.toString()
    val confirmPass = binding.etRegisterConfirmPass.text.toString()

    if (fullName.isEmpty()){
        setErrors(binding.etRegisterName,"Enter Full Name")
    }
    if (collegeName.isEmpty()){
        setErrors(binding.etRegisterCollege,"Please Enter College Name")
    }
    if (courseName.isEmpty()){
        setErrors(binding.etRegisterCourse,"Please Enter Your Course")
    }
    if (email.isEmpty()){
        setErrors(binding.etRegisterName,"Please Enter Email")
    }
    if (pass.isEmpty()){
        setErrors(binding.etRegisterName,"Please Enter Password")
    }
    if (pass != confirmPass){
        setErrors(binding.etRegisterConfirmPass,"Password Do Not Match..!")
    }




    }


//    used for show errors on edittext when empty
    private fun setErrors(view:EditText,error:String){
        view.setError(error)
    }
}


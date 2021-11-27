package com.example.kipmnotes.activity

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.widget.EditText
import com.example.kipmnotes.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    lateinit var binding:ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        // Design Login text
        changeColorTextView()


//        AgainLoginpage Call
        binding.txtAgainLogin.setOnClickListener {
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

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
        setErrors(binding.etRegisterEmail,"Please Enter Email")
    }
    if (pass.isEmpty()){
        setErrors(binding.etRegisterPass,"Please Enter Password")
    }
    if (pass != confirmPass){
        setErrors(binding.etRegisterConfirmPass,"Password Do Not Match..!")
    }


    }


//    used for show errors on edittext when empty
    private fun setErrors(view:EditText,error:String){
        view.setError(error)
    }



    // Change color for designing purpose
    private fun changeColorTextView(){

        val mText = binding.txtAgainLogin.text.toString()

        val mSpannableString = SpannableString(mText)
        val mRed = ForegroundColorSpan(Color.RED)

        mSpannableString.setSpan(mRed,23,30, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        binding.txtAgainLogin.text = mSpannableString

    }



}


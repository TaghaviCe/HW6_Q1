package com.example.hw6_q1

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isInvisible
import com.example.hw6_q1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var activity: Activity
    lateinit var sharedPreferences: SharedPreferences
    lateinit var binding: ActivityMainBinding
    private val sharedPrefFile = "kotlinSharedPreference"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding= ActivityMainBinding.inflate(layoutInflater)
        val view =binding.root
        setContentView(view)
        val sharedPreferences: SharedPreferences = this.getSharedPreferences(sharedPrefFile,Context.MODE_PRIVATE)
        binding.register.setOnClickListener{
            val name:String=binding.editTextTextPersonName.toString()
            val username:String=binding.editTextTextPersonName2.toString()
            val email:String=binding.editTextTextEmailAddress.toString()
            val password:String=binding.editTextTextPassword.toString()
            val password2:String=binding.editTextTextPassword2.toString()
            val editor:SharedPreferences.Editor =  sharedPreferences.edit()
            editor.putString("name",name)
            editor.putString("username",username)
            editor.putString("email",email)
            if(binding.editTextTextPassword==binding.editTextTextPassword2) {
                editor.putString("password", password)
                editor.apply()
                editor.commit()
            }

        }
        binding.show.setOnClickListener {
            val sharedNameValue = sharedPreferences.getString("name","non")
            val sharedUserValue=sharedPreferences.getString("username","non")
            val sharedEmailValue = sharedPreferences.getString("email","non")
            val sharedPasswordValue = sharedPreferences.getString("password","non")
            binding.viewName.visibility
            binding.viewName.setText(sharedNameValue).toString()
            binding.viewUserName.visibility
            binding.viewUserName.setText(sharedUserValue).toString()
            binding.viewEmail.visibility
            binding.viewEmail.setText(sharedEmailValue).toString()
            binding.viewpassword.visibility
            binding.viewpassword.setText(sharedPasswordValue).toString()
        }
        binding.hiding.setOnClickListener {
            binding.viewName.isInvisible
            binding.viewUserName.isInvisible
            binding.viewEmail.isInvisible
            binding.viewpassword.isInvisible
        }


    }
    }

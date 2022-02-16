package com.example.hw6_q1

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
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
        binding.radio2.setOnClickListener {
            binding.radio1.isClickable=false
        }
        binding.radio1.setOnClickListener {
            binding.radio2.isClickable=false
        }
        val sharedPreferences: SharedPreferences = this.getSharedPreferences(sharedPrefFile,Context.MODE_PRIVATE)
        binding.register.setOnClickListener{
            val name:String=binding.editTextTextPersonName.text.toString()
            val username:String=binding.editTextTextPersonName2.text.toString()
            val email:String=binding.editTextTextEmailAddress.text.toString()
            val password:String=binding.editTextTextPassword.text.toString()
            val editor:SharedPreferences.Editor =  sharedPreferences.edit()
            editor.putString("name",name)
            editor.putString("username",username)
            editor.putString("email",email)
            if (binding.editTextTextPassword.text==binding.editTextTextPassword2.text){
                editor.putString("password", password)
            }
            editor.apply()
            editor.commit()
            Toast.makeText(getApplicationContext(),"yes",Toast.LENGTH_SHORT)


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

package com.pallavi.backgroundtheme

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CompoundButton
import android.widget.Switch
import androidx.appcompat.app.AppCompatDelegate
import com.google.android.gms.drive.events.OnChangeListener
import com.google.android.material.switchmaterial.SwitchMaterial
import java.lang.Boolean.getBoolean
import java.util.Objects

class MainActivity : AppCompatActivity() {
     lateinit var btnTheme : Switch
      var nigthMode:Boolean=false
      private var editor : SharedPreferences.Editor?=null
    private var sharedPreferences: SharedPreferences?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnTheme = findViewById(R.id.btnTheme)
        sharedPreferences = getSharedPreferences("MODE",Context.MODE_PRIVATE)
        nigthMode = sharedPreferences?.getBoolean("nigth",false)!!
        if (nigthMode)
        {
            btnTheme.isChecked=true
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }
        btnTheme.setOnCheckedChangeListener { compoundButton, state ->
            if (nigthMode) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                editor = sharedPreferences?.edit()
                editor?.putBoolean("nigth", false)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                editor = sharedPreferences?.edit()
                editor?.putBoolean("nigth", true)
            }
            editor?.apply()

        }
    }

}
package com.androidatc.sharedpreferences

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        save.setOnClickListener{
            savePreferences("save", enter_data.text.toString())
            show.isEnabled = true
        }
        show.setOnClickListener{
            load_data.setText(loadPreferences())
        }
        show.isEnabled = false
        /*
        * If there is no data currently stored then the
        * show button will be shown as disabled when
        * application is launched.
        */
        if (loadPreferences().isNotEmpty())
            show.isEnabled = true
    }

    private fun savePreferences(key: String, value: String) {
        val sharedPreferences = getPreferences(MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString(key, value)
        editor.commit()
    }

    private fun loadPreferences(): String {
        val sharedPreferences = getPreferences(MODE_PRIVATE)
        val savedData = sharedPreferences.getString("save", "")
        return savedData
    }
}


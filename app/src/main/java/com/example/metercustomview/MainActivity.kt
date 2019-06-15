package com.example.metercustomview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import com.example.metercustomview.views.MetersCustomView

class MainActivity : AppCompatActivity() {

    lateinit var meter:MetersCustomView
    lateinit var seekBar: SeekBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        meter = findViewById(R.id.metters)
        seekBar = findViewById(R.id.seekBar)
        meter.setCurrentSpeed(50)
        seekBar.setOnSeekBarChangeListener(object :SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                meter.setCurrentSpeed(progress)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })
    }
}

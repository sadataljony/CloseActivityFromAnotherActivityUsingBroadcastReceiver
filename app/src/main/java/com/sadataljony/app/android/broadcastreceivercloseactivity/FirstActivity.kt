package com.sadataljony.app.android.broadcastreceivercloseactivity

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.sadataljony.app.android.broadcastreceivercloseactivity.databinding.ActivityFirstBinding


class FirstActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFirstBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirstBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setClickListener()
        initBroadcastReceiver()
    }

    private fun setClickListener() {
        binding.btnGoToSecondActivity.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }
    }

    private fun initBroadcastReceiver() {
        val broadcastReceiver: BroadcastReceiver = object : BroadcastReceiver() {
            override fun onReceive(arg0: Context?, intent: Intent) {
                val action = intent.action
                if (action == "finish_first_activity") {
                    finish()
                    Toast.makeText(this@FirstActivity, "Close First Activity", Toast.LENGTH_LONG)
                        .show()
                }
            }
        }
        registerReceiver(broadcastReceiver, IntentFilter("finish_first_activity"))
    }

}
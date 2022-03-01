package com.sadataljony.app.android.broadcastreceivercloseactivity

import android.R
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.sadataljony.app.android.broadcastreceivercloseactivity.databinding.ActivitySecondBinding


class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setToolbar()
        setClickListener()
        initBroadcastReceiver()
    }

    private fun setToolbar() {
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
    }

    private fun setClickListener() {
        binding.btnGoToThirdActivity.setOnClickListener {
            startActivity(Intent(this, ThirdActivity::class.java))
        }
    }

    private fun initBroadcastReceiver() {
        val broadcastReceiver: BroadcastReceiver = object : BroadcastReceiver() {
            override fun onReceive(arg0: Context?, intent: Intent) {
                val action = intent.action
                if (action == "finish_second_activity") {
                    finish()
                    Toast.makeText(this@SecondActivity, "Close Second Activity", Toast.LENGTH_LONG)
                        .show()
                }
            }
        }
        registerReceiver(broadcastReceiver, IntentFilter("finish_second_activity"))
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id: Int = item.itemId
        if (id == R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
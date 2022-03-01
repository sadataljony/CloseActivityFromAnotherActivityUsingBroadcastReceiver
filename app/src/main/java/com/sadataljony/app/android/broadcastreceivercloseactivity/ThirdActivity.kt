package com.sadataljony.app.android.broadcastreceivercloseactivity

import android.R
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.sadataljony.app.android.broadcastreceivercloseactivity.databinding.ActivityThirdBinding


class ThirdActivity : AppCompatActivity() {

    private lateinit var binding: ActivityThirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setToolbar()
        setClickListener()
    }

    private fun setToolbar() {
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
    }

    private fun setClickListener() {
        binding.btnCloseThisActivity.setOnClickListener {
            finish()
        }
        binding.btnGoToSecondActivity.setOnClickListener {
            val intent = Intent("finish_second_activity")
            sendBroadcast(intent)
            finish()
        }
        binding.btnGoToFirstActivity.setOnClickListener {
            val intent = Intent("finish_first_activity")
            sendBroadcast(intent)
            finish()
        }
        binding.btnGoBackToPreviousActivity.setOnClickListener {
            finish()
        }
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
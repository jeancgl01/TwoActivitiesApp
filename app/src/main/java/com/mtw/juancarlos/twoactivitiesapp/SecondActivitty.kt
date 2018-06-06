package com.mtw.juancarlos.twoactivitiesapp

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_second_activitty.*

class SecondActivitty : AppCompatActivity() {

    companion object {
        val EXTRA_REPLY = "com.mtw.juancarlos.twoactivitiesapp.extra.REPLY"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_activitty)

        //Log.e("SECOND", "VALOR:" + intent.getStringExtra(MainActivity.EXTRA_MESSAGE))
        text_message.text = intent.getStringExtra(MainActivity.EXTRA_MESSAGE)

    }

    fun returnReply(view:View){
        val replyString = editText_second.text.toString()
        val replyIntent = Intent()
        replyIntent.putExtra(EXTRA_REPLY,replyString)
        setResult(Activity.RESULT_OK,replyIntent)
        finish()
    }

}

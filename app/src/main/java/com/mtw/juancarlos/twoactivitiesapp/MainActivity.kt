package com.mtw.juancarlos.twoactivitiesapp

import android.app.Activity
import android.content.Intent
import android.opengl.Visibility
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.util.Log
import android.view.View
import com.mtw.juancarlos.twoactivitiesapp.R.id.text_message_reply
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val LOG_TAG = MainActivity::class.java.simpleName

    companion object {
        val EXTRA_MESSAGE = "com.mtw.juancarlos.twoactivitiesapp.extra.MESSAGE"
        val TEXT_REQUEST = 1
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun launchSecondActivity(view: View){
        Log.d(LOG_TAG,"button clicked!")

        val message = editText_main.text.toString()
        val intent = Intent(this,SecondActivitty::class.java)
        intent.putExtra(EXTRA_MESSAGE,message)
        //startActivity(intent)
        startActivityForResult(intent, TEXT_REQUEST)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == TEXT_REQUEST && resultCode == Activity.RESULT_OK ){
            val reply = data?.getStringExtra(SecondActivitty.EXTRA_REPLY) ?: ""
            text_header_reply.visibility = View.VISIBLE
            text_message_reply.text = reply
            text_message_reply.visibility = View.VISIBLE
        }

    }
}

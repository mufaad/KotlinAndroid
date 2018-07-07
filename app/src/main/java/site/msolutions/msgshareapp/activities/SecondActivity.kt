package site.msolutions.msgshareapp.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.second_layout.*
import site.msolutions.msgshareapp.Constants
import site.msolutions.msgshareapp.R

class SecondActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_layout)

        var allData = intent.extras

        allData?.let {
//Constants is a object of your app, AppConstants.kt
            var msg = allData.getString(Constants.USER_MSG_KEY)
            lblDisplay.text = msg
        }

    }
}
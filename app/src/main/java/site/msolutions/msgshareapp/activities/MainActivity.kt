package site.msolutions.msgshareapp.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import site.msolutions.msgshareapp.Constants
import site.msolutions.msgshareapp.R
import site.msolutions.msgshareapp.showToast

class MainActivity:AppCompatActivity(){

    companion object {
        val TAG: String = MainActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnShowToast.setOnClickListener {
            Log.i(TAG, resources.getString(R.string.lbl_button_clicked))
            showToast(resources.getString(R.string.lbl_button_clicked), Toast.LENGTH_LONG)
        }

        btnGotoNext.setOnClickListener {

            var editTxt = txtEdit.text.toString()

            var intent = Intent(this, SecondActivity::class.java)
//Constants is a object of your app, AppConstants.kt
                intent.putExtra(Constants.USER_MSG_KEY, editTxt)

            startActivity(intent)
        }

        btnShare.setOnClickListener {

            var intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT, txtEdit.text.toString())
            intent.type = "text/plain"
            startActivity(Intent.createChooser(intent, "Please Select An App:"))
        }

        //
        btnRecyclerCard.setOnClickListener {

            var intent = Intent(this, RecyclerAndCardViews::class.java)
            startActivity(intent)

        }

        //
    }
}

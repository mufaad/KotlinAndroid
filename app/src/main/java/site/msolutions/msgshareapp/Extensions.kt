package site.msolutions.msgshareapp

import android.content.Context
import android.widget.Toast

fun Context.showToast(msg: String, duration: Int = Toast.LENGTH_SHORT){

    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}
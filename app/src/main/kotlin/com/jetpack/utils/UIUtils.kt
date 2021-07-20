package com.jetpack.utils

import android.app.Activity
import android.content.Context
import android.widget.Toast

object UIUtils {


    fun showTip(context: Context?, message: String, isSuccess: Boolean) {
        val tip = if (isSuccess) " success !" else " fail !!!"

        if (context is Activity){
            context.runOnUiThread{
                Toast.makeText(context, message + tip, Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(context, message + tip, Toast.LENGTH_SHORT).show()
        }

    }

    fun showTip(context: Context?, message: String?) {

        if (context is Activity){
            context.runOnUiThread{
                Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
            }
        } else{
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        }

    }
}

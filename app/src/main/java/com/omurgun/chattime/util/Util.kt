package com.omurgun.chattime.util

import android.content.Context
import android.content.res.Resources
import android.graphics.drawable.Drawable
import androidx.core.content.res.ResourcesCompat
import androidx.swiperefreshlayout.widget.CircularProgressDrawable

class Util {


    companion object {


        fun placeholderProgressBar(context: Context): CircularProgressDrawable {
            return CircularProgressDrawable(context).apply {
                strokeWidth = 8f
                centerRadius = 40f
                start()
            }
        }


        fun getDrawable(id: Int, theme: Resources.Theme): Drawable {
            return ResourcesCompat.getDrawable(theme.resources, id, theme)!!
        }


    }
}
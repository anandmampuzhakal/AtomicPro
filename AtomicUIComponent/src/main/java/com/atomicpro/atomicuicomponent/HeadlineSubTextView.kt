package com.atomicpro.atomicuicomponent

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

class HeadlineTextView (context: Context, attributeSet: AttributeSet) : AppCompatTextView(context, attributeSet) {
    init {
        applyFont()
    }
    fun applyFontSize(float: Float, color: Int ) {
        textSize = float
        setTextColor(color)
    }
    private fun applyFont() {
        val headlineTypeface: Typeface = Typeface.create("Montserrat", Typeface.NORMAL)
        typeface=headlineTypeface
    }

}
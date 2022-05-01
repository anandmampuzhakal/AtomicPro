package com.atomicpro.atomicuicomponent

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

class HeadlineSubTextView (context: Context, attributeSet: AttributeSet) : AppCompatTextView(context, attributeSet) {
    init {
        applyFont()
        applyFontSize()
    }

    private fun applyFontSize() {
        textSize = 14.00f
        setTextColor(Color.GRAY)
    }

    private fun applyFont() {
        val headlineTypeface: Typeface = Typeface.create("Montserrat", Typeface.NORMAL)
        typeface=headlineTypeface
    }

}
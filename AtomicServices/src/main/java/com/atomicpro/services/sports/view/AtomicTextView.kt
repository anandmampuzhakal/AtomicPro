package com.atomicpro.services.sports.view

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

class HeadlineTextView(context: Context, attributeSet: AttributeSet) : AppCompatTextView(context, attributeSet) {
    init {
        applyFont()
    }
    private fun applyFont() {
        val headlineTypeface: Typeface =Typeface.create("Montserrat", Typeface.NORMAL)
        typeface=headlineTypeface
    }

}
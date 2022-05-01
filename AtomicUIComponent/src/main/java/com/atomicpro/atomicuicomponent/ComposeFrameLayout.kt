package com.atomicpro.atomicuicomponent

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.AbstractComposeView
import androidx.compose.ui.platform.ComposeView

class ComposeFrameLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AbstractComposeView(context, attrs, defStyleAttr) {

    // Create a State for the title text so any changes can be observed and reflected automatically
    // in our Composable Text.
    private val titleText = mutableStateOf("")

    // Public getter/setter for our title that delegates to the State value.
    var title: String
        get() = titleText.value
        set(value) {
            titleText.value = value
        }

    @Composable
    override fun Content() {
        Text(
            text = titleText.value,
            modifier = Modifier.fillMaxSize()
        )
    }
}
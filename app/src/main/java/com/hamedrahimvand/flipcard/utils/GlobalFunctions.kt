package com.hamedrahimvand.flipcard.utils

import android.content.Context
import android.util.TypedValue

/**
 *
 *@author Hamed.Rahimvand
 *@since 2020-02-22
 */
object GlobalFunctions {
    fun dpToPx(context: Context, dp: Float) =
        TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            dp,
            context.resources.displayMetrics
        )
}
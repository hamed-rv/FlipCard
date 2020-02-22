package com.hamedrahimvand.flipcard.viewpager_flip_card

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.viewpager.widget.ViewPager
import com.hamedrahimvand.flipcard.utils.GlobalFunctions
import kotlin.math.abs


/**
 *
 *@author Hamed.Rahimvand
 *@since 2020-02-22
 */
class FlipCardViewPager(context: Context, attributeSet: AttributeSet?) :
    ViewPager(context, attributeSet), ViewPager.PageTransformer {

    constructor(context: Context) : this(context, null)

    init {
        setPageTransformer(false, this)
        offscreenPageLimit = 2
        pageMargin = -GlobalFunctions.dpToPx(context, 60f).toInt()
    }

    override fun transformPage(page: View, position: Float) {
        val absolutePosition = abs(position)
        if (position <= -1.0f || position >= 1.0f) {
            // Page is not visible -- stop any running animations
        } else if (position == 0.0f) {
            // Page is selected -- reset any views if necessary
            page.scaleX = (1).toFloat()
            page.scaleY = (1).toFloat()
        } else {
            page.scaleY = if (absolutePosition < 0.1) {
                (1 - absolutePosition)
            } else {
                1 - 0.1f
            }
            page.scaleX = if (absolutePosition < 0.1) {
                (1 - absolutePosition)
            } else {
                1 - 0.1f
            }
        }
    }

}
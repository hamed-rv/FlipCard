package com.hamedrahimvand.flipcard.viewpager_flip_card

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.viewpager.widget.ViewPager
import com.hamedrahimvand.flipcard.utils.GlobalFunctions
import kotlin.math.abs
import kotlin.math.min


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
        val absolutePosition = abs(position) / 5
        if (position <= -1.0f || position >= 1.0f) {
            // Page is not visible -- stop any running animations
        } else if (position == 0.0f) {
            // Page is selected -- reset any views if necessary
            page.scaleX = 1f
            page.scaleY = 1f
            page.alpha = 1f
        } else {
            page.scaleY = 1 - min(absolutePosition,0.2f)
//            page.scaleX = 1 - min(absolutePosition,0.1f)

//            page.alpha = if (abs(position) < 0.3) {
//                (1 - abs(position))
//            } else {
//                1 - 0.3f
//            }
        }
    }

}
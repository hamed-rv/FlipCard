package com.hamedrahimvand.flipcard.landing

import android.content.Intent
import android.os.Bundle
import com.hamedrahimvand.flipcard.R
import com.hamedrahimvand.flipcard.base.BaseActivity
import com.hamedrahimvand.flipcard.simple_flip_card.FlipCardActivity
import com.hamedrahimvand.flipcard.viewpager_flip_card.ViewPagerFlipCardActivity
import kotlinx.android.synthetic.main.activity_landing.*

/**
 *
 *@author Hamed.Rahimvand
 *@since 2020-02-22
 */
class LandingActivity : BaseActivity() {
    override fun layoutId(): Int = R.layout.activity_landing

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tvFlipCard.setOnClickListener {
            startActivity(Intent(this,FlipCardActivity::class.java))
        }
        tvViewPagerFlipCard.setOnClickListener {
            startActivity(Intent(this,ViewPagerFlipCardActivity::class.java))
        }
    }

}
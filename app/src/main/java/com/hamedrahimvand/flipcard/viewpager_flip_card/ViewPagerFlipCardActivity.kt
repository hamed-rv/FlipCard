package com.hamedrahimvand.flipcard.viewpager_flip_card

import android.os.Bundle
import com.hamedrahimvand.flipcard.R
import com.hamedrahimvand.flipcard.base.BaseActivity
import com.hamedrahimvand.flipcard.model.FlipModel
import com.hamedrahimvand.flipcard.utils.GlobalFunctions
import kotlinx.android.synthetic.main.activity_viewpager_flip_card.*

/**
 *
 *@author Hamed.Rahimvand
 *@since 2020-02-22
 * Add FlipCardAnimation to ViewPager's items.
 */
class ViewPagerFlipCardActivity : BaseActivity() {

    private var flipModelList = arrayListOf(
        FlipModel(0, "Page 1", "Hello1!","BACK1"),
        FlipModel(1, "Page 2", "Hello2!","BACK2"),
        FlipModel(2, "Page 3", "Hello3!","BACK3"),
        FlipModel(3, "Page 4", "Hello4!","BACK4"),
        FlipModel(4, "Page 5", "Hello5!","BACK5")
    )

    override fun layoutId(): Int = R.layout.activity_viewpager_flip_card

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vpFlipCard.pageMargin = GlobalFunctions.dpToPx(this, 12f).toInt()
        vpFlipCard.adapter = FlipCardAdapter(flipModelList, supportFragmentManager)
    }

}
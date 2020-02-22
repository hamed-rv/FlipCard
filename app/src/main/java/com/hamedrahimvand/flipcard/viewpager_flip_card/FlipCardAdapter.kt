package com.hamedrahimvand.flipcard.viewpager_flip_card

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.hamedrahimvand.flipcard.model.FlipModel

/**
 *
 *@author Hamed.Rahimvand
 *@since 2020-02-22
 */
class FlipCardAdapter(
    private val flipModelList: ArrayList<FlipModel>,
    fragmentManger: FragmentManager
) : FragmentStatePagerAdapter(fragmentManger) {

    override fun getItem(position: Int): Fragment = FlipCardFragment().apply {
        arguments = FlipCardFragment.getDefaultBundle(flipModelList[position])
    }

    override fun getCount(): Int = flipModelList.size
}
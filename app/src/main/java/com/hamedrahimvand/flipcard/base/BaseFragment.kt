package com.hamedrahimvand.flipcard.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.hamedrahimvand.flipcard.R

/**
 *
 *@author Hamed.Rahimvand
 *@since 2020-02-22
 */
abstract class BaseFragment : Fragment() {

    abstract fun layoutId():Int

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(layoutId(), container, false)
    }

}
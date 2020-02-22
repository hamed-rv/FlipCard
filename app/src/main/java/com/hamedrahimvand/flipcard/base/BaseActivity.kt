package com.hamedrahimvand.flipcard.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hamedrahimvand.flipcard.R

/**
 *
 *@author Hamed.Rahimvand
 *@since 2020-02-22
 */
abstract class BaseActivity : AppCompatActivity() {

    abstract fun layoutId():Int
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId())
    }
}
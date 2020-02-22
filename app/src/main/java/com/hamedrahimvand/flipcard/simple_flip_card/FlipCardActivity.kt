package com.hamedrahimvand.flipcard.simple_flip_card

import android.animation.Animator
import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.os.Bundle
import com.hamedrahimvand.flipcard.R
import com.hamedrahimvand.flipcard.base.BaseActivity
import kotlinx.android.synthetic.main.activity_flip_card.*

/**
 *@author Hamed.Rahimvand
 *@since 2020-02-22
 * Basic implementation of FlipCard with clockwise and counter-clockwise modes.
 */
class FlipCardActivity : BaseActivity() {

    override fun layoutId(): Int = R.layout.activity_flip_card
    //CounterClockWise
    private lateinit var animatorSetLeftIn: AnimatorSet
    private lateinit var animatorSetRightOut: AnimatorSet
    //ClockWise
    private lateinit var animatorSetLeftOut: AnimatorSet
    private lateinit var animatorSetRightIn: AnimatorSet

    private var isBackVisible = false
    private var canFlip = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadAnimations()
        changeCameraDistance()
        ibFlip.setOnClickListener {
            flipCard()
        }
        ibFlipClockWise.setOnClickListener {
            flipClockWise()
        }
        ibFlipCounterClockWise.setOnClickListener {
            flipCounterClockWise()
        }
    }

    private fun loadAnimations() {
        animatorSetLeftIn = AnimatorInflater.loadAnimator(
            this,
            R.animator.left_in_anim
        ) as AnimatorSet
        animatorSetRightOut = AnimatorInflater.loadAnimator(
            this,
            R.animator.right_out_anim
        ) as AnimatorSet

        animatorSetLeftOut = AnimatorInflater.loadAnimator(
            this,
            R.animator.left_out_anim
        ) as AnimatorSet
        animatorSetRightIn = AnimatorInflater.loadAnimator(
            this,
            R.animator.right_in_anim
        ) as AnimatorSet

        animatorSetLeftIn.addListener(object : Animator.AnimatorListener {
            override fun onAnimationRepeat(animation: Animator?) {
            }

            override fun onAnimationEnd(animation: Animator?) {
                canFlip = true
            }

            override fun onAnimationCancel(animation: Animator?) {
            }

            override fun onAnimationStart(animation: Animator?) {
                canFlip = false
            }

        })
        animatorSetLeftOut.addListener(object : Animator.AnimatorListener {
            override fun onAnimationRepeat(animation: Animator?) {
            }

            override fun onAnimationEnd(animation: Animator?) {
                canFlip = true
            }

            override fun onAnimationCancel(animation: Animator?) {
            }

            override fun onAnimationStart(animation: Animator?) {
                canFlip = false
            }

        })
    }

    private fun changeCameraDistance() {
        val distance = 8000
        val scale = resources.displayMetrics.density * distance
        cardFront.cameraDistance = scale
        cardBack.cameraDistance = scale
    }

    private fun flipCard() {
        if (!isBackVisible) {
            flipClockWise()
        } else {
            flipCounterClockWise()
        }
    }

    private fun flipClockWise() {
        if (!canFlip) return
        if (!isBackVisible) {
            animatorSetLeftOut.setTarget(cardFront)
            animatorSetRightIn.setTarget(cardBack)
        } else {
            animatorSetLeftOut.setTarget(cardBack)
            animatorSetRightIn.setTarget(cardFront)
        }
        animatorSetLeftOut.start()
        animatorSetRightIn.start()
        isBackVisible = !isBackVisible
    }

    private fun flipCounterClockWise() {
        if (!canFlip) return
        if (!isBackVisible) {
            animatorSetRightOut.setTarget(cardFront)
            animatorSetLeftIn.setTarget(cardBack)
        } else {
            animatorSetRightOut.setTarget(cardBack)
            animatorSetLeftIn.setTarget(cardFront)
        }
        animatorSetRightOut.start()
        animatorSetLeftIn.start()
        isBackVisible = !isBackVisible
    }
}

package com.hamedrahimvand.flipcard.viewpager_flip_card

import android.animation.Animator
import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.os.Bundle
import android.view.View
import com.hamedrahimvand.flipcard.R
import com.hamedrahimvand.flipcard.base.BaseFragment
import com.hamedrahimvand.flipcard.model.FlipModel
import kotlinx.android.synthetic.main.fragment_flip_card.*

/**
 *
 *@author Hamed.Rahimvand
 *@since 2020-02-22
 */
class FlipCardFragment : BaseFragment() {

    override fun layoutId(): Int = R.layout.fragment_flip_card
    //CounterClockWise
    private lateinit var animatorSetLeftIn: AnimatorSet
    private lateinit var animatorSetRightOut: AnimatorSet
    //ClockWise
    private lateinit var animatorSetLeftOut: AnimatorSet
    private lateinit var animatorSetRightIn: AnimatorSet

    private var isBackVisible = false
    private var canFlip = true

    private var flipModel: FlipModel? = null

    companion object {
        const val FLIP_MODEL_KEY = "FLIP_MODEL_KEY"
        fun getDefaultBundle(flipModel: FlipModel): Bundle = Bundle().apply {
            putSerializable(
                FLIP_MODEL_KEY,
                flipModel
            )
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        flipModel = arguments?.getSerializable(FLIP_MODEL_KEY) as FlipModel?
        setupView()
        loadAnimations()
        changeCameraDistance()

    }

    private fun setupView() {
        tvTitle.text = flipModel?.name
        tvContent.text = flipModel?.message
        tvContentBack.text = flipModel?.backMessage
        ibFlipBack.setOnClickListener {
            flipCard()
        }
        ibFlipFront.setOnClickListener {
            ibFlipBack.performClick()
        }
    }

    private fun loadAnimations() {
        animatorSetLeftIn = AnimatorInflater.loadAnimator(
            context,
            R.animator.left_in_anim
        ) as AnimatorSet
        animatorSetRightOut = AnimatorInflater.loadAnimator(
            context,
            R.animator.right_out_anim
        ) as AnimatorSet

        animatorSetLeftOut = AnimatorInflater.loadAnimator(
            context,
            R.animator.left_out_anim
        ) as AnimatorSet
        animatorSetRightIn = AnimatorInflater.loadAnimator(
            context,
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
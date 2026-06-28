package com.flux.ui.common

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically

// Consistent animation duration for all transitions
private const val ANIM_DURATION = 250

// --- Fade + Scale (Forward navigation) ---
fun defaultScreenEnterAnimation(): EnterTransition {
    return fadeIn(animationSpec = tween(ANIM_DURATION)) +
            scaleIn(
                initialScale = 0.92f,
                animationSpec = tween(ANIM_DURATION)
            )
}

fun defaultScreenExitAnimation(): ExitTransition {
    return fadeOut(animationSpec = tween(ANIM_DURATION)) +
            scaleOut(
                targetScale = 0.92f,
                animationSpec = tween(ANIM_DURATION)
            )
}

// --- Fade + slight slide (Pop / Back navigation) ---
fun popScreenEnterAnimation(): EnterTransition {
    return fadeIn(animationSpec = tween(ANIM_DURATION)) +
            slideInHorizontally(
                initialOffsetX = { fullWidth -> -fullWidth / 8 },
                animationSpec = tween(ANIM_DURATION)
            )
}

fun popScreenExitAnimation(): ExitTransition {
    return fadeOut(animationSpec = tween(ANIM_DURATION)) +
            slideOutHorizontally(
                targetOffsetX = { fullWidth -> fullWidth / 4 },
                animationSpec = tween(ANIM_DURATION)
            )
}

// --- Slide From/To Bottom (Detail screens) ---
fun slideFromBottomEnter(): EnterTransition {
    return slideInVertically(
        initialOffsetY = { fullHeight -> fullHeight },
        animationSpec = tween(ANIM_DURATION)
    ) + fadeIn(animationSpec = tween(ANIM_DURATION))
}

fun slideToBottomExit(): ExitTransition {
    return slideOutVertically(
        targetOffsetY = { fullHeight -> fullHeight },
        animationSpec = tween(ANIM_DURATION)
    ) + fadeOut(animationSpec = tween(ANIM_DURATION))
}

// --- Pop variants for bottom slide (slide out to bottom, slide in from bottom) ---
fun popSlideFromBottomEnter(): EnterTransition {
    return slideInVertically(
        initialOffsetY = { fullHeight -> fullHeight / 4 },
        animationSpec = tween(ANIM_DURATION)
    ) + fadeIn(animationSpec = tween(ANIM_DURATION))
}

fun popSlideToBottomExit(): ExitTransition {
    return slideOutVertically(
        targetOffsetY = { fullHeight -> fullHeight / 2 },
        animationSpec = tween(ANIM_DURATION)
    ) + fadeOut(animationSpec = tween(ANIM_DURATION))
}

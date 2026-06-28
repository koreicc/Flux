package com.flux.navigation

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.runtime.Composable
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDeepLink
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.flux.ui.common.defaultScreenEnterAnimation
import com.flux.ui.common.defaultScreenExitAnimation
import com.flux.ui.common.popScreenEnterAnimation
import com.flux.ui.common.popScreenExitAnimation
import com.flux.ui.common.popSlideFromBottomEnter
import com.flux.ui.common.popSlideToBottomExit
import com.flux.ui.common.slideFromBottomEnter
import com.flux.ui.common.slideToBottomExit


fun NavGraphBuilder.animatedComposable(
    route: String,
    arguments: List<NamedNavArgument> = emptyList(),
    deepLinks: List<NavDeepLink> = emptyList(),
    content: @Composable AnimatedVisibilityScope.(NavBackStackEntry) -> Unit
) = composable(
    route = route,
    arguments = arguments,
    deepLinks = deepLinks,
    enterTransition = { defaultScreenEnterAnimation() },
    exitTransition = { defaultScreenExitAnimation() },
    popEnterTransition = { popScreenEnterAnimation() },
    popExitTransition = { popScreenExitAnimation() },
    content = content
)

fun NavGraphBuilder.bottomSlideComposable(
    route: String,
    arguments: List<NamedNavArgument> = emptyList(),
    deepLinks: List<NavDeepLink> = emptyList(),
    content: @Composable AnimatedVisibilityScope.(NavBackStackEntry) -> Unit
) = composable(
    route = route,
    arguments = arguments,
    deepLinks = deepLinks,
    enterTransition = { slideFromBottomEnter() },
    exitTransition = { slideToBottomExit() },
    popEnterTransition = { popSlideFromBottomEnter() },
    popExitTransition = { popSlideToBottomExit() },
    content = content
)

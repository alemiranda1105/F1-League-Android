package es.alejandrom.f1league.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import es.alejandrom.f1league.presentation.HomeScreen
import es.alejandrom.f1league.presentation.WelcomeScreen
import es.alejandrom.f1league.presentation.login.LoginScreen
import es.alejandrom.f1league.presentation.signup.SignUpScreen
import es.alejandrom.f1league.routes.Routes

@Composable
@ExperimentalAnimationApi
@ExperimentalComposeUiApi
fun NavGraph(navController: NavHostController) {
    AnimatedNavHost(
        navController = navController,
        startDestination = Routes.WELCOME.route,
        enterTransition = { scaleIn() } ,
        exitTransition = { scaleOut(animationSpec = tween(durationMillis = 250)) }
    ) {
        composable(Routes.WELCOME.route) {
            WelcomeScreen(
                navigateToLoginScreen = {
                    navController.navigate(Routes.LOGIN.route)
                },
                navigateToSignUpScreen = {
                    navController.navigate(Routes.SIGNUP.route)
                }
            )
        }
        composable(
            route = Routes.SIGNUP.route
        ) {
            SignUpScreen(
                navigateBack = {
                    navController.popBackStack()
                }
            )
        }

        composable(
            route = Routes.LOGIN.route
        ) {
            LoginScreen(
                navigateBack = {
                    navController.popBackStack()
                }
            )
        }

        composable(
            route = Routes.HOME.route
        ) {
            HomeScreen()
        }
    }
}
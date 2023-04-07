package es.alejandrom.f1league.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import es.alejandrom.f1league.presentation.signup.SignUpViewModel
import es.alejandrom.f1league.presentation.signup.components.SignUpContent
import es.alejandrom.f1league.presentation.signup.components.SignUpTopBar

@Composable
@ExperimentalComposeUiApi
fun SignUpScreen(
    signUpViewModel: SignUpViewModel = hiltViewModel(),
    navigateBack: () -> Unit
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            SignUpTopBar(navigateBack = navigateBack)
        }
    ) { innerPadding ->
        SignUpContent(
            padding = innerPadding,
            signUp = { email, password ->
                signUpViewModel.signUpWithEmailAndPassword(email, password)
            }
        )
    }
}
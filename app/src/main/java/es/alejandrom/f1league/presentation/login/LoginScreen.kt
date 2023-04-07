package es.alejandrom.f1league.presentation.login

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import es.alejandrom.f1league.presentation.login.components.LoginContent
import es.alejandrom.f1league.presentation.login.components.LoginTopBar

@Composable
@ExperimentalComposeUiApi
fun LoginScreen(
    loginViewModel: LoginViewModel = hiltViewModel(),
    navigateBack: () -> Unit
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            LoginTopBar(
                navigateBack = navigateBack
            )
        }
    ) { innerPadding ->
        LoginContent(
            padding = innerPadding,
            login = { email, password ->
                loginViewModel.signInWithEmailAndPassword(email, password)
            }
        )
    }
}

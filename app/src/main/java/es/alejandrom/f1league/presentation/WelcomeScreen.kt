package es.alejandrom.f1league.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import es.alejandrom.f1league.R
import es.alejandrom.f1league.routes.Routes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WelcomeScreen(
    navigateToLoginScreen: () -> Unit,
    navigateToSignUpScreen: () -> Unit
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
                 LargeTopAppBar(
                     title = {
                         Text(text = stringResource(id = R.string.welcome))
                     }
                 )
        }
    ) { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = stringResource(id = R.string.welcome_message),
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier
                        .padding(bottom = 32.dp)
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 32.dp)
                ) {
                    Button(
                        onClick = navigateToLoginScreen,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        shape = RoundedCornerShape(20.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.primary,
                            contentColor = MaterialTheme.colorScheme.onPrimary
                        )
                    ) {
                        Text(text = stringResource(id = R.string.login), style = MaterialTheme.typography.labelLarge)
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(
                        onClick = navigateToSignUpScreen,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        shape = RoundedCornerShape(20.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.secondary,
                            contentColor = MaterialTheme.colorScheme.onSecondary
                        )
                    ) {
                        Text(text = stringResource(id = R.string.sign_up), style = MaterialTheme.typography.labelLarge)
                    }
                }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WelcomeViewPreview() {
    val navController = rememberNavController()
    WelcomeScreen(
        navigateToLoginScreen = {
            navController.navigate(Routes.LOGIN.route)
        },
        navigateToSignUpScreen = {
            navController.navigate(Routes.SIGNUP.route)
        }
    )
}
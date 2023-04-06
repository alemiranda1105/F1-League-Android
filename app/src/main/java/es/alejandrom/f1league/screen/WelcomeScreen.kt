package es.alejandrom.f1league.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import es.alejandrom.f1league.routes.Routes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WelcomeView(navController: NavHostController) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
                 LargeTopAppBar(
                     title = {
                         Text(text = "Welcome")
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
                    text = "Welcome to F1 League! Sign in or create an account to start playing with your friends",
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
                        onClick = { navController.navigate(Routes.LOGIN.route) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        shape = RoundedCornerShape(20.dp)
                    ) {
                        Text(text = "Login", style = MaterialTheme.typography.labelLarge)
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(
                        onClick = { navController.navigate(Routes.SIGNUP.route) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        shape = RoundedCornerShape(20.dp)
                    ) {
                        Text(text = "Sign up", style = MaterialTheme.typography.labelLarge)
                    }
                }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WelcomeViewPreview() {
    val navController = rememberNavController()
    WelcomeView(navController = navController)
}
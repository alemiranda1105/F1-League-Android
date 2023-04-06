package es.alejandrom.f1league

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import es.alejandrom.f1league.routes.Routes
import es.alejandrom.f1league.screen.LoginScreen
import es.alejandrom.f1league.screen.SignUpScreen
import es.alejandrom.f1league.screen.WelcomeView
import es.alejandrom.f1league.ui.theme.F1LeagueTheme

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            F1LeagueTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LoginView()
                }
            }
        }
    }
}

@Composable
fun LoginView() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.WELCOME.route) {
        composable(Routes.WELCOME.route) {
            WelcomeView(navController = navController)
        }
        composable(Routes.LOGIN.route) {
            LoginScreen(navController = navController)
        }
        composable(Routes.SIGNUP.route) {
            SignUpScreen(navController = navController)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    F1LeagueTheme {
        LoginView()
    }
}
package es.alejandrom.f1league.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import es.alejandrom.f1league.components.login.PasswordField

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreen(navController: NavHostController) {
    val (email, setEmail) = remember { mutableStateOf("") }
    val (emailConfirmation, setEmailConfirmation) = remember { mutableStateOf("") }
    val (password, setPassword) = remember { mutableStateOf("") }
    val (passwordConfirmation, setPasswordConfirmation) = remember { mutableStateOf("") }
    val (passwordVisibility, setPasswordVisibility) = remember { mutableStateOf(false) }

    val focusManager = LocalFocusManager.current

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        "Create Account",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.popBackStack()
                    }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Back button")
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(40.dp, Alignment.Top),
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
                .fillMaxSize()
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.Top)
            ) {
                TextField(
                    value = email,
                    onValueChange = setEmail,
                    label = {
                        Text("Email")
                    },
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(
                        capitalization = KeyboardCapitalization.None,
                        autoCorrect = false,
                        keyboardType = KeyboardType.Email,
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions(onNext = {
                        focusManager.moveFocus(FocusDirection.Down)
                    })
                )

                TextField(
                    value = emailConfirmation,
                    onValueChange = setEmailConfirmation,
                    label = {
                        Text("Email confirmation")
                    },
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(
                        capitalization = KeyboardCapitalization.None,
                        autoCorrect = false,
                        keyboardType = KeyboardType.Email,
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions(onNext = {
                        focusManager.moveFocus(FocusDirection.Down)
                    })
                )

                PasswordField(
                    password = password,
                    passwordVisibility = passwordVisibility,
                    onPasswordChange = setPassword,
                    onPasswordVisibilityChange = setPasswordVisibility,
                    keyboardOptions = KeyboardOptions(
                        capitalization = KeyboardCapitalization.None,
                        autoCorrect = false,
                        keyboardType = KeyboardType.Password,
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions(onNext = {
                        focusManager.moveFocus(FocusDirection.Down)
                    })
                )

                PasswordField(
                    password = passwordConfirmation,
                    label = "Password confirmation",
                    passwordVisibility = passwordVisibility,
                    onPasswordChange = setPasswordConfirmation,
                    onPasswordVisibilityChange = setPasswordVisibility,
                    keyboardActions = KeyboardActions(onDone = { /*TODO */})
                )
            }
            Button(
                onClick = { /* TODO */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(20.dp)
            ) {
                Text(text = "Create account", style = MaterialTheme.typography.labelLarge)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignUpScreen() {
    val navController = rememberNavController()
    SignUpScreen(navController = navController)
}
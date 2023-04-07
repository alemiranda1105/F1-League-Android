package es.alejandrom.f1league.presentation.signup.components

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import es.alejandrom.f1league.R
import es.alejandrom.f1league.components.BackIcon

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpTopBar(
    navigateBack: () -> Unit
) {
    CenterAlignedTopAppBar (
        title = {
            Text(
                text = stringResource(id = R.string.sign_up)
            )
        },
        navigationIcon = {
            BackIcon(
                navigateBack = navigateBack
            )
        }
    )
}
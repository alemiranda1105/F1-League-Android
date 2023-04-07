package es.alejandrom.f1league.presentation.signup

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import es.alejandrom.f1league.domain.model.Response
import es.alejandrom.f1league.domain.repository.AuthRepository
import es.alejandrom.f1league.domain.repository.SignUpResponse
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {
    var signUpResponse by mutableStateOf<SignUpResponse>(Response.Success(false))
        private set

    fun signUpWithEmailAndPassword(email: String, password: String) = viewModelScope.launch {
        signUpResponse = Response.Loading
        signUpResponse = authRepository.firebaseSignUpWithEmailAndPassword(email, password)
    }
}
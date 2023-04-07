package es.alejandrom.f1league.presentation

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import es.alejandrom.f1league.domain.repository.AuthRepository
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {
    fun signOut() = authRepository.signOut()
}
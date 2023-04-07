package es.alejandrom.f1league

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import es.alejandrom.f1league.domain.repository.AuthRepository
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {
    init {
        getAuthState()
    }

    fun getAuthState() = authRepository.getAuthState(viewModelScope)
}
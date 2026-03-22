package net.thechance.caffine.screen.amount

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class CoffeeAmountViewModel: ViewModel(), CoffeeAmountInteractions {

    private val _state: MutableStateFlow<CoffeeAmountScreenState> = MutableStateFlow(CoffeeAmountScreenState())
    val state: StateFlow<CoffeeAmountScreenState> = _state

    override fun onClickContinue() {
        // Navigate to next destination
    }

    override fun onChangeCupSize(newSize: Int) {
        _state.update { it.copy(
            cupSizeIndex = newSize
        ) }
    }

    override fun onChangeCaffineAmount(newAmount: Int) {
        _state.update { it.copy(
            caffineAmountIndex = newAmount
        ) }
    }

}
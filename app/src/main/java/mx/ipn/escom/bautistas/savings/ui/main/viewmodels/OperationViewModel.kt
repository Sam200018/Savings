package mx.ipn.escom.bautistas.savings.ui.main.viewmodels


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import java.time.LocalDateTime
import java.util.Date


class OperationViewModel : ViewModel() {
    var date: LocalDateTime by mutableStateOf(LocalDateTime.now())
        private set

    var account: String by mutableStateOf("")
        private set

    var category: String by mutableStateOf("")
        private set

    var amount: String by mutableStateOf("")
        private set

    var note: String by mutableStateOf("")
        private set

    var type: String by mutableStateOf("")
        private set

    fun onDateChanged(date: LocalDateTime) {
        this.date = date
    }

    fun onAccountChanged(account: String) {
        this.account = account
    }

    fun onCategoryChanged(category: String) {
        this.category = category
    }

    fun onAmountChanged(amount: String) {
        this.amount = amount
    }

    fun onNoteChanged(note: String) {
        this.note = note
    }

    fun onTypeChanged(type: String) {
        this.type = type
    }

}
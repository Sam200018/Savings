package mx.ipn.escom.bautistas.savings.ui.main.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import mx.ipn.escom.bautistas.savings.domain.model.Operation
import java.time.DayOfWeek
import java.time.LocalDateTime
import java.time.temporal.TemporalAdjusters

class OperationsViewModel : ViewModel() {

    var operations: MutableList<Operation> by mutableStateOf(mutableListOf())
        private set

    init {
        val now = LocalDateTime.now()
        operations.filter { it.date.toLocalDate() == now.toLocalDate() }
    }

    var filterSelected: Int by mutableIntStateOf(0)
        private set

    fun addOperation(operation: Operation) {
        operations.add(operation)
    }

    fun onFilterSelectedChanged(filterOption: Int) {
        filterSelected = filterOption
    }

}
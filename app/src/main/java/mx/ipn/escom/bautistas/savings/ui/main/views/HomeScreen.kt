package mx.ipn.escom.bautistas.savings.ui.main.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import mx.ipn.escom.bautistas.savings.domain.model.Operation
import mx.ipn.escom.bautistas.savings.ui.components.BalanceComponent
import mx.ipn.escom.bautistas.savings.ui.components.OperationComponent
import mx.ipn.escom.bautistas.savings.ui.components.TabsComponent
import mx.ipn.escom.bautistas.savings.ui.main.viewmodels.OperationsViewModel
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.temporal.TemporalAdjusters


@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    operationsMap: Map<LocalDate, List<Operation>>,
    addOperation: () -> Unit,
    operations: List<Operation>,
    operationsViewModel: OperationsViewModel
) {
    Scaffold(topBar = {
        Column {
            TopAppBar(
                title = { Text(text = "Fecha") },
            )
            TabsComponent(filterSelected = operationsViewModel.filterSelected) {
                operationsViewModel.onFilterSelectedChanged(it)
            }
        }
    }, floatingActionButton = {
        FloatingActionButton(onClick = { addOperation() }) {
            Icon(Icons.Filled.Add, "")
        }
    }
    ) {
        Box(modifier = Modifier.padding(it)) {
            LazyColumn {
                item {
                    BalanceComponent(operations = operations)
                }
                items(operationsMap.keys.size) { key ->
                    val keyOp = operationsMap.keys.toList()[key]
                    val operationsGroup = operationsMap[keyOp]
                    OperationComponent(date = keyOp, operationsGroup = operationsGroup!!)
                }
            }
        }
    }
}

fun filterByOption(optionSelected: Int, operations: List<Operation>): List<Operation> {
    return when (optionSelected) {
        0 -> {
            val now = LocalDateTime.now()
            operations.filter { it.date.toLocalDate() == now.toLocalDate() }
        }

        1 -> {
            val startOfWeek = LocalDateTime.now().with(
                TemporalAdjusters.previousOrSame(
                    DayOfWeek.MONDAY
                )
            )

            val endOfWeek =
                LocalDateTime.now()
                    .with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY))

            operations.filter {
                it.date.dayOfWeek >= startOfWeek.dayOfWeek && it.date.isBefore(endOfWeek)
            }
        }

        2 -> {
            val startOfMonth = LocalDateTime.now().withDayOfMonth(1)

            val endOfMonth = LocalDateTime.now()
                .withDayOfMonth(LocalDateTime.now().month.length(false))

            operations.filter {
                it.date.isAfter(startOfMonth) && it.date.isBefore(endOfMonth)
            }
        }

        else -> {
            operations
        }
    }
}

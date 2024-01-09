package mx.ipn.escom.bautistas.savings.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import mx.ipn.escom.bautistas.savings.domain.model.Operation
import java.time.LocalDate

@Composable
fun OperationComponent(
    modifier: Modifier = Modifier,
    date: LocalDate = LocalDate.MIN,
    operationsGroup: List<Operation> = listOf(),
) {
    val sumPos = operationsGroup.filter { it.type == "Ingreso" }.sumOf { it.amount.toDouble() }
    val sumNeg = operationsGroup.filter { it.type == "Gasto" }.sumOf { it.amount.toDouble() }
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(2.dp)
    ) {
        Column(modifier.fillMaxWidth()) {
            Divider(thickness = 5.dp)
//            Balance Operation
            Row(modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                DateInfoComponent(date = date)
                Box(
                    modifier
                        .width(150.dp)
                        .height(50.dp), contentAlignment = Alignment.Center
                ) {
                    Row(
                        modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Text(text = sumPos.toString(), style = TextStyle(color = Color.Green))
                        Text(text = sumNeg.toString(), style = TextStyle(color = Color.Red))
                    }
                }
            }
            Divider()
            operationsGroup.forEach { operation ->
                OperationsInfoComponent(operation = operation)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun OperationComponentPrev() {
    OperationComponent()
}
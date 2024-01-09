package mx.ipn.escom.bautistas.savings.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import mx.ipn.escom.bautistas.savings.domain.model.Operation
import java.time.LocalDate

@Composable
fun BalanceComponent(
    modifier: Modifier = Modifier,
    operations: List<Operation>,
) {

    val sumPos = operations.filter { it.type == "Ingreso" }.sumOf { it.amount.toDouble() }
    val sumNeg = operations.filter { it.type == "Gasto" }.sumOf { it.amount.toDouble() }
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(50.dp)
            .padding(5.dp)
    ) {
        Row(modifier.fillMaxSize(), horizontalArrangement = Arrangement.SpaceAround) {
            Column {
                Text(text = "Ingreso")
                Text(text = sumPos.toString(), style = TextStyle(color = Color.Green))
            }
            Column {
                Text(text = "Gasto")
                Text(text = sumNeg.toString(), style = TextStyle(color = Color.Red))
            }
            Column {
                Text(text = "Total")
                Text(text = "${sumPos - sumNeg}")
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun BalancePrev() {
    BalanceComponent(operations = listOf())
}
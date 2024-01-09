package mx.ipn.escom.bautistas.savings.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import mx.ipn.escom.bautistas.savings.domain.model.Operation

@Composable
fun OperationsInfoComponent(
    modifier: Modifier = Modifier,
    operation: Operation = Operation(),
) {
    Row(
        modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(text = operation.category)
        Box {
            Column {
                Text(text = operation.note)
                Text(text = operation.account)
            }
        }
        Box(modifier.width(150.dp)) {
            if (operation.type == "Ingreso") {
                Row(
                    modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start
                ) {
                    Text(text = operation.amount.toString())
                }
            } else {
                Row(
                    modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End
                ) {
                    Text(text = operation.amount.toString())
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun OperationsInfoPrev() {
    OperationsInfoComponent()
}
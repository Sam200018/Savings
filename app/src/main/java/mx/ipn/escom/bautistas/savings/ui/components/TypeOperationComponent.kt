package mx.ipn.escom.bautistas.savings.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TypeOperationComponent(
    modifier: Modifier = Modifier,
    value: String = "",
    onSelectOption: (String) -> Unit
) {
    val radioOptions = listOf("Ingreso", "Gasto")

    Column(modifier.selectableGroup()) {
        radioOptions.forEach { option ->
            Row(modifier
                .fillMaxWidth()
                .height(56.dp)
                .selectable(
                    selected = (option == value), onClick = {

                        onSelectOption(option)
                    }
                )
                .padding(horizontal = 16.dp), verticalAlignment = Alignment.CenterVertically) {
                RadioButton(selected = (option == value), onClick = null)
                Text(
                    text = option,
                    style = MaterialTheme.typography.body1,
                    modifier = modifier.padding(16.dp)
                )

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TypeOperationPrev() {
    TypeOperationComponent() {}
}
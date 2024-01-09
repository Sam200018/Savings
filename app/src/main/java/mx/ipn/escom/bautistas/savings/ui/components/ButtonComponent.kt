package mx.ipn.escom.bautistas.savings.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ButtonComponent(
    modifier: Modifier = Modifier,
    text: String = "",
    onAction: ()->Unit
) {
    Button(onClick = { onAction() },modifier.fillMaxWidth()) {
        Text(text = text)
    }
}

@Preview
@Composable
fun ButtonPrev() {
    ButtonComponent(){}
}
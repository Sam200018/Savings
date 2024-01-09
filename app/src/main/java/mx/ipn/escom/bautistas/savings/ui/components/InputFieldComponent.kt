package mx.ipn.escom.bautistas.savings.ui.components

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun InputFieldComponent(
    modifier: Modifier = Modifier,
    value: String = "",
    label: String = "",
    keyboardOptions: KeyboardOptions = KeyboardOptions(),
    readOnly: Boolean = false,
    onChanged: (String) -> Unit
) {
    Column {
        TextField(
            value = value,
            onValueChange = onChanged,
            label = {
                Text(text = label)
            },
            readOnly = readOnly,
            modifier = modifier.fillMaxWidth(),
            keyboardOptions = keyboardOptions
        )
        Spacer(modifier = modifier.height(5.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun InputFieldPrev() {
    InputFieldComponent() {}
}
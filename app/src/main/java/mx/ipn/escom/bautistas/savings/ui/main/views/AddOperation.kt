package mx.ipn.escom.bautistas.savings.ui.main.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import mx.ipn.escom.bautistas.savings.domain.model.Operation
import mx.ipn.escom.bautistas.savings.ui.components.ButtonComponent
import mx.ipn.escom.bautistas.savings.ui.components.DatePickerComponent
import mx.ipn.escom.bautistas.savings.ui.components.InputFieldComponent
import mx.ipn.escom.bautistas.savings.ui.components.TypeOperationComponent
import mx.ipn.escom.bautistas.savings.ui.main.viewmodels.OperationViewModel
import java.time.ZoneId
import java.util.Date

@Composable
fun AddOperation(
    modifier: Modifier = Modifier,
    back: () -> Unit,
    operationViewModel: OperationViewModel,
    saveOperation: (Operation) -> Unit
) {

    val mContext = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Agregar operacion") },
                navigationIcon = {
                    IconButton(onClick = { back() }) {
                        Icon(Icons.Filled.ArrowBack, "")
                    }
                }
            )
        }
    ) {
        Box(modifier.padding(it)) {
            Column(
                modifier
                    .fillMaxSize()
                    .padding(10.dp)
            ) {
                DatePickerComponent(
                    context = mContext,
                    date = Date.from(
                        operationViewModel.date.atZone(ZoneId.systemDefault()).toInstant()
                    )
                ) {
                    val ldt = it.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime()
                    operationViewModel.onDateChanged(ldt)
                }
                InputFieldComponent(
                    value = operationViewModel.account,
                    label = "Cuenta"
                ) { accountValue ->
                    operationViewModel.onAccountChanged(accountValue)
                }
                InputFieldComponent(
                    value = operationViewModel.category,
                    label = "Categoria"
                ) { categoryValue ->
                    operationViewModel.onCategoryChanged(categoryValue)
                }
                InputFieldComponent(
                    value = operationViewModel.amount,
                    label = "Importe",
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                ) { amountValue ->
                    operationViewModel.onAmountChanged(amountValue)
                }
                InputFieldComponent(value = operationViewModel.note, label = "Nota") { noteValue ->
                    operationViewModel.onNoteChanged(noteValue)
                }
                TypeOperationComponent(value = operationViewModel.type) { typeValue ->
                    operationViewModel.onTypeChanged(typeValue)
                }
                ButtonComponent(text = "Guardar") {
                    back()
                    val operation = Operation(
                        id = 0,
                        date = operationViewModel.date,
                        account = operationViewModel.account,
                        category = operationViewModel.category,
                        type = operationViewModel.type,
                        note = operationViewModel.note,
                        amount = operationViewModel.amount.toFloat()
                    )
                    saveOperation(operation)
                }

            }
        }
    }
}

@Preview
@Composable
fun AddOperationPrev() {
    AddOperation(back = {

    }, operationViewModel = OperationViewModel()) {

    }
}
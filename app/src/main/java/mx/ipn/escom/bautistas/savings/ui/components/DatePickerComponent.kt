package mx.ipn.escom.bautistas.savings.ui.components

import android.app.DatePickerDialog
import android.content.Context
import android.widget.DatePicker
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.text.SimpleDateFormat
import java.util.*


@Composable
fun DatePickerComponent(
    context: Context,
    date: Date,
    setDate: (Date) -> Unit
) {
    val currentDate = Calendar.getInstance()
    currentDate.time = date

    val mDay = currentDate.get(Calendar.DAY_OF_MONTH)
    val mMonth = currentDate.get(Calendar.MONTH)
    val mYear = currentDate.get(Calendar.YEAR)


    val mDatePickerDialog =
        DatePickerDialog(context, fun(_: DatePicker, sYear: Int, sMonth: Int, sDayOfMonth: Int) {
            val selectedDate = Calendar.getInstance()
            selectedDate.set(sYear, sMonth, sDayOfMonth)
            setDate(selectedDate.time)
        }, mYear, mMonth, mDay)

    Button(
        onClick = {
            mDatePickerDialog.show()
        },
        modifier = Modifier
            .size(361.dp, 49.dp)
            .clip(CircleShape),
    ) {
        val formatter = SimpleDateFormat("dd/MM/yy(EEE) hh:mm a", Locale.getDefault()).format(date)

        Text(formatter, fontSize = 20.sp)
    }
}


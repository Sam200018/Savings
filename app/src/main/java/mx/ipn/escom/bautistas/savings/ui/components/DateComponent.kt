package mx.ipn.escom.bautistas.savings.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun DateInfoComponent(
    modifier: Modifier = Modifier,
    date: LocalDate = LocalDate.MIN,
) {
    Row {
        Box(modifier.padding(2.dp)) {
            Text(text = date.format(
                DateTimeFormatter.ofPattern(
                    "dd"
                )
            ), style = TextStyle(fontSize = 30.sp))
        }

        Column(modifier.padding(2.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = date.format(
                DateTimeFormatter.ofPattern(
                    "MM-YYYY"
                )
            ))
            Text(
                text = date.format(
                    DateTimeFormatter.ofPattern(
                        "EEE"
                    )
                ),
                modifier.background(color = Color.Gray),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DatePrev() {
    DateInfoComponent()
}
package mx.ipn.escom.bautistas.savings.ui.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun TabsComponent(
    modifier: Modifier = Modifier,
    filterSelected: Int,
    onSelected: (Int) -> Unit,
) {
    val tabs = listOf("Dia", "Semana", "Mes", "Total")
    TabRow(
        selectedTabIndex = filterSelected,
        modifier.background(color = MaterialTheme.colorScheme.background)
    ) {
        tabs.forEachIndexed { index, s ->
            Tab(selected = filterSelected == index, onClick = {
                if (index != filterSelected)
                    Log.i("Filter",index.toString())
                    onSelected(index)
            }) {
                Text(text = s)
            }
        }

    }

}

@Preview(showBackground = true)
@Composable
fun TabsPrev() {
    TabsComponent(filterSelected = 0) {}
}
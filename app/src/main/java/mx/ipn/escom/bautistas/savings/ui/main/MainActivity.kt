package mx.ipn.escom.bautistas.savings.ui.main

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import mx.ipn.escom.bautistas.savings.ui.main.viewmodels.OperationViewModel
import mx.ipn.escom.bautistas.savings.ui.main.viewmodels.OperationsViewModel
import mx.ipn.escom.bautistas.savings.ui.main.views.AddOperation
import mx.ipn.escom.bautistas.savings.ui.main.views.HomeScreen
import mx.ipn.escom.bautistas.savings.ui.main.views.Routes
import mx.ipn.escom.bautistas.savings.ui.main.views.filterByOption
import mx.ipn.escom.bautistas.savings.ui.theme.SavingsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SavingsTheme {
                // A surface container using the 'background' color from the theme
                val navController = rememberNavController()

                val operationViewModel = OperationViewModel()
                val operationsViewModel = OperationsViewModel()

                NavHost(navController = navController, startDestination = Routes.HomeScreen.route) {
                    composable(Routes.HomeScreen.route) {
                        val filteredOperations = filterByOption(optionSelected = operationsViewModel.filterSelected, operations = operationsViewModel.operations)
                        Log.i("Filtered Op", filteredOperations.toString())
                        HomeScreen(
                            addOperation = {
                                navController.navigate(Routes.AddOperation.route)
                            },
                            operationsMap = filteredOperations.groupBy { it.date.toLocalDate() },
                            operations = operationsViewModel.operations,
                            operationsViewModel = operationsViewModel
                        )
                    }
                    composable(Routes.AddOperation.route) {
                        AddOperation(back = {
                            navController.popBackStack();
                        }, operationViewModel = operationViewModel) {
                            operationsViewModel.addOperation(it)
                        }
                    }
                }
            }
        }
    }
}

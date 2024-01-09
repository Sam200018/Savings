package mx.ipn.escom.bautistas.savings.ui.main.views

sealed class Routes (val route: String){
    data object HomeScreen: Routes(route = "home")
    data object AddOperation: Routes(route = "add_operation")
}
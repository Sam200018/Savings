package mx.ipn.escom.bautistas.savings.domain.model

import java.time.LocalDateTime

data class Operation(
    val id: Int = 0,
    val date: LocalDateTime = LocalDateTime.now(),
    val account: String = "",
    val category: String = "",
    val type: String = "",
    val note: String = "",
    val amount: Float = 0.0f,
)
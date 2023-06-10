package com.example.mytestapplication.presentation.components.bottom_sheet_component.components


sealed class TransactionType {
    object Cash : TransactionType()

    object Credit : TransactionType()
}

sealed class CashSale {
    data class  Amount (val id: String): CashSale()
    data class  Quantity (val id: String): CashSale()
    data class  ProductName (val id: String): CashSale()
    data class Description (val id: String): CashSale()

}
sealed class CreditSale {
    data class Amount (val id: String): CreditSale()
    data class Quantity (val id: String): CreditSale()
    data class ProductName (val id: String): CreditSale()
    data class Description (val id: String): CreditSale()
    data class DebtorName (val id: String): CreditSale()

}sealed class CashPurchase {
    data class Amount (val id: String): CashPurchase()
    data class Quantity (val id: String): CashPurchase()
    data class ProductName (val id: String): CashPurchase()
    data class Description (val id: String): CashPurchase()

}sealed class CreditPurchase {
    data class Amount (val id: String): CreditPurchase()
    data class Quantity (val id: String): CreditPurchase()
    data class ProductName (val id: String): CreditPurchase()
    data class Description (val id: String): CreditPurchase()
    data class LenderName (val id: String): CreditPurchase()


}








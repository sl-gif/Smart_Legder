package com.example.mytestapplication.presentation.components.bottom_sheet_component.components



sealed class BottomSheetContentType(val transactionType: TransactionType) {
    class Sales(transactionType: TransactionType) : BottomSheetContentType(transactionType) {
        override fun hashCode(): Int {
            var result = transactionType.hashCode()
            result *= 31
            return result
        }

        override fun equals(other: Any?): Boolean {
            return other is Sales && other.transactionType == transactionType
        }
    }


    class Purchases(transactionType: TransactionType) : BottomSheetContentType(transactionType) {
        override fun hashCode(): Int {
            var result = transactionType.hashCode()
            result *= 31
            return result
        }

        override fun equals(other: Any?): Boolean {
            return other is Purchases && other.transactionType == transactionType
        }
    }
}

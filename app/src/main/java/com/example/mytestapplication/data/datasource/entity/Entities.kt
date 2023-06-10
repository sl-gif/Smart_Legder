package com.example.mytestapplication.data.datasource.entity

import androidx.room.*
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import java.time.OffsetDateTime


@Entity(tableName = "account")
data class Account(
    val name: String,
    val dateOfItemRecentClick: OffsetDateTime? = null,
    val date: OffsetDateTime,
    @PrimaryKey(autoGenerate = true)
    val userId: Int = 0,
    val isActive: Boolean,
    ){
    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }

    override fun hashCode(): Int {
        return super.hashCode()
    }

    fun doesMatchQuery(text: String): Boolean{
        val matchingQuery = listOf(
            "$name"
       /*     "",
            ""*/
        )
      return matchingQuery.any{
          it.contains(text, ignoreCase = true)
      }

    }

}




@Entity(tableName = "transaction",
    foreignKeys = [ForeignKey(
    entity = Account::class,
    parentColumns = arrayOf("userId"),
    childColumns = arrayOf("accountOwnerId"),
    onDelete = CASCADE,
    )
        ],
    indices = [Index(value = ["accountOwnerId"], name ="index_foreign_key_column")]

)

/**
 * is it advisable to put all fields in one data class?.
 * like we have two different fields that can never be true at the same
 * time- it can never have values at the same instance.
 * example borrowerName and lenderName. it is either you are borrowing
 * which requires lender name or you are lending which requires borrower
 * name,
 *
 * is using nullable fields a good approach or might there result some unforeseen
 * bugs?
 * is using different data classes though stressful, most advised?
 */
data class Transaction(
    val type: String ="",
    val amount: String,
    val lenderName: String? = null,
    val borrowerName: String? = null,
    val time: Long,
    @PrimaryKey(autoGenerate = true)
    val transactionId: Int = 0,
    val accountOwnerId: Int,
    val quantity: String,
    val nameOfProduct: String
)

data class AccountWithTransaction(
    @Embedded val account: Account,
    @Relation(
        parentColumn = "userId",
        entityColumn = "accountOwnerId",
        entity = Transaction::class
    )
    val transaction: List<Transaction>
)


fun Account.toFinancialData(): FinancialData{
    return FinancialData(
         name = name,
     dateOfItemRecentClick = dateOfItemRecentClick,
     date = date,
     userId = userId,
     isActive = isActive,
    )
}

fun Transaction.toFinancialData(): FinancialData{
    return FinancialData(
         type = type,
    amount = amount,
     lenderName = lenderName,
     borrowerName = borrowerName,
     time = time,
     transactionId = transactionId,
     accountOwnerId = accountOwnerId,
     quantity = quantity,
     nameOfProduct = nameOfProduct
    )
}



data class FinancialData(
    val name: String? = null,
    val dateOfItemRecentClick: OffsetDateTime? = null,
    val date: OffsetDateTime? = null,
    val userId: Int? = null,
    val isActive: Boolean? = null,
    val type: String? = null,
    val amount: String? = null,
    val lenderName: String? = null,
    val borrowerName: String? = null,
    val time: Long? = null,
    val transactionId: Int? = null,
    val accountOwnerId: Int? = null,
    val quantity: String? = null,
    val nameOfProduct: String? = null

)

data class FinancialDataDemo(
    val name: String? = null,
    val dateOfItemRecentClick: OffsetDateTime? = null,
    val date: OffsetDateTime? = null,
    val userId: Int? = null,
    val isActive: Boolean? = null,
    val type: String? = null,
    val amount: String? = null,
    val lenderName: String? = null,
    val borrowerName: String? = null,
    val time: Long? = null,
    val transactionId: String? = null,
    val accountOwnerId: Int? = null,
    val quantity: String? = null,
    val nameOfProduct: String? = null

)

fun FinancialDataDemo.makeNull(
     name: Boolean = false,
     dateOfItemRecentClick: Boolean = false,
     date: Boolean = false,
     userId: Boolean = false,
     isActive: Boolean = false,
     type: Boolean = false,
     amount: Boolean = false,
     lenderName: Boolean = false,
     borrowerName: Boolean = false,
     time: Boolean = false,
     transactionId: Boolean = false,
     accountOwnerId: Boolean = false,
     quantity: Boolean = false,
     nameOfProduct: Boolean = false,
): FinancialDataDemo{
   // val c: String? =
    return this.copy(
         name = if(name) null  else this.name   ,
     dateOfItemRecentClick = if(dateOfItemRecentClick) null else this.dateOfItemRecentClick ,
     date = if(date)  null  else this.date  ,
     userId = if(userId)   null else this.userId ,
     isActive = if(isActive)  null else this.isActive ,
     type = if(type)  null else this.type ,
     amount = if(amount) null else this.amount ,
        time = if(time) null else this.time ,
     lenderName = if(lenderName) null else this.lenderName ,
     borrowerName = if(borrowerName) null else this.borrowerName ,
     transactionId= if(transactionId) null else this.transactionId ,
     accountOwnerId= if(accountOwnerId) null else this.accountOwnerId ,
        quantity= if(quantity) null else this.quantity ,
     nameOfProduct = if(nameOfProduct) null else this.nameOfProduct ,
    )

}

fun FinancialData.toAccount(): Account{
    return Account(
         name= name!!,
     dateOfItemRecentClick = dateOfItemRecentClick,
     date = date!!,
     userId = userId!!,
     isActive= isActive!!,
    )
}
fun FinancialData.toTransaction(): Transaction{
    return Transaction(
         type = type!!,
     amount=amount!!,
     lenderName = lenderName,
     borrowerName = borrowerName,
     time = time!!,
     transactionId = transactionId!!,
     accountOwnerId = accountOwnerId!!,
     quantity= quantity!!,
     nameOfProduct= nameOfProduct!!
    )
}







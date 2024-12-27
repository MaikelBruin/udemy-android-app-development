package com.example.bankaccountprogram

fun main() {
    val bankAccount = BankAccount("MB", 1000.0)
    println(bankAccount.displayBalance())
    println(bankAccount.displayTransactionHistory())

    bankAccount.deposit(111.0)
    println(bankAccount.displayBalance())
    println(bankAccount.displayTransactionHistory())

    bankAccount.withdraw(111.0)
    println(bankAccount.displayBalance())
    println(bankAccount.displayTransactionHistory())
    bankAccount.withdraw(2000.0)
    println(bankAccount.displayBalance())
    println(bankAccount.displayTransactionHistory())

}
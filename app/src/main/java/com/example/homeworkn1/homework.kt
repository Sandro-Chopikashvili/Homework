package com.example.a1

// 1 ნაწილი:

open class Account(val accountNumber: String, val ownerName: String) {
    private var balance: Double = 0.0
    fun getBalance(): Double {
        return balance
    }
    fun deposit(amount: Double) {
        if (amount > 0) {
            balance += amount
            println("Successfully deposited $amount. New balance: $balance")
        }
        else {
            println(":'''(((( ERROR!!!")
        }
    }

    open fun withdraw(amount: Double) {
        if (amount > 0 && balance >= amount) {
            balance -= amount
        }
        else {
            println(":'''((( mshieri rchebi dges.")
        }
    }
    fun printInfo() {
        println("acc number: $accountNumber ; owner name: $ownerName, current balance: $balance")
    }
}

// 2 ნაწილი:

class SavingsAccount(accountNumber: String, ownerName: String) : Account(accountNumber, ownerName) {
    override fun withdraw(amount: Double) {
        if (amount > 500) {
            println("Withdrawals are only allowed if the amount is not greater than 500 per transaction.")
        }
        else {
            super.withdraw(amount)
        }
    }
}

class VIPAccount(accountNumber: String, ownerName: String, val transactionFee: Double = 2.0):Account(accountNumber, ownerName) {
    override fun withdraw(amount: Double) {
        val totalAmount = amount + transactionFee
        if (super.getBalance() >= totalAmount) {
            super.withdraw(totalAmount)
        }
        else {
            println("operation failed..")
        }
    }
}

// 3 ნაწილი

fun main() {
    val savings = SavingsAccount("S101", "George G.")
    val vip = VIPAccount("V202", "Mariam A.")

    savings.deposit(1000.0)
    vip.deposit(1000.0)

    savings.withdraw(600.0)
    savings.withdraw(400.0)

    vip.withdraw(200.0)

    savings.printInfo()
    vip.printInfo()
}
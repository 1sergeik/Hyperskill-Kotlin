package cinema

var rows = 0
var seats =0
var price = 0
val frontTicket = 10
val backTicket = 8
var saleTicket = 0
var income = 0
var totalIncome = 0


var a: Array<CharArray> = emptyArray()
fun cinemaCreation(){
    println("Enter the number of rows:")
    rows = readln().toInt()
    println("Enter the number of seats in each row:")
    seats = readln().toInt()

    a = Array((rows +1)) { CharArray((seats +1) * 2) }

    for (i in 0..(rows)){
        if (i == 0){

            for (o in 0..seats){
                if(o == 0) {
                    a[i][o] = ' '
                    a[i][o+1] = ' '
                }
                else {
                    a[i][o*2] = o.digitToChar()
                    a[i][o*2+1] = ' '
                }
            }

        } else {
            a[i][0] = i.digitToChar()
            a[i][1] = ' '
            for (o in 1..seats){
                a[i][o*2]= 'S'
                a[i][o*2 + 1] = ' '
            }

        }

    }
    if (rows * seats <= 60){
        totalIncome = rows * seats * 10
    } else {
        totalIncome = seats * (rows / 2) * 10 + seats * (rows - rows / 2) * 8

    }
}
fun printCinema() {
    println("Cinema:")
    for (i in 0..rows) {
        for (o in 0..(seats * 2 + 1)) {
            print(a[i][o])

        }
        println()
    }
}
fun buyTicket() {
    while (true) {
        println("Enter a row number:")
        val row = readln().toInt()
        println("Enter a seat number in that row:")
        val seat = readln().toInt()
        if (row > rows || seat > seats){
            println("Wrong input!")

        } else if (a[row][seat * 2] == 'B') {
            println("That ticket has already been purchased!")
            println()
        }else {
            a[row][seat * 2] = 'B'
            if (rows * seats <= 60) {
                price = frontTicket
            } else {
                if (row <= rows / 2) {
                    price = frontTicket
                } else price = backTicket
            }
            println("Ticket price: $$price")
            income += price
            saleTicket += 1
            break
        }

    }
}
fun statistics(){
    println("Number of purchased tickets: $saleTicket")

    println("Percentage: ${"%.2f".format(saleTicket *10000.0/(rows * seats)/100)}%")
    println("Current income: $$income")
    println("Total income: $$totalIncome")
}

fun main() {
    cinemaCreation()
    while (true) {
        println(
            """
1. Show the seats
2. Buy a ticket
3. Statistics
0. Exit
"""
        )
        when (readln()) {
            "1" -> printCinema()
            "2" -> buyTicket()
            "3" -> statistics()
            "0" -> break
        }
    }
}

package com.example.quiz

object constants {
    fun getQuestions():ArrayList<Questions>{
        val questionlist = ArrayList<Questions>()
        val que1 = Questions(1,
            "How many terms are there in 3,9,27,81........531441?",
            "25",
            "12",
            "13",
            "15",
            2
        )
        questionlist.add(que1)
        val que2 = Questions(2,
            "If the average of four consecutive odd numbers is 16, find the smallest of these numbers?",
            "5",
            "7",
            "13",
            "11",
            3
        )
        questionlist.add(que2)
        val que3 = Questions(3,
            "If the sum of two numbers is 13 and the sum of their square is 85. Find the numbers?",
            "6 & 7",
            "5 & 8",
            "4 & 9",
            "3 & 10",
            1
        )
        questionlist.add(que3)
        val que4 = Questions(4,
            "The difference between a two-digit number and the number obtained by interchanging the positions of its digits is 36. What is the difference between the two digits of that number?",
            "5",
            "7",
            "4",
            "6",
            3
        )
        questionlist.add(que4)
        val que5 = Questions(5,
            "A two-digit number is such that the product of the digits is 12. When 9 is subtracted from the number, the digits are reversed. The number is:",
            "34",
            "62",
            "43",
            "26",
            3
        )
        questionlist.add(que5)
        return questionlist
    }
}
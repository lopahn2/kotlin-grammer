package com.example.kotlin_usage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.util.Arrays

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // logcat
        Log.v("Tag-Name", "Output verbose data") //  V  Output verbose data
        Log.d("Tag-Name", "Output logs for debug") // D  Output logs for debug
        Log.i("Tag-Name", "Output logs for info") // I  Output logs for info
        Log.w("Tag-Name", "Output logs for warning") //  W  Output logs for warning
        Log.e("Tag-Name", "Output logs for error") //  E  Output logs for error

        // String Template
        val i = 10
        Log.d("String-Template", "i = $i") // i = 10

        val s = "abc"
        Log.d("String-Template", "$s.length is ${s.length}") // abc.length is 3

        // Var vs Val
        var x = 5
        x += 1

        Log.d("Var-vs-Val", "x = $x") // x = 6

        var y: Int
        y = 30

        Log.d("Var-vs-Val", "y = $y") // y = 30

        val a: Int = 1
        val b = 2
        val c: Int
        c = 3
//        c= 5 val is constant.
        Log.d("Var-vs-Val", "a, b, c =  $a, $b, $c") // a, b, c =  1, 2, 3

        // If Statement
        var aa = 20
        var bb = 30

        val max = if (aa > bb) {
            Log.d("If-Statement", "Choose aa")
            aa // allocate to max
        } else {
            Log.d("If-Statement", "Choose bb")
            bb // allocate to max
        }
        // Choose bb


        Log.d("If-Statement", "higher value was $max") // higher value was 30
        if (max > 20) Log.d("If-Statement", "Hmm~ Smells good")
        // Hmm~ Smells good

        // When Statement
        val grade = "F"
        when(grade) {
            "A+", "A", "B+" -> Log.d("When-Statement", "OH...Great!!")
            "B", "C+", "D" -> Log.d("When-Statement", "Oppps")
            else -> Log.d("When-Statement","oh my god")
        }
        // oh my god

        // .. arrange
        val score = 89
        when(score) {
            in 90..100 -> Log.d("When-Statement", "A+")
            else -> Log.d("When-Statement", "Fail")
        }
        // Fail

        val score2 = 49
        when {
            score2 > 90 -> Log.d("When-Statement", "A+")
            score2 in 50..89 -> Log.d("When-Statement", "A0")
            else -> Log.d("When-Statement", "FAIL")
        }
        // FAIL

        // type matcher
        val xx:Any = 21
        when(xx) {
            is Int -> Log.d("When-Statement", "is Int")
            is String -> Log.d("When-Statement", "is String")
            else -> Log.d("When-Statement", "is Nothing")
        }
        // is Int

        val myScore = 90
        var myGrade = when(myScore) {
            in 90..100 -> "A+"
            else -> "F"
        }
        Log.d("When-Statement", "my score is $myScore , So my Grade is $myGrade")
        // my score is 90 , So my Grade is A+

        // Array Statement
        val xIntArray: IntArray = intArrayOf(1,2,3)
        val yArray = arrayOf("One", "Two", "Three")

        val arr = IntArray(5)
        val arr2 = IntArray(5) { 42 }
        val arr3 = IntArray(5) { it + 1}
        val arr4 = Array(5) {i -> i*i}

        Log.d("Array-Statement", "xIntArray.size = ${xIntArray.size}") // xIntArray.size = 3
        Log.d("Array-Statement", "yArray.size = ${yArray.size}") // yArray.size = 3

        Log.d("Array-Statement", Arrays.toString(xIntArray)) // [1, 2, 3]
        Log.d("Array-Statement", Arrays.toString(yArray)) // [One, Two, Three]
        Log.d("Array-Statement", Arrays.toString(arr)) // [0, 0, 0, 0, 0]
        Log.d("Array-Statement", Arrays.toString(arr2)) // [42, 42, 42, 42, 42]
        Log.d("Array-Statement", Arrays.toString(arr3)) // [1, 2, 3, 4, 5]
        Log.d("Array-Statement", Arrays.toString(arr4)) // [0, 1, 4, 9, 16]


        val arr11: IntArray = IntArray(10){it+1}
        val first = arr11[0]
        val first2 = arr11.first()
        val first3 = arr11.get(0)
        val last = arr11.last()
        Log.d("Array-Statement","${Arrays.toString(arr11)}") // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
        Log.d("Array-Statement","first: $first $first2 $first3 last: $last") //  first: 1 1 1 last: 10
        arr11[0] = 100
        arr11.set(1,200)
        Log.d("Array-Statement","${Arrays.toString(arr11)}") // [100, 200, 3, 4, 5, 6, 7, 8, 9, 10]
        arr11.sort() // in-place sorting
        val arr22 = arr11.sortedArrayDescending() // return a new sorted array (desc.)
        Log.d("Array-Statement","${Arrays.toString(arr11)}") // [3, 4, 5, 6, 7, 8, 9, 10, 100, 200]
        Log.d("Array-Statement","${Arrays.toString(arr22)}") // [200, 100, 10, 9, 8, 7, 6, 5, 4, 3]

        // Iterate Statement
        for (i in 1..3) { Log.d("Iterate-Statement","$i") // 1 2 3
        }
        for (i in 6 downTo 0) { Log.d("Iterate-Statement","$i") // 6 5 4 3 2 1 0
        }
        for (i in 1..11 step 3) { Log.d("Iterate-Statement","$i") // 1 4 7 10
        }
        for (i in 6 downTo 0 step 2) { Log.d("Iterate-Statement","$i") // 6 4 2 0
        }
        for (i in 1 until 11 step 2){ Log.d("Iterate-Statement","$i") // 1 3 5 7 9
        }

        val arrInt = IntArray(5){it+1}
        for (i in arrInt) { Log.d("Iterate-Statement","$i") // 1 2 3 4 5
        }

        for ((index, i) in arrInt.withIndex()) { Log.d("Iterate-Statement","$index's value= $i") // 0's value= 1 ...
        }


        arrInt.forEach { Log.d("Iterate-Statement","$it") } // 1 2 3 4 5

        for (i in 1..10) { Log.d("Iterate-Statement", "$i") // 1 2 3 4 5 6 7 8 9 10
        }
        var num =1
        while (num <= 10) {
            Log.d("Iterate-Statement", "$num") // 1 2 3 4 5 6 7 8 9 10
            num++
        }

        var num2 =1
        do{
            Log.d("Iterate-Statement", "$num2") // 1 2 3 4 5 6 7 8 9 10
            num2++
        } while(num2<=10)

        // Escape label
        outer@ for (i in 1..3) {
            for (j in 1..5) {
                if (j % 2 == 0) continue@outer
                Log.d("Escape-label", "$i, $j") }
            // 1, 1
            // 2, 1
            // 3, 1
        }

        // Data structure list
        val numbers = listOf("one", "two", "three", "four")
        Log.d("Data-structure-list", "Number of elements: ${numbers.size}") // Number of elements: 4
        Log.d("Data-structure-list", "Third element: ${numbers.get(2)}") // Third element: three
        Log.d("Data-structure-list", "Fourth element: ${numbers[3]}") // Fourth element: four
        Log.d("Data-structure-list", "Index of element \"two\" ${numbers.indexOf("two")}") // Index of element "two" 1

        val numbers2 = mutableListOf(1, 2, 3, 4)
        numbers2.add(5)
        numbers2.removeAt(1)
        Log.d("Data-structure-list", "${numbers2}") // [1, 3, 4, 5]
        numbers2[0] = 0
        numbers2.shuffle()
        Log.d("Data-structure-list", "${numbers2}") // [0, 3, 5, 4]

        // Data structure set
        val numbers3 = setOf(1, 2, 3, 4)
        Log.d("Data-structure-set","Number of elements: ${numbers3.size}") // Number of elements: 4
        if (numbers3.contains(1)) Log.d("Data-structure-set","1 is in the set") // 1 is in the set
        val numbersBackwards = setOf(4, 3, 2, 1)
        Log.d("Data-structure-set","The sets are equal: ${numbers3 == numbersBackwards}") // The sets are equal: true

        val depts = mutableSetOf("ITM")
        Log.d("Data-structure-set","Number of elements: ${depts.size}") // Number of elements: 1
        Log.d("Data-structure-set","${depts}") // [ITM]
        depts.add("IISE")
        depts.add("AIX")
        depts.add("Computer")
        Log.d("Data-structure-set","${depts}") // [ITM, IISE, AIX, Computer]
        depts.remove("Data science")
        depts.remove("IISE")
        Log.d("Data-structure-set","${depts}") // [ITM, AIX, Computer]

        // Data structure map
        val studentGrade = mutableMapOf<String, Int>()
        studentGrade.put("Jeong",100)
        studentGrade.put("Kim",90)
        studentGrade.put("Hong",80)
        studentGrade.put("Park",70)
        Log.d("Data-structure-map","${studentGrade}") // {Jeong=100, Kim=90, Hong=80, Park=70}
        Log.d("Data-structure-map","${studentGrade.get("Jeong")}") // 100
        Log.d("Data-structure-map","${studentGrade.get("Wow")}") //  null
        studentGrade.put("Jeong",0)
        Log.d("Data-structure-map","${studentGrade}") // {Jeong=0, Kim=90, Hong=80, Park=70}

        val numbers4 = setOf(1,2,3,4,5)
        val numbers5 = numbers4.map {it * 2}
        Log.d("Data-structure-map","${numbers4}") // [1, 2, 3, 4, 5]
        Log.d("Data-structure-map","${numbers5}") // [2, 4, 6, 8, 10]
        val studentGrade1 = mutableMapOf<String, Int>()
        studentGrade1.put("Jinwoo",100)
        studentGrade1.put("Kim",90)
        studentGrade1.put("Hong",80)
        studentGrade1.put("Park",70)
        val grade2 = studentGrade1.mapValues { it.value / 10 }
        Log.d("Data-structure-map","${grade2}") // {Jinwoo=10, Kim=9, Hong=8, Park=7}

        // Collections
        val colors = listOf("red", "brown", "grey")
        val animals = listOf("fox", "bear", "wolf")
        Log.d("Collections","${colors zip animals}") // [(red, fox), (brown, bear), (grey, wolf)]
        val twoAnimals = listOf("fox", "bear")
        Log.d("Collections","${colors.zip(twoAnimals)}") // [(red, fox), (brown, bear)]
        Log.d("Collections", "${colors.zip(animals) { color, animal -> "The ${color.replaceFirstChar { it.uppercase() }} is $animal"}}")
        // [The Red is fox, The Brown is bear, The Grey is wolf]

        val numbers6 = listOf("one", "two", "three", "four")
        val longerThan3 = numbers6.filter { it.length > 3 }
        Log.d("Collections","$longerThan3") // [three, four]
        val numbersMap = mapOf("key1" to 1, "key2" to 2, "key3" to 3, "key11" to 11)
        val filteredMap = numbersMap.filter { (key, value) -> key.endsWith("1") && value > 10}
        Log.d("Collections","$filteredMap") // {key11=11}

        val numbers111 = listOf("one", "two", "three", "four", "five", "six")
        Log.d("Collections", numbers111.first { it.length > 3 }) // three
        Log.d("Collections", numbers111.last { it.startsWith("f") }) // five
        val numbers222 = listOf(1, 2, 3, 4)
        Log.d("Collections","${(numbers222.find { it % 2 == 0 })}") // 2
        Log.d("Collections","${numbers222.findLast { it % 2 == 0 }}") // 4

        val numbers22 = listOf(6, 42, 10, 4)
        Log.d("Collections","Count: ${numbers22.count()}") // Count: 4
        Log.d("Collections","Max: ${numbers22.maxOrNull()}") // Max: 42
        Log.d("Collections","Min: ${numbers22.minOrNull()}") // Min: 4
        Log.d("Collections","Average: ${numbers22.average()}") // Average: 15.5
        Log.d("Collections","Sum: ${numbers22.sum()}") // Sum: 62

        val numbers33 = listOf("one", "two", "three", "four")
        val numbersIterator = numbers33.iterator()
        while (numbersIterator.hasNext()) {
            Log.d("Collections",numbersIterator.next()) } // one two three four

        // Function
        fun fun_name(parameter: Int): Int {
            return 2 * parameter
        }
        val result = fun_name(2)

        val sumLambda: (Int, Int) -> Int = {x: Int, y: Int -> x+y}
        val sumLambda2 = {x: Int, y: Int -> x+y}
//        val product = items.fold(1) { acc, e -> acc * e}
//        is equal to items.fold(1,{ acc, e -> acc * e})

        // Lambda Usage
        val number = listOf(1, 2, 3, 4)
        Log.d("Lambda-Usage", "1: ${number.find({num: Int -> num % 2 == 0})}") // 1: 2
        Log.d("Lambda-Usage", "2: ${number.find(){num: Int -> num % 2 == 0}}") // 2: 2
        Log.d("Lambda-Usage", "1: ${number.find{num: Int -> num % 2 == 0}}") // 1: 2
        Log.d("Lambda-Usage", "1: ${number.find{num -> num % 2 == 0}}") // 1: 2
        Log.d("Lambda-Usage", "1: ${number.find{it % 2 == 0}}") // 1: 2

        // Class
        class InitOrderDemo(name: String) {
            val firstProperty = "First Property $name"

            init {
                Log.d("Class", "First Init Block Print $name")
            }

            val secondaryProperty = "Secondary property: ${name.length}"

            constructor(age: Int) : this("hey") {
                Log.d("Class", "Secondary Init Block Print $age")
            }
        }

        class InitOrderDemo2 {

            init {
                Log.d("Class", "Init Body")
            }

            constructor(age: Int) {
                Log.d("Class", "Secondary Init Block Print $age")
            }
        }

        val instance = InitOrderDemo(20)
        // First Init Block Print hey
        // Secondary Init Block Print 20

        val instance2 = InitOrderDemo2(20)
        // Init Body
        // Secondary Init Block Print 20

        // Class Property
        class Address {
            var name: String = "default"
                get() = field
                set(value) {field = "$value, Korea"}
            val street: String = "Baker"
            val state: String? = null
        }

        val addressInstance = Address()
        addressInstance.name = "hwany"
        Log.d("Class-Property", "get state: ${addressInstance.name}") // get state: hwany, Korea

        // Class Static
        Log.d("Class-Static", "${IE.numStudents}") // static // 30
        //Log.d("Class-Static", "${IE.graduate}") -> non-static

        // Data Class
        data class User(val name: String, val age: Int)

        val uData = User("hwany", 25)
        Log.d("Data-Class", uData.toString()) // User(name=hwany, age=25)
        val uData2 = uData.copy(age = 21)
        Log.d("Data-Class", uData2.toString()) // User(name=hwany, age=21)

        // Inheritance
        open class Shape { // open으로 상속이 가능한 클래스로 변경. 기본은 상속불가한 final
            open fun draw() {

            }
            fun fill() {

            }
            open val count = 2
        }

        class Circle : Shape() {
            override val count = 0
            override fun draw() {}
            //override fun fill() can not override.
        }

        // Inheritance Order
        open class Base(val name: String){
            init {
                Log.d("Inheritance-Order","Init Base Class")
                // Init Base Class
            }

            open val size: Int = name.length.also { Log.d("Inheritance-Order","Init Size in the base class: $it") } // Init Size in the base class: 5
        }

        class Derived(name: String, val lastName: String) : Base(name.replaceFirstChar { it.uppercase() }.also { Log.d("Inheritance-Order","Argument for the base class: $it") }) {
                                                                                                                // Argument for the base class: Hwany
            init {
                Log.d("Inheritance-Order","Init Derived Class") // Init Derived Class
            }

            override val size: Int =
                (super.size + lastName.length).also { Log.d("Inheritance-Order","Initializing size in the derived class: $it") } // Initializing size in the derived class: 9
        }

        Derived("Hwany", "Pahn")

        // Null Safety
        var aString: String = "abc"
        //aString = null -> compile error
        var aStringNull: String? = null
        //val l = aStringNull.length nullable value can not access directly

        val explicitCheck = if (aStringNull != null) aStringNull.length else -1
        Log.d("Null-Safety", "Safe call ${aStringNull?.length}") // Safe call null

        val unElvisOperator: Int = if (aStringNull != null) aStringNull.length else -1
        val elivisOperator = aStringNull?.length ?: -1

        // Scope Function-let
        val numberLet = mutableListOf("one", "two", "three", "four", "five")
        val resultList = numberLet.map {it.length}.filter { it > 3 }
        Log.d("Scope-Function-let", "normal $resultList") // normal [5, 4, 4]

        // same as
        numberLet.map { it.length }.filter { it > 3 }
            .let {
                Log.d("Scope-Function-let", "let scope function: $resultList") // let scope function: [5, 4, 4]
            }

        // Scope Function-with
        val numberWith = mutableListOf("one", "two", "three", "four", "five")
        with(numberWith) {
            Log.d("Scope-Function-with", "with scope function: $this") //with scope function: [one, two, three, four, five]
            Log.d("Scope-Function-with", "It Contains $size element") // It Contains 5 element
            Log.d("Scope-Function-with", "It Contains ${this.size} element")// It Contains [one, two, three, four, five].size element
        }

        // Scope Function-run
        class RunClass {
            val name: String = "hwany"
            val age: Int = 25
        }

        val runClass = RunClass()
        val resultRun = runClass.run {
            runClass.name
        }
        Log.d("Scope-Function-run", "extension result: $resultRun") // extension result: hwany

        val hexNumberRegex = run {
            val digits = "0-9"
            val hexDigits = "A-Fa-f"
            val sign = "+-"

            Regex("[$sign]?[$digits$hexDigits]+")
        }

        for (match in hexNumberRegex.findAll("+1234 -FFFF not-a-number")) {
            Log.d("Scope-Function-run", "non extension result: ${match.value}")
        }
        // non extension result: +1234
        // non extension result: -FFFF
        // non extension result: -a
        // non extension result: be

        // Scope Function-apply/also
        data class Person(var name: String, var age: Int = 25)

        val hwany = Person("hwany")
            .also {
                Log.d("Scope-Function-apply/also", "apply age to hwany 32") // apply age to hwany 32
            }
            .apply {
                age = 32
            }
        Log.d("Scope-Function-apply/also", hwany.toString()) // Person(name=hwany, age=32)





    }
    // Class Static
    class IE {
        // static과 동일한 기능 - companion numStudent와 print()를 static하게 접근 가능
        companion object {
            val numStudents = 30
            fun print() {
                Log.d("Class-Static", "Hello world")
            }
        }

        fun graudate() {
            Log.d("Class-Static", "Hello world graduate!")
        }
    }
}
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
        Log.v("Tag-Name", "Output verbose data")
        Log.d("Tag-Name", "Output logs for debug")
        Log.i("Tag-Name", "Output logs for info")
        Log.w("Tag-Name", "Output logs for warning")
        Log.e("Tag-Name", "Output logs for error")

        // String Template
        val i = 10
        Log.d("String-Template", "i = $i")

        val s = "abc"
        Log.d("String-Template", "$s.length is ${s.length}")

        // Var vs Val
        var x = 5
        x += 1

        Log.d("Var-vs-Val", "x = $x")

        var y: Int
        y = 30

        Log.d("Var-vs-Val", "y = $y")

        val a: Int = 1
        val b = 2
        val c: Int
        c = 3
//        c= 5 val is constant.
        Log.d("Var-vs-Val", "a, b, c =  $a, $b, $c")

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

        Log.d("If-Statement", "higher value was $max")
        if (max > 20) Log.d("If-Statement", "Hmm~ Smells good")

        // When Statement
        val grade = "F"
        when(grade) {
            "A+", "A", "B+" -> Log.d("When-Statement", "OH...Great!!")
            "B", "C+", "D" -> Log.d("When-Statement", "Oppps")
            else -> Log.d("When-Statement","oh my god")
        }

        // .. arrange
        val score = 89
        when(score) {
            in 90..100 -> Log.d("When-Statement", "A+")
            else -> Log.d("When-Statement", "Fail")
        }

        val score2 = 49
        when {
            score2 > 90 -> Log.d("When-Statement", "A+")
            score2 in 50..89 -> Log.d("When-Statement", "A0")
            else -> Log.d("When-Statement", "FAIL")
        }

        // type matcher
        val xx:Any = 21
        when(xx) {
            is Int -> Log.d("When-Statement", "is Int")
            is String -> Log.d("When-Statement", "is String")
            else -> Log.d("When-Statement", "is Nothing")
        }

        val myScore = 90
        var myGrade = when(myScore) {
            in 90..100 -> "A+"
            else -> "F"
        }
        Log.d("When-Statement", "my score is $myScore , So my Grade is $myGrade")

        // Array Statement
        val xIntArray: IntArray = intArrayOf(1,2,3)
        val yArray = arrayOf("One", "Two", "Three")

        val arr = IntArray(5)
        val arr2 = IntArray(5) { 42 }
        val arr3 = IntArray(5) { it + 1}
        val arr4 = Array(5) {i -> i*i}

        Log.d("Array-Statement", "xIntArray.size = ${xIntArray.size}")
        Log.d("Array-Statement", "yArray.size = ${yArray.size}")

        Log.d("Array-Statement", Arrays.toString(xIntArray))
        Log.d("Array-Statement", Arrays.toString(yArray))
        Log.d("Array-Statement", Arrays.toString(arr))
        Log.d("Array-Statement", Arrays.toString(arr2))
        Log.d("Array-Statement", Arrays.toString(arr3))
        Log.d("Array-Statement", Arrays.toString(arr4))


        val arr11: IntArray = IntArray(10){it+1}
        val first = arr11[0]
        val first2 = arr11.first()
        val first3 = arr11.get(0)
        val last = arr11.last()
        Log.d("Array-Statement","${Arrays.toString(arr11)}")
        Log.d("Array-Statement","first: $first $first2 $first3 last: $last")
        arr11[0] = 100
        arr11.set(1,200)
        Log.d("Array-Statement","${Arrays.toString(arr11)}")
        arr11.sort() // in-place sorting
        val arr22 = arr11.sortedArrayDescending() // return a new sorted array (desc.)
        Log.d("Array-Statement","${Arrays.toString(arr11)}")
        Log.d("Array-Statement","${Arrays.toString(arr22)}")

        // Iterate Statement
        for (i in 1..3) { Log.d("Iterate-Statement","$i")
        }
        for (i in 6 downTo 0) { Log.d("Iterate-Statement","$i")
        }
        for (i in 1..11 step 3) { Log.d("Iterate-Statement","$i")
        }
        for (i in 6 downTo 0 step 2) { Log.d("Iterate-Statement","$i")
        }
        for (i in 1 until 11 step 2){ Log.d("Iterate-Statement","$i")
        }

        val arrInt = IntArray(5){it+1}
        for (i in arrInt) { Log.d("Iterate-Statement","$i")
        }

        for ((index, i) in arrInt.withIndex()) { Log.d("Iterate-Statement","$index's value= $i")
        }


        arrInt.forEach { Log.d("Iterate-Statement","$it") }

        for (i in 1..10) { Log.d("Iterate-Statement", "$i")
        }
        var num =1
        while (num <= 10) {
            Log.d("Iterate-Statement", "$num")
            num++
        }

        var num2 =1
        do{
            Log.d("Iterate-Statement", "$num2")
            num2++
        } while(num2<=10)

        // Escape label
        outer@ for (i in 1..3) {
            for (j in 1..5) {
                if (j % 2 == 0) continue@outer
                Log.d("Escape-label", "$i, $j") }
        }

        // Data structure list
        val numbers = listOf("one", "two", "three", "four")
        Log.d("Data-structure-list", "Number of elements: ${numbers.size}")
        Log.d("Data-structure-list", "Third element: ${numbers.get(2)}")
        Log.d("Data-structure-list", "Fourth element: ${numbers[3]}")
        Log.d("Data-structure-list", "Index of element \"two\" ${numbers.indexOf("two")}")

        val numbers2 = mutableListOf(1, 2, 3, 4)
        numbers2.add(5)
        numbers2.removeAt(1)
        Log.d("Data-structure-list", "${numbers2}")
        numbers2[0] = 0
        numbers2.shuffle()
        Log.d("Data-structure-list", "${numbers2}")

        // Data structure set
        val numbers3 = setOf(1, 2, 3, 4)
        Log.d("Data-structure-set","Number of elements: ${numbers3.size}")
        if (numbers3.contains(1)) Log.d("Data-structure-set","1 is in the set")
        val numbersBackwards = setOf(4, 3, 2, 1)
        Log.d("Data-structure-set","The sets are equal: ${numbers3 == numbersBackwards}")

        val depts = mutableSetOf("ITM")
        Log.d("Data-structure-set","Number of elements: ${depts.size}")
        Log.d("Data-structure-set","${depts}")
        depts.add("IISE")
        depts.add("AIX")
        depts.add("Computer")
        Log.d("Data-structure-set","${depts}")
        depts.remove("Data science")
        depts.remove("IISE")
        Log.d("Data-structure-set","${depts}")

        // Data structure map
        val studentGrade = mutableMapOf<String, Int>()
        studentGrade.put("Jeong",100)
        studentGrade.put("Kim",90)
        studentGrade.put("Hong",80)
        studentGrade.put("Park",70)
        Log.d("Data-structure-map","${studentGrade}")
        Log.d("Data-structure-map","${studentGrade.get("Jeong")}")
        Log.d("Data-structure-map","${studentGrade.get("Wow")}")
        studentGrade.put("Jeong",0)
        Log.d("Data-structure-map","${studentGrade}")

        val numbers4 = setOf(1,2,3,4,5)
        val numbers5 = numbers4.map {it * 2}
        Log.d("Data-structure-map","${numbers4}")
        Log.d("Data-structure-map","${numbers5}")
        val studentGrade1 = mutableMapOf<String, Int>()
        studentGrade1.put("Jinwoo",100)
        studentGrade1.put("Kim",90)
        studentGrade1.put("Hong",80)
        studentGrade1.put("Park",70)
        val grade2 = studentGrade1.mapValues { it.value / 10 }
        Log.d("Data-structure-map","${grade2}")

        // Collections
        val colors = listOf("red", "brown", "grey")
        val animals = listOf("fox", "bear", "wolf")
        Log.d("Collections","${colors zip animals}")
        val twoAnimals = listOf("fox", "bear")
        Log.d("Collections","${colors.zip(twoAnimals)}")
        Log.d("Collections", "${colors.zip(animals) { color, animal -> "The ${color.replaceFirstChar { it.uppercase() }} is $animal"}}")

        val numbers6 = listOf("one", "two", "three", "four")
        val longerThan3 = numbers6.filter { it.length > 3 }
        Log.d("Collections","$longerThan3")
        val numbersMap = mapOf("key1" to 1, "key2" to 2, "key3" to 3, "key11" to 11)
        val filteredMap = numbersMap.filter { (key, value) -> key.endsWith("1") && value > 10}
        Log.d("Collections","$filteredMap")

        val numbers111 = listOf("one", "two", "three", "four", "five", "six")
        Log.d("Collections", numbers111.first { it.length > 3 })
        Log.d("Collections", numbers111.last { it.startsWith("f") })
        val numbers222 = listOf(1, 2, 3, 4)
        Log.d("Collections","${(numbers222.find { it % 2 == 0 })}")
        Log.d("Collections","${numbers222.findLast { it % 2 == 0 }}")

        val numbers22 = listOf(6, 42, 10, 4)
        Log.d("Collections","Count: ${numbers22.count()}")
        Log.d("Collections","Max: ${numbers22.maxOrNull()}")
        Log.d("Collections","Min: ${numbers22.minOrNull()}")
        Log.d("Collections","Average: ${numbers22.average()}")
        Log.d("Collections","Sum: ${numbers22.sum()}")

        val numbers33 = listOf("one", "two", "three", "four")
        val numbersIterator = numbers33.iterator()
        while (numbersIterator.hasNext()) {
            Log.d("Collections",numbersIterator.next()) }

        // Function
        fun fun_name(parameter: Int): Int {
            return 2 * parameter
        }
        val result = fun_name(2)

        val sumLambda: (Int, Int) -> Int = {x: Int, y: Int -> x+y}
        val sumLambda2 = {x: Int, y: Int -> x+y}

        // Lambda Usage
        val number = listOf(1, 2, 3, 4)
        Log.d("Lambda-Usage", "1: ${number.find({num: Int -> num % 2 == 0})}")
        Log.d("Lambda-Usage", "2: ${number.find(){num: Int -> num % 2 == 0}}")
        Log.d("Lambda-Usage", "1: ${number.find{num: Int -> num % 2 == 0}}")
        Log.d("Lambda-Usage", "1: ${number.find{num -> num % 2 == 0}}")
        Log.d("Lambda-Usage", "1: ${number.find{it % 2 == 0}}")

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
        val instance2 = InitOrderDemo2(20)

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
        Log.d("Class-Property", "get state: ${addressInstance.name}")

        // Class Static
        Log.d("Class-Static", "${IE.numStudents}") // static
        //Log.d("Class-Static", "${IE.graduate}") -> non-static

        // Data Class
        data class User(val name: String, val age: Int)

        val uData = User("hwany", 25)
        Log.d("Data-Class", uData.toString())
        val uData2 = uData.copy(age = 21)
        Log.d("Data-Class", uData2.toString())

        // Inheritance
        open class Shape {
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
            }

            open val size: Int = name.length.also { Log.d("Inheritance-Order","Init Size in the base class: $it") }
        }

        class Derived(name: String, val lastName: String) : Base(name.replaceFirstChar { it.uppercase() }.also { Log.d("Inheritance-Order","Argument for the base class: $it") }) {
            init {
                Log.d("Inheritance-Order","Init Derived Class")
            }

            override val size: Int =
                (super.size + lastName.length).also { Log.d("Inheritance-Order","Initializing size in the derived class: $it") }
        }

        Derived("Hwany", "Pahn")

        // Null Safety
        var aString: String = "abc"
        //aString = null -> compile error
        var aStringNull: String? = null
        //val l = aStringNull.length nullable value can not access directly

        val explicitCheck = if (aStringNull != null) aStringNull.length else -1
        Log.d("Null-Safety", "Safe call ${aStringNull?.length}")

        val unElvisOperator: Int = if (aStringNull != null) aStringNull.length else -1
        val elivisOperator = aStringNull?.length ?: -1

        // Scope Function-let
        val numberLet = mutableListOf("one", "two", "three", "four", "five")
        val resultList = numberLet.map {it.length}.filter { it > 3 }
        Log.d("Scope-Function-let", "normal $resultList")

        // same as
        numberLet.map { it.length }.filter { it > 3 }
            .let {
                Log.d("Scope-Function-let", "let scope function: $resultList")
            }

        // Scope Function-with
        val numberWith = mutableListOf("one", "two", "three", "four", "five")
        with(numberWith) {
            Log.d("Scope-Function-with", "with scope function: $this")
            Log.d("Scope-Function-with", "It Contains $size element")
            Log.d("Scope-Function-with", "It Contains $this.size element")
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
        Log.d("Scope-Function-run", "extension result: $resultRun")

        val hexNumberRegex = run {
            val digits = "0-9"
            val hexDigits = "A-Fa-f"
            val sign = "+-"

            Regex("[$sign]?[$digits$hexDigits]+")
        }

        for (match in hexNumberRegex.findAll("+1234 -FFFF not-a-number")) {
            Log.d("Scope-Function-run", "non extension result: ${match.value}")
        }
        // Scope Function-apply/also
        data class Person(var name: String, var age: Int = 25)

        val hwany = Person("hwany")
            .also {
                Log.d("Scope-Function-apply/also", "apply age to hwany 32")
            }
            .apply {
                age = 32
            }
        Log.d("Scope-Function-apply/also", hwany.toString())





    }
    // Class Static
    class IE {
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
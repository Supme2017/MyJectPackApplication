package com.jetpack.activity.bean

class User (first : String, last : String, name :String, age: Int) : Person(name, age){
    var first : String = "";
    var last : String = "";
    var char : CharSequence = "";


    val fullName : String
        get() {
            println(first + last);
            return "${first} . ${last}";
        }

    var converFullname :String
        get() = "${last} . ${first}";
        set(value) {
            var tokens = value.split(".");
            first = tokens[0];
            last = tokens[1];
        }

    var weith = 0.0
        set(value) {
            if (value >0.0) field = value;
        }
        get() {return field}

    init {
        this.first = first;
        this.last = last;
    }

    constructor(first: String, last: String, age : Int) : this(first, last, "", age) {

    }

}

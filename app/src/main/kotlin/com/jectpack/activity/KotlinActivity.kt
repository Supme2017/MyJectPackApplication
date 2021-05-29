package com.jectpack.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import com.jectpack.activity.bean.Person
import com.jectpack.activity.bean.PersonData
import com.jectpack.activity.bean.User
import com.robert.jectpack.R
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.HashMap

class KotlinActivity : AppCompatActivity() {
    var testChar : Char= 'a';
    var testString : String = "this is a test";
    var arrayInt = Array(5,  {it +1});

    var myMap : Map<Int, String> = mapOf(1 to "value1",  2 to "value2", 3 to "value3");
    var person : Person = Person("zhang", 19);
    var user : User = User("z", "x", 19);
    var mutableData:MutableLiveData<List<String>> = MutableLiveData();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)
        var fn : (Int) -> Int = {i -> i*i};

        person.age = 20;
        person.name = "ding";

        user.first = "w";
        user.last = "l";


        var items : MutableList<in Person> = mutableListOf<Person>();
        items.add(user)

        for (item in items){
            println("-------1--------1-----3------ $item");
        }

        runBlocking {
            launch {

            }
        }

    }


}
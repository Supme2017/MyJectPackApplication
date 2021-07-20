package com.jetpack.aidl.bean

import android.os.Parcel
import android.os.Parcelable

data class Book(val id: Int, val name: String?): Parcelable{


    constructor(parce: Parcel): this(
            parce.readInt(),
            parce.readString()
    ){}

    override fun describeContents(): Int {
        return 0;
    }

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeInt(id);
        dest?.writeString(name)
    }

    companion object CREATOR : Parcelable.Creator<Book> {
        override fun createFromParcel(parcel: Parcel): Book {
            return Book(parcel)
        }

        override fun newArray(size: Int): Array<Book?> {
            return arrayOfNulls(size)
        }
    }
}
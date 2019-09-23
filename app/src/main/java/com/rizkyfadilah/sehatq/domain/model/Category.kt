package com.rizkyfadilah.sehatq.domain.model

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * com.rizkyfadilah.sehatq.domain.model
 * Created by rizkyfadilah on 2019-07-31.
 */

@Entity
data class Category(
    @PrimaryKey(autoGenerate = true)
    @SerializedName("id") var id: Int,
    @SerializedName("imageUrl") var imageUrl: String,
    @SerializedName("name") var name: String
) : Parcelable {
    constructor(source: Parcel) : this(
        source.readInt(),
        source.readString().orEmpty(),
        source.readString().orEmpty()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeInt(id)
        writeString(imageUrl)
        writeString(name)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Category> = object : Parcelable.Creator<Category> {
            override fun createFromParcel(source: Parcel): Category = Category(source)
            override fun newArray(size: Int): Array<Category?> = arrayOfNulls(size)
        }
    }

}
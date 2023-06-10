package com.example.mytestapplication.domain.model

import android.net.Uri
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import androidx.navigation.NavType
import com.google.gson.Gson
import com.google.gson.JsonElement
import kotlinx.android.parcel.Parcelize
import org.json.JSONObject
import java.time.OffsetDateTime

@Parcelize
data class Post(
    val name: String ="",
    val timeOfRecentClick: OffsetDateTime? = null,
    val userId: Int,
    val isActive: Boolean,
    val date: OffsetDateTime? = null

) : Parcelable{
    override fun toString(): String {
        return Uri.encode(Gson().toJson(this))
    }

    override fun equals(other: Any?): Boolean {
        return other is Post && other.name == name && other.timeOfRecentClick == timeOfRecentClick
                && other.isActive == isActive && other.userId == userId && other.date == date

    }

    override fun hashCode(): Int {
         date.also { Log.d("hashcodeeee","${it == null}")  }
        var result = name.hashCode()
        result = result * 31 + userId.hashCode() + isActive.hashCode()
        return result
    }
}

class PostType : NavType<Post>(isNullableAllowed = true){
    override fun get(bundle: Bundle, key: String): Post? {
        return bundle.getParcelable(key)
    }

    override fun parseValue(value: String): Post {
            return Gson().fromJson(value,Post::class.java)
    }

    override fun put(bundle: Bundle, key: String, value: Post) {
        bundle.putParcelable(key, value)
    }



}

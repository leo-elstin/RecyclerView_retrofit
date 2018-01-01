package `in`.yapp.recyclerviewexample.models

import com.google.gson.annotations.SerializedName

/**
 * Created by elstin on 12/30/2017.
 */

data class User(
        @SerializedName("name") var name:String,
        @SerializedName("location") var location:String
)

data class UserList( val userList : List<User>)
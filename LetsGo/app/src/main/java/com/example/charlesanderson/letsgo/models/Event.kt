package com.example.charlesanderson.letsgo.models

import java.io.Serializable
import java.util.*

class Event(val title: String, val date: String, val host: User) : Serializable {
    lateinit var description: String
    lateinit var invitedList: List<User>
    lateinit var comments: List<Comment>
    // do i need this or should i just use epoch time
    lateinit var hour: String
    lateinit var minute: String

    var imageId = 0
}
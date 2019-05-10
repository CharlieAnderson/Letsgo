package com.example.charlesanderson.letsgo.models

import java.util.*

class Event(val title: String, val date: Date, val host: User) {
    lateinit var description: String
    lateinit var invitedList: List<User>
    lateinit var comments: List<Comment>
    var imageId = 0
}
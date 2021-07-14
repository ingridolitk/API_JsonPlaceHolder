package model

class Postagem {
    private lateinit var userId:String
    private lateinit var id:String
    private lateinit var title:String
    private lateinit var body:String

    fun albumId():String {
        return userId;
    }


    fun id():String {
        return id;
    }

    fun title():String {
        return title;
    }

    fun body():String {
        return body;
    }
}
package model

class Foto {
    private lateinit var albumId: String
    private lateinit var id: String
    private lateinit var title:String
    private lateinit var url:String
    private lateinit var thumbnailUrl: String

    fun albumId():String {
        return albumId;
    }


    fun id():String {
        return id;
    }

    fun title():String {
        return title;
    }

    fun url():String {
        return url;
    }


    fun thumbnailUrl():String {
        return thumbnailUrl;
    }
}
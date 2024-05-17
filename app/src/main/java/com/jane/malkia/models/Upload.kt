package com.jane.malkia.models
class Upload {
    var name:String=""
    var stream:String=""
    var booktitle:String=""
    var imageUrl:String=""
    var id:String=""

    constructor(name:String,stream:String,booktitle:String,imageUrl:String,id:String){

        this.name=name
        this.stream=stream
        this.booktitle=booktitle
        this.imageUrl=imageUrl
        this.id=id

    }
    constructor()
}


package com.sarah.testlessor.ui.scrips

data class Product(var name:String,var description:String,var price:Int) {


}


fun test():MutableList<Product>{
     var tempList= mutableListOf<Product>()
    for(i in 1..20){

        tempList.add(Product("","test",35))

    }
    return tempList
}
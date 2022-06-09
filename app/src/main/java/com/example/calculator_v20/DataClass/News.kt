package com.example.calculator_v20.DataClass

import com.example.calculator_v20.R

data class News(
    var Tittle:String = "Заголовок",
    var Description:String = "Описание",
    var Photo: Int = R.drawable.cat,
    var Source:String = "Источник",
    var Time:String = "Время публикации")
{

}

package com.example.calculator_v20.common.adapter

import android.provider.ContactsContract
import android.util.EventLogTags
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.calculator_v20.R
import com.example.calculator_v20.adapter.BaseViewHolder
import com.example.calculator_v20.databinding.ListItemBinding
import com.example.calculator_v20.extension.binding
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate

// это адаптер для наших итемов в листе
// в конструкторе можно заметить новую конструкцию getString:(Int) -> String
// это называется лямбда функции, они позволяют передать кусок кода как аргумент
// который мы можем в последствии вызвать, в listFragment видно какой именно код я передаю

class TextFieldDelegationAdapter(
    private val getString:(Int) -> String
): AdapterDelegate<
        MutableList<TextFieldModel>>() {

    //Функция позволяет определить этим ли адаптером нужно обработать текущий элемент из списка
    // так как у нас 1 тип элементов просто возвращаем true
    // далее когда типов будет несколько просто можем создать интерфейс, например RecyclerViewType
    // который будет реализовывать getItemViewType(): Int и возвращать например 0,1,2 и так далее
    override fun isForViewType(items: MutableList<TextFieldModel>, position: Int): Boolean = true

    //Эта функция просто создает наш холдер (или просто вью) в котором находятся наши данные
    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder =
        TextFieldHolder(parent)

    //тут в наш созданный холдер уже передаются данные, например для этого был создан метод
    //bind в который передается наша модель данных
    override fun onBindViewHolder(
        items: MutableList<TextFieldModel>,
        position: Int,
        holder: RecyclerView.ViewHolder,
        payloads: MutableList<Any>
    ) {
        holder as TextFieldHolder
        holder.bind(items[position])
    }

    //с холдером все немного сложнее, я сразу закинул класс который используется в нашем проекте
    //можешь посмотреть что он из себя представляет внутри, а так уже он наследуется от базового
    //RecyclerViewHolder, он просто упрощает работу по созданию вью из нашего binding для
    //itemList
    inner class TextFieldHolder(
        parent: ViewGroup
    ): BaseViewHolder<ListItemBinding>(
        parent.binding(ListItemBinding::inflate)
    ) {
        //В эту функцию мы передаем итем из листа, в котором хранятся данные и уже по старой схеме
        //просто присваиваем полям значения
        fun bind(item: TextFieldModel){
            binding.apply {
                tvDescription.text = item.position.toString()
                //Ниже виден пример вызова лямбда функции
                tvSource.text = getString.invoke(item.DescriptionId)
                tvPublishedAt.text = getString.invoke(item.TimeId)
                tvTitle.text = getString.invoke(item.TitleId)
                ivArticleImage.setImageResource(item.ImageId)
            }
        }
    }
}

//Это наша модель данных, так как она единственная для списка в строке 19 мы для всех адаптеров
//указываем что список будет MutableList<TextFieldModel>>
//модель хранит данные которые мы в нее положили и в последствии которые мы используем во вь
class TextFieldModel(
    val position:Int
){
    val TitleId: Int
    get() = when(position % 3){
        0 -> R.string.cat1
        1 -> R.string.cat2
        2 -> R.string.cat3
        else -> R.string.cat3
    }

    val TimeId: Int
        get() = when(position % 3){
            0 -> R.string.time1
            1 -> R.string.time2
            2 -> R.string.time3
            else -> R.string.time1
        }

    val DescriptionId: Int
        get() = when(position % 3){
            0 -> R.string.description1
            1 -> R.string.description2
            2 -> R.string.description3
            else -> R.string.description2
        }

    val ImageId: Int
        get() = when(position % 3){
            0 -> R.drawable.cat1
            1 -> R.drawable.cat
            2 -> R.drawable.cat2
            else -> R.drawable.cat2
        }
}
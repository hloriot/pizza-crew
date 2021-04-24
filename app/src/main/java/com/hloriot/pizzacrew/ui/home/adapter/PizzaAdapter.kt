package com.hloriot.pizzacrew.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hloriot.pizzacrew.R
import com.hloriot.pizzacrew.databinding.ItemPizzaBinding
import com.hloriot.pizzacrew.model.interfaces.IPizza
import java.util.Locale

class PizzaAdapter(initialList: List<IPizza> = emptyList()) :
    RecyclerView.Adapter<PizzaAdapter.PizzaViewHolder>() {

    private val pizzaList: MutableList<IPizza> = mutableListOf()

    init {
        pizzaList.addAll(initialList)
    }

    fun addPizza(pizza: IPizza) {
        pizzaList.add(pizza)
        notifyItemInserted(pizzaList.size)
    }

    fun removePizza(pizza: IPizza) {
        val index = pizzaList.indexOf(pizza)
        if (index != -1) {
            pizzaList.remove(pizza)
            notifyItemRemoved(index)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PizzaViewHolder {
        return PizzaViewHolder(
            ItemPizzaBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PizzaViewHolder, position: Int) {
        val pizza = pizzaList[position]
        holder.onBind(pizza)
    }

    override fun getItemCount(): Int {
        return pizzaList.size
    }

    class PizzaViewHolder(private val itemPizzaBinding: ItemPizzaBinding) :
        RecyclerView.ViewHolder(itemPizzaBinding.root) {

        fun onBind(pizza: IPizza) {
            val context = itemPizzaBinding.root.context
            itemPizzaBinding.apply {
                pizzaName.text = pizza.getName()
                pizzaIngredients.text = pizza.getIngredients().joinToString { it.getName() }
                pizzaPrice.text =
                    context.getString(R.string.pizza_price_value, pizza.getPriceInEuro())
                context.resources.getIdentifier(
                    pizza.getName().toLowerCase(Locale.ROOT).replace(" ", "_"),
                    "drawable", context.packageName
                ).let {
                    if (it != 0) {
                        pizzaPicture.setImageResource(it)
                    }
                }
            }
        }
    }
}
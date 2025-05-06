package scima.com.github.android_lista_compras.viewmodel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import com.google.android.ads.mediationtestsuite.viewmodels.ItemViewHolder
import scima.com.github.android_lista_compras.model.ItemModel
import androidx.recyclerview.widget.RecyclerView
import scima.com.github.android_lista_compras.R

class ItemsAdapter(private val onItemRemoved: (ItemModel) -> Unit) :
    RecyclerView.Adapter<ItemsAdapter.ItemViewHolder>() {

    private var items = listOf<ItemModel>()

    inner class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        // Referências para as views de cada item.
        val textView = view.findViewById<TextView>(R.id.textViewItem)
        val button = view.findViewById<ImageButton>(R.id.imageButton)

        /**
         * Método que preenche os dados nas views.
         * @param item O item que será exibido neste ViewHolder.
         */
        fun bind(item: ItemModel) {
            // Define o texto do TextView para o nome do item.
            textView.text = item.name
            // Define um listener para o botão, que chama o callback onItemRemoved quando clicado
            button.setOnClickListener {
                onItemRemoved(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // Infla o layout do item.
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout, parent, false)
        // Cria e retorna um novo ViewHolder.
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemsAdapter.ItemViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = items.size


}

package id.ac.polbeng.ardianto.kabupatenkotariauapp

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.ac.polbeng.ardianto.kabupatenkotariauapp.databinding.ItemCardKabkotaBinding

class CardKabKotaAdapter(private val listWisata: ArrayList<Wisata>) :
    RecyclerView.Adapter<CardKabKotaAdapter.CardViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    // Interface untuk menangani klik item
    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Wisata)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val binding = ItemCardKabkotaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val wisata = listWisata[position]

        Glide.with(holder.itemView.context)
            .load(wisata.gambar)
            .into(holder.binding.imgItemPhoto)

        holder.binding.tvItemName.text = wisata.nama
        holder.binding.tvItemDetail.text = "Lokasi: \n${wisata.lokasi}"

        holder.binding.btnSetShare.setOnClickListener {
            Toast.makeText(
                holder.itemView.context,
                "Share Data: ${wisata.nama}",
                Toast.LENGTH_SHORT
            ).show()
        }

        // Klik pada item
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listWisata[holder.adapterPosition])
        }
    }

    override fun getItemCount(): Int = listWisata.size

    inner class CardViewHolder(val binding: ItemCardKabkotaBinding) :
        RecyclerView.ViewHolder(binding.root)
}

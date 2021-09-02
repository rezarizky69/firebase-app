package com.eja.firebaseapp.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.amulyakhare.textdrawable.util.ColorGenerator
import com.eja.firebaseapp.R
import com.eja.firebaseapp.R.color.colorPrimary
import com.eja.firebaseapp.R.color.white
import com.eja.firebaseapp.holder.MainViewHolder
import com.eja.firebaseapp.model.ModelBarang

class MainAdapter(private val context: Context,
                  private val daftarBarang: ArrayList<ModelBarang?>?) : RecyclerView.Adapter<MainViewHolder>() {
    private val listener: FirebaseDataListener
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_barang, parent, false)
        return MainViewHolder(view)
    }

    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
//        val generator = ColorGenerator.MATERIAL //custom color
//        val color = generator.getColor()
        holder.view.setCardBackgroundColor(white)
        holder.namaBarang.text = "Nama   : " + (daftarBarang?.get(position)?.nama)
        holder.merkBarang.text = "Merk     : " + daftarBarang?.get(position)?.merk
        holder.tipeBarang.text = "Tipe     : " + daftarBarang?.get(position)?.tipe
        holder.hargaBarang.text = "Harga   : " + daftarBarang?.get(position)?.harga
        holder.view.setOnClickListener { listener.onDataClick(daftarBarang?.get(position), position) }
    }

    override fun getItemCount(): Int {

        return daftarBarang?.size!!
    }

    //interface data listener
    interface FirebaseDataListener {
        fun onDataClick(barang: ModelBarang?, position: Int)
    }

    init {
        listener = context as FirebaseDataListener
    }
}
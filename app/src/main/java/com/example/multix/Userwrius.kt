package com.example.multix

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView

class Userwrius(private val userList : ArrayList<Userwri>) :
    RecyclerView.Adapter<Userwrius.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemview : View = LayoutInflater.from(parent.context).inflate(R.layout.user_list,parent,false)
        return MyViewHolder(itemview)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentitem=userList[position]
        holder.inputvalue.text=currentitem.inputvalue
        holder.inputvalue1.text=currentitem.inputvalue1
        holder.inputvalue2.text=currentitem.inputvalue2
        holder.inputvalue3.text=currentitem.inputvalue3
        holder.inputvalue4.text=currentitem.inputvalue4
        holder.inputvalue5.text=currentitem.inputvalue5
        holder.inputvalue6.text=currentitem.inputvalue6
        holder.inputvalue7.text=currentitem.inputvalue7
        holder.inputvalue8.text=currentitem.inputvalue8
        holder.inputvalue9.text=currentitem.inputvalue9
    }

    override fun getItemCount(): Int {
        return userList.size
    }


    class MyViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){

        val inputvalue:TextView=itemView.findViewById(R.id.tvname)
        val inputvalue1:TextView=itemView.findViewById(R.id.tvname1)
        val inputvalue2:TextView=itemView.findViewById(R.id.tvphone)
        val inputvalue3:TextView=itemView.findViewById(R.id.tvadd)
        val inputvalue4:TextView=itemView.findViewById(R.id.tvemail)
        val inputvalue5:TextView=itemView.findViewById(R.id.tvphone1)
        val inputvalue6:TextView=itemView.findViewById(R.id.tvedu)
        val inputvalue7:TextView=itemView.findViewById(R.id.tvdate)
        val inputvalue8:TextView=itemView.findViewById(R.id.tvsex)
        val inputvalue9:TextView=itemView.findViewById(R.id.tvaadhar)

    }


}
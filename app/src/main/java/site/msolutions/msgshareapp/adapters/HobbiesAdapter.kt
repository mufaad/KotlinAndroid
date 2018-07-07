package site.msolutions.msgshareapp.adapters

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.list_item.view.*
import site.msolutions.msgshareapp.models.Hobby
import site.msolutions.msgshareapp.R
import site.msolutions.msgshareapp.showToast

class HobbiesAdapter(val context: Context, val hobbies: List<Hobby>):RecyclerView.Adapter<HobbiesAdapter.MyViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return hobbies.size
    }

    override fun onBindViewHolder(holder: MyViewHolder?, position: Int) {

        var hobby = hobbies[position]
        holder!!.setData(hobby, position)

    }


    inner class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)
    {
        var displayTitle = ""
        var displayPos: Int = 0
        init {
            //click to open toast
            itemView.setOnClickListener {

              context.showToast("You clicked: $displayTitle")
              //  itemView.setBackgroundColor(2)
            }


            //share with other apps
            itemView.imgShare.setOnClickListener {
                var intent = Intent()
                intent.action = Intent.ACTION_SEND
                intent.putExtra(Intent.EXTRA_TEXT, displayTitle)
                intent.type = "text/plain"
                context.startActivity(Intent.createChooser(intent, "Please Select An App:"))
            }
        }
        fun setData(hobby: Hobby?, pos:Int){

            //avoid null point errors .if hobby is null the code wont execute
            hobby?.let {

                itemView.txtViewMy.text = hobby.title
                displayTitle = hobby.title
                displayPos = pos

            }


        }
    }
}
package shahabek.myapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import shahabek.myapplication.databinding.ItemRvBinding
import shahabek.myapplication.models.MyTodoGetResponse


class Adapter(val list: List<MyTodoGetResponse>) : RecyclerView.Adapter<Adapter.VH>() {

    inner class VH(var itemRvBinding: ItemRvBinding) : RecyclerView.ViewHolder(itemRvBinding.root) {
        fun onBind(myTodoGetResponse: MyTodoGetResponse, position: Int) {
            itemRvBinding.tvName.text = myTodoGetResponse.sarlavha
            itemRvBinding.tvText.text = myTodoGetResponse.matn
            itemRvBinding.tvMuddat.text = myTodoGetResponse.oxirgi_muddat
            itemRvBinding.tvholat.text = myTodoGetResponse.holat
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(ItemRvBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onBind(list[position], position)
    }

    override fun getItemCount(): Int = list.size

}
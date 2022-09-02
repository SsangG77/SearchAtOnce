package Utl

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.Color.red
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toDrawable
import androidx.recyclerview.widget.RecyclerView
import com.sangjin.SearchAtOnce.R
import com.sangjin.SearchAtOnce.databinding.ItemRecyclerBinding
import searchVO.SearchVO

class CustomAdapter(private val mContext: Activity) : RecyclerView.Adapter<Holder>() {

    var listData = mutableListOf<SearchVO>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemRecyclerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val searchResult = listData.get(position)
        holder.setSearchResult(searchResult, mContext)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

}


class Holder(val binding : ItemRecyclerBinding) : RecyclerView.ViewHolder(binding.root) {

    fun setSearchResult(searchResult : SearchVO, mContext: Activity) {
        binding.searchWord.text = searchResult.getSearchWord()
        binding.siteName.text = searchResult.getSiteName()

        when(searchResult.getSiteName()) {
            "Naver" -> binding.siteName.setTextColor(Color.parseColor("#2DB400"))
            "Google" -> binding.siteName.setTextColor(Color.parseColor("#EA4335"))
            "Daum" -> binding.siteName.setTextColor(Color.parseColor("#3679FF"))
        }

        binding.link.text = searchResult.getResultLink()

        itemView.setOnClickListener {
            val urlIntent = Intent(Intent.ACTION_VIEW, Uri.parse(binding.link.text.toString()))
            mContext.startActivity(urlIntent)

        }
    }
}
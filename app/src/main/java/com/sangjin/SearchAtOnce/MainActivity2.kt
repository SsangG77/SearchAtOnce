package com.sangjin.SearchAtOnce

import Utl.CustomAdapter
import Utl.UtilFunction
import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.sangjin.SearchAtOnce.databinding.ActivityMain2Binding
import searchVO.SearchVO

class MainActivity2 : AppCompatActivity() {

    private var mBinding: ActivityMain2Binding? = null
    private val binding get() = mBinding!!
    private lateinit var adapter: CustomAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val data:MutableList<SearchVO> = mutableListOf()

        adapter = CustomAdapter(this)

        adapter.listData = data
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        val intent = intent

        val getNaverVO = intent.getSerializableExtra("Naver")
        val getGoogleVO = intent.getSerializableExtra("Google")
        val getDaumVO = intent.getSerializableExtra("Daum")

        if(getNaverVO != null) {
            data.add(getNaverVO as SearchVO)
        }
        if(getGoogleVO != null) {
            data.add(getGoogleVO as SearchVO)
        }
        if(getDaumVO != null) {
            data.add(getDaumVO as SearchVO)
        }
        else {
            val util = UtilFunction()
            util.toast(this, "넘어온 데이터가 없습니다.")
        }

    }
}
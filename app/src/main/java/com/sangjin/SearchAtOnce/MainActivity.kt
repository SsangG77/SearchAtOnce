package com.sangjin.SearchAtOnce

import Utl.UtilFunction
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.sangjin.SearchAtOnce.databinding.ActivityMainBinding
import searchVO.SearchVO

class MainActivity : AppCompatActivity() {

    private var mBinding : ActivityMainBinding? = null
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val func = UtilFunction()
        val intent = Intent(this, MainActivity2::class.java)

        var inputText = binding.putKeyword
        //네이버
        val naverCheckbox = binding.naverCheckbox
        val naverSearchQuery = "https://search.naver.com/search.naver?query="
        //구글
        val googleCheckBox = binding.googleCheckbox
        val googleSearchQuery = "https://www.google.co.kr/search?q="
        //다음
        val daumCheckBox = binding.daumCheckbox
        val daumSearchQuery = "https://search.daum.net/search?q="

        binding.searchBtn.setOnClickListener {
            if(inputText.text.toString() != "" && naverCheckbox.isChecked || googleCheckBox.isChecked || daumCheckBox.isChecked) {
                if(naverCheckbox.isChecked) {
                    val vo = SearchVO()
                    setVO(vo, "Naver", naverSearchQuery, inputText.text.toString(), intent)
                }
                if(googleCheckBox.isChecked) {
                    val vo = SearchVO()
                    setVO(vo, "Google", googleSearchQuery, inputText.text.toString(), intent)
                }
                if(daumCheckBox.isChecked) {
                    val vo = SearchVO()
                    setVO(vo, "Daum", daumSearchQuery, inputText.text.toString(), intent)
                }
                startActivity(intent)
            } else {
                func.toast(this, "선택한 사이트가 없습니다.")
            }
        }

    }

    fun setVO(getVo: SearchVO, siteName:String, query:String, searchWord:String, intent:Intent) {
        val vo = getVo
        vo.setSiteName(siteName)
        vo.setSearchWord(searchWord)
        vo.setResultLink("${query}${searchWord}")
        intent.putExtra(siteName, vo)
    }

}
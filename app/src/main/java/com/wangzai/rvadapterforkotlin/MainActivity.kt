package com.wangzai.rvadapterforkotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.wangzai.rvadapterforkotlin.adapter.MultiItemAdapter
import com.wangzai.rvadapterforkotlin.bean.TestBean
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val datas = listOf<TestBean>(TestBean("one", "one"), TestBean("two", "two"), TestBean("three", "three"), TestBean("two", "two"), TestBean("three", "three"), TestBean("one", "one"), TestBean("one", "one"), TestBean("one", "one"), TestBean("three", "three"), TestBean("two", "two"), TestBean("three", "three"), TestBean("two", "two"), TestBean("three", "three"), TestBean("one", "one"), TestBean("one", "one"), TestBean("one", "one"), TestBean("three", "three"), TestBean("one", "one"))
        recyclerView.layoutManager = LinearLayoutManager(this)
//        recyclerView.adapter = SingleItemAdapter(this, datas)
        recyclerView.adapter = MultiItemAdapter(this, datas)
    }
}

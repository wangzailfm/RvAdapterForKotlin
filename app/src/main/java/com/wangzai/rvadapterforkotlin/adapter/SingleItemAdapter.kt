package com.wangzai.rvadapterforkotlin.adapter

import android.content.Context
import com.wangzai.rvadapter.adapter.DelegateItemAdapter
import com.wangzai.rvadapterforkotlin.bean.TestBean
import com.wangzai.rvadapterforkotlin.delegate.SingleItemDelegate

class SingleItemAdapter(mContext: Context, mDatas: List<TestBean>)
    : DelegateItemAdapter<TestBean>(mContext, mDatas) {
    init {
        addItemViewDelegate(SingleItemDelegate())
    }
}
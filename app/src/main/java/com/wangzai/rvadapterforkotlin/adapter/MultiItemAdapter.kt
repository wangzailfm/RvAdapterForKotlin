package com.wangzai.rvadapterforkotlin.adapter

import android.content.Context
import com.wangzai.rvadapter.adapter.DelegateItemAdapter
import com.wangzai.rvadapterforkotlin.bean.TestBean
import com.wangzai.rvadapterforkotlin.delegate.CenterDelegate
import com.wangzai.rvadapterforkotlin.delegate.LeftDelegate
import com.wangzai.rvadapterforkotlin.delegate.RightDelegate

class MultiItemAdapter(mContext: Context, mDatas: List<TestBean>)
    : DelegateItemAdapter<TestBean>(mContext, mDatas) {
    init {
        addItemViewDelegate(LeftDelegate())
        addItemViewDelegate(CenterDelegate())
        addItemViewDelegate(RightDelegate())
    }
}
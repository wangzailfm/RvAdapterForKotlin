package com.wangzai.rvadapterforkotlin.delegate

import android.content.Context
import com.wangzai.rvadapter.base.DelegateType
import com.wangzai.rvadapter.base.ViewHolder
import com.wangzai.rvadapterforkotlin.R
import com.wangzai.rvadapterforkotlin.bean.TestBean
import com.wangzai.rvadapterforkotlin.toast
import kotlinx.android.synthetic.main.item_left.view.*

class LeftDelegate : DelegateType<TestBean> {
    override val itemViewLayoutId: Int
        get() = R.layout.item_left

    override fun isItemViewType(item: TestBean, position: Int): Boolean = "one" == item.type

    override fun convert(context: Context, holder: ViewHolder, item: TestBean, position: Int) {
        with(holder.itemView) {
            item_left_text.text = item.text
            setOnClickListener {
                context.toast("LeftDelegate")
            }
        }
    }
}
package com.wangzai.rvadapterforkotlin.delegate

import android.content.Context
import com.wangzai.rvadapterforkotlin.R
import com.wangzai.rvadapterforkotlin.base.DelegateType
import com.wangzai.rvadapterforkotlin.base.ViewHolder
import com.wangzai.rvadapterforkotlin.bean.TestBean
import com.wangzai.rvadapterforkotlin.toast
import kotlinx.android.synthetic.main.item_center.view.*

class CenterDelegate : DelegateType<TestBean> {
    override val itemViewLayoutId: Int
        get() = R.layout.item_center

    override fun isItemViewType(item: TestBean, position: Int): Boolean = "two" == item.type

    override fun convert(context: Context, holder: ViewHolder, item: TestBean, position: Int) {
        with(holder.itemView) {
            item_center_text.text = item.text
            setOnClickListener {
                context.toast("CenterDelegate")
            }
        }
    }
}
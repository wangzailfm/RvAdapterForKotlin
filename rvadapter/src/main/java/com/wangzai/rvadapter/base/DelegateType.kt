package com.wangzai.rvadapter.base

import android.content.Context

/**
 * itemView属性
 */
interface DelegateType<in T> { // 由于T只是作为参数，所以T是contravariant逆变，加in
    /**
     * 获取layoutId
     */
    val itemViewLayoutId: Int

    /**
     * 判断类型
     *
     * @param item data数据
     * @param position 当前position
     * @return true显示数据
     */
    fun isItemViewType(item: T, position: Int): Boolean

    /**
     * 显示数据
     *
     * @param context Context
     * @param holder ViewHolder
     * @param item data数据
     * @param position 当前position
     */
    fun convert(context: Context, holder: ViewHolder, item: T, position: Int)
}
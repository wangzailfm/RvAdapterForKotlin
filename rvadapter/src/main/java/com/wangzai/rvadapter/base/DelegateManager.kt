package com.wangzai.rvadapter.base

import android.content.Context
import android.support.v4.util.SparseArrayCompat
import java.lang.IllegalArgumentException

/**
 * itemView管理器
 */
class DelegateManager<T> {

    /**
     * itemView集合
     */
    val mDelegates: SparseArrayCompat<DelegateType<T>> = SparseArrayCompat()

    /**
     * 获取itemView总数
     */
    val delegateCount: Int
        get() = mDelegates.size()

    /**
     * 获取itemView的类型
     *
     * @param item data数据
     * @param position 当前position
     * @return Int
     */
    fun getItemViewType(item: T, position: Int): Int {
        (0.. delegateCount - 1)
                .filter { mDelegates.valueAt(it).isItemViewType(item, position) }
                .forEach { return mDelegates.keyAt(it) }
        throw IllegalArgumentException(
                "No ItemViewDelegate added that matches position = $position in data = $item source");
    }

    /**
     * 显示数据
     *
     * @param context Context
     * @param holder ViewHolder
     * @param item data数据
     * @param position 当前position
     */
    fun convert(context: Context, holder: ViewHolder, item: T, position: Int) {
        for (i in 0..delegateCount - 1) {
            val delegate = mDelegates.valueAt(i)
            if (delegate.isItemViewType(item, position)) {
                delegate.convert(context, holder, item, position);
                return@convert
            }
        }
        throw IllegalArgumentException(
                "No ItemViewDelegateManager added that matches position= $position in data = $item source")
    }

    /**
     * 添加itemView
     *
     * @param delegate itemView
     * @throws IllegalArgumentException 已存在不能再添加
     * @return DelegateManager
     */
    fun addDelegate(delegate: DelegateType<T>): DelegateManager<T> {
        for (i in 0..delegateCount - 1) {
            if (mDelegates.valueAt(i).itemViewLayoutId == delegate.itemViewLayoutId) {
                throw IllegalArgumentException("An ItemViewDelegate is already registered for the delegate = $delegate.")
            }
        }
        mDelegates.put(mDelegates.size(), delegate)
        return this
    }

    /**
     * 添加itemView
     *
     * @param viewType 代表itemView的下标
     * @param delegate itemView
     * @throws IllegalArgumentException 已存在不能再添加
     * @return DelegateManager
     */
    fun addDelegate(viewType: Int, delegate: DelegateType<T>): DelegateManager<T> {
        if (mDelegates.get(viewType) != null) {
            throw IllegalArgumentException("An ItemViewDelegate is already registered for the viewType = $viewType. Already registered ItemViewDelegate is ${mDelegates.get(viewType)}")
        }
        mDelegates.put(viewType, delegate)
        return this
    }

    /**
     * 移除itemView
     *
     * @param delegate itemView
     * @return DelegateManager
     */
    fun removeDelegate(delegate: DelegateType<T>): DelegateManager<T> {
        val indexToRemove = mDelegates.indexOfValue(delegate)

        if (indexToRemove >= 0) {
            mDelegates.removeAt(indexToRemove)
        }
        return this
    }

    /**
     * 移除itemView
     *
     * @param viewType 代表itemView的下标
     * @return DelegateManager
     */
    fun removeDelegate(viewType: Int): DelegateManager<T> {
        val indexToRemove = mDelegates.indexOfKey(viewType)

        if (indexToRemove >= 0) {
            mDelegates.removeAt(indexToRemove)
        }
        return this
    }

    /**
     * 获取itemView
     *
     * @param viewType 代表itemView的下标
     * @return DelegateType
     */
    fun getItemViewDelegate(viewType: Int): DelegateType<T> = mDelegates.get(viewType)

    /**
     * 获取itemView的LayoutId
     *
     * @param viewType 代表itemView的下标
     * @return Int
     */
    fun getItemViewLayoutId(viewType: Int): Int = getItemViewDelegate(viewType).itemViewLayoutId

    /**
     * 获取itemView的类型
     *
     * @param delegate itemView
     * @return Int
     */
    fun getItemViewType(delegate: DelegateType<T>): Int = mDelegates.indexOfValue(delegate)

}
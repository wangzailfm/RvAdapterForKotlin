package com.wangzai.rvadapterforkotlin.base

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    companion object {
        /**
         * 创建ViewHolder
         *
         * @param itemView itemView
         * @return ViewHolder
         */
        fun createViewHolder(itemView: View): ViewHolder {
            val holder = ViewHolder(itemView)
            return holder
        }

        /**
         * 创建ViewHolder
         *
         * @param context Context
         * @param parent ViewGroup
         * @param layoutId layoutId
         * @return ViewHolder
         */
        fun createViewHolder(context: Context,
                             parent: ViewGroup, layoutId: Int): ViewHolder {
            val itemView = LayoutInflater.from(context).inflate(layoutId, parent,
                    false)
            val holder = ViewHolder(itemView)
            return holder
        }
    }

}
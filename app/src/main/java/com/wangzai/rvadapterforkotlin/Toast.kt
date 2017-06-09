package com.wangzai.rvadapterforkotlin

import android.content.Context
import android.widget.Toast

fun Context.toast(content: String) {
    Toast.makeText(this, content, Toast.LENGTH_SHORT).show()
}
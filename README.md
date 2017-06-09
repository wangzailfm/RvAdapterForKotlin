# RvAdapterForKotlin
使用Kotlin写的实现Android的Recyclerview的多种item布局


## 使用

### 一种item布局
1.创建一个itemView
```kotlin
class SingleItemDelegate : DelegateType<TestBean> {
    override val itemViewLayoutId: Int
        get() = R.layout.item_left

    override fun isItemViewType(item: TestBean, position: Int): Boolean = true

    override fun convert(context: Context, holder: ViewHolder, item: TestBean, position: Int) {
        with(holder.itemView) {
            item_left_text.text = item.text
            setOnClickListener {
                context.toast("SingleItemDelegate")
            }
        }
    }
}
```

2.添加到Adapter里面
```kotlin
class SingleItemAdapter(mContext: Context, mDatas: List<TestBean>)
    : DelegateItemAdapter<TestBean>(mContext, mDatas) {
    init {
        addItemViewDelegate(SingleItemDelegate())
    }
}
```

3.设置RecyclerView的Adapter
```kotlin
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val datas = listOf<TestBean>(TestBean("one", "one"), TestBean("two", "two"), TestBean("three", "three"), TestBean("two", "two"), TestBean("three", "three"), TestBean("one", "one"), TestBean("one", "one"), TestBean("one", "one"), TestBean("three", "three"), TestBean("two", "two"), TestBean("three", "three"), TestBean("two", "two"), TestBean("three", "three"), TestBean("one", "one"), TestBean("one", "one"), TestBean("one", "one"), TestBean("three", "three"), TestBean("one", "one"))
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = SingleItemAdapter(this, datas)
    }
}
```

4.效果图

![SingleItem](http://upload-images.jianshu.io/upload_images/1241355-4c6e971a09036c8e.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

### 多种item布局

1.创建多个个itemView
```kotlin
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

class RightDelegate : DelegateType<TestBean> {
    override val itemViewLayoutId: Int
        get() = R.layout.item_right

    override fun isItemViewType(item: TestBean, position: Int): Boolean = "three" == item.type

    override fun convert(context: Context, holder: ViewHolder, item: TestBean, position: Int) {
        with(holder.itemView) {
            item_right_text.text = item.text
            setOnClickListener {
                context.toast("RightDelegate")
            }
        }
    }
}
```

2.添加到Adapter里面
```kotlin
class MultiItemAdapter(mContext: Context, mDatas: List<TestBean>) 
    : DelegateItemAdapter<TestBean>(mContext, mDatas) {
    init {
        addItemViewDelegate(LeftDelegate())
        addItemViewDelegate(CenterDelegate())
        addItemViewDelegate(RightDelegate())
    }
}
```

3.设置RecyclerView的Adapter
```kotlin
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val datas = listOf<TestBean>(TestBean("one", "one"), TestBean("two", "two"), TestBean("three", "three"), TestBean("two", "two"), TestBean("three", "three"), TestBean("one", "one"), TestBean("one", "one"), TestBean("one", "one"), TestBean("three", "three"), TestBean("two", "two"), TestBean("three", "three"), TestBean("two", "two"), TestBean("three", "three"), TestBean("one", "one"), TestBean("one", "one"), TestBean("one", "one"), TestBean("three", "three"), TestBean("one", "one"))
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = MultiItemAdapter(this, datas)
    }
}

```

4.效果图

![MultiItem](http://upload-images.jianshu.io/upload_images/1241355-704a68a70b901398.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
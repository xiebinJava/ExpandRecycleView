# ExpandRecycleView
Expand RecycleView 是单个RecycleView 来实现 ExpandableListView 的效果。好处是可以添加展开和搜索动画。
我们先看下效果：



![conv_ops](https://github.com/xiebinJava/ExpandRecycleView/blob/master/A1D798DBA7F818B2E0754FFF84D848E0.gif?raw=true)



展开的动画我用的是默认的，大家需要其他的动画的话，可以自己重写一下动画效果。这里主要看一下代码这么实现以及数据结构的整理。


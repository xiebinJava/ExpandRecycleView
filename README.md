# ExpandRecycleView
Expand RecycleView 是单个RecycleView 来实现 ExpandableListView 的效果。好处是可以添加展开和搜索动画。
我们先看下效果：



![conv_ops](https://github.com/xiebinJava/ExpandRecycleView/blob/master/A1D798DBA7F818B2E0754FFF84D848E0.gif?raw=true)



展开的动画我用的是默认的，大家需要其他的动画的话，可以自己重写一下动画效果。这里主要看一下代码这么实现以及数据结构的整理。

![cony_ops](https://github.com/xiebinJava/ExpandRecycleView/blob/master/%7D31%5DKJMJI%7DZR9NS%5D558TQM4.png?raw=true)

这是我再做项目的时候，从服务器获取的数据。这个数据，我们再做的时候需要进一步处理。


![cony_ops](https://github.com/xiebinJava/ExpandRecycleView/blob/master/XFORN~H84XUY7EMUKQG61FM.png?raw=true)

  1：处理数据，设置RecycleView 的布局
  
  
  
           /**
               * 整理数据
               */
              private void initData() {
                  String json = new String(getAssertsFile(this, "data.json"));
                  Gson gson = new Gson();
                  myDataBean = gson.fromJson(json, MyDataBean.class);
                  categories = myDataBean.getData().getCategories();
                  if (subCategoriesBeansListShow.size() == 0) {
                      int size = categories.size();
                      //1：遍历大集合 categories (下面叫一级分类)  SubCategories（下面叫二级分类）
                      for (int i = 0; i < size; i++) {
                          MyDataBean.DataBean.CategoriesBean categoriesBean = categories.get(i);
                          //2：创建二级分类对象，把一级分类的数据（name:aaaaaaa）放到二级分类对象中，并设置title为true
                          MyDataBean.DataBean.CategoriesBean.SubCategoriesBean subCategoriesBean = new MyDataBean.DataBean.CategoriesBean.SubCategoriesBean();
                          subCategoriesBean.setName(categoriesBean.getName());
                          subCategoriesBean.setTitle(true);
                          subCategoriesBean.setTitleOldListPos(i);
                          //3:创建二级分类对象，把一级分类的数据（introduce:bbbbbbb）放到二级分类对象中,并设置子View 的title为true
                          MyDataBean.DataBean.CategoriesBean.SubCategoriesBean subCategoriesBean2 = new MyDataBean.DataBean.CategoriesBean.SubCategoriesBean();
                          subCategoriesBean2.setName(categoriesBean.getIntroduce());
                          subCategoriesBean2.setChildTitle(true);
                          //4:把子View 的title 放到二级分类第一个
                          categoriesBean.getSub_categories().add(0, subCategoriesBean2);
                          //5：创建一个三级分类集合，放入我们创建的第一个二级分类对象
                          subCategoriesBeansListShow.add(subCategoriesBean);
                      }
                      rvExpand.setLayoutManager(new LinearLayoutManager(this));
                      homeCategoriesAdapter = new HomeCategoriesAdapter(this, categories, subCategoriesBeansListShow, this);
                  }
                  rvExpand.setAdapter(homeCategoriesAdapter);
                  //以下是对布局进行控制，3表示3个条目做为一行
                  final GridLayoutManager manager = new GridLayoutManager(this, 3);
                  manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                      @Override
                      public int getSpanSize(int position) {
                          //如果条目的 type 是 1 ， 那么这个条目就占3个位置。也就是一行
                          if (homeCategoriesAdapter.getItemViewType(position) == 1) {
                              return 3;
                              //如果条目的 type 是 2 ， 那么这个条目就占3个位置。也就是一行
                          } else if (homeCategoriesAdapter.getItemViewType(position) == 2) {
                              return 3;
                          } else {
                              return 1;
                          }
                      }
                  });
                  rvExpand.setLayoutManager(manager);
              }
              
              
              
2：在Adapter里面根据 type 填充布局

          @Override
              public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                  View itemView;
                  if (viewType == 1) {
                      itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_categories, parent, false);
                      return new ViewHolder(itemView);
                  } else if (viewType == 2 ) {
                      itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.categories_header, parent, false);
                      return new ViewHolderChildTitle(itemView);
                  } else {
                      itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_categories_gridview1, parent, false);
                      return new ViewHolder1(itemView);
                  }
              }
              
 3：如何优雅的为横向排列的 item 设置 间距。
      
      //计算出横向排列的数据的大小 size (减1是减掉type = 2的情况)
            int size = categories.get(titleOldListPos).getSub_categories().size()-1;
            //每行是3个 就 %3  如果等于0   结果就是行数，
            if (size % 3 == 0) {
                pos = size / 3;
            } else {
                //如果不等于0  先将结果转为int 然后加一
                pos = size / 3 + 1;
            }
            //postion - 3*行数 = 2+titleOldListPos  如果等式成立表示第一列
            //postion - 3*行数 = 3+titleOldListPos  如果等式成立表示第二列
            //postion - 3*行数 = 4+titleOldListPos  如果等式成立表示第三列
            for (int i = 0; i <= pos; i++) {
                if (position - 3 * i == titleOldListPos + 2) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                    layoutParams.setMargins(30, 0, 10, 30);
                    itemSectionHolder.item_categories_relas.setLayoutParams(layoutParams);
                } else if (position - 3 * i == titleOldListPos + 3) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                    layoutParams.setMargins(10, 0, 10, 30);
                    itemSectionHolder.item_categories_relas.setLayoutParams(layoutParams);
                } else if (position - 3 * i == titleOldListPos + 4) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                    layoutParams.setMargins(10, 0, 30, 30);
                    itemSectionHolder.item_categories_relas.setLayoutParams(layoutParams);
                }
            }
            
            
            
4：如何展开和收起布局



      /**
           * 展开某个item
           *
           * @param titleIndex 点击的title的position,还需要这个position在categories集合下面的角标时多少。这里算出来
           */
          private void expand(int titleIndex, int categoriesPos) {
              categoriesBeanListShow.addAll(categoriesPos + 1, categories.get(categoriesPos).getSub_categories());
              curExpandChapterIndex = categoriesPos;
              categories.get(categoriesPos).setExpand(true);
              notifyItemRangeInserted(categoriesPos + 1, categories.get(categoriesPos).getSub_categories().size());
              notifyItemRangeChanged(0, getItemCount(), "change_position");
          }

          /**
           * 收起某个item
           *
           * @param titleIndex
           */
          private void narrow(int titleIndex) {
              if (titleIndex != -1) {
                  int removeStart = titleIndex + 1;
                  int removeCount = 0;
                  for (int i = removeStart; i < categoriesBeanListShow.size() && (getItemViewType(i) == 3 || getItemViewType(i) == 2); i++) {
                      removeCount++;
                  }
                  categoriesBeanListShow.removeAll(categories.get(titleIndex).getSub_categories());
                  categories.get(titleIndex).setExpand(false);
                  notifyItemRangeRemoved(removeStart, removeCount);
                  notifyItemRangeChanged(0, getItemCount(), "change_position");
              }
          }

            

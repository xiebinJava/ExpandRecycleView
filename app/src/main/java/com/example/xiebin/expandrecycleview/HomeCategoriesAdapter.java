package com.example.xiebin.expandrecycleview;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 *
 * @author zhangxiang
 * @date 2017/8/31
 */
public class HomeCategoriesAdapter extends RecyclerView.Adapter {

    private final List<MyDataBean.DataBean.CategoriesBean> categories;
    Activity activity;
    private final LayoutInflater layoutInflater;
    private AllCategoriesOnClickListener allCategoriesOnClickListener;
    //当前展开的课时，-1代表没有任何展开
    private int curExpandChapterIndex = 0;
    //显示数据的集合，用于展开
    List<MyDataBean.DataBean.CategoriesBean.SubCategoriesBean>  categoriesBeanListShow;
    private int titleOldListPos;
    private int pos;

    public HomeCategoriesAdapter(Activity activity, List<MyDataBean.DataBean.CategoriesBean> categories, List<MyDataBean.DataBean.CategoriesBean.SubCategoriesBean> categoriesBeanListShow, AllCategoriesOnClickListener allCategoriesOnClickListener) {
        this.activity = activity;
        this.categories = categories;
        this.allCategoriesOnClickListener = allCategoriesOnClickListener;
        layoutInflater = LayoutInflater.from(activity);
        this.categoriesBeanListShow = categoriesBeanListShow;
        categoriesBeanListShow.addAll(1, categories.get(0).getSub_categories());
    }


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

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final MyDataBean.DataBean.CategoriesBean.SubCategoriesBean subCategoriesBean = categoriesBeanListShow.get(position);
        if (getItemViewType(position) == 1) {
            final ViewHolder itemHolder = (ViewHolder) holder;
            itemHolder.itemView.setTag(position);
            itemHolder.labText1.setTag(position);
            itemHolder.labText1.setText(subCategoriesBean.getName());
            if (curExpandChapterIndex == position) {
                itemHolder.categoriesDownImage.setBackgroundResource(R.drawable.arrow_black_down);
            } else {
                itemHolder.categoriesDownImage.setBackgroundResource(R.drawable.arrow_down);
            }
            itemHolder.categoriesExpand.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!categories.get(subCategoriesBean.getTitleOldListPos()).isExpand()) {
                        if (position == curExpandChapterIndex) {
                            narrow(curExpandChapterIndex);
                        } else {
                            narrow(curExpandChapterIndex);
                            expand(position, subCategoriesBean.getTitleOldListPos());
                            titleOldListPos = subCategoriesBean.getTitleOldListPos();
                        }
                    }
                }
            });
        } else if (getItemViewType(position) == 2) {
            ViewHolderChildTitle holderChidTitle = (ViewHolderChildTitle) holder;
            holderChidTitle.categoriesHeaderTiele.setTag(position);
            holderChidTitle.llTwoHeader.setTag(position);
            holderChidTitle.categoriesHeaderTiele.setText(subCategoriesBean.getName());
        } else {
            ViewHolder1 itemSectionHolder = (ViewHolder1) holder;
            itemSectionHolder.allcategoreGrideviewTextone.setTag(position);
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
            itemSectionHolder.allcategoreGrideviewTextone.setText(subCategoriesBean.getName());
            itemSectionHolder.item_categories_relas.setBackground(activity.getResources().getDrawable(R.color.white));
            itemSectionHolder.item_categories_relas.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    allCategoriesOnClickListener.clickItem(subCategoriesBean);
                }
            });
        }
    }

    //该方法只更改itemView的部分信息，不全部刷新
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position, List payloads) {
        if (payloads.isEmpty()) {
            super.onBindViewHolder(holder, position, payloads);
        } else {
            String str = (String) payloads.get(0);
            //更改view的tag
            if (str.equals("change_position")) {
                if (getItemViewType(position) == 1) {
                    ViewHolder itemHolder = (ViewHolder) holder;
                    itemHolder.itemView.setTag(position);
                    itemHolder.labText1.setTag(position);
                    //改变箭头方向
                    if (curExpandChapterIndex == position) {
                        itemHolder.categoriesDownImage.setBackgroundResource(R.drawable.arrow_black_down);
                    } else {
                        itemHolder.categoriesDownImage.setBackgroundResource(R.drawable.arrow_down);
                    }
                } else {
                    ViewHolder1 itemSectionHolder = (ViewHolder1) holder;
                    itemSectionHolder.allcategoreGrideviewTextone.setTag(position);
                }
            }
        }
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public int getItemCount() {
        if (categoriesBeanListShow == null) {
            return 0;
        } else {
            return categoriesBeanListShow.size();
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (categoriesBeanListShow.get(position).isTitle()) {
            return 1;
        } else if (categoriesBeanListShow.get(position).isChildTitle()) {
            return 2;
        } else {
            return 3;
        }
    }


    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.lab_text1)
        TextView labText1;
        @BindView(R.id.categories_image)
        ImageView categoriesImage;
        @BindView(R.id.categories_down_image)
        ImageView categoriesDownImage;
        @BindView(R.id.categories_expand)
        RelativeLayout categoriesExpand;
        @BindView(R.id.categories_line)
        LinearLayout categoriesLine;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    static class ViewHolder1 extends RecyclerView.ViewHolder {
        @BindView(R.id.allcategore_grideview_image)
        ImageView allcategoreGrideviewImage;
        @BindView(R.id.allcategore_grideview_textone)
        TextView allcategoreGrideviewTextone;
        @BindView(R.id.item_categories_relas)
        RelativeLayout item_categories_relas;

        ViewHolder1(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    static class ViewHolderChildTitle extends RecyclerView.ViewHolder {
        @BindView(R.id.categories_header_tiele)
        TextView categoriesHeaderTiele;
        @BindView(R.id.ll_two_header)
        RelativeLayout llTwoHeader;

        ViewHolderChildTitle(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }


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

    public interface AllCategoriesOnClickListener {
        //这里不传 position 出去，应为postion乱了，数据经过更改
        void clickItem(MyDataBean.DataBean.CategoriesBean.SubCategoriesBean subCategoriesBean);

    }
}

package com.example.xiebin.expandrecycleview;

import java.util.List;

/**
 *
 * @author xiebin
 * @date 2018/7/5
 */

public class MyDataBean {


    /**
     * Code : 200
     * data : {"categories":[{"banner_image":"http://www.fs.com/includes/modules/phone/images/category/1.png","introduce":"bbbbbbbb","name":"aaaaaaa","sub_categories":[{"id":"6","image":"https://www.fs.com/imgCache/2/20e14f36fc7d16d84dc1d06cf3a91be8.image.220x220.jpg","name":"product1"},{"id":"894","image":"https://www.fs.com/imgCache/1/1876c88013130d29e7c6167077bd02a0.image.220x220.jpg","name":"product2"},{"id":"1023","image":"https://www.fs.com/imgCache/4/4b659e31dbed05f0e43efe77fc1ddb56.image.220x220.jpg","name":"product3"},{"id":"1017","image":"https://www.fs.com/imgCache/6/6bdb166be2cfabedda6c0e511263f9c4.image.220x220.jpg","name":"product4"},{"id":"1334","image":"https://www.fs.com/imgCache/f/f7ce13b2840fc26624d19f819d315768.image.220x220.jpg","name":"product5"},{"id":"999","image":"https://www.fs.com/imgCache/f/ff4db43841d027fc8e81c888415c94db.image.220x220.jpg","name":"product6"},{"id":"1105","image":"https://www.fs.com/imgCache/a/a4c526787e17ee29094224b2d2243080.image.220x220.jpg","name":"product7"},{"id":"1080","image":"https://www.fs.com/imgCache/b/b1d6daa6bd5035f1ea0e5fadbbbf5c93.image.220x220.jpg","name":"product8"}]},{"banner_image":"http://www.fs.com/includes/modules/phone/images/category/1.png","introduce":"bbbbbbbb","name":"aaaaaaa","sub_categories":[{"id":"6","image":"https://www.fs.com/imgCache/2/20e14f36fc7d16d84dc1d06cf3a91be8.image.220x220.jpg","name":"product1"},{"id":"894","image":"https://www.fs.com/imgCache/1/1876c88013130d29e7c6167077bd02a0.image.220x220.jpg","name":"product2"},{"id":"1023","image":"https://www.fs.com/imgCache/4/4b659e31dbed05f0e43efe77fc1ddb56.image.220x220.jpg","name":"product3"},{"id":"1017","image":"https://www.fs.com/imgCache/6/6bdb166be2cfabedda6c0e511263f9c4.image.220x220.jpg","name":"product4"},{"id":"1334","image":"https://www.fs.com/imgCache/f/f7ce13b2840fc26624d19f819d315768.image.220x220.jpg","name":"product5"},{"id":"999","image":"https://www.fs.com/imgCache/f/ff4db43841d027fc8e81c888415c94db.image.220x220.jpg","name":"product6"},{"id":"1105","image":"https://www.fs.com/imgCache/a/a4c526787e17ee29094224b2d2243080.image.220x220.jpg","name":"product7"},{"id":"1080","image":"https://www.fs.com/imgCache/b/b1d6daa6bd5035f1ea0e5fadbbbf5c93.image.220x220.jpg","name":"product8"}]},{"banner_image":"http://www.fs.com/includes/modules/phone/images/category/1.png","introduce":"bbbbbbbb","name":"aaaaaaa","sub_categories":[{"id":"6","image":"https://www.fs.com/imgCache/2/20e14f36fc7d16d84dc1d06cf3a91be8.image.220x220.jpg","name":"product1"},{"id":"894","image":"https://www.fs.com/imgCache/1/1876c88013130d29e7c6167077bd02a0.image.220x220.jpg","name":"product2"},{"id":"1023","image":"https://www.fs.com/imgCache/4/4b659e31dbed05f0e43efe77fc1ddb56.image.220x220.jpg","name":"product3"},{"id":"1017","image":"https://www.fs.com/imgCache/6/6bdb166be2cfabedda6c0e511263f9c4.image.220x220.jpg","name":"product4"},{"id":"1334","image":"https://www.fs.com/imgCache/f/f7ce13b2840fc26624d19f819d315768.image.220x220.jpg","name":"product5"},{"id":"999","image":"https://www.fs.com/imgCache/f/ff4db43841d027fc8e81c888415c94db.image.220x220.jpg","name":"product6"},{"id":"1105","image":"https://www.fs.com/imgCache/a/a4c526787e17ee29094224b2d2243080.image.220x220.jpg","name":"product7"},{"id":"1080","image":"https://www.fs.com/imgCache/b/b1d6daa6bd5035f1ea0e5fadbbbf5c93.image.220x220.jpg","name":"product8"}]},{"banner_image":"http://www.fs.com/includes/modules/phone/images/category/1.png","introduce":"bbbbbbbb","name":"aaaaaaa","sub_categories":[{"id":"6","image":"https://www.fs.com/imgCache/2/20e14f36fc7d16d84dc1d06cf3a91be8.image.220x220.jpg","name":"product1"},{"id":"894","image":"https://www.fs.com/imgCache/1/1876c88013130d29e7c6167077bd02a0.image.220x220.jpg","name":"product2"},{"id":"1023","image":"https://www.fs.com/imgCache/4/4b659e31dbed05f0e43efe77fc1ddb56.image.220x220.jpg","name":"product3"},{"id":"1017","image":"https://www.fs.com/imgCache/6/6bdb166be2cfabedda6c0e511263f9c4.image.220x220.jpg","name":"product4"},{"id":"1334","image":"https://www.fs.com/imgCache/f/f7ce13b2840fc26624d19f819d315768.image.220x220.jpg","name":"product5"},{"id":"999","image":"https://www.fs.com/imgCache/f/ff4db43841d027fc8e81c888415c94db.image.220x220.jpg","name":"product6"},{"id":"1105","image":"https://www.fs.com/imgCache/a/a4c526787e17ee29094224b2d2243080.image.220x220.jpg","name":"product7"},{"id":"1080","image":"https://www.fs.com/imgCache/b/b1d6daa6bd5035f1ea0e5fadbbbf5c93.image.220x220.jpg","name":"product8"}]}],"msg":"","result":"success","total_items":0}
     * msg :
     * result : success
     */

    private int Code;
    private DataBean data;
    private String msg;
    private String result;

    public int getCode() {
        return Code;
    }

    public void setCode(int Code) {
        this.Code = Code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public static class DataBean {
        /**
         * categories : [{"banner_image":"http://www.fs.com/includes/modules/phone/images/category/1.png","introduce":"bbbbbbbb","name":"aaaaaaa","sub_categories":[{"id":"6","image":"https://www.fs.com/imgCache/2/20e14f36fc7d16d84dc1d06cf3a91be8.image.220x220.jpg","name":"product1"},{"id":"894","image":"https://www.fs.com/imgCache/1/1876c88013130d29e7c6167077bd02a0.image.220x220.jpg","name":"product2"},{"id":"1023","image":"https://www.fs.com/imgCache/4/4b659e31dbed05f0e43efe77fc1ddb56.image.220x220.jpg","name":"product3"},{"id":"1017","image":"https://www.fs.com/imgCache/6/6bdb166be2cfabedda6c0e511263f9c4.image.220x220.jpg","name":"product4"},{"id":"1334","image":"https://www.fs.com/imgCache/f/f7ce13b2840fc26624d19f819d315768.image.220x220.jpg","name":"product5"},{"id":"999","image":"https://www.fs.com/imgCache/f/ff4db43841d027fc8e81c888415c94db.image.220x220.jpg","name":"product6"},{"id":"1105","image":"https://www.fs.com/imgCache/a/a4c526787e17ee29094224b2d2243080.image.220x220.jpg","name":"product7"},{"id":"1080","image":"https://www.fs.com/imgCache/b/b1d6daa6bd5035f1ea0e5fadbbbf5c93.image.220x220.jpg","name":"product8"}]},{"banner_image":"http://www.fs.com/includes/modules/phone/images/category/1.png","introduce":"bbbbbbbb","name":"aaaaaaa","sub_categories":[{"id":"6","image":"https://www.fs.com/imgCache/2/20e14f36fc7d16d84dc1d06cf3a91be8.image.220x220.jpg","name":"product1"},{"id":"894","image":"https://www.fs.com/imgCache/1/1876c88013130d29e7c6167077bd02a0.image.220x220.jpg","name":"product2"},{"id":"1023","image":"https://www.fs.com/imgCache/4/4b659e31dbed05f0e43efe77fc1ddb56.image.220x220.jpg","name":"product3"},{"id":"1017","image":"https://www.fs.com/imgCache/6/6bdb166be2cfabedda6c0e511263f9c4.image.220x220.jpg","name":"product4"},{"id":"1334","image":"https://www.fs.com/imgCache/f/f7ce13b2840fc26624d19f819d315768.image.220x220.jpg","name":"product5"},{"id":"999","image":"https://www.fs.com/imgCache/f/ff4db43841d027fc8e81c888415c94db.image.220x220.jpg","name":"product6"},{"id":"1105","image":"https://www.fs.com/imgCache/a/a4c526787e17ee29094224b2d2243080.image.220x220.jpg","name":"product7"},{"id":"1080","image":"https://www.fs.com/imgCache/b/b1d6daa6bd5035f1ea0e5fadbbbf5c93.image.220x220.jpg","name":"product8"}]},{"banner_image":"http://www.fs.com/includes/modules/phone/images/category/1.png","introduce":"bbbbbbbb","name":"aaaaaaa","sub_categories":[{"id":"6","image":"https://www.fs.com/imgCache/2/20e14f36fc7d16d84dc1d06cf3a91be8.image.220x220.jpg","name":"product1"},{"id":"894","image":"https://www.fs.com/imgCache/1/1876c88013130d29e7c6167077bd02a0.image.220x220.jpg","name":"product2"},{"id":"1023","image":"https://www.fs.com/imgCache/4/4b659e31dbed05f0e43efe77fc1ddb56.image.220x220.jpg","name":"product3"},{"id":"1017","image":"https://www.fs.com/imgCache/6/6bdb166be2cfabedda6c0e511263f9c4.image.220x220.jpg","name":"product4"},{"id":"1334","image":"https://www.fs.com/imgCache/f/f7ce13b2840fc26624d19f819d315768.image.220x220.jpg","name":"product5"},{"id":"999","image":"https://www.fs.com/imgCache/f/ff4db43841d027fc8e81c888415c94db.image.220x220.jpg","name":"product6"},{"id":"1105","image":"https://www.fs.com/imgCache/a/a4c526787e17ee29094224b2d2243080.image.220x220.jpg","name":"product7"},{"id":"1080","image":"https://www.fs.com/imgCache/b/b1d6daa6bd5035f1ea0e5fadbbbf5c93.image.220x220.jpg","name":"product8"}]},{"banner_image":"http://www.fs.com/includes/modules/phone/images/category/1.png","introduce":"bbbbbbbb","name":"aaaaaaa","sub_categories":[{"id":"6","image":"https://www.fs.com/imgCache/2/20e14f36fc7d16d84dc1d06cf3a91be8.image.220x220.jpg","name":"product1"},{"id":"894","image":"https://www.fs.com/imgCache/1/1876c88013130d29e7c6167077bd02a0.image.220x220.jpg","name":"product2"},{"id":"1023","image":"https://www.fs.com/imgCache/4/4b659e31dbed05f0e43efe77fc1ddb56.image.220x220.jpg","name":"product3"},{"id":"1017","image":"https://www.fs.com/imgCache/6/6bdb166be2cfabedda6c0e511263f9c4.image.220x220.jpg","name":"product4"},{"id":"1334","image":"https://www.fs.com/imgCache/f/f7ce13b2840fc26624d19f819d315768.image.220x220.jpg","name":"product5"},{"id":"999","image":"https://www.fs.com/imgCache/f/ff4db43841d027fc8e81c888415c94db.image.220x220.jpg","name":"product6"},{"id":"1105","image":"https://www.fs.com/imgCache/a/a4c526787e17ee29094224b2d2243080.image.220x220.jpg","name":"product7"},{"id":"1080","image":"https://www.fs.com/imgCache/b/b1d6daa6bd5035f1ea0e5fadbbbf5c93.image.220x220.jpg","name":"product8"}]}]
         * msg :
         * result : success
         * total_items : 0
         */

        private String msg;
        private String result;
        private int total_items;
        private List<CategoriesBean> categories;

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public String getResult() {
            return result;
        }

        public void setResult(String result) {
            this.result = result;
        }

        public int getTotal_items() {
            return total_items;
        }

        public void setTotal_items(int total_items) {
            this.total_items = total_items;
        }

        public List<CategoriesBean> getCategories() {
            return categories;
        }

        public void setCategories(List<CategoriesBean> categories) {
            this.categories = categories;
        }

        public static class CategoriesBean {
            /**
             * banner_image : http://www.fs.com/includes/modules/phone/images/category/1.png
             * introduce : bbbbbbbb
             * name : aaaaaaa
             * sub_categories : [{"id":"6","image":"https://www.fs.com/imgCache/2/20e14f36fc7d16d84dc1d06cf3a91be8.image.220x220.jpg","name":"product1"},{"id":"894","image":"https://www.fs.com/imgCache/1/1876c88013130d29e7c6167077bd02a0.image.220x220.jpg","name":"product2"},{"id":"1023","image":"https://www.fs.com/imgCache/4/4b659e31dbed05f0e43efe77fc1ddb56.image.220x220.jpg","name":"product3"},{"id":"1017","image":"https://www.fs.com/imgCache/6/6bdb166be2cfabedda6c0e511263f9c4.image.220x220.jpg","name":"product4"},{"id":"1334","image":"https://www.fs.com/imgCache/f/f7ce13b2840fc26624d19f819d315768.image.220x220.jpg","name":"product5"},{"id":"999","image":"https://www.fs.com/imgCache/f/ff4db43841d027fc8e81c888415c94db.image.220x220.jpg","name":"product6"},{"id":"1105","image":"https://www.fs.com/imgCache/a/a4c526787e17ee29094224b2d2243080.image.220x220.jpg","name":"product7"},{"id":"1080","image":"https://www.fs.com/imgCache/b/b1d6daa6bd5035f1ea0e5fadbbbf5c93.image.220x220.jpg","name":"product8"}]
             */

            private String banner_image;
            private String introduce;
            private String name;

            public boolean isExpand() {
                return isExpand;
            }

            public void setExpand(boolean expand) {
                isExpand = expand;
            }

            private boolean isExpand;
            private List<SubCategoriesBean> sub_categories;

            public String getBanner_image() {
                return banner_image;
            }

            public void setBanner_image(String banner_image) {
                this.banner_image = banner_image;
            }

            public String getIntroduce() {
                return introduce;
            }

            public void setIntroduce(String introduce) {
                this.introduce = introduce;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public List<SubCategoriesBean> getSub_categories() {
                return sub_categories;
            }

            public void setSub_categories(List<SubCategoriesBean> sub_categories) {
                this.sub_categories = sub_categories;
            }

            public static class SubCategoriesBean {
                /**
                 * id : 6
                 * image : https://www.fs.com/imgCache/2/20e14f36fc7d16d84dc1d06cf3a91be8.image.220x220.jpg
                 * name : product1
                 */

                private String id;
                private String image;
                private String name;

                public boolean isChildTitle() {
                    return isChildTitle;
                }

                public void setChildTitle(boolean childTitle) {
                    isChildTitle = childTitle;
                }

                private boolean isChildTitle;

                public boolean isTitle() {
                    return isTitle;
                }

                public void setTitle(boolean title) {
                    isTitle = title;
                }

                public int getTitleOldListPos() {
                    return titleOldListPos;
                }

                public void setTitleOldListPos(int titleOldListPos) {
                    this.titleOldListPos = titleOldListPos;
                }

                private boolean isTitle;
                private int titleOldListPos;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getImage() {
                    return image;
                }

                public void setImage(String image) {
                    this.image = image;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }
            }
        }
    }
}

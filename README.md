# GridAnimal

仿照LISVIEW 做出来的GRIDVIEW的动画

使用方法和googlelistview基本一样
···java
adapter=new aadapter(this,list);----生成Adapter
                GridViewSwingBottomInAnimationAdapter swingBottomInAnimationAdapter= new GridViewSwingBottomInAnimationAdapter(adapter);-----直接引入动画文件
                swingBottomInAnimationAdapter.setGridView(gridView); ------把GridView加进动画文件
                gridView.setAdapter(swingBottomInAnimationAdapter);-------把动画set进GridView
```

目前动画方法有四个

GridViewScaleInAnimationAdapter

GridViewSwingBottomInAnimationAdapter

GridViewSwingLeftInAnimationAdapter

GridViewSwingRightInAnimationAdapter


效果如下：

![1](https://github.com/01100044093/GridAnimal/blob/master/113634nn8z1xkc6zux4oxf.gif)
![2](https://github.com/01100044093/GridAnimal/blob/master/113634qs7gvr6ljrv6glil.gif)
![3](https://github.com/01100044093/GridAnimal/blob/master/113635x1k1rz2kk1w1b15u.gif)
![4](https://github.com/01100044093/GridAnimal/blob/master/113636h5hoiwp5omozinoo.gif)




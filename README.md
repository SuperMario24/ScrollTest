# ScrollTest
控件跟随手势移动

View的滑动
1.使用ScrollTo/ScrollBy方法：
  缺点：只能滑动view的内容,并不能滑动view本身。
2.使用动画：
  Android3.0以上，没有明显的缺点；
  如果使用view动画或者在Android3.0以下使用属性动画，均不能改变view本身的属性；
  能实现一些复杂的效果
3.改变布局：
  麻烦一点，没有明显的缺点，适用于有交互的view
  
  
  

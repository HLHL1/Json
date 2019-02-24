Json解析器
## 项目简介
  用Java实现Json解析器。
## 功能特性
 -  实现字符串到JSON对象的转换
 - 实现词法解析Lexical类
 -  实现语法解析Grammar类
 -  能够解析 null、true、false、数字(double)、字符串、数组、对象
## 开发技术
   使用Java在IDEA中编写，Maven工具管理
## 实现过程
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190224200329237.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0hMX0hMSEw=,size_16,color_FFFFFF,t_70)
## 测试结果
语法解析测试用例：

```
"\"Hello\" ",
              " 0 ",
              "-0  ",
              "-0.0 ",
              "1    ",
              "-1 ",
              "1.5 ",
              "-1.5 ",
              "3.1416   ",
              "1E10 ",
              "1e10 ",
              "1E+10 ",
              "1E-10 ",
              "-1E10 ",
              "-1e10 ",
              "-1E+10 ",
              "-1E-10 ",
              "1.234E+10 ",
              "1.234E-10 ",
              "1e-10000 ",
              "1.0000000000000002 ",
              "4.9406564584124654e-324 ",
              "-4.9406564584124654e-324 ",
              "2.2250738585072009e-308 ",
              "-2.2250738585072009e-308 ",
              "2.2250738585072014e-308 ",
              "-2.2250738585072014e-308 ",
              "1.7976931348623157e+308 ",
              "-1.7976931348623157e+308 ",
              "\"Hello\\nWorld\"",
              "\"\\\\ \\/ \\b \\f \\n \\r \\t\"",
              "\"Hello\\u0000World\"",
              "\"\\u0024\"",
              "\"\\u00A2\"",
              "\"\\u20AC\"",
              "\"\\uD834\\uDD1E\"",
              "\"\\ud834\\udd1e\"",
              "[ ]",
              "[ null , false , true , 123 , \"abc\" ]",
              "[ [ ] , [ 0 ] , [ 0 , 1 ] , [ 0 , 1 , 2 ] ]",
              " { } ",
              "{\"key1\":\"value1\",\"key2\":\"value2\",\"key3\":\"value3\",\"key4\":[{\"a1\":\"1\",\"a2\":\"2\",\"a3\":\"3\",\"subChildA\":[{\"suba1\":\"3040\",\"suba2\":\"brebb\",\"suba3\":\"fbre\"},{\"suba1\":\"erbrrt\",\"suba2\":\"be4\",\"suba3\":\"5yh5\"},{\"suba1\":\"g445h\",\"suba2\":\"43th\",\"suba3\":\"r5yj4\"}],\"subChildB\":{\"suY1\":\"30L40\",\"suY2\":\"bre00bb\",\"suY3\":\"fbFGFre\",\"subChildA\":[{\"suba1\":\"3040\",\"suba2\":\"brebb\",\"suba3\":\"fbre\"},{\"suba1\":\"erbrrt\",\"suba2\":\"be4\",\"suba3\":\"5yh5\"},{\"suba1\":\"g445h\",\"suba2\":\"43th\",\"suba3\":\"r5yj4\"}]}},{\"a1\":\"s\",\"a2\":\"D\",\"a3\":\"F\"},{\"a1\":\"Q\",\"a2\":\"R\",\"a3\":\"T\"}],\"key5\":[{\"b1\":\"11\",\"b2\":\"21\",\"b3\":\"31\"},{\"b1\":\"3er\",\"b2\":\"3gt\",\"b3\":\"y7u\"},{\"b1\":\"H\",\"b2\":\"Y\",\"b3\":\"R\"}],\"key6\":\"uuid\",\"key7\":{\"vx1\":\"HwH\",\"vx2\":\"YrY\",\"vx3\":\"ReR\"}}",
              "nul "
```

语法解析测试结果
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190224200441686.PNG?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0hMX0hMSEw=,size_16,color_FFFFFF,t_70)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190224200455912.PNG?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0hMX0hMSEw=,size_16,color_FFFFFF,t_70)
词法解析测试用例：

```
"{\"key1\":\"value1\",\"key2\":\"value2\",\"key3\":\"value3\"}"
```

词法解析测试结果：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190224200508362.PNG)
## 收获
 - 熟悉了Json数据交换格式
 - 学会了简单将反射运用到代码中，是代码结构清晰简洁
 - 学会了简单的单元测试的编写
 - 提高了代码能力
 
想了解更多[点这里~](https://blog.csdn.net/HL_HLHL/article/details/87484181)

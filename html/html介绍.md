## html文档介绍

### 分为三个部分:登录界面，人事部门操作界面，管理员操作界面

### 1.登录界面
#### 有两个按钮，但是他们的接口是不一样的，一个登录人事部门、一个是登录管理员
控件类型|控件id|控件使用说明
--|:--:|--:
按钮|login|人事部门登录的按按钮
按钮|admin_login|管理员登录的按钮
文本框|username|用户名
文本框|password|密码

### 2.人事部门部分(user文件夹)

#### &nbsp;&nbsp;1)退出系统
#### &nbsp;&nbsp;&nbsp;每一个界面的退出系统id都是一样
控件类型|控件id|控件使用说明
--|:--:|--:
按钮|quit|退出按钮

#### &nbsp;&nbsp;2)添加工程师界面(addengineer.html)
控件类型|控件id|控件使用说明
--|:--:|--:
文本框|id|编号
文本框|name|姓名
radio|sex|性别
select|year|年
select|month|月
select|day|日
select|eduction|学历
文本框|domicile|贯籍
文本框|address|地址
文本框|phone|电话
select|woeking_year|工龄
文本框|salary|工资
按钮|submit|提交信息

#### &nbsp;&nbsp;3)更行工程师资料
#### &nbsp;&nbsp;&nbsp;使用说明:先要在导航栏里查询出工程师的资料，然后赋值到每个控件上，然后再让操作者进行修改，然后再按保存信息给后端
控件类型|控件id|控件使用说明
--|:--:|--:
select|type|查询类型
文本框|keyword|查询工程师的关键字
文本框|id|编号
文本框|name|姓名
radio|sex|性别
select|year|年
select|month|月
select|day|日
select|eduction|学历
文本框|domicile|贯籍
文本框|address|地址
文本框|phone|电话
select|woeking_year|工龄
文本框|salary|工资
按钮|submit|保存信息
按钮|search|搜索信息

#### &nbsp;&nbsp;4)删除工程师资料
#### &nbsp;&nbsp;&nbsp;使用说明:输入好类型和关键字然后点击按钮进行删除
控件类型|控件id|控件使用说明
--|:--:|--:
select|type|类型
文本框|keyword|查询工程师的关键字
按钮|delete|删除按钮

#### &nbsp;&nbsp;5)搜索工程师资料
#### &nbsp;&nbsp;&nbsp;使用说明:都是搜索关键字然后，返回的信息放到表格里
控件类型|控件id|控件使用说明
--|:--:|--:
select|type|类型
文本框|keyword|查询工程师的关键字
按钮|search|搜索按钮
div|content|存放你编辑好的表格代码

#### &nbsp;&nbsp;&nbsp;表格代码：放入div中
```
<table class="table table-hover">
<thead>
  <tr>
    <th>编号</th>
    <th>姓名</th>
    <th>性别</th>
    <th>出生日期</th>
    <th>学历</th>
    <th>贯籍</th>
    <th>地址</th>
    <th>电话</th>
    <th>工龄</th>
    <th>基本工资</th>
  </tr>
</thead>
<tbody>
  <tr>
    <td>编号的value</td>
    ...
    <td>基本工资的value</td>
  </tr>

</tbody>
</table>
```

#### &nbsp;&nbsp;6)排序工程师资料
#### &nbsp;&nbsp;&nbsp;使用说明:选择好关键词就可以开始排序，返回的信息放到表格里
控件类型|控件id|控件使用说明
--|:--:|--:
select|type|类型
select|sequence|升降序
按钮|sort|排序按钮
div|content|存放你编辑好的表格代码

#### &nbsp;&nbsp;&nbsp;表格代码：放入div中
```
<table class="table table-hover">
<thead>
  <tr>
    <th>编号</th>
    <th>姓名</th>
    <th>性别</th>
    <th>出生日期</th>
    <th>学历</th>
    <th>贯籍</th>
    <th>地址</th>
    <th>电话</th>
    <th>工龄</th>
    <th>基本工资</th>
  </tr>
</thead>
<tbody>
  <tr>
    <td>编号的value</td>
    ...
    <td>基本工资的value</td>
  </tr>

</tbody>
</table>
```

#### &nbsp;&nbsp;7)清空工程师资料
控件类型|控件id|控件使用说明
--|:--:|--:
按钮|empty|清空按钮

#### &nbsp;&nbsp;8)列出所有工程师
控件类型|控件id|控件使用说明
--|:--:|--:
div|content|放入表格

```
<table class="table table-hover">
  <thead>
    <tr>
      <th>编号</th>
      <th>姓名</th>
      <th>性别</th>
      <th>出生日期</th>
      <th>学历</th>
      <th>贯籍</th>
      <th>地址</th>
      <th>电话</th>
      <th>工龄</th>
      <th>基本工资</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      ···
    </tr>
  </tbody>
</table>
```

#### &nbsp;&nbsp;8)计算工资公式(公式看总开发文档)
控件类型|控件id|控件使用说明
--|:--:|--:
文本框|base_salary|基本工资
文本框|vaild_day|有效天数
文本框|monthly_benefit|月效益
文本框|working_Ni|工作年限
文本框|monthly_premium|月保险金
文本框|result|显示计算出来的数据
文本框|calculate|点击按钮开始计算

### 3.超级管理员部分

#### &nbsp;&nbsp;1)退出系统
#### &nbsp;&nbsp;&nbsp;每一个界面的退出系统id都是一样
控件类型|控件id|控件使用说明
--|:--:|--:
按钮|quit|退出按钮

#### &nbsp;&nbsp;2)添加用户界面
控件类型|控件id|控件使用说明
--|:--:|--:
文本框|id|编号
文本框|name|姓名
文本框|phone|电话
select|woeking_year|工龄
按钮|submit|提交信息

#### &nbsp;&nbsp;3)删除用户界面
控件类型|控件id|控件使用说明
--|:--:|--:
select|type|类型
文本框|keyword|关键字
按钮|delete|删除信息

#### &nbsp;&nbsp;4)清空用户界面
控件类型|控件id|控件使用说明
--|:--:|--:
按钮|empty|清空信息

#### &nbsp;&nbsp;5)查看所有用户操作界面
#### &nbsp;&nbsp;使用说明:写一个加载函数，向后端请求数据
控件类型|控件id|控件使用说明
--|:--:|--:
div|content|放入表格

```
<table class="table table-hover">
  	<thead>
  		<tr>
  			<th>编号</th>
  			<th>姓名</th>
  			<th>操作</th>
  		</tr>
  	</thead>
  	<tbody>
  		<tr>
  			···
  		</tr>
  	</tbody>
  </table>
```

#### &nbsp;&nbsp;6)更新用户操作界面
#### &nbsp;&nbsp;使用说明:跟人事部门一样
控件类型|控件id|控件使用说明
--|:--:|--:
select|type|类型
文本框|keyword|关键字
文本框|id|编号
文本框|name|姓名
文本框|phone|电话
select|woeking_year|工龄
按钮|search|搜索信息
按钮|submit|保存修改信息

#### &nbsp;nbsp;7)列出所有认识用户
控件类型|控件id|控件使用说明
--|:--:|--:
div|content|放入表格

```
<table class="table table-hover">
  	<thead>
  		<tr>
  			<th>编号</th>
  			<th>姓名</th>
  			<th>性别</th>
        <th>电话</th>
        <th>工龄</th>
  		</tr>
  	</thead>
  	<tbody>
  		<tr>
  			···
  		</tr>
  	</tbody>
  </table>
```

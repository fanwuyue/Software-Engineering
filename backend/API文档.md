## 管理员

### 管理员登录

| Path     | /admin/login |
| -------- | ------------ |
| 请求类型 | GET          |

| 请求参数 | 值类型及含义  |
| -------- | ------------- |
| username | String 用户名 |
| password | String 密码   |

| 返回     | 内容及含义                                   |
| -------- | -------------------------------------------- |
| status   | success 、 failed       登陆成功 、 登录失败 |
| cookie | “XXXX” 长度为17的字符串，用作登陆校验        |



### 验证管理员登录

| Path     | /admin/verifyLogin |
| -------- | ------------------ |
| 请求类型 | GET                |

| 请求参数 | 值类型及含义 |
| -------- | ------------ |
| 无       |              |

| Cookies  | 值类型及含义            |
| -------- | ----------------------- |
| username | String 用户名           |
| token    | String token 登录时获得 |

| 返回   | 内容及含义                         |
| ------ | ---------------------------------- |
| status | success、failed 校验成功、校验失败 |


### 添加人事员工信息

| Path     | /admin/addHr |
| -------- | ------------------ |
| 请求类型 | POST                |

| 请求参数 | 值类型及含义 |
| -------- | ------------ |
| 无       |              |

请求体

```
{
    "name": String, //姓名
    "telephone": String, //电话
    "username": String, //用户名 用于登录
    "password": String, //密码 用于登录
    "sex": String, //性别
    "seniority": Int, //工龄
    "number": String //编号
}
```

| Cookies  | 值类型及含义            |
| -------- | ----------------------- |
| username | String 用户名           |
| token    | String token 登录时获得 |

| 返回   | 内容及含义                         |
| ------ | ---------------------------------- |
| status | success、failed 添加成功、添加失败 |
| reason | 失败时返回，详细值含义看以下内容 |

```
    {
        errorBody: '请求体有误',
        notLogged: '没有登陆或cookie失效',
        numberAlreadyExists: '插入失败(编号已存在)',
        nameAlreadyExists: '插入失败(姓名已存在)'
    }
```

### 修改人事员工信息

| Path     | /admin/updateHr |
| -------- | ------------------ |
| 请求类型 | POST                |

| 请求参数 | 值类型及含义 |
| -------- | ------------ |
| 无       |              |

请求体

```
{
    "uid": Int, //人事人员在数据库中的真实Id，由查询操作得到。
    "name": String, //姓名
    "telephone": String, //电话
    "username": String, //用户名 用于登录
    "password": String, //密码 用于登录
    "sex": String, //性别
    "seniority": Int, //工龄
    "number": String //编号
}
```

| Cookies  | 值类型及含义            |
| -------- | ----------------------- |
| username | String 用户名           |
| token    | String token 登录时获得 |

| 返回   | 内容及含义                         |
| ------ | ---------------------------------- |
| status | success、failed 修改成功、修改失败 |
| reason | 失败时返回，详细值含义看以下内容 |

```
    {
        errorBody: '请求体有误',
        notLogged: '没有登陆或cookie失效',
        updateError: '修改失败'
        numberAlreadyExists: '所填编号已存在'
    }
```

### 查询所有人事人员资料

| Path     | /admin/getHrs |
| -------- | ------------------ |
| 请求类型 | GET                |

| 请求参数 | 值类型及含义 |
| -------- | ------------ |
| 无       |              |

| Cookies  | 值类型及含义            |
| -------- | ----------------------- |
| username | String 用户名           |
| token    | String token 登录时获得 |

| 返回   | 内容及含义                         |
| ------ | ---------------------------------- |
| status | success、failed 校验成功、校验失败 |
| reason | 失败时返回，详细值含义看以下内容 |
| hrs | 成功时返回，详细含义值查看以下内容 |

```
    {
        notLogged: '没有登陆或cookie失效'
    }
```

```
[
        {
            "id": Int, //人事人员在数据库中的真实Id，由查询操作得到。
            "hrName": String, //姓名
            "hrTelephone": String, //电话
            "hrUsername": String, //用户名 用于登录
            "hrPassword": String, //密码 用于登录
            "hrSex": String, //性别
            "hrSeniority": Int, //工龄
            "hrNumber": String, //编号
            "hrToken": 恒为空
        },
        {
            "id": Int, //人事人员在数据库中的真实Id，由查询操作得到。
            "hrName": String, //姓名
            "hrTelephone": String, //电话
            "hrUsername": String, //用户名 用于登录
            "hrPassword": String, //密码 用于登录
            "hrSex": String, //性别
            "hrSeniority": Int, //工龄
            "hrNumber": String, //编号
            "hrToken": 恒为空
        }

]
```

### 查询单个人事人员资料

| Path     | /admin/getHr |
| -------- | ------------------ |
| 请求类型 | GET                |

| 请求参数 | 值类型及含义 |
| -------- | ------------ |
| type       | Int 查询方式 0为编号，1为姓名             |
| key       | String 关键字             |

| Cookies  | 值类型及含义            |
| -------- | ----------------------- |
| username | String 用户名           |
| token    | String token 登录时获得 |

| 返回   | 内容及含义                         |
| ------ | ---------------------------------- |
| status | success、failed 校验成功、校验失败 |
| hr | 成功时返回，详细含义值查看以下内容 |
| reason | 失败时返回，详细含义值查看以下内容 |

```
    {
        notLogged: '没有登陆或cookie失效',
        noSuchHr: '没有此用户'
    }
```

```
    {
        "id": Int, //人事人员在数据库中的真实Id
        "hrName": String, //姓名
        "hrTelephone": String, //电话
        "hrUsername": String, //用户名 用于登录
        "hrPassword": String, //密码 用于登录
        "hrSex": String, //性别
        "hrSeniority": Int, //工龄
        "hrNumber": String, //编号
        "hrToken": 恒为空
    }
```

### 删除单个人事人员资料

| Path     | /admin/deleteHr |
| -------- | ------------------ |
| 请求类型 | GET                |

| 请求参数 | 值类型及含义 |
| -------- | ------------ |
| type       | Int 查询方式 0为编号，1为姓名             |
| key       | String 关键字             |

| Cookies  | 值类型及含义            |
| -------- | ----------------------- |
| username | String 用户名           |
| token    | String token 登录时获得 |

| 返回   | 内容及含义                         |
| ------ | ---------------------------------- |
| status | success、failed 校验成功、校验失败 |
| reason | 失败时返回，详细含义值查看以下内容 |

```
    {
        notLogged: '没有登陆或cookie失效',
        deleteError: '删除失败'，
        noSuchHr: '没有此用户'，
    }
```

### 删除所有人事员工资料

| Path     | /admin/deleteAll |
| -------- | ------------------ |
| 请求类型 | GET                |

| 请求参数 | 值类型及含义 |
| -------- | ------------ |
| 无       |             |

| Cookies  | 值类型及含义            |
| -------- | ----------------------- |
| username | String 用户名           |
| token    | String token 登录时获得 |

| 返回   | 内容及含义                         |
| ------ | ---------------------------------- |
| status | success、failed 校验成功、校验失败 |
| reason | 失败时返回，详细含义值查看以下内容 |

```
    {
        notLogged: '没有登陆或cookie失效',
        deleteError: '删除失败'
    }
```

### 查询操作记录

| Path     | /admin/getLogs |
| -------- | ------------------ |
| 请求类型 | GET                |

| 请求参数 | 值类型及含义 |
| -------- | ------------ |
| 无       |              |

| Cookies  | 值类型及含义            |
| -------- | ----------------------- |
| username | String 用户名           |
| token    | String token 登录时获得 |

| 返回   | 内容及含义                         |
| ------ | ---------------------------------- |
| status | success、failed 校验成功、校验失败 |
| reason | 失败时返回，详细值含义看以下内容 |
| logs | 成功时返回，详细含义值查看以下内容 |

```
    {
        notLogged: '没有登陆或cookie失效'
    }
```

```
[
        {
            "id": Int, //人事人员在数据库中的真实Id，由查询操作得到。
            "hrName": String, //姓名
            "hrNumber": String, //编号
            "message": String //操作信息
        },
        {
            "id": Int, //人事人员在数据库中的真实Id，由查询操作得到。
            "hrName": String, //姓名
            "hrNumber": String, //编号
            "message": String //操作信息
        }

]
```


## 人事部门

### 人事人员登录

| Path     | /hr/login |
| -------- | --------- |
| 请求类型 | GET       |

| 请求参数 | 值类型及含义  |
| -------- | ------------- |
| username | String 用户名 |
| password | String 密码   |

| 返回   | 内容及含义                                   |
| ------ | -------------------------------------------- |
| status | success 、 failed       登陆成功 、 登录失败 |
| token  | “XXXX” 长度为17的字符串，用作登陆校验        |



### 验证人事人员登录

| Path     | /hr/verifyLogin |
| -------- | --------------- |
| 请求类型 | GET             |

| 请求参数 | 值类型及含义 |
| -------- | ------------ |
| 无       |              |

| Cookies  | 值类型及含义            |
| -------- | ----------------------- |
| username | String 用户名           |
| token    | String token 登录时获得 |

| 返回   | 内容及含义                         |
| ------ | ---------------------------------- |
| status | success、failed 校验成功、校验失败 |

### 添加员工信息

| Path     | /hr/addWorker |
| -------- | ------------------ |
| 请求类型 | POST                |

| 请求参数 | 值类型及含义 |
| -------- | ------------ |
| 无       |              |

请求体

```
{
	"name": String, //姓名
	"address": String, //地址
	"birthDate": String, //出生日期 例 "1970-01-01"
	"number": String, // 四位 编号
	"baseSalary": Int, //基本工资
	"hometown": String, //籍贯
	"seniority": Int, //工龄
	"sex": String, //性别 男、女
	"telephone": String, //电话号码只接受数字和'-'
	"edu": Int, //0 - 3 学历
}
```

| Cookies  | 值类型及含义            |
| -------- | ----------------------- |
| username | String 用户名           |
| token    | String token 登录时获得 |

| 返回   | 内容及含义                         |
| ------ | ---------------------------------- |
| status | success、failed 添加成功、添加失败 |
| reason | 失败时返回，详细值含义看以下内容 |

```
    {
        errorBody: '请求体有误',
        notLogged: '没有登陆或cookie失效',
        insertError: '插入失败(编号已存在)'
    }
```

### 修改员工信息

| Path     | /hr/updateWorker |
| -------- | ------------------ |
| 请求类型 | POST                |

| 请求参数 | 值类型及含义 |
| -------- | ------------ |
| 无       |              |

请求体

```
{
    "uid": Int, //人事人员在数据库中的真实Id，由查询操作得到。
	"name": String, //姓名
	"address": String, //地址
	"birthDate": String, //出生日期 例 "1970-01-01"
	"number": String, // 四位 编号
	"baseSalary": Int, //基本工资
	"hometown": String, //籍贯
	"seniority": Int, //工龄
	"sex": String, //性别 男、女
	"telephone": String, //电话号码只接受数字和'-'
	"edu": Int, //0 - 3 学历
}
```

| Cookies  | 值类型及含义            |
| -------- | ----------------------- |
| username | String 用户名           |
| token    | String token 登录时获得 |

| 返回   | 内容及含义                         |
| ------ | ---------------------------------- |
| status | success、failed 修改成功、修改失败 |
| reason | 失败时返回，详细值含义看以下内容 |

```
    {
        errorBody: '请求体有误',
        notLogged: '没有登陆或cookie失效',
        updateError: '修改失败'
        numberAlreadyExists: '所填编号已存在'
    }
```

### 查询所有员工资料

| Path     | /hr/getWorkers |
| -------- | ------------------ |
| 请求类型 | GET                |

| 请求参数 | 值类型及含义 |
| -------- | ------------ |
| 无       |              |

| Cookies  | 值类型及含义            |
| -------- | ----------------------- |
| username | String 用户名           |
| token    | String token 登录时获得 |

| 返回   | 内容及含义                         |
| ------ | ---------------------------------- |
| status | success、failed 校验成功、校验失败 |
| reason | 失败时返回，详细值含义看以下内容 |
| hrs | 成功时返回，详细含义值查看以下内容 |

```
    {
        notLogged: '没有登陆或cookie失效'
    }
```

```
[
        {
            "id": Int, //数据库内真实编号
            "name": String, //姓名
            "address": String, //地址
            "birthDate": Int, // 以毫秒为单位的时间戳
            "number": String, // 四位 编号
            "baseSalary": Int, //基本工资
            "hometown": String, //籍贯
            "seniority": Int, //工龄
            "sex": String, //性别 男、女
            "telephone": String, //电话号码只接受数字和'-'
            "edu": Int, //0 - 3 学历
        },
        {
            "id": Int, //数据库内真实编号
            "name": String, //姓名
            "address": String, //地址
            "birthDate": Int, // 以毫秒为单位的时间戳
            "number": String, // 四位 编号
            "baseSalary": Int, //基本工资
            "hometown": String, //籍贯
            "seniority": Int, //工龄
            "sex": String, //性别 男、女
            "telephone": String, //电话号码只接受数字和'-'
            "edu": Int, //0 - 3 学历
        }

]
```

### 查询单个员工资料

| Path     | /hr/getWorker |
| -------- | ------------------ |
| 请求类型 | GET                |

| 请求参数 | 值类型及含义 |
| -------- | ------------ |
| type       | Int 查询方式 0为编号，1为姓名             |
| key       | String 关键字             |

| Cookies  | 值类型及含义            |
| -------- | ----------------------- |
| username | String 用户名           |
| token    | String token 登录时获得 |

| 返回   | 内容及含义                         |
| ------ | ---------------------------------- |
| status | success、failed 校验成功、校验失败 |
| hr | 成功时返回，详细含义值查看以下内容 |
| reason | 失败时返回，详细含义值查看以下内容 |

```
    {
        notLogged: '没有登陆或cookie失效',
        noSuchHr: '没有此用户'
    }
```

```
    {
        "id": Int, //数据库内真实编号
        "name": String, //姓名
        "address": String, //地址
        "birthDate": Int, // 以毫秒为单位的时间戳
        "number": String, // 四位 编号
        "baseSalary": Int, //基本工资
        "hometown": String, //籍贯
        "seniority": Int, //工龄
        "sex": String, //性别 男、女
        "telephone": String, //电话号码只接受数字和'-'
        "edu": Int, //0 - 3 学历
    }
```

### 删除单个员工资料

| Path     | /hr/deleteWorker |
| -------- | ------------------ |
| 请求类型 | GET                |

| 请求参数 | 值类型及含义 |
| -------- | ------------ |
| type       | Int 查询方式 0为编号，1为姓名             |
| key       | String 关键字             |

| Cookies  | 值类型及含义            |
| -------- | ----------------------- |
| username | String 用户名           |
| token    | String token 登录时获得 |

| 返回   | 内容及含义                         |
| ------ | ---------------------------------- |
| status | success、failed 校验成功、校验失败 |
| reason | 失败时返回，详细含义值查看以下内容 |

```
    {
        notLogged: '没有登陆或cookie失效',
        deleteError: '删除失败'，
        noSuchHr: '没有此用户'，
    }
```

### 删除所有员工资料

| Path     | /hr/deleteAll |
| -------- | ------------------ |
| 请求类型 | GET                |

| 请求参数 | 值类型及含义 |
| -------- | ------------ |
| 无       |             |

| Cookies  | 值类型及含义            |
| -------- | ----------------------- |
| username | String 用户名           |
| token    | String token 登录时获得 |

| 返回   | 内容及含义                         |
| ------ | ---------------------------------- |
| status | success、failed 校验成功、校验失败 |
| reason | 失败时返回，详细含义值查看以下内容 |

```
    {
        notLogged: '没有登陆或cookie失效',
        deleteError: '删除失败'
    }
```
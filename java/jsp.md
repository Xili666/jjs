# JSP #

1. 四大作用域
    1. application      ServletContext
    2. session          HttpSession
    3. request          HttpServletRequest
    4. page             pageContext

2. 9大内置对象
    1. request          HttpServletRequest
    2. response         HttpServletResponse
    3. config           ServletConfig
    4. application      ServletContext
    5. session          HttpSession
    6. exception        Throwable
    7. page             Object(this)
    8. out              JspWriter
    9. pageContext      PageContext

3. 常见jstl包
    1. c    core        核心
    2. fmt  fmt         格式化
    3. sql  sql         与数据库交互
    4. x    xml         创建和操作xml文档
    5. fn   functions   字符串处理
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

4. 只有当该页面是`isErroePage = true`时, 才能使用`exception`
5. JSP指令:
    1. `<%@ page ... %>`, 定义网页依赖属性，比如脚本语言、error页面、缓存需求等等
    2. `<%@ include ... %>`, 包含其它文件
    3. `<%@ taglib ... %>`, 引入标签库定义
6. JSP动作:(动作元素只有一种语法, 符合xml规范)
    | 语法            | 描述                                            |
    | :-------------- | :---------------------------------------------- |
    | jsp:include     | 在页面被请求的时候引入一个文件。                |
    | jsp:useBean     | 寻找或者实例化一个JavaBean。                    |
    | jsp:setProperty | 设置JavaBean的属性。                            |
    | jsp:getProperty | 输出某个JavaBean的属性。                        |
    | jsp:forward     | 把请求转到一个新的页面。                        |
    | jsp:plugin      | 根据浏览器类型为Java插件生成OBJECT或EMBED标记。 |
    | jsp:element     | 定义动态XML元素                                 |
    | jsp:attribute   | 设置动态定义的XML元素属性。                     |
    | jsp:body        | 设置动态定义的XML元素内容。                     |
    | jsp:text        | 在JSP页面和文档中使用写入文本的模板             |
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改书籍</title>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="containern">

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>修改书籍</small>
                </h1>
            </div>
        </div>
    </div>
    <%--这是bootstrap给的forms格式--%>
    <%--    将提交表单关联上updatebook方法完成数据库的修改--%>
    <form action="${pageContext.request.contextPath}/book/updatebook" method="post">
        <%--    但是这里有一个问题，本来想着bookid是主键自增的不能修改，所以只写了三个属性，
但是sql语句中是要根据id去修改数据的，而这里我们定义了三个字段，所以根本无法查到修改，需要给前端添加id隐藏域--%>
        <input type="hidden" name="bookID" value="${qbook.bookID}">
        <div class="form-group">
            <label>书籍名称</label>
            <%--            这里面的name属性必须和实体类中的名字一样,required属性表示该项必须填写才能提交--%>
            <input type="text" name="bookName" class="form-control" value="${qbook.bookName}" required>
        </div>
        <div class="form-group">
            <label>书籍数量</label>
            <input type="text" name="bookCounts" class="form-control" value="${qbook.bookCounts}" required>
        </div>
        <div class="form-group">
            <label>书籍描述</label>
            <input type="text" name="detail" class="form-control" value="${qbook.detail}" required>
        </div>
        <div class="form-group">
            <input type="submit" class="form-control" value="修改">
        </div>
    </form>

</div>
</body>
</html>

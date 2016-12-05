<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.1.0.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SayHello</title>
<script type="text/javascript">
$(function() {
    $("#say").bind("click", function(e) {
        var myUrl = "<%=request.getContextPath()%>/say.do?name=" + $('#name').val();
        
        $.ajax({
            type: 'get',
            url: myUrl,
            dataType: 'json',
            success: function(data, result) {
                alert(data.result);
            },
            error: function() {
                alert('error');
            }
        });
    });
});
</script>
</head>
<body>

<form id="helloForm" name="helloForm" method="post">
    Name: <input type="text" id="name" name="name" />&nbsp;
    <input type="button" id="say" name="say" value="哈囉"/>
</form>

</body>
</html>
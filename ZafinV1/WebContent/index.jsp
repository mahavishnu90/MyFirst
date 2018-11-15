<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Zafin Case Study</title>
<link href="css/styles.css" rel="stylesheet" type="text/css">
<script src="<%=request.getContextPath()%>/Javascripts/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/Javascripts/Validations/validation.js"></script>
</head>

<body >
	<jsp:include page="/LoginLeft.jsp"></jsp:include>
	
	<div id="central_column" align="center">
		<form method="post" action="GetServlet.do" >
   <tr><td>Please Enter the Words:</td></tr>	
			<table align="center"
				style="font-family: Gill, Helvetica, sans-serif;">
				<tr>
					<td height="20px"></td>
				</tr>
								
			<div class="multi-field-wrapper">
			      <div class="multi-fields">
			        <div class="multi-field">
			     
			          <input type="text" style="text-transform:uppercase" id="inputValueID"  name="inputList">
			             <img align="top" style="cursor: pointer;" width="30px" height="30px"  src="images/remove.png" class="remove-field">
			        </div>
			      </div>
			      <div >
			       <img  width="35px" style="cursor: pointer;" height="30px" class="add-field" src="images/add.ico"  >
			      </div>
			     </div>
				<tr><td>
				<input type="submit" id="gobutton" align="center" onclick="return validateForm()"     value="Get Words" ></td></tr>
			</table>

		</form>

	</div>
<script type="text/javascript">
$('.multi-field-wrapper').each(function() {
    var $wrapper = $('.multi-fields', this);
    $(".add-field", $(this)).click(function(e) {
        $('.multi-field:first-child', $wrapper).clone(true).appendTo($wrapper).find('input').val('').focus();
    });
    $('.multi-field .remove-field', $wrapper).click(function() {
        if ($('.multi-field', $wrapper).length > 1)
            $(this).parent('.multi-field').remove();
    });
});

</script>
</body>

</html>

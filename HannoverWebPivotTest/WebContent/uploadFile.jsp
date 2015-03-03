<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hannover-Re</title>
</head>
<body>
<script>
function fnUpload(){
	var filePath = document.getElementById("excelFilePath").value.toUpperCase();	
	//if((filePath.length - filePath.indexOf(".XLS"))==4 ){		
		window.document.uploadFileForm.action = '/uploadFileMotor.do?method=uploadExcel';
		window.document.uploadFileForm.submit();
	//}
	//else{
		//alert("Only Micorsoft Excel file can be uploaded");
		//return;
	//}
}

function openReport()
{
	var src ="/birt/frameset?__report=hannoverReport.rptdesign";
	window.open(src,'MyWindow','scrollbars=no,menubar=no,height=600,width=800,resizable=yes,toolbar=no,location=no,status=no');
}
</script>
<html:form action="/uploadFileMotor" enctype="multipart/form-data">
<html:file property="excelFilePath" styleId ="excelFilePath"/>
<input type="button"  value="Upload" onClick="javascript:fnUpload()">
<input type="button"  value="Show Report" onClick="javascript:openReport()">
</html:form>
</body>
</html>
<!DOCTYPE html>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>Pivot Demo From Local CSV</title>
<link rel="stylesheet" type="text/css" href="css/pivot.css">
<script type="text/javascript" src="js/d3.js"></script>
<script type="text/javascript" src="js/jsapi"></script>
<script type="text/javascript" src="js/jquery-1.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.js"></script>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/pivot.js"></script>
<script type="text/javascript" src="js/gchart_renderers.js"></script>
<script type="text/javascript" src="js/d3_renderers.js"></script>
<style>
* {
	font-family: Verdana;
}

.node {
	border: solid 1px white;
	font: 10px sans-serif;
	line-height: 12px;
	overflow: hidden;
	position: absolute;
	text-indent: 2px;
}
</style>
<link type="text/css" rel="stylesheet" href="css/orgchart.css">
<link type="text/css" rel="stylesheet" href="css/annotatedtimeline.css">
<link type="text/css" rel="stylesheet" href="css/imagesparkline.css">
</head>
<body>
	<script type="text/javascript">
		google.load("visualization", "1", {
			packages : [ "corechart", "charteditor" ]
		});
</script>
	<script src="js/a" type="text/javascript"></script>
<html:form action="/uploadFile" enctype="multipart/form-data">

	<p>
		<html:hidden styleId="outputStream" property="outputStream"></html:hidden>
	</p>
	<div id="output" style="margin: 10px;">

	</div>


</html:form>
</body>
<script>
function showPivot(){
try {
	alert(document.getElementById("outputStream").value);
	var input = $.csv.toArrays(document.getElementById("outputStream").value);
	
} catch (e) {
	alert("CSV Parse error.");
	return;
}
$("#output")
		.pivotUI(
				input,
				{
					renderers : $
							.extend(
									$.pivotUtilities.renderers,
									$.pivotUtilities.gchart_renderers,
									$.pivotUtilities.d3_renderers)
				});
}
showPivot();
	</script>
</html>
<!DOCTYPE HTML>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<html>
<head>
    <title>Hannover - re Pivot Utility</title>

    <link href="http://fonts.googleapis.com/css?family=Open+Sans:400,700,600" rel="stylesheet" type="text/css">
    <link href="http://netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="css/app.css" rel="stylesheet" type="text/css">
    <script src="js/jquery.blockUI.js"></script>
	<script src="js/chili-1.8b.js"></script>
</head>


<script>
$(document).ready(function() { 
    $('#demo2').click(function() { 
        $.blockUI({ css: { 
            border: 'none', 
            padding: '15px', 
            backgroundColor: '#000', 
            '-webkit-border-radius': '10px', 
            '-moz-border-radius': '10px', 
            opacity: .5, 
            color: '#fff' 
        } }); 
        //setTimeout($.unblockUI, 2000); 
    }); 
}); 
function saveAsTrend(currentRows, currentCols){
	window.document.uploadFileForm.action = '/uploadFile.do?method=saveAsTrend&currentRows='+currentRows+"&currentCols="+currentCols;
	window.document.uploadFileForm.submit();
}
</script>
<body>
	<div style="color: black;border: 1px;border-color: black; border-style: solid;padding-left: 20px;"><img src="graphics/hannover_re.png;"/>
</div>
<div id="contentWrapper">

 <jsp:include page="leftMenu.jsp"></jsp:include>
 
    <html:hidden name="uploadFileForm" property="outputStream" styleId="outputStream"/>
    <input type="hidden" name="aiCols" id = "aiCols" value='<bean:write name="uploadFileForm" property="aiColsList" filter="false"/>'/>
    <jsp:include page="hannoverPivotAI.html"></jsp:include>
</div>
</body>
</html>



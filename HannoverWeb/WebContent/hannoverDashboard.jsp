<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<html>
<head>
    <title>Hannover-re Dashboard</title>
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:400,700,600" rel="stylesheet" type="text/css">
    <link href="http://netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="css/app.css" rel="stylesheet" type="text/css">
</head>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script src="js/jquery.blockUI.js"></script>
	<script src="js/chili-1.8b.js"></script>
<script>
function fnUpload(){

	window.document.uploadFileForm.action = '/uploadFile.do?method=uploadExcel';
	window.document.uploadFileForm.submit();

}
</script>
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
</script>
<body>
<html:form action="/uploadFile" enctype="multipart/form-data">
<div style="color: black;border: 1px;border-color: black; border-style: solid;padding-left: 260px;"><img src="graphics/hannover_re.png;"/> </div>
<div id="contentWrapper">

    <div id="contentLeft">

        <ul id="leftNavigation">
            <li class="active">
                <a href="/uploadFile.do?method=init"><i class="fa fa-flask leftNavIcon"></i> Upload File</a>
            </li>
            
             <li>
                <a href="/uploadFile.do?method=showReport"><i class="fa fa-flask leftNavIcon"></i>Dashboard</a>
            </li>
            <li>
                <a href="/uploadFile.do?method=showTable"><i class="fa fa-flask leftNavIcon"></i>Anomalies</a>
            </li>
            <li>
                <a href="/uploadFile.do?method=showTrigger"><i class="fa fa-flask leftNavIcon"></i> Trigger 1</a>
            </li>
            <li>
                <a href="/uploadFile.do?method=showTrigger"><i class="fa fa-flask leftNavIcon"></i> Trigger 2</a>
            </li>
            <li>
                <a href="#"><i class="fa fa-flask leftNavIcon"></i> About us</a>
            </li>
            <li>
                <a href="#"><i class="fa fa-flask leftNavIcon"></i> Contact us</a>
            </li>
            </br></br>
            <li>
                <a href="/uploadFile.do?method=showTriggerPivot"><i class="fa fa-flask leftNavIcon"></i> Pivot Utility</a>
            </li>
        </ul>

    </div>

    <div id="contentRight">
        <p>
        Select State&nbsp;&nbsp;<html:select property="state">
        	<html:option value="Select">Select..</html:option>
            <html:option value="Haryana">Haryana</html:option>
            <html:option value="Delhi">Delhi</html:option>
            <html:option value="Uttar Pradesh">Uttar Pradesh</html:option>
            <html:option value="Others">Others</html:option>
        </html:select><br/>
         Select Year&nbsp;&nbsp;<html:select property="year">
        	<html:option value="Select">Select..</html:option>
            <html:option value="2014">2014</html:option>
            <html:option value="2015">2015</html:option>
        </html:select><br/>
         Select Month&nbsp;&nbsp;<html:select property="month">
        	<html:option value="Select">Select..</html:option>
            <html:option value="January">January</html:option>
            <html:option value="February">February</html:option>
            <html:option value="March">March</html:option>
            <html:option value="April">April</html:option>
            <html:option value="May">May</html:option>
            <html:option value="June">June</html:option>
            <html:option value="July">July</html:option>
            <html:option value="August">August</html:option>
            <html:option value="September">September</html:option>
            <html:option value="October">October</html:option>
            <html:option value="November">November</html:option>
            <html:option value="December">December</html:option>
        </html:select><br/>
        
        Enter Description&nbsp;&nbsp;<html:text property="description"></html:text><br/>
        Please upload a file <br/>
        <html:file property="excelFilePath" styleId ="excelFilePath"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" id="demo2"  value="Upload" onClick="javascript:fnUpload()"></p>
    </div>

</div>

</html:form>
</body>
</html>
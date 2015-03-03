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

<div style="color: black;border: 1px;border-color: black; border-style: solid;padding-left: 260px;"><img src="graphics/hannover_re.png;"/> </div>
<div id="contentWrapper">

   <jsp:include page="leftMenu.jsp"></jsp:include>

    <div id="contentRight">

    </div>

</div>

</body>
</html>
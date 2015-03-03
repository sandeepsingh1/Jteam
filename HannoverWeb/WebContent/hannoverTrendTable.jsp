<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<HTML xml:lang="en-us" xmlns="http://www.w3.org/1999/xhtml">
<HEAD><META content="IE=11.0000" http-equiv="X-UA-Compatible">
	 <TITLE>Trend Table (Hannover-re)</TITLE>	 
<META http-equiv="Content-Type" content="text/html; charset=windows-1252"><LINK href="css/jq.css" rel="stylesheet" type="text/css" media="print, projection, screen">	 
<LINK href="css/styleTable.css" rel="stylesheet" type="text/css" media="print, projection, screen">	 
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<SCRIPT src="js/__jquery.tablesorter.js" type="text/javascript"></SCRIPT>
<SCRIPT src="js/jquery.tablesorter.pager.js" type="text/javascript"></SCRIPT>
<SCRIPT src="js/chili-1.8b.js" type="text/javascript"></SCRIPT>
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:400,700,600" rel="stylesheet" type="text/css">
    <link href="http://netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="css/app.css" rel="stylesheet" type="text/css">
<SCRIPT id="js" type="text/javascript">$(document).ready(function() {
	
	// call the tablesorter plugin
	$("table").tablesorter({
		// define a custom text extraction function
		textExtraction: function(node) {
			// extract data from markup and return it 
			return node.childNodes[0].childNodes[0].innerHTML;
		}
	});
}); </SCRIPT>
 
</HEAD> 
<BODY>
<html:form action="/uploadFile" >
<div style="color: black;border: 1px;border-color: black; border-style: solid;padding-left: 260px;"><img src="graphics/hannover_re.png;"/> </div>
<div id="contentWrapper">

 <jsp:include page="leftMenu.jsp"></jsp:include>

<div id="contentRight">
</div>

</div>

<DIV id="main" style="padding-left: 260px;">
	<H1>Trends Failure Report. <bean:write name="uploadFileForm" property="month"/>, <bean:write name="uploadFileForm" property="year"/>.  <bean:write name="uploadFileForm" property="state"/> </H1>
	<DIV id="demo">
		<TABLE class="tablesorter" cellspacing="1">
		  <THEAD>
		  <TR>
		  <TH> </TH>
		    <TH>Trend</TH>
		    <TH>Patient Name</TH>
		    <TH>URN</TH>
		    <TH>Age</TH>
		    <TH>Gender</TH>
		    <TH>Disease</TH>
		    <TH>Hospital</TH>
		    <TH>Stay Duration</TH>
		    <TH>Failure Reason</TH>
		    <TH>Admission Date</TH>
		    <TH>Admission Time</TH>
		    </TR></THEAD>
		  <TBODY>
		  <logic:iterate name="uploadFileForm" property="pcdList" id="pcdList">
		  <TR>
		    <TD><img src="flag.jpg" height="25px" width="25px" /></TD>
		    <TD><STRONG><EM><bean:write name="pcdList" property="trendName"/></EM></STRONG></TD>
		    <TD><STRONG><EM><bean:write name="pcdList" property="patientName"/></EM></STRONG></TD>
		    <TD><STRONG><EM><bean:write name="pcdList" property="urn"/></EM></STRONG></TD>
		    <TD><STRONG><EM><bean:write name="pcdList" property="patientAge"/></EM></STRONG></TD>
		    <TD><STRONG><EM><bean:write name="pcdList" property="gender"/></EM></STRONG></TD>
		    <TD><STRONG><EM><bean:write name="pcdList" property="diseaseName"/></EM></STRONG></TD>
		    <TD><STRONG><EM><bean:write name="pcdList" property="hospitalName"/></EM></STRONG></TD>
		    <TD><STRONG><EM><bean:write name="pcdList" property="numberOfDays"/> days</EM></STRONG></TD>
		    <TD><STRONG><EM><bean:write name="pcdList" property="ruleRemarks"/></EM></STRONG></TD>
		    <TD><STRONG><EM><bean:write name="pcdList" property="admissionDate"/></EM></STRONG></TD>
		    <TD><STRONG><EM><bean:write name="pcdList" property="admissionTime"/></EM></STRONG></TD>
		  </TR>
		  </logic:iterate>
		  </TBODY>
		</TABLE>
	</DIV>
</DIV>
</html:form>
</BODY>
</HTML>

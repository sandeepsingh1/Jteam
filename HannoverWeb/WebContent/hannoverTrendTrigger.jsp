<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<HTML xml:lang="en-us" xmlns="http://www.w3.org/1999/xhtml">
<HEAD>
<META content="IE=11.0000" http-equiv="X-UA-Compatible">
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
    <link href="css/hannoverTrendTrigger.css" rel="stylesheet" type="text/css">
    
    
    <!-- Data Tables CSS & JS-->

<link href="css/jquery.dataTables.min.css" rel="stylesheet" type="text/css">
<SCRIPT src="js/jquery.dataTables.min.js" type="text/javascript"></SCRIPT>
<SCRIPT src="js/dataTables.scroller.min.js" type="text/javascript"></SCRIPT>    


<style type="text/css">
        #wpt-container {width:100%;height:400px;}
</style>

    <link rel='stylesheet' href='WebPivot/public/brightsea/wpt/wpt.css'>

</head>

 
</HEAD> 
<BODY>
<html:form action="/uploadFile" >

<div id="contentWrapper">
	 	<jsp:include page="leftMenu.jsp"></jsp:include>
</div>

	
		<div id="contentRight">
		    <span>Select trigger</span><div id="selectTriggerFilter"></div>
	    </div>
	
	<div class="claro" style="font-size:11px;margin-left:250px; margin-top:20px; width:82%; height:420px; overflow-y: scroll;">
		<div id="wpt-container"></div>
	</div>
	
	<DIV id="demo" style="margin-left:250px;">
		<TABLE class="tablesorter" cellspacing="1" id="tableTrigger">
		  <THEAD>
		  <TR>
			    <TH>Trend</TH>
			    <TH>Patient Name</TH>
			    <TH>URN</TH>
			    <TH>Age</TH>
			    <TH>Gender</TH>
			    <TH>Disease</TH>
			    <TH>Hospital</TH>
			    <TH>Stay Duration</TH>
			    <TH>Failure Reason</TH>
			    <TH>Date</TH>
			    <TH>Time</TH>
		  </TR>
		  </THEAD>
		  <TBODY>
		  <logic:iterate name="uploadFileForm" property="pcdList" id="pcdList">
		  <TR>
		    <TD><bean:write name="pcdList" property="trendName"/></TD>
		    <TD><bean:write name="pcdList" property="patientName"/></TD>
		    <TD><bean:write name="pcdList" property="urn"/></TD>
		    <TD><bean:write name="pcdList" property="patientAge"/></TD>
		    <TD><bean:write name="pcdList" property="gender"/></TD>
		    <TD><bean:write name="pcdList" property="diseaseName"/></TD>
		    <TD><bean:write name="pcdList" property="hospitalName"/></TD>
		    <TD><bean:write name="pcdList" property="numberOfDays"/> days</TD>
		    <TD><bean:write name="pcdList" property="ruleRemarks"/></TD>
		    <TD><bean:write name="pcdList" property="admissionDate"/></TD>
		    <TD><bean:write name="pcdList" property="admissionTime"/></TD>
		  </TR>
		  </logic:iterate>
		  </TBODY>
		</TABLE>
	</DIV>



</html:form>

<!-- <script type="text/javascript">
$(document).ready(function() {
     $('#tableTrigger').DataTable({
        
    "lengthMenu": [ [10, 25, 50, 100, -1], [10, 25, 50, 100, "All"] ],
    searching: false,
    "scrollY": "200px",
    "dom": 'frtipS',
    "deferRender": true,
    
    initComplete: function () 
    {
        var api = this.api();

        api.columns().indexes().flatten().each( function ( i ) 
        		{
				        	if(i == 0){ //Create just one SelectBox
				                var select = $('<select class='+i+'><option value=""></option></select>')
				                    		.appendTo( '#selectTriggerFilter')
				                    		.on( 'change', function () {
				
				                        var val = $(this).val();
				                        column( i ).search( val ? '^'+$(this).val()+'$' : val, true, false ).draw();
				                    });
				
				                column( i ).data().unique().sort().each( function ( d, j ) {
				                    select.append( '<option value="'+d+'">'+d+'</option>' );
				                } );
				        }
				        	else return;
        	   });
    } 
       
  }); 
});

</script> -->


<script type="text/javascript">
$(document).ready(function() {

    var table = $('#tableTrigger').DataTable({
    		"lengthMenu": [ [10, 25, 50, 100, -1], [10, 25, 50, 100, "All"] ],
    	    searching: false,
    	    "scrollY": "120px",
    	    "dom": 'frtpS',
    	    "deferRender": true
    });

    $("#tableTrigger thead th").each( function ( i ) {

    if(i == 0){ //Create just one SelectBox
            var select = $('<select class='+i+'><option value=""></option></select>')
                .appendTo('#selectTriggerFilter')
                .on( 'change', function () {

                    var val = $(this).val();

                    table.column( 0 ) //Only the first column
                         .search( val ? '^'+$(this).val()+'$' : val, true, false )
                         .draw();
                });

            	table.column( 0 ).data().unique().sort().each( function ( d, j ) {
                select.append( '<option value="'+d+'">'+d+'</option>' );
            });
    }
    
    else return;
});
});
</script>




    <script type="text/javascript" src="WebPivot/public/brightsea/wpt/wpt.js"  data-dojo-config="async:1, baseUrl: 'WebPivot/public/brightsea/dojo/'"></script>
    <!-- <script type="text/javascript" src="WebPivot/public/jquery/jquery-1.11.0.min.js"></script> -->
    <script type="text/javascript" src="WebPivot/public/highcharts/4.0.1/highcharts-all.js"></script>
    <script type="text/javascript" src="WebPivot/public/highcharts/group_categories/grouped-categories.js"></script>

    <script type="text/javascript">
        require(["wpt/WebPivotTable","dojo/domReady!"], function(WebPivotTable){
            new WebPivotTable({
                customOptions:{

                    uiFlags: {
                        helpBtn: 0,
                        aboutBtn: 0,
                        languageSwitchBtn: 0, 
                        openWptMenu: 0,
                        saveWptMenu: 0,
                        sourceDataMenu: 1,
                        exportReportMenu: 1,
                        settingMenu: 1,
                        leavePageWarning: 0,
                        csvFileMenu: 1,
                        xlsFileMenu: 1,
                        xlsxFileMenu: 1,
                        gssFileMenu: 0,
                        olapCubeMenu: 0,

                        internetLinkMenu: 0,
                        localDriveMenu: 1,
                        cloudDriveMenu: 0,
                        copyPasteMenu: 1
                    }
                }
            },"wpt-container").setCsvRawData(document.getElementById('#tableTrigger > tbody > tr').each().value, ",", null);
        });
	</script>

</BODY>
</HTML>

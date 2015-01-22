<!DOCTYPE HTML>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>Trend Report (Hannover-re)</title>
		<link href="http://fonts.googleapis.com/css?family=Open+Sans:400,700,600" rel="stylesheet" type="text/css">
    	<link href="http://netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
    	<link href="css/app.css" rel="stylesheet" type="text/css">
		<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
		<style type="text/css">
${demo.css}
		</style>
		<script type="text/javascript">
$(function () {

    Highcharts.data({
        csv: document.getElementById('tsv').innerHTML,
        itemDelimiter: '~~~',
        parsed: function (columns) {

            var brands = {},
                brandsData = [],
                versions = {},
                drilldownSeries = [];
            // Parse percentage strings
            columns[1] = $.map(columns[1], function (value) {
            	
                if (value.indexOf('%') === value.length - 1) {
                    value = parseFloat(value);
                }
                return value;
            });

            $.each(columns[0], function (i, name) {
                var brand,
                    version;

                if (i > 0) {

				
                    // Split into brand and version
                    if(name.indexOf("#") != -1){
                    	var temp = name.split("#");
                    	brand = temp[0];
                    	version = temp[1];
                    } else{
                    	brand = name;
                    }

                    // Create the main data
                    if (!brands[brand]) {
                        brands[brand] = columns[1][i];
                    } else {
                        brands[brand] += columns[1][i];
                    }

                    // Create the version data
                    if (version !== null) {
                        if (!versions[brand]) {
                            versions[brand] = [];
                        }
                        versions[brand].push([version, columns[1][i]]);
                    }
                }

            });

            $.each(brands, function (name, y) {
                brandsData.push({
                    name: name,
                    y: y,
                    drilldown: versions[name] ? name : null
                });
            });
            $.each(versions, function (key, value) {
                drilldownSeries.push({
                    name: key,
                    id: key,
                    data: value
                });
            });

            // Create the chart
            $('#container').highcharts({
                chart: {
                    type: 'pie'
                },
                title: {
                    text: 'Trends Status. '+document.getElementById('month').value+', '+document.getElementById('year').value+'. '+document.getElementById('state').value
                },
                subtitle: {
                    text: 'Click the slices to view details. Source: hannover-re.com.'
                },
                plotOptions: {
                    series: {
                        dataLabels: {
                            enabled: true,
                            format: '{point.name}: {point.y:.1f}%'
                        }
                    }
                },

                tooltip: {
                    headerFormat: '<span style="font-size:11px">{series.name}</span><br>',
                    pointFormat: '<span style="color:{point.color}">{point.name}</span>: <b>{point.y:.2f}%</b> of total<br/>'
                },

                series: [{
                    name: 'Trends	',
                    colorByPoint: true,
                    data: brandsData
                }],
                drilldown: {
                    series: drilldownSeries
                }
            });
        }
    });
});


		</script>
		
		<script>
function fnUpload(){

	window.document.uploadFileForm.action = '/uploadFile.do?method=showReport';
	window.document.uploadFileForm.submit();

}
</script>
	</head>
	<body>
	<html:form action="/uploadFile">
<script src="../../js/highcharts.js"></script>
<script src="../../js/modules/data.js"></script>
<script src="../../js/modules/drilldown.js"></script>
<div style="color: black;border: 1px;border-color: black; border-style: solid;padding-left: 20px;"><img src="graphics/hannover_re.png;"/>
	<span style="margin-left: 100px;">Change Data Set &nbsp;&nbsp;&nbsp;&nbsp;
        Select State&nbsp;&nbsp;<html:select property="state">
        	<html:option value="Select">Select..</html:option>
            <html:option value="Haryana">Haryana</html:option>
            <html:option value="Delhi">Delhi</html:option>
            <html:option value="Uttar Pradesh">Uttar Pradesh</html:option>
            <html:option value="Others">Others</html:option>
        </html:select>&nbsp;
         Select Year&nbsp;&nbsp;<html:select property="year">
        	<html:option value="Select">Select..</html:option>
            <html:option value="2014">2014</html:option>
            <html:option value="2015">2015</html:option>
        </html:select>&nbsp;
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
        </html:select>&nbsp;<input type="button" id="demo2"  value="Upload" onClick="javascript:fnUpload()"> </span></div>
<div id="contentWrapper">

    <div id="contentLeft">

        <ul id="leftNavigation">
            <li >
                <a href="/uploadFile.do?method=init"><i class="fa fa-flask leftNavIcon"></i> Upload File</a>
            </li>
            <li>
                <a href="/uploadFile.do?method=showTriggerPivot"><i class="fa fa-flask leftNavIcon"></i> Pivot Utility</a>
            </li>
             <li class="active">
                <a href="/uploadFile.do?method=showReport"><i class="fa fa-flask leftNavIcon"></i> Trends Report</a>
            </li>
            <li>
                <a href="/uploadFile.do?method=showTable"><i class="fa fa-flask leftNavIcon"></i> Trends Table</a>
            </li>
            <li>
                <a href="/uploadFile.do?method=showTrigger"><i class="fa fa-flask leftNavIcon"></i> Trigger 1</a>
            </li>
            <li>
                <a href="/uploadFile.do?method=showTrigger"><i class="fa fa-flask leftNavIcon"></i> Trigger 2</a>
            </li>            
            <li >
                <a href="#"><i class="fa fa-flask leftNavIcon"></i> About us</a>
            </li>
            <li>
                <a href="#"><i class="fa fa-flask leftNavIcon"></i> Contact us</a>
            </li>
        </ul>

    </div>

    <div id="contentRight">
    </div>

</div>
<div id="container" style="min-width: 310px; max-width: 600px; height: 400px; margin: 0 auto"></div>
<html:hidden name="uploadFileForm" property="state" styleId="state"/>
<html:hidden name="uploadFileForm" property="year" styleId="year"/>
<html:hidden name="uploadFileForm" property="month" styleId="month"/>
<pre id="tsv" style="display:none"><bean:write name="uploadFileForm" property="pieData" filter="false"/>
</pre>
</html:form>
	</body>
</html>

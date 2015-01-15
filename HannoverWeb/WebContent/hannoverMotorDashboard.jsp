<!DOCTYPE HTML>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<html>
<head>
<title>Hannover-re Dashboard</title>
<link href="http://fonts.googleapis.com/css?family=Open+Sans:400,700,600"	rel="stylesheet" type="text/css">
<link href="http://netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
<link href="css/app.css" rel="stylesheet" type="text/css">
<LINK href="css/css.css" rel="stylesheet" type="text/css">
<LINK href="css/Examples.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/style4.css" />


<LINK href="css/jquery-ui.css" rel="stylesheet">	 

<LINK href="css/styleAcc.css" rel="stylesheet">	 

<STYLE>
@
-webkit-viewport {
	width: device-width;
}

@
-moz-viewport {
	width: device-width;
}

@
-ms-viewport {
	width: device-width;
}

@
-o-viewport {
	width: device-width;
}

@
viewport {
	width: device-width;
}
</STYLE>
</head>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="js/chili-1.8b.js"></script>
<SCRIPT src="js/Examples.js"></SCRIPT>
<script type="text/javascript" src="js/jquery.dropdown.js"></script>
<script src="js/modernizr.custom.63321.js"></script>
<script src="js/highcharts.js"></script>
<script src="js/modules/data.js"></script>
<script src="js/modules/drilldown.js"></script>
<SCRIPT>
$(function() {
		$("#example-basic").show().steps({
			headerTag : "h3",
			bodyTag : "section",
			transitionEffect : "slideLeft",
			autoFocus : true
		});
});
</SCRIPT>
<script type="text/javascript">
$(function () {

    Highcharts.data({
        csv: document.getElementById('tsv').innerHTML,
        itemDelimiter: '\t',
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
                    text: 'Trends Status. December, 2014. Uttar Pradesh'
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
<script type="text/javascript">
$( function() {
	 $( "#contentWrapper #contentRight section#accordion" ).accordion();
});
</script>
<body>
	<html:form action="/hannoverMotor">
		<div
			style="color: black; border: 1px; border-color: black; border-style: solid; padding-left: 260px;">
			<img src="graphics/hannover_re.png;" />
		</div>
		<div id="contentWrapper">

			<div id="contentLeft">

				<ul id="leftNavigation">
					<li class="active"><a href="/hannoverMotor.do?method=init"> Renew Policy</a></li>
					<li><a href="/uploadFile.do?method=showReport"> Get Quote</a></li>
					<li><a href="#"> About us</a></li>
					<li><a href="#"> Contact us</a></li>
				</ul>
			</div>
			<div id="contentRight">
					<SECTION id="basic" style="font-size:14px;border: 1px; border-color: white; border-style: solid;">
						<DIV id="example-basic" style="display: none;">
							<H3>Data Master</H3>
							<SECTION>
								<a href="">Link 1</a><br/>
								<a href="">Link 2</a><br/>
								<a href="">Link 3</a><br/>
							</SECTION>
							<H3>Data Analysis</H3>
							<SECTION>
								<div id="container" style="min-width: 310px; max-width: 600px; height: 400px; margin: 0 auto"></div>

								<pre id="tsv" style="display:none">Trends Status	Uttar Pradesh	
								Failed#Prolonged stay<br>General Ward- Unspecified	1%	
								Failed#Prolonged stay<br>CHOLECYSTECTOMY	1.5%	
								Failed#Prolonged stay<br>Hernia	2.5%	
								Passed	95%</pre>
							</SECTION>
							<H3>Admin Console</H3>
							<SECTION>
								<DIV id="accordion">
<H3>Section 1</H3>
<DIV>
<P>		Mauris mauris ante, blandit et, ultrices a, suscipit eget, quam. Integer
		ut neque. Vivamus nisi metus, molestie vel, gravida in, condimentum sit		amet, 
nunc. Nam a nibh. Donec suscipit eros. Nam mi. Proin viverra leo ut		odio. 
Curabitur malesuada. Vestibulum a velit eu ante scelerisque vulputate.
		 </P></DIV>
<H3>Section 2</H3>
<DIV>
<P>		Sed non urna. Donec et ante. Phasellus eu ligula. Vestibulum sit amet
		purus. Vivamus hendrerit, dolor at aliquet laoreet, mauris turpis porttitor
		velit, faucibus interdum tellus libero ac justo. Vivamus non quam. In
		suscipit faucibus urna.		 </P></DIV>
<H3>Section 3</H3>
<DIV>
<P>		Nam enim risus, molestie et, porta ac, aliquam ac, risus. Quisque lobortis.
		Phasellus pellentesque purus in massa. Aenean in pede. Phasellus ac libero		ac 
tellus pellentesque semper. Sed ac felis. Sed commodo, magna quis		lacinia 
ornare, quam ante aliquam nisi, eu iaculis leo purus venenatis dui.		 </P>
<UL>
  <LI>List item one</LI>
  <LI>List item two</LI>
  <LI>List item three</LI></UL></DIV>
<H3>Section 4</H3>
<DIV>
<P>		Cras dictum. Pellentesque habitant morbi tristique senectus et netus		et 
malesuada fames ac turpis egestas. Vestibulum ante ipsum primis in		faucibus 
orci luctus et ultrices posuere cubilia Curae; Aenean lacinia		mauris vel est.
		 </P>
<P>		Suspendisse eu nisl. Nullam ut libero. Integer dignissim consequat lectus.
		Class aptent taciti sociosqu ad litora torquent per conubia nostra, per
		inceptos himenaeos.		 </P></DIV></DIV>

								
							</SECTION>
							<H3>Calculate Premium</H3>
							<SECTION>
							<table>
							<tr>
							<td>
							Car Registration State<br/>
								<select id="cd-dropdown" >
									<option value="-1" selected>Select....</option>
									<option value="1" >Delhi</option>
									<option value="2" >Haryana</option>
									<option value="3" >Rajasthan</option>
									<option value="4" >Punjab</option>
									<option value="5" >Others</option>
								</select>
							</td>
							<td width="40px"></td>
							<td>
							 Car Registration City<br/>
								<select id="cd-dropdown2" >
									<option value="-1" selected>Select....</option>
									<option value="1" >Gurgaon</option>
									<option value="2" >Faridabad</option>
									<option value="3" >Karnal</option>
									<option value="4" >Panchkula</option>
									<option value="5" >Others</option>
								</select>
							</td>
							<td width="40px"></td>
							<td>
							Car Registration Date<br/>
								<select id="cd-dropdown3" style="width: 60px;">
									<option value="-1" selected>DD</option>
									<option value="1" >01</option>
									<option value="2" >02</option>
									<option value="3" >03</option>
									<option value="4" >04</option>
									<option value="5" >05</option>
								</select>
								<select id="cd-dropdown4" style="width: 65px;">
									<option value="-1" selected>MM</option>
									<option value="1" >01</option>
									<option value="2" >02</option>
									<option value="3" >03</option>
									<option value="4" >04</option>
									<option value="5" >05</option>
								</select>
								<select id="cd-dropdown4" style="width: 80px;">
									<option value="-1" selected>YYYY</option>
									<option value="1" >2010</option>
									<option value="2" >2011</option>
									<option value="3" >2012</option>
									<option value="4" >2013</option>
									<option value="5" >2014</option>
									<option value="6" >2015</option>
								</select>
							</td>
							<td width="40px"></td>
							<td>
							Previous Policy Expiry Date<br/>
								<select id="cd-dropdown3" style="width: 60px;">
									<option value="-1" selected>DD</option>
									<option value="1" >01</option>
									<option value="2" >02</option>
									<option value="3" >03</option>
									<option value="4" >04</option>
									<option value="5" >05</option>
								</select>
								<select id="cd-dropdown4" style="width: 65px;">
									<option value="-1" selected>MM</option>
									<option value="1" >01</option>
									<option value="2" >02</option>
									<option value="3" >03</option>
									<option value="4" >04</option>
									<option value="5" >05</option>
								</select>
								<select id="cd-dropdown4" style="width: 80px;">
									<option value="-1" selected>YYYY</option>
									<option value="1" >2010</option>
									<option value="2" >2011</option>
									<option value="3" >2012</option>
									<option value="4" >2013</option>
									<option value="5" >2014</option>
									<option value="6" >2015</option>
								</select>
							</td>
							</tr>
							
							<tr>
							<td>
							Previous Policy Issued by<br/>
								<select id="cd-dropdown" >
									<option value="-1" selected>Select....</option>
									<option value="1" >New India Insurance</option>
									<option value="2" >Oriental Insurnce</option>
									<option value="5" >Others</option>
								</select>
							</td>
							<td width="40px"></td>
							<td>
							 Manufacturer's Name<br/>
								<select id="cd-dropdown2" >
									<option value="-1" selected>Select....</option>
									<option value="1" >BMW</option>
									<option value="2" >Mercedes</option>
									<option value="3" >Audi</option>
									<option value="4" >Honda</option>
									<option value="5" >Others</option>
								</select>
							</td>
							<td width="40px"></td>
							<td>
							Manufacturing Year<br/>
								<select id="cd-dropdown2" >
									<option value="-1" selected>Select....</option>
									<option value="1" >2010</option>
									<option value="2" >2011</option>
									<option value="3" >2012</option>
									<option value="4" >2013</option>
									<option value="5" >2014</option>
									<option value="6" >2015</option>
								</select>
							</td>
							<td width="40px"></td>
							<td>
							Model Name<br/>
								<select id="cd-dropdown2" >
									<option value="-1" selected>Select....</option>
									<option value="1" >A3</option>
									<option value="2" >A4</option>
									<option value="3" >A6</option>
									<option value="4" >A7</option>
									<option value="5" >Others</option>
								</select>
							</td>
							</tr>
							
							
							</table>
							</SECTION>
							<H3>Add-Ons</H3>
							<SECTION>
								<P>
								<input type="checkbox" style="margin-bottom: 5px;margin-right: 15px;"/><b>Zero dep</b><br/>
								A zero depreciation cover ensures that in case of an accident, you will receive full claim without any deduction for depreciation on value of parts replaced.<br/>
								
								<input type="checkbox" style="margin-bottom: 5px;margin-right: 15px;"/><b>NCB Retention</b><br/>
								No claim bonus (NCB) is a reward for those policy holders who have not claimed against their car insurance policy in the past year(s). Over a period of time, NCB can be accumulated to provide a discount of up to 50%.
								However, even a single claim on your policy can bring NCB down to 0%. By taking an add-on, this can be avoided. Under this add-on, even if you have a claim.<br/>
								
								<input type="checkbox" style="margin-bottom: 5px;margin-right: 15px;"/><b>Engine Cover</b><br/>
								Provides cover for engine failure.<br/>
								
								<input type="checkbox" style="margin-bottom: 5px;margin-right: 15px;"/><b>Key Replacement</b><br/>
								Cover for replacement of keys in case they break or get lost.<br/>
								
								<input type="checkbox" style="margin-bottom: 5px;margin-right: 15px;"/><b>Roadside Assistance</b><br/>
								It may include jump starting an automobile, towing a vehicle, helping to change a flat tire, providing a small amount of fuel when a vehicle runs out of it, pulling out a vehicle that is stuck in snow or helping people who are locked out.<br/>
								
								<input type="checkbox" style="margin-bottom: 5px;margin-right: 15px;"/><b>Daily Cash Allowance</b><br/>
								This allowance covers the owner's transportation costs, is paid only if your vehicle has a need to be in a garage for more than 3-4 days.<br/>
								
								<input type="checkbox" style="margin-bottom: 5px;margin-right: 15px;"/><b>Return to Invoice</b><br/>
								This benefit is available only for new cars and for the first year of the vehicle. If your vehicle gets totally damaged, 100% of the value of the vehicle (without deducting 5% depreciation) shall be reimbursed to the car owner.<br/>
								
								<input type="checkbox" style="margin-bottom: 5px;margin-right: 15px;"/><b>Telematics/Blackbox Insurance</b><br/>
								Customers can opt for this to prove that they drive safely and hence pay reduced premium.<br/>
								</P>
							</SECTION>
						</DIV>
					</SECTION>
				</DIV>
			</DIV>
	</html:form>
</body>
</html>
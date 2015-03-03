<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
 <div id="contentLeft">

        <ul id="leftNavigation">
            <li id="uploadFile">
                <a href="/uploadFile.do?method=init"><i class="fa fa-flask leftNavIcon"></i> Dashboard</a>
            </li>
            <li id="pivot">
                <a href="/uploadFile.do?method=showTriggerPivot"><i class="fa fa-flask leftNavIcon"></i> Hannover BI</a>
            </li>
             <li id="pivotAi">
                <a href="/uploadFile.do?method=showTriggerPivotAi"><i class="fa fa-flask leftNavIcon"></i> Hannover AI</a>
            </li>           
             <li id="report">
                <a href="/uploadFile.do?method=showReport"><i class="fa fa-flask leftNavIcon"></i> Hannover Report</a>
            </li>
            <li id="trendTable">
                <a href="/uploadFile.do?method=showTable"><i class="fa fa-flask leftNavIcon"></i> Trends Table</a>
            </li>
            <logic:iterate name="uploadFileForm" property="trendsList" id="trendsList">
            <li id="<bean:write name="trendsList" property="trendName"/>">
                <a href='/uploadFile.do?method=showTrend&id=<bean:write name="trendsList" property="id"/>'><i class="fa fa-flask leftNavIcon"></i>&nbsp;<bean:write name="trendsList" property="trendName"/></a>
            </li>
            </logic:iterate>
            
            <li id="trigger1">
                <a href="/uploadFile.do?method=showTrigger"><i class="fa fa-flask leftNavIcon"></i>Triggers</a>
            </li>
            
            <li>
                <a href="#"><i class="fa fa-flask leftNavIcon"></i> About us</a>
            </li>
            <li>
                <a href="#"><i class="fa fa-flask leftNavIcon"></i> Contact us</a>
            </li>
        </ul>
        
        
        <ul id="tabs" style="font-size: 10px; font-family: Arial;">
	      <li style="font-size: 10px; font-family: Arial;"><a href="#about">Upload File</a></li>
	      <li style="font-size: 10px; font-family: Arial;"><a href="#advantages">Change Dataset</a></li>
	    </ul>
	<html:form action="/uploadFile" enctype="multipart/form-data">
	    <div class="tabContent" id="about" style="font-size: 10px; font-family: Arial;">
	      <div>
        Select State&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<html:select property="state" style="font-size: 10px; font-family: Arial;  width:125px;">
        	<html:option value="Select">Select..</html:option>
            <html:option value="Haryana">Haryana</html:option>
            <html:option value="Delhi">Delhi</html:option>
            <html:option value="Uttar Pradesh">Uttar Pradesh</html:option>
            <html:option value="Others">Others</html:option>
        </html:select><br/>
         Select Year&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<html:select property="year" style="font-size: 10px; font-family: Arial;  width:125px;">
        	<html:option value="Select">Select..</html:option>
            <html:option value="2014">2014</html:option>
            <html:option value="2015">2015</html:option>
        </html:select><br/>
         Select Month&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<html:select property="month" style="font-size: 10px; font-family: Arial; width:125px;">
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
        
        Enter Description&nbsp;<html:text property="description" style="font-size: 10px; font-family: Arial;  width:120px;"></html:text><br/>
        Please select a file
        <html:file property="excelFilePath" styleId ="excelFilePath" style="font-size: 10px; font-family: Arial;"/><br/><input style="font-size: 10px; font-family: Arial;" type="button" id="demo2"  value="Upload" onClick="javascript:fnUpload()">
	      </div>
	    </div>
	
	    <div class="tabContent" id="advantages" style="font-size: 10px; font-family: Arial;">
	      <div>
        Select State&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<html:select property="state" style="font-size: 10px; font-family: Arial;  width:125px;">
        	<html:option value="Select">Select..</html:option>
            <html:option value="Haryana">Haryana</html:option>
            <html:option value="Delhi">Delhi</html:option>
            <html:option value="Uttar Pradesh">Uttar Pradesh</html:option>
            <html:option value="Others">Others</html:option>
        </html:select>&nbsp;
         Select Year&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<html:select property="year" style="font-size: 10px; font-family: Arial;  width:125px;">
        	<html:option value="Select">Select..</html:option>
            <html:option value="2014">2014</html:option>
            <html:option value="2015">2015</html:option>
        </html:select>&nbsp;
         Select Month&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<html:select property="month" style="font-size: 10px; font-family: Arial;  width:125px;">
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
        </html:select>&nbsp;<input type="button" id="demo2"  value="Change" onClick="javascript:changeDataSet()" style="font-size: 10px; font-family: Arial;"> 
	      </div>
	    </div>
	    </html:form>

    </div>
    
     <script type="text/javascript">
    //<![CDATA[
    function showTrend(id){
    	window.document.uploadFileForm.action = '/uploadFile.do?method=showTrend&id='+id;
    	window.document.uploadFileForm.submit();
    }       

    var tabLinks = new Array();
    var contentDivs = new Array();

    function init() {

      // Grab the tab links and content divs from the page
      var tabListItems = document.getElementById('tabs').childNodes;
      for ( var i = 0; i < tabListItems.length; i++ ) {
        if ( tabListItems[i].nodeName == "LI" ) {
          var tabLink = getFirstChildWithTagName( tabListItems[i], 'A' );
          var id = getHash( tabLink.getAttribute('href') );
          tabLinks[id] = tabLink;
          contentDivs[id] = document.getElementById( id );
        }
      }

      // Assign onclick events to the tab links, and
      // highlight the first tab
      var i = 0;

      for ( var id in tabLinks ) {
        tabLinks[id].onclick = showTab;
        tabLinks[id].onfocus = function() { this.blur() };
        if ( i == 0 ) tabLinks[id].className = 'selected';
        i++;
      }

      // Hide all content divs except the first
      var i = 0;

      for ( var id in contentDivs ) {
        if ( i != 0 ) contentDivs[id].className = 'tabContent hide';
        i++;
      }
    }

    function showTab() {
      var selectedId = getHash( this.getAttribute('href') );

      // Highlight the selected tab, and dim all others.
      // Also show the selected content div, and hide all others.
      for ( var id in contentDivs ) {
        if ( id == selectedId ) {
          tabLinks[id].className = 'selected';
          contentDivs[id].className = 'tabContent';
        } else {
          tabLinks[id].className = '';
          contentDivs[id].className = 'tabContent hide';
        }
      }

      // Stop the browser following the link
      return false;
    }

    function getFirstChildWithTagName( element, tagName ) {
      for ( var i = 0; i < element.childNodes.length; i++ ) {
        if ( element.childNodes[i].nodeName == tagName ) return element.childNodes[i];
      }
    }

    function getHash( url ) {
      var hashPos = url.lastIndexOf ( '#' );
      return url.substring( hashPos + 1 );
    }
    
    init();
    
    function fnUpload(){

    	window.document.uploadFileForm.action = '/uploadFile.do?method=uploadExcel';
    	window.document.uploadFileForm.submit();

    }
    
    function changeDataSet(){

    	window.document.uploadFileForm.action = '/uploadFile.do?method=loadPivotData';
    	window.document.uploadFileForm.submit();

    }

    //]]>
    </script>
    
        <style type="text/css">
      ul#tabs { list-style-type: none; margin: 30px 0 0 0; padding: 0 0 0.3em 0; }
      ul#tabs li { display: inline; }
      ul#tabs li a { color: #42454a; background-color: #dedbde; border: 1px solid #c9c3ba; border-bottom: none; padding: 0.3em; text-decoration: none; }
      ul#tabs li a:hover { background-color: #f1f0ee; }
      ul#tabs li a.selected { color: #000; background-color: #f1f0ee; font-weight: bold; padding: 0.7em 0.3em 0.38em 0.3em; }
      div.tabContent { border: 1px solid #c9c3ba; padding: 0.5em; background-color: #f1f0ee; }
      div.tabContent.hide { display: none; }
    </style>
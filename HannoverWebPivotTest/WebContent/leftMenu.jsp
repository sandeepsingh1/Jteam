<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
 <div id="contentLeft">

        <ul id="leftNavigation">
            <li id="uploadFile">
                <a href="/uploadFileMotor.do?method=init"><i class="fa fa-flask leftNavIcon"></i> Dashboard</a>
            </li>
            <li id="pivot">
                <a href="/uploadFileMotor.do?method=showTriggerPivot"><i class="fa fa-flask leftNavIcon"></i> Hannover BI</a>
            </li>
             
        </ul>
        
        
        <ul id="tabs" style="font-size: 10px; font-family: Arial;">
	      <li style="font-size: 10px; font-family: Arial;"><a href="#about">Upload File</a></li>
	    </ul>
	<html:form action="/uploadFileMotor" enctype="multipart/form-data">
	    <div class="tabContent" id="about" style="font-size: 10px; font-family: Arial;">
	      <div>
	        Please select a file
	        <html:file property="excelFilePath" styleId ="excelFilePath" style="font-size: 10px; font-family: Arial;"/><br/>
	        <input style="font-size: 10px; font-family: Arial;" type="button" id="demo2"  value="Upload" onClick="javascript:fnUpload()">
	      </div>
	    </div>
	</html:form>

    </div>
    
     <script type="text/javascript">
  
    
    function fnUpload(){

    	window.document.uploadFileForm.action = '/uploadFileMotor.do?method=uploadExcel';
    	window.document.uploadFileForm.submit();

    }
   
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
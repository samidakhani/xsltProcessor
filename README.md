#XSLTProcessor
 	Transforms a xml file into other format using xsl style-sheet as input. An alternate to using browsers for xsl-transformation.
 	
# Motivation
   A need to transform an xml into other formats and to exclude the embedding of xsl style-sheet into the xml file.
   Also, some browsers may not support xsl transformation.Hence, this project was undertaken.    
   
# Installation
   * Download the project 
   * Navigate to the directory **cd xsltProcessor**
   * Run **mvn clean package**
   * A jar named **XSLTProcessor.jar** is generated in **xsltProcessor/target** folder
   
#Usage
   * You may now use **XSLTProcessor.jar** with the following command
  
	 java -jar XSLTProcessor.jar -xml <absolute_path_to_xmlFile> -xsl <absolute_path_to_xslFile> [-r <absolute_path_to_outputFile>]
	 
    
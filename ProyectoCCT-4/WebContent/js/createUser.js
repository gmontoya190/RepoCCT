$(document).ready(function() {
	 alert("holis ENTRE a createUser.js");
	 
	 
	   $('input#creoUsuario').click(function(event) {
		  
           //alert("Creo Usuario");
		   var actionSource ='creoUsuario';
           var vec=[7]; 
       	vec[0]=$("#nombreUsuario").val();   
        vec[1]=$("#email").val();                         
       	vec[2]=$("#sexo").val();
       	vec[3]=$("#IdProceso").val();
       	vec[4]=$("#esLider").val();    
        vec[5]=$("#contra").val();
        console.dir("entro creousuario") ;
          
           $.post('UserServlet', {evec:vec ,action:actionSource}, function(responseText) {
               $('#content').html(responseText);
           });
       });
   
	   $('input#modificacion').click(function(event) {
	       	
           alert("holis sirviooo");
		   var actionSource ='modificoUsuario';
           var vec=[7];
       	vec[0]=$("#nombreUsuario").val();   
        vec[1]=$("#email").val();                         
       	vec[2]=$("#sexo").val();
       	vec[3]=$("#IdProceso").val();
       	vec[4]=$("#esLider").val();    
        vec[5]=$("#contra").val();
       
          
           $.post('UserServlet', {evec:vec ,action:actionSource} , function(responseText) {
               $('#content').html(responseText);
           });
       });
	   /*$('input#modificacion').click(function(event) {
        	
            alert("Modifico el formato");
            var actionSource ='modificaFormato';
          
           
            $.post('UserServler', {action:actionSource
            }, function(responseText) {
                $('#content').html(responseText);
            });*/
        });
        
        
 
   // });


/*
$(document).ready(function() {
        $('a#formats').click(function(event) {
           
             console.dir("ENTROOOOOO") ;
             var actionSource ='loadFormats';
            $.post('UserServlet', {action:actionSource
            }, function(responseText) {
                $('#content').html(responseText);
            });
        });
    });

$(document).on("ready",function(){

	$('#creaUsuario').on('click',                    
                    
			function(){
        
        
    	var vec=[6];
    	vec[0]=$("#nombreUsuario").val();   
       vec[1]=$("#email").val();                         
    	vec[2]=$("#sexo").val();
    	vec[3]=$("#IdProceso").val();
    	 vec[4]=$("#esLider").val();                         
     	vec[5]=$("#contraseña").val();
   
       
        alert("Formato guardado");
        $.post('UserServlet',{evec:vec},function(responsetext){
            
            
            //   $("#res").text(responsetext);
               
           });
       $('#formularioCreaFormato').each (function(){
       this.reset();
            });
        
        
      
        

    });
                        
});
                  */  
                    
                    
                    
                    
brite.registerView("ContactDialog", {emptyParent:false}, {
	create: function(data,config){
		return render("tmpl-ContactDialog", {data : data});
   },
   
   postDisplay: function(){

   },
   
   events: {
	       "click; .form-actions .add": function(event){
	    	   var ContactDialog = this;
	    	   var firstName = ContactDialog.$el.find("#firstName").val();
	    	   var lastName = ContactDialog.$el.find("#lastName").val();
	    	   
	    	   var legal = true;
	    	   if(firstName.length <= 0) {
	    		   legal = false;
	    	   } 
	    	   
	    	   if(lastName.length <= 0) {
	    		   legal = false;
	    	   }
	    	   
	    	   if(legal == true) {
	    		   app.RemoteDAOHandler.createContact(firstName,lastName).pipe(function(contact) {
	    			   brite.display("MainView",$mainview);
	    		   });
	    		   this.$el.remove();
	    	   }else{
	    		   alert("unavailable value");
	    	   }
	    	  
	       },
	
	       "click; .form-actions .update": function(event){
	    	   var ContactDialog = this;
	    	   var firstName = ContactDialog.$el.find("#firstName").val();
	    	   var lastName = ContactDialog.$el.find("#lastName").val();
	    	   var contactId = ContactDialog.$el.find("#firstName").attr("contactId");
	    	   
	    	   var legal = true;
	    	   if(firstName.length <= 0) {
	    		   legal = false;
	    	   } 
	    	   
	    	   if(lastName.length <= 0) {
	    		   legal = false;
	    	   }
	    	   
	    	   if(legal == true) {
	    		   app.RemoteDAOHandler.updateContactInfo(contactId,firstName,lastName).pipe(function(contact) {
	    			   brite.display("MainView",$mainview);
	    		   });
	    		   this.$el.remove();
	    	   }else{
	    		   alert("unavailable value");
	    	   }
	    	   
	       },
	       
	       "click; button.setGroup": function(event){
	     	  var contactId = this.$el.find("legend").attr("data-contact-id");
	     	  var checkboxs = this.$el.find("input[type='checkbox']");
	     	  var groupIds = "";
	     	  
	     	  checkboxs.each(function(index) {
	     		  var checkbox = checkboxs[index];
	     		  if(checkbox.checked) {
	     			  var groupId = $(checkbox).attr("groupId")+"";
	     			 groupIds=groupIds+"#"+groupId;
	     		  }
	     	  });
	     	  
	     	  app.RemoteDAOHandler.setContactGroup(contactId,groupIds);
	     	  this.$el.remove();
	     	  brite.display("MainView",$mainview);
	        },
	        
	       "click; .form-actions .cancel": function(event){
	    	   this.$el.remove();
	       }
      }
   
 });



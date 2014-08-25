brite.registerView("GroupDialog", {emptyParent:false}, {
	create: function(data,config){
		return render("tmpl-GroupDialog", {data : data});
   },
   
   postDisplay: function(){

   },
   
   events: {
	       "click; .form-actions .add": function(event){
	    	   var groupCreate = this;
	    	   var groupName = groupCreate.$el.find("#groupName").val()
	    	   
	    	   if(groupName.length > 0) {
	    		   app.RemoteDAOHandler.createGroup(groupName).pipe(function(group) {
	    			   brite.display("MainView",$mainview);
	    			   console.log(group);
	    		   });
	    		   this.$el.remove();
	    		   
	    	   } else {
	    		   alert("unavailable value");
	    	   }
	    	  
	       },
	       
	       "click; .form-actions .cancel": function(event){
	    	   this.$el.remove();
	       },
	       
	       "click; .form-actions .update": function(event){
	    	   var groupCreate = this;
	    	   var groupName = groupCreate.$el.find("#groupName").val();
	    	   var groupId = groupCreate.$el.find("#groupName").attr("groupId");
	    	   
	    	   if(groupName.length > 0) {
	    		   app.RemoteDAOHandler.updateGroupInfo(groupId, groupName).pipe(function(group) {
	    			   brite.display("MainView",$mainview);
	    		   });
	    		   this.$el.remove();
	    		   
	    	   } else {
	    		   alert("unavailable value");
	    	   }
	       }
   }
 });



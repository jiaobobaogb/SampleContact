brite.registerView("GroupView", {emptyParent:true}, {
	create: function(data,config){
		var groupList = data.groupList;
       return render("tmpl-GroupView", {groupList:groupList});
   },
   postDisplay: function(){
	   
   },
   events: {
		   "click; button.add": function(event){
		         brite.display("GroupDialog",$mainview,{title : "Add Group"});
		       },
	       
	       "click; button.edit": function(event){
	    	   var groupId = $(event.target).closest("tr").attr("data-group-id");
	    	   app.RemoteDAOHandler.getGroupInfo(groupId).pipe(function(group) {
	    		   brite.display("GroupDialog",$mainview,{title : "Edit Group",group : group});
	    	   })
	       },
	         
	       "click; button.delete": function(event){
	    	   var groupId = $(event.target).closest("tr").attr("data-group-id");
	    	   app.RemoteDAOHandler.deleteGroup(groupId).pipe(function(group) {
	    		   brite.display("MainView",$mainview);
	    	   })
	       }
	       
	   }
   
});



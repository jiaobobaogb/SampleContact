brite.registerView("MainView", {emptyParent:true}, {
	create: function(data,config){
       return render("tmpl-MainView");
   },
   postDisplay: function(){
	    var mainView = this;
	    
	    app.RemoteDAOHandler.listAllGroups().done(function(groupList) {
    		brite.display("GroupView", mainView.$el.find(".MainView-group"), { groupList : groupList});
    	});
	    
	    app.RemoteDAOHandler.listContacts().done(function(contactList) {
    		brite.display("ContactView", mainView.$el.find(".MainView-contact"), { contactList : contactList});
    	});

   }
 });




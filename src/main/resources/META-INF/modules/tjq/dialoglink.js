define(function() {
	init = function(spec) {
		jQuery('#' + spec.triggerId).click(function(e) {

			    e.preventDefault();
	            jQuery('#' + spec.dialogId).dialog('open');
				
				return false;
	        });
	  };
  	
  	return exports = init;
});

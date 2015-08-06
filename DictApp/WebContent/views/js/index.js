$(document).ready(function() {
	$( "#form" ).submit(function( event ) {
		 
	    // If .required's value's length is zero
	    if ( $( ".required" ).val().length === 0 ) {
	 
	        // Usually show some kind of error message here
	 
	        // Prevent the form from submitting
	        event.preventDefault();
	    } else {
	 
	        // Run $.ajax() here
	    	alert("哈哈");
	    }
	});
});
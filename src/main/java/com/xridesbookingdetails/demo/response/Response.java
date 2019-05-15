package com.xridesbookingdetails.demo.response;

import java.util.Date;


/*This is the class that defines the JSON response which the user will get in case of a successful operation, 
 or in case of any error.
 The response will contain details like the success or failure message, URL used and error details if any.
 */
public class Response {
    private Date timestamp;
    private String message;
    private String details;

    public Response(Date timestamp, String message, String details) {
         this.timestamp = timestamp;
         this.message = message;
         this.details = details;
    }
    
    

    public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}



	public void setMessage(String message) {
		this.message = message;
	}



	public void setDetails(String details) {
		this.details = details;
	}



	public Date getTimestamp() {
         return timestamp;
    }

    public String getMessage() {
         return message;
    }

    public String getDetails() {
         return details;
    }
}

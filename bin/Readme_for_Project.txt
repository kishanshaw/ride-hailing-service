I have implemented the REST API using Spring Boot, spring data JPA, PostgreSQL. The project is maven-type. 

Description of the Application : The application allows the end-user to hit or access the API to perform CRUD operations like
adding a record (ride details here), updating, deleting or getting the details of a particular booking id (here booking_id).
So, in other words the created REST service covers all the utilities that a REST API can do.

Below are following dependencies that I have added into our project : 
	1. Spring data JPA - This enables us to perform the JDBC or CRUD opeartions using the REST service.
	2. Spring Web - This enables the REST abilities in our application.
	3. Devtools - This restarts our applications automatically if any change in the code is detected.
	4. Actuator -  This maintains different configrations (health, info) regarding the created REST service. Through this, we can 					easily monitor the health of our API. 
	5. PostgreSQL - This is the database that we use to store our data.


Some more details: 
1. Our project has a REST controller (RideRestController.java) that handles all the REST API calls, and returns the acknowledgement to the user or an error response with detailed information in case of a failure. The class which is responisble for sending the response is Response.java. 

2. The project has a properties file (appication.properties) that stores the connections details for PostgreSQL database and other configurations. This application is configurable to run on different ports. 

3. I have implemented a custom Exception class in case if the required booking id (here booking_id) details are not found.
I have also created a Global Exception Handler (GlobalExceptionHandler.java)to handle all and any kind of exception being thrown while hitting the API. This exceptional handler responds to the user with appropriate error details 

This was a brief to the application, please reach out to me in case of doubts or concerns at kishanshaw29@gmail.com.


Now, I'll be covering the first brownie point that was given as part of the back-end task.

For this part, I have used Elasticsearch to implement and enhance the searching ability of the application. Using Elasticsearch, the end-user can easily perform analytical opeartions on the data even if the data size is big enough. To tackle more heavy data we can increase the nodes in the Elasticsearch cluster to make it more powerful by using its distributing capabilities. 
Using Elasticsearch will certainily decrease the load on the main application. If any user search for something, the request will go to Elasticsearch nodes, not to the main application. This will help the application to run smoothly. 

I have tried implementing or syncing the given dataset to Elasticsearch cluster in two ways: 
	1. Loading the data.csv into a table in PostgreSQL database and then syncing or indexing the data to Elasticsearch.
	   To implement this, I have used Logstash to sync data from PostgreSQL database to Elasticsearch. For this reason, I have 
	   written a configration file (postgresql-database.conf) and executed this file from Logstash. The command that I have used is-
	   		logstash -f postgresql-database.conf
	   	This command will start syncing or indexing the table from PostgreSQL database to Elasticsearch

	2. We can also index the csv data into Elasticsearch cluster. Here also I have used Logstash to sync data using configuration file (logstashPipelineCSV.conf). The command used here: 
			logstash -f logstashPipelineCSV.conf

I have attached both the config files in the corresponding mail, please feel free to check those. 

We can also write query DSL in ELasticsearch to perform some analytical operation. For instance, we can find the max number of 
cab cancellations had happened in which by the below query DSL: 

POST index/_search
{
	"query":{
		"match":{
			"car_cancellation" : 1
		}
		
	},
   
    "aggs" : {
        "Cancellations in different area" : {
            "terms" : { "field" : "from_area_id", "order" : { "_count" : "desc" },"size":3136}
            
        }
}
}


The above query will output area-code along with count of cancellations (in desc order)they had. Sample output of the query (go to end of the output)

"aggregations": {
        "Cancellations in different area": {
            "doc_count_error_upper_bound": 0,
            "sum_other_doc_count": 0,
            "buckets": [
                {
                    "key": "571",
                    "doc_count": 127
                },
                {
                    "key": "393",
                    "doc_count": 116
                },
                {
                    "key": "293",
                    "doc_count": 99
                },
                {
                    "key": "83",
                    "doc_count": 68
                },
                .....

}


So, this query will help company X to increase cabs in those areas which had maximum cancellations. In other words, it will reduce the number of cab cancellations. 




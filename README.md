# API Search Store

This project is a simply way create query to run in index without writer queries using libraries API client Elasticsearch. 

## Technologies

* Java 17
* Elasticsearch
* HandlerBars

### Process

HandlerBars is a library that through a template and an input object generates an output in
text format.
In our project we use a query template from Elasticsearch and with the mustache template we can manipulate query parameters dynamically without the need to write code.

Template: 
````
{
   "size": {{ size }},
   "query":{
      "match": {
         "title": "{{ term }}"
      }
   }
}
````

Output:
````
{
   "size": 10,
   "query":{
      "match": {
         "title": "batman"
      }
   }
}
````

## More information

For more information [handlerBars](https://github.com/jknack/handlebars.java).

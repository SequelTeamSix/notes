REST

https://restfulapi.net/

Stands for Representational State Transfer.

Defined originally by Roy Fielding in his dissertation in 2000, REST is an architectural style that outlines communication between a client and server over the web.

Essentially for a web service to be RESTful it has to adhere to a set of guidelines or constraints.

A RESTful server should not retain information about the state of the client.

Clients communicate with the server through an interface that is standard in that it too follows another set of constraints:

"defined by four interface constraints: 
identification of resources;
(resources are uniquely identified and separate from each other)
manipulation of resources through representations;
(resources are represented in some format, like json/xml)
self-descriptive messages;
(each representation should have the info needed to parse it - like content type header)
and, hypermedia as the engine of application state.
(we are accessing our restful resources via a link)
" - Roy Fielding

In a RESTful system, the server creates an object or resource and returns the state of that object (the values contained within the object) when requested by the client.
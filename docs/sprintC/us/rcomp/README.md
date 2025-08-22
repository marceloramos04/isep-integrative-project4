## 1. Introduction

For this project, we planned how the client and server applications will communicate with each other. This communication follows a rigid protocol that is described in later sections. All supported commands/messages are also described in this document.

## How to run

### Follow up Server
To run the server application, you need to run the following command on the follow up server, while located in the folder PROGS-RCOMP/JAVA/src/main/java

```bash
java -cp ".:h2-2.2.224.jar" TcpSrvSum
```

### Client Side Server
To run the client application, you need to run the following command on the client side server:


```bash
java TcpChatCli vsgate-s2.dei.isep.ipp.pt
```

| US NAME | README                                |
|---------|---------------------------------------|
| US3000  | [README.md](us/us3000/README.md)      |
| US3001  | [README.md](us/us3001/README.md)      |
| US3002  | [README.md](us/us3002/README.md)      |
| US3003  | [README.md](us/us3003/README.md)      |


## 2. Messages Format

We followed the following protocol to exchange data between the client and the server. The protocol is based on a message format that is used to exchange data between the client and the server applications. The message format is a binary format that is used to send requests and responses between the client and the server applications. The message format is designed to be simple and efficient, it’s based on a fixed-size message format that is easy to parse and generate. The message format is designed to be extensible, it supports the transport of any number of chunks of data, each chunk of data is identified by a length field that specifies the length of the data chunk. The message format is designed to be robust, it supports the transport of any type of data, including binary data.
### Table 1 - Message Format

| Field          | Offset (bytes) | Length (bytes) | Description                                                                                                                                                                         |
|----------------|----------------|----------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **VERSION**    | 0              | 1              | Message format version. This field is a single byte and should be interpreted as an unsigned integer (value 0 to 255). The present message format version number is one.             |
| **CODE**       | 1              | 1              | This field identifies the type of request or response, it should be interpreted as an unsigned integer (value 0 to 255). See Section 3.                                              |
| **DATA1_LEN_L**| 2              | 1              | These two fields are used to specify the length in bytes of the following DATA1 field. Both these fields are to be interpreted as unsigned integer numbers (value 0 to 255).         |
| **DATA1_LEN_M**| 3              | 1              | The length of the DATA1 field is to be calculated as: DATA1_LEN_L + 256 x DATA1_LEN_M                                                                                                |
| **DATA1**      | 4              | -              | First chunk of data, contains data to meet the specific needs of the participating applications, its existence and the content depend on the message’s code (type of request or response). |
| **DATA2_LEN_L**| -              | 1              | These two fields are used to specify the length in bytes of the following DATA2 field. Both these fields are to be interpreted as unsigned integer numbers (value 0 to 255).         |
| **DATA2_LEN_M**| -              | 1              | The length of the DATA2 field is to be calculated as: DATA2_LEN_L + 256 x DATA2_LEN_M                                                                                                |
| **DATA2**      | -              | -              | Second chunk of data, contains data to meet the specific needs of the participating applications, its existence and the content depend on the message’s code (type of request or response). |

In this message format, the transport of any number of chunks of data (DATA1, DATA2, DATA3, …) is supported, all messages end with two bytes with value zero that state that the next chunk of data does not exist, and the message has ended. Every message terminates with a sequence of two zero bytes. A message may not carry any data, such a message is only four bytes long.

## 3. Message Codes

This table shows all the available request and response message codes that are used to exchange data between the client and the server applications.

### Table 2 - Message Codes

| CODE | Type    | Meaning                                                                                                                                                                                                                                                                                            |
|------|---------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| 0    | Request | COMMTEST – Communications test request with no other effect on the server application than the response with an ACK message. This request has no data.                                                                                                                                             |
| 1    | Request | DISCONN – End of session request. The server application is supposed to respond with an ACK message, afterwards both client and server applications are expected to close the session (TCP connection). This request has no data.                                                                  |
| 2    | Response | ACK – Generic acknowledgment and success response message. Used in response to a successful request. This response contains no data.                                                                                                                                                               |
| 3    | Response | ERR – Error response message. Used in response to unsuccessful requests that caused an error. This response message may carry a human readable phrase explaining the error. If used, the phrase is carried in the DATA1 field as a string of ASCII codes, it’s not required to be null terminated. |
| 4    | Request | AUTH – User authentication request carrying the username in DATA1 and the user’s password in DATA2, both are strings of ASCII codes and are not required to be null terminated. If the authentication is successful, the server application response is ACK, otherwise it’s ERR.                   |
| 6    | Response | Contains the candidate application information. The request carries each Candidate application object in different DATA fields.                                                                                                                                                                    |
| 7    | Response | Contains the customer job opening information. The response carries each Job opening object in different DATA fields.                                                                                                                                                                              |
| 8    | Response | Contains the customer notifications. The response carries each notification object in different DATA fields.                                                                                                                                                                                       |
| 10   | Request | Requests all the candidate applications information.                                                                                                                                                                                                                                               |
| 11   | Request | Requests candidate notifications.                                                                                                                                                                                                                                                                  |
 | 18   | Response| Sends the Candidate Notifications                                                                                                                                                                                                                                                                  |
| 21   | Request | Requests all the customer job opening information.                                                                                                                                                                                                                                                 |
| 22   | Request | Requests all the customer notifications.                                                                                                                                                                                                                                                           |
| 100  | Response | AUTHAUCK – User authentication successful response. This response contains no data                                                                                                                                                                                                                 |

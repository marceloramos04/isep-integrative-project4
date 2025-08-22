## Description

---

- US1016: As Customer Manager, I want the system to notify candidates, by email, of the result of the verification process.

---

## NFR11 (RCOMP)

---

- The solution should be deployed using several network nodes.

- It is expected that, at least, the relational database server and the Follow Up Server be deployed in nodes different 
  from localhost, preferably in the cloud.

- The e-mail notification tasks must be executed in background by the Follow Up Server.

---

## 3. Subjects and backlog

---

- This is a software development project of network applications by using the Berkeley Sockets API, either in Java or C programming languages.

- A specific client-server application protocol is provided in the next topic, its use is mandatory on all network 
  communications between the developed applications, except for the communications with SMTP servers where the SMTP 
  application protocol should be used instead.

- The backlog for this project is a subset of the Integrative Project of the 4th Semester backlog for sprint C, as shown in Table 1.


---

## Application Protocol

---

The application protocol described in this chapter is of mandatory use.

### Protocol description

- It´s a TCP (Transmission Control Protocol) based client-server protocol.
- The client application takes the initiative of establishing a TCP connection with the server application, for such the client application is required to know (IP address or DNS name) the node where the server application is running and the TCP port number where the server application is accepting TCP connections.
- After the TCP connection is established, the connected applications exchange messages with the format described in Messages Format.
- Once established, the TCP connection between the client application and the server application is kept alive and is used for all required data exchanges while the client application is running.
- All message exchanges between the client application and the server application must follow a very restrict client-server pattern: the client application sends one request message, and the server application sends back one response message.

---

### Messages Format

- Every data exchange through the TCP connection (requests or responses) must comply with the bytes sequence description in the next table, this is the message format version one.

|    Field     | Offset (bytes)  | Length (bytes)  |                                                                                          Description                                                                                           |
|:------------:|:---------------:|:---------------:|:----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------:|
|   VERSION    |        0        |        1        |               Message format version. This field is a single byte and should be interpreted as an unsigned integer (0 to 255). The present message format version number is one.               |
|     CODE     |        1        |        1        |                              This field identifies the type of request or response, it should be interpreted as an unsigned integer (0 to 255). See Section 4.3.                               |
| DATA1_LEN_L  |        2        |        1        |             These two fields are used to specify the length in bytes of the following DATA1 field. Both these fields are to be interpreted as unsigned integer numbers (0 to 255).             |
| DATA1_LEN_M  |        3        |        1        | The length of the DATA1 field is to be calculated as: DATA1_LEN_L + 256 x DATA1_LEN_M If the resulting value is zero, it means DATA1 does not exist, and the message has ended at this point.  |
|    DATA1     |        4        |        -        |                   First chunk of data, contains data to meet the specific needs of the participating applications, its existence and the content depend on the message code.                   |
| DATA2_LEN_L  |        -        |        1        |             These two fields are used to specify the length in bytes of the following DATA2 field. Both these fields are to be interpreted as unsigned integer numbers (0 to 255).             |
| DATA2_LEN_M  |        -        |        1        | The length of the DATA2 field is to be calculated as: DATA2_LEN_L + 256 x DATA2_LEN_M If the resulting value is zero, it means DATA2 does not exist, and the message has ended at this point.  |
|    DATA2     |        -        |        -        |                  Second chunk of data, contains data to meet the specific needs of the participating applications, its existence and the content depend on the message code.                   |

- In this message format, the transport of any number of chunks of data (DATA1, DATA2, DATA3, …) is supported, all messages end with two bytes with value zero that state that the next chunk of date does not exist, and the message has ended.
- Every message ends with a sequence of two zero bytes.
- A message may not carry any data, such a message is only four bytes long.

---

### Message Codes

- Table 3 presents the set of initial message codes to be supported. As the project is developed, new message codes are 
  supposed to be added by the team to meet the needs of new features.

- After establishing the TCP connection with the server application, the client application must undertake a user 
  authentication procedure by sending an AUTH request carrying a username and a password.

- Until there’s a successful user authentication, the server application will refuse any other request other than AUTH, COMMTEST or DISCONN.

| Code  |   Type    |                                                                                                                              Request                                                                                                                               |                                                                                                                              Response                                                                                                                              |                                                                                                                           Meaning                                                                                                                            |
|:-----:|:---------:|:------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------:|:------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------:|:------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------:|
|   0   |  Request  |                                                                                             COMMTEST – Communication test request with no other effect on the server.                                                                                              |                                                         ACK – End of session requests, both client and server applications must respond to close the session (TCP connection). This response has no data.                                                          |                         A generic acknowledgment success request message. Used in response to a successful error response message sent in response to an unsuccessful request that caused an error. This response contains no data.                          |
|   1   |  Request  |                       DISCONN – End session request. The server application must respond with an ACK message, after which both client and server applications are expected to close the session (TCP connection). This request has no data.                        |                                          ACK – Generic acknowledgment success response message. Used in response to a successful error response message sent in response to an unsuccessful request that caused an error.                                          | Acknowledgment success request message containing only a human-readable phrase explaining that it is not used, but is terminated in the DATA1 field as an ASCII code string; zero required if the null character is used as the terminator; otherwise, ERR.  |
|   2   | Response  |                                                                                                       ACK – Generic acknowledgment success request message.                                                                                                        | ERR – Acknowledgment success request message containing only a human-readable phrase explaining that it is not used, but is terminated in the DATA1 field as an ASCII code string; zero required if the null character is used as the terminator; otherwise, ERR.  | Acknowledgment success request message containing only a human-readable phrase explaining that it is not used, but is terminated in the DATA1 field as an ASCII code string; zero required if the null character is used as the terminator; otherwise, ERR.  |
|   3   | Response  | ERR – Acknowledgment success request message containing only a human-readable phrase explaining that it is not used, but is terminated in the DATA1 field as an ASCII code string; zero required if the null character is used as the terminator; otherwise, ERR.  |                                                                                                                                 -                                                                                                                                  |                                                                                                                              -                                                                                                                               |
- This table provides the translation of the request and response messages, along with their meanings.

---
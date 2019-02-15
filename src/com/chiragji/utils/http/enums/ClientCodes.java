package com.chiragji.utils.http.enums;

import com.chiragji.utils.http.interfaces.ErrorCode;

/**
 * The 4xx class of status code is intended for cases in which the client seems to have erred. Except when responding to
 * a HEAD request, the server SHOULD include an entity containing an explanation of the error situation, and whether it
 * is a temporary or permanent condition. These status codes are applicable to any request method. User agents SHOULD
 * display any included entity to the user.
 * <p>
 * If the client is sending data, a server implementation using TCP SHOULD be careful to ensure that the client
 * acknowledges receipt of the packet(s) containing the response, before the server closes the input connection.
 * If the client continues sending data to the server after the close, the server's TCP stack will send a reset packet
 * to the client, which may erase the client's unacknowledged input buffers before they can be read and interpreted by
 * the HTTP application.
 *
 * @author Chirag Gupta
 */
public enum ClientCodes implements ErrorCode {
    /**
     * The request could not be understood by the server due to malformed syntax. The client SHOULD NOT repeat the
     * request without modifications.
     */
    BAD_REQUEST(400, "Bad Request"),
    /**
     * The request requires user authentication. The response MUST include a WWW-Authenticate header field
     * (section 14.47) containing a challenge applicable to the requested resource. The client MAY repeat the request
     * with a suitable Authorization header field (section 14.8). If the request already included Authorization
     * credentials, then the 401 response indicates that authorization has been refused for those credentials.
     * If the 401 response contains the same challenge as the prior response, and the user agent has already attempted
     * authentication at least once, then the user SHOULD be presented the entity that was given in the response, since
     * that entity might include relevant diagnostic information. HTTP access authentication is explained in
     * "HTTP Authentication: Basic and Digest Access Authentication".
     */
    UNAUTHORIZED(401, "Unauthorized"),
    /**
     * Reserved for future use. The original intention was that this code might be used as part of some form of digital
     * cash or micropayment scheme, but that has not happened, and this code is not usually used. As an example of its
     * use, however, Apple's MobileMe service generates a 402 error ("httpStatusCode:402" in the Mac OS X Console log)
     * if the MobileMe account is delinquent.
     */
    PAYMENT_REQUIRED(402, "Payment Required"),
    /**
     * The server understood the request, but is refusing to fulfill it. Authorization will not help and the request
     * SHOULD NOT be repeated. If the request method was not HEAD and the server wishes to make public why the request
     * has not been fulfilled, it SHOULD describe the reason for the refusal in the entity. If the server does not wish
     * to make this information available to the client, the status code 404 (Not Found) can be used instead.
     */
    FORBIDDEN(403, "Forbidden"),
    /**
     * The server has not found anything matching the Request-URI. No indication is given of whether the condition is
     * temporary or permanent. The 410 (Gone) status code SHOULD be used if the server knows, through some internally
     * configurable mechanism, that an old resource is permanently unavailable and has no forwarding address.
     * This status code is commonly used when the server does not wish to reveal exactly why the request has been
     * refused, or when no other response is applicable.
     */
    NOT_FOUND(404, "Not Found"),
    /**
     * The method specified in the Request-Line is not allowed for the resource identified by the Request-URI.
     * The response MUST include an Allow header containing a list of valid methods for the requested resource.
     */
    METHOD_NOT_ALLOWED(405, "Method Not Allowed"),
    /**
     * The resource identified by the request is only capable of generating response entities which have content
     * characteristics not acceptable according to the accept headers sent in the request.
     * <p>
     * Unless it was a HEAD request, the response SHOULD include an entity containing a list of available entity
     * characteristics and location(s) from which the user or user agent can choose the one most appropriate.
     * The entity format is specified by the media type given in the Content-Type header field. Depending upon the
     * format and the capabilities of the user agent, selection of the most appropriate choice MAY be performed
     * automatically. However, this specification does not define any standard for such automatic selection.
     * <p>
     * Note: HTTP/1.1 servers are allowed to return responses which are not acceptable according to the accept headers
     * sent in the request. In some cases, this may even be preferable to sending a 406 response. User agents are
     * encouraged to inspect the headers of an incoming response to determine if it is acceptable.
     * If the response could be unacceptable, a user agent SHOULD temporarily stop receipt of more data and query the
     * user for a decision on further actions.
     */
    NOT_APPLICABLE(406, "Not Acceptable"),
    /**
     * This code is similar to 401 (Unauthorized), but indicates that the client must first authenticate itself with
     * the proxy. The proxy MUST return a Proxy-Authenticate header field (section 14.33) containing a challenge
     * applicable to the proxy for the requested resource. The client MAY repeat the request with a suitable
     * Proxy-Authorization header field (section 14.34). HTTP access authentication is explained in
     * "HTTP Authentication: Basic and Digest Access Authentication".
     */
    PROXY_AUTH_REQUIRED(407, "Proxy Authentication Required"),
    /**
     * The client did not produce a request within the time that the server was prepared to wait. The client MAY repeat
     * the request without modifications at any later time.
     */
    REQUEST_TIMEOUT(408, "Request Timeout"),
    /**
     * The request could not be completed due to a conflict with the current state of the resource. This code is only
     * allowed in situations where it is expected that the user might be able to resolve the conflict and resubmit the
     * request. The response body SHOULD include enough information for the user to recognize the source of the conflict.
     * Ideally, the response entity would include enough information for the user or user agent to fix the problem;
     * however, that might not be possible and is not required.
     * <p>
     * Conflicts are most likely to occur in response to a PUT request. For example, if versioning were being used and
     * the entity being PUT included changes to a resource which conflict with those made by an earlier (third-party)
     * request, the server might use the 409 response to indicate that it can't complete the request. In this case, the
     * response entity would likely contain a list of the differences between the two versions in a format defined by
     * the response Content-Type.
     */
    CONFLICT(409, "Conflict"),
    /**
     * The requested resource is no longer available at the server and no forwarding address is known. This condition is
     * expected to be considered permanent. Clients with link editing capabilities SHOULD delete references to the
     * Request-URI after user approval. If the server does not know, or has no facility to determine, whether or not the
     * condition is permanent, the status code 404 (Not Found) SHOULD be used instead. This response is cacheable unless
     * indicated otherwise.
     * <p>
     * The 410 response is primarily intended to assist the task of web maintenance by notifying the recipient that the
     * resource is intentionally unavailable and that the server owners desire that remote links to that resource be
     * removed. Such an event is common for limited-time, promotional services and for resources belonging to
     * individuals no longer working at the server's site. It is not necessary to mark all permanently unavailable
     * resources as "gone" or to keep the mark for any length of time -- that is left to the discretion of the server
     * owner.
     */
    GONE(410, "Gone"),
    /**
     * The server refuses to accept the request without a defined Content- Length. The client MAY repeat the request if
     * it adds a valid Content-Length header field containing the length of the message-body in the request message.
     */
    LENGTH_REQ(411, "Length Required"),
    /**
     * The precondition given in one or more of the request-header fields evaluated to false when it was tested on the
     * server. This response code allows the client to place preconditions on the current resource metainformation
     * (header field data) and thus prevent the requested method from being applied to a resource other than the one
     * intended.
     */
    PRE_CONDITION_FAILED(412, "Precondition Failed"),
    /**
     * The server is refusing to process a request because the request entity is larger than the server is willing or
     * able to process. The server MAY close the connection to prevent the client from continuing the request.
     * <p>
     * If the condition is temporary, the server SHOULD include a Retry- After header field to indicate that it is
     * temporary and after what time the client MAY try again.
     */
    REQUEST_ENTITY_TOO_LARGE(413, "Request Entity Too Large"),
    /**
     * The server is refusing to service the request because the Request-URI is longer than the server is willing to
     * interpret. This rare condition is only likely to occur when a client has improperly converted a POST request to
     * a GET request with long query information, when the client has descended into a URI "black hole" of redirection
     * (e.g., a redirected URI prefix that points to a suffix of itself), or when the server is under attack by a client
     * attempting to exploit security holes present in some servers using fixed-length buffers for reading or
     * manipulating the Request-URI.
     */
    REQUEST_URI_TOO_LONG(414, "Request-URI Too Long"),
    /**
     * The server is refusing to service the request because the entity of the request is in a format not supported by
     * the requested resource for the requested method.
     */
    UNSUPPORTED_MEDIA_TYPE(415, "Unsupported Media Type"),
    /**
     * A server SHOULD return a response with this status code if a request included a Range request-header field
     * (section 14.35), and none of the range-specifier values in this field overlap the current extent of the selected
     * resource, and the request did not include an If-Range request-header field. (For byte-ranges, this means that the
     * first- byte-pos of all of the byte-range-spec values were greater than the current length of the selected
     * resource.)
     * <p>
     * When this status code is returned for a byte-range request, the response SHOULD include a Content-Range
     * entity-header field specifying the current length of the selected resource (see section 14.16). This response
     * MUST NOT use the multipart/byteranges content- type.
     */
    REQ_RANGE_NOT_SATISFIABLE(416, "Requested Range Not Satisfiable"),
    /**
     * The expectation given in an Expect request-header field (see section 14.20) could not be met by this server, or,
     * if the server is a proxy, the server has unambiguous evidence that the request could not be met by the next-hop
     * server.
     */
    EXCEPTION_FAILED(417, "Expectation Failed"),
    /**
     * This code was defined in 1998 as one of the traditional IETF April Fools' jokes, in RFC 2324, Hyper Text Coffee
     * Pot Control Protocol, and is not expected to be implemented by actual HTTP servers. However, known
     * implementations do exist. An Nginx HTTP server uses this code to simulate goto-like behaviour in its
     * configuration.
     */
    I_M_A_TEAPOT(418, "I'm a teapot (RFC 2324)"),
    /**
     * Returned by the Twitter Search and Trends API when the client is being rate limited. The text is a quote from
     * 'Demolition Man' and the '420' code is likely a reference to this number's association with marijuana. Other
     * services may wish to implement the 429 Too Many Requests response code instead.
     */
    ENHANCE_YOUR_CALM(420, "Enhance Your Calm (Twitter)"),
    /**
     * The 422 (Unprocessable Entity) status code means the server understands the content type of the request entity
     * (hence a 415(Unsupported Media Type) status code is inappropriate), and the syntax of the request entity is
     * correct (thus a 400 (Bad Request) status code is inappropriate) but was unable to process the contained
     * instructions. For example, this error condition may occur if an XML request body contains well-formed
     * (i.e., syntactically correct), but semantically erroneous, XML instructions.
     */
    UNPROCESSABLE_ENTITY(422, "Unprocessable Entity (WebDAV)"),
    /**
     * The 423 (Locked) status code means the source or destination resource of a method is locked. This response
     * SHOULD contain an appropriate precondition or postcondition code, such as 'lock-token-submitted' or
     * 'no-conflicting-lock'.
     */
    LOCKED(423, "Locked (WebDAV)"),
    /**
     * The 424 (Failed Dependency) status code means that the method could not be performed on the resource because the
     * requested action depended on another action and that action failed. For example, if a command in a PROPPATCH
     * method fails, then, at minimum, the rest of the commands will also fail with 424 (Failed Dependency).
     */
    FAILED_DEPENDENCY(424, "Failed Dependency (WebDAV)"),
    /**
     * Slein, J., Whitehead, E.J., et al., "WebDAV Advanced Collections Protocol", Work In Progress.
     * <p>
     * Wikipedia
     * Defined in drafts of "WebDAV Advanced Collections Protocol", but not present in "Web Distributed Authoring and
     * Versioning (WebDAV) Ordered Collections Protocol".
     */
    RESERVED_FOR_WebDAV(425, "Reserved for WebDAV"),
    /**
     * Reliable, interoperable negotiation of Upgrade features requires an unambiguous failure signal. The 426 Upgrade
     * Required status code allows a server to definitively state the precise protocol extensions a given resource must
     * be served with.
     */
    UPGRADE_REQUIRED(426, "Upgrade Required"),
    /**
     * The 428 status code indicates that the origin server requires the request to be conditional.
     * <p>
     * Its typical use is to avoid the "lost update" problem, where a client GETs a resource's state, modifies it, and
     * PUTs it back to the server, when meanwhile a third party has modified the state on the server, leading to a
     * conflict. By requiring requests to be conditional, the server can assure that clients are working with the
     * correct copies.
     * <p>
     * Responses using this status code SHOULD explain how to resubmit the request successfully.
     * <p>
     * The 428 status code is optional; clients cannot rely upon its use to prevent "lost update" conflicts.
     */
    PRE_CONDITION_REQ(428, "Precondition Required"),
    /**
     * The 429 status code indicates that the user has sent too many requests in a given amount of time
     * ("rate limiting").
     * <p>
     * The response representations SHOULD include details explaining the condition, and MAY include a Retry-After
     * header indicating how long to wait before making a new request.
     * <p>
     * When a server is under attack or just receiving a very large number of requests from a single party, responding
     * to each with a 429 status code will consume resources.
     * <p>
     * Therefore, servers are not required to use the 429 status code; when limiting resource usage, it may be more
     * appropriate to just drop connections, or take other steps.
     */
    TOO_MANY_REQ(429, "Too Many Requests"),
    /**
     * The 431 status code indicates that the server is unwilling to process the request because its header fields are
     * too large. The request MAY be resubmitted after reducing the size of the request header fields.
     * <p>
     * It can be used both when the set of request header fields in total are too large, and when a single header field
     * is at fault. In the latter case, the response representation SHOULD specify which header field was too large.
     * <p>
     * Servers are not required to use the 431 status code; when under attack, it may be more appropriate to just drop
     * connections, or take other steps.
     */
    REQ_HEADER_FIELDS_TOO_LARGE(431, "Request Header Fields Too Large"),
    /**
     * An Nginx HTTP server extension. The server returns no information to the client and closes the connection
     * (useful as a deterrent for malware).
     */
    NO_RESPONSE(444, "No Response (Nginx)"),
    /**
     * A Microsoft extension. The request should be retried after performing the appropriate action.
     */
    RETRY_WITH(449, "Retry With (Microsoft)"),
    /**
     * A Microsoft extension. This error is given when Windows Parental Controls are turned on and are blocking access
     * to the given webpage.
     */
    BLOCK_BY_WIN_PARENTAL_CONTROLS(450, "Blocked by Windows Parental Controls (Microsoft)"),
    /**
     * Intended to be used when resource access is denied for legal reasons, e.g. censorship or government-mandated
     * blocked access. A reference to the 1953 dystopian novel Fahrenheit 451, where books are outlawed, and the
     * autoignition temperature of paper, 451°F.
     */
    UNAVAILABLE_FOR_LEGAL_REASONS(451, "Unavailable For Legal Reasons"),
    /**
     * An Nginx HTTP server extension. This code is introduced to log the case when the connection is closed by client
     * while HTTP server is processing its request, making server unable to send the HTTP header back.
     */
    CLIENT_CLOSED_REQUEST(499, "Client Closed Request (Nginx)");

    private final int code;
    private final String description;

    ClientCodes(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }}

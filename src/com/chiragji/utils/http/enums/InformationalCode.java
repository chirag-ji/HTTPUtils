package com.chiragji.utils.http.enums;

import com.chiragji.utils.http.interfaces.HTTPCodes;

/**
 * This class of status code indicates a provisional response, consisting only of the Status-Line and optional headers,
 * and is terminated by an empty line. There are no required headers for this class of status code. Since HTTP/1.0 did
 * not define any 1xx status codes, servers MUST NOT send a 1xx response to an HTTP/1.0 client except under experimental
 * conditions.
 * <p>
 * A client MUST be prepared to accept one or more 1xx status responses prior to a regular response, even if the client
 * does not expect a 100 (Continue) status message. Unexpected 1xx status responses MAY be ignored by a user agent.
 * <p>
 * Proxies MUST forward 1xx responses, unless the connection between the proxy and its client has been closed, or unless
 * the proxy itself requested the generation of the 1xx response. (For example, if a proxy adds a "Expect: 100-continue"
 * field when it forwards a request, then it need not forward the corresponding 100 (Continue) response(s).)
 *
 * @author Chirag Gupta
 */
public enum InformationalCode implements HTTPCodes {
    /**
     * The client SHOULD continue with its request. This interim response is used to inform the client that the
     * initial part of the request has been received and has not yet been rejected by the server.
     * The client SHOULD continue by sending the remainder of the request or, if the request has already been completed,
     * ignore this response. The server MUST send a final response after the request has been completed.
     * See section 8.2.3 for detailed discussion of the use and handling of this status code.
     */
    CONTINUE(100, "Continue"),
    /**
     * The server understands and is willing to comply with the client's request, via the Upgrade message header field
     * (section 14.42), for a change in the application protocol being used on this connection. The server will switch
     * protocols to those defined by the response's Upgrade header field immediately after the empty line which
     * terminates the 101 response.
     * <p>
     * The protocol SHOULD be switched only when it is advantageous to do so. For example, switching to a newer version
     * of HTTP is advantageous over older versions, and switching to a real-time, synchronous protocol might be
     * advantageous when delivering resources that use such features.
     */
    SWITCHING_PROTOCOLS(101, "Switching Protocols"),
    /**
     * The 102 (Processing) status code is an interim response used to inform the client that the server has accepted
     * the complete request, but has not yet completed it. This status code SHOULD only be sent when the server has a
     * reasonable expectation that the request will take significant time to complete. As guidance, if a method is
     * taking longer than 20 seconds (a reasonable, but arbitrary value) to process the server SHOULD return a 102
     * (Processing) response. The server MUST send a final response after the request has been completed.
     * <p>
     * Methods can potentially take a long period of time to process, especially methods that support the Depth header.
     * In such cases the client may time-out the connection while waiting for a response. To prevent this the server
     * may return a 102 (Processing) status code to indicate to the client that the server is still processing the method.
     */
    PROCESSING_WebDAV(102, "Processing (WebDAV)");

    private final int code;
    private final String description;

    InformationalCode(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}

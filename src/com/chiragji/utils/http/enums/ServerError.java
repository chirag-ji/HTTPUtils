package com.chiragji.utils.http.enums;

import com.chiragji.utils.http.interfaces.ErrorCode;

/**
 * Response status codes beginning with the digit "5" indicate cases in which the server is aware that it has erred or
 * is incapable of performing the request. Except when responding to a HEAD request, the server SHOULD include an entity
 * containing an explanation of the error situation, and whether it is a temporary or permanent condition. User agents
 * SHOULD display any included entity to the user. These response codes are applicable to any request method.
 *
 * @author Chirag Gupta
 */
public enum ServerError implements ErrorCode {
    /**
     * The server encountered an unexpected condition which prevented it from fulfilling the request.
     */
    INTERNAL_ERROR(500, "Internal Server Error"),
    /**
     * The server does not support the functionality required to fulfill the request. This is the appropriate response
     * when the server does not recognize the request method and is not capable of supporting it for any resource.
     */
    NOT_IMPLEMENTED(501, "Not Implemented"),
    /**
     * The server, while acting as a gateway or proxy, received an invalid response from the upstream server it accessed
     * in attempting to fulfill the request.
     */
    BAD_GATEWAY(502, "Bad Gateway"),
    /**
     * The server is currently unable to handle the request due to a temporary overloading or maintenance of the server.
     * The implication is that this is a temporary condition which will be alleviated after some delay.
     * If known, the length of the delay MAY be indicated in a Retry-After header.
     * If no Retry-After is given, the client SHOULD handle the response as it would for a 500 response.
     * <p>
     * Note: The existence of the 503 status code does not imply that a server must use it when becoming overloaded.
     * Some servers may wish to simply refuse the connection.
     */
    SERVICE_UNAVAILABLE(503, "Service Unavailable"),
    /**
     * The server, while acting as a gateway or proxy, did not receive a timely response from the upstream server
     * specified by the URI (e.g. HTTP, FTP, LDAP) or some other auxiliary server (e.g. DNS) it needed to access in
     * attempting to complete the request.
     * <p>
     * Note: Note to implementors: some deployed proxies are known to return 400 or 500 when DNS lookups time out.
     */
    GATEWAY_TIMEOUT(504, "Gateway Timeout"),
    /**
     * The server does not support, or refuses to support, the HTTP protocol version that was used in the request
     * message. The server is indicating that it is unable or unwilling to complete the request using the same major
     * version as the client, as described in section 3.1, other than with this error message. The response SHOULD
     * contain an entity describing why that version is not supported and what other protocols are supported by that
     * server.
     */
    HTTP_NOT_SUPPORTED(505, "HTTP Version Not Supported"),

    /**
     * The 506 status code indicates that the server has an internal configuration error: the chosen variant resource is
     * configured to engage in transparent content negotiation itself, and is therefore not a proper end point in the
     * negotiation process.
     */
    VARIANT_ALSO_NEGOTIATES(506, "Variant Also Negotiates (Experimental)"),
    /**
     * The 507 (Insufficient Storage) status code means the method could not be performed on the resource because the
     * server is unable to store the representation needed to successfully complete the request. This condition is
     * considered to be temporary. If the request that received this status code was the result of a user action, the
     * request MUST NOT be repeated until it is requested by a separate user action.
     */
    INSUFFICIENT_STORAGE(507, "Insufficient Storage (WebDAV)"),
    /**
     * The 508 (Loop Detected) status code indicates that the server terminated an operation because it encountered an
     * infinite loop while processing a request with "Depth: infinity". This status indicates that the entire operation
     * failed.
     */
    LOOP_DETECTED(508, "Loop Detected (WebDAV)"),
    /**
     * Wikipedia
     * This status code, while used by many servers, is not specified in any RFCs.
     */
    BANDWIDTH_LIMIT_EXCEED(509, "Bandwidth Limit Exceeded (Apache)"),
    /**
     * The policy for accessing the resource has not been met in the request. The server should send back all the
     * information necessary for the client to issue an extended request. It is outside the scope of this specification
     * to specify how the extensions inform the client.
     * <p>
     * If the 510 response contains information about extensions that were not present in the initial request then the
     * client MAY repeat the request if it has reason to believe it can fulfill the extension policy by modifying the
     * request according to the information provided in the 510 response. Otherwise the client MAY present any entity
     * included in the 510 response to the user, since that entity may include relevant diagnostic information.
     */
    NOT_EXTENDED(510, "Not Extended"),
    /**
     * The 511 status code indicates that the client needs to authenticate to gain network access.
     * <p>
     * The response representation SHOULD contain a link to a resource that allows the user to submit credentials
     * (e.g. with a HTML form).
     * <p>
     * Note that the 511 response SHOULD NOT contain a challenge or the login interface itself, because browsers would
     * show the login interface as being associated with the originally requested URL, which may cause confusion.
     * <p>
     * The 511 status SHOULD NOT be generated by origin servers; it is intended for use by intercepting proxies that are
     * interposed as a means of controlling access to the network.
     * <p>
     * Responses with the 511 status code MUST NOT be stored by a cache.
     * <p>
     * The 511 status code is designed to mitigate problems caused by "captive portals" to software (especially
     * non-browser agents) that is expecting a response from the server that a request was made to, not the intervening
     * network infrastructure. It is not intended to encouraged deployment of captive portals, only to limit the damage
     * caused by them.
     * <p>
     * A network operator wishing to require some authentication, acceptance of terms or other user interaction before
     * granting access usually does so by identifing clients who have not done so ("unknown clients") using their MAC
     * addresses.
     * <p>
     * Unknown clients then have all traffic blocked, except for that on TCP port 80, which is sent to a HTTP server
     * (the "login server") dedicated to "logging in" unknown clients, and of course traffic to the login server itself.
     * <p>
     * In common use, a response carrying the 511 status code will not come from the origin server indicated in the
     * request's URL. This presents many security issues; e.g., an attacking intermediary may be inserting cookies into
     * the original domain's name space, may be observing cookies or HTTP authentication credentials sent from the user
     * agent, and so on.
     * <p>
     * However, these risks are not unique to the 511 status code; in other words, a captive portal that is not using
     * this status code introduces the same issues.
     * <p>
     * Also, note that captive portals using this status code on an SSL or TLS connection (commonly, port 443) will
     * generate a certificate error on the client.
     */
    NETWORK_AUTH_REQUIRED(511, "Network Authentication Required"),
    /**
     * Wikipedia
     * This status code is not specified in any RFCs, but is used by some HTTP proxies to signal a network read timeout
     * behind the proxy to a client in front of the proxy.
     */
    NETWORK_READ_TIMEOUT_ERROR(598, "Network read timeout error"),
    /**
     * Wikipedia
     * This status code is not specified in any RFCs, but is used by some HTTP proxies to signal a network connect
     * timeout behind the proxy to a client in front of the proxy.
     */
    NETWORK_CONNECT_TIMEOUT_ERROR(599, "Network connect timeout error");

    private final int code;
    private final String description;

    ServerError(int code, String description) {
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

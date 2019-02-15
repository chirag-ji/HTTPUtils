package com.chiragji.utils.http.enums;

import com.chiragji.utils.http.interfaces.HTTPCodes;

/**
 * This class of status code indicates that further action needs to be taken by the user agent in order to fulfill the
 * request. The action required MAY be carried out by the user agent without interaction with the user if and only if
 * the method used in the second request is GET or HEAD. A client SHOULD detect infinite redirection loops, since such
 * loops generate network traffic for each redirection.
 *
 * <b>Note:-</b> previous versions of this specification recommended a maximum of five redirections. Content developers
 * should be aware that there might be clients that implement such a fixed limitation.
 *
 * @author Chirag Gupta
 */
public enum RedirectionCodes implements HTTPCodes {
    /**
     * The requested resource corresponds to any one of a set of representations, each with its own specific location,
     * and agent- driven negotiation information (section 12) is being provided so that the user (or user agent) can
     * select a preferred representation and redirect its request to that location.
     * <p>
     * Unless it was a HEAD request, the response SHOULD include an entity containing a list of resource characteristics
     * and location(s) from which the user or user agent can choose the one most appropriate. The entity format is
     * specified by the media type given in the Content- Type header field. Depending upon the format and the
     * capabilities of the user agent, selection of the most appropriate choice MAY be performed automatically.
     * However, this specification does not define any standard for such automatic selection.
     * <p>
     * If the server has a preferred choice of representation, it SHOULD include the specific URI for that
     * representation in the Location field; user agents MAY use the Location field value for automatic redirection.
     * This response is cacheable unless indicated otherwise.
     */
    MULTIPLE_CHOICES(300, "Multiple Choices"),
    /**
     * The requested resource has been assigned a new permanent URI and any future references to this resource SHOULD
     * use one of the returned URIs. Clients with link editing capabilities ought to automatically re-link references to
     * the Request-URI to one or more of the new references returned by the server, where possible. This response is
     * cacheable unless indicated otherwise.
     * <p>
     * The new permanent URI SHOULD be given by the Location field in the response. Unless the request method was HEAD,
     * the entity of the response SHOULD contain a short hypertext note with a hyperlink to the new URI(s).
     * <p>
     * If the 301 status code is received in response to a request other than GET or HEAD, the user agent MUST NOT
     * automatically redirect the request unless it can be confirmed by the user, since this might change the conditions
     * under which the request was issued.
     * <p>
     * Note: When automatically redirecting a POST request after receiving a 301 status code, some existing HTTP/1.0
     * user agents will erroneously change it into a GET request.
     */
    MOVED_PERMANENTLY(301, "Moved Permanently"),
    /**
     * The requested resource resides temporarily under a different URI. Since the redirection might be altered on
     * occasion, the client SHOULD continue to use the Request-URI for future requests. This response is only cacheable
     * if indicated by a Cache-Control or Expires header field.
     * <p>
     * The temporary URI SHOULD be given by the Location field in the response. Unless the request method was HEAD, the
     * entity of the response SHOULD contain a short hypertext note with a hyperlink to the new URI(s).
     * <p>
     * If the 302 status code is received in response to a request other than GET or HEAD, the user agent MUST NOT
     * automatically redirect the request unless it can be confirmed by the user, since this might change the conditions
     * under which the request was issued.
     * <p>
     * Note: RFC 1945 and RFC 2068 specify that the client is not allowed to change the method on the redirected request.
     * However, most existing user agent implementations treat 302 as if it were a 303 response, performing a GET on the
     * Location field-value regardless of the original request method. The status codes 303 and 307 have been added for
     * servers that wish to make unambiguously clear which kind of reaction is expected of the client.
     */
    FOUND(302, "Found"),
    /**
     * The response to the request can be found under a different URI and SHOULD be retrieved using a GET method on that
     * resource. This method exists primarily to allow the output of a POST-activated script to redirect the user agent
     * to a selected resource. The new URI is not a substitute reference for the originally requested resource. The 303
     * response MUST NOT be cached, but the response to the second (redirected) request might be cacheable.
     * <p>
     * The different URI SHOULD be given by the Location field in the response. Unless the request method was HEAD, the
     * entity of the response SHOULD contain a short hypertext note with a hyperlink to the new URI(s).
     * <p>
     * Note: Many pre-HTTP/1.1 user agents do not understand the 303 status. When interoperability with such clients is
     * a concern, the 302 status code may be used instead, since most user agents react to a 302 response as described
     * here for 303.
     */
    SEE_OTHER(303, "See Other"),
    /**
     * If the client has performed a conditional GET request and access is allowed, but the document has not been
     * modified, the server SHOULD respond with this status code. The 304 response MUST NOT contain a message-body, and
     * thus is always terminated by the first empty line after the header fields.
     * <p>
     * The response MUST include the following header fields:
     * <UL>
     * <LI>
     * Date, unless its omission is required by section 14.18.1
     * </LI>
     * </UL>
     * <p>
     * If a clockless origin server obeys these rules, and proxies and clients add their own Date to any response
     * received without one (as already specified by [RFC 2068], section 14.19), caches will operate correctly.
     *
     * <UL>
     * <LI>
     * ETag and/or Content-Location, if the header would have been sent in a 200 response to the same request
     * </LI>
     * <LI>
     * Expires, Cache-Control, and/or Vary, if the field-value might differ from that sent in any previous response for
     * the same variant
     * </LI>
     * </UL>
     * <p>
     * If the conditional GET used a strong cache validator (see section 13.3.3), the response SHOULD NOT include other
     * entity-headers. Otherwise (i.e., the conditional GET used a weak validator), the response MUST NOT include other
     * entity-headers; this prevents inconsistencies between cached entity-bodies and updated headers.
     * <p>
     * If a 304 response indicates an entity not currently cached, then the cache MUST disregard the response and repeat
     * the request without the conditional.
     * <p>
     * If a cache uses a received 304 response to update a cache entry, the cache MUST update the entry to reflect any
     * new field values given in the response.
     */
    NOT_MODIFIED(304, "Not Modified"),
    /**
     * The requested resource MUST be accessed through the proxy given by the Location field. The Location field gives
     * the URI of the proxy. The recipient is expected to repeat this single request via the proxy. 305 responses MUST
     * only be generated by origin servers.
     * <p>
     * Note: RFC 2068 was not clear that 305 was intended to redirect a single request, and to be generated by origin
     * servers only. Not observing these limitations has significant security consequences.
     */
    USE_PROXY(305, "Use Proxy"),
    /**
     * The 306 status code was used in a previous version of the specification, is no longer used, and the code is
     * reserved.
     */
    UNUSED(306, "(Unused)"),
    /**
     * The requested resource resides temporarily under a different URI. Since the redirection MAY be altered on
     * occasion, the client SHOULD continue to use the Request-URI for future requests. This response is only cacheable
     * if indicated by a Cache-Control or Expires header field.
     * <p>
     * The temporary URI SHOULD be given by the Location field in the response. Unless the request method was HEAD, the
     * entity of the response SHOULD contain a short hypertext note with a hyperlink to the new URI(s) , since many
     * pre-HTTP/1.1 user agents do not understand the 307 status. Therefore, the note SHOULD contain the information
     * necessary for a user to repeat the original request on the new URI.
     * <p>
     * If the 307 status code is received in response to a request other than GET or HEAD, the user agent MUST NOT
     * automatically redirect the request unless it can be confirmed by the user, since this might change the conditions
     * under which the request was issued.
     */
    TEMP_REDIRECT(307, "Temporary Redirect"),
    /**
     * <B>Wikipedia:-</B>
     * The request, and all future requests should be repeated using another URI. 307 and 308 (as proposed) parallel the
     * behaviours of 302 and 301, but do not require the HTTP method to change. So, for example, submitting a form to a
     * permanently redirected resource may continue smoothly.
     */
    PERMANENT_REDIRECT(308, "Permanent Redirect (experimental)");

    private final int code;
    private final String description;

    RedirectionCodes(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public int getCode() {
        return code;
    }
}

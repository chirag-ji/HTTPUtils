package com.chiragji.utils.http.enums;

import com.chiragji.utils.http.interfaces.HTTPCodes;

/**
 * This class of status code indicates that the client's request was successfully received, understood, and accepted.
 *
 * @author Chirag Gupta
 */
public enum SuccessCodes implements HTTPCodes {
    /**
     * The request has succeeded. The information returned with the response is dependent on the method used in the
     * request, for example:
     *
     * <ul>
     * <li>
     * <b>GET</b>  an entity corresponding to the requested resource is sent in the response;
     * </li>
     * <li>
     * <b>HEAD</b> the entity-header fields corresponding to the requested resource are sent in the response without
     * any message-body;
     * </li>
     * <li>
     * <b>POST</b> an entity describing or containing the result of the action;
     * </li>
     * <li>
     * <b>TRACE</b> an entity containing the request message as received by the end server.
     * </li>
     * </ul>
     */
    OK(200, "OK"),
    /**
     * The request has been fulfilled and resulted in a new resource being created. The newly created resource can be
     * referenced by the URI(s) returned in the entity of the response, with the most specific URI for the resource
     * given by a Location header field. The response SHOULD include an entity containing a list of resource
     * characteristics and location(s) from which the user or user agent can choose the one most appropriate.
     * The entity format is specified by the media type given in the Content-Type header field. The origin server MUST
     * create the resource before returning the 201 status code. If the action cannot be carried out immediately,
     * the server SHOULD respond with 202 (Accepted) response instead.
     * <p>
     * A 201 response MAY contain an ETag response header field indicating the current value of the entity tag for the
     * requested variant just created, see section 14.19.
     */
    CREATED(201, "Created"),
    /**
     * The request has been accepted for processing, but the processing has not been completed. The request might or
     * might not eventually be acted upon, as it might be disallowed when processing actually takes place. There is no
     * facility for re-sending a status code from an asynchronous operation such as this.
     * <p>
     * The 202 response is intentionally non-committal. Its purpose is to allow a server to accept a request for some
     * other process (perhaps a batch-oriented process that is only run once per day) without requiring that the user
     * agent's connection to the server persist until the process is completed. The entity returned with this response
     * SHOULD include an indication of the request's current status and either a pointer to a status monitor or some
     * estimate of when the user can expect the request to be fulfilled.
     */
    ACCEPTED(202, "Accepted"),
    /**
     * The returned metainformation in the entity-header is not the definitive set as available from the origin server,
     * but is gathered from a local or a third-party copy. The set presented MAY be a subset or superset of the original
     * version. For example, including local annotation information about the resource might result in a superset of the
     * metainformation known by the origin server. Use of this response code is not required and is only appropriate when
     * the response would otherwise be 200 (OK).
     */
    NON_AUTHORITATIVE_INFO(203, "Non-Authoritative Information"),
    /**
     * The server has fulfilled the request but does not need to return an entity-body, and might want to return updated
     * metainformation. The response MAY include new or updated metainformation in the form of entity-headers, which if
     * present SHOULD be associated with the requested variant.
     * <p>
     * If the client is a user agent, it SHOULD NOT change its document view from that which caused the request to be
     * sent. This response is primarily intended to allow input for actions to take place without causing a change to
     * the user agent's active document view, although any new or updated metainformation SHOULD be applied to the
     * document currently in the user agent's active view.
     * <p>
     * The 204 response MUST NOT include a message-body, and thus is always terminated by the first empty line after the
     * header fields.
     */
    NO_CONTENT(204, "No Content"),
    /**
     * The server has fulfilled the request and the user agent SHOULD reset the document view which caused the request
     * to be sent. This response is primarily intended to allow input for actions to take place via user input, followed
     * by a clearing of the form in which the input is given so that the user can easily initiate another input action.
     * The response MUST NOT include an entity.
     */
    RESET_CONTENT(205, "Reset Content"),
    /**
     * The server has fulfilled the partial GET request for the resource. The request MUST have included a Range header
     * field (section 14.35) indicating the desired range, and MAY have included an If-Range header field (section 14.27)
     * to make the request conditional.
     * <p>
     * The response MUST include the following header fields:
     * <ul>
     * <li>
     * Either a Content-Range header field (section 14.16) indicating the range included with this response, or a
     * multipart/byteranges Content-Type including Content-Range fields for each part. If a Content-Length header field
     * is present in the response, its value MUST match the actual number of OCTETs transmitted in the message-body.
     * </li>
     * <li>
     * Date
     * </li>
     * <li>
     * ETag and/or Content-Location, if the header would have been sent in a 200 response to the same request
     * </li>
     * <li>
     * Expires, Cache-Control, and/or Vary, if the field-value might differ from that sent in any previous response for
     * the same variant
     * </li>
     * </ul>
     * <p>
     * If the 206 response is the result of an If-Range request that used a strong cache validator (see section 13.3.3),
     * the response SHOULD NOT include other entity-headers. If the response is the result of an If-Range request that
     * used a weak validator, the response MUST NOT include other entity-headers; this prevents inconsistencies between
     * cached entity-bodies and updated headers. Otherwise, the response MUST include all of the entity-headers that
     * would have been returned with a 200 (OK) response to the same request.
     * <p>
     * A cache MUST NOT combine a 206 response with other previously cached content if the ETag or Last-Modified headers
     * do not match exactly, see 13.5.4.
     * <p>
     * A cache that does not support the Range and Content-Range headers MUST NOT cache 206 (Partial) responses.
     */
    PARTIAL_CONTENT(206, "Partial Content"),
    /**
     * The 207 (Multi-Status) status code provides status for multiple independent operations (section 11).
     */
    MULTI_STATUS(207, "Multi-Status (WebDAV)"),
    /**
     * The 208 (Already Reported) status code can be used inside a DAV: propstat response element to avoid enumerating
     * the internal members of multiple bindings to the same collection repeatedly. For each binding to a collection
     * inside the request's scope, only one will be reported with a 200 status, while subsequent DAV:response elements
     * for all other bindings will use the 208 status, and no DAV:response elements for their descendants are included.
     */
    ALREADY_REPORTED(208, "Already Reported (WebDAV)"),
    /**
     * The server has fulfilled a GET request for the resource, and the response is a representation of the result of
     * one or more instance-manipulations applied to the current instance. The actual current instance might not be
     * available except by combining this response with other previous or future responses, as appropriate for the
     * specific instance-manipulation(s). If so, the headers of the resulting instance are the result of combining
     * the headers from the status-226 response and the other instances, following the rules in section 13.5.3 of
     * the HTTP/1.1 specification.
     * <p>
     * The request MUST have included an A-IM header field listing at least one instance-manipulation. The response
     * MUST include an Etag header field giving the entity tag of the current instance.
     * <p>
     * A response received with a status code of 226 MAY be stored by a cache and used in reply to a subsequent request,
     * subject to the HTTP expiration mechanism and any Cache-Control headers, and to the requirements in section 10.6.
     * <p>
     * A response received with a status code of 226 MAY be used by a cache, in conjunction with a cache entry for the
     * base instance, to create a cache entry for the current instance.
     */
    IM_USED(226, "IM Used");

    private final int code;
    private final String description;

    SuccessCodes(int code, String description) {
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

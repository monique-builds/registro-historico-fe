/*
 *  SIGES
 *  Desarrollado por Sofis Solutions
 */
package sv.gob.mined.siges.web.excepciones;

import javax.ws.rs.core.Response;

public class HttpServerException extends Exception {

    private static final long serialVersionUID = 1L;
    private Integer code;
    private String content;

    public HttpServerException(Response response) {
        code = response.getStatus();
        content = response.readEntity(String.class);
    }

    @Override
    public String getMessage() {
        return "HTTP Error " + code + " : " + content;
    }

    public int getCode() {
        return code;
    }
}

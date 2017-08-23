
package mx.com.findep.imagenes;

import javax.jws.WebService;

@WebService(endpointInterface = "mx.com.findep.imagenes.HelloWorld")
public class HelloWorldImpl implements HelloWorld {

    public String sayHi(String text) {
        return "Hello " + text;
    }
}


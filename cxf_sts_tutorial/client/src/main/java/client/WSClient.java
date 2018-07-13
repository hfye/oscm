package client;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;

import org.apache.cxf.ws.security.SecurityConstants;

import service.intf.CountingService;
import service.intf.DoubleItPortType;

public class WSClient {

    public static void main(String[] args) throws MalformedURLException {

        Service doubleItService = Service.create(
                new URL("http://localhost:8080/doubleit/services/doubleit?wsdl"),
                new QName("http://www.example.org/contract/DoubleIt",
                        "DoubleItService"));

        DoubleItPortType port = (DoubleItPortType) doubleItService
                .getPort(DoubleItPortType.class);
        addToContex((BindingProvider) port);

        int toBeDoubled = 31;
        int doubleIt = port.doubleIt(toBeDoubled);
        System.out.println("DOUBLED " + toBeDoubled + " IS: " + doubleIt);

        Service countingService = Service.create(
                new URL("http://localhost:8080/doubleit/services/CountingService?wsdl"),
                new QName("http://oscm.org/xsd", "CountingService"));

        CountingService count = (CountingService) countingService
                .getPort(CountingService.class);
        addToContex((BindingProvider) count);

        int sum = count.sum(5, 88);
        System.out.println("SUM IS: " + sum);
    }

    public static void addToContex(BindingProvider bindingProvider) {

        Map<String, Object> context = ((BindingProvider) bindingProvider)
                .getRequestContext();
        context.put(SecurityConstants.CALLBACK_HANDLER,
                new ClientCallbackHandler());
        context.put(SecurityConstants.ENCRYPT_PROPERTIES,
                "/clientKeystore.properties");
        context.put(SecurityConstants.ENCRYPT_USERNAME, "mystskey");
        context.put(SecurityConstants.USERNAME, "alice");

        // context.put(SecurityConstants.CALLBACK_HANDLER + ".it", new
        // ClientCallbackHandler());
        // context.put(SecurityConstants.ENCRYPT_PROPERTIES + ".it",
        // "/clientKeystore.properties");
        // context.put(SecurityConstants.ENCRYPT_USERNAME + ".it", "mystskey");
        // alias name in the keystore to get the user's public key to send to
        // the STS
        // context.put(SecurityConstants.STS_TOKEN_USERNAME + ".it",
        // "myclientkey");
        // Crypto property configuration to use for the STS
        // context.put(SecurityConstants.STS_TOKEN_PROPERTIES + ".it",
        // "/clientKeystore.properties");
        // write out an X509Certificate structure in UseKey/KeyInfo
        // context.put(SecurityConstants.STS_TOKEN_USE_CERT_FOR_KEYINFO + ".it",
        // "true");
        // Setting indicates the STSclient should not try using the
        // WS-MetadataExchange
        // call using STS EPR WSA address when the endpoint contract does not
        // contain
        // WS-MetadataExchange info.
        // context.put("ws-security.sts.disable-wsmex-call-using-epr-address",
        // "true");
    }

    public static void doubleIt(DoubleItPortType port, int numToDouble) {
        int resp = port.doubleIt(numToDouble);
        System.out.println("The number " + numToDouble + " doubled is " + resp);
    }
}

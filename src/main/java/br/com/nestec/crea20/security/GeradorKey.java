package br.com.nestec.crea20.security;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;

public class GeradorKey {

    public Key geradorKey() {
        String keyString = "secret"; //SHA-256 e EncodeBase64	}
        Key key = new SecretKeySpec(keyString.getBytes(), 0, keyString.getBytes().length, "HMACSHA256");
        return key;
    }
}

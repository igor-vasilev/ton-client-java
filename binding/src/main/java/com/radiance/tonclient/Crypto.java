package com.radiance.tonclient;

import java.util.concurrent.CompletableFuture;
import java.util.stream.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Arrays;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *  
 */
public class Crypto {

    public static abstract class EncryptionAlgorithm {

    /**
     *  
     */
    public static class AES extends EncryptionAlgorithm  {

        public AES(Object value) {

            this.value = value;

        }
        public AES() {

        }


        @JsonProperty("value")
        private Object value;
        /**
         * 
         */
        public Object getValue() {
            return value;
        }
        /**
         * 
         */
        public void setValue(Object value) {
            this.value = value;
        }


        @Override
        public String toString() {
            return "{"+Stream.of("\"type\":\"AES\"",(value==null?null:("\"value\":"+value))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
        }
    }

    /**
     *  
     */
    public static class ChaCha20 extends EncryptionAlgorithm  {

        public ChaCha20(Object value) {

            this.value = value;

        }
        public ChaCha20() {

        }


        @JsonProperty("value")
        private Object value;
        /**
         * 
         */
        public Object getValue() {
            return value;
        }
        /**
         * 
         */
        public void setValue(Object value) {
            this.value = value;
        }


        @Override
        public String toString() {
            return "{"+Stream.of("\"type\":\"ChaCha20\"",(value==null?null:("\"value\":"+value))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
        }
    }

    /**
     *  
     */
    public static class NaclBox extends EncryptionAlgorithm  {

        public NaclBox(Object value) {

            this.value = value;

        }
        public NaclBox() {

        }


        @JsonProperty("value")
        private Object value;
        /**
         * 
         */
        public Object getValue() {
            return value;
        }
        /**
         * 
         */
        public void setValue(Object value) {
            this.value = value;
        }


        @Override
        public String toString() {
            return "{"+Stream.of("\"type\":\"NaclBox\"",(value==null?null:("\"value\":"+value))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
        }
    }

    /**
     *  
     */
    public static class NaclSecretBox extends EncryptionAlgorithm  {

        public NaclSecretBox(Object value) {

            this.value = value;

        }
        public NaclSecretBox() {

        }


        @JsonProperty("value")
        private Object value;
        /**
         * 
         */
        public Object getValue() {
            return value;
        }
        /**
         * 
         */
        public void setValue(Object value) {
            this.value = value;
        }


        @Override
        public String toString() {
            return "{"+Stream.of("\"type\":\"NaclSecretBox\"",(value==null?null:("\"value\":"+value))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
        }
    }
}
    public static abstract class CryptoBoxSecret {

    /**
     *  This type should be used upon the first wallet initialization, all further initializationsshould use `EncryptedSecret` type instead.<p>Get `encrypted_secret` with `get_crypto_box_info` function and store it on your side.
     */
    public static class RandomSeedPhrase extends CryptoBoxSecret  {

        public RandomSeedPhrase(MnemonicDictionary dictionary, Number wordcount) {

            this.dictionary = dictionary;

            this.wordcount = wordcount;

        }
        public RandomSeedPhrase(MnemonicDictionary dictionary) {

            this.dictionary = dictionary;

        }
        public RandomSeedPhrase() {

        }


        @JsonProperty("dictionary")
        private MnemonicDictionary dictionary;
        /**
         * 
         */
        public MnemonicDictionary getDictionary() {
            return dictionary;
        }
        /**
         * 
         */
        public void setDictionary(MnemonicDictionary value) {
            this.dictionary = value;
        }

        @JsonProperty("wordcount")
        private Number wordcount;
        /**
         * 
         */
        public Number getWordcount() {
            return wordcount;
        }
        /**
         * 
         */
        public void setWordcount(Number value) {
            this.wordcount = value;
        }


        @Override
        public String toString() {
            return "{"+Stream.of("\"type\":\"RandomSeedPhrase\"",(dictionary==null?null:("\"dictionary\":"+dictionary.ordinal())),(wordcount==null?null:("\"wordcount\":"+wordcount))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
        }
    }

    /**
     *  This type should be used only upon the first wallet initialization, all furtherinitializations should use `EncryptedSecret` type instead.<p>Get `encrypted_secret` with `get_crypto_box_info` function and store it on your side.
     */
    public static class PredefinedSeedPhrase extends CryptoBoxSecret  {

        public PredefinedSeedPhrase(String phrase, MnemonicDictionary dictionary, Number wordcount) {

            this.phrase = phrase;

            this.dictionary = dictionary;

            this.wordcount = wordcount;

        }
        public PredefinedSeedPhrase(String phrase, MnemonicDictionary dictionary) {

            this.phrase = phrase;

            this.dictionary = dictionary;

        }
        public PredefinedSeedPhrase(String phrase) {

            this.phrase = phrase;

        }
        public PredefinedSeedPhrase() {

        }


        @JsonProperty("phrase")
        private String phrase;
        /**
         * 
         */
        public String getPhrase() {
            return phrase;
        }
        /**
         * 
         */
        public void setPhrase(String value) {
            this.phrase = value;
        }

        @JsonProperty("dictionary")
        private MnemonicDictionary dictionary;
        /**
         * 
         */
        public MnemonicDictionary getDictionary() {
            return dictionary;
        }
        /**
         * 
         */
        public void setDictionary(MnemonicDictionary value) {
            this.dictionary = value;
        }

        @JsonProperty("wordcount")
        private Number wordcount;
        /**
         * 
         */
        public Number getWordcount() {
            return wordcount;
        }
        /**
         * 
         */
        public void setWordcount(Number value) {
            this.wordcount = value;
        }


        @Override
        public String toString() {
            return "{"+Stream.of("\"type\":\"PredefinedSeedPhrase\"",(phrase==null?null:("\"phrase\":\""+phrase+"\"")),(dictionary==null?null:("\"dictionary\":"+dictionary.ordinal())),(wordcount==null?null:("\"wordcount\":"+wordcount))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
        }
    }

    /**
     *  It is an object, containing seed phrase or private key, encrypted with`secret_encryption_salt` and password from `password_provider`.<p>Note that if you want to change salt or password provider, then you need to reinitializethe wallet with `PredefinedSeedPhrase`, then get `EncryptedSecret` via `get_crypto_box_info`,store it somewhere, and only after that initialize the wallet with `EncryptedSecret` type.
     */
    public static class EncryptedSecret extends CryptoBoxSecret  {

        public EncryptedSecret(String encryptedSecret) {

            this.encryptedSecret = encryptedSecret;

        }
        public EncryptedSecret() {

        }


        @JsonProperty("encrypted_secret")
        private String encryptedSecret;
        /**
         * 
         */
        public String getEncryptedSecret() {
            return encryptedSecret;
        }
        /**
         * 
         */
        public void setEncryptedSecret(String value) {
            this.encryptedSecret = value;
        }


        @Override
        public String toString() {
            return "{"+Stream.of("\"type\":\"EncryptedSecret\"",(encryptedSecret==null?null:("\"encrypted_secret\":\""+encryptedSecret+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
        }
    }
}
    public static abstract class BoxEncryptionAlgorithm {

    /**
     *  
     */
    public static class ChaCha20 extends BoxEncryptionAlgorithm  {

        public ChaCha20(Object value) {

            this.value = value;

        }
        public ChaCha20() {

        }


        @JsonProperty("value")
        private Object value;
        /**
         * 
         */
        public Object getValue() {
            return value;
        }
        /**
         * 
         */
        public void setValue(Object value) {
            this.value = value;
        }


        @Override
        public String toString() {
            return "{"+Stream.of("\"type\":\"ChaCha20\"",(value==null?null:("\"value\":"+value))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
        }
    }

    /**
     *  
     */
    public static class NaclBox extends BoxEncryptionAlgorithm  {

        public NaclBox(Object value) {

            this.value = value;

        }
        public NaclBox() {

        }


        @JsonProperty("value")
        private Object value;
        /**
         * 
         */
        public Object getValue() {
            return value;
        }
        /**
         * 
         */
        public void setValue(Object value) {
            this.value = value;
        }


        @Override
        public String toString() {
            return "{"+Stream.of("\"type\":\"NaclBox\"",(value==null?null:("\"value\":"+value))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
        }
    }

    /**
     *  
     */
    public static class NaclSecretBox extends BoxEncryptionAlgorithm  {

        public NaclSecretBox(Object value) {

            this.value = value;

        }
        public NaclSecretBox() {

        }


        @JsonProperty("value")
        private Object value;
        /**
         * 
         */
        public Object getValue() {
            return value;
        }
        /**
         * 
         */
        public void setValue(Object value) {
            this.value = value;
        }


        @Override
        public String toString() {
            return "{"+Stream.of("\"type\":\"NaclSecretBox\"",(value==null?null:("\"value\":"+value))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
        }
    }
}

    /**
     *  
     */
    public enum MnemonicDictionary {
        
        /**
         * 
         */
        Ton,

        /**
         * 
         */
        English,

        /**
         * 
         */
        ChineseSimplified,

        /**
         * 
         */
        ChineseTraditional,

        /**
         * 
         */
        French,

        /**
         * 
         */
        Italian,

        /**
         * 
         */
        Japanese,

        /**
         * 
         */
        Korean,

        /**
         * 
         */
        Spanish
    }
    /**
     *  
     */
    public static class KeyPair  {

        public KeyPair(String publicKey, String secretKey) {

            this.publicKey = publicKey;

            this.secretKey = secretKey;

        }
        public KeyPair(String publicKey) {

            this.publicKey = publicKey;

        }
        public KeyPair() {

        }


        @JsonProperty("public")
        private String publicKey;
        /**
         * 
         */
        public String getPublic() {
            return publicKey;
        }
        /**
         * 
         */
        public void setPublic(String value) {
            this.publicKey = value;
        }

        @JsonProperty("secret")
        private String secretKey;
        /**
         * 
         */
        public String getSecret() {
            return secretKey;
        }
        /**
         * 
         */
        public void setSecret(String value) {
            this.secretKey = value;
        }


        @Override
        public String toString() {
            return "{"+Stream.of((publicKey==null?null:("\"public\":\""+publicKey+"\"")),(secretKey==null?null:("\"secret\":\""+secretKey+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
        }
    }
    /**
     *  
     */
    public static class ResultOfSign  {

        public ResultOfSign(String signed, String signature) {

            this.signed = signed;

            this.signature = signature;

        }
        public ResultOfSign(String signed) {

            this.signed = signed;

        }
        public ResultOfSign() {

        }


        @JsonProperty("signed")
        private String signed;
        /**
         * 
         */
        public String getSigned() {
            return signed;
        }
        /**
         * 
         */
        public void setSigned(String value) {
            this.signed = value;
        }

        @JsonProperty("signature")
        private String signature;
        /**
         * 
         */
        public String getSignature() {
            return signature;
        }
        /**
         * 
         */
        public void setSignature(String value) {
            this.signature = value;
        }


        @Override
        public String toString() {
            return "{"+Stream.of((signed==null?null:("\"signed\":\""+signed+"\"")),(signature==null?null:("\"signature\":\""+signature+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
        }
    }
    /**
     *  
     */
    public static class ResultOfGetCryptoBoxSeedPhrase  {

        public ResultOfGetCryptoBoxSeedPhrase(String phrase, MnemonicDictionary dictionary, Number wordcount) {

            this.phrase = phrase;

            this.dictionary = dictionary;

            this.wordcount = wordcount;

        }
        public ResultOfGetCryptoBoxSeedPhrase(String phrase, MnemonicDictionary dictionary) {

            this.phrase = phrase;

            this.dictionary = dictionary;

        }
        public ResultOfGetCryptoBoxSeedPhrase(String phrase) {

            this.phrase = phrase;

        }
        public ResultOfGetCryptoBoxSeedPhrase() {

        }


        @JsonProperty("phrase")
        private String phrase;
        /**
         * 
         */
        public String getPhrase() {
            return phrase;
        }
        /**
         * 
         */
        public void setPhrase(String value) {
            this.phrase = value;
        }

        @JsonProperty("dictionary")
        private MnemonicDictionary dictionary;
        /**
         * 
         */
        public MnemonicDictionary getDictionary() {
            return dictionary;
        }
        /**
         * 
         */
        public void setDictionary(MnemonicDictionary value) {
            this.dictionary = value;
        }

        @JsonProperty("wordcount")
        private Number wordcount;
        /**
         * 
         */
        public Number getWordcount() {
            return wordcount;
        }
        /**
         * 
         */
        public void setWordcount(Number value) {
            this.wordcount = value;
        }


        @Override
        public String toString() {
            return "{"+Stream.of((phrase==null?null:("\"phrase\":\""+phrase+"\"")),(dictionary==null?null:("\"dictionary\":"+dictionary.ordinal())),(wordcount==null?null:("\"wordcount\":"+wordcount))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
        }
    }
    public static abstract class ParamsOfAppSigningBox {

        public static final GetPublicKey GetPublicKey = new GetPublicKey();

    /**
     *  
     */
    public static class GetPublicKey extends ParamsOfAppSigningBox  {

        public GetPublicKey() {

        }



        @Override
        public String toString() {
            return "{"+"\"type\":\"GetPublicKey\""+"}";
        }
    }

    /**
     *  
     */
    public static class Sign extends ParamsOfAppSigningBox  {

        public Sign(String unsigned) {

            this.unsigned = unsigned;

        }
        public Sign() {

        }


        @JsonProperty("unsigned")
        private String unsigned;
        /**
         * 
         */
        public String getUnsigned() {
            return unsigned;
        }
        /**
         * 
         */
        public void setUnsigned(String value) {
            this.unsigned = value;
        }


        @Override
        public String toString() {
            return "{"+Stream.of("\"type\":\"Sign\"",(unsigned==null?null:("\"unsigned\":\""+unsigned+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
        }
    }
}
    public static abstract class ResultOfAppSigningBox {

    /**
     *  
     */
    public static class GetPublicKey extends ResultOfAppSigningBox  {

        public GetPublicKey(String publicKey) {

            this.publicKey = publicKey;

        }
        public GetPublicKey() {

        }


        @JsonProperty("public_key")
        private String publicKey;
        /**
         * 
         */
        public String getPublicKey() {
            return publicKey;
        }
        /**
         * 
         */
        public void setPublicKey(String value) {
            this.publicKey = value;
        }


        @Override
        public String toString() {
            return "{"+Stream.of("\"type\":\"GetPublicKey\"",(publicKey==null?null:("\"public_key\":\""+publicKey+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
        }
    }

    /**
     *  
     */
    public static class Sign extends ResultOfAppSigningBox  {

        public Sign(String signature) {

            this.signature = signature;

        }
        public Sign() {

        }


        @JsonProperty("signature")
        private String signature;
        /**
         * 
         */
        public String getSignature() {
            return signature;
        }
        /**
         * 
         */
        public void setSignature(String value) {
            this.signature = value;
        }


        @Override
        public String toString() {
            return "{"+Stream.of("\"type\":\"Sign\"",(signature==null?null:("\"signature\":\""+signature+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
        }
    }
}
    public static abstract class ParamsOfAppEncryptionBox {

        public static final GetInfo GetInfo = new GetInfo();

    /**
     *  
     */
    public static class GetInfo extends ParamsOfAppEncryptionBox  {

        public GetInfo() {

        }



        @Override
        public String toString() {
            return "{"+"\"type\":\"GetInfo\""+"}";
        }
    }

    /**
     *  
     */
    public static class Encrypt extends ParamsOfAppEncryptionBox  {

        public Encrypt(String data) {

            this.data = data;

        }
        public Encrypt() {

        }


        @JsonProperty("data")
        private String data;
        /**
         * 
         */
        public String getData() {
            return data;
        }
        /**
         * 
         */
        public void setData(String value) {
            this.data = value;
        }


        @Override
        public String toString() {
            return "{"+Stream.of("\"type\":\"Encrypt\"",(data==null?null:("\"data\":\""+data+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
        }
    }

    /**
     *  
     */
    public static class Decrypt extends ParamsOfAppEncryptionBox  {

        public Decrypt(String data) {

            this.data = data;

        }
        public Decrypt() {

        }


        @JsonProperty("data")
        private String data;
        /**
         * 
         */
        public String getData() {
            return data;
        }
        /**
         * 
         */
        public void setData(String value) {
            this.data = value;
        }


        @Override
        public String toString() {
            return "{"+Stream.of("\"type\":\"Decrypt\"",(data==null?null:("\"data\":\""+data+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
        }
    }
}
    public static abstract class ResultOfAppEncryptionBox {

    /**
     *  
     */
    public static class GetInfo extends ResultOfAppEncryptionBox  {

        public GetInfo(Object info) {

            this.info = info;

        }
        public GetInfo() {

        }


        @JsonProperty("info")
        private Object info;
        /**
         * 
         */
        public Object getInfo() {
            return info;
        }
        /**
         * 
         */
        public void setInfo(Object value) {
            this.info = value;
        }


        @Override
        public String toString() {
            return "{"+Stream.of("\"type\":\"GetInfo\"",(info==null?null:("\"info\":"+info))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
        }
    }

    /**
     *  
     */
    public static class Encrypt extends ResultOfAppEncryptionBox  {

        public Encrypt(String data) {

            this.data = data;

        }
        public Encrypt() {

        }


        @JsonProperty("data")
        private String data;
        /**
         * 
         */
        public String getData() {
            return data;
        }
        /**
         * 
         */
        public void setData(String value) {
            this.data = value;
        }


        @Override
        public String toString() {
            return "{"+Stream.of("\"type\":\"Encrypt\"",(data==null?null:("\"data\":\""+data+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
        }
    }

    /**
     *  
     */
    public static class Decrypt extends ResultOfAppEncryptionBox  {

        public Decrypt(String data) {

            this.data = data;

        }
        public Decrypt() {

        }


        @JsonProperty("data")
        private String data;
        /**
         * 
         */
        public String getData() {
            return data;
        }
        /**
         * 
         */
        public void setData(String value) {
            this.data = value;
        }


        @Override
        public String toString() {
            return "{"+Stream.of("\"type\":\"Decrypt\"",(data==null?null:("\"data\":\""+data+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
        }
    }
}
    private TONContext context;

    public Crypto(TONContext context) {
        this.context = context;
    }

   /**
    * Performs prime factorization – decomposition of a composite numberinto a product of smaller prime integers (factors).See <a target="_blank" href="https://en.wikipedia.org/wiki/Integer_factorization">https://en.wikipedia.org/wiki/Integer_factorization</a>
    *
    * @param composite 
    */
    public CompletableFuture<String[]> factorize(String composite) {
        return context.requestJSON("crypto.factorize", "{"+(composite==null?"":("\"composite\":\""+composite+"\""))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("factors"), String[].class));
    }

   /**
    * Performs modular exponentiation for big integers (`base`^`exponent` mod `modulus`).See <a target="_blank" href="https://en.wikipedia.org/wiki/Modular_exponentiation">https://en.wikipedia.org/wiki/Modular_exponentiation</a>
    *
    * @param base 
    * @param exponent 
    * @param modulus 
    */
    public CompletableFuture<String> modularPower(String base, String exponent, String modulus) {
        return context.requestJSON("crypto.modular_power", "{"+Stream.of((base==null?null:("\"base\":\""+base+"\"")),(exponent==null?null:("\"exponent\":\""+exponent+"\"")),(modulus==null?null:("\"modulus\":\""+modulus+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("modular_power"), String.class));
    }

   /**
    * 
    *
    * @param data Encoded with `base64`.
    */
    public CompletableFuture<Number> tonCrc16(String data) {
        return context.requestJSON("crypto.ton_crc16", "{"+(data==null?"":("\"data\":\""+data+"\""))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("crc"), Number.class));
    }

   /**
    * 
    *
    * @param length 
    */
    public CompletableFuture<String> generateRandomBytes(Number length) {
        return context.requestJSON("crypto.generate_random_bytes", "{"+(length==null?"":("\"length\":"+length))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("bytes"), String.class));
    }

   /**
    * 
    *
    * @param publicKey 
    */
    public CompletableFuture<String> convertPublicKeyToTonSafeFormat(String publicKey) {
        return context.requestJSON("crypto.convert_public_key_to_ton_safe_format", "{"+(publicKey==null?"":("\"public_key\":\""+publicKey+"\""))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("ton_public_key"), String.class));
    }

   /**
    * 
    *
    */
    public CompletableFuture<KeyPair> generateRandomSignKeys() {
        return context.requestJSON("crypto.generate_random_sign_keys", "{}")
            .thenApply(json -> TONContext.convertValue(json, KeyPair.class));
    }

   /**
    * 
    *
    * @param unsigned 
    * @param keys 
    */
    public CompletableFuture<ResultOfSign> sign(String unsigned, KeyPair keys) {
        return context.requestJSON("crypto.sign", "{"+Stream.of((unsigned==null?null:("\"unsigned\":\""+unsigned+"\"")),(keys==null?null:("\"keys\":"+keys))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json, ResultOfSign.class));
    }

   /**
    * 
    *
    * @param signed 
    * @param publicKey 
    */
    public CompletableFuture<String> verifySignature(String signed, String publicKey) {
        return context.requestJSON("crypto.verify_signature", "{"+Stream.of((signed==null?null:("\"signed\":\""+signed+"\"")),(publicKey==null?null:("\"public\":\""+publicKey+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("unsigned"), String.class));
    }

   /**
    * 
    *
    * @param data Encoded with `base64`.
    * @return Encoded with 'hex'.
    */
    public CompletableFuture<String> sha256(String data) {
        return context.requestJSON("crypto.sha256", "{"+(data==null?"":("\"data\":\""+data+"\""))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("hash"), String.class));
    }

   /**
    * 
    *
    * @param data Encoded with `base64`.
    * @return Encoded with 'hex'.
    */
    public CompletableFuture<String> sha512(String data) {
        return context.requestJSON("crypto.sha512", "{"+(data==null?"":("\"data\":\""+data+"\""))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("hash"), String.class));
    }

   /**
    * Derives key from `password` and `key` using `scrypt` algorithm.See <a target="_blank" href="https://en.wikipedia.org/wiki/Scrypt">https://en.wikipedia.org/wiki/Scrypt</a>.<p># Arguments- `log_n` - The log2 of the Scrypt parameter `N`- `r` - The Scrypt parameter `r`- `p` - The Scrypt parameter `p`# Conditions- `log_n` must be less than `64`- `r` must be greater than `0` and less than or equal to `4294967295`- `p` must be greater than `0` and less than `4294967295`# Recommended values sufficient for most use-cases- `log_n = 15` (`n = 32768`)- `r = 8`- `p = 1`
    *
    * @param password 
    * @param salt 
    * @param logN 
    * @param r 
    * @param p 
    * @param dkLen 
    * @return Encoded with `hex`.
    */
    public CompletableFuture<String> scrypt(String password, String salt, Number logN, Number r, Number p, Number dkLen) {
        return context.requestJSON("crypto.scrypt", "{"+Stream.of((password==null?null:("\"password\":\""+password+"\"")),(salt==null?null:("\"salt\":\""+salt+"\"")),(logN==null?null:("\"log_n\":"+logN)),(r==null?null:("\"r\":"+r)),(p==null?null:("\"p\":"+p)),(dkLen==null?null:("\"dk_len\":"+dkLen))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("key"), String.class));
    }

   /**
    * **NOTE:** In the result the secret key is actually the concatenationof secret and public keys (128 symbols hex string) by design of <a target="_blank" href="NaCL](http://nacl.cr.yp.to/sign.html).See also [the stackexchange question">NaCL](http://nacl.cr.yp.to/sign.html).See also [the stackexchange question</a>(https://crypto.stackexchange.com/questions/54353/).
    *
    * @param secretKey 
    */
    public CompletableFuture<KeyPair> naclSignKeypairFromSecretKey(String secretKey) {
        return context.requestJSON("crypto.nacl_sign_keypair_from_secret_key", "{"+(secretKey==null?"":("\"secret\":\""+secretKey+"\""))+"}")
            .thenApply(json -> TONContext.convertValue(json, KeyPair.class));
    }

   /**
    * 
    *
    * @param unsigned 
    * @param secretKey 
    */
    public CompletableFuture<String> naclSign(String unsigned, String secretKey) {
        return context.requestJSON("crypto.nacl_sign", "{"+Stream.of((unsigned==null?null:("\"unsigned\":\""+unsigned+"\"")),(secretKey==null?null:("\"secret\":\""+secretKey+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("signed"), String.class));
    }

   /**
    * Verifies the signature in `signed` using the signer's public key `public`and returns the message `unsigned`.<p>If the signature fails verification, crypto_sign_open raises an exception.
    *
    * @param signed Encoded with `base64`.
    * @param publicKey 
    */
    public CompletableFuture<String> naclSignOpen(String signed, String publicKey) {
        return context.requestJSON("crypto.nacl_sign_open", "{"+Stream.of((signed==null?null:("\"signed\":\""+signed+"\"")),(publicKey==null?null:("\"public\":\""+publicKey+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("unsigned"), String.class));
    }

   /**
    * Signs the message `unsigned` using the secret key `secret`and returns a signature `signature`.
    *
    * @param unsigned 
    * @param secretKey 
    */
    public CompletableFuture<String> naclSignDetached(String unsigned, String secretKey) {
        return context.requestJSON("crypto.nacl_sign_detached", "{"+Stream.of((unsigned==null?null:("\"unsigned\":\""+unsigned+"\"")),(secretKey==null?null:("\"secret\":\""+secretKey+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("signature"), String.class));
    }

   /**
    * 
    *
    * @param unsigned Encoded with `base64`.
    * @param signature Encoded with `hex`.
    * @param publicKey 
    */
    public CompletableFuture<Boolean> naclSignDetachedVerify(String unsigned, String signature, String publicKey) {
        return context.requestJSON("crypto.nacl_sign_detached_verify", "{"+Stream.of((unsigned==null?null:("\"unsigned\":\""+unsigned+"\"")),(signature==null?null:("\"signature\":\""+signature+"\"")),(publicKey==null?null:("\"public\":\""+publicKey+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("succeeded"), Boolean.class));
    }

   /**
    * 
    *
    */
    public CompletableFuture<KeyPair> naclBoxKeypair() {
        return context.requestJSON("crypto.nacl_box_keypair", "{}")
            .thenApply(json -> TONContext.convertValue(json, KeyPair.class));
    }

   /**
    * 
    *
    * @param secretKey 
    */
    public CompletableFuture<KeyPair> naclBoxKeypairFromSecretKey(String secretKey) {
        return context.requestJSON("crypto.nacl_box_keypair_from_secret_key", "{"+(secretKey==null?"":("\"secret\":\""+secretKey+"\""))+"}")
            .thenApply(json -> TONContext.convertValue(json, KeyPair.class));
    }

   /**
    * Encrypt and authenticate a message using the senders secret key, the receivers publickey, and a nonce.
    *
    * @param decrypted 
    * @param nonce 
    * @param theirPublic 
    * @param secretKey 
    */
    public CompletableFuture<String> naclBox(String decrypted, String nonce, String theirPublic, String secretKey) {
        return context.requestJSON("crypto.nacl_box", "{"+Stream.of((decrypted==null?null:("\"decrypted\":\""+decrypted+"\"")),(nonce==null?null:("\"nonce\":\""+nonce+"\"")),(theirPublic==null?null:("\"their_public\":\""+theirPublic+"\"")),(secretKey==null?null:("\"secret\":\""+secretKey+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("encrypted"), String.class));
    }

   /**
    * 
    *
    * @param encrypted Encoded with `base64`.
    * @param nonce 
    * @param theirPublic 
    * @param secretKey 
    */
    public CompletableFuture<String> naclBoxOpen(String encrypted, String nonce, String theirPublic, String secretKey) {
        return context.requestJSON("crypto.nacl_box_open", "{"+Stream.of((encrypted==null?null:("\"encrypted\":\""+encrypted+"\"")),(nonce==null?null:("\"nonce\":\""+nonce+"\"")),(theirPublic==null?null:("\"their_public\":\""+theirPublic+"\"")),(secretKey==null?null:("\"secret\":\""+secretKey+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("decrypted"), String.class));
    }

   /**
    * 
    *
    * @param decrypted Encoded with `base64`.
    * @param nonce 
    * @param key 
    */
    public CompletableFuture<String> naclSecretBox(String decrypted, String nonce, String key) {
        return context.requestJSON("crypto.nacl_secret_box", "{"+Stream.of((decrypted==null?null:("\"decrypted\":\""+decrypted+"\"")),(nonce==null?null:("\"nonce\":\""+nonce+"\"")),(key==null?null:("\"key\":\""+key+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("encrypted"), String.class));
    }

   /**
    * 
    *
    * @param encrypted Encoded with `base64`.
    * @param nonce 
    * @param key 
    */
    public CompletableFuture<String> naclSecretBoxOpen(String encrypted, String nonce, String key) {
        return context.requestJSON("crypto.nacl_secret_box_open", "{"+Stream.of((encrypted==null?null:("\"encrypted\":\""+encrypted+"\"")),(nonce==null?null:("\"nonce\":\""+nonce+"\"")),(key==null?null:("\"key\":\""+key+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("decrypted"), String.class));
    }

   /**
    * 
    *
    * @param dictionary 
    */
    public CompletableFuture<String> mnemonicWords(MnemonicDictionary dictionary) {
        return context.requestJSON("crypto.mnemonic_words", "{"+(dictionary==null?"":("\"dictionary\":"+dictionary.ordinal()))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("words"), String.class));
    }

   /**
    * Generates a random mnemonic from the specified dictionary and word count
    *
    * @param dictionary 
    * @param wordCount 
    */
    public CompletableFuture<String> mnemonicFromRandom(MnemonicDictionary dictionary, Number wordCount) {
        return context.requestJSON("crypto.mnemonic_from_random", "{"+Stream.of((dictionary==null?null:("\"dictionary\":"+dictionary.ordinal())),(wordCount==null?null:("\"word_count\":"+wordCount))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("phrase"), String.class));
    }

   /**
    * 
    *
    * @param entropy Hex encoded.
    * @param dictionary 
    * @param wordCount 
    */
    public CompletableFuture<String> mnemonicFromEntropy(String entropy, MnemonicDictionary dictionary, Number wordCount) {
        return context.requestJSON("crypto.mnemonic_from_entropy", "{"+Stream.of((entropy==null?null:("\"entropy\":\""+entropy+"\"")),(dictionary==null?null:("\"dictionary\":"+dictionary.ordinal())),(wordCount==null?null:("\"word_count\":"+wordCount))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("phrase"), String.class));
    }

   /**
    * The phrase supplied will be checked for word length and validated according to the checksumspecified in BIP0039.
    *
    * @param phrase 
    * @param dictionary 
    * @param wordCount 
    */
    public CompletableFuture<Boolean> mnemonicVerify(String phrase, MnemonicDictionary dictionary, Number wordCount) {
        return context.requestJSON("crypto.mnemonic_verify", "{"+Stream.of((phrase==null?null:("\"phrase\":\""+phrase+"\"")),(dictionary==null?null:("\"dictionary\":"+dictionary.ordinal())),(wordCount==null?null:("\"word_count\":"+wordCount))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("valid"), Boolean.class));
    }

   /**
    * Validates the seed phrase, generates master key and then derivesthe key pair from the master key and the specified path
    *
    * @param phrase 
    * @param path 
    * @param dictionary 
    * @param wordCount 
    */
    public CompletableFuture<KeyPair> mnemonicDeriveSignKeys(String phrase, String path, MnemonicDictionary dictionary, Number wordCount) {
        return context.requestJSON("crypto.mnemonic_derive_sign_keys", "{"+Stream.of((phrase==null?null:("\"phrase\":\""+phrase+"\"")),(path==null?null:("\"path\":\""+path+"\"")),(dictionary==null?null:("\"dictionary\":"+dictionary.ordinal())),(wordCount==null?null:("\"word_count\":"+wordCount))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json, KeyPair.class));
    }

   /**
    * 
    *
    * @param phrase 
    * @param dictionary 
    * @param wordCount 
    */
    public CompletableFuture<String> hdkeyXprvFromMnemonic(String phrase, MnemonicDictionary dictionary, Number wordCount) {
        return context.requestJSON("crypto.hdkey_xprv_from_mnemonic", "{"+Stream.of((phrase==null?null:("\"phrase\":\""+phrase+"\"")),(dictionary==null?null:("\"dictionary\":"+dictionary.ordinal())),(wordCount==null?null:("\"word_count\":"+wordCount))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("xprv"), String.class));
    }

   /**
    * 
    *
    * @param xprv 
    * @param childIndex 
    * @param hardened 
    */
    public CompletableFuture<String> hdkeyDeriveFromXprv(String xprv, Number childIndex, Boolean hardened) {
        return context.requestJSON("crypto.hdkey_derive_from_xprv", "{"+Stream.of((xprv==null?null:("\"xprv\":\""+xprv+"\"")),(childIndex==null?null:("\"child_index\":"+childIndex)),(hardened==null?null:("\"hardened\":"+hardened))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("xprv"), String.class));
    }

   /**
    * 
    *
    * @param xprv 
    * @param path 
    */
    public CompletableFuture<String> hdkeyDeriveFromXprvPath(String xprv, String path) {
        return context.requestJSON("crypto.hdkey_derive_from_xprv_path", "{"+Stream.of((xprv==null?null:("\"xprv\":\""+xprv+"\"")),(path==null?null:("\"path\":\""+path+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("xprv"), String.class));
    }

   /**
    * 
    *
    * @param xprv 
    */
    public CompletableFuture<String> hdkeySecretFromXprv(String xprv) {
        return context.requestJSON("crypto.hdkey_secret_from_xprv", "{"+(xprv==null?"":("\"xprv\":\""+xprv+"\""))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("secret"), String.class));
    }

   /**
    * 
    *
    * @param xprv 
    */
    public CompletableFuture<String> hdkeyPublicFromXprv(String xprv) {
        return context.requestJSON("crypto.hdkey_public_from_xprv", "{"+(xprv==null?"":("\"xprv\":\""+xprv+"\""))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("public"), String.class));
    }

   /**
    * 
    *
    * @param data Must be encoded with `base64`.
    * @param key Must be encoded with `hex`.
    * @param nonce Must be encoded with `hex`.
    * @return Encoded with `base64`.
    */
    public CompletableFuture<String> chacha20(String data, String key, String nonce) {
        return context.requestJSON("crypto.chacha20", "{"+Stream.of((data==null?null:("\"data\":\""+data+"\"")),(key==null?null:("\"key\":\""+key+"\"")),(nonce==null?null:("\"nonce\":\""+nonce+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("data"), String.class));
    }

   /**
    * Crypto Box is a root crypto object, that encapsulates some secret (seed phrase usually)in encrypted form and acts as a factory for all crypto primitives used in SDK:keys for signing and encryption, derived from this secret.<p>Crypto Box encrypts original Seed Phrase with salt and password that is retrievedfrom `password_provider` callback, implemented on Application side.<p>When used, decrypted secret shows up in core library's memory for a very short periodof time and then is immediately overwritten with zeroes.
    *
    * @param secretEncryptionSalt 
    * @param secretKey 
    */
    public CompletableFuture<Integer> createCryptoBox(String secretEncryptionSalt, CryptoBoxSecret secretKey) {
        return context.requestJSON("crypto.create_crypto_box", "{"+Stream.of((secretEncryptionSalt==null?null:("\"secret_encryption_salt\":\""+secretEncryptionSalt+"\"")),(secretKey==null?null:("\"secret\":"+secretKey))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("handle"), Integer.class));
    }

   /**
    * 
    *
    * @param handle 
    */
    public CompletableFuture<Void> removeCryptoBox(Integer handle) {
        return context.requestJSON("crypto.remove_crypto_box", "{"+(handle==null?"":("\"handle\":"+handle))+"}")
            .thenApply(json -> TONContext.convertValue(json, Void.class));
    }

   /**
    * 
    *
    * @param handle 
    */
    public CompletableFuture<String> getCryptoBoxInfo(Integer handle) {
        return context.requestJSON("crypto.get_crypto_box_info", "{"+(handle==null?"":("\"handle\":"+handle))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("encrypted_secret"), String.class));
    }

   /**
    * Attention! Store this data in your application for a very short period of time and overwrite it with zeroes ASAP.
    *
    * @param handle 
    */
    public CompletableFuture<ResultOfGetCryptoBoxSeedPhrase> getCryptoBoxSeedPhrase(Integer handle) {
        return context.requestJSON("crypto.get_crypto_box_seed_phrase", "{"+(handle==null?"":("\"handle\":"+handle))+"}")
            .thenApply(json -> TONContext.convertValue(json, ResultOfGetCryptoBoxSeedPhrase.class));
    }

   /**
    * 
    *
    * @param handle 
    * @param hdpath By default, Everscale HD path is used.
    * @param secretLifetime 
    */
    public CompletableFuture<Integer> getSigningBoxFromCryptoBox(Number handle, String hdpath, Number secretLifetime) {
        return context.requestJSON("crypto.get_signing_box_from_crypto_box", "{"+Stream.of((handle==null?null:("\"handle\":"+handle)),(hdpath==null?null:("\"hdpath\":\""+hdpath+"\"")),(secretLifetime==null?null:("\"secret_lifetime\":"+secretLifetime))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("handle"), Integer.class));
    }

   /**
    * Derives encryption keypair from cryptobox secret and hdpath andstores it in cache for `secret_lifetime`or until explicitly cleared by `clear_crypto_box_secret_cache` method.If `secret_lifetime` is not specified - overwrites encryption secret with zeroes immediately afterencryption operation.
    *
    * @param handle 
    * @param hdpath By default, Everscale HD path is used.
    * @param algorithm 
    * @param secretLifetime 
    */
    public CompletableFuture<Integer> getEncryptionBoxFromCryptoBox(Number handle, String hdpath, BoxEncryptionAlgorithm algorithm, Number secretLifetime) {
        return context.requestJSON("crypto.get_encryption_box_from_crypto_box", "{"+Stream.of((handle==null?null:("\"handle\":"+handle)),(hdpath==null?null:("\"hdpath\":\""+hdpath+"\"")),(algorithm==null?null:("\"algorithm\":"+algorithm)),(secretLifetime==null?null:("\"secret_lifetime\":"+secretLifetime))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("handle"), Integer.class));
    }

   /**
    * 
    *
    * @param handle 
    */
    public CompletableFuture<Void> clearCryptoBoxSecretCache(Integer handle) {
        return context.requestJSON("crypto.clear_crypto_box_secret_cache", "{"+(handle==null?"":("\"handle\":"+handle))+"}")
            .thenApply(json -> TONContext.convertValue(json, Void.class));
    }

   /**
    * 
    *
    * @param appObject 
    */
    public CompletableFuture<Integer> registerSigningBox(AppSigningBox appObject) {
        return context.requestJSONCallback("crypto.register_signing_box", "{}", (params,type) -> {
                Map data = (Map)(type==3?((Map)params).get("request_data"):params);
                switch ((String)data.remove("type")) {

                    case "GetPublicKey":
                        try {
                            appObject.getPublicKey().whenComplete((res,ex) -> {
                                new Client(context).resolveAppRequest(
                                    (Integer)((Map)params).get("app_request_id"),
                                    ex==null?
                                        new Client.AppRequestResult.Ok(new ResultOfAppSigningBox.GetPublicKey(res)):
                                        new Client.AppRequestResult.Error(ex.getMessage())
                                );
                            });
                        } catch (Exception e) {
                            e.printStackTrace(System.out);
                        }
                        break;

                    case "Sign":
                        try {
                            ParamsOfAppSigningBox.Sign p = new ObjectMapper().convertValue(data, ParamsOfAppSigningBox.Sign.class);
                            appObject.sign(p.getUnsigned()).whenComplete((res,ex) -> {
                                new Client(context).resolveAppRequest(
                                    (Integer)((Map)params).get("app_request_id"),
                                    ex==null?
                                        new Client.AppRequestResult.Ok(new ResultOfAppSigningBox.Sign(res)):
                                        new Client.AppRequestResult.Error(ex.getMessage())
                                );
                            });
                        } catch (Exception e) {
                            e.printStackTrace(System.out);
                        }
                        break;

                }
            }, Object.class)
            .thenApply(json -> TONContext.convertValue(json.findValue("handle"), Integer.class));
    }

   /**
    * 
    *
    * @param publicKey 
    * @param secretKey 
    */
    public CompletableFuture<Integer> getSigningBox(String publicKey, String secretKey) {
        return context.requestJSON("crypto.get_signing_box", "{"+Stream.of((publicKey==null?null:("\"public\":\""+publicKey+"\"")),(secretKey==null?null:("\"secret\":\""+secretKey+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("handle"), Integer.class));
    }

   /**
    * 
    *
    * @param handle 
    * @return Encoded with hex
    */
    public CompletableFuture<String> signingBoxGetPublicKey(Integer handle) {
        return context.requestJSON("crypto.signing_box_get_public_key", "{"+(handle==null?"":("\"handle\":"+handle))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("pubkey"), String.class));
    }

   /**
    * 
    *
    * @param signingBox 
    * @param unsigned Must be encoded with `base64`.
    * @return Encoded with `hex`.
    */
    public CompletableFuture<String> signingBoxSign(Integer signingBox, String unsigned) {
        return context.requestJSON("crypto.signing_box_sign", "{"+Stream.of((signingBox==null?null:("\"signing_box\":"+signingBox)),(unsigned==null?null:("\"unsigned\":\""+unsigned+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("signature"), String.class));
    }

   /**
    * 
    *
    * @param handle 
    */
    public CompletableFuture<Void> removeSigningBox(Integer handle) {
        return context.requestJSON("crypto.remove_signing_box", "{"+(handle==null?"":("\"handle\":"+handle))+"}")
            .thenApply(json -> TONContext.convertValue(json, Void.class));
    }

   /**
    * 
    *
    * @param appObject 
    */
    public CompletableFuture<Integer> registerEncryptionBox(AppEncryptionBox appObject) {
        return context.requestJSONCallback("crypto.register_encryption_box", "{}", (params,type) -> {
                Map data = (Map)(type==3?((Map)params).get("request_data"):params);
                switch ((String)data.remove("type")) {

                    case "GetInfo":
                        try {
                            appObject.getInfo().whenComplete((res,ex) -> {
                                new Client(context).resolveAppRequest(
                                    (Integer)((Map)params).get("app_request_id"),
                                    ex==null?
                                        new Client.AppRequestResult.Ok(new ResultOfAppEncryptionBox.GetInfo(res)):
                                        new Client.AppRequestResult.Error(ex.getMessage())
                                );
                            });
                        } catch (Exception e) {
                            e.printStackTrace(System.out);
                        }
                        break;

                    case "Encrypt":
                        try {
                            ParamsOfAppEncryptionBox.Encrypt p = new ObjectMapper().convertValue(data, ParamsOfAppEncryptionBox.Encrypt.class);
                            appObject.encrypt(p.getData()).whenComplete((res,ex) -> {
                                new Client(context).resolveAppRequest(
                                    (Integer)((Map)params).get("app_request_id"),
                                    ex==null?
                                        new Client.AppRequestResult.Ok(new ResultOfAppEncryptionBox.Encrypt(res)):
                                        new Client.AppRequestResult.Error(ex.getMessage())
                                );
                            });
                        } catch (Exception e) {
                            e.printStackTrace(System.out);
                        }
                        break;

                    case "Decrypt":
                        try {
                            ParamsOfAppEncryptionBox.Decrypt p = new ObjectMapper().convertValue(data, ParamsOfAppEncryptionBox.Decrypt.class);
                            appObject.decrypt(p.getData()).whenComplete((res,ex) -> {
                                new Client(context).resolveAppRequest(
                                    (Integer)((Map)params).get("app_request_id"),
                                    ex==null?
                                        new Client.AppRequestResult.Ok(new ResultOfAppEncryptionBox.Decrypt(res)):
                                        new Client.AppRequestResult.Error(ex.getMessage())
                                );
                            });
                        } catch (Exception e) {
                            e.printStackTrace(System.out);
                        }
                        break;

                }
            }, Object.class)
            .thenApply(json -> TONContext.convertValue(json.findValue("handle"), Integer.class));
    }

   /**
    * 
    *
    * @param handle 
    */
    public CompletableFuture<Void> removeEncryptionBox(Integer handle) {
        return context.requestJSON("crypto.remove_encryption_box", "{"+(handle==null?"":("\"handle\":"+handle))+"}")
            .thenApply(json -> TONContext.convertValue(json, Void.class));
    }

   /**
    * 
    *
    * @param encryptionBox 
    */
    public CompletableFuture<Object> encryptionBoxGetInfo(Integer encryptionBox) {
        return context.requestJSON("crypto.encryption_box_get_info", "{"+(encryptionBox==null?"":("\"encryption_box\":"+encryptionBox))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("info"), Object.class));
    }

   /**
    * Block cipher algorithms pad data to cipher block size so encrypted data can be longer then original data. Client should store the original data size after encryption and use it afterdecryption to retrieve the original data from decrypted data.
    *
    * @param encryptionBox 
    * @param data 
    * @return Padded to cipher block size
    */
    public CompletableFuture<String> encryptionBoxEncrypt(Integer encryptionBox, String data) {
        return context.requestJSON("crypto.encryption_box_encrypt", "{"+Stream.of((encryptionBox==null?null:("\"encryption_box\":"+encryptionBox)),(data==null?null:("\"data\":\""+data+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("data"), String.class));
    }

   /**
    * Block cipher algorithms pad data to cipher block size so encrypted data can be longer then original data. Client should store the original data size after encryption and use it afterdecryption to retrieve the original data from decrypted data.
    *
    * @param encryptionBox 
    * @param data 
    */
    public CompletableFuture<String> encryptionBoxDecrypt(Integer encryptionBox, String data) {
        return context.requestJSON("crypto.encryption_box_decrypt", "{"+Stream.of((encryptionBox==null?null:("\"encryption_box\":"+encryptionBox)),(data==null?null:("\"data\":\""+data+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("data"), String.class));
    }

   /**
    * 
    *
    * @param algorithm 
    */
    public CompletableFuture<Integer> createEncryptionBox(EncryptionAlgorithm algorithm) {
        return context.requestJSON("crypto.create_encryption_box", "{"+(algorithm==null?"":("\"algorithm\":"+algorithm))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("handle"), Integer.class));
    }

}

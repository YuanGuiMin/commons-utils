package com.meowu.commons.utils.utils;

import com.google.common.collect.Maps;
import com.meowu.commons.utils.security.exception.RSAException;

import javax.crypto.Cipher;
import java.io.ByteArrayOutputStream;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Map;

public class RSAUtils{

    private static final String ALGORITHM      = "RSA";
    private static final String SIGN_ALGORITHM = "SHA1withRSA";

    private static final int KEY_SIZE_1024 = 1024;
    private static final int KEY_SIZE_2048 = 2048;

    private static final int MAX_1024_ENCRYPT_BLOCK_SIZE = 117;
    private static final int MAX_1024_DECRYPT_BLOCK_SIZE = 128;
    private static final int MAX_2048_ENCRYPT_BLOCK_SIZE = 245;
    private static final int MAX_2048_DECRYPT_BLOCK_SIZE = 256;

    public static final String PUBLIC_KEY  = "publicKey";
    public static final String PRIVATE_KEY = "privateKey";

    public static Map<String, Key> keyPairBy1024(){
        return keyPair(KEY_SIZE_1024);
    }

    public static Map<String, Key> keyPairBy2048(){
        return keyPair(KEY_SIZE_2048);
    }

    public static PrivateKey generatePrivateKey(byte[] content){
        AssertUtils.notEmpty(content, "private key content must not be null");

        try{
            return KeyFactory.getInstance(ALGORITHM)
                             .generatePrivate(new PKCS8EncodedKeySpec(content));
        }catch(Exception e){
            throw new RSAException(e.getMessage(), e);
        }
    }

    public static PublicKey generatePublicKey(byte[] content){
        AssertUtils.notEmpty(content, "public key content must not be null");

        try{
            return KeyFactory.getInstance(ALGORITHM)
                             .generatePublic(new X509EncodedKeySpec(content));
        }catch(Exception e){
            throw new RSAException(e.getMessage(), e);
        }
    }

    public static byte[] sign(byte[] content, PrivateKey key){
        AssertUtils.notEmpty(content, "content to sign must not be null");
        AssertUtils.notNull(key, "private key must not be null");

        try{
            Signature signature = Signature.getInstance(SIGN_ALGORITHM);
            signature.initSign(key);
            signature.update(content);

            return signature.sign();
        }catch(Exception e){
            throw new RSAException(e.getMessage(), e);
        }
    }

    public static boolean verify(byte[] content, byte[] signature, PublicKey key){
        AssertUtils.notEmpty(content, "content to verify must not be null");
        AssertUtils.notEmpty(signature, "signature to verify must not be null");
        AssertUtils.notNull(key, "public key must not be null");

        try{
            Signature verify = Signature.getInstance(SIGN_ALGORITHM);
            verify.initVerify(key);
            verify.update(content);

            return verify.verify(signature);
        }catch(Exception e){
            throw new RSAException(e.getMessage(), e);
        }
    }

    public static byte[] decryptBy1024(byte[] content, Key key){
        return decrypt(content, key, KEY_SIZE_1024);
    }

    public static byte[] encryptBy1024(byte[] content, Key key){
        return encrypt(content, key, KEY_SIZE_1024);
    }

    public static byte[] decryptBy2048(byte[] content, Key key){
        return decrypt(content, key, KEY_SIZE_2048);
    }

    public static byte[] encryptBy2048(byte[] content, Key key){
        return encrypt(content, key, KEY_SIZE_2048);
    }

    private static Map<String, Key> keyPair(int size){
        AssertUtils.isTrue(size == KEY_SIZE_1024 || size == KEY_SIZE_2048, "key pair size must be 1024 or 2048");

        try{
            KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(ALGORITHM);
            keyPairGen.initialize(size, new SecureRandom());

            KeyPair       keyPair    = keyPairGen.generateKeyPair();
            RSAPublicKey  publicKey  = (RSAPublicKey) keyPair.getPublic();
            RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();

            Map<String, Key> pair = Maps.newHashMapWithExpectedSize(2);
            pair.put(PUBLIC_KEY, publicKey);
            pair.put(PRIVATE_KEY, privateKey);

            return pair;
        }catch(Exception e){
            throw new RSAException(e.getMessage(), e);
        }
    }

    private static byte[] decrypt(byte[] content, Key key, int size){
        AssertUtils.notEmpty(content, "content to decrypt must not be null");
        AssertUtils.notNull(key, "key must not be null");
        AssertUtils.isTrue(size == KEY_SIZE_1024 || size == KEY_SIZE_2048, "key pair size must be 1024 or 2048");

        try(ByteArrayOutputStream stream = new ByteArrayOutputStream()){
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, key);

            int blockSize = (size == KEY_SIZE_1024 ? MAX_1024_DECRYPT_BLOCK_SIZE : MAX_2048_DECRYPT_BLOCK_SIZE);
            int length    = content.length;
            int offset    = 0;
            int index     = 0;

            byte[] buffer;

            while(length - offset > 0){
                if(length - offset > blockSize){
                    buffer = cipher.doFinal(content, offset, blockSize);
                }else{
                    buffer = cipher.doFinal(content, offset, length - offset);
                }

                stream.write(buffer);
                index++;
                offset = index * blockSize;
            }

            return stream.toByteArray();
        }catch(Exception e){
            throw new RSAException(e.getMessage(), e);
        }
    }

    private static byte[] encrypt(byte[] content, Key key, int size){
        AssertUtils.notEmpty(content, "content to encrypt must not be null");
        AssertUtils.notNull(key, "key must not be null");
        AssertUtils.isTrue(size == KEY_SIZE_1024 || size == KEY_SIZE_2048, "key pair size must be 1024 or 2048");

        try(ByteArrayOutputStream stream = new ByteArrayOutputStream()){
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, key);

            int blockSize = (size == KEY_SIZE_1024 ? MAX_1024_ENCRYPT_BLOCK_SIZE : MAX_2048_ENCRYPT_BLOCK_SIZE);
            int length   = content.length;
            int offset   = 0;
            int index    = 0;

            byte[] buffer;

            while(length - offset > 0){
                if(length - offset > blockSize){
                    buffer = cipher.doFinal(content, offset, blockSize);
                }else{
                    buffer = cipher.doFinal(content, offset, length - offset);
                }

                stream.write(buffer);
                index++;
                offset = index * blockSize;
            }

            return stream.toByteArray();
        }catch(Exception e){
            throw new RSAException(e.getMessage(), e);
        }
    }
}

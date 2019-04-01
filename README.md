## Summary

This is a patched keytool version supporting to import a certificate using a provider using the `srcprovidername` option.
   
The original keytool is always using the Sun default crypto provider which cannot import e.g. Brainpool elliptic curve certificates.

## Build

    mvn clean install
    
To run the sample certificate import into a trust store run:
 
     mvn exec:java

Choose any password.
     
Before running the sample again, run `mvn clean install` again to delete the `truststore.jks` file.  

## Developer Notes

To prevent the collision with the classes contained in the standard JDK / JRE some classes were renamed: `<className>` -> `<className>2`.

## Use Keytool Option `srcprovidername`

    java -jar keytool.jar -importcert -alias ci -file CERT_CI_ECDSA_BRP.der -keystore truststore.bks -srcprovidername BC -deststoretype BKS -destprovidername BC -providerPath bcprov-jdk15on-1.59.jar -v -providerClass org.bouncycastle.jce.provider.BouncyCastleProvider
    
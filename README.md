# Summary

This is a patched keytool version supporting to import a certificate using a provider using the `srcprovidername` option.
   
The original keytool is always using the Sun default crypto provider which cannot import e.g. Brainpool elliptic curve certificates.

# Maven Dependency


```
    <groupId>de.ohmesoftware</groupId>
    <artifactId>keytool</artifactId>
    <version>0.0.3</version>

```
# Build

    mvn clean install
    
To run the sample certificate import into a trust store run:
 
     mvn exec:java

Choose any password.
     
Before running the sample again, run `mvn clean install` again to delete the `truststore.jks` file.  

# Use of Keytool Option `srcprovidername`

    java -jar keytool.jar -importcert -alias ci -file CERT_CI_ECDSA_BRP.der -keystore truststore.bks -srcprovidername BC -deststoretype BKS -destprovidername BC -providerPath bcprov-jdk15on-1.59.jar -v -providerClass org.bouncycastle.jce.provider.BouncyCastleProvider
 
# Developer Notes

To prevent the collision with the classes contained in the standard JDK / JRE some classes were renamed: `<className>` -> `<className>2`.

# Deployment + Release

See https://central.sonatype.org/pages/apache-maven.html


# For Snapshots

    mvn clean deploy

## For Releases

```
mvn release:clean release:prepare
mvn release:perform
```

Release the deployment using Nexus See https://central.sonatype.org/pages/releasing-the-deployment.html
Or alternatively do it with Maven:

```
cd target/checkout
mvn nexus-staging:release
```


   
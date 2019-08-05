package sun.security.tools.keytool;

import org.junit.Test;

import java.io.File;

/**
 * Doc.
 *
 * @author <a href="mailto:karsten.ohme@ohmesoftware.de">Karsten Ohme
 * (karsten.ohme@ohmesoftware.de)</a>
 */
public class TestKeyStoreUtil {

    @Test
    public void testBrpImport() throws Exception {
        String target = "./target/truststore.bks";
        new File(target).delete();
        Main2.main(new String[]{
                "-importcert",
                "-noprompt",
                "-storepass", "password",
                "-alias", "ci",
                "-file", "./cert/CERT_CI_ECDSA_BRP.der",
                "-keystore", target,
                "-srcprovidername", "BC",
                "-deststoretype", "BKS",
                "-destprovidername", "BC",
                "-providerPath",
                System.getProperty("user.home") + "/.m2/repository/org/bouncycastle/bcprov-jdk15on/1.61/bcprov-jdk15on-1.61.jar",
                "-v",
                "-providerClass", "org.bouncycastle.jce.provider.BouncyCastleProvider"});
    }

}

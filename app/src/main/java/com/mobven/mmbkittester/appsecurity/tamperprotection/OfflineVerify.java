package com.mobven.mmbkittester.appsecurity.tamperprotection;

import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.json.webtoken.JsonWebSignature;
import com.mobven.mmbkittester.R;

import org.apache.http.conn.ssl.AllowAllHostnameVerifier;
import org.apache.http.conn.ssl.StrictHostnameVerifier;
import org.apache.http.conn.ssl.X509HostnameVerifier;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.cert.X509Certificate;
import java.util.Arrays;

import javax.net.ssl.SSLException;

/**
 * Sample code to verify the device attestation statement offline.
 */
public class OfflineVerify {

    private static final X509HostnameVerifier HOSTNAME_VERIFIER = new StrictHostnameVerifier();

    private static AttestationStatement parseAndVerify(String signedAttestationStatment) {
        // Parse JSON Web Signature format.
        JsonWebSignature jws;
        try {
            jws = JsonWebSignature.parser(JacksonFactory.getDefaultInstance())
                    .setPayloadClass(AttestationStatement.class).parse(signedAttestationStatment);
        } catch (IOException e) {
            System.err.println("Failure: " + signedAttestationStatment + " is not valid JWS " +
                    "format.");
            return null;
        }

        // Verify the signature of the JWS and retrieve the signature certificate.
        X509Certificate cert;
        try {
            cert = jws.verifySignature();
            if (cert == null) {
                System.err.println("Failure: Signature verification failed.");
                return null;
            }
        } catch (GeneralSecurityException e) {
            System.err.println(
                    "Failure: Error during cryptographic verification of the JWS signature.");
            return null;
        }

        // Verify the hostname of the certificate.
        if (!verifyHostname("attest.android.com", cert)) {
            System.err.println("Failure: Certificate isn't issued for the hostname attest.android" +
                    ".com.");
            return null;
        }

        // Extract and use the payload data.
        AttestationStatement stmt = (AttestationStatement) jws.getPayload();
        return stmt;
    }

    /**
     * Verifies that the certificate matches the specified hostname.
     * to confirm that the hostname matches the certificate.
     *
     * @param hostname
     * @param leafCert
     * @return
     */
    private static boolean verifyHostname(String hostname, X509Certificate leafCert) {
        try {
            // Check that the hostname matches the certificate. This method throws an exception if
            // the cert could not be verified.
            HOSTNAME_VERIFIER.verify(hostname, leafCert);
            return true;
        } catch (SSLException e) {
            e.printStackTrace();
        }

        return false;
    }


    public static AppIntegrityModel process(String signedAttestationStatement, boolean isDummyFail) {
        AttestationStatement stmt = parseAndVerify(signedAttestationStatement);
        if (stmt == null) {
            return new AppIntegrityModel("Failure: Failed to parse and verify the attestation statement.", R.color.fail);
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Successfully verified the attestation statement. The content is:");
        stringBuilder.append("\n\nTimestamp: " + stmt.getTimestampMs() + " ms");
        stringBuilder.append("\n\nAPK package name: " + stmt.getApkPackageName());
        stringBuilder.append("\n\nAPK digest SHA256: " + Arrays.toString(stmt.getApkDigestSha256()));
        stringBuilder.append("\n\nAPK certificate digest SHA256: " +
                Arrays.deepToString(stmt.getApkCertificateDigestSha256()));
        stringBuilder.append("\n\nCTS profile match: " + stmt.isCtsProfileMatch());
        stringBuilder.append("\n\nHas basic integrity: " + stmt.hasBasicIntegrity());
        stringBuilder.append("\n\n** This sample only shows how to verify the authenticity of an "
                + "attestation response. Next, you must check that the server response matches the "
                + "request by comparing the nonce, package name, timestamp and digest.");

        if (stmt.isCtsProfileMatch() && stmt.hasBasicIntegrity() && !isDummyFail) {
            return new AppIntegrityModel(stringBuilder.toString(), R.color.pass);
        } else {
            return new AppIntegrityModel(stringBuilder.toString(), R.color.fail);
        }
    }
}

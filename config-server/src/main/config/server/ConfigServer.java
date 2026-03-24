package config.server;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * PBKDF2 - Reduce vulnerabilities to brute force attacks by using salt and iteration count
 * Rainbow attacks - Type of attack that uses a hash table to crack passwords by comparison
 * Config server to microservice - Use ssl/tls enabled communication on production
 * Symmetric encryption - Single key for encryption and decryption
 * Asymmetric encryption - public key for encryption / Private key for decryption
 * Asymmetric approach - More secure as it uses 2 keys: Public key is shared but private key is kept as confidential
 */

@EnableConfigServer
@SpringBootApplication
public class ConfigServer {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServer.class, args);
    }
}

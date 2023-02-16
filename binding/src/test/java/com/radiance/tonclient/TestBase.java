package com.radiance.tonclient;

import org.junit.*;
import java.nio.file.*;
import java.util.concurrent.CompletableFuture;
import java.util.Base64;
import java.util.Scanner;
import java.io.IOException;
import java.net.URISyntaxException;

public abstract class TestBase {
    protected static TONContext context;
    protected static Client client;
    protected static Crypto crypto;
    protected static Abi abiModule;
    protected static Processing processing;
    protected static Net net;
    protected static Boc boc;
    protected static Tvm tvm;

    protected static Abi.ABI eventsAbi, helloAbi, giverWalletAbi, walletAbi,
                    multisigWalletAbi, giverAbi, subscriptionAbi;
    protected static String eventsTvc, helloTvc, subscriptionTvc;
    protected static String giverAddress = "0:841288ed3b55d9cdafa806807f02a0ae0c169aa5edfe88a789a6482429756a94";


    protected static Abi.ABI abiFromResource(String name) {
        Scanner s = new Scanner(TestBase.class.getResourceAsStream(name)).useDelimiter("\\A");
        String data = s.hasNext() ? s.next() : "";
        s.close();
        return new Abi.ABI.Serialized(data);
    }

    protected static String tvcFromResource(String name) throws IOException, URISyntaxException {
        return new String(Base64.getEncoder().encode(Files.readAllBytes(Paths.get(TestBase.class.getResource(name).toURI()))));
    }

    @BeforeClass
    public static void init() throws Exception {
        System.getProperties().setProperty("java.util.logging.SimpleFormatter.format", "%4$s: %5$s%n");

        //context = TONContext.create("{\"network\": {\"server_address\": \"net1.ton.dev\"}}");
        context = TONContext.create("{\"network\": {\"server_address\": \"http://localhost\"}}");
        client = new Client(context);
        crypto = new Crypto(context);
        abiModule = new Abi(context);
        processing = new Processing(context);
        net = new Net(context);
        boc = new Boc(context);
        tvm = new Tvm(context);

        eventsAbi = abiFromResource("/Events.abi.json");
        eventsTvc = new String(Base64.getEncoder().encode(Files.readAllBytes(Paths.get(TestBase.class.getResource("/Events.tvc").toURI()))));
        helloAbi = abiFromResource("/Hello.abi.json");
        helloTvc = new String(Base64.getEncoder().encode(Files.readAllBytes(Paths.get(TestBase.class.getResource("/Hello.tvc").toURI()))));
        giverWalletAbi = abiFromResource("/GiverWallet.abi.json");
        walletAbi = abiFromResource("/Wallet.abi.json");
        multisigWalletAbi = abiFromResource("/SetcodeMultisigWallet.abi.json");
        giverAbi = abiFromResource("/Giver.abi.json");
        subscriptionAbi = abiFromResource("/Subscription.abi.json");
        subscriptionTvc = new String(Base64.getEncoder().encode(Files.readAllBytes(Paths.get(TestBase.class.getResource("/Subscription.tvc").toURI()))));
    }

    @AfterClass
    public static void destroy() {
        if (context != null)
            context.destroy();
    }


    @Before
    public void beforeTest() {
        System.out.println("==============================");
    }

    protected CompletableFuture<String> signDetached(String data, Crypto.KeyPair keys) {
        return crypto.naclSignKeypairFromSecretKey(keys.getSecret())
            .thenCompose(signKeys -> crypto.naclSignDetached(data, signKeys.getSecret()));
    }
/*
    protected CompletableFuture<ResultOfProcessMessage> getGramsFromGiver(String address) {
        Abi abi = giverAbi;
        String[] message = new String[1];

        return abiModule.encodeMessage(
            abi,
            "0:841288ed3b55d9cdafa806807f02a0ae0c169aa5edfe88a789a6482429756a94",
            new Abi.DeploySet(),
            new Abi.CallSet(
                "sendGrams",
                null,
                "{\"dest\":\"" + address +"\", \"amount\":500000000}"),
            Abi.Signer.None,
            null)
        .thenCompose(encoded -> {
            System.out.println("Encoded: " + encoded);
            message[0] = encoded.getMessage();
            return processing.sendMessage(message[0], abi, true, event -> System.out.println("Event: " + event));
        })
        .thenCompose(blockId -> {
            System.out.println("Send Result: " + blockId);
            return processing.waitForTransaction(abi, message[0], blockId, true, event -> {
                System.out.println("Transaction: " + event);
            });
        });
    }*/

    protected CompletableFuture<Processing.ResultOfProcessMessage> getGramsFromGiver(String address) {
        return processing.processMessage(
            giverAbi,
            giverAddress,
            null,
            new Abi.CallSet(
                "sendGrams",
                null,
                "{\"dest\":\"" + address +"\", \"amount\":500000000}"),
            Abi.Signer.None,
            null,
            null,
            false,
            null); //event -> System.out.println("Event: " + event));
    }

    protected CompletableFuture<String> deployWithGiver(Abi.ABI abi, Abi.DeploySet deploySet, Abi.CallSet callSet, Abi.Signer signer) {
        String[] address = new String[1];

        return abiModule.encodeMessage(abi, null, deploySet, callSet, signer, null, null)
            .thenCompose(encoded -> {
                address[0] = encoded.getAddress();
                return getGramsFromGiver(encoded.getAddress());
            }).thenCompose(processed -> {
                return processing.processMessage(abi, null, deploySet, callSet, signer, null, null, false, null);
            }).thenApply(processed -> address[0]);
    }
}

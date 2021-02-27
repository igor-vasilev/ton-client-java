package com.radiance.tonclient;

import java.util.concurrent.CompletableFuture;
import java.util.stream.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Arrays;

/**
 *  
 */
public class Boc {

    public static abstract class BocCacheType {

    /**
     *  Such BOC will not be removed from cache until it is unpinned
     */
    public static class Pinned extends BocCacheType  {

        public Pinned(String pin) {

            this.pin = pin;

        }
        public Pinned() {

        }


        @JsonProperty("pin")
        private String pin;
        /**
         * 
         */
        public String getPin() {
            return pin;
        }
        /**
         * 
         */
        public void setPin(String value) {
            this.pin = value;
        }


        @Override
        public String toString() {
            return "{"+Stream.of("\"type\":\"Pinned\"",(pin==null?null:("\"pin\":\""+pin+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}";
        }
    }

        public static final Unpinned Unpinned = new Unpinned();

    /**
     *  
     */
    public static class Unpinned extends BocCacheType  {

        public Unpinned() {

        }



        @Override
        public String toString() {
            return "{"+"\"type\":\"Unpinned\""+"}";
        }
    }
}
    private TONContext context;

    public Boc(TONContext context) {
        this.context = context;
    }

   /**
    * JSON structure is compatible with GraphQL API message object
    *
    * @param boc 
    */
    public CompletableFuture<Object> parseMessage(String boc) {
        return context.requestJSON("boc.parse_message", "{"+(boc==null?"":("\"boc\":\""+boc+"\""))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("parsed"), Object.class));
    }

   /**
    * JSON structure is compatible with GraphQL API transaction object
    *
    * @param boc 
    */
    public CompletableFuture<Object> parseTransaction(String boc) {
        return context.requestJSON("boc.parse_transaction", "{"+(boc==null?"":("\"boc\":\""+boc+"\""))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("parsed"), Object.class));
    }

   /**
    * JSON structure is compatible with GraphQL API account object
    *
    * @param boc 
    */
    public CompletableFuture<Object> parseAccount(String boc) {
        return context.requestJSON("boc.parse_account", "{"+(boc==null?"":("\"boc\":\""+boc+"\""))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("parsed"), Object.class));
    }

   /**
    * JSON structure is compatible with GraphQL API block object
    *
    * @param boc 
    */
    public CompletableFuture<Object> parseBlock(String boc) {
        return context.requestJSON("boc.parse_block", "{"+(boc==null?"":("\"boc\":\""+boc+"\""))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("parsed"), Object.class));
    }

   /**
    * JSON structure is compatible with GraphQL API shardstate object
    *
    * @param boc 
    * @param id 
    * @param workchainId 
    */
    public CompletableFuture<Object> parseShardstate(String boc, String id, Number workchainId) {
        return context.requestJSON("boc.parse_shardstate", "{"+Stream.of((boc==null?null:("\"boc\":\""+boc+"\"")),(id==null?null:("\"id\":\""+id+"\"")),(workchainId==null?null:("\"workchain_id\":"+workchainId))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("parsed"), Object.class));
    }

   /**
    * 
    *
    * @param blockBoc 
    */
    public CompletableFuture<String> getBlockchainConfig(String blockBoc) {
        return context.requestJSON("boc.get_blockchain_config", "{"+(blockBoc==null?"":("\"block_boc\":\""+blockBoc+"\""))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("config_boc"), String.class));
    }

   /**
    * 
    *
    * @param boc 
    */
    public CompletableFuture<String> getBocHash(String boc) {
        return context.requestJSON("boc.get_boc_hash", "{"+(boc==null?"":("\"boc\":\""+boc+"\""))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("hash"), String.class));
    }

   /**
    * 
    *
    * @param tvc 
    */
    public CompletableFuture<String> getCodeFromTvc(String tvc) {
        return context.requestJSON("boc.get_code_from_tvc", "{"+(tvc==null?"":("\"tvc\":\""+tvc+"\""))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("code"), String.class));
    }

   /**
    * 
    *
    * @param bocRef 
    */
    public CompletableFuture<String> cacheGet(String bocRef) {
        return context.requestJSON("boc.cache_get", "{"+(bocRef==null?"":("\"boc_ref\":\""+bocRef+"\""))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("boc"), String.class));
    }

   /**
    * 
    *
    * @param boc 
    * @param cacheType 
    */
    public CompletableFuture<String> cacheSet(String boc, BocCacheType cacheType) {
        return context.requestJSON("boc.cache_set", "{"+Stream.of((boc==null?null:("\"boc\":\""+boc+"\"")),(cacheType==null?null:("\"cache_type\":"+cacheType))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json.findValue("boc_ref"), String.class));
    }

   /**
    * BOCs which don't have another pins will be removed from cache
    *
    * @param pin 
    * @param bocRef If it is provided then only referenced BOC is unpinned
    */
    public CompletableFuture<Void> cacheUnpin(String pin, String bocRef) {
        return context.requestJSON("boc.cache_unpin", "{"+Stream.of((pin==null?null:("\"pin\":\""+pin+"\"")),(bocRef==null?null:("\"boc_ref\":\""+bocRef+"\""))).filter(_f -> _f != null).collect(Collectors.joining(","))+"}")
            .thenApply(json -> TONContext.convertValue(json, Void.class));
    }

}

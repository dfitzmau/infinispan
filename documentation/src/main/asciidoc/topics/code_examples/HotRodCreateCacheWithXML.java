String cacheName = "CacheWithXMLConfiguration";
String xml = String.format("<distributed-cache name=\"%s\" mode=\"SYNC\"
                              statistics=\"true\">" +
                              "<locking isolation=\"READ_COMMITTED\"/>" +
                              "<transaction mode=\"NON_XA\"/>" +
                              "<expiration lifespan=\"60000\" interval=\"20000\"/>" +
                           "</distributed-cache>" +
                           , cacheName);
remoteCacheManager.administration().getOrCreateCache(cacheName, new XMLStringConfiguration(xml));

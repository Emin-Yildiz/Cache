package org.example;

import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.CacheConfiguration;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;

/**
 * Hello world!
 *
 */
public class App {

    public static void main( String[] args ) {

        // cache yönetimi için CacheManager nesnesi oluşturuldu.
        CacheManager cacheManager = CacheManagerBuilder.newCacheManagerBuilder().build(true);

        // Önbellek için yapılandırmayı oluşturun
        CacheConfiguration<Long, String> cacheConfiguration = CacheConfigurationBuilder
                // ilk parametre (Long.class) keyin türü,
                // ikinci parametre(String.class) cache'de ki değerlerin türü,
                // üçüncü parametre ise cache'de 100 adet parametre tutulacağını belirtir.
                .newCacheConfigurationBuilder(Long.class, String.class, ResourcePoolsBuilder.heap(100))
                .build();

        // config nesnemizi referans alarak "exampleCache" adında bir cache oluşturdu.
        Cache<Long, String> cache = cacheManager.createCache("exampleCache", cacheConfiguration);

        // cache'e bir veri ekledi.
        cache.put(1L, "EMINNNNNNNNNNNNNNN");

        // cache'den 1 nolu keyde ki değeri getirir.
        String value = cache.get(1L);

        System.out.println("Önbellekten alınan değer: " + value);

        // belleği serbest bırakır.
        cacheManager.close();

    }
}

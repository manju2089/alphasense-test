import java.util.HashMap;
import java.util.Map;
import org.slf4j.LoggerFactory;
public abstract class Digest {
    // 1. The below code is not thread-safe, since HashMap is not thread safe. (ConcurrentHashMap can be an alternative)

    private Map<byte[], byte[]> cache = new HashMap<byte[], byte[]>(); // 2. The map is not final
    public byte[] digest(byte[] input) {
        //3. There is no readLock here
        byte[] result = cache.get(input); // 4. When the get operation is invoked here, there is a possibility for put operation to be invoked inside synchronized block
        if (result == null) {
            synchronized (cache) {
                result = cache.get(input);
                if (result == null) {
                    try {
                        result = doDigest(input);
                        cache.put(input, result); // 5. There is no writeLock here / Instead of put methods computeIfAbsent can be used
                    } catch (RuntimeException ex) {
                        LoggerFactory.getLogger("Digest").error(
                                "Unable to make digest"
                        );
                        throw ex;
                    }
                }
            }
        }
        return result;
    }
    protected abstract byte[] doDigest(byte[] input);
}
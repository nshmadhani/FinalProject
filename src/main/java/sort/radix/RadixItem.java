package sort.radix;

import com.ibm.icu.text.CollationKey;
import com.ibm.icu.text.Collator;
import com.ibm.icu.text.RuleBasedCollator;

import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;


/**
 * The reason we created a new class and did not use CollationKey is due to
 * CollationKey.toByteArray() -> creates a new byte[] every time we call, would add overhead to algorithm
 */
public class RadixItem implements Comparable<RadixItem> {
    String source;
    CollationKey collationKey;
    byte[] collationKeyBytes;

    public RadixItem(String source, CollationKey collationKey, byte[] collationKeyBytes) {
        this.source = source;
        this.collationKey = collationKey;
        this.collationKeyBytes = collationKeyBytes;
    }

    public static RadixItem[] createItem(String[] a, Locale l) {
        RuleBasedCollator collator = (RuleBasedCollator) Collator.getInstance(l);
        RadixItem[] res = new RadixItem[a.length];
        for (int i = 0; i < a.length; i++) {
            res[i] = new RadixItem(a[i], collator.getCollationKey(a[i]), collator.getCollationKey(a[i]).toByteArray());
        }
        return res;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public CollationKey getCollationKey() {
        return collationKey;
    }

    public void setCollationKey(CollationKey collationKey) {
        this.collationKey = collationKey;
    }

    public byte[] getCollationKeyBytes() {
        return collationKeyBytes;
    }

    public void setCollationKeyBytes(byte[] collationKeyBytes) {
        this.collationKeyBytes = collationKeyBytes;
    }


    /**
     * @param d
     * @return an integer value for the byte(Why? since we need to return a value that
     * is outside of the byte range d is greater than length of key)
     */
    public int getByte(int d) {
        if (d < collationKeyBytes.length) return collationKeyBytes[d];
        else return 0; //Random value
    }
    public int getTwoBytes(int d) {
        if (d < collationKeyBytes.length)
            return (((getByte(d) & 0xFF)<<8) |  (getByte(d + 1) & 0xFF));
        else return 0; //Random value
    }

    public byte getEndByte(int d) {
        if (collationKeyBytes.length <= d) {
            return 0;
        } else return collationKeyBytes[collationKeyBytes.length - 1 - d];
    }

    @Override
    public String toString() {
        //return Arrays.toString(Arrays.copyOfRange(collationKeyBytes, Math.max(0, collationKeyBytes.length - 14), collationKeyBytes.length));
        return source;
    }




    @Override
    public int hashCode() {
        int result = Objects.hash(source, collationKey);
        result = 31 * result + Arrays.hashCode(collationKeyBytes);
        return result;
    }

    @Override
    public int compareTo(RadixItem radixItem) {
        if (radixItem == null)
            throw new NullPointerException("Comparable was Null");
        return collationKey.compareTo(radixItem.collationKey);

    }
}
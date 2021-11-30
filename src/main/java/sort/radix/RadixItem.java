package sort.radix;

import com.ibm.icu.text.CollationKey;
import com.ibm.icu.text.Collator;
import com.ibm.icu.text.RuleBasedCollator;

import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;

public class RadixItem implements Comparable {
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

    public byte getByte(int d) {
        if (collationKeyBytes.length <= d) {
            return 0;
        } else return collationKeyBytes[d];
    }

    public byte getEndByte(int d) {
        if (collationKeyBytes.length <= d) {
            return 0;
        } else return collationKeyBytes[collationKeyBytes.length - 1 - d];
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOfRange(collationKeyBytes, collationKeyBytes.length - 6, collationKeyBytes.length));
    }


    @Override
    public int compareTo(Object o) {
        RadixItem radixItem = (RadixItem) o;
        if (radixItem == null)
            throw new NullPointerException("Comparable was Null");
        return collationKey.compareTo(radixItem.collationKey);
    }


    @Override
    public int hashCode() {
        int result = Objects.hash(source, collationKey);
        result = 31 * result + Arrays.hashCode(collationKeyBytes);
        return result;
    }
}
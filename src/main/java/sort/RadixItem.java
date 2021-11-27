package sort;

import com.ibm.icu.text.CollationKey;
import com.ibm.icu.text.Collator;
import com.ibm.icu.text.RuleBasedCollator;

import java.util.Arrays;
import java.util.Locale;

public class RadixItem {
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

    @Override
    public String toString() {
        return Arrays.toString(collationKeyBytes);
    }


}
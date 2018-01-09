/* 
 *  Copyright FUJITSU LIMITED 2018
 **
 * 
 */
package org.oscm.app.security;

import java.io.UnsupportedEncodingException;
import java.util.Random;

/**
 *
 */
public class StringScrambler2 {

    private static final String UTF8 = new String(new char[] { '\u0055',
            '\u0054', '\u0046', '\u0038' }); // => "UTF8"


    /**
     * Returns a string containing obfuscated Java code which you can copy-paste
     * into your source code in order to represent the given string. Obfuscation
     * is performed by encoding the given string into UTF8 and then XOR-ing a
     * sequence of pseudo random numbers to it in order to prevent attacks based
     * on character probability. The result is encoded into an array of longs
     * which is embedded in some Java code which would produce the original
     * string again. The sequence of pseudo random numbers is seeded with a 48
     * bit random number in order to provide a non-deterministic result for the
     * generated code. Hence, two subsequent calls with the same string will
     * produce equal results by a chance of 1/(2<sup>48</sup>-1) (0 isn't used
     * as a seed) only!
     * <p>
     * As an example, calling this method with <code>"Hello world!"</code> as
     * its parameter may produce the result
     * <code>"new ObfuscatedString(new long[] {
     *     0x3676CB307FBD35FEL, 0xECFB991E2033C169L, 0xD8C3D3E365645589L
     * }).toString()"</code>. If this code is compiled and executed later, it
     * will produce the string <code>"Hello world!"</code> again.
     * 
     * @param s
     *            The string to obfuscate. This may not contain null characters.
     * 
     * @return Some obfuscated Java code to produce the given string again.
     * 
     * @throws IllegalArgumentException
     *             If <code>s</code> contains a null character.
     */
    public static String obfuscate(final String s) {
        // Any string literal used in this method is represented as an
        // ObfuscatedString unless it's no longer than two characters.
        // This should help to prevent location of this class in the obfuscated
        // code generated by ProGuard.

        if (s.indexOf(0) != -1) {
            throw new IllegalArgumentException(new StringScrambler2(new long[] {
                    0x241005931110FC70L, 0xDCD925A88EAD9F37L,
                    0x19ADA1C861E2A85DL, 0x9A5948E700FCAD8AL,
                    0x2E11C83A72441DE2L }).toString()); // => "Null
                                                        // characters
                                                        // are not
                                                        // allowed!";
        }

        // Obtain the string as a sequence of UTF-8 encoded bytes.
        final byte[] encoded;
        try {
            encoded = s.getBytes(UTF8);
        } catch (UnsupportedEncodingException ex) {
            throw new AssertionError(ex); // UTF8 is always supported
        }

        // Create and seed a Pseudo Random Number Generator (PRNG) with a
        // random long number generated by another PRNG.
        // Note that using a PRNG to generate a seed for itself wouldn't make
        // it behave deterministically because each subsequent call to
        // setSeed() SUPPLEMENTS, rather than replaces, the existing seed.
        long seed;
        Random prng = new Random(); // randomly seeded
        do {
            seed = prng.nextLong(); // seed strength is effectively 48 bits
        } while (seed == 0); // setSeed(0) could cause issues
        prng = new Random(seed);

        // Construct a StringBuffer to hold the generated code and append the
        // seed as the first element of the encoded array of longs.
        // The value is represented in hexadecimal in order to keep the string
        // representation as short as possible.
        final StringBuffer code = new StringBuffer(new StringScrambler2(
                new long[] { 0x4E919C38A5FA6161L, 0x4B3EB92485C7262L,
                        0xA60D8752CC9A703L, 0xAC0E939BAE9E97B2L,
                        0x4492779563BC6E7BL, 0x877BC892C33314B5L }).toString()); // =>
        // "new
        // StringScrambler2(new
        // long[]
        // {";
        appendHexLiteral(code, seed);

        final int length = encoded.length;
        for (int i = 0; i < length; i += 8) {
            final long key = prng.nextLong();
            // Compute the value of the next array element as an obfuscated
            // version of the next eight bytes of the UTF8 encoded string.
            final long obfuscated = toLong(encoded, i) ^ key;

            code.append(", ");
            appendHexLiteral(code, obfuscated);
        }

        code.append(new StringScrambler2(new long[] { 0x43314F04EE218EB8L,
                0xADBCFD6F942C9B1BL, 0x2AEF7934B99F9C82L, 0x4635E5491665AD73L })
                .toString()); // => "}).toString()
                              // /* => \"";

        // Append the original string to the generated code comment,
        // properly escaping quotation marks and backslashes.
        code.append(s.replaceAll(
                "\\\\",
                new StringScrambler2(new long[] { 0x6D2C680D49523A01L,
                        0xB932F1DBD19E82CEL }).toString() /*
                                                           * => "\\\\\\\\"
                                                           */).replaceAll(
                "\"",
                new StringScrambler2(new long[] { 0x85E9D53EF7A9324BL,
                        0xB05BD65C9F19DE07L }).toString() /*
                                                           * => "\\\\\""
                                                           */));

        code.append(new StringScrambler2(new long[] { 0xC54FFF0621E7D107L,
                0x194EAD468C6FCF93L }).toString()); // => "\" */"

        return code.toString();
    }

    /**
     * The opposite to this method, obfuscate, is found in
     * org.oscm.tools.StringScrambler2.
     * 
     * @param obfuscated
     * @return original string
     */
    // For security reasons it will not be shipped to the customer.
    public static final String decode(final long[] obfuscated) {
        final int length = obfuscated.length;
        final byte[] encoded = new byte[8 * (length - 1)];
        final long seed = obfuscated[0];
        final Random prng = new Random(seed);

        for (int i = 1; i < length; i++) {
            final long key = prng.nextLong();
            final int off = 8 * (i - 1);
            long l = obfuscated[i] ^ key;
            final int end = Math.min(encoded.length, off + 8);
            for (int i2 = off; i2 < end; i2++) {
                encoded[i2] = (byte) l;
                l >>= 8;
            }
        }

        final String decoded;
        try {
            decoded = new String(encoded, "UTF8"); //$NON-NLS-1$
        } catch (UnsupportedEncodingException ex) {
            throw new AssertionError(ex);
        }

        final int i = decoded.indexOf(0);
        return i != -1 ? decoded.substring(0, i) : decoded;
    }

    private static final void appendHexLiteral(final StringBuffer sb,
            final long l) {
        sb.append("0x"); // obfuscation futile - too short
        sb.append(Long.toHexString(l).toUpperCase());
        sb.append('L'); // dito
    }

    /** The clear text string. */
    private final String s;

    /**
     * Decodes an obfuscated string from its representation as an array of
     * longs.
     * 
     * @param obfuscated
     *            The obfuscated representation of the string.
     * 
     * @throws NullPointerException
     *             If <code>obfuscated</code> is <code>null</code>.
     * @throws ArrayIndexOutOfBoundsException
     *             If the provided array does not contain at least one element.
     */
    public StringScrambler2(final long[] obfuscated) {
        final int length = obfuscated.length;

        // The original UTF8 encoded string was probably not a multiple
        // of eight bytes long and is thus actually shorter than this array.
        final byte[] encoded = new byte[8 * (length - 1)];

        // Obtain the seed and initialize a new PRNG with it.
        final long seed = obfuscated[0];
        final Random prng = new Random(seed);

        // De-obfuscate.
        for (int i = 1; i < length; i++) {
            final long key = prng.nextLong();
            toBytes(obfuscated[i] ^ key, encoded, 8 * (i - 1));
        }

        // Decode the UTF-8 encoded byte array into a string.
        // This will create null characters at the end of the decoded string
        // in case the original UTF8 encoded string was not a multiple of
        // eight bytes long.
        final String decoded;
        try {
            decoded = new String(encoded, UTF8);
        } catch (UnsupportedEncodingException ex) {
            throw new AssertionError(ex); // UTF-8 is always supported
        }

        // Cut off trailing null characters in case the original UTF8 encoded
        // string was not a multiple of eight bytes long.
        final int i = decoded.indexOf(0);
        s = i != -1 ? decoded.substring(0, i) : decoded;
    }

    /**
     * Decodes a long value from eight bytes in little endian order, beginning
     * at index <code>off</code>. This is the inverse of
     * {@link #toBytes(long, byte[], int)}. If less than eight bytes are
     * remaining in the array, only these low order bytes are processed and the
     * complementary high order bytes of the returned value are set to zero.
     * 
     * @param bytes
     *            The array containing the bytes to decode in little endian
     *            order.
     * @param off
     *            The offset of the bytes in the array.
     * 
     * @return The decoded long value.
     */
    private static final long toLong(final byte[] bytes, int off) {
        long l = 0;

        final int end = Math.min(bytes.length, off + 8);
        for (int i = end; --i >= off;) {
            l <<= 8;
            l |= bytes[i] & 0xFF;
        }

        return l;
    }

    /**
     * Encodes a long value to eight bytes in little endian order, beginning at
     * index <code>off</code>. This is the inverse of
     * {@link #toLong(byte[], int)}. If less than eight bytes are remaining in
     * the array, only these low order bytes of the long value are processed and
     * the complementary high order bytes are ignored.
     * 
     * @param l
     *            The long value to encode.
     * @param bytes
     *            The array which holds the encoded bytes upon return.
     * @param off
     *            The offset of the bytes in the array.
     */
    private static final void toBytes(long l, byte[] bytes, int off) {
        final int end = Math.min(bytes.length, off + 8);
        for (int i = off; i < end; i++) {
            bytes[i] = (byte) l;
            l >>= 8;
        }
    }

    /**
     * Returns the original string which was obfuscated by the
     * {@link #obfuscate} method.
     */
    public String toString() {
        return s;
    }

}

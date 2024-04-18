package me.piguy.inholland.sisyphus.service;

import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class IbanService {
    private static final String bankCode = "SYPB";
    private static int bankCodeInt = 0;
    private static final String countryCode = "NL";
    private static int countryCodeInt = 0;


    static {
        for (int i = 0; i < 4; i++) {
            bankCodeInt *= 100;
            bankCodeInt += bankCode.charAt(i) - 55;
        }
        for (int i = 0; i < 2; i++) {
            countryCodeInt *= 100;
            countryCodeInt += countryCode.charAt(i) - 55;
        }
    }

    public String generateIban() {
        int rnd = (int) (Math.random() * 1000000000);

        BigInteger preChecksum = new BigInteger(((bankCodeInt * 10000000000L) + rnd) + "" + countryCodeInt + "00");

        System.out.println(bankCodeInt);
        System.out.println(countryCodeInt);

        int checksum = 98 - preChecksum.mod(new BigInteger("97")).intValue();


        String rndStr = String.format("%010d", rnd);
        String checksumStr = String.format("%02d", checksum);

        return countryCode + checksumStr + bankCode + rndStr;
    }
}

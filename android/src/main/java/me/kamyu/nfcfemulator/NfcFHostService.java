package me.kamyu.nfcfemulator;

import android.nfc.cardemulation.HostNfcFService;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.RequiresApi;

public class NfcFHostService extends HostNfcFService {
    public static boolean isServiceStarted = false;

    @Override
    public void onCreate() {
        super.onCreate();
        isServiceStarted = true;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        isServiceStarted = false;
    }

    @Override
    public byte[] processNfcFPacket(byte[] commandPacket, Bundle extras) {
        return new byte[0];
    }

    @Override
    public void onDeactivated(int reason) {
    }
}
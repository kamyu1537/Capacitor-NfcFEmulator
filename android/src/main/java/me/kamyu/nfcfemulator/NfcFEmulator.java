package me.kamyu.nfcfemulator;

import android.app.Activity;
import android.content.ComponentName;
import android.nfc.NfcAdapter;
import android.nfc.cardemulation.NfcFCardEmulation;
import android.util.Log;

public class NfcFEmulator {
    private Activity activity;
    private ComponentName componentName;
    private NfcAdapter nfcAdapter;
    private NfcFCardEmulation nfcFCardEmulation;

    public void register(Activity activity) {
        this.activity = activity;
        componentName = new ComponentName(activity.getPackageName(), NfcFHostService.class.getName());
        nfcAdapter = NfcAdapter.getDefaultAdapter(activity.getApplicationContext());
        nfcFCardEmulation = NfcFCardEmulation.getInstance(nfcAdapter);
    }

    public void unregister() {
        this.disable();
        this.nfcAdapter = null;
        this.nfcFCardEmulation = null;
        this.activity = null;
    }

    public void enable() {
        if (activity == null) return;
        if (NfcFHostService.isServiceStarted) return;

        try {
            nfcFCardEmulation.enableService(this.activity, this.componentName);
            nfcAdapter.enableReaderMode(this.activity, tag -> Log.d("NfcFEmulator", "onTagDiscovered"), 256, null);
        } catch (Exception e) {
            Log.e("NfcFEmulator", String.valueOf(e));
        }
    }

    public void disable() {
        if (activity == null) return;
        if (!NfcFHostService.isServiceStarted) return;

        try {
            nfcFCardEmulation.disableService(this.activity);
            nfcAdapter.disableReaderMode(this.activity);
        } catch (Exception e) {
            Log.e("NfcFEmulator", String.valueOf(e));
        }
    }

    public String getNfcId() {
        return this.nfcFCardEmulation.getNfcid2ForService(this.componentName);
    }

    public boolean setNfcId(String nfcId) {
        if (!nfcId.matches("^[A-Fa-f0-9]{16}$")) return false;
        return this.nfcFCardEmulation.setNfcid2ForService(this.componentName, nfcId.toUpperCase());
    }
}

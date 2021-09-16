package me.kamyu.nfcfemulator;

import android.Manifest;
import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;
import com.getcapacitor.annotation.Permission;

@CapacitorPlugin(name = "NfcFEmulator", permissions={
        @Permission(strings = { Manifest.permission.NFC, Manifest.permission.BIND_NFC_SERVICE }, alias="nfc")
})
public class NfcFEmulatorPlugin extends Plugin {
    private final NfcFEmulator emulator = new NfcFEmulator();
    private boolean enabled = false;

    @Override
    public void load() {
        emulator.register(this.getActivity());
    }

    @Override
    public void handleOnResume() {
        if (enabled) {
            emulator.enable();
        }
    }

    @Override
    public void handleOnPause() {
        if (enabled) {
            emulator.disable();
        }
    }

    @Override
    public void handleOnDestroy() {
        emulator.unregister();
    }

    @PluginMethod
    public void enable(PluginCall call) {
        emulator.enable();
        enabled = true;
        call.resolve();
    }

    @PluginMethod
    public void disable(PluginCall call) {
        emulator.disable();
        enabled = false;
        call.resolve();
    }

    @PluginMethod
    public void setNfcId(PluginCall call) {
        String value = call.getString("nfcId", "");
        JSObject ret = new JSObject();
        ret.put("result", value != null && emulator.setNfcId(value));
        call.resolve(ret);
    }

    @PluginMethod
    public void getNfcId(PluginCall call) {
        JSObject ret = new JSObject();
        ret.put("nfcId", emulator.getNfcId());
        call.resolve(ret);
    }
}

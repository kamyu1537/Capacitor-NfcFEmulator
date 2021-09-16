import { WebPlugin } from '@capacitor/core';
export class NfcFEmulatorWeb extends WebPlugin {
    async disable() {
        return;
    }
    async enable() {
        return;
    }
    async getNfcId() {
        return { nfcId: '02FE000000000000' };
    }
    async setNfcId(options) {
        console.info("NfcFEmulator.setNfcId:", options);
        return { result: true };
    }
}
//# sourceMappingURL=web.js.map
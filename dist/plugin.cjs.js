'use strict';

Object.defineProperty(exports, '__esModule', { value: true });

var core = require('@capacitor/core');

const NfcFEmulator = core.registerPlugin('NfcFEmulator', {
    web: () => Promise.resolve().then(function () { return web; }).then(m => new m.NfcFEmulatorWeb()),
});

class NfcFEmulatorWeb extends core.WebPlugin {
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

var web = /*#__PURE__*/Object.freeze({
    __proto__: null,
    NfcFEmulatorWeb: NfcFEmulatorWeb
});

exports.NfcFEmulator = NfcFEmulator;
//# sourceMappingURL=plugin.cjs.js.map

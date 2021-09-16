import { registerPlugin } from '@capacitor/core';
const NfcFEmulator = registerPlugin('NfcFEmulator', {
    web: () => import('./web').then(m => new m.NfcFEmulatorWeb()),
});
export * from './definitions';
export { NfcFEmulator };
//# sourceMappingURL=index.js.map
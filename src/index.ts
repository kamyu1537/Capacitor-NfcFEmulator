import { registerPlugin } from '@capacitor/core';

import type { NfcFEmulatorPlugin } from './definitions';

const NfcFEmulator = registerPlugin<NfcFEmulatorPlugin>('NfcFEmulator', {
  web: () => import('./web').then(m => new m.NfcFEmulatorWeb()),
});

export * from './definitions';
export { NfcFEmulator };

import { WebPlugin } from '@capacitor/core';

import type { NfcFEmulatorPlugin } from './definitions';

export class NfcFEmulatorWeb extends WebPlugin implements NfcFEmulatorPlugin {
  async disable(): Promise<void> {
    return;
  }

  async enable(): Promise<void> {
    return;
  }

  async getNfcId(): Promise<{ nfcId: string }> {
    return { nfcId: '02FE000000000000' };
  }

  async setNfcId(options: { nfcId: string }): Promise<{ result: boolean }> {
    console.info("NfcFEmulator.setNfcId:", options);
    return { result: true };
  }
}

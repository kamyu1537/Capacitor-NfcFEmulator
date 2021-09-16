import { WebPlugin } from '@capacitor/core';

import type { NfcFEmulatorPlugin } from './definitions';

export class NfcFEmulatorWeb extends WebPlugin implements NfcFEmulatorPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}

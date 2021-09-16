import { WebPlugin } from '@capacitor/core';
import type { NfcFEmulatorPlugin } from './definitions';
export declare class NfcFEmulatorWeb extends WebPlugin implements NfcFEmulatorPlugin {
    disable(): Promise<void>;
    enable(): Promise<void>;
    getNfcId(): Promise<{
        nfcId: string;
    }>;
    setNfcId(options: {
        nfcId: string;
    }): Promise<{
        result: boolean;
    }>;
}

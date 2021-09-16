export interface NfcFEmulatorPlugin {
  enable(): Promise<void>;
  disable(): Promise<void>;

  getNfcId(): Promise<{ nfcId: string }>;
  setNfcId(options: { nfcId: string }): Promise<{ result: boolean }>;
}

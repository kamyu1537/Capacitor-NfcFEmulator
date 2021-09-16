export interface NfcFEmulatorPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}

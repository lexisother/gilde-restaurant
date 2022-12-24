// Simple wrapper around LocalStorage with typing and error handling.
// Cleanest API you've seen, bub.
class LocalStorage {
  public get<T>(key: string, defaultValue: string | null = null): T {
    let value = localStorage.getItem(key);

    if (value != null) {
      try {
        value = JSON.parse(value);
      } catch (_e) {
        value = defaultValue;
      }
    } else {
      value = defaultValue;
    }

    return value as unknown as T;
  }

  public set(key: string, value: any): void {
    localStorage.setItem(key, JSON.stringify(value));
  }

  public remove(key: string): void {
    localStorage.removeItem(key);
  }

  public clear(): void {
    localStorage.clear();
  }
}

export const Storage = new LocalStorage();
